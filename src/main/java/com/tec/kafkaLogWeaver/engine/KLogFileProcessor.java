package com.tec.kafkaLogWeaver.engine;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes("com.tec.kafkaLogWeaver.KLogFile")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class KLogFileProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Set<? extends Element> set;
        for (TypeElement annotation : annotations) {
            if (annotation.getSimpleName().toString().equals("KLogFile")) //get only the element that annotated with KLogFile Annotation
                set = roundEnv.getElementsAnnotatedWith(annotation);
        }



        return false;
    }
}
