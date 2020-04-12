package au.company.product.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import au.company.product.admin.domain.RoleFunction;
import au.company.product.lib.common.domain.admin.Function;

public interface RoleFunctionCRUD extends CrudRepository<RoleFunction,Long> {
    @Query("select rf from RoleFunction rf")
    public List<Function> fetchAll();
    
    @Query("select rf.function from RoleFunction rf where rf.role.id = :roleId")
    public List<Function> fetchByRoleId(Long roleId);
}
