package com.example.vote_newpro.web.console.framework.auth;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public class LoginUserDetails implements UserDetails, Serializable {
    private String userId;
    private String password;
    private String userName;
    private List<GrantedAuthority> authorities;

    public LoginUserDetails(String userId, String password, String userName, List<GrantedAuthority> authorities) {
        this.userId=userId;
        this.password=password;
        this.userName = userName;
        this.authorities=authorities;
    }

    public static LoginUserDetails create(String userId, String password, String userName, List<GrantedAuthority> authorities) {
        return new LoginUserDetails(userId,password,userName,authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
