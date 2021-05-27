package xyz.mizan.multimodule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/board")
	public String adminAccess() {
		return "Admin Board.";
	}
}
