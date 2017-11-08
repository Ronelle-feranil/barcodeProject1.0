package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;

@Repository
public interface BarcodeUsageHistoryRepository extends JpaRepository<BarcodeUsageHistory, Long> {
	
	@Query(value = "SELECT COUNT(1) FROM barcode_usage_history buh WHERE buh.account_identifier_id = :accountIdentifier AND buh.otp_string = :otp",
			nativeQuery = true)
	public long countActiveBarcodeUsage(@Param("accountIdentifier")long accountIdentifier, @Param("otp")int otp);
	
}
