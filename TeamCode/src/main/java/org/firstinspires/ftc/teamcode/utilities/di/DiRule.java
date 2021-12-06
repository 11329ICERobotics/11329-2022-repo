package org.firstinspires.ftc.teamcode.utilities.di;
/*
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiRule {
    protected DiContainer container;
    protected RetrievalMode retrievalMode = RetrievalMode.None;
    protected Class<?> targetClass = null;
    protected Class<?> instanceClass;
    protected List<DiCondition> conditions = new ArrayList<>();

    public boolean ruleApplies(DiContext context) {
        boolean applies = true;

        for (DiCondition condition: conditions) {
            if (!condition.check(context)) {
                applies = false;
                break;
            }
        }

        return applies;
    }

    public Object getObjectValue() throws DiExceptions.IncompleteBindingException, IllegalAccessException, InstantiationException, InvocationTargetException {
        switch (retrievalMode) {
            case Create:
                if (instanceClass == null) throw new DiExceptions.IncompleteBindingException();

                return container.Instantiate(instanceClass);
            case Resolve:
                return container.Resolve();
        }

        throw new DiExceptions.IncompleteBindingException();
    }

    protected enum RetrievalMode {
        None,
        Resolve,
        Create
    }
}
*/