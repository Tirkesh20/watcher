package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.CryptoModel;

import java.util.List;

public interface CryptoService {

    void save(CryptoModel cryptoModel);
    List<CryptoModel> getAll();
    CryptoModel findFirstBySymbol(String symbol);
}
