package org.tsxuehu.pm.service.scm;

import com.alibaba.fastjson.JSONObject;
import org.tsxuehu.pm.domain.scm.SCM;
import org.tsxuehu.pm.service.Factory;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface SCMFactory extends Factory {
    SCM create(JSONObject jsonObject);
}
