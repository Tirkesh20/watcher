package by.idFinanceLab.watcher.job;

import by.idFinanceLab.watcher.mapper.CryptoMapper;
import by.idFinanceLab.watcher.model.CryptoModel;
import by.idFinanceLab.watcher.model.CryptoPOJO;
import by.idFinanceLab.watcher.model.User;
import by.idFinanceLab.watcher.service.CryptoService;
import by.idFinanceLab.watcher.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(CoinLore.class);
    @Lazy
    @Autowired
    public CoinLore(ObjectMapper objectMapper, CryptoMapper mapper, List<URL> urls, CryptoService cryptoService, UserService userService) {
        this.objectMapper=objectMapper;
        this.mapper = mapper;
        this.urls=urls;
        this.cryptoService = cryptoService;
        this.userService = userService;
    }
//Cлишком много вложений я понимая  я могу сделать через потоки но просте не успевал это сделать
    @Override
    @Scheduled(fixedRate = 1000*60)
    public void ticker() {
        try {
            for (URL url:urls){
                List<CryptoPOJO> myObjects = objectMapper.readValue(url, new TypeReference<List<CryptoPOJO>>(){});
                CryptoModel cryptoModel=mapper.cryptoToModel(myObjects.get(0));
                float oldPrice=cryptoService.findFirstBySymbol(cryptoModel.getSymbol()).getPriceUsd();
              if (difference(cryptoModel.getPriceUsd(),oldPrice)){
                    logger.warn(String.valueOf(getPercentage(cryptoModel.getPriceUsd(),oldPrice)));
                    List<User> userList= userService.findUserByCoin(cryptoModel.getSymbol());
                    for (User user: userList) {
                        logger.warn(cryptoModel.getSymbol()+" "+user.getName()+" "+getPercentage(cryptoModel.getPriceUsd(),user.getPrice()));
                    }
                }
                cryptoService.save(cryptoModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean difference(Float currentPrice,Float oldPrice ){
        return ((currentPrice - oldPrice) / oldPrice > 0.01);
    }

    private float getPercentage(Float currentPrice,Float oldPrice){

        return (currentPrice/oldPrice)*100;
    }
}
