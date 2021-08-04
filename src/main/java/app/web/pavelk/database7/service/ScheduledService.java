package app.web.pavelk.database7.service;

import app.web.pavelk.database7.component.ScheduledCom1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduledService {

    private final GenericApplicationContext genericApplicationContext;

    public String create() {

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        genericBeanDefinition.setBeanClass(ScheduledCom1.class);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) genericApplicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition(ScheduledCom1.class.getName(), genericBeanDefinition);
        genericApplicationContext.getBean(ScheduledCom1.class.getName());

        return "ok";
    }

    public String delete() {

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) genericApplicationContext.getBeanFactory();
        beanFactory.removeBeanDefinition(ScheduledCom1.class.getName());

        return "ok";
    }
}
