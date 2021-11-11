import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProf implements ActionListener {
    JLabel fieldL;
    JTextField fieldT;
    public UpdateProf(String adminID, String lNAme, String field){
        JFrame updateProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Update");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(new JLabel("Admin ID - " + adminID));
        panel.add(new JLabel("Last Name - " + lNAme));

        fieldL = new JLabel("" + field);
        fieldT = new JFormattedTextField();

        //Submit Button
        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);

        panel.add(fieldL);
        panel.add(fieldT);
        panel.add(submitButton);

        updateProf.add(panel, BorderLayout.CENTER);
        updateProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateProf.setTitle("Update Profie");
        updateProf.pack();
        updateProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
