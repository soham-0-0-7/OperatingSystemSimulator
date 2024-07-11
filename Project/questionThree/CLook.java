package Project.questionThree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CLook {
    public void initGUI() {

        JFrame window1 = new JFrame();
        window1.setSize(800, 800);
        window1.setBackground(Color.pink);
        window1.setLayout(new GridLayout(4, 1));
        window1.setVisible(true);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //array list for storing the disctracks we need to reach
        ArrayList<Integer> discTracks = new ArrayList<>();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the number of tracks req. - ");
//        int size = scan.nextInt();

        JLabel l1 = new JLabel("Enter the tracks - (with , in between and no space)");
        l1.setBackground(Color.black);
        l1.setForeground(Color.black);
        l1.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

        JTextField tf1 = new JTextField(20);
        tf1.setBackground(Color.gray);
        tf1.setForeground(Color.blue);
        tf1.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 16));
//        String str1 = scan.nextLine();
////        String[] str1Array = str1.split(",");
//        for(String s : str1Array){
//            int x = Integer.parseInt(s);
//            discTracks.add(x);
//        }
        // we take the input in form of a string with all the track numbers with , in between and then
        // store them in the arraylist disctracks by converting the splitted string into integer

        JLabel l2 = new JLabel("Enter the start position");
        l2.setBackground(Color.black);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
        JTextField tf2 = new JTextField(20);
        tf2.setBackground(Color.gray);
        tf2.setForeground(Color.black);
        tf2.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 16));

        //  we take the start position of the read write head
        boolean isInIt = false;
        int start;
//        start = scan.nextInt();

        JLabel l3 = new JLabel("Enter time for moving 1 track (in ns)");
        l3.setBackground(Color.black);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
        JTextField tf3 = new JTextField(20);
        tf3.setBackground(Color.gray);
        tf3.setForeground(Color.blue);
        tf3.setFont(new Font("Segoe UI Variable ", Font.PLAIN, 16));
//        System.out.println()/
//         time for the head to move 1 track
//        float singlleSeek = scan.nextFloat();

//        boolean greaterToLesser;

        // the question may mention to move towards greater first or lesser first we accordingly
        // ask the user to mention it
//        System.out.println("Enter 1 if we want to go greater first else 0");

        JButton b1 = new JButton("Greater First");
        b1.setForeground(Color.black);
        b1.setBackground(Color.red);
        b1.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));
        JButton b2 = new JButton("Lesser First");
        b2.setForeground(Color.black);
        b2.setBackground(Color.red);
        b2.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p1.setBackground(Color.pink);
        p2.setBackground(Color.pink);
        p3.setBackground(Color.pink);
        p4.setBackground(Color.pink);

        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());

        p1.add(l1);p1.add(tf1);
        p2.add(l2);p2.add(tf2);
        p3.add(l3);p3.add(tf3);
        p4.add(b1);p4.add(b2);

        window1.add(p1);
        window1.add(p2);
        window1.add(p3);
        window1.add(p4);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discTracks.clear();
                JFrame window2 = new JFrame();
                window2.setSize(300, 300);
                window2.setBackground(Color.pink);
                window2.setLayout(new GridLayout(3, 1));
                window2.setVisible(true);
                window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String str1 = tf1.getText();
                String[] str1Array = str1.split(",");

                for(String s : str1Array){
                    int x = Integer.parseInt(s);
                    discTracks.add(x);
                }

                int start = Integer.parseInt(tf2.getText());

                int singlleSeek = Integer.parseInt(tf3.getText());

                int total = 0; // this will store the total tracks moved
                Collections.sort(discTracks); // we sort the disc tracks in ascending order
//                JLabel l4 = new JLabel("The order : ");
//                l4.setBackground(Color.black);
//                l4.setForeground(Color.black);
//                l4.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                String s = "";
                total += (discTracks.get(discTracks.size() - 1) - start);
                // first we move from start position
                // to greatest track so we add their difference
                // (last element is the greatest one)


//                System.out.println(total);
                total += (discTracks.get(discTracks.size() - 1) - discTracks.get(0));
                // then we move from greatest track(last element)
                // to smallest track (first element) so we add their difference


