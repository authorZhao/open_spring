package com.qdz.frameWork.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QdzMapper {
    String value() default "";
}
