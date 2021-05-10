package pl.parser.nbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.parser.nbp.domain.ExchangeRate;


@SpringBootTest
public class RateMapperTest {

    @Autowired
    public RateMapper mapper;

    @Test
    public void fetchExchangeRate() {
        //given
        ExchangeRate exchangeRate = mapper.fetchExchangeRate("EUR", "2021-01-01", "2021-01-06");
        exchangeRate.getRates().stream()
                .map(r -> r.getBid() + " " + r.getAsk())
                .forEach(System.out::println);
        //when
        //then


    }
}