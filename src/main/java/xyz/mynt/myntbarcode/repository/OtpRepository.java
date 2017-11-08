package xyz.mynt.myntbarcode.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.OTP;

@Repository
public interface OtpRepository extends JpaRepository<OTP, Long>{
	
	@Transactional
	@Query(value = "UPDATE otp SET status = 0 WHERE datetime_modified < (NOW() - INTERVAL 2 MINUTE)"
			, nativeQuery = true)
	@Modifying
	public int expireOTP();
	
	@Transactional
	@Query(value = "UPDATE otp SET status = 0 where account_identifier_id = :accountIdentifier"
			, nativeQuery = true)
	@Modifying
	public int invalidatePreviousOTP(@Param("accountIdentifier")long accountIdentifier);
	
}
