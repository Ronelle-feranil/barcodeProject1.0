package xyz.mynt.myntbarcode.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SevenElevenUtils {
	
	public final static String TRANSACTION_KEY = "{6f32e256c3c997d62f95216778e38c06b07bf37400c00fb1f3355e1fc6d4e228}";
	public final static String MERCHANT_ID = "test_app_gcash";
	public final static String SUCCESS = "SUCCESS";
	public final static String DECLINED = "DECLINED";
	public final static String VALIDATE = "VALIDATE";
	public final static String CONFIRM = "CONFIRM";
	public final static String VALID = "VALID";
	public final static String INVALID = "INVALID";
	
	public static String createToken(String type, String merchantID, String merchantRef, String transactionKey) {
		
		String token = DigestUtils.sha1Hex(type.concat(merchantID).concat(merchantRef).concat(transactionKey));
		
		return token;
	}

}
