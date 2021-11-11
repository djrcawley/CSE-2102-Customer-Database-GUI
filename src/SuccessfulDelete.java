import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessfulDelete implements ActionListener {
    public SuccessfulDelete(){
        JFrame successfulDelete = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Delete Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Label
        JLabel deleted = new JLabel("Profile Deleted");

        //OK Button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(this);

        panel.add(deleted);
        panel.add(okButton);

        successfulDelete.add(panel, BorderLayout.CENTER);
        successfulDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successfulDelete.setTitle("Profile Deleted");
        successfulDelete.pack();
        successfulDelete.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        MainMenu gui = new MainMenu();
    }
}
