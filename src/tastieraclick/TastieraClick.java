package tastieraclick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TastieraClick {

    public static void main(String[] args) {

//tastiera che scrive nel JLabel
//aggiunge a una lista
//ricerca nella lista
//bottone invio testoe somma prezzi cper ogni stringa uguale e totale
        JFrame frame;
        frame = new JFrame("                                                                      GIOCO DEL 15");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(650, 70);
        frame.setAlwaysOnTop(true);
        String[] posizione = {"North", "West", "Center", "East", "South"};
        String[] posizione1 = {"North", "Center"};
        JPanel pannello[] = new JPanel[posizione.length];
        JPanel pannello1[] = new JPanel[posizione1.length];
        int DIM = 10;
        int DIMN = 28;
        JButton bottoniNumeri[] = new JButton[DIM];
        JButton bottoniLettere[] = new JButton[DIMN];
        JLabel label = new JLabel();
        DefaultListModel dlm = new DefaultListModel();

        ActionListener l;
        l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = ((JButton) e.getSource()).getText();
                String t = label.getText();
                    s = t + s;
                    label.setText(s);

            }
        };
        for (int i = 0; i < posizione.length; i++) {
            pannello[i] = new JPanel();
            pannello[i].setName(posizione[i]);
            pannello[i].setBorder(BorderFactory.createLineBorder(Color.red));
            frame.add(pannello[i]);
        }
        for (int j = 0; j < posizione1.length; j++) {
            pannello1[j] = new JPanel();
            pannello1[j].setName(posizione1[j]);
            pannello[4].add(pannello1[j]);
        }
        for (int i = 0; i < bottoniNumeri.length; i++) {
            bottoniNumeri[i] = new JButton("" + i);
            bottoniNumeri[i].setName("" + i);
            bottoniNumeri[i].addActionListener(l);
            pannello1[0].setLayout(new FlowLayout(0, 5, 7));
            pannello1[0].add(bottoniNumeri[i]);
        }
        String s[] = new String[DIMN];
        for (int i = 0; i < DIMN; i++) {
            char tasti[] = new char[DIMN];
            int c = 65 + i;
            tasti[i] = (char) c;
            s[i] = "" + tasti[i];
            bottoniLettere[i] = new JButton("" + s[i]);
            bottoniLettere[i].setText(s[i]);
            bottoniLettere[i].setName(s[i]);
            bottoniLettere[i].addActionListener(l);
            pannello1[1].setLayout(new GridLayout(4, 9, 5, 7));
            pannello1[1].add(bottoniLettere[i]);
            pannello[4].add(pannello1[1]);

        }

        bottoniLettere[26].setText(".");
        bottoniLettere[26].setName(".");
        bottoniLettere[27].setText("INVIO");
        bottoniLettere[27].setName("INVIO");
        pannello[2].add(label);
        label.setText("");
        label.setFont(new Font("Serif", Font.BOLD, 50));
        frame.add(pannello[2], posizione[2]);
        frame.add(pannello[4], posizione[4]);
        pannello[4].setPreferredSize(new Dimension(300, 200));
        frame.setVisible(true);
    }

}
