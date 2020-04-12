package au.company.product.admin.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import au.company.product.admin.dao.AppUserRoleDao;
import au.company.product.admin.domain.AppUserRole;
import au.company.product.lib.dao.util.ConectionDao;

@Repository
public class AppUserRoleDaoImpl extends ConectionDao implements AppUserRoleDao {



    @SuppressWarnings("unchecked")
	@Override
    public List<AppUserRole> findUserRole(Long userId, Long roleId) {
        String q = "select p from AppUserRole p " +
                "where " +
                "p.appUser.id=:userId and " +
                "p.role.id=:roleId";
        Query query = entityManager.createQuery(q);
        query.setParameter("userId", userId);
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
}
