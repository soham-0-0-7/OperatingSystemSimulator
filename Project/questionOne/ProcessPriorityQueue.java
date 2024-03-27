package Project.questionOne;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;
import java.util.*;
public class ProcessPriorityQueue {
    PriorityQueue<Processes> processQueue = new PriorityQueue<>(new ProcessComparator());
    ArrayList<Processes> processesToBeInserted = new ArrayList<>();
    Queue<String> finishedProcesses = new LinkedList<>();
    Queue<Integer> finishedTimes = new LinkedList<>();
    Queue<String> finishedProcesses2 = new LinkedList<>();
    Queue<Integer> finishedTimes2 = new LinkedList<>();

    public int totalProcesses;


    public void ProcessesGUI(){

        JFrame window = new JFrame("Total processes");

        ImageIcon img = new ImageIcon("C:\\Users\\soham\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-03-20 154828.png");
        window.setIconImage(img.getImage());
        window.setLayout(new FlowLayout());
        JLabel label = new JLabel("Enter total number of processes");
        label.setForeground(Color.WHITE);
        JTextField number = new JTextField(5);
        JButton proceed = new JButton("proceed");
        proceed.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
        proceed.setBackground(Color.orange);
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        panel1.setBackground(Color.DARK_GRAY);
        panel2.setBackground(Color.DARK_GRAY);
        panel3.setBackground(Color.DARK_GRAY);
        panel1.add(label);
        panel2.add(number);
        panel3.add(proceed);
        window.add(panel1);
        window.add(panel2);
        window.add(panel3);
        window.setSize(600, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setVisible(true);
        proceed.setSize(10,10);

        number.setBackground(Color.PINK);
        number.setForeground(Color.BLACK);
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalProcesses = Integer.parseInt(number.getText().trim());
                JFrame window2 = new JFrame("process inserion");
                ImageIcon img = new ImageIcon("C:\\Users\\soham\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-03-20 154828.png");
                window2.setIconImage(img.getImage());

                window2.setBackground(Color.DARK_GRAY);
                window2.setLayout(new GridLayout(totalProcesses + 2 ,1));

                JLabel[] processNames = new JLabel[totalProcesses];
                JTextField[] arrivalTimes = new JTextField[totalProcesses];
                JTextField[] burstTimes = new JTextField[totalProcesses];

                JPanel p = new JPanel(new GridLayout(1,3));
                JPanel pp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JPanel pp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JPanel pp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

                pp1.setBackground(Color.DARK_GRAY); pp2.setBackground(Color.DARK_GRAY);
                pp3.setBackground(Color.DARK_GRAY); p.setBackground(Color.DARK_GRAY);

                JLabel l1 =new JLabel("Process - ");
                JLabel l2 =new JLabel("ArrivalTime - ");
                JLabel l3 =new JLabel("BurstTime - ");

                l1.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25)); l1.setForeground(Color.WHITE);
                l2.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25)); l2.setForeground(Color.WHITE);
                l3.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25)); l3.setForeground(Color.WHITE);

                l1.setForeground(Color.WHITE); l2.setForeground(Color.white); l3.setForeground(Color.white);
                pp1.add(l1); pp2.add(l2); pp3.add(l3); p.add(pp1); p.add(pp2); p.add(pp3); window2.add(p);

                for(int i = 0; i<totalProcesses; i++) {
                    JPanel newPanel = new JPanel(new GridLayout(1, 3));
                    JPanel ppp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

                    newPanel.setBackground(Color.DARK_GRAY);
                    ppp1.setBackground(Color.DARK_GRAY);

                    processNames[i] = new JLabel("Process" + Integer.toString(i + 1));
                    processNames[i].setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
                    processNames[i].setForeground(Color.WHITE);

                    arrivalTimes[i] = new JTextField(5);
                    arrivalTimes[i].setSize(5, 5);
                    burstTimes[i] = new JTextField(5);
                    burstTimes[i].setSize(5, 5);

                    JPanel pn = new JPanel(new FlowLayout());
                    JPanel pn2 = new JPanel(new FlowLayout());

                    pn.setBackground(Color.DARK_GRAY);
                    pn2.setBackground(Color.DARK_GRAY);
                    arrivalTimes[i].setBackground(Color.PINK);
                    arrivalTimes[i].setForeground(Color.BLACK);

//                    arrivalTimes[i].getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "ENTER");
//                    arrivalTimes[i].getActionMap().put("ENTER", enter);

                    burstTimes[i].setBackground(Color.PINK);
                    burstTimes[i].setForeground(Color.BLACK);

                    ppp1.add(processNames[i]);
                    pn.add(arrivalTimes[i]);
                    pn2.add(burstTimes[i]);
                    newPanel.add(ppp1);
                    newPanel.add(pn);
                    newPanel.add(pn2);
                    window2.add(newPanel);
                }
                JPanel p2 = new JPanel(new FlowLayout());
                JButton b = new JButton("proceed");

                b.setFont(new Font("Candara", Font.PLAIN, 14));
                p2.setBackground(Color.darkGray);
                b.setBackground(Color.GREEN); b.setForeground(Color.BLACK);

                p2.add((b)); window2.add(p2);
                window2.setSize(500, 500);
                window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window2.getContentPane().setBackground(Color.DARK_GRAY);
                window2.setVisible(true);
                b.setSize(10,10);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i = 0; i<totalProcesses; i++){

                            Processes p = new Processes(Integer.toString(i+1),
                                    Integer.parseInt(arrivalTimes[i].getText().trim()),
                                    Integer.parseInt(burstTimes[i].getText().trim()));

                            processesToBeInserted.add(p);
                        }
                        ShortestJobFirst();
                        JFrame window3 = new JFrame("answer SJF");

                        ImageIcon img = new ImageIcon("C:\\Users\\soham\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-03-20 154828.png");
                        window3.setIconImage(img.getImage());

                        window3.setBackground(Color.darkGray);
                        window3.setLayout(new GridLayout(totalProcesses+2, 1));
                        JLabel[] processNames2 = new JLabel[totalProcesses];
                        JLabel[] finishTimes2 = new JLabel[totalProcesses];
                        JPanel p3 = new JPanel(new GridLayout(1,2));
                        JPanel pppp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JPanel pppp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

                        p3.setBackground(Color.DARK_GRAY); pppp2.setBackground(Color.DARK_GRAY); pppp1.setBackground(Color.DARK_GRAY);

                        JLabel l4 =new JLabel("Process - ");
                        JLabel l5 =new JLabel("FinishTime - ");

                        l5.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25));
                        l4.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25));
                        l4.setForeground(Color.white); l5.setForeground(Color.white);

                        pppp1.add(l4); pppp2.add(l5); p3.add(pppp1); p3.add(pppp2); window3.add(p3);
                        for(int i = 0; i<totalProcesses; i++){
                            JPanel newPanel2 = new JPanel(new GridLayout(1,2));
                            newPanel2.setBackground(Color.DARK_GRAY);

                            processNames2[i] = new JLabel(finishedProcesses.remove());
                            processNames2[i].setSize(5,5);
                            processNames2[i].setForeground(Color.WHITE);
                            processNames2[i].setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));

                            finishTimes2[i] = new JLabel(Integer.toString(finishedTimes.remove()));
                            finishTimes2[i].setSize(5,5);
                            finishTimes2[i].setForeground(Color.WHITE);
                            finishTimes2[i].setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));

                            JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                            JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                            jp1.setBackground(Color.darkGray); jp2.setBackground(Color.darkGray);
                            jp1.add(processNames2[i]);
                            jp2.add(finishTimes2[i]);
                            newPanel2.add(jp1); newPanel2.add(jp2);
                            window3.add(newPanel2);
                        }
                        JPanel jpp = new JPanel(new GridLayout(2,1));
                        jpp.setBackground(Color.DARK_GRAY);
                        JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JLabel gc = new JLabel("Gantt Chart");
                        gc.setForeground(Color.white);
                        JLabel gc2 = new JLabel();
                        gc2.setText(ganttChart());
                        jp3.setBackground(Color.darkGray); jp4.setBackground(Color.darkGray);
                        gc.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
                        gc2.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
                        gc2.setForeground(Color.WHITE);
                        gc.setBackground(Color.WHITE);

                        jp3.add(gc); jp4.add(gc2); jpp.add(jp3); jpp.add(jp4); window3.add(jpp);

                        window3.setSize(700, 700);
                        window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        window3.getContentPane().setBackground(Color.BLACK);
                        window3.setVisible(true);
                    }
                });


            }
        });
    }

