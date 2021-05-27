package xyz.mizan.multimodule.report.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ReportViewer {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ReportViewer.class);
	
	@Autowired
	DataSource dataSource;

	@Autowired
	ReportExporter reportExporter;
	
	@Autowired
	ReportResponse reportResponse;
	
	public void getPDFView(JasperReport jasperReport, Map<String, Object> parameters, HttpServletRequest request,
			HttpServletResponse response, String id) throws JRException, SQLException, IOException {

		// report response
		reportResponse.getPDFReportResponse(request, response, id);

		// Fill the report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());

		// report exporter
		reportExporter.getPDFReportExport(jasperPrint, response.getOutputStream());

	}
	
	

}
