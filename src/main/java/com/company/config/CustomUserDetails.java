package com.company.config;

import com.company.entity.ClientEntity;
import com.company.enums.ClientStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class CustomUserDetails implements UserDetails {

    private ClientEntity client;

    public CustomUserDetails(ClientEntity client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new LinkedList<>(Collections.singletonList(new SimpleGrantedAuthority(client.getName())));
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return client.getStatus().equals(ClientStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return client.getVisible();
    }

    public ClientEntity getClient() {
        return client;
    }
}
