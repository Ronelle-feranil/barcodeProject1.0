package xyz.mynt.myntbarcode.exception;

/**
 * Exception Class for BarCode
 * 
 * @author karl.cubilo
 *
 */
public class BarcodeException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6885493951170551015L;

	public BarcodeException() {
		super();
	}

	public BarcodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BarcodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BarcodeException(String message) {
		super(message);
	}

	public BarcodeException(Throwable cause) {
		super(cause);
	}

}
