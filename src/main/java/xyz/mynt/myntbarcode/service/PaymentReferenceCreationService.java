package xyz.mynt.myntbarcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.mynt.myntbarcode.domain.PaymentReferenceCreationRequest;
import xyz.mynt.myntbarcode.entity.AccountIdentifier;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.entity.Transactions;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.repository.AccountIdentifierRepository;
import xyz.mynt.myntbarcode.repository.BarcodeUsageHistoryRepository;
import xyz.mynt.myntbarcode.repository.TransactionRepository;

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
	public String mapSecondaryBarcode(PaymentReferenceCreationRequest paymentReferenceCreationRequest) {
		/*
		 TODO:
		 	- validate of transaction is existing via barcodeString
		 	- validate if barcode usage repository is existing via barcodeString
		 	- update tables feeding secondary barcode from ESB payload (payID)
		 */
		
		Transactions trans;
		BarcodeUsageHistory barcodeHistory;
		
		
		try {
			trans = transactionRepository.findByBarcodeString(paymentReferenceCreationRequest.getBarcodeString());
			barcodeHistory = barcodeUsageHistoryRepository.findByBarcodeString(paymentReferenceCreationRequest.getBarcodeString());
			
			if(trans != null  && barcodeHistory != null) {
				
				trans.setSecondaryBarcodeString(paymentReferenceCreationRequest.getPayID());
				transactionRepository.save(trans);
				
				barcodeHistory.setSecondaryBarcodeString(paymentReferenceCreationRequest.getPayID());
				barcodeUsageHistoryRepository.save(barcodeHistory);
				
			}else {
				throw new BarcodeException("Unable to retrieve transaction data.");
			}
			
		} catch (Exception e) {
			// TODO: log exception
			throw new BarcodeException(e.getLocalizedMessage());
		}
		
		return trans.getSecondaryBarcodeString();
	}
}
