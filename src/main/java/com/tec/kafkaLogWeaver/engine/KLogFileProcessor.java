package com.tec.kafkaLogWeaver.engine;

import com.sun.source.util.JavacTask;
import com.tec.kafkaLogWeaver.engine.tasks.KLogFileTask;
import com.tec.kafkaLogWeaver.engine.tasks.KLogFileTaskListener;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.*;


@SupportedAnnotationTypes("com.tec.kafkaLogWeaver.KLogFile")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class KLogFileProcessor extends AbstractProcessor {

    Messager messager;
    List<KLogFileTask> tasks = new ArrayList<KLogFileTask>();


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        JavacTask.instance(processingEnv).addTaskListener(new KLogFileTaskListener(tasks, messager));
        messager.printMessage(Diagnostic.Kind.NOTE, "KLogFileProcessor initialize and task added to task listener");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> set = null;
        for (TypeElement annotation : annotations) {
            if (annotation.getSimpleName().toString().equals("KLogFile")) //get only the element that annotated with KLogFile Annotation
                set = roundEnv.getElementsAnnotatedWith(annotation);
        }

        //for each element(method), create task then add it into tasks list.
        for (Element element : set) {
            String methodName = element.getSimpleName().toString();
            List<? extends VariableElement> arguments = ((ExecutableElement) element).getParameters();
            tasks.add(new KLogFileTask(methodName, getArgumentsMap(arguments), (ExecutableElement) element));
        }
        return false;
    }


    private Map<String, VariableElement> getArgumentsMap(List<? extends VariableElement> argumentsList) {
        Map<String, VariableElement> argumentsMap = new HashMap<>();
        for (VariableElement element : argumentsList) {
            argumentsMap.put(element.getSimpleName().toString(), element);
        }
        return argumentsMap;


    }

}


