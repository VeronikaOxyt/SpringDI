package com.oxytoca.config;

import com.oxytoca.student.MyStudent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyStudent) {
            MyStudent student = (MyStudent) bean;
            if (student.getName().equals("Jil")) {
                Map<String, Double> gradesOfJil = student.getReportCard();
                for (Map.Entry<String, Double> entry : gradesOfJil.entrySet()) {
                    entry.setValue(4.0);
                }
            }
        }
        return bean;
    }
}
