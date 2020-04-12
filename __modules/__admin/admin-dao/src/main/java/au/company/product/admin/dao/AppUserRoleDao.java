package au.company.product.admin.dao;

import java.util.List;

import au.company.product.admin.domain.AppUserRole;

public interface AppUserRoleDao {
    List<AppUserRole> findUserRole(Long userId, Long roleId);
}