//    public void getProcesses(){
//        if(this.processesToBeInserted.isEmpty()){
//            System.out.println("Empty");
//            return;
//        } else{
//            System.out.println("not empty");
//        }
//        for(Processes p : this.processesToBeInserted){
//            System.out.println(p.toString());
//        }
//    }

    public void ShortestJobFirst(){
//        for(Processes p : processesToBeInserted){
//            System.out.println(p);
//        }
        Processes.resetTimer();

        Processes processToBeTreated = null;

        int size = processesToBeInserted.size();

        while(size!=0) {
            if(processToBeTreated!=null){
                if(processToBeTreated.remTime == 0){
//                    System.out.println(processToBeTreated.processName + " compeleted at time = " + Processes.timer);
                    finishedProcesses.add(processToBeTreated.processName); finishedProcesses2.add(processToBeTreated.processName);
                    finishedTimes.add(Processes.timer); finishedTimes2.add(Processes.timer);
                    processToBeTreated = null;
                    size--;
                }
            }
//            if(processQueue.peek()!=null) {
//                if (processQueue.peek().remTime == 0) {
//                    System.out.println(processQueue.peek().processName + " compeleted at time = " + Processes.timer);
//                    processQueue.remove();
//                    size--;
//                }
//            }

            for(Processes p : processesToBeInserted){
                if(p.arrTime == Processes.timer){
                    processQueue.add(p);
                }
            }

            if(processQueue.peek()!=null){
                if(processToBeTreated==null){
                    processToBeTreated = processQueue.remove();
                }
            }

            if(processToBeTreated!=null){
                processToBeTreated.remTime--;
            }

            Processes.timer++;
        }

//        for(String f : finishedProcesses){
//            System.out.println(f);
//        }
//        for(int i : finishedTimes){
//            System.out.println(i);
//        }
    }

    public String ganttChart(){
        String s = "  START  ";
        int y = 0;
        int x = 0;
        while(!finishedTimes2.isEmpty()){
            s+="[";
            x = finishedTimes2.peek();
            for(int i = 0; i<x-y;i++){
                s += "_";
            }
            s+="]";
            s+= " P"+finishedProcesses2.remove().replace("Process","");
            s+=",";
            s+= Integer.toString(x) + " ";

            y = finishedTimes2.remove();
        }

        s+= "  FINISH";
        return s;
    }

}


