import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.usb.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class ISecurity extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnEvaluate;
	int scorePassword;
	int scoreLogin;
	int scoreVersion;
	int finalScore;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnEvaluate_1;
	private JButton btnEvaluate_2;
	private JButton btnEvaluate_3;
	static File f = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/Evaluation.txt");
	static File scoreFile = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/finalScore.txt");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ISecurity frame = new ISecurity();
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
	public ISecurity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("I-Security");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Is the Password 8 characters Long?(Y/N)");
		
		JLabel lblNewLabel_1 = new JLabel("Presence of special characters and numbers?(Y/N)");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblIsYourSystem = new JLabel("Is your system password protected(Y/N)");
		
		btnEvaluate = new JButton("Evaluate");
		btnEvaluate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				scorePassword = checkPassword();
			}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblIsYourSystem))
							.addContainerGap(88, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_2, Alignment.LEADING)
								.addComponent(textField_1, Alignment.LEADING)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(btnEvaluate)
							.addGap(43))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(lblIsYourSystem)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGap(1)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEvaluate))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblLoginTimeHhmm = new JLabel("Login Time:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblLogoutTime = new JLabel("Logout Time:");
		
		JLabel lblPleaseEnterTime = new JLabel("Please enter time in hh.mm format");
		
		btnEvaluate_1 = new JButton("Evaluate");
		btnEvaluate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				scoreLogin = checkLoginTime(scorePassword);
			}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLoginTimeHhmm))
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogoutTime))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(90)
					.addComponent(lblPleaseEnterTime)
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEvaluate_1)
					.addContainerGap(284, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPleaseEnterTime)
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoginTimeHhmm)
						.addComponent(lblLogoutTime))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btnEvaluate_1)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		btnEvaluate_2 = new JButton("Evaluate");
		btnEvaluate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					scoreVersion = checkVersion(scoreLogin);
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		
		JLabel lblEvaluateOsVersion = new JLabel("Evaluate OS Version");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(149)
							.addComponent(btnEvaluate_2))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(134)
							.addComponent(lblEvaluateOsVersion)))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(43)
					.addComponent(lblEvaluateOsVersion)
					.addGap(18)
					.addComponent(btnEvaluate_2)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		btnEvaluate_3 = new JButton("Evaluate");
		btnEvaluate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					finalScore = checkFileRights(scoreVersion);
					FileWriter writer = new FileWriter(scoreFile);
					BufferedWriter bwriter = new BufferedWriter(writer);
					bwriter.write(String.valueOf(finalScore));
					bwriter.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		
		JLabel lblEvaluateFileRights = new JLabel("Evaluate File Rights");
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsbDisplay frame = new UsbDisplay();
				frame.setVisible(true);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(143)
							.addComponent(btnEvaluate_3))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(127)
							.addComponent(lblEvaluateFileRights))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(152)
							.addComponent(btnNext)))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(47)
					.addComponent(lblEvaluateFileRights)
					.addGap(18)
					.addComponent(btnEvaluate_3)
					.addGap(34)
					.addComponent(btnNext)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	
	public int checkPassword() throws IOException{
		int versionScore = 0;
		// Scanner scan = new Scanner(System.in);
		
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		//System.out.println("Is your system password protected? (Y/N)");
		String answer = textField.getText();

		if (answer.contentEquals("Y")) {
			bw.write("\nSystem is password protected.");
			versionScore = 2;
			//System.out.println("Is the password 8 characters long? (Y/N)");
			String ans2 = textField_1.getText();
			if (ans2.contentEquals("Y")) {
				//System.out.println("Does the password consists special "
					//	+ "characters and numbers? (Y/N)");
				String ans3 = textField_2.getText();
				if (ans3.contentEquals("Y")) {
					versionScore = 3;
					bw.write("The password has a good strength\n");
				} else if (ans3.contentEquals("N")) {
					versionScore = 2;
					bw.write("The strength of password should be improved "
									+ "by adding special characters and numbers.\n");
				}
			} else if (ans2.contentEquals("N")) {
				versionScore = 2;
				bw.write("The strength of password is weak.\n");
			}
		} else if (answer.contentEquals("N")) {
			bw.write("System is not password protected. The user should "
					+ "protect the system by setting up a password.\n");
			versionScore = 1;
		} 
		bw.close();
		System.out.println("scorePassword: "+versionScore);
		return versionScore;
	}
	
	public int checkLoginTime(int score)throws IOException {
		int versionScore = 0;
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		// Scanner scan = new Scanner(System.in);
	//	System.out.println("Please enter the time frame (hh.mm format) "
			//	+ "during which you usually login.");
		//System.out.print("Login Time: ");
		String Login = textField_3.getText();
		Double timein = Double.parseDouble(Login);
		//System.out.print("Logout Time: ");
		String Logout = textField_4.getText();
		Double timeout = Double.parseDouble(Logout);

		List<String> myList = new ArrayList<String>();
		ArrayList<Double> timeList = new ArrayList<Double>();
		
		String user = System.getProperty("user.name");
		Runtime run = Runtime.getRuntime();
		try {
			Process process = run.exec("last " + user);
			process.getErrorStream();
			process.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);
				line = reader.readLine();
				myList.add(line);
				for (int i = 0; i < myList.size() - 3; i++) {
					int location = myList.get(i).indexOf(":");
					// System.out.println(location);
					char tens = myList.get(i).charAt(location - 2);
					char ones = myList.get(i).charAt(location - 1);
					char decimalOne = myList.get(i).charAt(location + 1);
					char decimalTwo = myList.get(i).charAt(location + 2);
					String s = new StringBuilder().append(tens).append(ones)
							.append(".").append(decimalOne).append(decimalTwo).toString();
					Double time = Double.parseDouble(s);
					timeList.add(time);
				}
			}
			for (Double time : timeList) {
				int flag = 0;
				if (time > timeout || time < timein) {
					flag++;
					if (flag >= 4) {
						versionScore = (1+score);
						bw.write("The account has been used at odd times several times. "
								+ "Kindly check login time.\n");
						break;
					} else if (flag == 2 || flag == 3) {
						versionScore = (2+score);
						bw.write("The account might be at risk, check login time to "
								+ "confirm your timings.\n");
						break;
					} else if (flag == 0 || flag == 1) {
						versionScore = (3+score);
						bw.write("The account login time has been analysed and the "
								+ "status seems to be OK.\n");
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bw.close();
		System.out.println("scoreLogin: "+versionScore);
		return versionScore;
	}
	
	public int checkVersion(int score)throws IOException {
		int versionScore = 0;
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String version = System.getProperty("os.version");

		if (version.contentEquals("10.10.3")) {
			// System.out.println("True");
			versionScore = (3+score);
			bw.write("The OS version is up-to-date.\n");
		} else if (version.contentEquals("10.0.4")
				|| (version.contentEquals("10.1.5"))
				|| (version.contentEquals("10.2.8"))
				|| (version.contentEquals("10.3.9"))
				|| (version.contentEquals("10.4.11"))) {

			versionScore = (1+score);
			bw.write("The OS version is " + version
					+ ". Need to update the version immediately.\n");

		} else if (version.contentEquals("10.5.8")
				|| (version.contentEquals("10.6.8 v1.1"))
				|| (version.contentEquals("10.7.5"))
				|| (version.contentEquals("10.8.5"))
				|| (version.contentEquals("10.9.5"))) {

			versionScore = (2+score);
			bw.write("The OS version is " + version
					+ ". Need to update the version.\n");

		} else if (version.contentEquals("10.9.5")) {
			versionScore = (1+score);
			bw.write("The OS version is "+ version
							+ ". It is recommended to install the "
							+ "newest version as the installed version is the last one.\n");
		}
		bw.close();
		System.out.println("scoreVersion: "+versionScore);
		return versionScore;
	}
	
	public int checkFileRights(int score)throws IOException {
		int versionScore = 0;
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		ArrayList<String> myList = new ArrayList<String>();
		Runtime run = Runtime.getRuntime();
		String user = System.getProperty("user.name");

		Process process = null;
		String command = "ls -l /Users/" + user;
		try {
			process = run.exec(command);
			process.getErrorStream();
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);
				line = reader.readLine();
				myList.add(line);
			}
			int flag = 0;
			for (int i = 0; i < myList.size() - 1; i++) {
				if (myList.get(i).contains("-rwxrwxrwx")) {
					// System.out.println("True");
					flag++;
					if (flag == 3) {
						versionScore = (1+score);
						bw.write("Check file rights for the user folders immediately.\n");
					}
				} else if (myList.get(i).contains("drwxr-xr-x")) {
					flag++;
					if (flag == 3) {
						versionScore = (3+score);
						bw.write("The file rights alloted are perfect.\n");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bw.close();
		System.out.println("finalScore: "+versionScore);
		return versionScore;
	}
}
