package by.idFinanceLab.watcher.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CryptoModel implements Serializable {
    @Id
    private int id;

    private String symbol;

    private Float priceUsd;
public CryptoModel(int id,String symbol,Float price){
    this.id=id;
    this.symbol=symbol;
    this.priceUsd=price;
}

    public CryptoModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Float priceUsd) {
        this.priceUsd = priceUsd;
    }
}

