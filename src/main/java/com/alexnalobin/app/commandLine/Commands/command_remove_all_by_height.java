package com.alexnalobin.app.commandLine.Commands;

import com.alexnalobin.app.commandLine.Conveyor;
import com.alexnalobin.app.commandLine.command;
import com.alexnalobin.app.dataStruct.Answer;
import com.alexnalobin.app.dataStruct.Person;
import com.alexnalobin.app.dataStruct.command_condition;

public class command_remove_all_by_height implements command {
    private Conveyor conveyor;
    private Object conditor;
    private Object answer_conditor;
    
    public command_remove_all_by_height(Conveyor conv, Object cond, Object answcond) {
        this.conveyor = conv;
        this.conditor = cond;
        this.answer_conditor = answcond;
    }

    public void execute() {
        String buffer = conveyor.comm_buff.get(0).get(0);
        Long num = null;
        try {
            num = Long.parseLong(buffer);
            if (num != null) {
                Integer counter = 0;
                for (Person pers : conveyor.data) {
                    Long temp = pers.getHeight();
                    if (num == temp) {
                        conveyor.data.remove(pers);
                        counter += 1;
                    }
                }
                conveyor.answer.add(new Answer(command_condition.finished, "Удалено элементов: " + counter));
                sendAwake();
            }
            if (conveyor.comm_buff.size() > 1) {
                this.repeat();
                return;
            }
        } catch (NumberFormatException e) {
            conveyor.answer.add(new Answer(command_condition.critical_error, "Значение " + buffer +
                    " не распознано. Вводите значение типа Long."));
            sendAwake();
            return;
        }
    };

    public void repeat() {
        conveyor.comm_buff.get(0).remove(0);
        conveyor.comm_buff.get(0).add("");
        this.execute();
        return;
    };

    public void set_next_command(command com) {
    };

    private void sendAwake() {
        synchronized (answer_conditor) {
            answer_conditor.notifyAll();
        }
    }
}
