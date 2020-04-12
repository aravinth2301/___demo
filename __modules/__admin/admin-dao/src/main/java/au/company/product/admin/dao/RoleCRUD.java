package au.company.product.admin.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.company.product.lib.common.domain.admin.Role;


@Repository
public interface RoleCRUD extends CrudRepository<Role,Long> {

    @Query("select r from Role r where r.name =:name")
    Role findRole(String name);


}
