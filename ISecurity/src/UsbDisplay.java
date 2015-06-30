import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.usb.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import java.awt.event.*;

public class UsbDisplay extends JFrame implements ActionListener, MouseListener {

	static int connected=0;
	static int score=0;
	static int finalScore;
	private JPanel contentPane;
	private JButton btnShowDevices;
	private JButton btnRegister;
	String UsbToRegister;
	ArrayList<String> registeredUsb = new ArrayList<String>();
	private JButton btnShowRegisteredDevices;
	private JTextArea textArea;
	private JButton btnGenerateScore;
	private JButton btnNext;
	static File scoreFinal = new File("/Users/sunnyb/Documents/workspace/FIS_Project/src/finalScore.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsbDisplay frame = new UsbDisplay();
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
	public UsbDisplay() {
		setTitle("USB Devices");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnShowDevices = new JButton("Show Devices");
		btnShowDevices.addActionListener(this);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(this);
		
		btnShowRegisteredDevices = new JButton("Show Registered Devices");
		btnShowRegisteredDevices.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.addMouseListener(this);
		textArea.setEditable(false);
		
		btnGenerateScore = new JButton("Generate Score");
		btnGenerateScore.addActionListener(this);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnShowDevices)
									.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
									.addComponent(btnRegister))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnShowRegisteredDevices)
									.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNext)
										.addComponent(btnGenerateScore))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShowDevices)
						.addComponent(btnRegister))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShowRegisteredDevices)
						.addComponent(btnGenerateScore))
					.addGap(18)
					.addComponent(btnNext)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object id=e.getSource();
		
		if(id==btnShowDevices){
			try{
			UsbServices usbServices= UsbHostManager.getUsbServices();
			UsbHub hub = usbServices.getRootUsbHub();
			StringBuffer dev=new StringBuffer("");
			dev = ListDevices(hub,dev);
			textArea.setText(dev.toString());
		}
			catch(UsbException ex){
				ex.printStackTrace();
			}
	}
		else if(id == btnRegister){
			registeredUsb.add(UsbToRegister);
		}
		else if(id==btnShowRegisteredDevices){
			StringBuffer registered=new StringBuffer();
			for(int i=0;i<registeredUsb.size();i++){
				registered.append(registeredUsb.get(i)+" is registered\n");
			}
			textArea.setText(registered.toString());
		}
		else if(id==btnGenerateScore){
			try{
				FileReader reader = new FileReader(scoreFinal);
				BufferedReader read = new BufferedReader(reader);
				
				StringBuffer output = new StringBuffer();
				String input="";
				
				
				while((input = read.readLine())!=null){
					output.append(input);
				}
				
				read.close();
				input = output.toString();
				finalScore = Integer.parseInt(input);
				System.out.println("final score is: "+finalScore);
				if(registeredUsb.size()<=(connected/2)){
					score=2;
					finalScore+=score;
					
				}
				else {
					score=3;
					finalScore += score;
					
				}
				try{
				writeToFile(finalScore);
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		else if(id==btnNext){
			Meta frame=new Meta();
			frame.setVisible(true);
		}
}
	public StringBuffer ListDevices(UsbHub hub,StringBuffer dev){
	
		List devices = hub.getAttachedUsbDevices();
		Iterator iterateDevice = devices.iterator();
		
		
		while(iterateDevice.hasNext()){
			UsbDevice device = (UsbDevice) iterateDevice.next();
			if(!device.isUsbHub()){
				connected+=1;
				System.out.println(device.toString()+"\n");
				dev.append(device.toString()+"\n");
				
			}
			if(device.isUsbHub()){
				//System.out.println(device +" Is a hub");
				ListDevices((UsbHub) device,dev);
				
			}
		}
		return dev;
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(textArea.getSelectedText()!=null){
			UsbToRegister = textArea.getSelectedText();
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void generateScore()throws IOException{
		
	}
	
	public void writeToFile(int score)throws IOException{
		FileWriter writer = new FileWriter(scoreFinal);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write(String.valueOf(score));
		bwriter.close();
		
	}
}
