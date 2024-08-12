package com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.repository;

import com.shoppingmall.mktcloud.springboot.vscode.sf_mkt_cloud_connect_shopping_mall_backend.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}