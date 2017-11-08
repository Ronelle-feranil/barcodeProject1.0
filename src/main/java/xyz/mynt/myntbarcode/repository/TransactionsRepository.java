package xyz.mynt.myntbarcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.myntbarcode.entity.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

}
