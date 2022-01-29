package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.User;

import java.util.List;

public interface UserService {

    List<User> findUserByCoin(String coin);
    void save(String user,String coin,Float price);
}
