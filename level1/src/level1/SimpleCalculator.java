package level1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator implements ActionListener {
	JFrame frame;
	JPanel panel;
	JTextField text;
	JTextField text2;
	JTextField text3;
	JButton button;
	JButton button2;
	JButton button3;
	JButton button4;
	public static void main(String[] args) {
		SimpleCalculator start = new SimpleCalculator();
		start.anOriginalMethodName();
	}
	public void anOriginalMethodName(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		text = new JTextField();
		 text2 = new JTextField();
		 text3 = new JTextField();
		 button = new JButton();
		 button2 = new JButton();
		 button3 = new JButton();
		 button4 = new JButton();
		frame.setVisible(true);
		frame.setSize(700, 400);
		frame.add(panel);
		panel.add(text);
		panel.add(text2);
		panel.add(text3);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button.setText("Addition");
		button2.setText("Subtraction");
		button3.setText("Multiplication");
		button4.setText("Division");
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		text.setPreferredSize(new Dimension(100, 20));
		text2.setPreferredSize(new Dimension(100, 20));
		text3.setPreferredSize(new Dimension(100,20));
		text3.setEditable(false);
		frame.pack();
	}
	public SimpleCalculator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int input = Integer.parseInt(text.getText());
		int input2 = Integer.parseInt(text2.getText());
		int addition = input + input2;
		int subtraction = input - input2;
		int multiplication = input * input2;
		int division = input / input2;
		String addition2 = Integer.toString(addition);
		String subtraction2 = Integer.toString(subtraction);
		String multiplication2 = Integer.toString(multiplication);
		String division2 = Integer.toString(division);
		if(button.equals(e.getSource())){
			text3.setText(addition2);
		} else if(button2.equals(e.getSource())){
			text3.setText(subtraction2);
		}else if(button3.equals(e.getSource())){
			text3.setText(multiplication2);
		}else if(button4.equals(e.getSource())){
			text3.setText(division2);
		}
	}

}
