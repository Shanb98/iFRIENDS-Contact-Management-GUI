import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWindow extends JFrame{
    private JButton btnAddNewContact;
    private JButton btnUpdateContact;
    private JButton btnSearchContact;
    private JButton btnDeleteContact;
    private JButton btnViewContact;
    private JButton btnExit;

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel imageLabel;
    private JLabel titleLabel;

    private AddNewContact addNewContact;
    private UpdateContact updateContact;
    private SearchContact searchContact;
    private DeleteContact deleteContact;
    private ViewContact viewContact;
    public MainWindow(){
        setSize(650,455);
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        leftPanel = new JPanel(new BorderLayout());

        titleLabel = new JLabel("<html><div style='text-align: center;'>iFRIEND<br>Contact Organizer</div></html>");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(JLabel.BOTTOM);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titleLabel.setBackground(new Color(255, 255, 255));
        titleLabel.setOpaque(true);
        leftPanel.add(titleLabel, BorderLayout.NORTH);

        String filePath = "C:/Users/shanb/OneDrive/Desktop/Programming/Java/Java Swing Application/src/Screenshot 2023-07-02 210734.png";
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        leftPanel.setPreferredSize(new Dimension(300, 350));
        leftPanel.setBackground(new Color(255, 255, 255));

        JPanel rightPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        rightPanel.setBackground(new Color(255, 255, 255));


        btnAddNewContact=new JButton("Add New Contact");
        btnAddNewContact = createButtonWithIcon("Add New Contact", "icons/add.png");
        btnAddNewContact.setFont(new Font("",1,30));
        btnAddNewContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addNewContact==null){
                    addNewContact=new AddNewContact();
                }
                addNewContact.setVisible(true);
            }
        });
        rightPanel.add(btnAddNewContact);

        btnSearchContact=new JButton("Search Contact");
        btnSearchContact = createButtonWithIcon("Search Contact", "icons/search.png");
        btnSearchContact.setFont(new Font("",1,30));
        btnSearchContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new SearchContact().setVisible(true);
            }
        });
        rightPanel.add(btnSearchContact);

        btnUpdateContact=new JButton("Update Contact");
        btnUpdateContact = createButtonWithIcon("Update Contact", "icons/update.png");
        btnUpdateContact.setFont(new Font("",1,30));
        btnUpdateContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new UpdateContact().setVisible(true);
            }
        });
        rightPanel.add(btnUpdateContact);

        btnDeleteContact=new JButton("Delete Contact");
        btnDeleteContact = createButtonWithIcon("Delete Contact", "icons/delete.png");
        btnDeleteContact.setFont(new Font("",1,30));
        btnDeleteContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new DeleteContact().setVisible(true);
            }
        });
        rightPanel.add(btnDeleteContact);

        btnViewContact=new JButton("View Customer List");
        btnViewContact.setFont(new Font("",1,30));
        btnViewContact = createButtonWithIcon("View Customer List", "icons/view.png");
        btnViewContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(viewContact==null){
                    viewContact=new ViewContact();
                }
                viewContact.setVisible(true);
            }
        });
        rightPanel.add(btnViewContact);

        btnExit=new JButton("Exit");
        btnExit.setFont(new Font("",1,10));
        btnExit = createButtonWithIcon("Exit", "icons/exit.png");
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(rightPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(btnExit);
        exitPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.add(exitPanel, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        add(mainPanel);

    }
    private JButton createButtonWithIcon(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("", 1, 30));

        ImageIcon icon = new ImageIcon(iconPath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledImage));

        return button;
    }
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}

