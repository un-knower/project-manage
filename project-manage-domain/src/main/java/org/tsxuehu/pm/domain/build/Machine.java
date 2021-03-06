package org.tsxuehu.pm.domain.build;

import lombok.Data;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Data
public class Machine {
    Long id;
    String name;
    String location;
    String username;
    String password;
    String port;

    public Machine(Long id, String name, String location, String port, String username, String password) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.port = port;
        this.username = username;
        this.password = password;
    }
}
