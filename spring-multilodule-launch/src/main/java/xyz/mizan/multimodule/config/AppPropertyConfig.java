package xyz.mizan.multimodule.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:properties/app.properties")
})
public class AppPropertyConfig {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppPropertyConfig.class);
	
	
	//code here
}
