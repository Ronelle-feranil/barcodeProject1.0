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
	
	@Query(value="SELECT CASE WHEN count(ai.status) = 0 THEN 0 ELSE CASE WHEN (ai.status) THEN 1 ELSE 0 END END AS isActive FROM barcode_usage_history buh INNER JOIN account_identifier ai ON buh.account_identifier_id = ai.account_identifier INNER JOIN otp o ON buh.otp_string = o.otp_string WHERE buh.secondary_barcode_string =:barcodeString"  
			, nativeQuery = true)
	public int isSevenElevenBarcodeActive(@Param("barcodeString")String barcodeString);
	
	public BarcodeUsageHistory findByBarcodeString(String barcodeString);
}
