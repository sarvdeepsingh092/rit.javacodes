
/**
 * Calculator.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.MouseListener;


/**
 * This class generates the interface for all the conversions
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Calculator extends JFrame implements ActionListener, MouseListener {

	//declare the components needed for the interface to be complete
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblInches;
	public JTextField textField;
	private JLabel lblMeters;
	public JTextField textField_1;
	private JButton btnConvert;
	private JLabel lblMeter;
	public JTextField textField_2;
	private JLabel lblInches_1;
	public JTextField textField_3;
	private JButton btnConvert_1;
	private JLabel lblKmh;
	public JTextField textField_4;
	private JLabel lblMPH;
	public JTextField textField_5;
	private JLabel lblMph;
	public JTextField textField_6;
	private JLabel lblkmh_2;
	public JTextField textField_7;
	private JButton btnConvert_2;
	private JButton btnConvert_3;
	private JLabel lblKms;
	public JTextField textField_8;
	private JLabel lblLightYears;
	public JTextField textField_9;
	private JButton btnConvert_4;
	private JLabel lblLightYears_1;
	public JTextField textField_10;
	private JLabel lblKms_1;
	public JTextField textField_11;
	private JButton btnConvert_5;
	private JLabel lblCelsius;
	public JTextField textField_12;
	private JLabel lblFarenheit;
	public JTextField textField_13;
	private JButton btnConvert_6;
	private JLabel lblFarenheit_1;
	public JTextField textField_14;
	private JLabel lblCelsius_1;
	public JTextField textField_15;
	private JButton btnConvert_7;
	public static Calculator frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//create the instance of the calculator class
					frame = new Calculator();
					
					//set the visibility of the window to true
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the bounds of the window
		setBounds(100, 100, 450, 300);
		
		//set the title of the window
		setTitle("Calculator");
		
		//create the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//create the tabbed pane and allot it the proper layout and alignment
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
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		//create the tabs in the tabbed pane
		panel = new JPanel();
		tabbedPane.addTab("Length", null, panel, "inches to meters and meters to inches");
		
		//create the label
		lblInches = new JLabel("Inches :");
		
		//create the text field
		textField = new JTextField();
		textField.setColumns(10);
		
		
		//create the label
		lblMeters = new JLabel("Meters :");
		
		//create the text field
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		//create the button and make it responsive to mouse clicks
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(this);
		
		//create the label
		lblMeter = new JLabel("Meters :");
		
		//create the text field
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		//create the label
		lblInches_1 = new JLabel("Inches :");
		
		//create the textfield
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_1 = new JButton("Convert");
		btnConvert_1.addActionListener(this);
		
		//set the layout of the panel and give proper alignment to the components added in the panel
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInches)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMeters)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMeter)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblInches_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_1)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInches)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMeters)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeter)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInches_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConvert_1)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//create the second tab in the interface
		panel_1 = new JPanel();
		tabbedPane.addTab("Speed", null, panel_1, "km/h to mph and mph to km/h");
		
		//create the label
		lblKmh = new JLabel("km/h :");
		
		//create the text field for input
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		//create the label
		lblMPH = new JLabel("MPH :");
		
		//create the text field for output
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		//create the label
		lblMph = new JLabel("MPH :");
		
		//create the text field for input
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		//create the label
		lblkmh_2 = new JLabel("km/h :");
		
		//create the text field for output
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_2 = new JButton("Convert");
		btnConvert_2.addActionListener(this);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_3 = new JButton("Convert");
		btnConvert_3.addActionListener(this);
		
		//set the layout of the panel and allot proper alignment to the components in the panel
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblKmh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMPH))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblMph)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblkmh_2)))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConvert_3)
						.addComponent(btnConvert_2)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKmh)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMPH)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConvert_2)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMph)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblkmh_2))
					.addGap(18)
					.addComponent(btnConvert_3)
					.addGap(28))
		);
		panel_1.setLayout(gl_panel_1);
		
		//create the third tab in the interface
		panel_2 = new JPanel();
		tabbedPane.addTab("Distance", null, panel_2, "kms to light years and light years to kms");
		
		//create the label
		lblKms = new JLabel("Kms :");
		
		//create the text field for th input
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		//create the label
		lblLightYears = new JLabel("Light years:");
		
		//create the text field for output
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_4 = new JButton("Convert");
		btnConvert_4.addActionListener(this);
		
		//create the label
		lblLightYears_1 = new JLabel("Light Years :");
		
		//create the text field for the input
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		//create the label
		lblKms_1 = new JLabel("Kms :");
		
		//create the text field for output
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_5 = new JButton("Convert");
		btnConvert_5.addActionListener(this);
		
		//set the layout of the tab and allot proper alignment to the components in the tab
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblKms)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLightYears)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_4)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblLightYears_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKms_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_5)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKms)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLightYears)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert_4)
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLightYears_1)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKms_1)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert_5)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		//create the fourth tab in the interface
		panel_3 = new JPanel();
		tabbedPane.addTab("Temperature", null, panel_3, "celsius to farenheit and farenheit to celsius");
		
		//create the label
		lblCelsius = new JLabel("Celsius :");
		
		//create the text field for input
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		//create the label
		lblFarenheit = new JLabel("Farenheit :");
		
		//create the text field for output
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_6 = new JButton("Convert");
		btnConvert_6.addActionListener(this);
		
		//create the label
		lblFarenheit_1 = new JLabel("Farenheit :");
		
		//create the text field for input
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		//create the label
		lblCelsius_1 = new JLabel("Celsius :");
		
		//create the text field for the output
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_7 = new JButton("Convert");
		btnConvert_7.addActionListener(this);
		
		//set the layout for the tab and allot proper alignment to the components in the tab
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblCelsius)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFarenheit)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_6)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblFarenheit_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCelsius_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_7)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCelsius)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFarenheit)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert_6)
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFarenheit_1)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCelsius_1)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConvert_7)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * The method takes care of the mouse clicks on the buttons
	 * @param e		it is the instance of the ActionEvent class
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//identify the button which is clicked
		Object src=e.getSource();
				
				
				if(src==btnConvert){
					
					
					//take the input for inches from the text field
					String inches=textField.getText();
					
					//if the input is null print a message
					if(inches.equals("")){
						textField.setText("enter value");
					}
					else{
						//convert the input string to double
						double inch=0;
						try{
						inch=Double.parseDouble(inches);
					}
						catch(Exception ex){
							textField.setText("enter digits");
						}
						//convert inches to meters
						double meter;
						meter=inch*0.0254;
						
						//convert the result to a string
						String meters=String.valueOf(meter);
						
						//set the string as the text in the output text box
						textField_1.setText(meters);
					}
				}
				else if(src==btnConvert_1){
					//take the input for meters from the text field
					String m=textField_2.getText();
					
					//if the input is null print a message
					if(m.equals("")){
						textField_2.setText("enter value");
					}
					else{
						//convert the input string to double
						double mt=0;
						try{
							mt=Double.parseDouble(m);
						}
						catch(Exception ex){
							textField_2.setText("enter digits");
						}
						//convert meters to inches
						double i;
						i=mt/0.0254;
						
						//convert the result to a string
						String in=String.valueOf(i);
						
						//set the string as the text in the output text box
						textField_3.setText(in);
						
					}
				}
				else if(src==btnConvert_2){
					//take the input for km/h from the text field
					String kmh=textField_4.getText();
					
					//if the input is null print a message
					if(kmh.equals("")){
						textField.setText("enter value");
					}
					else{
						//convert the input string to double
						double kmph=0;
						try{
							kmph=Double.parseDouble(kmh);
						}
						catch(Exception ex){
							textField_4.setText("enter digits");
						}
						//convert km/h to mph
						double mphh;
						mphh=kmph*0.621371;
						
						//convert the result to a string
						String mph=String.valueOf(mphh);
						
						//set the string as the text in the output text box
						textField_5.setText(mph);
					}
					
				}
				else if(src==btnConvert_3){
					
				//take the input for mph from the text field
				String mph=textField_6.getText();
				
				//if the input is null print a message
				if(mph.equals("")){
					textField_6.setText("enter value");
				}
				else{
					//convert the input string to double
					double mphh=0;
					try{
						mphh=Double.parseDouble(mph);
					}
					catch(Exception ex){
						textField_6.setText("enter digits");
					}
					//convert mph to km/h
					double kmph;
					kmph=mphh/0.621371;
					
					//convert the result to a string
					String kmh=String.valueOf(kmph);
					
					//set the string as the text in the output text box
					textField_7.setText(kmh);
				}
				}
				else if(src==btnConvert_4){
					//take the input for kms from the text field
					String kilo=textField_8.getText();
					
					//if the input is null print a message
					if(kilo.equals("")){
						textField_8.setText("enter value");
					}
					else{
						//convert the input string to double
						double k=0;
						try{
							k=Double.parseDouble(kilo);
						}
						catch(Exception ex){
							textField_8.setText("enter digits");
						}
						//convert kms to lightYears
						double light;
						light=k*1.0570e-13f;
						
						//convert the result to a string
						String lightYear=String.valueOf(light);
						
						//set the string as the text in the output text box
						textField_9.setText(lightYear);
					}
				}
				else if(src==btnConvert_5){
					
					//take the input for lightYears from the text field
					String lightYear=textField_10.getText();
					
					//if the input is null print a message
					if(lightYear.equals("")){
						textField_10.setText("enter value");
					}
					else{
						//convert the input string to double
						double light=0;
						try{
							light=Double.parseDouble(lightYear);
						}
						catch(Exception ex){
							textField_10.setText("enter digits");
						}
						//convert lightYear to kms
						double k;
						k=light/1.0570e-13f;
						
						//convert the result to a string
						String kilo=String.valueOf(k);
						
						//set the string as the text in the output text box
						textField_11.setText(kilo);
					}
					
				}
				else if(src==btnConvert_6){
					
				//take the input for celsius from the text field
				String cel=textField_12.getText();
				
				//if the input is null print a message
				if(cel.equals("")){
					textField_12.setText("enter value");
				}
				else{
					//convert the input string to double
					double cel1=0;
					try{
						cel1=Double.parseDouble(cel);
					}
					catch(Exception ex){
						textField_12.setText("enter digits");
					}
					//convert celsius to farenheit
					double f;
					f=cel1*9/5+32;
					
					//convert the result to a string
					String faren=String.valueOf(f);
					
					//set the string as the text in the output text box
					textField_13.setText(faren);
				}
				}
				else if(src==btnConvert_7){
					
					//take the input for farenheit from the text field
					String faren=textField_14.getText();
					
					//if the input is null print a message
					if(faren.equals("")){
						textField_14.setText("enter value");
					}
					else{
						//convert the input string to double
						double f=0;
						try{
							f=Double.parseDouble(faren);
						}
						catch(Exception ex){
							textField_14.setText("enter digits");
						}
						//convert farenheit to celsius
						double cel;
						cel=(f-32)*5/9;
						
						//convert the result to a string
						String cel1=String.valueOf(cel);
						
						//set the string as the text in the output text box
						textField_15.setText(cel1);
					}
					
				}
				
		
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
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
