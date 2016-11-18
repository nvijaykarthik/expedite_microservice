package in.expedite.web.resource;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.expedite.entity.Configuration;
import in.expedite.service.ConfigService;
import in.expedite.util.GeneralSuccessResponse;

/**
 * 
 * @author vijaykarthik N 
 *
 *  Rest service for Configuration management,
 *  it include add/update and get request.
 */


@RestController
@RequestMapping("/config")
public class ConfiguratorController  {

	@Autowired
	private ConfigService cs;
	
	private static final Logger LOG = Logger.getLogger(ConfiguratorController.class.getName());
	
	/**
	 * Add config ,Method : POST, Resource path : / 
	 * @param cfg
	 * @return
	 * @throws PrdmException
	 */
	
	@RequestMapping(produces="application/json",method=RequestMethod.POST)
	public GeneralSuccessResponse addConfig(@Valid @RequestBody Configuration cfg){
		LOG.info("Adding new configuration property" + cfg.toString());
		cs.addConfig(cfg);
    	return new GeneralSuccessResponse(0,"Sucessfully Added");
	}
	
	
	/**
	 * Get All Configurations available. Method : GET, Resource path : / 
	 * @return
	 * @throws PrdmException
	 * 
	 */
	@RequestMapping(produces="application/json",method=RequestMethod.GET)
	public List<Configuration> getAllConfig(){
		return cs.getConfig();
	}

	/**
	 * Method : POST, Resource path : /update 
	 * @param cfg
	 * @return
	 * @throws PrdmException
	 */
	
	@RequestMapping(path="/update",produces="application/json",method=RequestMethod.POST)
	public GeneralSuccessResponse saveConfig(@Valid @RequestBody Configuration cfg)	{
		LOG.info("Updating existing configuration property" + cfg.toString());
		cs.update(cfg);
		return new GeneralSuccessResponse(0,"Sucessfully Updated");
	}

}
