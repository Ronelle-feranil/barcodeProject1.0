package xyz.mynt.myntbarcode.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.mynt.myntbarcode.domain.BarcodeRequest;
import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.entity.AccountIdentifier;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.entity.OTP;
import xyz.mynt.myntbarcode.entity.Transactions;
import xyz.mynt.myntbarcode.enums.Status;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.repository.AccountIdentifierRepository;
import xyz.mynt.myntbarcode.repository.BarcodeUsageHistoryRepository;
import xyz.mynt.myntbarcode.repository.OtpRepository;
import xyz.mynt.myntbarcode.repository.TransactionsRepository;
import xyz.mynt.myntbarcode.utils.GeneratorUtils;
import xyz.mynt.myntbarcode.utils.Utils;

/**
 * 
 * Service for Barcode
 * 
 * @author karl.cubilo
 *
 */

@Service
public class BarcodeService {

	@Autowired
	private AccountIdentifierRepository accountIdentifierRepository;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private BarcodeUsageHistoryRepository barcodeUsageHistoryRepository;
	
	@Autowired
	private TransactionsRepository transactionRepository;

	/**
	 * Generates the barcode and persist the necessary details
	 * 
	 * @param barcodeRequest
	 * @return ResponseEntity<?>
	 * @throws BarcodeException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@Transactional
	public ResponseEntity<BarcodeResponse<BarcodeUsageHistory>> generateBarcode(BarcodeRequest barcodeRequest) throws BarcodeException{
		
		BarcodeResponse<BarcodeUsageHistory> barcodeResponse = new BarcodeResponse<BarcodeUsageHistory>();
		AccountIdentifier accountIdentifier = generateAccountIdentifier(barcodeRequest);
		OTP otp = generateOTP(accountIdentifier);
		BarcodeUsageHistory barcodeUsageHistory = 
				generateBarcodeUsage(accountIdentifier.getAccountIdentifier(), otp.getOtpString(), barcodeRequest.getGcashWalletName());
		
		Transactions transaction = persistTransaction(barcodeUsageHistory, barcodeRequest);
		
		barcodeResponse.setMessage("message");
		barcodeResponse.setNamespace("namespace");
		barcodeResponse.setResultCode("200");
		barcodeResponse.setStatus(true);
		barcodeResponse.setTransid(transaction.getGcashTransID());
		barcodeResponse.setData(barcodeUsageHistory);
		ResponseEntity<BarcodeResponse<BarcodeUsageHistory>> responseEntity = new ResponseEntity<>(barcodeResponse, HttpStatus.OK);
		
		return responseEntity;
	}
	
	/**
	 * Generate the AccountIdentifier and map the request
	 * 
	 * @param barcodeRequest
	 * @return AccountIdentifier
	 */
	private AccountIdentifier generateAccountIdentifier(BarcodeRequest barcodeRequest) {
		
		
		AccountIdentifier accountIdentifier = accountIdentifierRepository
				.findByGcashWalletAndStatus(barcodeRequest.getGcashWalletName(), Status.ACTIVE);
		
		if(accountIdentifier == null) {
			
			long ai = 0L;
			boolean exist =true;
			long count = 0;
			
			while(exist) {

				ai = GeneratorUtils.generateRandomNumber(1000000000, 9999999999L, new Random());
				count = accountIdentifierRepository.countByAccountIdentifierAndStatus(ai, Status.ACTIVE);
				
				if(count==0) {
					
					
					accountIdentifier = new AccountIdentifier();
					accountIdentifier.setAccountIdentifier(ai);
					accountIdentifier.setClientAccountIdentifier(barcodeRequest.getClientIdentifier());
					accountIdentifier.setExtraDetails("extraDetails");
					accountIdentifier.setGcashWallet(barcodeRequest.getGcashWalletName());
					accountIdentifier.setHashedPin(barcodeRequest.getPin());
					accountIdentifier.setStatus(Status.ACTIVE);
					accountIdentifier = accountIdentifierRepository.save(accountIdentifier);
					exist= false; 
					break;
				}
			}	
		}
		
		return accountIdentifier;
	}
	
	/**
	 * Generate the OTP and map it to AccountIdentifier
	 * 
	 * @param accountIdentifier
	 * @return OTP
	 */
	private OTP generateOTP(AccountIdentifier accountIdentifier) {
		
		int otpString = 0;
		long count = 0;
		boolean exist = true;

		OTP otp = new OTP();
		
		while(exist) {
			
			otpString = (int) GeneratorUtils.generateRandomNumber(100000, 999999L, new Random());
			count = barcodeUsageHistoryRepository.countActiveBarcodeUsage(accountIdentifier.getAccountIdentifier(), otpString);
			
			if(count == 0) {
				
				otpRepository.invalidatePreviousOTP(accountIdentifier.getAccountIdentifier());
				
				otp.setAccountIdentifier(accountIdentifier);
				otp.setOtpString(otpString);	
				otp.setStatus(Status.ACTIVE);
				otp = otpRepository.save(otp);
				exist = false;
				break;
			}
		}
		return otp;
	}
	
	/**
	 * Persist the BarcodeUsageHistory
	 * 
	 * @param accountIdentifier
	 * @param otp
	 * @return BarcodeUsageHistory
	 */
	private BarcodeUsageHistory generateBarcodeUsage(long accountIdentifier, int otp, String gcashWallet) {
		
		String cgcp = getCGCP();
		
		BarcodeUsageHistory barcodeUsageHistory = new BarcodeUsageHistory();
		barcodeUsageHistory.setAccountIdentifierID(accountIdentifier);
		barcodeUsageHistory.setOtpString(otp);
		barcodeUsageHistory.setBarcodeString(cgcp.concat(String.valueOf(accountIdentifier)).concat(String.valueOf(otp)));
		barcodeUsageHistory.setSubscriberGcashWallet(gcashWallet);
		barcodeUsageHistory.setStatus(Status.ACTIVE);
		barcodeUsageHistory = barcodeUsageHistoryRepository.save(barcodeUsageHistory);
		
		return barcodeUsageHistory;
	}
	
	/**
	 * Get the preconfigured CGCP 
	 * 
	 * @return CGCP
	 */
	private String getCGCP() {
		
		//get preconfigured on a server
		String cgcp = "123456";
		
		return cgcp;
	}
	
	private Transactions persistTransaction(BarcodeUsageHistory barcodeUsageHistory, BarcodeRequest barcodeRequest) {
		
		Transactions transaction =  new Transactions();
		transaction.setBarcodeString(barcodeUsageHistory.getBarcodeString());
		transaction.setSubscriberGcashWallet(barcodeRequest.getGcashWalletName());
		transaction.setGcashTransID("testID 123456");
		
		transaction = transactionRepository.save(transaction);
		return transaction;
	}
	
	public boolean validateHmacSignature(String hmacSignature, BarcodeRequest barcodeRequest) {
		
		boolean isHmac = false;
		
		long timestamp = Utils.roundToNearest5thMinute(Utils.generateUnixTimeStamp());
		
//		String hmacRequest = HMACUtils.calculateRFC2104HMAC(data, key);
		
		if(hmacSignature.equals(hmacSignature))
			isHmac = true;	
		
		return isHmac;
	}
	
}
