package xyz.mynt.myntbarcode.service;

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
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private AccountIdentifierRepository accountIdentifierRepository;
	
	/**
	 * Expire OTP Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.otp}")
	public void expireOTP() {
		
		otpRepository.expireOTP();
		System.out.println("CRON SERVICE OTP SUCCESS");
	}
	
	/**
	 * Expire Account Identifier Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.accountidentifier}")
	public void expireAccountIdentifier() {
		
		accountIdentifierRepository.expireAccountIdentifier();
		System.out.println("CRON SERVICE Account Identifier SUCCESS");
	}
	
	
	/**
	 * Expire Seven ElevenAccount Identifier Scheduler 
	 */
	@Scheduled(cron="${cron.schedule.expire.seveneleven}")
	public void expireSevenElevenAccountIdentifier() {
		
		accountIdentifierRepository.expireSevenElevenAccountIdentifier();
		System.out.println("CRON SERVICE Seven Eleven Account Identifier SUCCESS");
	}
	

}
