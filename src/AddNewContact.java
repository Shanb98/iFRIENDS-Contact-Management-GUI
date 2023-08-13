import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewContact extends JFrame{
    private JLabel titleLabel;
    private JButton addButton;
    private JButton cancelButton;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel companyLabel;
    private JLabel salaryLabel;
    private JLabel bdayLabel;

    private JTextField idText;
    private JTextField nameText;
    private JTextField phoneText;
    private JTextField companyText;
    private JTextField salaryText;
    private JTextField bdayText;

    AddNewContact(){
        setSize(400,400);
        setTitle("Add New Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new  BorderLayout());

        titleLabel=new JLabel("Add New Contact");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setBackground(new Color(51, 199, 255));
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        addButton=new JButton("Add Contact");
        addButton.setFont(new Font("",1,15));
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String returnedID=idText.getText();
                String name=nameText.getText();
                String phone=phoneText.getText();
                String company=companyText.getText();
                String salary=salaryText.getText();
                String bday=bdayText.getText();
                boolean isAdded=true;
                if (phone.length() != 10 || phone.charAt(0) != '0'||CustomerController.subi(phone)||CustomerController.subii2(phone)) {
                    int option = JOptionPane.showOptionDialog(
                            null,
                            "Invalid Phone Number. Do you want to edit the contact?",
                            "Invalid Input",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,
                            new String[]{"Edit", "Cancel"},
                            "Edit"
                    );
                    if (option == JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        dispose();
                        nameText.setText("");
                        phoneText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        bdayText.setText("");
                        isAdded=false;
                    }
                }
                else if (CustomerController.Enter_bday(bday)) {
                    int option = JOptionPane.showOptionDialog(
                            null,
                            "Invalid BirthDay. Do you want to edit the contact?",
                            "Invalid Input",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,
                            new String[]{"Edit", "Cancel"},
                            "Edit"
                    );
                    if (option == JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        dispose();
                        nameText.setText("");
                        phoneText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        bdayText.setText("");
                        isAdded=false;
                    }
                }
                else if(CustomerController.subii2(salary)){
                    int option = JOptionPane.showOptionDialog(
                            null,
                            "Invalid Salary. Do you want to edit the contact?",
                            "Invalid Input",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,
                            new String[]{"Edit", "Cancel"},
                            "Edit"
                    );
                    if (option == JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        dispose();
                        nameText.setText("");
                        phoneText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        bdayText.setText("");
                        isAdded=false;
                    }
                }

                if(isAdded){
                    Customer customer=new Customer(returnedID, name ,phone,company,salary, bday);
                    isAdded=CustomerController.addCustomer(customer);
                    JOptionPane.showMessageDialog(null,"Added Success");
                    int op=JOptionPane.showConfirmDialog(null, "Do you want to add another customer");
                    if(op==JOptionPane.YES_OPTION){
                        generateId();
                        nameText.setText("");
                        phoneText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        bdayText.setText("");
                    }else{
                        dispose();
                        generateId();
                        nameText.setText("");
                        phoneText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        bdayText.setText("");
                    }
                }
            }
        });

        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,15));
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                dispose();
                nameText.setText("");
                phoneText.setText("");
                companyText.setText("");
                salaryText.setText("");
                bdayText.setText("");
            }
        });

        //JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel=new JPanel();
        FlowLayout f1=new FlowLayout();
        f1.setAlignment(FlowLayout.RIGHT);
        buttonPanel.setLayout(f1);

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        add("South",buttonPanel);


        JPanel labelPanel=new JPanel(new GridLayout(6,1));

        idLabel=new JLabel("  Customer ID");
        idLabel.setFont(new Font("",1,15));
        labelPanel.add(idLabel);
        nameLabel=new JLabel("  Name");
        nameLabel.setFont(new Font("",1,15));
        labelPanel.add(nameLabel);
        phoneLabel=new JLabel("  Contact No");
        phoneLabel.setFont(new Font("",1,15));
        labelPanel.add(phoneLabel);
        companyLabel=new JLabel("  Company");
        companyLabel.setFont(new Font("",1,15));
        labelPanel.add(companyLabel);
        salaryLabel=new JLabel("  Salary");
        salaryLabel.setFont(new Font("",1,15));
        labelPanel.add(salaryLabel);
        bdayLabel=new JLabel("  Birthday");
        bdayLabel.setFont(new Font("",1,15));
        labelPanel.add(bdayLabel);
        add("West",labelPanel);


        JPanel textPanel=new JPanel(new GridLayout(6,1));
        JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        idText=new JTextField(10);
        idText.setFont(new Font("",1,15));
        idText.setEditable(false);
        idTextPanel.add(idText);
        textPanel.add(idTextPanel);
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
        buttonPanel.setBackground(new Color(51, 199, 255)); // Set background color

        generateId();
    }
    private void generateId(){
        String lastId=CustomerController.lastId();
        if(lastId==null){
            idText.setText("C0001");
        }else{
            String s=lastId.substring(1);
            int x=Integer.parseInt(s);
            lastId=String.format("C%04d",++x);
            idText.setText(lastId);
        }


    }
    public static void main(String srgs[]){
        new AddNewContact().setVisible(true);
    }
}


