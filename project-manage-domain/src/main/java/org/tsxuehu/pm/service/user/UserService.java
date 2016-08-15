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
        users.add(new User(1l,"pianfan"));
        users.add(new User(2l,"pangxie"));
        users.add(new User(3l,"niunai"));
        users.add(new User(4l,"jiagoushi"));
    }
    public List<User> query(String nick){
        return users;
    }
}
