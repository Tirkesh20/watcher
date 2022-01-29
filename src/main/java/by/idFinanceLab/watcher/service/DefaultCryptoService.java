package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.CryptoModel;
import by.idFinanceLab.watcher.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
public class DefaultCryptoService implements CryptoService {

private final CryptoRepository cryptoRepository;
    @Lazy
    @Autowired
    public DefaultCryptoService(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }


    public void save(CryptoModel cryptoModel) {
        cryptoRepository.save(cryptoModel);
    }

    public CryptoModel findFirstBySymbol(String symbol) {
        return cryptoRepository.findFirstBySymbol(symbol);
    }


}
