package org.tsxuehu.midway.web.html;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 注入到页面的数据
 * Created by tsxuehu on 16/9/2.
 */
@Data
public class InjectData {
    String name;
    String serviceId;
    Map<String, String> paramsMap;
}
