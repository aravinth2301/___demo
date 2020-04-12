package au.company.product.lib.dao;

import org.springframework.data.repository.CrudRepository;

import au.company.product.lib.common.domain.admin.DataStatus;


public interface DataStatusCRUD extends CrudRepository<DataStatus, Integer> {
	public boolean existsByCode(String code);
}
