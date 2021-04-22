import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args) {

        char[][] map = new char[][]  {
                                {'G', 'G', 'G'},
                                {'M', 'S', 'M'},
                                {'T', 'T', 'T'}
                            };

        ImageIcon ground = new ImageIcon("./resource/ground.png");
        ImageIcon tundra = new ImageIcon("./resource/tundra.png");
        ImageIcon mount = new ImageIcon("./resource/mount.png");
        ImageIcon sea = new ImageIcon("./resource/sea.png");
        ImageIcon invent_slot = new ImageIcon("./resource/inventory.png");
        ImageIcon P = new ImageIcon("./resource/P.png");

        // FRAME
        JFrame frame1 = new JFrame();
        frame1.setSize(1500, 750);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BUTTON
        JButton button1 = new JButton("W");
        button1.setBounds(120, 100, 50, 50);
        frame1.add(button1);

        JButton button2 = new JButton("S");
        button2.setBounds(120, 160, 50, 50);
        frame1.add(button2);

        JButton button3 = new JButton("A");
        button3.setBounds(60, 160, 50, 50);
        frame1.add(button3);

        JButton button4 = new JButton("D");
        button4.setBounds(180, 160, 50, 50);
        frame1.add(button4);

        JButton button5 = new JButton("Execute Command");
        button5.setBounds(40, 300, 200, 25);
        frame1.add(button5);

        // PANEL
        JLayeredPane panel = new JLayeredPane();
        panel.setPreferredSize(new Dimension(900, 450));
        panel.setLayout(null);

        JLabel label_x = new JLabel();
        label_x.setBounds(0,0,32,32);
        label_x.setIcon(P);
        panel.add(label_x,0);

        JLabel label_y = new JLabel();
        label_y.setBounds(16,16,32,32);
        label_y.setIcon(ground);
        panel.add(label_y,1);

        JScrollPane pane = new JScrollPane(panel);
        pane.setBounds(280,10,900,450);
        pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame1.add(pane);

        JPanel panel2 = new JPanel();
        panel2.setBounds(280, 470, 900, 230);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame1.add(panel2);

        JPanel panel4 = new JPanel();
        panel4.setBounds(40, 325, 200, 50);
        frame1.add(panel4);

        JPanel panel3 = new JPanel();
        //panel3.setBounds(1190, 10, 270, 340);
        //panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel3.setPreferredSize(new Dimension(4 * 64, 5 * 64));
        panel3.setLayout(null);
        //frame1.add(panel3);

        /*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label_new = new JLabel();
                label_new.setBounds(j * 64,i * 64,64,64);
                label_new.setIcon(invent_slot);
                panel3.add(label_new);
            }
        }
        */

        JScrollPane pane1 = new JScrollPane(panel3);
        pane1.setBounds(1190,10,270,340);
        pane1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame1.add(pane1);

        JPanel panel5 = new JPanel();
        //panel5.setBounds(1190, 360, 270, 340);
        //panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel5.setPreferredSize(new Dimension(4 * 64, 5 * 64));
        panel5.setLayout(null);
        //frame1.add(panel5);

        /*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label_new = new JLabel();
                label_new.setBounds(j * 64,i * 64,64,64);
                label_new.setIcon(invent_slot);
                panel5.add(label_new);
            }
        }
        */

        JLabel label_z = new JLabel();
        label_z.setBounds(0,0,32,32);
        label_z.setIcon(ground);
        panel5.add(label_z);

        JScrollPane pane2 = new JScrollPane(panel5);
        pane2.setBounds(1190,360,270,340);
        pane2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame1.add(pane2);

        // TEXT FIELD
        JTextField text_field1 = new JTextField("", 17);
        panel4.add(text_field1);

        frame1.show();

    }
}

