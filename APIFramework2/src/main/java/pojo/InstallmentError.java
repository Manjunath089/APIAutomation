package pojo;

public class InstallmentError {
	
	public static int errorCode;
    public static String errorMessage;
    public static String isValidationError;
   
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getIsValidationError() {
        return isValidationError;
    }
    public void setIsValidationError(String isValidationError) {
        this.isValidationError = isValidationError;
    }
}


