package Project.questionTwo;

import javax.swing.*;
//import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private Random rng = new Random();
    public Semaphore leftChopstick, rightChopstick;
    public int id;

    public boolean isFull = false;

    public static JTextArea textArea = new JTextArea(20,50);

//    PrintStream stdout = System.out;


//    stdout.println("Starting gui for console output");
    // Still works
    // Stream for output to gui
//    GuiOutputStream rawout = new GuiOutputStream(textArea);


    // Set new stream for System.out

//    String file = "DiningPhilosopher.txt";
//    FileWriter fw = new FileWriter(file, true);
//    BufferedWriter bw = new BufferedWriter(fw);
//
//    public static String s = "";

        // if file doesnt exists, then create it
//        if (!file.exists()) {
//            file.createNewFile();
//        } else {
//
//        }

//    SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            // Update GUI components here
//            // For example, append text to a JTextArea
//            textArea.append("Your text here\n");
//        }
//    });

    public Philosopher(Semaphore leftChopstick, Semaphore rightChopstick, int id) throws IOException {

        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.id = id;
//        bw.write("kkk");
//        s+="done";
    }

    @Override
    public String toString() {
        return "Philosopher" + Integer.toString(this.id);
    }

    public void pickLeft() throws IOException {
//        System.setOut(new PrintStream(rawout, true));
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        System.out.println(this + ".pickleft");
        if(this.leftChopstick.availablePermits() != 1){
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append("  Philosopher" + Integer.toString(id) + " is waiting for his left Chopstick\n");
                }
            });

//            textArea.append(this + " is waiting for his left Chopstick\n");
        }
        try {
            leftChopstick.acquire();
        }catch (Exception e){}

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append("  Philosopher" + Integer.toString(id) + " holds his left chopstick\n");
            }
        });

//        textArea.append(this + " holds his left chopstick\n");
    }

    public void pickRight() throws IOException {
//        System.setOut(new PrintStream(rawout, true));
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        System.out.println(this + ".pickright");
        if(this.rightChopstick.availablePermits() != 1){

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append("  Philosopher" + Integer.toString(id) + " is waiting for his right Chopstick\n");
                }
            });

//            textArea.append(this + " is waiting for his right Chopstick\n");
        }

        try {
            rightChopstick.acquire();
        }catch (Exception e){}

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append("  Philosopher" + Integer.toString(id) + " holds his right chopstick\n");
            }
        });

//        textArea.append(this + " holds his right chopstick\n");
    }

    public void eat() throws IOException {
//        System.setOut(new PrintStream(rawout, true));
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        System.out.println(this + ".eat");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append("  Philosopher" + Integer.toString(id) + " is eating\n");
            }
        });


//        textArea.append(this + " is eating\n");
        try {
            Thread.sleep(rng.nextInt(100));
        } catch(Exception e){}
        this.isFull = true;
    }

    public void think() throws IOException {
//        System.setOut(new PrintStream(rawout, true));
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        System.out.println(this + ".think");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append("  Philosopher" + Integer.toString(id) + " is thinking\n");
            }
        });

//        textArea.append(this + " is thinking\n");
        try {
            Thread.sleep(rng.nextInt(100));
        } catch(Exception e){}
    }

    public void leave() throws IOException {
//        System.setOut(new PrintStream(rawout, true));
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append("  Philosopher" + Integer.toString(id) + " is done and releases his chopsticks\n");
            }
        });

//        textArea.append(this + " is done and releases his chopsticks\n");
        leftChopstick.release();
        rightChopstick.release();
    }


    public void run() {
//        System.out.println(this);
        while(!isFull){
            try {
                this.think();
                this.pickLeft();
                this.pickRight();
                this.eat();
                this.leave();
            } catch (IOException e) {
                System.out.println("Excption");
            }
        }
    }
}
