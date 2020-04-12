package au.company.product.admin.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import au.company.product.admin.domain.AppVersion;

public interface AppVersionCRUD extends CrudRepository<AppVersion, Integer> {
	
	public Optional<AppVersion> findByVersion(String version);

}
