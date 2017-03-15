package com.model;

public class ResponseSuccess {
	public ResponseSuccess(boolean success, String accountIdentifier) {
        super();
        this.success = success;
        this.accountIdentifier = accountIdentifier;
    }
    private boolean success;
    private String accountIdentifier;
    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getAccountIdentifier() {
        return accountIdentifier;
    }
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

}
