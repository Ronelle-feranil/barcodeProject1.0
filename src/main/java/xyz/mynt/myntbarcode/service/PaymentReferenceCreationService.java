package xyz.mynt.myntbarcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.domain.PaymentReferenceCreationRequest;
import xyz.mynt.myntbarcode.domain.SevenElevenResponse;
import xyz.mynt.myntbarcode.entity.AccountIdentifier;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.entity.Transactions;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.repository.AccountIdentifierRepository;
import xyz.mynt.myntbarcode.repository.BarcodeUsageHistoryRepository;
import xyz.mynt.myntbarcode.repository.TransactionRepository;
import xyz.mynt.myntbarcode.utils.SevenElevenUtils;

@Service
public class PaymentReferenceCreationService {

	@Autowired
	private BarcodeUsageHistoryRepository barcodeUsageHistoryRepository;
	
	
	@Autowired
	private TransactionRepository transactionRepository;

	/**
	 SAVE
	 	BarcodeUsageHistory barcodeUsageHistory = new BarcodeUsageHistory();
		barcodeUsageHistory.setAccountIdentifierID(accountIdentifier);
		barcodeUsageHistory.setOtpString(otp);
		barcodeUsageHistory.setBarcodeString("barcode");
		barcodeUsageHistory.setStatus(true);
		barcodeUsageHistoryRepository.save(barcodeUsageHistory);
	 **/
	
	@Transactional
	public ResponseEntity<BarcodeResponse<?>> mapSecondaryBarcode(PaymentReferenceCreationRequest paymentReferenceCreationRequest) {
		/*
		 TODO:
		 	- validate of transaction is existing via barcodeString
		 	- validate if barcode usage repository is existing via barcodeString
		 	- update tables feeding secondary barcode from ESB payload (payID)
		 */
		BarcodeResponse<PaymentReferenceCreationRequest> response = new BarcodeResponse<PaymentReferenceCreationRequest>();
		Transactions trans;
		BarcodeUsageHistory barcodeHistory;
		
		response.setMessage("message");
		response.setNamespace("namespace");
		response.setResultCode("200");
		response.setStatus(true);
		response.setData(paymentReferenceCreationRequest);
		ResponseEntity<BarcodeResponse<?>> responseEntity = null;
		
		try {
			trans = transactionRepository.findByBarcodeString(paymentReferenceCreationRequest.getBarcodeString());
			barcodeHistory = barcodeUsageHistoryRepository.findByBarcodeString(paymentReferenceCreationRequest.getBarcodeString());
			
			if(trans != null  && barcodeHistory != null) {
				
				trans.setSecondaryBarcodeString(paymentReferenceCreationRequest.getPayID());
				transactionRepository.save(trans);
				
				barcodeHistory.setSecondaryBarcodeString(paymentReferenceCreationRequest.getPayID());
				barcodeUsageHistoryRepository.save(barcodeHistory);
				
				 responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
				
			}else {
				throw new BarcodeException("Unable to retrieve transaction data.");
			}
			
		} catch (Exception e) {
			// TODO: log exception
			throw new BarcodeException(e.getLocalizedMessage());
		}
		
		
		
		return responseEntity;
	}
}
