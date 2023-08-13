import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SearchContact extends JFrame{
    private JLabel titleLabel;
    private JButton searchButton;
    private JButton sButton;
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

    SearchContact(){
        setSize(400,400);
        setTitle("Search Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new  BorderLayout());

        titleLabel=new JLabel("Search Contact");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(51, 199, 255));
        titleLabel.setOpaque(true);
        add("North",titleLabel);



        searchButton=new JButton("Search Contact");
        searchButton.setFont(new Font("",1,15));
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String name=searchText.getText();
                Customer customer=CustomerController.searchCustomer(name);
                if(customer!=null){
                    searchText.setText("");
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

        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,15));
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
            }
        });

        //JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel=new JPanel();
        FlowLayout f1=new FlowLayout();
        f1.setAlignment(FlowLayout.RIGHT);
        buttonPanel.setLayout(f1);

        buttonPanel.add(searchButton);
        buttonPanel.add(cancelButton);
        add("South",buttonPanel);
        buttonPanel.setBackground(new Color(51, 199, 255)); // Set background color


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
                    searchText.setText("");
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
                    searchText.setText("");
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

        idText = new JTextField(10);
        idText.setFont(new Font("", 1, 15));
        idText.setEditable(false);
        textPanel.add(idText);

        nameText = new JTextField(10);
        nameText.setFont(new Font("", 1, 15));
        nameText.setEditable(false);
        textPanel.add(nameText);

        phoneText = new JTextField(20);
        phoneText.setFont(new Font("", 1, 15));
        phoneText.setEditable(false);
        textPanel.add(phoneText);

        companyText = new JTextField(10);
        companyText.setFont(new Font("", 1, 15));
        companyText.setEditable(false);
        textPanel.add(companyText);

        salaryText = new JTextField(10);
        salaryText.setFont(new Font("", 1, 15));
        salaryText.setEditable(false);
        textPanel.add(salaryText);

        bdayText = new JTextField(10);
        bdayText.setFont(new Font("", 1, 15));
        bdayText.setEditable(false);
        textPanel.add(bdayText);

        add("East", textPanel);


    }

    public static void main(String srgs[]){
        new SearchContact().setVisible(true);
    }
}
