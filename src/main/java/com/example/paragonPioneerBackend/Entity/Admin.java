package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.entityEnums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Represents an Admin entity in the system.
 * This class extends BaseEntity and implements UserDetails interface.
 * It is mapped to the "admin" table in the database.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
@SQLDelete(sql = "UPDATE admin SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Admin extends BaseEntity implements UserDetails {

    /**
     * Represents the email of the admin.
     * It is a unique field in the "admin" table.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Represents the password of the admin.
     */
    private String password;

    /**
     * Represents the role of the admin.
     * By default, it is set to Role.Admin.
     */
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.Admin;

    /**
     * Returns the authorities granted to the admin.
     * In this case, it returns a list containing the role of the admin.
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    /**
     * Returns the username of the admin.
     * In this case, it returns the email of the admin.
     * @return the username
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * Checks if the account is not expired.
     * @return true since the account is never expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if the account is not locked.
     * @return true since the account is never locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if the credentials are not expired.
     * @return true since the credentials are never expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if the account is enabled.
     * @return true since the account is always enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}