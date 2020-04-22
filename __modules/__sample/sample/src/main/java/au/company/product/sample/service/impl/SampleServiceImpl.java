package au.company.product.sample.service.impl;

import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.dao.AppUserCRUD;
import au.company.product.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private AppUserCRUD appUserCRUD;

    @Override
    public String testDBService() {
        return "Test DB Service";
    }

    @Override
    public List<AppUser> fetchUsers(){
       return appUserCRUD.findAllUsers();
    }
}
