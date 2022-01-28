package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.User;

public interface UserService {

    User findUserByCoin(String coin);
    void save(String user,String coin,Float price);
}
