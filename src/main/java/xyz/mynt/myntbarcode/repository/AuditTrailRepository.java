package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.AuditTrail;

@Repository
public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long>{

}
