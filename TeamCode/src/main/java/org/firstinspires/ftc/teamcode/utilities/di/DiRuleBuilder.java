package org.firstinspires.ftc.teamcode.utilities.di;
/*
import java.util.ArrayList;
import java.util.List;

public class DiRuleBuilder {
    private DiContainer container;

    private List<DiRule> targetRules = new ArrayList<>();

    protected DiRuleBuilder(DiContainer container) {
        this.container = container;
    }


    // User Facing

    public DiRuleBuilder Bind(Class<?> ...inClasses) {
        // Bind Source Classes
        return this;
    }

    public DiRuleBuilder BindInstance(Object instance) {
        // Bind Instance
        return this;
    }

    public DiRuleBuilder BindInstances(Object ...instances) {
        // Bind Instances
        return this;
    }

    public DiRuleBuilder BindInterfacesTo(Class<?> inClass) {
        // Bind all implemented interfaces to the class
        return this;
    }

    public DiRuleBuilder BindInterfacesAndSelfTo(Class<?> inClass) {
        // Bind all implemented interfaces and self to the class
        return this;
    }

    public DiRuleBuilder AsSingle() {
        // Create new Single Instance
        return this;
    }

    public DiRuleBuilder AsTransient() {
        // Create new Transient Instance
        return this;
    }

    public DiRuleBuilder AsCached() {
        // Create new Transient Instance
        return this;
    }

    public DiRuleBuilder FromResolve() {
        // Create new Cached Instance
        return this;
    }

    public DiRuleBuilder To(Class<?> inClass) {
        // Bind classes to use inClass
        return this;
    }

    public DiRuleBuilder FromInstance(Object instance) {
        // Bind classes to use instance
        return this;
    }

    public DiRuleBuilder When(DiCondition condition) {
        for (DiRule rule: targetRules) {
            rule.conditions.add(condition);
        }

        return this;
    }

    public DiRuleBuilder WhenInjectedInto(Class<?> inClass) {
        for (DiRule rule: targetRules) {
            rule.conditions.add(new DiCondition() {
                @Override
                public boolean check(DiContext context) {
                    return context.targetClass == inClass;
                }
            });
        }

        return this;
    }

    public DiRuleBuilder WithId(String id) throws DiExceptions.IDAlreadyTakenException {
        if (container.takenIDs.contains(id)) throw new DiExceptions.IDAlreadyTakenException();

        container.takenIDs.add(id);

        this.id = id;

        conditions.add(new DiCondition() {
            @Override
            public boolean check(DiContext context) {
                return context.id == id;
            }
        });

        return this;
    }
}
*/