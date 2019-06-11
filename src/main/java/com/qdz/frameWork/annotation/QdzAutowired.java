package com.qdz.frameWork.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QdzAutowired {
    String value() default "";
}
