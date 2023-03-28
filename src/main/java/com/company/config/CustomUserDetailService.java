package com.company.config;

import com.company.entity.ClientEntity;
import com.company.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
            Optional<ClientEntity> entity = clientRepository.findByPhone(phone);
            if (entity.isEmpty()) {
                throw new UsernameNotFoundException("User Not Found");
            }
            return new CustomUserDetails(entity.get());
    }
}
