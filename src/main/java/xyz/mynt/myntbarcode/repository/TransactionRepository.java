package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long>{

	@Query(value = "SELECT * FROM Transactions buh WHERE buh.barcode_string = :barcodeString",
			nativeQuery = true)
	  public Transactions transactionBarcodeExist(String barcodeString);

}
