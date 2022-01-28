package by.idFinanceLab.watcher.config;

import by.idFinanceLab.watcher.mapper.CryptoMapper;
import by.idFinanceLab.watcher.mapper.DefaultCryptoMapper;
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
import java.util.HashMap;
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
    public HashMap<String,Integer> map(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("ETH",80);
        map.put("BTC",90);
        map.put("SOL",48543);
        return map;
    }

    @Bean
    public List<URL> url() throws MalformedURLException {
      List<URL> urls=new ArrayList<>();
      urls.add(new URL("https://api.coinlore.net/api/ticker/?id=48543"));
      urls.add(new URL("https://api.coinlore.net/api/ticker/?id=90"));
      urls.add(new URL("https://api.coinlore.net/api/ticker/?id=80"));
      return urls;
    }


}
