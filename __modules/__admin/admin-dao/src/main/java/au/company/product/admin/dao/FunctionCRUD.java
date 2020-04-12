package au.company.product.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import au.company.product.lib.common.domain.admin.Function;

public interface FunctionCRUD extends CrudRepository<Function,Long> {

    @Query("select p from Function p")
    public List<Function> fetchAll();
}
