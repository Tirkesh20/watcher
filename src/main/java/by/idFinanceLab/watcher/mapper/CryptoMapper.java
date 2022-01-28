package by.idFinanceLab.watcher.mapper;

import by.idFinanceLab.watcher.model.CryptoPOJO;
import by.idFinanceLab.watcher.model.CryptoModel;

public interface CryptoMapper {

     CryptoModel cryptoToModel(CryptoPOJO cryptoPOJO);

}
