package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.BarcodeUsageHistory;

@Repository
public interface BarcodeUsageHistoryRepository extends JpaRepository<BarcodeUsageHistory, Long> {
	
	public long countByAccountIdentifierIDAndOtpString(long accountIdentifier, int otpString);
	
	public long countByAccountIdentifierID(long accountIdentifier);
	
	@Query(value="SELECT count(1) FROM barcode_usage_history buh INNER JOIN account_identifier ai ON buh.account_identifier_id = ai.account_identifier INNER JOIN otp o ON buh.otp_string = o.otp_string WHERE buh.secondary_barcode_string = :barcodeString AND buh.status = 1 AND ai.status = 1 AND o.status = 1"  
			, nativeQuery = true)
	public int isSevenElevenBarcodeActive(@Param("barcodeString")String barcodeString);
	
	@Query(value = "SELECT * FROM barcode_usage_history buh WHERE buh.barcode_string = :barcodeString",
			nativeQuery = true)
	public BarcodeUsageHistory barcodeUsageHistoryExist(@Param("barcodeString")String barcodeString);

	public BarcodeUsageHistory findByBarcodeString(String barcodeString);
}
