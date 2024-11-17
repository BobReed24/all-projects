package com.thealgorithms.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class LotteryScheduling {
    private LotteryScheduling() {
    }

    private List<Process> processes;
    private Random random;

    public LotteryScheduling(final List<Process> processes) {
        this.processes = processes;
        this.random = new Random();
    }

    public LotteryScheduling(final List<Process> processes, Random random) {
        this.processes = processes;
        this.random = random;
    }

    public List<Process> scheduleProcesses() {
        int totalTickets = processes.stream().mapToInt(Process::getTickets).sum();
        int currentTime = 0;
        List<Process> executedProcesses = new ArrayList<>();

        while (!processes.isEmpty()) {
            int winningTicket = random.nextInt(totalTickets) + 1;
            Process selectedProcess = selectProcessByTicket(winningTicket);

            if (selectedProcess == null) {
                
                System.err.println("Error: No process selected. Recalculating total tickets.");
                totalTickets = processes.stream().mapToInt(Process::getTickets).sum();
                continue;
            }

            selectedProcess.setWaitingTime(currentTime);
            currentTime += selectedProcess.getBurstTime();
            selectedProcess.setTurnAroundTime(selectedProcess.getWaitingTime() + selectedProcess.getBurstTime());

            executedProcesses.add(selectedProcess);
            processes.remove(selectedProcess);

            totalTickets = processes.stream().mapToInt(Process::getTickets).sum();
        }

        return executedProcesses;
    }

    private Process selectProcessByTicket(int winningTicket) {
        int ticketSum = 0;
        for (Process process : processes) {
            ticketSum += process.getTickets();
            if (ticketSum >= winningTicket) {
                return process;
            }
        }
        return null;
    }

    public static class Process {
        private String processId;
        private int burstTime;
        private int tickets;
        private int waitingTime;
        private int turnAroundTime;

        public Process(String processId, int burstTime, int tickets) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.tickets = tickets;
        }

        public String getProcessId() {
            return processId;
        }

        public int getBurstTime() {
            return burstTime;
        }

        public int getTickets() {
            return tickets;
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
