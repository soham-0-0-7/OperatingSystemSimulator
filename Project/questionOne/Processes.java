package Project.questionOne;

public class Processes {
    public static int timer;
    public int arrTime;
    public int burstTime;

    public int remTime;
    public String processName;

    public static void resetTimer() {
        Processes.timer = 0;
    }

    public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
        this.remTime = burstTime;
    }

    public void setProcessName(String processName) {
        this.processName = "Process" + processName;
    }

    Processes(String processName, int arrTime, int burstTime){
        setArrTime(arrTime);
        setProcessName(processName);
        setBurstTime(burstTime);
    }

    @Override
    public String toString() {
        return "Processes{" +
                "arrTime=" + arrTime +
                ", burstTime=" + burstTime +
                ", remTime=" + remTime +
                ", processName='" + processName + '\'' +
                '}';
    }
}
