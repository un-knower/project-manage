package org.tsxuehu.pm.domain.build;

import java.util.Date;

/**
 * Created by tsxuehu on 16/8/12.
 */
public class Shell {
    ShellType shellType;//脚本类型
    String name;//同一个类型里面这个是唯一的
    String description;
    String content;//脚本内容
    Date lastModifyTime;//最近修改时间
    Date createTime;//创建时间
}
