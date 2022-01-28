package by.idFinanceLab.watcher.controller;

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

    private final DefaultCryptoService cryptoService;
    private final DefaultUserService userService;
    @Lazy
    @Autowired
    public CryptoController(DefaultCryptoService cryptoService, DefaultUserService userService) {
        this.cryptoService = cryptoService;
        this.userService = userService;
    }

    @GetMapping("/actual")
    public List<CryptoModel> getAll(){
        return cryptoService.getAll();
    }

    @PostMapping("/register")
    public void register(@PathVariable("name") String name,@PathVariable("coin") String coin){
        Float price=cryptoService.findFirstBySymbol(coin).getPriceUsd();
        userService.save(name,coin,price);
    }


}
