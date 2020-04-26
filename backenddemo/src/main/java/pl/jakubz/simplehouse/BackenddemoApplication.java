package pl.jakubz.simplehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackenddemoApplication extends SpringBootServletInitializer {
    public BackenddemoApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(BackenddemoApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(new Class[]{BackenddemoApplication.class});
    }
}