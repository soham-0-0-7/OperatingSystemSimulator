package Project.questionOne;

import java.util.Comparator;

class ProcessComparator implements Comparator<Processes> {
    public int compare(Processes p1, Processes p2) {
        if (p1.remTime < p2.remTime) {return -1;}
        else if (p1.remTime > p2.remTime){return 1;}
        return 0;
    }
}