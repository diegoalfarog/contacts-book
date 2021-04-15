/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactBookSearchOrRemoveUI extends JFrame {

  private static final long serialVersionUID = 1023761073924873760L;

  public ContactBookSearchOrRemoveUI(JFrame Patern, ContactBook contactBook, String mode, String state, String by) {
    super("Contact Book");
    ContactBookSearchOrRemoveUI contextPaternComponent = this;
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
    JButton cancelButton;
    cancelButton = new JButton("Cancel");
    JLabel dialogLabel = null;
    switch (mode) {
    case "Search":
      dialogLabel = new JLabel("Search by: ");
      break;
    case "Remove":
      dialogLabel = new JLabel("Remove by: ");
      break;
    }

    add(dialogLabel);

    switch (state) {
    case "Select":

      JButton byNameButton;
      JButton byIndexButton;

      byNameButton = new JButton("Name");
      byIndexButton = new JButton("Index position");

      add(byNameButton);
      add(byIndexButton);
      add(cancelButton);

      byNameButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {
          contextPaternComponent.dispose();
          new ContactBookSearchOrRemoveUI(Patern, contactBook, mode, "Selected", "byName");
        }
      });

      byIndexButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {
          contextPaternComponent.dispose();
          new ContactBookSearchOrRemoveUI(Patern, contactBook, mode, "Selected", "byIndex");
        }
      });
      this.setSize(150, 175);
      break;
    case "Selected":
      JLabel parameterLabel;
      JTextField parameterTextField;

      parameterTextField = new JTextField(15);

      JButton modeButton = null;

      switch (mode) {
      case "Search":
        modeButton = new JButton("Search");
        break;
      case "Remove":
        modeButton = new JButton("Remove");
        break;
      }

      switch (by) {
      case "byIndex":
        parameterLabel = new JLabel("Index");
        add(parameterLabel);
        break;
      case "byName":
        parameterLabel = new JLabel("Name");
        add(parameterLabel);
        break;
      }
      add(parameterTextField);
      add(modeButton);
      modeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {
          if (parameterTextField.getText() == "") {
            return;
          }
          switch (by) {
          case "byIndex":
            if (!StringValidator.valitateIfOnlyHaveNumbers(parameterTextField.getText())) {
              JOptionPane.showMessageDialog(contextPaternComponent, "The index must be only numbers");
              return;
            }
            break;
          case "byName":
            if (!StringValidator.valitateIfOnlyHaveLettersAndNumbers(parameterTextField.getText())) {
              JOptionPane.showMessageDialog(contextPaternComponent, "The name must be only letters and numbers");
              return;
            }
            break;
          }
          switch (mode) {
          case "Search":
            Contact searchResult = null;
            switch (by) {
            case "byName":
              searchResult = contactBook.searchContact(parameterTextField.getText());
              break;
            case "byIndex":
              searchResult = contactBook.searchContact(Integer.parseInt(parameterTextField.getText()));
              break;
            default:
              break;
            }
            if (searchResult != null) {
              JOptionPane.showMessageDialog(contextPaternComponent, searchResult.toString());
              Patern.setVisible(true);
              contextPaternComponent.dispose();
            } else {
              JOptionPane.showMessageDialog(contextPaternComponent, "no exist any result");
              return;
            }
            break;
          case "Remove":
            boolean removeResult = false;
            switch (by) {
            case "byName":
              removeResult = contactBook.removeContact(parameterTextField.getText());
              break;
            case "byIndex":
              removeResult = contactBook.removeContact(Integer.parseInt(parameterTextField.getText()));
              break;
            default:
              break;
            }
            if (removeResult) {
              JOptionPane.showMessageDialog(contextPaternComponent, "Succesfully removed");
              Patern.setVisible(true);
              contextPaternComponent.dispose();
            } else {
              JOptionPane.showMessageDialog(contextPaternComponent, "not found to remove");
              return;
            }
            break;
          }

        }
      });
      this.setSize(250, 175);
      break;
    }

    add(cancelButton);
    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evento) {
        contextPaternComponent.dispose();
        Patern.setVisible(true);
      }
    });

    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public ContactBookSearchOrRemoveUI(JFrame Patern, ContactBook contactBook, String mode, String state) {
    this(Patern, contactBook, mode, state, "");
  }

}
