package xyz.mizan.multimodule.report.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ReportResponse {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ReportResponse.class);
	
	public void getPDFReportResponse(HttpServletRequest request, HttpServletResponse response, String viewId) {
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=" + viewId + ".pdf");
		response.setHeader("responseURL", "" + request.getRequestURL());
	}
	
	/*public void getXLSReportResponse(HttpServletRequest request, HttpServletResponse response, String viewId) {
		response.setContentType("application/xls");
		response.setHeader("Content-disposition", "inline; filename=" +viewId+ ".xls");
		response.setHeader("responseURL", ""+request.getRequestURL());
	}*/
	
	/*public void getCSVReportResponse(HttpServletRequest request, HttpServletResponse response, String viewId) {
		response.setContentType("application/csv");
		response.setHeader("Content-disposition", "inline; filename=" +viewId+ ".csv");
		response.setHeader("responseURL", ""+request.getRequestURL());
	}*/
	
	
	/*public void getHTMLReportResponse(HttpServletRequest request, HttpServletResponse response, String viewId) {
		response.setContentType("application/html");
		response.setHeader("Content-disposition", "inline; filename=" +viewId+ ".html");
		response.setHeader("responseURL", ""+request.getRequestURL());
	}*/
}
