package org.tsxuehu.pm.service.user;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.domain.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Service("userService")
public class UserService {
    private static List<User> users;
    static {
        users=new ArrayList<>();
        users.add(new User("1","pianfan"));
        users.add(new User("2","pangxie"));
        users.add(new User("3","niunai"));
        users.add(new User("4","jiagoushi"));
    }
    public List<User> query(String nick){
        return users;
    }
}
