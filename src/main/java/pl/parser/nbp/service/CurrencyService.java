package pl.parser.nbp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parser.nbp.domain.Rate;
import pl.parser.nbp.mapper.RateMapper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CurrencyService {
    private RateMapper mapper;

    @Autowired
    public CurrencyService(RateMapper mapper) {
        this.mapper = mapper;
    }

    public BigDecimal getMidBidValue(String code, String startDate, String endDate) {
        List<Rate> rates = mapper.fetchExchangeRate(code, startDate, endDate).getRates();

        BigDecimal sum = BigDecimal.ZERO;
        for (Rate r: rates) {
            sum = sum.add(BigDecimal.valueOf(r.getBid()));
        }
        return sum.divide(BigDecimal.valueOf(rates.size()), RoundingMode.HALF_UP);
    }

    public BigDecimal getStandardDeviationAsk(String code, String startDate, String endDate) {
        List<Rate> rates = mapper.fetchExchangeRate(code, startDate, endDate).getRates();

        BigDecimal sum = BigDecimal.ZERO;
        for (Rate r: rates) {
            sum = sum.add(BigDecimal.valueOf(r.getAsk()));
        }
        sum = sum.divide(BigDecimal.valueOf(rates.size()), RoundingMode.HALF_UP);

        BigDecimal difference = BigDecimal.ZERO;

        for (Rate r: rates) {
            difference = difference.add(sum.subtract(BigDecimal.valueOf(r.getAsk())).pow(2));
        }

        return difference.divide(BigDecimal.valueOf(rates.size()), RoundingMode.HALF_UP).sqrt(new MathContext(3));
    }

}
