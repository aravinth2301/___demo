package au.company.product.lib.common.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class DomainIdentifier extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4775459161816144540L;
	
	@Column(nullable = false, unique = true)
	private String code;

	public String getCode() {
		return code;
	}

	public abstract Long getId();
	public abstract void setId(Long id);
	public void setCode(String code) {
		if (code != null)
			this.code = code.toUpperCase();
	}

}
