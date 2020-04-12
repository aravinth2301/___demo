package au.company.product.lib.common.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.util.ApplicationConfig;

@Entity
@Table(name = "_error_log")
public class ErrorLog extends Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5179618667502286047L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_error_log_generator")
    @SequenceGenerator(name="_error_log_generator", sequenceName = "_error_log_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;
	
	@Column(unique = false)
	private String code;
	
	private String requestContent;
	public ErrorLog() {
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	public ErrorLog(String code ,String requestContent) {
		super();
		this.setCode(code);
		this.requestContent = requestContent;
		
	}
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
	
}
