package xyz.mizan.multimodule.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);
}
