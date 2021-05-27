package xyz.mizan.multimodule;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class BootstrapApplication {

	private static final Logger LOG = LoggerFactory.getLogger(BootstrapApplication.class);
	
	@Autowired
    private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
	}
	
	
	@PostConstruct
    public void init(){
        LOG.info(System.getProperty("user.home"));
        LOG.info(environment.getProperty("controller.package"));
    }
}
