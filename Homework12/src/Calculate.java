
/**
 * Calculate.java
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
import javax.swing.JSpinner;
import javax.swing.*;


/**
 * This class generates the interface for all the conversions
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Calculate extends JFrame implements ActionListener {

	//declare the components needed for the interface to be complete
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblInches;
	private JLabel lblMeters;
	public JTextField textField_1;
	private JButton btnConvert;
	private JLabel lblMeter;
	private JLabel lblInches_1;
	public JTextField textField_3;
	private JButton btnConvert_1;
	private JLabel lblKmh;
	private JLabel lblMPH;
	public JTextField textField_5;
	private JLabel lblMph;
	private JLabel lblkmh_2;
	public JTextField textField_7;
	private JButton btnConvert_2;
	private JButton btnConvert_3;
	private JLabel lblKms;
	private JLabel lblLightYears;
	public JTextField textField_9;
	private JButton btnConvert_4;
	private JLabel lblLightYears_1;
	private JLabel lblKms_1;
	public JTextField textField_11;
	private JButton btnConvert_5;
	private JLabel lblCelsius;
	private JLabel lblFarenheit;
	public JTextField textField_13;
	private JButton btnConvert_6;
	private JLabel lblFarenheit_1;
	private JLabel lblCelsius_1;
	public JTextField textField_15;
	private JButton btnConvert_7;
	public static Calculate frame;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JSpinner spinner_5;
	private JSpinner spinner_6;
	private JSpinner spinner_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//create the instance of the Calculate class
					frame = new Calculate();
					
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
	public Calculate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the bounds of the window
		setBounds(100, 100, 450, 300);
		
		//set the title of the window
		setTitle("Calculate");
		
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
		
		
		//create the label
		lblMeters = new JLabel("Meters :");
		
		//create the text field
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		
		//create the button and make it responsive to mouse clicks
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(this);
		
		//create the label
		lblMeter = new JLabel("Meters :");
		
		//create the label
		lblInches_1 = new JLabel("Inches :");
		
		//create the textfield
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_1 = new JButton("Convert");
		btnConvert_1.addActionListener(this);
		
		//create the spinner for the input
		 spinner = new JSpinner();
		 JFormattedTextField ft=((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		 ft.setEditable(false);
		
		 //create the spinner for the input
		spinner_1 = new JSpinner();
		JFormattedTextField ft1=((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		ft1.setEditable(false);
		
		//set the layout of the panel and give proper alignment to the components added in the panel
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInches)
							.addGap(18)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMeters)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMeter)
							.addGap(18)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(lblMeters)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeter)
						.addComponent(lblInches_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		//create the label
		lblMPH = new JLabel("MPH :");
		
		//create the text field for output
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		//create the label
		lblMph = new JLabel("MPH :");
		
		//create the label
		lblkmh_2 = new JLabel("km/h :");
		
		//create the text field for output
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_2 = new JButton("Convert");
		btnConvert_2.addActionListener(this);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_3 = new JButton("Convert");
		btnConvert_3.addActionListener(this);
		
		//create the spinner for input
		spinner_2 = new JSpinner();
		JFormattedTextField ft2=((JSpinner.DefaultEditor)spinner_2.getEditor()).getTextField();
		ft2.setEditable(false);
		
		//create the spinner for input
		spinner_3 = new JSpinner();
		JFormattedTextField ft3=((JSpinner.DefaultEditor)spinner_3.getEditor()).getTextField();
		ft3.setEditable(false);
		
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
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMPH))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblMph)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblkmh_2)))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConvert_3)
						.addComponent(btnConvert_2)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKmh)
						.addComponent(lblMPH)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConvert_2)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMph)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblkmh_2)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		//create the label
		lblLightYears = new JLabel("Light years:");
		
		//create the text field for output
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_4 = new JButton("Convert");
		btnConvert_4.addActionListener(this);
		
		//create the label
		lblLightYears_1 = new JLabel("Light Years :");
		
		//create the label
		lblKms_1 = new JLabel("Kms :");
		
		//create the text field for output
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_5 = new JButton("Convert");
		btnConvert_5.addActionListener(this);
		
		
		//create the spinner for input
		spinner_4 = new JSpinner();
		JFormattedTextField ft4=((JSpinner.DefaultEditor)spinner_4.getEditor()).getTextField();
		ft4.setEditable(false);
		
		//create the spinner for input
		spinner_5 = new JSpinner();
		JFormattedTextField ft5=((JSpinner.DefaultEditor)spinner_5.getEditor()).getTextField();
		ft5.setEditable(false);
		
		//set the layout of the tab and allot proper alignment to the components in the tab
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblKms)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLightYears)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_4)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblLightYears_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
						.addComponent(lblLightYears)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert_4)
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLightYears_1)
						.addComponent(lblKms_1)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		//create the label
		lblFarenheit = new JLabel("Farenheit :");
		
		//create the text field for output
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_6 = new JButton("Convert");
		btnConvert_6.addActionListener(this);
		
		//create the label
		lblFarenheit_1 = new JLabel("Farenheit :");
		
		//create the label
		lblCelsius_1 = new JLabel("Celsius :");
		
		//create the text field for the output
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setEditable(false);
		
		//create the button to convert and make it responsive to mouse clicks
		btnConvert_7 = new JButton("Convert");
		btnConvert_7.addActionListener(this);
		
		//create the spinner for the input
		spinner_6 = new JSpinner();
		JFormattedTextField ft6=((JSpinner.DefaultEditor)spinner_6.getEditor()).getTextField();
		ft6.setEditable(false);
		
		//create the spinner for the input
		spinner_7 = new JSpinner();
		JFormattedTextField ft7=((JSpinner.DefaultEditor)spinner_7.getEditor()).getTextField();
		ft7.setEditable(false);
		
		//set the layout for the tab and allot proper alignment to the components in the tab
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblCelsius)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFarenheit)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConvert_6)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblFarenheit_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
						.addComponent(lblFarenheit)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConvert_6)
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFarenheit_1)
						.addComponent(lblCelsius_1)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					Object inches=spinner.getValue();
					
					
						//convert the input to double
						Double inch=null;
						
						inch=new Double(inches.toString());
					
						if(inch.toString().compareTo("0")<0){
							textField_1.setText("input cannot be negative");
						}
						else{	
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
					Object m=spinner_1.getValue();
					
					
					
						//convert the input to double
						Double mt=null;
						
							mt=new Double(m.toString());
				if(mt.toString().compareTo("0")<0){
					textField_3.setText("input cannot be negative");
				}
							else{
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
					Object kmh=spinner_2.getValue();
					
					
				
						//convert the input to double
						Double kmph=null;
						
							kmph=new Double(kmh.toString());
				
							if(kmph.toString().compareTo("0")<0){
							textField_5.setText("input cannot be negative");
						}
						else{
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
				Object mph=spinner_3.getValue();
				
				
				
					//convert the input to double
					Double mphh=null;
					
						mphh=new Double(mph.toString());
						
						if(mphh.toString().compareTo("0")<0){
						textField_7.setText("input cannot be negative");
						}
					
						else{
					
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
					Object kilo=spinner_4.getValue();
					
					
					
						//convert the input to double
						Double k=null;
						
							k=new Double(kilo.toString());
							if(k.toString().compareTo("0")<0){
								textField_9.setText("input cannot be negative");
							}
							else{
						
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
					Object lightYear=spinner_5.getValue();
					
					
					
						//convert the input to double
						Double light=null;
						
							light=new Double(lightYear.toString());
						
					if(light.toString().compareTo("0")<0){
					textField_11.setText("input cannot be negative");	
					}
					else{
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
				Object cel=spinner_6.getValue();
				
				
					//convert the input to double
					Double cel1=null;
					
						cel1=new Double(cel.toString());
						
						
					//convert celsius to farenheit
					double f;
					f=cel1*9/5+32;
					
					//convert the result to a string
					String faren=String.valueOf(f);
					
					//set the string as the text in the output text box
					textField_13.setText(faren);
				}
				
				else if(src==btnConvert_7){
					
					//take the input for farenheit from the text field
					Object faren=spinner_7.getValue();
					
					
						//convert the input to double
						Double f=null;
						
							f=new Double(faren.toString());
						
							
						
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
