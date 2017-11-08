	package xyz.mynt.myntbarcode.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.mynt.myntbarcode.domain.BarcodeRequest;
import xyz.mynt.myntbarcode.domain.BarcodeResponse;
import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;
import xyz.mynt.myntbarcode.exception.BarcodeException;
import xyz.mynt.myntbarcode.service.BarcodeService;

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
	
}
