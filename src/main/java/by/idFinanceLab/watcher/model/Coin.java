package by.idFinanceLab.watcher.model;

import lombok.AllArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
public class Coin implements Serializable {
    private final int id;
    private final String symbol;

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

}
