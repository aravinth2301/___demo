package au.company.product.admin.domain;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.domain.admin.Role;
import au.company.product.lib.common.util.ApplicationConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;

@Entity
@Table(name = "admin_app_user_role")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AppUserRole extends Domain{


    /**
	 * 
	 */
	private static final long serialVersionUID = -3658050676698485723L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_user_role_generator")
    @SequenceGenerator(name="admin_user_role_generator", sequenceName = "admin_user_role_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Role role;

    public AppUserRole() {
    }

    
    public Role getRole() {
		return role;
	}


	public AppUserRole(AppUser appUser, Role role) {
        this.appUser = appUser;
        this.role = role;
    }
}
