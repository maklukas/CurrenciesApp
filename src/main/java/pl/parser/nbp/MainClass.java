package pl.parser.nbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.parser.nbp.service.CurrencyService;

@SpringBootApplication
public class MainClass {

    private static CurrencyService currencyService;

    @Autowired
    public MainClass(CurrencyService currencyService) {
        MainClass.currencyService = currencyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);
        init(args);
    }

    public static void init(String[] args) {
        if (args.length < 3) {
            System.out.println("You have to pass all arguments: Currency code, date from and date to");
        } else {
            System.out.println(currencyService.getMidBidValue(args[0], args[1], args[2]));
            System.out.println(currencyService.getStandardDeviationAsk(args[0], args[1], args[2]));
        }
    }
}
