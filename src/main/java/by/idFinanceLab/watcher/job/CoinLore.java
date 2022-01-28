package by.idFinanceLab.watcher.job;

import by.idFinanceLab.watcher.mapper.CryptoMapper;
import by.idFinanceLab.watcher.model.CryptoPOJO;
import by.idFinanceLab.watcher.service.CryptoService;
import by.idFinanceLab.watcher.service.DefaultCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public class CoinLore implements Watcher {

    private final ObjectMapper objectMapper;
    private final CryptoMapper mapper;
    private final List<URL> urls;
    private final CryptoService cryptoService;

    @Lazy
    @Autowired
    public CoinLore(ObjectMapper objectMapper, CryptoMapper mapper, List<URL> urls, CryptoService cryptoService) {
        this.objectMapper=objectMapper;
        this.mapper = mapper;
        this.urls=urls;
        this.cryptoService = cryptoService;
    }

    @Override
    @Scheduled(fixedRate = 1000*60)
    public void ticker() {
        try {
            for (URL url:urls){
                List<CryptoPOJO> myObjects = objectMapper.readValue(url, new TypeReference<List<CryptoPOJO>>(){});
                System.out.println(myObjects.get(0));
                cryptoService.save(mapper.cryptoToModel(myObjects.get(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
