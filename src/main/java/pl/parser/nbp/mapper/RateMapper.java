package pl.parser.nbp.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.parser.nbp.configuration.AppConfig;
import pl.parser.nbp.domain.ExchangeRate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class RateMapper {

    private XmlMapper xmlMapper;

    @Autowired
    public RateMapper(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    public ExchangeRate fetchExchangeRate(String code, String startDate, String endDate) {
        try {
            return xmlMapper.readValue(buildStringUrl(code, startDate, endDate), ExchangeRate.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public URL buildStringUrl(String code, String startDate, String endDate) {
        try {
            URL url = new URL(AppConfig.API_URL + code + "/" + startDate + "/" + endDate + "?format=xml");
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
