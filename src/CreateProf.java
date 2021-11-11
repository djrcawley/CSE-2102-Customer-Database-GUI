import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateProf implements ActionListener {
    JLabel adminID, fName, lName, address, phone, income, use, status, model, year, type, method;
    JTextField adminIdT, fNameT, lNameT, addressT, phoneT, incomeT, modelT, yearT;

    String[] uses = {"Personal", "Business", "Both"};
    String[] statuses = {"Active", "Inactive"};
    String[] types = {"Sedan", "Sport", "SUV", "Truck", "Other"};
    String[] methods = {"New", "Used", "Certified Pre-Owned"};
    JComboBox<String> useT, statusT, typeT, methodT;

    public CreateProf(){
        JFrame createProf = new JFrame();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Create Profile");
        panel.add(label);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        //Define all Text Fields
        adminID = new JLabel("Admin ID:");
        adminIdT = new JFormattedTextField();
        fName = new JLabel("First Name:");
        fNameT = new JFormattedTextField();
        lName = new JLabel("Last Name:");
        lNameT = new JFormattedTextField();
        address = new JLabel("Address:");
        addressT = new JFormattedTextField();
        phone = new JLabel("Phone:");
        phoneT = new JFormattedTextField();
        income = new JLabel("Income:");
        incomeT = new JFormattedTextField();
        model = new JLabel("Model:");
        modelT = new JFormattedTextField();
        year = new JLabel("Year:");
        yearT = new JFormattedTextField();

        //Define all dropdowns
        use = new JLabel("Use:");
        useT = new JComboBox<String>(uses);
        status = new JLabel("Status:");
        statusT = new JComboBox<String>(statuses);
        type = new JLabel("Type:");
        typeT = new JComboBox<String>(types);
        method = new JLabel("Method:");
        methodT = new JComboBox<String>(methods);

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

    public void actionPerformed(ActionEvent e) {
        //Write to DB
    }
    public static void main(String[] args){
        CreateProf createProf = new CreateProf();
    }
}
