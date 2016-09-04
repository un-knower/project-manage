package org.tsxuehu.midway.web.html;

import lombok.Data;

import java.util.List;

/**
 * Created by tsxuehu on 16/9/2.
 */
@Data
public class Asserts {
    String project;//前端工程名
    String verion;//前端工程版本号
    List<String> cssFiles;//引用的css文件
    List<String> jsFiles;//引用的js文件
}
