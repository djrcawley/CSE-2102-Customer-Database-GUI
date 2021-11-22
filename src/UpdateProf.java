import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProf implements ActionListener {
    JLabel fieldL;
    JTextField fieldT;
    CustomerProf customer;
    String updateField;
    JFrame updateProf;
    CustomerProfDB database;

    String[] uses = {"Personal", "Business", "Both"};
    String[] statuses = {"Active", "Inactive"};
    String[] types = {"Sedan", "Sport", "SUV", "Truck", "Other"};
    String[] methods = {"New", "Used", "Certified Pre-Owned"};
    JComboBox<String> useT = new JComboBox<>(uses);
    JComboBox<String> statusT = new JComboBox<>(statuses);
    JComboBox<String> typeT = new JComboBox<>(types);
    JComboBox<String> methodT = new JComboBox<>(methods);

    public UpdateProf(CustomerProf theCustomer, String field, CustomerProfDB data){
        database = data;
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
        if (updateField.equals("Use")){
            panel.add(useT);
        }else if(updateField.equals("Status")){
            panel.add(statusT);
        }else if(updateField.equals("Type")){
            panel.add(typeT);
        }else if(updateField.equals("Method")){
            panel.add(methodT);
        }else {
            panel.add(fieldT);
        }
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
            customer.updateUse(String.valueOf(useT.getSelectedItem()));
        }
        if(updateField.equals("Status")){
            customer.updateStatus(String.valueOf(statusT.getSelectedItem()));
        }
        if(updateField.equals("Model")){
            vehicle.updateModel(fieldT.getText());
        }
        if(updateField.equals("Year")){
            vehicle.updateYear(fieldT.getText());
        }
        if(updateField.equals("Type")){
            vehicle.updateType(String.valueOf(typeT.getSelectedItem()));
        }
        if(updateField.equals("Method")){
            vehicle.updateMethod(String.valueOf(methodT.getSelectedItem()));
        }

        database.writeAllCustomerProf();

        new MainMenu();
        updateProf.dispose();
    }
}