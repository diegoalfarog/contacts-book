/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactBookMainUI extends JFrame {

	private static final long serialVersionUID = 1023761073924873760L;

	private JButton addContactButton;
	private JButton searchContactButton;
	private JButton showAllContactsButton;
	private JButton removeContactButton;
	private JButton removeAllContactsButton;
	private JButton exitButton;

	public ContactBookMainUI(ContactBook contactBook) {
		super("Contact Book");
		JFrame contextPaternComponent = this;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

		addContactButton = new JButton("Add Contact");
		searchContactButton = new JButton("Search Contact");
		showAllContactsButton = new JButton("Show All Contacts");
		removeContactButton = new JButton("Remove Contact");
		removeAllContactsButton = new JButton("Remove All Contact");
		exitButton = new JButton("Exit");

		add(addContactButton);
		add(searchContactButton);
		add(showAllContactsButton);
		add(removeContactButton);
		add(removeAllContactsButton);
		add(exitButton);

		addContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				contextPaternComponent.setVisible(false);
				new ContactBookAddContactUI(contextPaternComponent, contactBook);
			}
		});
		searchContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (contactBook.isEmpty()) {
					JOptionPane.showMessageDialog(contextPaternComponent, "Contact Book is empty");
					return;
				}
				contextPaternComponent.setVisible(false);
				new ContactBookSearchOrRemoveUI(contextPaternComponent, contactBook, "Search", "Select");
			}
		});
		showAllContactsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (contactBook.isEmpty()) {
					JOptionPane.showMessageDialog(contextPaternComponent, "Contact Book is empty");
					return;
				}
				contextPaternComponent.setVisible(false);
				new ContactBookShowAllUI(contextPaternComponent, contactBook);
			}
		});

		removeContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (contactBook.isEmpty()) {
					JOptionPane.showMessageDialog(contextPaternComponent, "Contact Book is empty");
					return;
				}
				contextPaternComponent.setVisible(false);
				new ContactBookSearchOrRemoveUI(contextPaternComponent, contactBook, "Remove", "Select");
			}
		});

		removeAllContactsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (contactBook.isEmpty()) {
					JOptionPane.showMessageDialog(contextPaternComponent, "Contact Book is empty");
					return;
				}
				contactBook.removeAllContact();
				JOptionPane.showMessageDialog(contextPaternComponent, "All contacts removed succesfully");
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				JOptionPane.showMessageDialog(contextPaternComponent,
						"will exit from the aplication(will lose all information)", "warning", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});

		this.setLocationRelativeTo(null);
		this.setSize(200, 300);
		this.setVisible(true);
	}

}
