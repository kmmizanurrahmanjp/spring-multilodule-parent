package xyz.mizan.multimodule.comon.util;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ErrorResponse {
	
	private Integer total;
	private Object data;
	private Boolean success;
	private String message;
	private List<String> details;
	
	
	//setter and getter
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	//methods
	public ErrorResponse getResponse(Integer total, Object data, Boolean success, String message, List<String> details) {
		this.setTotal(total);
		this.setData(data);
		this.setSuccess(success);
		this.setMessage(message);
		this.setDetails(details);
		return this;
	}
}
