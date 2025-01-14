package in.sameer.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configclass {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
