package by.idFinanceLab.watcher.mapper;

import by.idFinanceLab.watcher.model.CryptoPOJO;
import by.idFinanceLab.watcher.model.CryptoModel;

public class DefaultCryptoMapper implements CryptoMapper {

    @Override
    public CryptoModel cryptoToModel(CryptoPOJO cryptoPOJO) {
        return new CryptoModel(cryptoPOJO.getId(),cryptoPOJO.getSymbol(),Float.parseFloat(cryptoPOJO.getPrice_usd()));
    }
}
