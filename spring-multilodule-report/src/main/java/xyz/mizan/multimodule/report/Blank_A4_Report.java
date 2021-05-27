package xyz.mizan.multimodule.report;

import java.io.File;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;
import xyz.mizan.multimodule.report.util.ReportSources;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class Blank_A4_Report {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(Blank_A4_Report.class);
	
	@Autowired
	ReportSources reportSources;
	
	public JasperReport compileBlankA4Report() throws FileNotFoundException, JRException {
		
		// Compile the Jasper report from .jrxml to .japser
		File mainReportFile = ResourceUtils.getFile(reportSources.getClasspathSourceDir(reportSources.BLANK_A4));
		JasperReport mainJasperReport = JasperCompileManager.compileReport(mainReportFile.getAbsolutePath());
		JRSaver.saveObject(mainJasperReport, reportSources.getCompileDir(reportSources.BLANK_A4));
		
		File subReportFile = ResourceUtils.getFile(reportSources.getClasspathSourceDir(reportSources.BLANK_A4_1));
		JasperReport subJasperReport = JasperCompileManager.compileReport(subReportFile.getAbsolutePath());
		JRSaver.saveObject(subJasperReport, reportSources.getCompileDir(reportSources.BLANK_A4_1));
		
		File headerReportFile = ResourceUtils.getFile(reportSources.getClasspathSourceDir(reportSources.HEADER));
		JasperReport headerJasperReport = JasperCompileManager.compileReport(headerReportFile.getAbsolutePath());
		JRSaver.saveObject(headerJasperReport, reportSources.getCompileDir(reportSources.HEADER));
		
		return mainJasperReport;
	}
	
}
