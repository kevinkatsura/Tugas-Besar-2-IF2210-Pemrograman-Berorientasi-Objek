import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {
    public static int P_X = 0;
    public static int P_Y = 0;

    public static void main(String[] args) {
        // ### AWAL INISIALISASI
        ArrayList<String> result = new ArrayList<>();

        try (FileReader f = new FileReader("./assets/map.txt")) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    result.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        } catch (IOException e) {

        }

        String[][] result_char = new String[result.size()][result.get(0).length()];

        for (int i = 0; i < result.size(); i++) {
            result_char[i] = result.get(i).split("\t");
        }

        for (int i = 0; i < result_char.length; i++) {
            for (int j = 0; j < result_char[i].length; j++) {
                result_char[i][j] = result_char[i][j].replaceAll("[^a-zA-Z0-9]","");
            }
        }

        ImageIcon ground = new ImageIcon("./resource/MAP/ground.png");
        ImageIcon tundra = new ImageIcon("./resource/MAP/tundra.png");
        ImageIcon mount = new ImageIcon("./resource/MAP/mount.png");
        ImageIcon sea = new ImageIcon("./resource/MAP/sea.png");
        ImageIcon invent_slot = new ImageIcon("./resource/INV/inventory.png");
        ImageIcon player = new ImageIcon("./resource/PLAYER/player.png");
        ImageIcon map = new ImageIcon("./resource/TEXT/map.png");
        ImageIcon inventory_text = new ImageIcon("./resource/TEXT/inventory_text.png");

        ImageIcon pikachu = new ImageIcon("./resource/ENGI_ICON/pikachu.png");
        // ### AKHIR INISIALISASI

        // ### AWAL FRAME
        JFrame window = new JFrame();
        window.setSize(1500, 725);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Engimon's Bizzare Adventure");
        // ### AKHIR FRAME

        // ### AWAL MAP
        JPanel panel_Label_Map = new JPanel();
        panel_Label_Map.setBounds(280,515,110,40);
        window.add(panel_Label_Map);

        JLabel label_Map = new JLabel();
        label_Map.setIcon(map);
        panel_Label_Map.add(label_Map);

        JLayeredPane panel_Map = new JLayeredPane();
        panel_Map.setPreferredSize(new Dimension(26 * 64, 26 * 64));
        panel_Map.setLayout(null);

        JLabel label_Player = new JLabel();
        label_Player.setBounds(P_X * 64,P_Y * 64,64,64);
        label_Player.setIcon(player);
        panel_Map.add(label_Player,1);

        /////

        for (int i = 0; i < result_char.length; i++) {
            for (int j = 0; j < result_char[i].length; j++) {
                JLabel label_Tile = new JLabel();
                label_Tile.setBounds(j * 64,i * 64,64,64);

                if (result_char[i][j].equals("G")) {
                    label_Tile.setIcon(ground);
                } else if (result_char[i][j].equals("M")) {
                    label_Tile.setIcon(mount);
                } else if (result_char[i][j].equals("S")) {
                    label_Tile.setIcon(sea);
                } else if (result_char[i][j].equals("T")) {
                    label_Tile.setIcon(tundra);
                } else {
                    System.out.printf("%s", result_char[i][j]);
                }

                panel_Map.add(label_Tile, -1);
            }
        }

        /////

        JButton button_W = new JButton("W");
        button_W.setBounds(690, 540, 50, 50);
        button_W.setActionCommand("comm_W");
        button_W.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                P_Y--;
                label_Player.setLocation(P_X * 64,P_Y * 64);
            }
        });
        window.add(button_W);

        JButton button_S = new JButton("S");
        button_S.setBounds(690, 600, 50, 50);
        button_S.setActionCommand("comm_S");
        button_S.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                P_Y++;
                label_Player.setLocation(P_X * 64,P_Y * 64);
            }
        });
        window.add(button_S);

        JButton button_A = new JButton("A");
        button_A.setBounds(630, 600, 50, 50);
        button_A.setActionCommand("comm_A");
        button_A.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                P_X--;
                label_Player.setLocation(P_X * 64,P_Y * 64);
            }
        });
        window.add(button_A);

        JButton button_D = new JButton("D");
        button_D.setBounds(750, 600, 50, 50);
        button_D.setActionCommand("comm_D");
        button_D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                P_X++;
                label_Player.setLocation(P_X * 64,P_Y * 64);
            }
        });
        window.add(button_D);

        /////

        JScrollPane panel_Map_Scrollpane = new JScrollPane(panel_Map);
        panel_Map_Scrollpane.setBounds(280,10,900,500);
        panel_Map_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Map_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Map_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Map_Scrollpane);

        // ### AKHIR MAP

        // ### AWAL EXEC
        JButton button_exec = new JButton("Execute Command");
        button_exec.setBounds(40, 500, 200, 25);
        window.add(button_exec);

        JPanel panel_Info = new JPanel();
