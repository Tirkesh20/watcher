package by.idFinanceLab.watcher.repository;

import by.idFinanceLab.watcher.model.CryptoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CryptoRepository extends JpaRepository<CryptoModel,Long> {
    List<CryptoModel> findAll();
    CryptoModel findFirstBySymbol(String symbol);
}
