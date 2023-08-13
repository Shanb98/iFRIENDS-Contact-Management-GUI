import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UpdateContact extends JFrame{
    private JLabel titleLabel;
    private JButton updateButton;
    private JButton cancelButton;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel companyLabel;
    private JLabel salaryLabel;
    private JLabel bdayLabel;
    private JLabel searchLabel;

    private JTextField idText;
    private JTextField nameText;
    private JTextField phoneText;
    private JTextField companyText;
    private JTextField salaryText;
    private JTextField bdayText;
    private JTextField searchText;

    UpdateContact(){
        setSize(400,400);
        setTitle("Update Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new  BorderLayout());

        titleLabel=new JLabel("Update Contact");
        titleLabel.setFont(new Font("",1,40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(51, 199, 255));
        titleLabel.setOpaque(true);
        add("North",titleLabel);


        updateButton=new JButton("Update Contact");
        updateButton.setFont(new Font("",1,15));
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String returnedID=idText.getText();
                String name=nameText.getText();
                String phone=phoneText.getText();
                String company=companyText.getText();
                String salary=salaryText.getText();
                String bday=bdayText.getText();
                Customer customer=new Customer(returnedID, name ,phone,company,salary, bday);
                boolean isUpdate=CustomerController.updateCustomer(customer);
                if(isUpdate){
                    JOptionPane.showMessageDialog(null, "Update Success");
                }else{
                    JOptionPane.showMessageDialog(null, "Update Fail");
                }
            }
        });

        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,15));
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
            }
        });

        //JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel = new JPanel();
        FlowLayout f1 = new FlowLayout();
        f1.setAlignment(FlowLayout.RIGHT);
        buttonPanel.setLayout(f1);
        buttonPanel.setBackground(new Color(51, 199, 255)); // Set background color
        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);
        add("South",buttonPanel);


        JPanel labelPanel=new JPanel(new GridLayout(7,1));
        searchLabel=new JLabel("");
        searchLabel.setFont(new Font("",1,15));
        labelPanel.add(searchLabel);
        idLabel=new JLabel("Customer ID");
        idLabel.setFont(new Font("",1,15));
        labelPanel.add(idLabel);
        nameLabel=new JLabel("Name");
        nameLabel.setFont(new Font("",1,15));
        labelPanel.add(nameLabel);
        phoneLabel=new JLabel("Contact No");
        phoneLabel.setFont(new Font("",1,15));
        labelPanel.add(phoneLabel);
        companyLabel=new JLabel("Company");
        companyLabel.setFont(new Font("",1,15));
        labelPanel.add(companyLabel);
        salaryLabel=new JLabel("Salary");
        salaryLabel.setFont(new Font("",1,15));
        labelPanel.add(salaryLabel);
        bdayLabel=new JLabel("Birthday");
        bdayLabel.setFont(new Font("",1,15));
        labelPanel.add(bdayLabel);
        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(7,1));
        JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchText=new JTextField(10);
        searchText.setFont(new Font("",1,15));
        searchText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String name=searchText.getText();
                Customer customer=CustomerController.searchCustomer(name);
                if(customer!=null){
                    idText.setText(customer.getReturnedID());
                    nameText.setText(customer.getName());
                    phoneText.setText(customer.getPhone());
                    companyText.setText(customer.getCompany());
                    salaryText.setText(customer.getSalary());
                    bdayText.setText(customer.getBday());

                }else{
                    JOptionPane.showMessageDialog(null,"Customer not found..");
                }
            }
        });
        searchTextPanel.add(searchText);
        JButton sButton = new JButton("Search");
        sButton.setFont(new Font("", 1, 15));
        sButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String name=searchText.getText();
                Customer customer=CustomerController.searchCustomer(name);
                if(customer!=null){
                    idText.setText(customer.getReturnedID());
                    nameText.setText(customer.getName());
                    phoneText.setText(customer.getPhone());
                    companyText.setText(customer.getCompany());
                    salaryText.setText(customer.getSalary());
                    bdayText.setText(customer.getBday());
                }else{
                    JOptionPane.showMessageDialog(null,"Customer not found..");
                }
            }
        });

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchTextPanel, BorderLayout.WEST);
        searchPanel.add(sButton, BorderLayout.EAST);

        textPanel.add(searchPanel);

        idText=new JTextField(10);
        idText.setFont(new Font("",1,15));
        idText.setEditable(false);
        textPanel.add(idText);
        nameText=new JTextField(10);
        nameText.setFont(new Font("",1,15));
        textPanel.add(nameText);
        phoneText=new JTextField(20);
        phoneText.setFont(new Font("",1,15));
        textPanel.add(phoneText);
        companyText=new JTextField(10);
        companyText.setFont(new Font("",1,15));
        textPanel.add(companyText);
        salaryText=new JTextField(10);
        salaryText.setFont(new Font("",1,15));
        textPanel.add(salaryText);
        bdayText=new JTextField(10);
        bdayText.setFont(new Font("",1,15));
        textPanel.add(bdayText);
        add("East",textPanel);


    }

    public static void main(String srgs[]){
        new SearchContact().setVisible(true);
    }
}
