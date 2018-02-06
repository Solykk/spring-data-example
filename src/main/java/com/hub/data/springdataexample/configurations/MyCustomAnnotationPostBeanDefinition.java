package com.hub.data.springdataexample.configurations;

import com.hub.data.springdataexample.annotations.MyCustomAnnotation;
import com.hub.data.springdataexample.utils.DataUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Lyashenko
 */
//@Component
public class MyCustomAnnotationPostBeanDefinition implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(DataUtil.getDescription(o));
        MyCustomAnnotation annotation = o.getClass().getAnnotation(MyCustomAnnotation.class);
        if (annotation != null){
            System.out.println(annotation.value());
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
