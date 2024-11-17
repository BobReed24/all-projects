package com.thealgorithms.scheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class EDFScheduling {
    private EDFScheduling() {
    }

    private List<Process> processes;

    public EDFScheduling(final List<Process> processes) {
        this.processes = processes;
    }

    public List<Process> scheduleProcesses() {
        processes.sort(Comparator.comparingInt(Process::getDeadline));

        int currentTime = 0;
        List<Process> executedProcesses = new ArrayList<>();

        for (Process process : processes) {
            process.setWaitingTime(currentTime);
            currentTime += process.getBurstTime();
            process.setTurnAroundTime(process.getWaitingTime() + process.getBurstTime());

            if (currentTime > process.getDeadline()) {
                System.out.println("Warning: Process " + process.getProcessId() + " missed its deadline.");
            }

            executedProcesses.add(process);
        }

        return executedProcesses;
    }

    public static class Process {
        private String processId;
        private int burstTime;
        private int deadline;
        private int waitingTime;
        private int turnAroundTime;

        public Process(String processId, int burstTime, int deadline) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.deadline = deadline;
        }

        public String getProcessId() {
            return processId;
        }

        public int getBurstTime() {
            return burstTime;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getWaitingTime() {
            return waitingTime;
        }

        public void setWaitingTime(int waitingTime) {
            this.waitingTime = waitingTime;
        }

        public int getTurnAroundTime() {
            return turnAroundTime;
        }

        public void setTurnAroundTime(int turnAroundTime) {
            this.turnAroundTime = turnAroundTime;
        }
    }
}
