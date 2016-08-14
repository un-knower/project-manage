package org.tsxuehu.pm.domain.build;

import lombok.Data;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Data
public class  ShellType {
    public static final ShellType  Merge = new ShellType("merge","合并分支");
    public static final ShellType  Build = new ShellType("build","构建应用");
    public static final ShellType  Push = new ShellType("push","推送应用");

    public static ShellType[] getAllShellTypes(){
        return new ShellType[]{Merge,Build,Push};
    }

    private ShellType(String key,String name){
        this.key = key;
        this.name = name;
    }

    private String key;
    private String name;


}
