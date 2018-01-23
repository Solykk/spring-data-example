package com.hub.data.springdataexample.configurations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AutowiredAnnotationBeanPostProcessorInterceptor extends AutowiredAnnotationBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("----------------" + beanName);
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }
}
