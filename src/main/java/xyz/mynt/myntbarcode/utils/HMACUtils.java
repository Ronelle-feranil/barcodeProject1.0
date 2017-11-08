package xyz.mynt.myntbarcode.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Util for HMAC Security
 * 
 * @author karl.cubilo
 *
 */

public class HMACUtils {

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	private static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();

		try {
			
			for (byte b : bytes) {
				formatter.format("%02x", b);
			}
		} catch(Exception e) {
			
			//todo log the exception and throw
		} finally {
			
			formatter.close();
		}

		return formatter.toString();
	}

	public static String calculateRFC2104HMAC(String data, String key)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
		
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		return toHexString(mac.doFinal(data.getBytes()));
	}

}
