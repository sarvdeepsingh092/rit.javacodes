import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;


public class VirusWarning extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int counterC;
	int counterSh;
	int counterExe;
	int counterJar;
	int counterZip;
	private JButton btnScan;
	static int finalScore;
	static File scoreFinal = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/finalScore.txt");
	ArrayList<String> fileName=new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirusWarning frame = new VirusWarning();
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
	public VirusWarning() {
		setTitle("Virus Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterThePath = new JLabel("Enter the path:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblResult = new JLabel("Result:");
		
		btnScan = new JButton("Scan");
		btnScan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File f = new File(textField.getText());
				readAllFiles(f, textField.getText());
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalEvaluation eval = new finalEvaluation();
				eval.setVisible(true);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(lblEnterThePath)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(lblResult)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(btnScan))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(btnNext)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblEnterThePath)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnScan)
					.addGap(24)
					.addComponent(lblResult)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNext)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void readAllFiles(File f, String path){
		for(File files: f.listFiles()){
			if(files.isFile()){
				fileName.add(files.getName());
			}
		}
		scanForVirus(path);
	}
	
	public void scanForVirus(String path){
		StringBuffer output = new StringBuffer();
		/*for(int i=3;i<fileName.size();i++){
			System.out.println(fileName.get(i));
		}*/
		for(int i=0;i<fileName.size();i++){
			String[] extensions = fileName.get(i).split("\\.");
			/*for(int j=0;j<extensions.length;j++){
				System.out.println("extensions array position "+j+" "+extensions[j]);
			}*/
			if(extensions[extensions.length-1].equals("c")){
				counterC++;
			}
			if(extensions[extensions.length-1].equals("sh")){
				counterSh++;
			}
			if(extensions[extensions.length-1].equals("exe")){
				counterExe++;
			}
			if(extensions[extensions.length-1].equals("jar")){
				counterJar++;
			}
			if(extensions[extensions.length-1].equals("zip")){
				counterZip++;
			}
		}
		try{
			FileReader reader = new FileReader(scoreFinal);
			BufferedReader read = new BufferedReader(reader);
			
			StringBuffer outputscore = new StringBuffer();
			String input="";
			
			
			while((input = read.readLine())!=null){
				outputscore.append(input);
			}
			
			read.close();
			input = outputscore.toString();
			finalScore = Integer.parseInt(input);
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		if(counterC>=2||counterSh>=2||counterExe>=2||counterJar>=2||counterZip>=2){
			output.append("please scan "+path+" path with your antivirus software");
			finalScore+=2;
			}
		else{
			finalScore+=3;
			output.append(path+" is clean");
		}
		textField_1.setText(output.toString());
		writetoEvaluation(output.toString());
		writeToFile(finalScore);
	}
	public void writetoEvaluation(String input){
		File file = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/Evaluation.txt");
		try{
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write(input+"\n");
		bwriter.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void writeToFile(int score){
		try{
		FileWriter writer = new FileWriter(scoreFinal);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write(String.valueOf(score));
		bwriter.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
