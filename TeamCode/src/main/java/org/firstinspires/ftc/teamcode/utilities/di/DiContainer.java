package org.firstinspires.ftc.teamcode.utilities.di;

import org.apache.commons.lang3.ClassUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DiContainer {/*
    List<DiRule> rules = new ArrayList<>();
    HashMap<UUID, Object> objectPool = new HashMap<>();

    protected Object Resolve(Class<?> searchClass, DiContext context) {
        //Resolve a value using a given context
    }

    public void Tick() {

    }

    public void Dispose() {

    }
*/
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Inject {
        String id() default "";
        boolean optional() default false;
    }
/*
    public Object Inject(Object instance) throws IllegalAccessException {
        DiContext context = new DiContext("", instance.getClass(), instance, "", false, this);

        Field[] fields = instance.getClass().getFields();

        for (Field field: fields) {
            if (!field.isAnnotationPresent(Inject.class)) continue;
            Inject inject = field.getAnnotation(Inject.class);

            context.id = inject.id();
            context.optional = inject.optional();
            context.memberName = field.getName();

            field.set(instance, Resolve(instance.getClass(), context));
        }

        return instance;
    }

    public Object Instantiate(Class<?> inClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        DiContext context = new DiContext("", inClass, null, "", false, this);

        Constructor<?>[] constructors = inClass.getConstructors();

        Class<?>[] parameterClasses = constructors[0].getParameterTypes();

        List<Object> parameterValues = new ArrayList<>();

        for (Class<?> parameterClass: parameterClasses) {
            parameterValues.add(Resolve(parameterClass, context));
        }

        Object instance = constructors[0].newInstance(parameterValues.toArray(new Object[0]));

        return Inject(instance);
    }

    public DiRuleBuilder Bind(Class<?> ...inClasses) {
        DiRuleBuilder diRuleBuilder = new DiRuleBuilder(this);

        diRuleBuilder.Bind(inClasses);

        return diRuleBuilder;
    }

    public DiRuleBuilder BindInstance(Object instance) {
        DiRuleBuilder diRuleBuilder = new DiRuleBuilder(this);

        diRuleBuilder.BindInstance(instance);

        return diRuleBuilder;
    }

    public DiRuleBuilder BindInstances(Object ...instances) {
        DiRuleBuilder diRuleBuilder = new DiRuleBuilder(this);

        diRuleBuilder.BindInstances(instances);

        return diRuleBuilder;
    }

    public DiRuleBuilder BindInterfacesTo(Class<?> inClass) {
        DiRuleBuilder diRuleBuilder = new DiRuleBuilder(this);

        diRuleBuilder.BindInterfacesTo(inClass);

        return diRuleBuilder;
    }

    public DiRuleBuilder BindInterfacesAndSelfTo(Class<?> inClass) {
        DiRuleBuilder diRuleBuilder = new DiRuleBuilder(this);

        diRuleBuilder.BindInterfacesAndSelfTo(inClass);

        return diRuleBuilder;
    }

    public Object Resolve(Class<?> searchClass) throws DiExceptions.InstanceNotFoundException, DiExceptions.MultipleInstancesFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<Object> allObjects = ResolveAll(searchClass);

        if (allObjects.size() > 1) throw new DiExceptions.MultipleInstancesFoundException();

        return allObjects.get(0);
    }

    public Object ResolveId(Class<?> searchClass, String id) throws DiExceptions.InstanceNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<Object> allObjects = ResolveAll(searchClass);

        return allObjects.get(0);
    }

    public List<Object> ResolveAll(Class<?> searchClass) throws DiExceptions.InstanceNotFoundException, DiExceptions.IncompleteBindingException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Object> allObjects = new ArrayList<>();

        for (DiRule diRule : rules) {
            if (diRule.targetClass != null || diRule.instanceClass != searchClass) continue;

            allObjects.add(diRule.getObjectValue());
        }

        if (allObjects.size() <= 0) throw new DiExceptions.InstanceNotFoundException();

        return allObjects;
    }

    public Object TryResolve(Class<?> searchClass) {
        try {
            return this.Resolve(searchClass);
        } catch (Exception e) {
            return null;
        }
    }

    public Object TryResolveId(Class<?> searchClass, String id) {
        try {
            return this.ResolveId(searchClass, id);
        } catch (Exception e) {
            return null;
        }
    }
*/
}