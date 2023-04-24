package tn.enicarthage;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetWebBackendApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8082");
		DOMConfigurator.configure("src/main/resources/log4j.xml");
	
		SpringApplication.run(ProjetWebBackendApplication.class, args);
	}

}
