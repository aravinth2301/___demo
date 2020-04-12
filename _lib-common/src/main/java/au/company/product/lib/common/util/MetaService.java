package au.company.product.lib.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.company.product.lib.common.dto.MetaDataDTO;

public interface MetaService {
	
	@Transactional(propagation = Propagation.REQUIRED)
	default void upgrate() {
		MetaDataDTO metaDataDTO = JSONUtil.get("/data/meta/_version.json", MetaDataDTO.class);
		String currentVersion = metaDataDTO.getVersion();

		List<String> versions = new ArrayList<>();
		if (!("".equals(currentVersion) || currentVersion == null)) {
			versions.add(currentVersion);
		} else {
			versions.addAll(metaDataDTO.getVersionHistory());
		}
		versions.forEach(version -> upgrate(version));
	}


	default void upgrate(String version) {}
}
