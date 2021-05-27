package xyz.mizan.multimodule.comon.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ApiResponse {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ApiResponse.class);
	
	public Map<String, Object> getSuccessMultiData(List<?> list) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", list);
		response.put("total", list.size());
		response.put("message", "Data Found");
		return response;
	}

	public Map<String, Object> getSuccessSingleData(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", data);
		response.put("total", 1);
		response.put("message", "Data Found");
		return response;
	}

	public Map<String, Object> getFailed(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", false);
		response.put("data", null);
		response.put("total", 0);
		response.put("message", "Data Not Found");
		return response;
	}

	public Map<String, Object> insertSuccess(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", data);
		response.put("total", 1);
		response.put("message", "Insert Successfull");
		return response;
	}

	public Map<String, Object> insertFailed(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", false);
		response.put("data", null);
		response.put("total", 0);
		response.put("message", "Insert Failed");
		return response;
	}

	public Map<String, Object> updateSuccess(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", data);
		response.put("total", 1);
		response.put("message", "Update Successfull");
		return response;
	}

	public Map<String, Object> updateFailed(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", false);
		response.put("data", data);
		response.put("total", 1);
		response.put("message", "Update Failed");
		return response;
	}

	public Map<String, Object> deleteSuccess(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", data);
		response.put("total", 0);
		response.put("message", "Delete Successfull");
		return response;
	}

	public Map<String, Object> deleteFailed(Object data) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", false);
		response.put("data", data);
		response.put("total", 1);
		response.put("message", "Delete Failed");
		return response;
	}

	// Upload response success
	public Map<String, Object> uploadSuccess(String id, String name, String type) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("id", id);
		response.put("name", name);
		response.put("type", type);
		response.put("message", "Upload Successful");
		return response;
	}

	// Upload response failed
	public Map<String, Object> uploadFailed(String name, String type) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", false);
		response.put("id", null);
		response.put("name", name);
		response.put("type", type);
		response.put("message", "Upload Failed");
		return response;
	}
}
