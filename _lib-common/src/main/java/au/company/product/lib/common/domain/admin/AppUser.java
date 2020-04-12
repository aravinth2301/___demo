package au.company.product.lib.common.domain.admin;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.util.ApplicationConfig;

@Entity
@Table(name = "admin_app_user")
public class AppUser extends Domain  implements Serializable, UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4552951401620495899L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_user_generator")
    @SequenceGenerator(name="admin_user_generator", sequenceName = "admin_user_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private Date lastLoginAt;

    @Transient
    private List<Role> authorities;

    @Transient
    private String newPassword;

	@Override
    @JsonIgnoreProperties
    public Collection<? extends Role> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public String getNewPassword() {
        return newPassword;
    }
     
}
