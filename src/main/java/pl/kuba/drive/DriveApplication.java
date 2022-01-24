package pl.kuba.drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.kuba.drive.config.properties.ApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties.class)
@EnableJpaAuditing
public class DriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveApplication.class, args);
    }

}
