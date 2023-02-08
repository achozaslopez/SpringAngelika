package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"es"})//(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"es.rf.tienda"})
public class TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}

}
