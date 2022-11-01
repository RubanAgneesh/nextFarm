package com.internaltools.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.internaltools.persistence.entity.User;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonIgnore
    private String userEmailId;


    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String userEmailId, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userEmailId = userEmailId;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new UserPrincipal(
                user.getId(),
                user.getUserEmailId(),
                user.getPassword(),
                authorities
        );
    }

    public Long getid() {
        return id;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }





}
