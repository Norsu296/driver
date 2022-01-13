package pl.kuba.drive.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app.driver.api")
public class ApiProperties {

    private String url;

}
