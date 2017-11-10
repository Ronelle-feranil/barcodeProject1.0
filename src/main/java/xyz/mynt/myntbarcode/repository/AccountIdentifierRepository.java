package xyz.mynt.myntbarcode.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.AccountIdentifier;
import xyz.mynt.myntbarcode.enums.Status;

@Repository
public interface AccountIdentifierRepository extends JpaRepository<AccountIdentifier, Long>{
	
	public long countByAccountIdentifierAndStatus(long accountIdentifier, Status status);
	
	public AccountIdentifier findByGcashWalletAndStatus(String gcashWallet, Status status);
	
	@Transactional
	@Query(value = "UPDATE account_identifier SET status = 0, hashed_pin = '' WHERE datetime_modified < (NOW() - INTERVAL 5 MINUTE) AND secondary_barcode_string IS NULL"
			, nativeQuery = true)
	@Modifying
	public int expireAccountIdentifier();
	
	@Transactional
	@Query(value = "UPDATE account_identifier SET STATUS = 0 WHERE datetime_modified < (NOW() - INTERVAL 30 MINUTE) AND secondary_barcode_string IS NOT NULL"
			, nativeQuery = true)
	@Modifying
	public int expireSevenElevenAccountIdentifier();
	
}
	