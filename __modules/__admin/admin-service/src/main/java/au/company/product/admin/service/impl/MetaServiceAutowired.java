package au.company.product.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import au.company.product.admin.dao.AppVersionCRUD;
import au.company.product.lib.dao.DataStatusCRUD;

public abstract class MetaServiceAutowired {
	@Autowired 
	protected AppVersionCRUD appVersionCRUD;
	@Autowired
	protected DataStatusCRUD dataStatusCRUD;

}
