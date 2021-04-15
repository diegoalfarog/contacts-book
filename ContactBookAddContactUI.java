/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactBookAddContactUI extends JFrame {

  private static final long serialVersionUID = 1L;

  private JLabel nameLabel;
  private JLabel phoneLabel;
  private JLabel emailLabel;
  private JTextField nameTextField;
  private JTextField phoneTextField;
  private JTextField emailTextField;
  private JButton addButton;
  private JButton cancelButton;

  public ContactBookAddContactUI(JFrame Patern, ContactBook contactBook) {
    super("Contact Book");
    JFrame contextPaternComponent = this;
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

    nameLabel = new JLabel("Name: ");
    nameTextField = new JTextField(15);

    phoneLabel = new JLabel("Phone: ");
    phoneTextField = new JTextField(15);

    emailLabel = new JLabel("Email: ");
    emailTextField = new JTextField(15);

    addButton = new JButton("Add Contact");
    cancelButton = new JButton("Cancel");

    add(nameLabel);
    add(nameTextField);

    add(phoneLabel);
    add(phoneTextField);

    add(emailLabel);
    add(emailTextField);

    add(addButton);
    add(cancelButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evento) {
        if (nameTextField.getText().equals("") || phoneTextField.getText().equals("")
            || emailTextField.getText().equals("")) {
          JOptionPane.showMessageDialog(contextPaternComponent, "please fill all spaces");
          return;
        }
        if (!StringValidator.valitateIfOnlyHaveLettersAndNumbers(nameTextField.getText())) {
          JOptionPane.showMessageDialog(contextPaternComponent, "The name must be only lettes and numbers");
          return;
        }
        if (!StringValidator.valitateIfOnlyHaveNumbers(phoneTextField.getText())) {
          JOptionPane.showMessageDialog(contextPaternComponent, "The phone must be only numbers");
          return;
        }
        if (!StringValidator.valitateIfIsAEmail(emailTextField.getText())) {
          JOptionPane.showMessageDialog(contextPaternComponent, "invalid email");
          return;
        }
        contactBook
            .addContact(new Contact(nameTextField.getText(), phoneTextField.getText(), emailTextField.getText()));
        JOptionPane.showMessageDialog(contextPaternComponent, "succesfully added");
        Patern.setVisible(true);
        contextPaternComponent.dispose();
      }
    });
    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evento) {
        Patern.setVisible(true);
        contextPaternComponent.dispose();
      }
    });

    this.setLocationRelativeTo(null);
    this.setSize(270, 175);
    this.setVisible(true);
  }
}
