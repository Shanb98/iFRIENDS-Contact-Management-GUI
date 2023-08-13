import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class ViewContact extends JFrame{
    private JTable customerTable;
    private DefaultTableModel dtm;
    private JLabel titleLabel;
    private JButton btnReload;
    private JButton btnSortBySalary;
    private JButton btnSortByName;
    private JButton btnSortByBday;
    private JButton cancelButton;
    ViewContact(){
        setSize(700,500);
        setTitle("View Customer Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel=new JLabel("LIST CONTACT");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(51, 199, 255));
        titleLabel.setOpaque(true);
        add("North",titleLabel);

        String[] columnNames={"Contact Id","Name","Contact No","Company","Salary","Birthday"};
        dtm=new DefaultTableModel(columnNames,0);
        customerTable=new JTable(dtm);

        JScrollPane tablePane=new JScrollPane(customerTable);
        add("Center",tablePane);

        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,15));
        btnReload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Customer[] customerArray=CustomerController.getAllCustomer();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getReturnedID(),customer.getName(), customer.getPhone(),customer.getCompany(),customer.getSalary(),customer.getBday()};
                    dtm.addRow(rowData);
                }

            }
        });
        btnSortBySalary=new JButton("Sort by Salary");
        btnSortBySalary.setFont(new Font("",1,15));
        btnSortBySalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Customer[] customerArray=CustomerController.getAllCustomerSortBySalary();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getReturnedID(),customer.getName(), customer.getPhone(),customer.getCompany(),customer.getSalary(),customer.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        btnSortByName=new JButton("Sort by Name");
        btnSortByName.setFont(new Font("",1,15));
        btnSortByName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Customer[] customerArray=CustomerController.getAllCustomerSortByName();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getReturnedID(),customer.getName(), customer.getPhone(),customer.getCompany(),customer.getSalary(),customer.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        btnSortByBday=new JButton("Sort by Birthday");
        btnSortByBday.setFont(new Font("",1,15));
        btnSortByBday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Customer[] customerArray=CustomerController.getAllCustomerSortByName();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getReturnedID(),customer.getName(), customer.getPhone(),customer.getCompany(),customer.getSalary(),customer.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,15));
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnReload);
        buttonPanel.add(btnSortByName);
        buttonPanel.add(btnSortBySalary);
        buttonPanel.add(btnSortByBday);
        buttonPanel.add(cancelButton);
        buttonPanel.setBackground(new Color(51, 199, 255)); // Set background color
        add("South",buttonPanel);
    }
    public static void main(String srgs[]){
        new ViewContact().setVisible(true);
    }
}
