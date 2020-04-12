package au.company.product.lib.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.util.JSONUtil;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public abstract class Domain implements Serializable {
	
	private static final long serialVersionUID = 3560968982496646484L;

	@CreatedDate
	@JsonIgnore
    private Date createdAt;

    @CreatedBy
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private AppUser createdBy;
    
    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedAt;
    
    @LastModifiedBy
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private AppUser lastModifiedBy;
    
    
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
	public String toString() {
		return JSONUtil.toString(this);
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public AppUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AppUser createdBy) {
		this.createdBy = createdBy;
	}

	public AppUser getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(AppUser lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
}
