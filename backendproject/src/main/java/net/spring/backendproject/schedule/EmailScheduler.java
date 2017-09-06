package net.spring.backendproject.schedule;

import net.spring.backendproject.business.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailScheduler {
	
	@Autowired
	private BusinessLogic logic;

//	@Scheduled(fixedDelay=5000)
//	public void demoFixedDelaySchedule(){
//		System.out.println("hello : "  + new Date());
//	}
	
	@Scheduled(cron="0 0 22 * * *")
	public void demoCronSchedule(){
		logic.sendEmail();
	}
}