//                System.out.println(total);
                boolean first = true; // this is defined to get the index of first track reached which will be handy later
                int f = 0; // will be assigned the index of first track

                for (int r : discTracks) {
                    if (r >= start) {
                        if (first) {
                            f = discTracks.indexOf(r);
                            first = false; // converted to false so no next track will assign its index
                        }
                        s += (Integer.toString(r) + " ");
                    }
                }

                // now we add the remaining traacks moved which is from the smallest
                // to the one preceeding the starting position
                // which lies before the first track whose index we have stored so it becomes
                // easy to calculate


                total += (discTracks.get(f - 1) - discTracks.get(0));
//                System.out.println(total);

                for (int r : discTracks) {
                    if (r < start) {
                        s += (Integer.toString(r) + " ");
                    }
                }

                JLabel l5 = new JLabel("The order : "+s);
                l5.setBackground(Color.black);
                l5.setForeground(Color.black);
                l5.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                // printing total by total tracks moved * time for moving a single track
                JLabel l6 = new JLabel("Total seek time is " + total * singlleSeek + "ns");
                l6.setBackground(Color.black);
                l6.setForeground(Color.black);
                l6.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));


                JLabel l7 = new JLabel("Total tracks travelled is " + total);
                l7.setBackground(Color.black);
                l7.setForeground(Color.black);
                l7.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));


//                JPanel p5 = new JPanel();
                JPanel p6 = new JPanel();
                JPanel p7 = new JPanel();
                JPanel p8 = new JPanel();
//
//                p5.setLayout(new FlowLayout(FlowLayout.CENTER));
                p6.setLayout(new FlowLayout(FlowLayout.CENTER));
                p7.setLayout(new FlowLayout(FlowLayout.CENTER));
                p8.setLayout(new FlowLayout(FlowLayout.CENTER));

//                p5.add(l4);
                p6.add(l5);
                p7.add(l6);
                p8.add(l7);

//                p5.setBackground(Color.pink);
                p6.setBackground(Color.pink);
                p7.setBackground(Color.pink);
                p8.setBackground(Color.pink);


                window2.add(p6);window2.add(p8); window2.add(p7);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discTracks.clear();
                JFrame window2 = new JFrame();
                window2.setSize(300, 300);
                window2.setBackground(Color.pink);
                window2.setLayout(new GridLayout(3, 1));
                window2.setVisible(true);
                window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String str1 = tf1.getText();
                String[] str1Array = str1.split(",");

                for(String s : str1Array){
                    int x = Integer.parseInt(s);
                    discTracks.add(x);
                }


                int start = Integer.parseInt(tf2.getText());

                int singlleSeek = Integer.parseInt(tf3.getText());

                int total = 0; // this will store the total tracks moved
                Collections.sort(discTracks , Collections.reverseOrder()); // we sort the disc tracks in ascending order
//                JLabel l4 = new JLabel("The order : ");
//                l4.setBackground(Color.black);
//                l4.setForeground(Color.black);
//                l4.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                String s = "";
                total += (start - discTracks.get(discTracks.size() - 1));
                // first we move from start position
                // to greatest track so we add their difference
                // (last element is the greatest one)


//                System.out.println(total);
                total += (discTracks.get(0) - discTracks.get(discTracks.size() - 1));
                // then we move from greatest track(last element)
                // to smallest track (first element) so we add their difference


//                System.out.println(total);
                boolean first = true; // this is defined to get the index of first track reached which will be handy later
                int f = 0; // will be assigned the index of first track

                for (int r : discTracks) {
                    if (r <= start) {
                        if (first) {
                            f = discTracks.indexOf(r);
                            first = false; // converted to false so no next track will assign its index
                        }
                        s += (Integer.toString(r) + " ");
                    }
                }

                // now we add the remaining traacks moved which is from the smallest
                // to the one preceeding the starting position
                // which lies before the first track whose index we have stored so it becomes
                // easy to calculate


                total += (discTracks.get(0) - discTracks.get(f-1));
//                System.out.println(total);

                for (int r : discTracks) {
                    if (r > start) {
                        s += (Integer.toString(r) + " ");
                    }
                }

                JLabel l5 = new JLabel("The order : " + s);
                l5.setBackground(Color.black);
                l5.setForeground(Color.black);
                l5.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));

                // printing total by total tracks moved * time for moving a single track
                JLabel l6 = new JLabel("Total seek time is " + total * singlleSeek + "ns");
                l6.setBackground(Color.black);
                l6.setForeground(Color.black);
                l6.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));


                JLabel l7 = new JLabel("Total tracks travelled is " + total);
                l7.setBackground(Color.black);
                l7.setForeground(Color.black);
                l7.setFont(new Font("Segoe UI Variable ", Font.BOLD, 16));