//        panel_Info.setBounds(280, 470, 900, 230);
//        panel_Info.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        window.add(panel_Info);

        JScrollPane panel_Info_Scrollpane = new JScrollPane(panel_Info);
        panel_Info_Scrollpane.setBounds(15, 10, 250, 475);
        panel_Info_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Info_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Info_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Info_Scrollpane);

        JTextArea ta_info = new JTextArea("");
        ta_info.setLineWrap(true);
        ta_info.setColumns(20);
        ta_info.setRows(28);
        panel_Info.add(ta_info);

//        ta_info.setText("This is a sample text This is a sample text This is a sample text");
//        ta_info.append("This is a sample text");

        JPanel panel_Input_Command = new JPanel();
        panel_Input_Command.setBounds(40, 535, 200, 50);
        window.add(panel_Input_Command);

        JTextField text_field1 = new JTextField("", 17);
        panel_Input_Command.add(text_field1);

        // ### AKHIR EXEC

        // ### AWAL INVENTORY
        JPanel panel_Inventory_Text = new JPanel();
        panel_Inventory_Text.setBounds(1195,150,250,40);
        window.add(panel_Inventory_Text);

        JLabel label_Inventory = new JLabel();
        label_Inventory.setIcon(inventory_text);
        panel_Inventory_Text.add(label_Inventory);

        JLayeredPane panel_Inventory = new JLayeredPane();
        //panel_Inventory.setBounds(1190,10,4 * 64, 5 * 64);
        //panel_Inventory.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Inventory.setPreferredSize(new Dimension(4 * 64, 5 * 64));
        panel_Inventory.setLayout(null);
        //window.add(panel_Inventory);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label_new = new JLabel();
                label_new.setBounds(j * 64,i * 64,64,64);
                label_new.setIcon(invent_slot);
                panel_Inventory.add(label_new);
            }
        }

        JScrollPane panel_Inventory_Scrollpane = new JScrollPane(panel_Inventory);
        panel_Inventory_Scrollpane.setBounds(1195,200,270,340);
        panel_Inventory_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Inventory_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Inventory_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Inventory_Scrollpane);
        // ### AKHIR INVENTORY

        // ### TESTING
        JLabel pika = new JLabel();
        pika.setBounds(64,64,64,64);
        pika.setIcon(pikachu);
        panel_Map.add(pika,3);

        // ### AWAL MAIN MENU
        JButton button_main_menu = new JButton("Main Menu");
        button_main_menu.setBounds(1225, 10, 200, 25);
        button_main_menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                Main_Menu.main(args);
            }
        });
        window.add(button_main_menu);
        // ### AKHIR MAIN MENU

        // ### AWAL SAVE
        JButton button_save = new JButton("Save");
        button_save.setBounds(1225, 45, 200, 25);
        window.add(button_save);
        // ### AKHIR SAVE

        // ### AWAL EXIT
        JButton button_exit = new JButton("Exit");
        button_exit.setBounds(1225, 80, 200, 25);
        button_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        window.add(button_exit);
        // ### AKHIR EXIT

        window.show();
    }
}

