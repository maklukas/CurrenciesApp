package pl.parser.nbp.configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public static final String API_URL = "http://api.nbp.pl/api/exchangerates/rates/C/";

    @Bean
    public XmlMapper getXmlMapper() {
        return new XmlMapper();
    }
}
