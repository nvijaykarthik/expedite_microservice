package in.expedite.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.expedite.entity.Configuration;
import in.expedite.repository.ConfigurationRepository;

/**
 * 
 * @author vijaykarthik 
 *
 *  Service class to manage the application's configuration values
 *  includes Add, Update and Get values
 *  Doesn't include delete as the key once created cannot be deleted  
 */
		

@Service
public class ConfigService {

	
	@Autowired
	private ConfigurationRepository repo;
	
	private static final Logger LOG = Logger.getLogger(ConfigService.class.getName());

	/**
	 * Function to add the configuration key and value is any permitted String,
	 * @param cfg
	 * @return
	 * @throws PrdmException
	 */
	@Transactional
	public Configuration addConfig(Configuration cfg)
	{
		cfg=repo.save(cfg);
		LOG.info("Configuartion Added");
		return cfg;
		
	}
/**
 * Function to Update the configuration value is any permitted String
 * @param cfg 
 * @throws PrdmException
 * 
 */
	@Transactional
	public void update(Configuration cfg){
		repo.save(cfg);
		LOG.info("Configuartion Updated");
	}
	
/**
 * Get All the Existing configuration 
 * @return
 * @throws PrdmException
 */
	
	@Transactional(readOnly=true)
	public List<Configuration> getConfig(){
		List<Configuration> confs=repo.findAll();
		LOG.info("List of Configuration Available " +confs);
		return confs;
	}
	
	/**
	 * Get configuration for selected key
	 * @param key
	 * @return
	 * @throws PrdmException
	 */
	@Transactional(readOnly=true)
	public Configuration getConfig(String key){
		return repo.findByKey(key);
	}
}
