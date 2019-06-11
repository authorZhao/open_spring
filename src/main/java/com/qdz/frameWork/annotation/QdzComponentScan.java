package com.qdz.frameWork.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface QdzComponentScan {
    String[] value() default {};
}
