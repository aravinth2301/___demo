package au.company.product.admin.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.domain.admin.Function;
import au.company.product.lib.common.domain.admin.Role;
import au.company.product.lib.common.util.ApplicationConfig;

@Entity
@Table(name = "admin_role_function")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class RoleFunction extends Domain implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 788039073554282142L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_role_function_generator")
    @SequenceGenerator(name="admin_role_function_generator", sequenceName = "admin_role_function_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Function function;


    public RoleFunction() {
    }

    public RoleFunction(Role role, Function function) {
        this.role = role;
        this.function = function;
    }
}
