package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Client implements ActionListener {
    JTextField text;
    static JPanel a1;
    static DataOutputStream dout;
    static JFrame f = new JFrame();
    static JScrollPane scrollPane;

    Client() {
        f.setLayout(null);

        // Header Panel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);

        // Back Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel back = new JLabel(new ImageIcon(i2));
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        // Profile Picture
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JLabel profile = new JLabel(new ImageIcon(i5));
        profile.setBounds(40, 10, 50, 50);
        profile.setBorder(new LineBorder(Color.WHITE, 2, true));
        p1.add(profile);

        // Contact Name and Status
        JLabel name = new JLabel("Bablu");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        p1.add(status);

        // Video Call Button
        ImageIcon videoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image videoImg = videoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel videoCall = new JLabel(new ImageIcon(videoImg));
        videoCall.setBounds(300, 20, 30, 30); // Adjust the bounds to align and set the size
        p1.add(videoCall);

        // Voice Call Button
        ImageIcon voiceIcon = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image voiceImg = voiceIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel voiceCall = new JLabel(new ImageIcon(voiceImg));
        voiceCall.setBounds(350, 20, 30, 30); // Adjust the bounds to align and set the size
        p1.add(voiceCall);

        // More Options Button
        ImageIcon moreIcon = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image moreImg = moreIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel moreOptions = new JLabel(new ImageIcon(moreImg));
        moreOptions.setBounds(400, 20, 30, 30); // Adjust the bounds to align and set the size
        p1.add(moreOptions);

        // Chat Area
        a1 = new JPanel();
        a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
        a1.setBackground(new Color(236, 229, 221));

        scrollPane = new JScrollPane(a1);
        scrollPane.setBounds(5, 75, 440, 470);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        f.add(scrollPane);

        // Input Field
        text = new JTextField();
        text.setBounds(5, 550, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        text.setBorder(new LineBorder(new Color(7, 94, 84), 1, true));
        text.setBackground(Color.WHITE);
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(320, 550, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        send.addActionListener(this);
        f.add(send);

        f.setSize(450, 600);
        f.setLocation(800, 30);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText().trim();
            if (!out.isEmpty()) {
                JPanel p2 = formatLabel(out);

                JPanel right = new JPanel(new BorderLayout());
                right.add(p2, BorderLayout.LINE_END);

                a1.add(right);
                a1.add(Box.createVerticalStrut(15)); // Add space between messages

                text.setText(""); // Clear input field

                dout.writeUTF(out);

                f.repaint();
                f.invalidate();
                f.validate();

                // Auto-scroll to the bottom
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width:200px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(220, 248, 198));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(10, 15, 10, 50));
        panel.add(output);

        JLabel time = new JLabel(new SimpleDateFormat("HH:mm").format(new Date()));
        time.setFont(new Font("SAN_SERIF", Font.PLAIN, 12));
        time.setForeground(Color.GRAY);
        panel.add(time);

        return panel;
    }

    public static void main(String[] args) {
        new Client();
        try {
            Socket s = new Socket("127.0.0.1", 6001);
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (true) {
                String msg = din.readUTF();
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);

                a1.add(left);
                a1.add(Box.createVerticalStrut(15)); // Add space between messages

                f.validate();

                // Auto-scroll to the bottom
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
