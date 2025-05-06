package com.zainab.customerapi.Repository;

import com.zainab.customerapi.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Long>{
}
