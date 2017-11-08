package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>{
	
	public Merchant findByMerchantGcashWallet(String gcashWallet);

}
