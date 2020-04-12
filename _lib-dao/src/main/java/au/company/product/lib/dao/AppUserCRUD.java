package au.company.product.lib.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.company.product.lib.common.domain.admin.AppUser;

@Repository
public interface AppUserCRUD extends CrudRepository<AppUser,Long> {

    @Query("select p from AppUser p where p.username =:username")
    AppUser findAppUser(String username);

    Optional<AppUser> findByUsername(String username);

    @Query("select p from AppUser p")
    List<AppUser> findAllUsers();

}
