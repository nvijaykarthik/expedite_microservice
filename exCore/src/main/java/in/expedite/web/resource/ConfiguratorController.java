package in.expedite.web.resource;

import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
	@PreAuthorize("#oauth2.hasScope('ui')")
	@RequestMapping(produces="application/json",method=RequestMethod.GET)
	public List<Configuration> getAllConfig(HttpServletRequest req,OAuth2Authentication auth){
		LOG.info("Getting All configuration property");
		System.out.println(auth.getPrincipal()+" is logged in ");
		Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {

			String headerName = headerNames.nextElement();
			System.out.println(headerName);

			Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				System.out.println("header value:" + headerValue);
			}

		}
		
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
