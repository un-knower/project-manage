package org.tsxuehu.pm.domain.api;

import lombok.Data;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/8/13.
 */
@Data
public class ApiDefinition {
    Long id;
    //接口定义
    String key;
    String version;
    //参数
    List<Param> apiParams;

    //后端服务
    String className;
    String method;
    //服务参数,及与接口参数的映射
    List<ServiceParam> serviceParams;

    /**
     * 调用容器中得服务
     *
     * @param params
     * @param applicationContext
     * @return
     */
    public Object call(Map<String, String> params, ApplicationContext applicationContext) throws ClassNotFoundException, NoSuchMethodException {

        //获取对象
        Class clazz = Class.forName(this.className);
        Object object = applicationContext.getBean(clazz);
        //构建参数类型
        Map<Integer, ServiceParam> paramMap = serviceParamMap();

        Method method = clazz.getDeclaredMethod(this.method, getTypeArray(paramMap));
        //通过反射调用该对象的方法
        return null;
    }

    private Map<Integer, ServiceParam> serviceParamMap() {
        Map<Integer, ServiceParam> paramsHash = new HashMap<>();
        for (ServiceParam serviceParam : serviceParams) {
            paramsHash.put(serviceParam.getOrder(),serviceParam);
        }
        return paramsHash;
    }
    private Class[] getTypeArray(Map<Integer, ServiceParam> paramMap) throws ClassNotFoundException {
        int length = serviceParams.size();
        Class[] result =new Class[length];
        for(int i =0;i<length;i++){
            result[i]=Class.forName(paramMap.get(i).getType());
        }
        return result;
    }
    private Object[] getParamArray(Map<Integer, ServiceParam> paramMap,Map<String, String> params){
        int length = serviceParams.size();
        Object[] result =new Object[length];

        for(int i =0;i<length;i++){
            ServiceParam serviceParam = paramMap.get(i);
            switch (serviceParam.getType()){
                case "java.lang.String":
                    result[i]=params.get(serviceParam.getMapAPiParamName());
                    break;
                case "java.lang.Integer":
                    result[i]=Integer.parseInt(params.get(serviceParam.getMapAPiParamName()));
                    break;
            }



        }
        return result;
    }

    public String[] getParamsName() {
        return null;
    }
}
