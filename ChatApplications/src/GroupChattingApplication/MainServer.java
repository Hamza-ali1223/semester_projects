package GroupChattingApplication;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class MainServer implements Runnable
{
    Socket socket;
   public static  Vector<BufferedWriter> Client = new Vector();
    MainServer(Socket socket)
    {
        try
        {
            this.socket = socket;
        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }
    @Override
    public void run()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Client.add(writer);
            while(true)
            {
                String msg = reader.readLine().trim();
                System.out.println("Received: " + msg);
               sendToAllClients(msg, writer);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    public static void main(String[] args) throws Exception
    {
        ServerSocket s = new ServerSocket(6000);

        JFrame f1 = new JFrame();
        f1.setSize(400, 400);
        f1.setLayout(null);
        f1.setVisible(true);


        JLabel l1 = new JLabel("Enter User Numbers You want to connect: min:2 max:5");
        l1.setBounds(50, 50, 350, 10);
        f1.add(l1);

        JTextField text1 = new JTextField();
        text1.setBounds(50, 100, 200, 50);
        f1.add(text1);

        JButton Ok = new JButton("OK");
        Ok.setSize(100, 50);
        Ok.setBounds(50, 150, 100, 50);

        f1.add(Ok);


        Ok.addActionListener(e -> {
            String text = text1.getText();
            if (text.equals("1") || text.equals("2") || text.equals("3")||text.equals("4")||text.equals("5")) {
                f1.setVisible(false);
                int numOfUsers = Integer.parseInt(text);
                System.out.println("Number of users: " + numOfUsers);
                System.out.println("code is running");
                switch (numOfUsers) {
                    case 5:
                        UserFive s5 = new UserFive();
                        Thread u5 = new Thread(s5);
                        u5.start();
                        // Fallthrough to start UserFour, UserThree, UserTwo and UserOne as well
                    case 4:
                        UserFour s4 = new UserFour();
                        Thread u4 = new Thread(s4);
                        u4.start();
                        // Fallthrough to start UserThree, UserTwo and UserOne as well
                    case 3:
                        UserThree s3 = new UserThree();
                        Thread u3 = new Thread(s3);
                        u3.start();
                        // Fallthrough to start UserTwo and UserOne as well
                    case 2:
                        UserTwo s2 = new UserTwo();
                        Thread u2 = new Thread(s2);
                        u2.start();
                        // Fallthrough to start UserOne as well
                    case 1:
                        UserOne s1 = new UserOne();
                        Thread u1 = new Thread(s1);
                        u1.start();
                        break;
                    default:
                        System.out.println("Invalid number of users. Please enter a number between 1 and 3.");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(f1, "Please enter a valid number (1, 2 or 3)");
            }

        }
        );
        while (true)
        {
            Socket socket= s.accept();
            MainServer server =new MainServer(socket);
            Thread t1 = new Thread(server);
            t1.start();
        }


    }
    private void sendToAllClients(String message, BufferedWriter senderWriter) {
        for (BufferedWriter bw : Client) {
            // Check if the current BufferedWriter is not the sender
            if (!bw.equals(senderWriter)) {
                try {
                    bw.write(message);
                    bw.write("\r\n");
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
