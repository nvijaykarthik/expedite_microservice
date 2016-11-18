package in.expedite.util;

public class GeneralSuccessResponse {

	private Integer responseCode;
	private String response;
	

	public GeneralSuccessResponse(Integer responseCode, String response) {
		super();
		this.responseCode = responseCode;
		this.response = response;
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "GeneralSuccessResponse [responseCode=" + responseCode + ", response=" + response + "]";
	}
		
}
