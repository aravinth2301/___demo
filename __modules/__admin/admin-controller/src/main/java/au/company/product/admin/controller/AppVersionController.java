package au.company.product.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.company.product.lib.common.util.MetaService;
import au.company.product.lib.common.util._Controller;

@RestController
@RequestMapping("/version")
public class AppVersionController implements _Controller {

	@Autowired
	@Qualifier("adminMetaService")
	private MetaService metaService;
	
	@PostMapping(value = "/admin")
	public void versionUpgrade() {
		metaService.upgrate();
	}
}
