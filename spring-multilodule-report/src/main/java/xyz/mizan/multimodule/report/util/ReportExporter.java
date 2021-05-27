package xyz.mizan.multimodule.report.util;

import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ReportExporter {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ReportExporter.class);
	
	public void getPDFReportExport(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {

		JRPdfExporter exporter = new JRPdfExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);

		SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
		exportConfig.setMetadataAuthor("MIZAN");
		exportConfig.setEncrypted(true);
		exportConfig.setAllowedPermissionsHint("PRINTING");

		exporter.setConfiguration(reportConfig);
		exporter.setConfiguration(exportConfig);

		exporter.exportReport();
	}
	
	/*public void getXLSReportExport(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
	
	    JRXlsxExporter exporter = new JRXlsxExporter();
	    
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
		 
		exporter.exportReport();
	}*/
	
	
	/*public void getCSVReportExport(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
		
		JRCsvExporter exporter = new JRCsvExporter();
	    
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput((WriterExporterOutput) outputStream);
		 
		exporter.exportReport();
	}*/
	
	
	/*public void getHTMLReportExport(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
		
		HtmlExporter exporter = new HtmlExporter();
	    
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput((HtmlExporterOutput) outputStream);
		 
		exporter.exportReport();
	}*/
}