//                JPanel p5 = new JPanel();
                JPanel p6 = new JPanel();
                JPanel p7 = new JPanel();
                JPanel p8 = new JPanel();
//
//                p5.setLayout(new FlowLayout(FlowLayout.CENTER));
                p6.setLayout(new FlowLayout(FlowLayout.CENTER));
                p7.setLayout(new FlowLayout(FlowLayout.CENTER));
                p8.setLayout(new FlowLayout(FlowLayout.CENTER));

//                p5.add(l4);
                p6.add(l5);
                p7.add(l6);
                p8.add(l7);

//                p5.setBackground(Color.pink);
                p6.setBackground(Color.pink);
                p7.setBackground(Color.pink);
                p8.setBackground(Color.pink);


                window2.add(p6);window2.add(p8); window2.add(p7);
            }
        });
    }

    public static void main(String[] args) {
        CLook cl = new CLook();
        cl.initGUI();
    }
}
//        int y = 3;
//        while(y !=1 || y != 0) {
//            // we take the input if user enters anything other than 0
//            // user is asked to put an input again
//            y = scan.nextInt();
//            if (y == 1) { // for moving towards greater first
//                int total = 0; // this will store the total tracks moved
//                Collections.sort(discTracks); // we sort the disc tracks in ascending order
//                System.out.println("The order : ");
//
//                total += (discTracks.get(discTracks.size() - 1) - start);
//                // first we move from start position
//                // to greatest track so we add their difference
//                // (last element is the greatest one)
//
//
////                System.out.println(total);
//                total += (discTracks.get(discTracks.size() - 1) - discTracks.get(0));
//                // then we move from greatest track(last element)
//                // to smallest track (first element) so we add their difference
//
//
////                System.out.println(total);
//                boolean first = true; // this is defined to get the index of first track reached which will be handy later
//                int f = 0; // will be assigned the index of first track
//
//                for(int r : discTracks){
//                    if(r>=start){
//                        if(first){
//                            f = discTracks.indexOf(r);
//                            first = false; // converted to false so no next track will assign its index
//                        }
//                        System.out.print(r + " ");
//                    }
//                }
//
//                // now we add the remaining traacks moved which is from the smallest
//                // to the one preceeding the starting position
//                // which lies before the first track whose index we have stored so it becomes
//                // easy to calculate
//
//
//                total += (discTracks.get(f-1) - discTracks.get(0));
////                System.out.println(total);
//
//                for(int r : discTracks) {
//                    if (r < start) {
//                        System.out.print(r + " ");
//                    }
//                }
//
//                System.out.println();
//                // printing total by total tracks moved * time for moving a single track
//                System.out.println("Total seek time is " + total*singlleSeek + "ns");
//            } else if (y == 0) {
//
//                // the same in reverse
//                int total = 0;
//                Collections.sort(discTracks , Collections.reverseOrder()); // sorted in descnding order
//                System.out.println("The order : ");
//
//                total += (start - discTracks.get(discTracks.size() - 1));
//                // first we move from start position
//                // to smallest track so we add their difference
//                // (last element is the smallest one)
//
//
////                System.out.println(total);
//                total += (discTracks.get(0) - discTracks.get(discTracks.size() - 1));
//                // then we move from smallest track(last element)
//                // to greatest track (first element) so we add their difference
//
//
////                System.out.println(total);
//
//                boolean first = true; // same to store the index of first reached track to use later
//                int f = 0; // has the index
//
//                for(int r : discTracks){
//                    if(first){
//                        f = discTracks.indexOf(r);
//                        first = false;
//                    }
//                    if(r<=start){
//                        System.out.print(r + " ");
//                    }
//                }
//
//                total += (discTracks.get(0) - discTracks.get(f-1));
//                // now we add the remaining traacks moved which is from the greatest
//                // to the one succeeding the starting position
//                // which lies after the first track whose index we have stored so it becomes
//                // easy to calculate
//
//
////                System.out.println(total);
//
//                for(int r : discTracks) {
//                    if (r < start) {
//                        System.out.print(r + " ");
//                    }
//                }
//
//                System.out.println();
//                // printing total by total tracks moved * time for moving a single track
//                System.out.println("Total seek time is " + total*singlleSeek + "ns");
//            }
//            else {
//                System.out.println("Invalid value, enter again : ");
//            }
//        }
//    }
//}