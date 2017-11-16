package xyz.mynt.myntbarcode.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.domain.SevenElevenResponse;
import xyz.mynt.myntbarcode.domain.ValidateConfirmRequest;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.entity.Transactions;
import xyz.mynt.myntbarcode.enums.Status;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.repository.BarcodeUsageHistoryRepository;
import xyz.mynt.myntbarcode.repository.TransactionRepository;
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

	@Autowired
	private TransactionRepository transactionRepository;

	public ResponseEntity<BarcodeResponse<?>> validate(ValidateConfirmRequest validateConfirmRequest) {

		return validateSevenEleven(validateConfirmRequest);
	}

	public ResponseEntity<BarcodeResponse<?>> confirm(ValidateConfirmRequest validateConfirmRequest) {
		return confirmSevenEleven(validateConfirmRequest);
	}

	private ResponseEntity<BarcodeResponse<?>> validateSevenEleven(ValidateConfirmRequest validateConfirmRequest) {

		String token = SevenElevenUtils.createToken(validateConfirmRequest.getType(), SevenElevenUtils.MERCHANT_ID,
				validateConfirmRequest.getMerchantRef(), SevenElevenUtils.TRANSACTION_KEY);

		if (validateConfirmRequest.getToken().equals(token)) {

			int i = (barcodeUsageHistoryRepository
					.isSevenElevenBarcodeActive(validateConfirmRequest.getPaymentDetails()));
			BarcodeResponse<SevenElevenResponse> barcodeResponse = new BarcodeResponse<>();

			SevenElevenResponse sevenElevenResponse = new SevenElevenResponse();
			sevenElevenResponse.setAmount(validateConfirmRequest.getAmount());
			sevenElevenResponse.setMerchanteRef(validateConfirmRequest.getMerchantRef());
			sevenElevenResponse.setToken(token);
			sevenElevenResponse.setType(SevenElevenUtils.VALIDATE);
			sevenElevenResponse.setResponseCode(SevenElevenUtils.SUCCESS);

			if (i == Status.ACTIVE.getValue()) {

				sevenElevenResponse.setResponseDesc("Barcode Valid");
			} else if (i == Status.INACTIVE.getValue()) {

				sevenElevenResponse.setResponseDesc("Barcode Invalid");
			}

			barcodeResponse.setData(sevenElevenResponse);
			ResponseEntity<BarcodeResponse<?>> responseEntity = new ResponseEntity<>(barcodeResponse, HttpStatus.OK);

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

			ResponseEntity<BarcodeResponse<?>> responseEntity = new ResponseEntity<>(barcodeResponse, HttpStatus.OK);

			return responseEntity;
		}

	}

	private ResponseEntity<BarcodeResponse<?>> confirmSevenEleven(ValidateConfirmRequest validateConfirmRequest) {

		String token = SevenElevenUtils.createToken(validateConfirmRequest.getType(), SevenElevenUtils.MERCHANT_ID,
				validateConfirmRequest.getMerchantRef(), SevenElevenUtils.TRANSACTION_KEY);
		ResponseEntity<BarcodeResponse<?>> responseEntity = null;
		try {
			if (validateConfirmRequest.getToken().equals(token)) {

				JSONObject paymentDetails = new JSONObject(validateConfirmRequest.getPaymentDetails());
				String barcodeString = paymentDetails.getString("payID");

				Transactions trans;
				BarcodeUsageHistory barcodeHistory;

				trans = transactionRepository.findByBarcodeString(barcodeString);
				barcodeHistory = barcodeUsageHistoryRepository.findByBarcodeString(barcodeString);

				if (Status.ACTIVE.equals(trans.getStatus()) && Status.ACTIVE.equals(barcodeHistory.getStatus())) {
					
//					TODO: call ESB endponint for gcash core. if the call succeeded, then we proceed on saving records.
					trans.setStatus(Status.PAID);
					barcodeHistory.setStatus(Status.PAID);

					transactionRepository.save(trans);
					barcodeUsageHistoryRepository.save(barcodeHistory);
				}
				BarcodeResponse<SevenElevenResponse> barcodeResponse = new BarcodeResponse<>();
				SevenElevenResponse sevenElevenResponse = new SevenElevenResponse();
				sevenElevenResponse.setAmount(validateConfirmRequest.getAmount());
				sevenElevenResponse.setMerchanteRef(validateConfirmRequest.getMerchantRef());
				sevenElevenResponse.setToken(token);
				sevenElevenResponse.setType(SevenElevenUtils.CONFIRM);
				sevenElevenResponse.setResponseCode(SevenElevenUtils.SUCCESS);
				sevenElevenResponse.setResponseDesc("Confirmed");

				barcodeResponse.setData(sevenElevenResponse);
				responseEntity = new ResponseEntity<>(barcodeResponse, HttpStatus.OK);

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

				responseEntity = new ResponseEntity<>(barcodeResponse, HttpStatus.OK);
			}
		} catch (Exception e) {

			throw new BarcodeException(e.getLocalizedMessage());
		}

		return responseEntity;
	}

}
