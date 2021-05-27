package xyz.mizan.multimodule.comon.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
@EnableScheduling
public class PrintScheduler {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PrintScheduler.class);

	// execute the task every minute starting at 9:00 AM and ending at 9:59 AM,
	// every day
	/*@Scheduled(cron = "0 * 9 * * ?")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		LOG.warn("Java cron job expression:: " + strDate);
	}*/

	/**
	 * Fixed Rate scheduler is used to execute the tasks at the specific time. It
	 * does not wait for the completion of previous task. The values should be in
	 * milliseconds.
	 */
	/*@Scheduled(fixedRate = 1000)
	public void fixedRateSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		LOG.warn("Fixed Rate scheduler:: " + strDate);
	}*/

	
	/**
	Fixed Delay scheduler is used to execute the tasks at a specific time. 
	It should wait for the previous task completion. 
	The values should be in milliseconds.
	In this example
	after every 3 seconds, the fixed delay scheduler task has executed on every second.
	*/
	/*@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		LOG.warn("Fixed Delay scheduler:: " + strDate);
	}*/
}
