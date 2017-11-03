package com.luo.redis.info.component;

import com.luo.redis.info.bean.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * BeanConvert
 */
@Component
public class BeanConvert {

    /**
     * properties 转换为 bean
     */
    public <T> T toBean(Properties properties, T bean) {

        try {
            Class clazz = bean.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(bean, properties.getProperty(field.getName()));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * properties 转换为 info
     */
    public InfoBean toInfoBean(Properties properties, InfoBean infoBean) {

        infoBean.setServer(toBean(properties, new InfoServer()));
        infoBean.setClients(toBean(properties, new InfoClients()));
        infoBean.setMemory(toBean(properties, new InfoMemory()));
        infoBean.setPersistence(toBean(properties, new InfoPersistence()));
        infoBean.setStats(toBean(properties, new InfoStats()));
        infoBean.setReplication(toBean(properties, new InfoReplication()));
        infoBean.setCpu(toBean(properties, new InfoCpu()));
        infoBean.setCluster(toBean(properties, new InfoCluster()));
        infoBean.setKeyspace(toInfoKeyspace(properties, new InfoKeyspace()));

        return infoBean;
    }

    /**
     * 提取properties转换为InfoKeyspace
     */
    public InfoKeyspace toInfoKeyspace(Properties properties, InfoKeyspace infoKeyspace) {

        List<String> dbList = new ArrayList<>();
        Enumeration<String> nameList = (Enumeration<String>) properties.propertyNames();
        while (nameList.hasMoreElements()) {
            String name = nameList.nextElement();
            if (name.startsWith("db")) {
                dbList.add(properties.getProperty(name));
            }
        }

        infoKeyspace.setDbList(dbList);
        return infoKeyspace;
    }

}
