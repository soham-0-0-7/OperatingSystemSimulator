package Project.questionFour;

import Project.questionTwo.Philosopher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class PageReplacementFIFO {

    public static boolean doesContain(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    } // function to check whether an array has an element or not
    // array for storing the page reference numbers

    public void initGUI() {
        JFrame window1 = new JFrame();
        window1.setSize(500,500); window1.setBackground(Color.black); window1.setLayout(new GridLayout(3,1));
        ArrayList<Integer> pageRefs = new ArrayList<>();

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the number of tracks req. - ");
//        int size = scan.nextInt();

        JLabel l1 = new JLabel("Enter the pages - (with , in between and no space)");
        l1.setBackground(Color.black); l1.setForeground(Color.white); l1.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
//        window1.add(l1);
//        System.out.println("Enter the pages - (with , in between and no space)");

        JTextField tf1 = new JTextField(30);
        tf1.setBackground(Color.gray); tf1.setForeground(Color.blue); tf1.setFont(new Font("Candara", Font.PLAIN, 16));
//        String str1 = scan.nextLine();
//        String[] str1Array = str1.split(",");
        // we enter the input references with commas in between and then we split it into
        // an array of its substrings giving us individual page references and convert those to integer

        JLabel l2 = new JLabel("Enter the frames available for this process");
        l2.setBackground(Color.black); l2.setForeground(Color.white); l2.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
//        window1.add(l1);
//        System.out.println("Enter the pages - (with , in between and no space)");

        JTextField tf2 = new JTextField(30);
        tf2.setBackground(Color.gray); tf2.setForeground(Color.blue); tf2.setFont(new Font("Candara", Font.PLAIN, 14));

        JButton b1 = new JButton("Proceed");
        b1.setForeground(Color.black); b1.setBackground(Color.yellow); b1.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

        //        System.out.println("Enter the number of frames available for this process - ");
//        int size = scan.nextInt(); // taking total frames for th process


        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(l1); p1.add(tf1);
        p2.add(l2); p2.add(tf2);
        p3.add(b1);

        p1.setBackground(Color.black); p2.setBackground(Color.black); p3.setBackground(Color.black);
        window1.add(p1); window1.add(p2);window1.add(p3);
        window1.setVisible(true);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = tf1.getText();
                String[] str1Array = str1.split(",");
                int size = Integer.parseInt(tf2.getText());
                int[] virtualMemory = new int[size];
                for (int i = 0; i < size; i++) {
                    virtualMemory[i] = (-1);
                } // adding -1 to represent empty frames
                for (String s : str1Array) {
                    int x = Integer.parseInt(s);
                    pageRefs.add(x);
                }
                // total inputtedpages for later use
                int S = pageRefs.size();
                int misses = 0, hits = 0;

                JFrame window2 = new JFrame();
                window2.setLayout(new FlowLayout());  window2.setSize(500,500); window2.getContentPane().setBackground(Color.darkGray);

                JLabel l3 = new JLabel("The solution - ");
                l3.setBackground(Color.black); l3.setForeground(Color.white); l3.setFont(new Font("Segoe UI Variable ", Font.BOLD, 25));

                JTextArea ta1 = new JTextArea(15,30);
                ta1.setBackground(Color.gray); ta1.setForeground(Color.blue); ta1.setFont(new Font("Candara", Font.PLAIN, 14));
                JScrollPane js = new JScrollPane(ta1);
//                System.out.println("The solution - ");
                int ref = 0; // for adding references in the memory i.e it has the index of first entered page

                String s = "";

                for (int x : pageRefs) {
                    if (doesContain(virtualMemory, x)) { // if memory has the page already i.e a hit
                        hits++;
//                for(int z = 0; z<virtualMemory.length; z++){
//                    if(virtualMemory[z] == x){
//                        virtualMemory[z] = x;
//                    } // replacing the same page
//                }
//                System.out.println(x);
//                System.out.println("hits - " + hits);
//                System.out.println("Misses - " + misses);
//                Iterator<Integer> itr = virtualMemory.iterator();
//                Iterator iT = virtualMemory.iterator();
                        for (int z : virtualMemory) {
                            s+= Integer.toString(z) + ",";
                        } // printing the pages in memory
                        s+="hit\n";
                    } else if (!doesContain(virtualMemory, x)) {

                        // replacing the first page to new one
                        virtualMemory[ref] = x;
                        if (ref == size-1) {
                            ref = 0; // if its greates than size than make it 0
                        } else {
                            ref++; // going to next new page
                        }
                        misses++;
//                System.out.println(x);
//                System.out.println("hits - " + hits);
//                System.out.println("Misses - " + misses);
//                Iterator<Integer> itr = virtualMemory.iterator();
//                Iterator iT = virtualMemory.iterator();

                        for (int z : virtualMemory) {
                            s+=(z) + ",";
                        } // printing the m=pages in memory
                        s+="miss\n";
                    }
                }
//        System.out.println(hits +" " + misses);

                ta1.setText(s);
                float hitP = (((float) hits / (float) S)) * 100; // calculating hit and miss percentages
                float missP = (((float) misses / (float) S)) * 100;
                JLabel l4 = new JLabel("Miss percentage - " + Float.toString(missP));
                JLabel l5 = new JLabel("Hit percentage - " + Float.toString(hitP));
                l4.setBackground(Color.darkGray); l4.setForeground(Color.red); l4.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
                l5.setBackground(Color.darkGray); l5.setForeground(Color.red); l5.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                JLabel l6 = new JLabel("Total miss - " + misses);
                JLabel l7 = new JLabel("Total hits - " + hits);
                l6.setBackground(Color.darkGray); l6.setForeground(Color.red); l6.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
                l7.setBackground(Color.darkGray); l7.setForeground(Color.red); l7.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                JPanel p4 = new JPanel();
                JPanel p5 = new JPanel();
                JPanel p6 = new JPanel();
                JPanel p7 = new JPanel();
                JPanel p8 = new JPanel();
                JPanel p9 = new JPanel();
                p4.setBackground(Color.darkGray);p5.setBackground(Color.darkGray);p6.setBackground(Color.darkGray);
                p7.setBackground(Color.darkGray);p8.setBackground(Color.darkGray);p9.setBackground(Color.darkGray);

                p4.setLayout(new FlowLayout(FlowLayout.CENTER)); p5.setLayout(new FlowLayout(FlowLayout.CENTER)); p6.setLayout(new FlowLayout(FlowLayout.CENTER)); p7.setLayout(new FlowLayout(FlowLayout.CENTER));
                p4.add(l3); p5.add(new JScrollPane(js)); p6.add(l4); p7.add(l5); p8.add(l6); p9.add(l7);
                window2.add(p4);window2.add(p5);window2.add(p8);window2.add(p9);window2.add(p6);window2.add(p7);
                window2.setVisible(true); window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }

    public static void main(String[] args) {
        PageReplacementFIFO n = new PageReplacementFIFO();
        n.initGUI();
    }
}



