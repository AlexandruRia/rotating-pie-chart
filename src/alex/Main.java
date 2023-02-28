package alex;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();


        Slice[] slice = {new Slice("University_degree", Color.black,200000), new Slice("College_graduate", Color.green, 250000),
                new Slice("Trade_school_graduate", Color.yellow, 150000), new Slice("Primary_school_graduate", Color.red,400000) };

        Pie pie = new Pie(slice);

        button.add(pie);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                button.remove(pie);

                Slice[] slice2 = {null,null,null,null};

                slice2[0] = pie.slice[3];
                slice2[1] = pie.slice[0];
                slice2[2] = pie.slice[1];
                slice2[3] = pie.slice[2];

                pie.slice[3] = slice2[3];
                pie.slice[0] = slice2[0];
                pie.slice[1] = slice2[1];
                pie.slice[2] = slice2[2];

                button.add(pie);

            }
        });

        frame.add(button);
        frame.setSize(700, 700);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}