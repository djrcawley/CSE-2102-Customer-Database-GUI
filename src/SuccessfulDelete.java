import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessfulDelete implements ActionListener {
    JFrame successfulDelete; //Frame
    public SuccessfulDelete(){
        successfulDelete = new JFrame(); //Set Frame
        //Create Panel
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Delete Profile");
        panel.add(label);
        //Set layout
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Label
        JLabel deleted = new JLabel("Profile Deleted");

        //OK Button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(this);
        //Add panels
        panel.add(deleted);
        panel.add(okButton);
        //set layout
        successfulDelete.add(panel, BorderLayout.CENTER);
        successfulDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successfulDelete.setTitle("Profile Deleted");
        successfulDelete.pack();
        successfulDelete.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        successfulDelete.dispose(); //close
    }
}
