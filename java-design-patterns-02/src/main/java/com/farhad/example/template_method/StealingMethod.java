package com.farhad.example.template_method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class StealingMethod {
    
    protected abstract String pickTarget();
    protected abstract void confuseTarget(String target);
    protected abstract void stealTheItem(String target);

    public final void steal() {
        String target = pickTarget();
        log.info("the target has een chosen as {}m", target);
        confuseTarget(target);
        stealTheItem(target);
    }
}
