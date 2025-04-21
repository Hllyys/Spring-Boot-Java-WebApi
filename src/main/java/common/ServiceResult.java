package common;

public class ServiceResult<T> {
  
	private T data;
	private boolean success= true;
	private String errorMessage;
	public ServiceResult(T data, boolean success, String errorMessage) {
		this.data = data;
		this.success = success;
		this.errorMessage = errorMessage;
	}
	public ServiceResult() {
		
	}
	 public boolean isSuccess() {
	        return success;
	    }

	    public void setSuccess(boolean success) {
	        this.success = success;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage;
	    }

	    public T getData() {
	        return data;
	    }

	    public void setData(T data) {
	        this.data = data;
	    }
	
	
}
