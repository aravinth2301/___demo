package au.company.product.sample.service;

import au.company.product.lib.common.domain.admin.AppUser;

import java.util.List;

public interface SampleService {

    public String testDBService();

    List<AppUser> fetchUsers();
}
