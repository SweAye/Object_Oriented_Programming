import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * This is the View and Controller part of the program
 * @author Aye Swe
 *
 */
public class Views extends JFrame {
	private Model m;
	private ArrayList<String> list;

	public Views() {
		list = new ArrayList<String>();
		m = new Model();
		JPanel panel = new JPanel();
		JButton button = new JButton("add");

		JTextArea textArea = new JTextArea(10, 25);

		JTextField textField = new JTextField("Type here");

		/**
		 * This is the MVC's controller part of the program
		 */
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				m.addTexts(s);// add the test to modle (update the model)

				textArea.setText(m.getTextArray().toString() + "\n");
			}

		});

		panel.setLayout(new BorderLayout());
		panel.add(button, BorderLayout.NORTH);
		panel.add(textArea, BorderLayout.CENTER);
		panel.add(textField, BorderLayout.SOUTH);

		this.add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

}
