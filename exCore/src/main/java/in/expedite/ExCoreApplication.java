package in.expedite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.expedite.repository.ConfigurationRepository;

@SpringBootApplication
public class ExCoreApplication extends SpringBootServletInitializer implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExCoreApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExCoreApplication.class);
    }

	@Autowired
	ConfigurationRepository cr;
	
	@Override
	public void run(String... args) throws Exception {
		in.expedite.entity.Configuration cfg = new in.expedite.entity.Configuration();
		cfg.setKey("Hello");
		cfg.setValue("Hello");
		cr.save(cfg);		
	}
}
