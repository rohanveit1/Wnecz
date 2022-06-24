package me.poilet.wnecz.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WneczGUI extends JFrame implements ActionListener {

    WneczClient client;

    public WneczGUI(WneczClient client) {

        this.client = client;

        GridLayout layout = new GridLayout(0, 3);
        layout.setHgap(3);
        layout.setVgap(3);
        setLayout(layout); //3 x 3 layout

        setTitle("Wnecz");
        setSize(600, 600);
        setBackground(Color.BLACK);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setBackground(Color.WHITE);
            button.addActionListener(this);
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button source = (Button) e.getSource();
        source.setBackground(Color.RED);
        source.setEnabled(false);

    }
}
