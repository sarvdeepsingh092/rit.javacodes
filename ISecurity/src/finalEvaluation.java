import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class finalEvaluation extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea; 
	static File evaluation = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/Evaluation.txt");
	static File scoreFinal = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/finalScore.txt");
	int finalScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalEvaluation frame = new finalEvaluation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public finalEvaluation() {
		setTitle("Final Evaluation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textArea = new JTextArea();
		
		JLabel lblNewLabel = new JLabel("Final Evaluation:");
		
		JButton btnGetReuslt = new JButton("Get Result");
		btnGetReuslt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FileReader reader = new FileReader(evaluation);
					BufferedReader read = new BufferedReader(reader);
					StringBuffer output = new StringBuffer();
					String input="";
					while((input =read.readLine())!=null){
						output.append(input+"\n");
					}
					
					FileReader reader1 = new FileReader(scoreFinal);
					BufferedReader read1 = new BufferedReader(reader1);
					
					StringBuffer readline = new StringBuffer();
					
					String input1="";
					while((input1=read1.readLine())!=null){
						readline.append(input1);
					}
					input1=readline.toString();
					finalScore = Integer.parseInt(input1);
					
					if(finalScore<=14){
						output.append("The security of your computer is weak\n");
					}
					else if(finalScore>14&&finalScore<=18){
						output.append("The security of your computer is average\n");
					}
					else if(finalScore>18){
						output.append("The security of your computer is Strong\n");
					}
					textArea.setText(output.toString());
					read.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
							.addComponent(btnGetReuslt)
							.addGap(33))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnGetReuslt))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
