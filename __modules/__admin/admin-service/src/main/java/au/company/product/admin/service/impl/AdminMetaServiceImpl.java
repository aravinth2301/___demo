package au.company.product.admin.service.impl;

import org.springframework.stereotype.Service;

import au.company.product.lib.common.domain.admin.DataStatus;
import au.company.product.lib.common.util.MetaService;

@Service("adminMetaService")
public class AdminMetaServiceImpl extends MetaServiceAutowired implements MetaService{
	
	
	@Override
	public void upgrate() {
		MetaService.super.upgrate();
		addDataStatus();
	}
	private void addDataStatus() {
		DataStatus.Enum[] tmp = DataStatus.Enum.values();
		for (int i = 0; i < tmp.length; i++) {
			DataStatus.Enum value=tmp[i];
			if (!dataStatusCRUD.existsByCode(value.getCode()))
				dataStatusCRUD.save(new DataStatus(value.getId(),value.getCode()));
		}
	}
	
}
