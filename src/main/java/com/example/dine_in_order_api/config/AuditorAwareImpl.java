package com.example.dine_in_order_api.config;

import com.example.dine_in_order_api.security.util.UserIentity;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Configuration
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    private final UserIentity userIentity;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(userIentity.getCurrentUserEmail());
    }
}
