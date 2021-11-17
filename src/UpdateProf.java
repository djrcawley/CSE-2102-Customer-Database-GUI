import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UpdateProf implements ActionListener {
    JLabel fieldL;
    JTextField fieldT;

    CustomerProf customer;
    String updateField;

    JFrame updateProf;

    public UpdateProf(CustomerProf theCustomer, String field){
        customer = theCustomer;
        updateField = field;

        updateProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Update");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(new JLabel("Admin ID - " + customer.getadminID()));
        panel.add(new JLabel("Last Name - " + customer.getLastName()));

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
        //Configure
        VehicleInfo vehicle = customer.getVehicleInfo();

        if(updateField.equals("First Name")){
            customer.updateFirstName(fieldT.getText());
        }
        if(updateField.equals("Last Name")){
            customer.updateLastName(fieldT.getText());
        }
        if(updateField.equals("Address")){
            customer.updateAddress(fieldT.getText());
        }
        if(updateField.equals("Phone")){
            customer.updatePhone(fieldT.getText());
        }
        if(updateField.equals("Income")) {
            customer.updateIncome(Integer.parseInt(fieldT.getText()));
        }
        if(updateField.equals("Use")){
            customer.updateUse(fieldT.getText());
        }
        if(updateField.equals("Status")){
            customer.updateStatus(fieldT.getText());
        }
        if(updateField.equals("Model")){
            vehicle.updateModel(fieldT.getText());
        }
        if(updateField.equals("Year")){
            vehicle.updateYear(fieldT.getText());
        }
        if(updateField.equals("Type")){
            vehicle.updateType(fieldT.getText());
        }
        if(updateField.equals("Method")){
            vehicle.updateMethod(fieldT.getText());
        }

        MainMenu gui = new MainMenu();
        updateProf.dispose();
    }
}