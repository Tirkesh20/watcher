package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.job.CoinLore;
import by.idFinanceLab.watcher.model.CryptoModel;
import by.idFinanceLab.watcher.job.Watcher;
import by.idFinanceLab.watcher.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.List;


@Repository
public class DefaultCryptoService implements CryptoService {

private final CryptoRepository cryptoRepository;
    @Lazy
    @Autowired
    public DefaultCryptoService(CoinLore coinLore, CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }


    public void save(CryptoModel cryptoModel) {
        cryptoRepository.save(cryptoModel);
    }

    public List<CryptoModel> getAll() {
        return cryptoRepository.findAll();
    }

    public CryptoModel findFirstBySymbol(String symbol) {
        return cryptoRepository.findFirstBySymbol(symbol);
    }


}
