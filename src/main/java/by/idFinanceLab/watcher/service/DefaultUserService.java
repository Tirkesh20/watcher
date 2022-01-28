package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.User;
import by.idFinanceLab.watcher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    @Lazy
    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findUserByCoin(String coin) {
        return null;
    }

    public void save(String name, String coin, Float price) {
        User user=new User();
        user.setName(name);
        user.setCoin(coin);
        user.setPrice(price);
        userRepository.save(user);
    }
}
