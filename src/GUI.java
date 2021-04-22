import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {
    public static void main(String[] args) {

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
            result_char[i] = result.get(i).split(" ");
        }

        for (int i = 0; i < result_char.length; i++) {
            for (int j = 0; j < result_char[i].length; j++) {
                //System.out.printf("%s", result_char[i][j]);
                result_char[i][j] = result_char[i][j].replaceAll("[^a-zA-Z0-9]","");
            }
            //System.out.printf("\n");
        }

        ImageIcon ground = new ImageIcon("./resource/ground.png");
        ImageIcon tundra = new ImageIcon("./resource/tundra.png");
        ImageIcon mount = new ImageIcon("./resource/mount.png");
        ImageIcon sea = new ImageIcon("./resource/sea.png");
        ImageIcon invent_slot = new ImageIcon("./resource/inventory.png");
        //ImageIcon player = new ImageIcon("./resource/player.png");

        // FRAME
        JFrame window = new JFrame();
        window.setSize(1500, 750);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BUTTON
        JButton button_W = new JButton("W");
        button_W.setBounds(120, 100, 50, 50);
        window.add(button_W);

        JButton button_S = new JButton("S");
        button_S.setBounds(120, 160, 50, 50);
        window.add(button_S);

        JButton button_A = new JButton("A");
        button_A.setBounds(60, 160, 50, 50);
        window.add(button_A);

        JButton button_D = new JButton("D");
        button_D.setBounds(180, 160, 50, 50);
        window.add(button_D);

        JButton button_exec = new JButton("Execute Command");
        button_exec.setBounds(40, 300, 200, 25);
        window.add(button_exec);

        // PANEL
        JLayeredPane panel_Map = new JLayeredPane();
        panel_Map.setPreferredSize(new Dimension(900, 450));
        panel_Map.setLayout(null);

        /////

        //int counter = 0;
        for (int i = 0; i < result_char.length; i++) {
            for (int j = 0; j < result_char[i].length; j++) {
                JLabel label_Tile = new JLabel();
                label_Tile.setBounds(j * 32,i * 32,32,32);

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

                panel_Map.add(label_Tile);
                //counter++;
            }
        }

        /////

        JScrollPane panel_Map_Scrollpane = new JScrollPane(panel_Map);
        panel_Map_Scrollpane.setBounds(280,10,900,450);
        panel_Map_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Map_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Map_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Map_Scrollpane);

        JPanel panel_Info = new JPanel();
        panel_Info.setBounds(280, 470, 900, 230);
        panel_Info.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        window.add(panel_Info);

        JPanel panel_Input_Command = new JPanel();
        panel_Input_Command.setBounds(40, 325, 200, 50);
        window.add(panel_Input_Command);

        // TEXT FIELD
        JTextField text_field1 = new JTextField("", 17);
        panel_Input_Command.add(text_field1);

        JLayeredPane panel_Inventory_Engimon = new JLayeredPane();
        //panel_Inventory_Engimon.setBounds(1190,10,4 * 64, 5 * 64);
        //panel_Inventory_Engimon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Inventory_Engimon.setPreferredSize(new Dimension(4 * 64, 5 * 64));
        panel_Inventory_Engimon.setLayout(null);
        //window.add(panel_Inventory_Engimon);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label_new = new JLabel();
                label_new.setBounds(j * 64,i * 64,64,64);
                label_new.setIcon(invent_slot);
                panel_Inventory_Engimon.add(label_new);
            }
        }

        JScrollPane panel_Inventory_Engimon_Scrollpane = new JScrollPane(panel_Inventory_Engimon);
        panel_Inventory_Engimon_Scrollpane.setBounds(1190,10,270,340);
        panel_Inventory_Engimon_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Inventory_Engimon_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Inventory_Engimon_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Inventory_Engimon_Scrollpane);

        JLayeredPane panel_Inventory_Skill = new JLayeredPane();
        panel_Inventory_Skill.setPreferredSize(new Dimension(4 * 64, 5 * 64));
        panel_Inventory_Skill.setLayout(null);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label_new = new JLabel();
                label_new.setBounds(j * 64, i * 64, 64, 64);
                label_new.setIcon(invent_slot);
                panel_Inventory_Skill.add(label_new);
            }
        }

        JLabel label_z = new JLabel();
        label_z.setBounds(0,0,32,32);
        label_z.setIcon(ground);
        panel_Inventory_Skill.add(label_z);

        JScrollPane panel_Inventory_Skill_Scrollpane = new JScrollPane(panel_Inventory_Skill);
        panel_Inventory_Skill_Scrollpane.setBounds(1190,360,270,340);
        panel_Inventory_Skill_Scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_Inventory_Skill_Scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_Inventory_Skill_Scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(panel_Inventory_Skill_Scrollpane);

        window.show();

    }
}

