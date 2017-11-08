package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.MerchantKeys;

@Repository
public interface MerchantKeysRepository extends JpaRepository<MerchantKeys, Long>{

}
