package in.expedite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.expedite.entity.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>{
	
	Configuration findByKey(String key);
}
