import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateProf implements ActionListener {
    JLabel adminID, fName, lName, address, phone, income, use, status, model, year, type, method;
    CustomerProfDB database;
    JFrame createProf;
    JTextField adminIdT = new JFormattedTextField();
    JTextField fNameT = new JFormattedTextField();
    JTextField lNameT = new JFormattedTextField();
    JTextField addressT = new JFormattedTextField();
    JTextField phoneT = new JFormattedTextField();
    JTextField incomeT = new JFormattedTextField();
    JTextField modelT = new JFormattedTextField();
    JTextField yearT = new JFormattedTextField();


    String[] uses = {"Personal", "Business", "Both"};
    String[] statuses = {"Active", "Inactive"};
    String[] types = {"Sedan", "Sport", "SUV", "Truck", "Other"};
    String[] methods = {"New", "Used", "Certified Pre-Owned"};
    JComboBox<String> useT = new JComboBox<>(uses);
    JComboBox<String> statusT = new JComboBox<>(statuses);
    JComboBox<String> typeT = new JComboBox<>(types);
    JComboBox<String> methodT = new JComboBox<>(methods);

    public CreateProf(CustomerProfDB data){
        database = data;
        createProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Create Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Define all Text Fields
        adminID = new JLabel("Admin ID:");
        fName = new JLabel("First Name:");
        lName = new JLabel("Last Name:");
        address = new JLabel("Address:");
        phone = new JLabel("Phone:");
        income = new JLabel("Income:");
        model = new JLabel("Model:");
        year = new JLabel("Year:");

        //Define all dropdowns
        use = new JLabel("Use:");
        status = new JLabel("Status:");
        type = new JLabel("Type:");
        method = new JLabel("Method:");

        //Submit Button
        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);

        panel.add(adminID);
        panel.add(adminIdT);
        panel.add(fName);
        panel.add(fNameT);
        panel.add(lName);
        panel.add(lNameT);
        panel.add(address);
        panel.add(addressT);
        panel.add(phone);
        panel.add(phoneT);
        panel.add(income);
        panel.add(incomeT);
        panel.add(use);
        panel.add(useT);
        panel.add(status);
        panel.add(statusT);
        panel.add(model);
        panel.add(modelT);
        panel.add(year);
        panel.add(yearT);
        panel.add(type);
        panel.add(typeT);
        panel.add(method);
        panel.add(methodT);
        panel.add(submitButton);

        createProf.add(panel, BorderLayout.CENTER);
        createProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createProf.setTitle("Create Profile");
        createProf.pack();
        createProf.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String admin = adminIdT.getText();
        String first = fNameT.getText();
        String last = lNameT.getText();
        String addressStr = addressT.getText();
        String phoneStr = phoneT.getText();
        String incomeStr = incomeT.getText();
        String useStr = String.valueOf(useT.getSelectedItem());
        String statusStr = String.valueOf(statusT.getSelectedItem());
        String modelStr = modelT.getText();
        String yearStr = yearT.getText();
        String typeStr = String.valueOf(typeT.getSelectedItem());
        String methodStr = String.valueOf(methodT.getSelectedItem());

        boolean isComplete = false;
        if(admin.isEmpty() || first.isEmpty() || last.isEmpty() || addressStr.isEmpty() || phoneStr.isEmpty() || incomeStr.isEmpty() || modelStr.isEmpty() || yearStr.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please complete fields.");
            return;
        }
        else{
            isComplete = true;
        }

        float incomeFloat = 0;
        boolean isFloat = false;
        try{
            incomeFloat = Float.parseFloat(incomeStr);
            isFloat = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter a number.");
            return;
        }

        if(isFloat && isComplete){
            VehicleInfo newVehicle = new VehicleInfo(modelStr, yearStr, typeStr, methodStr);
            CustomerProf newCustomer = new CustomerProf(admin, first, last, addressStr, phoneStr, incomeFloat, statusStr, useStr, newVehicle);
            database.insertNewProfile(newCustomer);
            database.writeAllCustomerProf();

            MainMenu gui = new MainMenu();
            createProf.dispose(); //Close Window
        }
    }
}