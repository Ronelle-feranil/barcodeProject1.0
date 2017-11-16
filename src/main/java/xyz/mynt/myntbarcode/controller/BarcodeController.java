package xyz.mynt.myntbarcode.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.mynt.myntbarcode.domain.BarcodeRequest;
import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.domain.PaymentReferenceCreationRequest;
import xyz.mynt.myntbarcode.domain.ValidateConfirmRequest;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.service.BarcodeService;
import xyz.mynt.myntbarcode.service.CashinService;
import xyz.mynt.myntbarcode.service.PaymentReferenceCreationService;

/**
 * Entry point for Barcode
 * 
 * @author karl.cubilo	
 *
 */

@RestController
public class BarcodeController {

	@Autowired
	private BarcodeService barCodeService;
	
	@Autowired
	private PaymentReferenceCreationService paymentReferenceCreationService;
	
	@Autowired
	private CashinService cashinService;
	
	
	
	/**
	 * Contoller for Barcode Generation
	 * 
	 * @param barcodeRequest
	 * @return ResponseEntity<BarcodeUsageHistory>
	 * @throws BarcodeException
	 */
	@RequestMapping(value="/generate-barcode", method=RequestMethod.POST)
	public ResponseEntity<BarcodeResponse<BarcodeUsageHistory>> generateBarCode(@Valid @RequestBody BarcodeRequest barcodeRequest) throws BarcodeException{
		
		return barCodeService.generateBarcode(barcodeRequest);
	}
	
	@RequestMapping(value="/payment-reference-creation", method=RequestMethod.POST)
	public ResponseEntity<BarcodeResponse<?>> paymentReferenceCreation(@RequestBody PaymentReferenceCreationRequest paymentReferenceCreationRequest){
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PaymentReferenceCreationRequest>> violations = validator.validate(paymentReferenceCreationRequest);
				
		if (!(violations.toString().length() < 3)) {
			throw new BarcodeException("Exception occured. Please see logs for details.");
		} 
		
		return paymentReferenceCreationService.mapSecondaryBarcode(paymentReferenceCreationRequest);
	}
	
	/**
	 * 
	 * Controller for Validate 
	 * @param barcodeRequest
	 * @return ResponseEntity<?>
	 * @throws BarcodeException
	 */
	@RequestMapping(value="validate", method=RequestMethod.POST)
	public ResponseEntity<BarcodeResponse<?>> validate(@RequestBody ValidateConfirmRequest validateConfirmRequest) throws BarcodeException {
		
		return cashinService.validate(validateConfirmRequest);
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public ResponseEntity<BarcodeResponse<?>> confirm(@RequestBody ValidateConfirmRequest validateConfirmRequest){
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ValidateConfirmRequest>> violations = validator.validate(validateConfirmRequest);
				
		if (!(violations.toString().length() < 3)) {
			throw new BarcodeException("Exception occured. Please see logs for details.");
		} 
		
		
		return cashinService.confirm(validateConfirmRequest);
	}
	
}
