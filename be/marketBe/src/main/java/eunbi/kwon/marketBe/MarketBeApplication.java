package eunbi.kwon.marketBe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan("eunbi.kwon.marketBe")
public class MarketBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketBeApplication.class, args);
	}

}
