package org.tsxuehu.midway.web.api;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.tsxuehu.midway.web.HttpCall;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by tsxuehu on 16/8/28.
 */
public class SpringService extends BackendService {

    public SpringService() {
        type = "spring";
    }

    @Override
    public Object call(String env, Map<String, String> paramsMap, HttpCall httpCall, ApplicationContext applicationContext)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取对象
        Class clazz = Class.forName(this.service);
        Object target = applicationContext.getBean(clazz);
        Method method = clazz.getDeclaredMethod(this.function, getParamArray());
        //通过反射调用该对象的方法
        return method.invoke(target, getParamArray(paramsMap, httpCall));
    }

    private Class[] getParamArray() throws ClassNotFoundException {
        int length = parameters.length;
        Class[] result = new Class[length];

        for (int i = 0; i < length; i++) {
            Parameter parameter = parameters[i];
            result[i] = Class.forName(parameter.getType());
        }
        return result;
    }


    private Object[] getParamArray(Map<String, String> paramsMap, HttpCall httpCall) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int length = parameters.length;
        Object[] result = new Object[length];

        for (int i = 0; i < length; i++) {
            Parameter parameter = parameters[i];
            result[i] = convertType(httpCall.getString(paramsMap.get(parameter.getName())), parameter.getType());
        }
        return result;
    }

    private Object convertType(String value, String totype) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        if (StringUtils.endsWithIgnoreCase(totype, "string")) {
            return value;
        }
        Class type = Class.forName(totype);
        Method method = type.getDeclaredMethod("valueOf", String.class);
        return method.invoke(null, value);

    }
}
