package au.company.product.sample.controller;

import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("sample")
    public String testService() {
        return sampleService.testDBService();
    }

    @GetMapping("users")
    public @ResponseBody
    List<AppUser> getUsers() {
        return sampleService.fetchUsers().stream().map((user) -> {
                    user.setPassword(null);
                    return user;
                }
        ).collect(Collectors.toList());
    }
}
