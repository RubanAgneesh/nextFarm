package com.internaltools.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.ConfigProperties;

@Repository
public interface ConfigPropertiesRepository extends JpaRepository<ConfigProperties, Long> {

	/**
	 * @param configName
	 * @return ConfigProperties
	 */
	List<Optional<ConfigProperties>> findByConfigNameAndIsActiveTrue(String configName);

	/**
	 * @param type
	 * @return List<ConfigProperties>
	 */
	List<ConfigProperties> findByConfigValue(String type);
	
}
