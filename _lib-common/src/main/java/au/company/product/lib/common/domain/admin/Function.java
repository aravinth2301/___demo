package au.company.product.lib.common.domain.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.util.ApplicationConfig;

@Entity
@Table(name = "admin_function")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Function extends Domain implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3317947254223313897L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_function_generator")
    @SequenceGenerator(name="admin_function_generator", sequenceName = "admin_function_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;

    @Column(unique = true)
    private String code;

    private Boolean enabled = false;


    @Transient
    private Boolean delete = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Function() {
    }

    public Function(String code) {
        this.code = code;
    }

    public Function(String code, Boolean enabled) {
        this.code = code;
        this.enabled = enabled;
    }
    
    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}
