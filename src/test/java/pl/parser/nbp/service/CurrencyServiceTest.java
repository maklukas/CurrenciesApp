package pl.parser.nbp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyService service;

    @Test
    public void shouldGetBidMidValue() {
        //given
        BigDecimal eur = service.getMidBidValue("EUR", "2021-01-01", "2021-01-06");
        BigDecimal eur2 = service.getMidBidValue("EUR", "2021-01-01", "2021-04-06");

        //when
        BigDecimal result = BigDecimal.valueOf(4.5387);
        BigDecimal result2 = BigDecimal.valueOf(4.5033);
        //then
        assertEquals(result, eur);
        assertEquals(result2, eur2);
    }

    @Test
    public void shouldGetStandardDeviationAsk() {
        //given
        BigDecimal eur = service.getStandardDeviationAsk("EUR", "2021-01-01", "2021-01-06");
        BigDecimal eur2 = service.getStandardDeviationAsk("EUR", "2021-01-01", "2021-04-06");

        //when
        BigDecimal result = BigDecimal.valueOf(0.0306);
        BigDecimal result2 = BigDecimal.valueOf(0.0517);
        //then
        assertEquals(result, eur);
        assertEquals(result2, eur2);
    }
}