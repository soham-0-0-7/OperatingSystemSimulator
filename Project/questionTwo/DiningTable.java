package Project.questionTwo;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import javax.swing.*;
//import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
//import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class DiningTable {
    public int n;
//        Scanner scan  = new Scanner(System.in);
//        System.out.println("enter total philosophers");
//        int n = scan.nextInt();
////        int n = 5;

    public void initGUI() throws InterruptedException, IOException {
        JFrame window = new JFrame("Console test 2");

        ImageIcon img = new ImageIcon("C:\\Users\\soham\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-03-20 154657.png");
        window.setIconImage(img.getImage());

        window.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Number of philosophers");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.WHITE);
        panel1.add(label);
        JTextField text = new JTextField(3);
        panel1.add(text);
        panel1.setBackground(Color.BLACK);
        window.add(panel1);
        JButton button = new JButton("proceed");
        button.setBackground(Color.WHITE);

        text.setForeground(Color.BLACK); text.setBackground(Color.PINK);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Philosopher.textArea.selectAll();
                Philosopher.textArea.replaceSelection("");
                Philosopher.textArea.append("\n");
                n = Integer.parseInt(text.getText().trim());
                Semaphore[] chops = new Semaphore[n];
                Philosopher[] philosophers = new Philosopher[n];
//                    Philosopher.textArea.append(Integer.toString(n));
                for (int i = 0; i < n; i++) {
                    chops[i] = new Semaphore(1);
                }


//                for (int i = 0; i < n; i++) {
//                    try {
//                        philosophers[i] = new Philosopher(chops[i], chops[(i + 1) % n], i + 1);
//                    } catch (IOException ex) {}
//
//                }
//                Random rng = new Random();
//                int x = rng.nextInt(Math.abs(n));
//                Thread t2 = new Thread(philosophers[x]);
//                t2.start();
//                try {t2.join();} catch (InterruptedException ex) {}
//
//                for (int i = 0; i < n; i++) {
//                    if (i != x) {
//                        Thread t1 = new Thread(philosophers[i]);
//                        t1.start();
//                    }
//                }

                for (int i = 0; i < n; i++) {
                    try {
                        philosophers[i] = new Philosopher(chops[i], chops[(i + 1) % n], i + 1);
                    } catch (IOException ex) {}
                    new Thread((philosophers[i])).start();
                    try {
                        Thread.sleep(5);
                    } catch (Exception u){}
                }
            }
        });
        panel2.add(button);
        JScrollPane js = new JScrollPane(Philosopher.textArea);
        panel3.add(new JScrollPane(js));
        panel2.setBackground(Color.BLACK);
        panel3.setBackground(Color.BLACK);
        window.add(panel2);
        window.add(panel3);
        Philosopher.textArea.setBackground(Color.GRAY);
        Philosopher.textArea.setForeground(Color.BLUE);
        Philosopher.textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        window.setSize(800, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setVisible(true);
    }
//        if(allFinished(philosophers)) {
//            new Thread(philosophers[4]).start();
//        }


//        Thread.sleep(5000);
//        System.out.println(Philosopher.s)
    public static void main(String[] args) throws IOException, InterruptedException {
        DiningTable dt = new DiningTable();
        dt.initGUI();
    }
}


