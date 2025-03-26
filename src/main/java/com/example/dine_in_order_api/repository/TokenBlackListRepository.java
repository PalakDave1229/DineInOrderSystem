package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.TokenBlackList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenBlackListRepository extends JpaRepository<TokenBlackList,String>{

    boolean existsByToken(String token);
    List<TokenBlackList> findByExpirationLessThan(long current);

}
