package org.tsxuehu.pm.domain.application;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.tsxuehu.pm.domain.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by tsxuehu on 16/7/22.
 */
@Data
public class Application {
    public static Application create(Long id, String name, String description, Long scmId, String gitlabProjectId,
                                     String dailyMachines, String preMachines, String formalMachines,
                                     String publishers, Long mergeShellId, Long buildShellId, Long publishShellId,
                                     String review, String appParam, String owner) {
        Application application = new Application();
        application.setId(id);
        application.setName(name);
        application.setDescription(description);
        application.setScmId(scmId);
        application.setGitlabProjectId(gitlabProjectId);
        //机器解析
        application.setDailyMachines(Server.serverListFromJSONString(dailyMachines));
        application.setPreMachines(Server.serverListFromJSONString(preMachines));
        application.setFormalMachines(Server.serverListFromJSONString(formalMachines));

        application.setPublishers(User.userListFromJSONString(publishers));

        application.setMergeShellId(mergeShellId);
        application.setBuildShellId(buildShellId);
        application.setPublishShellId(publishShellId);
        //review项解析
        JSONObject jsObject = JSON.parseObject(review);
        application.setMustCodeReview(jsObject.getBoolean("mustCodeReview"));
        application.setMustStaticScan(jsObject.getBoolean("mustStaticScan"));
        application.setMustTest(jsObject.getBoolean("mustTest"));

        application.setAppParam(appParam);

        application.setOwner(User.userFromJSONString(owner));
        return application;
    }

    Long id;
    String name;//全局唯一
    String description;

    Long scmId;//git仓库地址
    String gitlabProjectId;//工程在gitlab上的id

    List<Server> dailyMachines;//日常可部署机器
    List<Server> preMachines;//预发可部署机器
    List<Server> formalMachines;//部署时部署的机器

    User owner;

    List<User> publishers;//可发布人员

    long mergeShellId;//合并分支的脚本id
    long buildShellId;//构建脚本id
    long publishShellId;//发布脚本id

    /**
     * review项(代码质量保证 选项)
     */
    boolean mustCodeReview;//必须通过review才能上线
    boolean mustTest;//必须通过测试才能上线
    boolean mustStaticScan;//必须通过静态扫描才能上线

    /**
     * 执行构建脚本时,appParam会传递给脚本
     */
    String appParam;

    public Application() {
        this.mustCodeReview = false;
        this.mustTest = true;
        this.mustStaticScan = false;
    }

    public Application(Long id, String name, String description, User owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.mustCodeReview = false;
        this.mustTest = true;
        this.mustStaticScan = false;
    }

    @JSONField(serialize = false)
    public String getReviewJSONString() {

        JSONObject jsObject = new JSONObject();
        jsObject.put("mustCodeReview", mustCodeReview);
        jsObject.put("mustStaticScan", mustStaticScan);
        jsObject.put("mustTest", mustTest);
        return jsObject.toJSONString();
    }
}
