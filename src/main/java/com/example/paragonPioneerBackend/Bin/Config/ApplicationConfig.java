package com.example.paragonPioneerBackend.Bin.Config;


import com.example.paragonPioneerBackend.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final AdminRepository adminRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> adminRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No Username found: " + username));
    }
}
