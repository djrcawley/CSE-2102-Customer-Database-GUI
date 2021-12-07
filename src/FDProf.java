import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FDProf implements ActionListener {
    CustomerProfDB database; //Database

    JLabel adminID, lName; //Label
    JFormattedTextField adminIDT, lNameT; //Text field

    JFrame fdProf; //Frame

    public FDProf(CustomerProfDB data) {
        database = data; //Set Database

        fdProf = new JFrame(); //Set Frame

        //Create Panels
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Find Profile");
        panel.add(label);
        //Set layout
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
        //Add panel
        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(findButton);
        //Complete Frame
        fdProf.add(panel, BorderLayout.CENTER);
        fdProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fdProf.setTitle("Update Profile");
        fdProf.pack();
        fdProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Find Profile
        CustomerProf customer = database.findProfile(adminIDT.getText(), lNameT.getText());
        if(customer == null){
            //No Customer Found
            JOptionPane.showMessageDialog(null, "Invalid Customer");
        }
        else {
            //Display the cutomer
            new DisplayProf(customer);
        }
        fdProf.dispose(); //Close
    }
}

