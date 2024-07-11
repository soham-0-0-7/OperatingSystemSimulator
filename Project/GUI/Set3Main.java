package Project.GUI;

import Project.questionFour.PageReplacementFIFO;
import Project.questionOne.ProcessPriorityQueue;
import Project.questionThree.CLook;
import Project.questionTwo.DiningTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Set3Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("OS Mini Simulator");

        ImageIcon img = new ImageIcon("C:\\Users\\soham\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-03-20 154258.png");
        window.setIconImage(img.getImage());

        window.setLayout(new GridLayout(5,1));
        JLabel header = new JLabel("Select the problem");
        header.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 30));
        header.setForeground(Color.RED);

        JPanel p = new JPanel(new FlowLayout());
        p.add(header);
        p.setBackground(Color.BLACK);

        JPanel pn1 = new JPanel(new FlowLayout());
        JPanel pn3 = new JPanel(new FlowLayout());
        JPanel pn4 = new JPanel(new FlowLayout());
        JPanel pn2 = new JPanel(new FlowLayout());

        JButton q1 = new JButton("Shortest Job First algo");
        JButton q2 = new JButton("Dining Philosophers problem");
        JButton q3 = new JButton("CLook disc scheduling algo");
        JButton q4 = new JButton("FIFO Page Replacement algo");
        q1.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
        q4.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
        q2.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
        q3.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 14));
        q1.setBackground(Color.DARK_GRAY);
        q2.setBackground(Color.DARK_GRAY);
        q3.setBackground(Color.DARK_GRAY);
        q4.setBackground(Color.DARK_GRAY);
        q1.setForeground(Color.WHITE);
        q3.setForeground(Color.WHITE);
        q2.setForeground(Color.WHITE);
        q4.setForeground(Color.WHITE);


        q1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProcessPriorityQueue pq = new ProcessPriorityQueue();
                pq.ProcessesGUI();
            }
        });

        q2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiningTable dt = new DiningTable();
                try {
                    dt.initGUI();
                } catch (InterruptedException ex) {} catch (IOException ex) {}
            }
        });

        q3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLook cl = new CLook();
                cl.initGUI();
            }
        });

        q4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PageReplacementFIFO prf = new PageReplacementFIFO();
                prf.initGUI();
            }
        });

        pn1.add(q1); pn2.add(q2); pn3.add(q3); pn4.add(q4);

        window.setBackground(Color.BLACK);
        pn1.setBackground(Color.BLACK);
        pn2.setBackground(Color.BLACK);
        pn4.setBackground(Color.BLACK);
        pn3.setBackground(Color.BLACK);

        window.add(p);window.add(pn1); window.add(pn2); window.add(pn3); window.add(pn4);

        window.setSize(600, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
    }
}
