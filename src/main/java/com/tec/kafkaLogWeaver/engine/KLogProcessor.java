package com.tec.kafkaLogWeaver.engine;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes("com.tec.kafkaLogWeaver.KLog")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class KLogProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }


}
