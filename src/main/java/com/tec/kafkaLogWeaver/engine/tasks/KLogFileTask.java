package com.tec.kafkaLogWeaver.engine.tasks;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import java.util.Map;

public class KLogFileTask {

    private String methodName;
    private Map<String, VariableElement> arguments;
    private ExecutableElement element;


    public KLogFileTask(String methodName, Map<String, VariableElement> arguments, ExecutableElement element) {
        this.methodName = methodName;
        this.arguments = arguments;
        this.element = element;
    }

    @Override
    public String toString() {
        return "KLogFileTask{" +
                "methodName='" + methodName + '\'' +
                ", arguments=" + arguments +
                ", element=" + element +
                '}';
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, VariableElement> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, VariableElement> arguments) {
        this.arguments = arguments;
    }

    public ExecutableElement getElement() {
        return element;
    }

    public void setElement(ExecutableElement element) {
        this.element = element;
    }
}
