package by.idFinanceLab.watcher.config;

import by.idFinanceLab.watcher.exception.URLException;
import by.idFinanceLab.watcher.mapper.CryptoMapper;
import by.idFinanceLab.watcher.mapper.DefaultCryptoMapper;
import by.idFinanceLab.watcher.model.Coin;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.idFinanceLab.watcher")
@EnableScheduling
public class ServerConfig {

    @Bean
    public ObjectMapper objectMapper() {
      return new ObjectMapper().configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Bean
    public CryptoMapper cryptoMapper(){
        return new DefaultCryptoMapper();
    }

    @Bean
    public List<URL> url() throws URLException {
      List<URL> urls=new ArrayList<>();
        try {
            urls.add(new URL("https://api.coinlore.net/api/ticker/?id=48543"));
            urls.add(new URL("https://api.coinlore.net/api/ticker/?id=90"));
            urls.add(new URL("https://api.coinlore.net/api/ticker/?id=80"));
        } catch (MalformedURLException e) {
            throw new URLException(e.getMessage());
        }

      return urls;
    }

    @Bean
    public List<Coin> coinList() {
        return Arrays.asList(
                new Coin(80,"ETH"),
                new Coin(90,"BTC"),
                new Coin(48543,"SOL") );
    }

}
