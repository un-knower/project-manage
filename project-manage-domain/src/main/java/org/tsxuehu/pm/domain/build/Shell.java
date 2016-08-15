package org.tsxuehu.pm.domain.build;

import lombok.Data;

import java.util.Date;

/**
 * 合并分支脚本回显
 * 当前正在合并的分支
 *
 * 构建脚本:
 * 当前阶段名称,百分比
 *
 * push脚本:
 * 回显当前阶段,百分比
 *
 * Created by tsxuehu on 16/8/12.
 */
@Data
public class Shell {
    Long id;
    String name;//同一个类型里面这个是唯一的
    String type;//脚本类型
    String description;
    String content;//脚本内容
    public Shell(){}
    public Shell(Long id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }
    public Shell(Long id, String name, String description, String type,String content) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.content =content;
    }
}
