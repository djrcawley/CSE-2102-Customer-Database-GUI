import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfFinder implements ActionListener {
    JLabel adminID, lName, update; //Label
    JTextField adminIDT, lNameT; //Text Field
    //Fields
    String[] fields = {"First Name", "Last Name", "Address", "Phone", "Income", "Status", "Use", "Model", "Year", "Type", "Method"};
    JComboBox<String> updateT;

    CustomerProfDB database; //Database
    JFrame updateProf; //Frame

    public UpdateProfFinder(CustomerProfDB data){
        database = data; //Set database

        updateProf = new JFrame(); //Set Frame

        //Create Panel
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Update Profile");
        panel.add(label);
        //Set layout
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set all Text Fields
        adminID = new JLabel("Admin ID:");
        adminIDT = new JFormattedTextField();
        lName = new JLabel("Last Name:");
        lNameT = new JFormattedTextField();

        //Set Combo Box
        update = new JLabel("Update Field");
        updateT = new JComboBox<>(fields);

        //Find Button
        JButton findButton = new JButton("FIND");
        findButton.addActionListener(this);
        //Add panels
        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(update);
        panel.add(updateT);
        panel.add(findButton);
        //Complete Frame
        updateProf.add(panel, BorderLayout.CENTER);
        updateProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateProf.setTitle("Update Profile");
        updateProf.pack();
        updateProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Search DB for Profile
        CustomerProf customer = database.findProfile(adminIDT.getText(), lNameT.getText());
        if(customer == null){
            //Cusomter does not exist
            JOptionPane.showMessageDialog(null, "Invalid Customer");
        }
        else {
            //Call updateProf
            new UpdateProf(customer, (String) updateT.getSelectedItem(), database);
        }
        updateProf.dispose(); //Close frame
    }
}
