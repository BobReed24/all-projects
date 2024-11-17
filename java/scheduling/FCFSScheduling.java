package com.thealgorithms.scheduling;

import com.thealgorithms.devutils.entities.ProcessDetails;
import java.util.List;

public class FCFSScheduling {

    private List<ProcessDetails> processes;

    FCFSScheduling(final List<ProcessDetails> processes) {
        this.processes = processes;
    }

    public void scheduleProcesses() {
        evaluateWaitingTime();
        evaluateTurnAroundTime();
    }

    private void evaluateWaitingTime() {
        int processesNumber = processes.size();

        if (processesNumber == 0) {
            return;
        }

        int waitingTime = 0;
        int burstTime = processes.get(0).getBurstTime();

        processes.get(0).setWaitingTime(waitingTime); 

        for (int i = 1; i < processesNumber; i++) {
            processes.get(i).setWaitingTime(waitingTime + burstTime);
            waitingTime = processes.get(i).getWaitingTime();
            burstTime = processes.get(i).getBurstTime();
        }
    }

    private void evaluateTurnAroundTime() {
        for (final var process : processes) {
            process.setTurnAroundTimeTime(process.getBurstTime() + process.getWaitingTime());
        }
    }
}
