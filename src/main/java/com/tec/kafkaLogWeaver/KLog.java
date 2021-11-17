package com.tec.kafkaLogWeaver;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})
public @interface KLog {
    String[] properties() default {};

}
