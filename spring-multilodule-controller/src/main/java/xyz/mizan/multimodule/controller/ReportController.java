package xyz.mizan.multimodule.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import xyz.mizan.multimodule.report.Blank_A4_Report;
import xyz.mizan.multimodule.report.util.ReportSources;
import xyz.mizan.multimodule.report.util.ReportViewer;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/report")
public class ReportController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	Blank_A4_Report report;
	
	@Autowired
	ReportSources reportSources;

	@Autowired
	ReportViewer reportViewer;

	@GetMapping("/pdf")
	public void generatePDFReport(HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException, SQLException {

		//Image image = reportSources.getReportImage();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("TITLE", "Test subreport with spring boot multimodule project");
		parameters.put("HEADER_TEXT", "Md Mizanur Rahman");
		parameters.put("LOGO", reportSources.getImage(reportSources.LOGO));
		parameters.put("HEADER_SR", reportSources.getCompileDir("HEADER"));
		parameters.put("BLANK_A4_1_SR", reportSources.getCompileDir("BLANK_A4_1"));
		String id = "report";// report id

		reportViewer.getPDFView(report.compileBlankA4Report(), parameters, request, response, id);

	}
}
