import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

public class MANGUI {

	private JFrame frmTheExplorationOf;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MANGUI window = new MANGUI();
					window.frmTheExplorationOf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MANGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheExplorationOf = new JFrame();
		frmTheExplorationOf.setTitle("The Exploration of MAN: A linux help system");
		frmTheExplorationOf.setBounds(100, 100, 600, 600);
		frmTheExplorationOf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheExplorationOf.getContentPane().setLayout(new MigLayout("", "[133.00][33][grow]", "[][][grow]"));
		
		textField = new JTextField();
		frmTheExplorationOf.getContentPane().add(textField, "flowx,cell 0 0,alignx left");
		textField.setColumns(14);
		
		JLabel lblContents = new JLabel("Contents:");
		frmTheExplorationOf.getContentPane().add(lblContents, "flowx,cell 0 1,growx");
		
		JButton btnSearch = new JButton("Search");
		frmTheExplorationOf.getContentPane().add(btnSearch, "cell 0 0");
		
		JLabel lblCommands = new JLabel("Commands:");
		frmTheExplorationOf.getContentPane().add(lblCommands, "cell 0 1,growx");
		
		JButton btnBack = new JButton("Back");
		frmTheExplorationOf.getContentPane().add(btnBack, "flowx,cell 2 1");
		
		JButton btnForward = new JButton("Forward");
		frmTheExplorationOf.getContentPane().add(btnForward, "cell 2 1");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Sytem", "Directories", "Files"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		frmTheExplorationOf.getContentPane().add(list, "flowx,cell 0 2,grow");
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"cd", "ls", "mkdir", "rmdir"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		frmTheExplorationOf.getContentPane().add(list_1, "cell 0 2,grow");
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setText("Welcome to the exploration of MAN");
		frmTheExplorationOf.getContentPane().add(txtrWelcome, "cell 2 2,grow");
	}

}
