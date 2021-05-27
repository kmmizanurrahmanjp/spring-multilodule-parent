package xyz.mizan.multimodule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(DefaultController.class);
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
