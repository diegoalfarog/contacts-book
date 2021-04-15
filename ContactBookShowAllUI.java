/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactBookShowAllUI extends JFrame {

  private static final long serialVersionUID = 1L;

  private JButton backButton;
  private JTable contactsTable;
  private JPanel contactsPanel;
  private JScrollPane contactsPane;
  private DefaultTableModel contactsModel;

  public ContactBookShowAllUI(JFrame Patern, ContactBook contactBook) {
    super("Contact Book");
    JFrame contextPaternComponent = this;
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

    contactsModel = new DefaultTableModel();
    contactsModel.addColumn("Index");
    contactsModel.addColumn("Name");
    contactsModel.addColumn("Phone");
    contactsModel.addColumn("Email");
    contactsModel.addRow(new Object[] { "Index", "Name", "Phone", "Phone" });
    for (Object[] contacObject : contactBook.showAllContacts()) {
      contactsModel.addRow(contacObject);
    }

    contactsTable = new JTable(contactsModel) {
      private static final long serialVersionUID = 1L;
      public boolean editCellAt(int row, int column, java.util.EventObject e) {
        return false;
      }
    };

    contactsPanel = new JPanel();
    contactsPanel.add(contactsTable, BorderLayout.CENTER);
    contactsPane = new JScrollPane(contactsPanel);

    backButton = new JButton("Back");

    contactsPane.setMaximumSize(new Dimension(360, 140));
    contactsPane.setMinimumSize(new Dimension(510, 300));

    contactsTable.getColumnModel().getColumn(1).setMinWidth(40);
    contactsTable.getColumnModel().getColumn(0).setMaxWidth(60);
    contactsTable.getColumnModel().getColumn(1).setMinWidth(60);
    contactsTable.getColumnModel().getColumn(1).setMaxWidth(140);
    contactsTable.getColumnModel().getColumn(2).setMinWidth(60);
    contactsTable.getColumnModel().getColumn(2).setMaxWidth(80);
    contactsTable.getColumnModel().getColumn(3).setMinWidth(200);
    contactsTable.getColumnModel().getColumn(3).setMaxWidth(300);
    
    add(contactsPane, BorderLayout.CENTER);
    add(backButton);

    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evento) {
        Patern.setVisible(true);
        contextPaternComponent.dispose();
      }
    });

    this.setLocationRelativeTo(null);
    this.setSize(500, 300);
    this.setVisible(true);
  }
}