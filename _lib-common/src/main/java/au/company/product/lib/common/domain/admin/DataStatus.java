package au.company.product.lib.common.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import au.company.product.lib.common.domain.Domain;
import au.company.product.lib.common.util.BadRequestException;
import au.company.product.lib.common.util.Error;

@Entity
@Table(name = "admin_data_status")
public class DataStatus extends Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 84933158793236891L;
	@Id
	private Integer id;
	@Column
	private String code;

	public Integer getId() {
		return id;
	}
	
	public DataStatus(String code) {
		if(Enum.ACTIVE.name().equals(code)) {
			this.code = Enum.ACTIVE.code;
			this.id = Enum.ACTIVE.id;
		} else if(Enum.DEACTIVE.name().equals(code)) {
			this.code = Enum.DEACTIVE.code;
			this.id = Enum.DEACTIVE.id;
		} else {
			throw new BadRequestException(Error.INVALID_DATA_VALUE, code);
		}
	}

	public DataStatus(Enum value) {
		this.code = value.code;
		this.id = value.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DataStatus(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public DataStatus() {
		super();
	}
	public enum Enum {
		ACTIVE(1,"ACTIVE"),
		DEACTIVE(2,"DE-ACTIVE");
		private Integer id;
		
		private String code;
		
		private Enum(Integer id,String code) {
			this.id = id;	
			this.code = code;
		}
		public Integer getId() {
			return id;
		}
		public String getCode() {
			return code;
		}
	}
	
	
}
