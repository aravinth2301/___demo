package au.company.product.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.company.product.admin.domain.AppUserRole;

@Repository
public interface AppUserRoleCRUD extends CrudRepository<AppUserRole,Long> , AppUserRoleDao{

    @Query("select ur from AppUserRole ur where ur.appUser.id =:userId")
    List<AppUserRole> findAppUserRoleByUser(Long userId);
}
