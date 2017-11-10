package xyz.mynt.myntbarcode.enums;

public enum Status {
	
	INACTIVE(0), ACTIVE(1), UNPAID(2), PAID(3);
	
	  private int value;

	    public Integer getValue() {
	        return value;
	    }

	    private Status(int value) {
	        this.value = value;
	    }
}
