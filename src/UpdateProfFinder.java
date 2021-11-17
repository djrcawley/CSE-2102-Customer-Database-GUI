import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfFinder implements ActionListener {
    JLabel adminID, lName, update;
    JTextField adminIDT, lNameT;

    String[] fields = {"First Name", "Last Name", "Address", "Phone", "Income", "Use", "Status", "Model", "Year", "Type", "Method"};
    JComboBox<String> updateT;

    CustomerProfDB database;
    JFrame updateProf;

    public UpdateProfFinder(CustomerProfDB data){
        database = data;

        updateProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Update Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Set all Text Fields
        adminID = new JLabel("Admin ID:");
        adminIDT = new JFormattedTextField();
        lName = new JLabel("Last Name:");
        lNameT = new JFormattedTextField();

        //Set Combo Box
        update = new JLabel("Update Field");
        updateT = new JComboBox<String>(fields);

        //Find Button
        JButton findButton = new JButton("FIND");
        findButton.addActionListener(this);

        panel.add(adminID);
        panel.add(adminIDT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(update);
        panel.add(updateT);
        panel.add(findButton);

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
            System.out.println("Invalid Customer");
            MainMenu gui = new MainMenu();
        }
        else {
            UpdateProf gui = new UpdateProf(customer, (String) updateT.getSelectedItem(), database);
        }
        updateProf.dispose();
    }
}
