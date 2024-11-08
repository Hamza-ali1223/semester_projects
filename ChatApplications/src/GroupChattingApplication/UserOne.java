package GroupChattingApplication;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class UserOne implements ActionListener,Runnable
{
    //Global Declarations (Frame, DataOutputStream, Box, JPanel, JTextField, JLabel, JButton)

    static  JFrame f2 = new JFrame();
    JTextField t1;
    static Box vertical = Box.createVerticalBox();
     JPanel a1;
     JPanel panel1;
    JLabel back, pfp, video, PHone, More_Options, Name_tag;
    JButton Send;
    BufferedWriter writer;
    BufferedReader reader;

    UserOne()   // Constructor helps in instantiating objects of Global declarations and Furthermore, it helps in setting up the GUI
    {
        panel1 = new JPanel();
        f2.setLayout(null);
        panel1.setBackground(new Color(7, 94, 84));
        panel1.setBounds(0, 0, 450, 80);

        //First Icon (Back Arrow)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\3.png"));
        Image backarrow = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon downscale_arrow_icon = new ImageIcon(backarrow);
        back = new JLabel(downscale_arrow_icon);
        back.setBounds(5, 20, 25, 25);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ME) {
                System.exit(0);
            }
        }); //MouseActionEvent for closing the frame

        //Second Icon (Profile Picture)
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons\\1.png"));
        Image PFP = i2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon PFPs = new ImageIcon(PFP);
        pfp = new JLabel(PFPs);
        pfp.setBounds(40, 10, 50, 50);

        //Third Icon (Video Icon)
        ImageIcon vid = new ImageIcon(ClassLoader.getSystemResource("icons\\video.png"));
        Image Vid = vid.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon Vids = new ImageIcon(Vid);
        video = new JLabel(Vids);
        video.setBounds(300, 20, 25, 25);

        //Fourth Icon (Phone Icon)
        ImageIcon P = new ImageIcon(ClassLoader.getSystemResource("icons\\phone.png"));
        Image Phone = P.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon Phones = new ImageIcon(Phone);
        PHone = new JLabel(Phones);
        PHone.setBounds(360, 20, 25, 25);

        //Fifth Icon (More Options)
        ImageIcon MO = new ImageIcon(ClassLoader.getSystemResource("icons\\3icon.png"));
        Image Mo = MO.getImage().getScaledInstance(20, 22, Image.SCALE_SMOOTH);
        ImageIcon mo = new ImageIcon(Mo);
        More_Options = new JLabel(mo);
        More_Options.setBounds(410, 20, 20, 22);

        //Name Tag
        Name_tag = new JLabel("Shahzaib");
        Name_tag.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        Name_tag.setForeground(Color.white);
        Name_tag.setBounds(110, 20, 100, 20);

        //Status Tag
        JLabel status = new JLabel("Ali, Wahaj,Idrees,Shahzaib,Furqan");
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        status.setForeground(Color.white);
        status.setBounds(110, 45, 160, 20);
        panel1.add(status);

        //Frame Additions
        a1 = new JPanel();
        a1.setBounds(3, 80, 440, 550);
        a1.setLayout(new BorderLayout());
        a1.setBackground(Color.white);
        f2.add(a1);

        t1 = new JTextField();
        t1.setBounds(5, 630, 310, 40);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f2.add(t1);

        //Send Button
        Send = new JButton("Send");
        Send.setBounds(320, 630, 120, 40);
        Send.setBackground(new Color(7, 94, 84));
        Send.setForeground(Color.white);
        Send.addActionListener(this);
        f2.add(Send);

        //Panel Additions

        panel1.add(back);
        panel1.add(pfp);
        panel1.add(video);
        panel1.add(PHone);
        panel1.add(More_Options);
        panel1.add(Name_tag);
        panel1.setLayout(null);

        //Frame Settings
        f2.setTitle("UserOne");
        f2.setSize(450, 710);
        f2.setLocation(200, 0);
        f2.add(panel1);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.getContentPane().setBackground(Color.white);
        f2.setVisible(true);

        //Socket Connection
        try {
            Socket s = new Socket("localhost",6000);
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        } catch (IOException e) {
            e.toString();
        }


    }

    public static void main(String []args) //This Main Method Does the Job of Instantiating the Client Object and also helps in setting up the Socket Connection
    {
        UserOne s1 = new UserOne();
        Thread u1 = new Thread(s1);
        u1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String out =  "<html><p>" + "Shahzaib"+ "</p><p>" + t1.getText() + "</p></html>";
            JPanel p2 = FormatLabel(out);
            JPanel right = new JPanel(new BorderLayout());
            right.setBackground(Color.white);
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
	        a1.add(vertical, BorderLayout.PAGE_START);
            try {
                writer.write(out);
                writer.write("\r\n");
                writer.flush();
            } catch (IOException ex) {
                ex.toString();
            }
           
            t1.setText("");
            f2.repaint();
            f2.invalidate();
            f2.validate();


            {

            }



    }

    //This Method is used to Format the Label and also to set the Time Stamp
    public static JPanel FormatLabel(String jout)
    {
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));

        JLabel l2 = new JLabel("<html><p style= \"width: 150px\">" + jout + "</p></html>");

        //Time Stamp
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(dateFormat.format(calendar.getTime()));

        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        l2.setBackground(new Color(37, 211, 102));
        l2.setOpaque(true);
        l2.setBorder(new EmptyBorder(0, 15, 0, 50));

        p3.add(l2);
        p3.add(time);
        p3.setBackground(Color.white);
        return p3;
    }

    @Override
    public void run()
    {
        try
        {
            String msg= "";
            while(true)
            {
                msg= reader.readLine();
                JPanel msgpanel = FormatLabel(msg);
                JPanel left = new JPanel(new BorderLayout());
                left.setBackground(Color.white);
                left.add(msgpanel, BorderLayout.LINE_START);
                vertical.add(left, BorderLayout.LINE_START);
                a1.add(vertical, BorderLayout.PAGE_START);
                f2.repaint();
                f2.invalidate();
                f2.validate();
            }
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
    }

}
