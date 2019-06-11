package com.qdz.frameWork.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QdzRequestMapping {
    String value() default "";
}
