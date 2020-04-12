package au.company.product.lib.dao;

import org.springframework.data.repository.CrudRepository;

import au.company.product.lib.common.domain.admin.ErrorLog;


public interface ErrorLogCRUD extends CrudRepository<ErrorLog,Long> {

}
