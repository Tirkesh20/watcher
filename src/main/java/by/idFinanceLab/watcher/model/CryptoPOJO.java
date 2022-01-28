package by.idFinanceLab.watcher.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CryptoPOJO implements Serializable {
    private final int id;
    private final String symbol;
    private final String name;
    private final String nameId;
    private final int rank;
    private final String price_usd;
    private final String percent_change_24h;
    private final String percent_change_1h;
    private final String percent_change_7d;
    private final String market_cap_usd;
    private final String volume24;
    private final String volume24_native;
    private final String csupply;
    private final String price_btc;
    private final String tsupply;
    private final String msupply;

    @JsonCreator
    public CryptoPOJO(
            @JsonProperty("id") String id,
            @JsonProperty("symbol") String symbol,
            @JsonProperty("name") String name,
            @JsonProperty("nameid") String nameId,
            @JsonProperty("rank") int rank,
            @JsonProperty("price_usd") String price_usd,
            @JsonProperty("percent_change_24h") String percent_change_24h,
            @JsonProperty("percent_change_1h") String percent_change_1h,
            @JsonProperty("percent_change_7d") String percent_change_7d,
            @JsonProperty("market_cap_usd") String market_cap_usd,
            @JsonProperty("volume24") String volume24,
            @JsonProperty("volume24_native") String volume24_native,
            @JsonProperty("csupply") String csupply,
            @JsonProperty("price_btc") String price_btc,
            @JsonProperty("tsupply") String tsupply,
            @JsonProperty("msupply") String msupply
    )
            {
        this.id=Integer.parseInt(id);
        this.symbol = symbol;
        this.name=name;
        this.nameId=nameId;
        this.rank=rank;
        this.price_usd=price_usd;
        this.percent_change_24h=percent_change_24h;
        this.percent_change_1h=percent_change_1h;
        this.percent_change_7d=percent_change_7d;
        this.market_cap_usd=market_cap_usd;
        this.volume24=volume24;
        this.volume24_native=volume24_native;
        this.csupply=csupply;
        this.price_btc=price_btc;
        this.tsupply=tsupply;
        this.msupply=msupply;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getNameId() {
        return nameId;
    }

    public int getRank() {
        return rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public String getVolume24() {
        return volume24;
    }

    public String getVolume24_native() {
        return volume24_native;
    }

    public String getCsupply() {
        return csupply;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public String getTsupply() {
        return tsupply;
    }

    public String getMsupply() {
        return msupply;
    }

    @Override
    public String toString() {
        return "CryptoPOJO{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", nameId='" + nameId + '\'' +
                ", rank=" + rank +
                ", price_usd='" + price_usd + '\'' +
                ", percent_change_24h='" + percent_change_24h + '\'' +
                ", percent_change_1h='" + percent_change_1h + '\'' +
                ", percent_change_7d='" + percent_change_7d + '\'' +
                ", market_cap_usd='" + market_cap_usd + '\'' +
                ", volume24='" + volume24 + '\'' +
                ", volume24_native='" + volume24_native + '\'' +
                ", csupply='" + csupply + '\'' +
                ", price_btc='" + price_btc + '\'' +
                ", tsupply='" + tsupply + '\'' +
                ", msupply='" + msupply + '\'' +
                '}';
    }
}

