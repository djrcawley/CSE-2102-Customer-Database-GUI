import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FDProf implements ActionListener {
    CustomerProfDB database;

    JLabel adminID, lName;
    JFormattedTextField adminIDT, lNameT;

    public FDProf(CustomerProfDB data) {
        database = data;

        JFrame fdProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Find Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set all Text Fields
        adminID = new JLabel("Admin ID:");
        adminIDT = new JFormattedTextField();
        lName = new JLabel("Last Name:");
        lNameT = new JFormattedTextField();

        //Find Button
        JButton findButton = new JButton("FIND");
        findButton.addActionListener(this);

        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(findButton);

        fdProf.add(panel, BorderLayout.CENTER);
        fdProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fdProf.setTitle("Update Profile");
        fdProf.pack();
        fdProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        CustomerProf customer = database.findProfile(adminIDT.getText(), lNameT.getText());
        if(customer == null){
            System.out.println("Invalid Customer");
            MainMenu gui = new MainMenu();
        }
        else {

        }
    }
}

