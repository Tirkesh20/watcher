package by.idFinanceLab.watcher.service;

import by.idFinanceLab.watcher.model.User;
import by.idFinanceLab.watcher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    @Lazy
    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findUserByCoin(String coin) {
        return userRepository.findUsersByCoin(coin);
    }

    public void save(String name, String coin, Float price) {
        User user=new User();
        user.setName(name);
        user.setCoin(coin);
        user.setPrice(price);
        user.setLocalDateTime(LocalDateTime.now());
        userRepository.save(user);
    }
}
