package au.company.product.lib.dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonCRUD<T,ID extends Serializable> extends CrudRepository<T, ID> {
	public Optional<T> findByCode(String code);
}
