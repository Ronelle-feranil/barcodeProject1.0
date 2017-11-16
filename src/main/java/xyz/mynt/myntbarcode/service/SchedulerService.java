package xyz.mynt.myntbarcode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import xyz.mynt.myntbarcode.repository.AccountIdentifierRepository;
import xyz.mynt.myntbarcode.repository.OtpRepository;

/**
 * Service for Scheduled Jobs
 * 
 * @author karl.cubilo
 *
 */
@Service
public class SchedulerService {
	
	private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private AccountIdentifierRepository accountIdentifierRepository;
	
	/**
	 * Expire OTP Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.otp}")
	public void expireOTP() {
		
		try {
			
			otpRepository.expireOTP();
		}catch(RuntimeException e) {
			
			log.error("Unexepected error occured on expire OTP: ", e.getCause());
		}
	}
	
	/**
	 * Expire Account Identifier Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.accountidentifier}")
	public void expireAccountIdentifier() {
		
		try {
			
			accountIdentifierRepository.expireAccountIdentifier();
		}catch(RuntimeException e) {
			
			log.error("Unexepected error occured on expire Account Identifier: ",e.getCause());
		}
	}
	
	
	/**
	 * Expire Seven ElevenAccount Identifier Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.seveneleven}")
	public void expireSevenElevenAccountIdentifier() {
		
		try {
			
			accountIdentifierRepository.expireSevenElevenAccountIdentifier();
		}catch(RuntimeException e) {
			
			log.error("Unexepected error occured on expire Seven Eleven Account Identifier: ",e.getCause());
		}
	}
	

}
