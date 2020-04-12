package au.company.product.admin.domain;

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
@Table(name = "_version")
public class AppVersion extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1278516269444330258L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_version_generator")
    @SequenceGenerator(name="_version_generator", sequenceName = "_version_seq",allocationSize = ApplicationConfig.DOMAIN_ID_INCREMENT_BY)
    private Long id;
	
	@Column(nullable = false)
	private String version;
	
	@Column
	private Integer hashValue;
	
	public AppVersion() {
	}

	public AppVersion(String version, Integer hashValue) {
		super();
		this.version = version;
		this.hashValue = hashValue;
	}
	
	

	
}
