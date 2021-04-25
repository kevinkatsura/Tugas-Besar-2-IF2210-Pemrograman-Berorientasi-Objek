import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu {
    public static void main(String[] args) {
        ImageIcon title = new ImageIcon("./resource/TEXT/title.png");

        // ### AWAL FRAME
        JFrame window = new JFrame();
        window.setSize(500, 500);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Engimon's Bizzare Adventure");
        // ### AKHIR FRAME

        // ### AWAL TITLE
        JLabel label_Title = new JLabel();
        label_Title.setIcon(title);
        label_Title.setBounds(113,60,274,97);
        window.add(label_Title);
        // ### AKHIR TITLE

        // ### AWAL NEW GAME
        JButton button_new = new JButton("New Game");
        button_new.setBounds(150, 190, 200, 25);
        button_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                GUI.main(args);
            }
        });
        window.add(button_new);
        // ### AKHIR NEW GAME

        // ### AWAL SAVE
        JButton button_save = new JButton("Load");
        button_save.setBounds(150, 235, 200, 25);
        window.add(button_save);
        // ### AKHIR SAVE

        // ### AWAL EXIT
        JButton button_exit = new JButton("Exit");
        button_exit.setBounds(150, 280, 200, 25);
        button_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        window.add(button_exit);
        // ### AKHIR EXIT
    }
}
