package com.example.dine_in_order_api.utility.schedulers;

import com.example.dine_in_order_api.model.TokenBlackList;
import com.example.dine_in_order_api.repository.TokenBlackListRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@AllArgsConstructor
public class CleanExpieredToken {

    private final TokenBlackListRepository tokenBlackListRepository;

    @Scheduled(cron = "0 5 * * * *")
    public void cleanExpieredToken(){

        List<TokenBlackList> tokenBlackListList = tokenBlackListRepository.
                                        findByExpirationLessThan(Instant.now().toEpochMilli());

        tokenBlackListRepository.deleteAll(tokenBlackListList);

    }
}
