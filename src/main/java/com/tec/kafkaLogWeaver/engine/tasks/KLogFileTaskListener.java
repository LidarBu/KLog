package com.tec.kafkaLogWeaver.engine.tasks;


import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import java.util.List;
import java.util.Map;

public class KLogFileTaskListener implements TaskListener {

    public static final String LOGGER_NAME = "KLogTEC_Logger";
    private  List<KLogFileTask> tasks;
    private Messager messager;

    public KLogFileTaskListener( List<KLogFileTask> tasks, Messager messager) {
        this.tasks = tasks;
        this.messager = messager;
        messager.printMessage(Diagnostic.Kind.NOTE,
                "KLogFileTaskListener Construct With Following Tasks: " +tasks.toString());
    }




    @Override
    public void started(TaskEvent event) {
    }

    @Override
    public void finished(TaskEvent event) {

    }
}
