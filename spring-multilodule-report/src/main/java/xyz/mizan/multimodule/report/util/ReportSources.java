package xyz.mizan.multimodule.report.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class ReportSources {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ReportSources.class);
	
	//..........
	@Value("${jasper.source.dir}")
	public String JASPER_SOURCE_DIR;
	
	@Value("${jasper.source.classpath.dir}")
	public String JASPER_CLASSPATH_SOURCE_DIR;
	
	@Value("${jasper.compile.dir}")
	public String JASPER_COMPILE_DIR;
	
	@Value("${jasper.compile.classpath.dir}")
	public String JASPER_CLASSPATH_COMPILE_DIR;
	
	@Value("${jasper.image.dir}")
	public String REPORT_IMAGE_PATH;
	
	@Value("${jasper.image.classpath.dir}")
	public String REPORT_ClASSPATH_IMAGE;
	
	
	//..............
	//Report file extension
	public final String JRKML_EXTENSION = ".jrxml";
	public final String JASPER_EXTENSION = ".jasper";

	// Report file name
	public final String HEADER = "Header";
	public final String BLANK_A4 = "Blank_A4";
	public final String BLANK_A4_1 = "Blank_A4_1";
	
	
	//............
	//Image classpath file name
	public final String LOGO = "logo.jpg";

	
	//.........
	public String getSourceDir(String filename) {
		return String.format("%s%s%s", JASPER_SOURCE_DIR, filename, JRKML_EXTENSION);
	}
	
	public String getClasspathSourceDir(String filename) {
		return String.format("classpath:%s%s%s", JASPER_CLASSPATH_SOURCE_DIR, filename, JRKML_EXTENSION);
	}

	public String getCompileDir(String filename) {
		return String.format("%s%s%s", JASPER_COMPILE_DIR, filename, JASPER_EXTENSION);
	}
	
	public String getClasspathCompileDir(String filename) {
		return String.format("classpath:%s%s%s", JASPER_CLASSPATH_COMPILE_DIR, filename, JASPER_EXTENSION);
	}
	
	public String getImage(String image) {
		return String.format("%s%s", REPORT_IMAGE_PATH, image);
	}
	
	public String getClassPathImage(String image) {
		return String.format("classpath:%s%s", REPORT_ClASSPATH_IMAGE, image);
	}
	
}
