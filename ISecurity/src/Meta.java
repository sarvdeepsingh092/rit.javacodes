import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


public class Meta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnEvaluateMetadata;
	static int score;
	static int finalScore;
	private JButton btnNext;
	static File scoreFinal = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/finalScore.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meta frame = new Meta();
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
	public Meta() {
		setTitle("MetaData");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterTheFile = new JLabel("Enter the file name with path");
		
		textArea = new JTextArea();
		
		btnEvaluateMetadata = new JButton("Evaluate Metadata");
		btnEvaluateMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(textField.getText());
				try{
					getDetails(f);
				}
				catch(IOException|InterruptedException it){
					
					it.printStackTrace();
				}
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VirusWarning frame = new VirusWarning();
				frame.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
								.addComponent(lblEnterTheFile)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(btnEvaluateMetadata)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNext)
									.addGap(36))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblEnterTheFile)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEvaluateMetadata)
						.addComponent(btnNext))
					.addGap(18)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void getDetails(File f)throws IOException, InterruptedException{
		
		Path file=Paths.get(f.getPath());
		
		BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
		StringBuffer output=new StringBuffer();
		
		output.append("Last Access time: "+attributes.lastAccessTime()+"\n");
		output.append("Last Modified time: "+attributes.lastModifiedTime()+"\n");
		output.append("Is a Directory? "+attributes.isDirectory()+"\n");
		output.append("is a regular file? "+attributes.isRegularFile()+"\n");
		output.append("size of the file: "+attributes.size()+" bytes\n");
		
		String fileName = f.getName();
		String extensions[] = fileName.split("\\.");
		boolean flag= false;
		if(extensions[extensions.length-1].equals("jar")){
			
			String commands[] = new String[3];
			
			ProcessBuilder pb = new ProcessBuilder("jarsigner", "-verify", f.getPath());
			Process p = pb.start();
			p.waitFor();
			InputStream inputStream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(reader);
			String line;
			while((line = br.readLine())!=null){
				if(line.contains("verified")){
					flag = true;
				}
			}
			if(!flag){
				output.append("file does not have signature");
			}
			else{
				output.append("file is signed");
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
		if(output.toString().contains("signed")){
			finalScore+=3;
			//output.append("\nThe score is "+score);
		}
		else{
			finalScore+=2;
			//output.append("\nThe score is "+score);
		}
		textArea.setText(output.toString());
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
	public void writeToFile(int score)throws IOException{
		FileWriter writer = new FileWriter(scoreFinal);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write(String.valueOf(score));
		bwriter.close();
		
	}
}
