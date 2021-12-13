package org.firstinspires.ftc.teamcode.utilities.di;

public class DiContext {
    public String id;
    public Class<?> targetClass;
    public Object objectInstance;
    public String memberName;
    public boolean optional;
    public DiContainer container;

    protected DiContext(String id, Class<?> targetClass, Object objectInstance, String memberName, boolean optional, DiContainer container) {
        this.id = id;
        this.targetClass = targetClass;
        this.objectInstance = objectInstance;
        this.memberName = memberName;
        this.optional = optional;
        this.container = container;
    }
}
