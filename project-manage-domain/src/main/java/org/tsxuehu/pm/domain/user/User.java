package org.tsxuehu.pm.domain.user;

import lombok.Data;

/**
 * Created by tsxuehu on 16/7/23.
 */
@Data
public class User {
    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String id;
    String name;
}
