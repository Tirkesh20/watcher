package by.idFinanceLab.watcher.controller;

import by.idFinanceLab.watcher.model.Coin;
import by.idFinanceLab.watcher.model.CryptoModel;
import by.idFinanceLab.watcher.service.CryptoService;
import by.idFinanceLab.watcher.service.DefaultCryptoService;
import by.idFinanceLab.watcher.service.DefaultUserService;
import by.idFinanceLab.watcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CryptoController {

    private final CryptoService cryptoService;
    private final UserService userService;
    private final List<Coin> coinList;
    @Lazy
    @Autowired
    public CryptoController(DefaultCryptoService cryptoService, DefaultUserService userService, List<Coin> coinList) {
        this.cryptoService = cryptoService;
        this.userService = userService;
        this.coinList = coinList;
    }

    @GetMapping("/actual")
    public List<Coin> getAll(){
        return coinList;
    }

    @GetMapping("/register")
    public String register(@RequestParam("Name") String name,@RequestParam("Coin") String coin){
        Float price=cryptoService.findFirstBySymbol(coin).getPriceUsd();
        userService.save(name,coin,price);
        return "success";
    }

    @GetMapping("/findBy/{symbol}")
    public Float getPrice(@PathVariable("symbol")String symbol){
        return cryptoService.findFirstBySymbol(symbol).getPriceUsd();
    }

}
