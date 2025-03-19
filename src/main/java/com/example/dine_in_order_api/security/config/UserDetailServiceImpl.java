package com.example.dine_in_order_api.security.config;

import com.example.dine_in_order_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(username)
                .map(this :: createAuthUser)
                .orElseThrow(() -> new UsernameNotFoundException("Fail to authenticate user, user not found "));
        return userDetails;
    }

    public UserDetails createAuthUser(com.example.dine_in_order_api.model.User user){
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
