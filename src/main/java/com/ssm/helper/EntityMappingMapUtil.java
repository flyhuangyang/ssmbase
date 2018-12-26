package com.ssm.helper;

import com.ssm.domain.Test;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 将实体类映射成map集合
 */
public class EntityMappingMapUtil {

    public static Map<String,Object> convertBeanToMap(Object bean) {
        if (bean != null){
            Class type = bean.getClass();
            Map<String,Object> returnMap = new HashMap<String, Object>();
            BeanInfo beanInfo = null;
            try {
                beanInfo = Introspector.getBeanInfo(type);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();

                    try {
                        Object result = readMethod.invoke(bean, new Object[0]);
                        if (result != null) {
                            returnMap.put(propertyName, result);
                        } else {
                            returnMap.put(propertyName, "");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return returnMap;
        }
        return null;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setViewCount(1213);
        Map<String,Object> map = EntityMappingMapUtil.convertBeanToMap(test);
        System.out.println(map.get("viewCount"));
        System.out.println(map.get("id")==null);
    }

}
