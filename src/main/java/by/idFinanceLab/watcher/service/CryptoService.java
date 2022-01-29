package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.CryptoModel;


public interface CryptoService {

    void save(CryptoModel cryptoModel);
    CryptoModel findFirstBySymbol(String symbol);
}
