package pl.kuba.drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.kuba.drive.config.properties.ApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties.class)
public class DriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveApplication.class, args);
    }

}
