package xyz.mynt.myntbarcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.domain.SevenElevenResponse;
import xyz.mynt.myntbarcode.domain.ValidateConfirmRequest;
import xyz.mynt.myntbarcode.enums.Status;
import xyz.mynt.myntbarcode.repository.BarcodeUsageHistoryRepository;
import xyz.mynt.myntbarcode.utils.SevenElevenUtils;

/**
 * 
 * Service for CashIn
 * 
 * @author karl.cubilo
 *
 */
@Service
public class CashinService {

	@Autowired
	private BarcodeUsageHistoryRepository barcodeUsageHistoryRepository;

	public ResponseEntity<BarcodeResponse<?>> validate(ValidateConfirmRequest validateConfirmRequest) {


		return validateSevenEleven(validateConfirmRequest);
	}

	private ResponseEntity<BarcodeResponse<?>>validateSevenEleven(ValidateConfirmRequest validateConfirmRequest) {
		
		String token = SevenElevenUtils.createToken(validateConfirmRequest.getType(), SevenElevenUtils.MERCHANT_ID, validateConfirmRequest.getMerchantRef(), SevenElevenUtils.TRANSACTION_KEY);
		
		if(validateConfirmRequest.getToken().equals(token)) {
			
			int i = (barcodeUsageHistoryRepository.isSevenElevenBarcodeActive(validateConfirmRequest.getPaymentDetails()));
			BarcodeResponse<SevenElevenResponse> barcodeResponse = new BarcodeResponse<>();
			
			SevenElevenResponse sevenElevenResponse = new SevenElevenResponse();
			sevenElevenResponse.setAmount(validateConfirmRequest.getAmount());
			sevenElevenResponse.setMerchanteRef(validateConfirmRequest.getMerchantRef());
			sevenElevenResponse.setToken(token);
			sevenElevenResponse.setType(SevenElevenUtils.VALIDATE);
			sevenElevenResponse.setResponseCode(SevenElevenUtils.SUCCESS);
			
			if(i == Status.ACTIVE.getValue()) {
				
				sevenElevenResponse.setResponseDesc("Barcode Valid");
			} else if (i == Status.INACTIVE.getValue()) {
				
				sevenElevenResponse.setResponseDesc("Barcode Invalid");
			}
			
			barcodeResponse.setData(sevenElevenResponse);
			ResponseEntity<BarcodeResponse<?>> responseEntity = new ResponseEntity<>(barcodeResponse,HttpStatus.OK);
			
			return responseEntity;
		} else {
			
			BarcodeResponse<SevenElevenResponse> barcodeResponse = new BarcodeResponse<>();
			
			SevenElevenResponse sevenElevenResponse = new SevenElevenResponse();
			sevenElevenResponse.setResponseCode(SevenElevenUtils.DECLINED);
			sevenElevenResponse.setResponseDesc("Invalid Token");
			sevenElevenResponse.setAuthCode("");
			sevenElevenResponse.setAmount(validateConfirmRequest.getAmount());
			sevenElevenResponse.setMerchanteRef(validateConfirmRequest.getMerchantRef());
			sevenElevenResponse.setToken(token);
			sevenElevenResponse.setType(SevenElevenUtils.VALIDATE);
			
			barcodeResponse.setData(sevenElevenResponse);
			
			ResponseEntity<BarcodeResponse<?>> responseEntity = new ResponseEntity<>(barcodeResponse,HttpStatus.OK);
			
			return responseEntity;
		}
		
	}

}
