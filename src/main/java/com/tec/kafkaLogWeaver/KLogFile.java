package com.tec.kafkaLogWeaver;

public @interface KLogFile {

    String path() default "";

}
