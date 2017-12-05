import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class ServiceProvider implements ActionListener {
	JFrame jf = new JFrame("ServiceProvider::Detection and Localization of Multiple Spoofing Attackers in Wireless Networks");
	Container c;

	JButton submit = new JButton("Submit");
	JButton browse = new JButton("Browse-File");
	JButton exit = new JButton("Exit");
	JTextArea ta = new JTextArea();
	JScrollPane pane = new JScrollPane();
	JSeparator sep = new JSeparator();
	JSeparator sep1 = new JSeparator();
	JLabel image,image1;
	ServiceProvider() {

		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.orange);
		
		
		ImageIcon im = new ImageIcon(this.getClass().getResource("ServiceProvider.PNG"));
		
		image = new JLabel();
		image.setIcon(im);
		image.setBounds(0,0,1000,90);
		
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("Ipspoof.jpg"));
		
		image1 = new JLabel();
		image1.setIcon(im1);
		image1.setBounds(460,0,600,590);
		
		
		browse.setBounds(350, 540, 125, 30);
		exit.setBounds(70, 540, 100, 30);
		sep.setBounds(0, 120, 1000, 10);
		sep.setForeground(Color.red);
		submit.setBounds(200, 540, 125, 30);
		sep1.setBounds(0, 530, 1000, 10);
		sep1.setForeground(Color.red);
		ta.setRows(10);
		ta.setColumns(10);
		pane.setViewportView(ta);
		pane.setBounds(5, 135, 450, 330);

		c.add(browse);
		c.add(submit);
		c.add(exit);
		c.add(pane);
		c.add(sep);
		c.add(sep1);
		jf.setBounds(100, 50, 1000, 630);
		jf.setVisible(true);
		

		browse.addActionListener(this);
		submit.addActionListener(this);
		exit.addActionListener(this);

		c.add(image);
		c.add(image1);
	}

	public static void main(String[] args) {
		new ServiceProvider();
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

		
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		
		if (e.getSource() == browse) {
			JFileChooser chooser = new JFileChooser();

			try {

				File f = new File(new File("filename.txt").getCanonicalPath());

				chooser.setSelectedFile(f);

			} catch (IOException e1) {
			}

			int retval = chooser.showOpenDialog(browse);

			if (retval == JFileChooser.APPROVE_OPTION) {

			}

			File curFile = chooser.getSelectedFile();
			try {

				FileInputStream fstream = new FileInputStream(curFile);

				DataInputStream ins = new DataInputStream(fstream);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));
				String strLine;
				StringBuffer buffer = new StringBuffer();
				while ((strLine = br.readLine()) != null) {

					buffer.append(strLine + "\n");

				}
				ta.setText(buffer.toString());

			} catch (Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}

		}
		if (e.getSource() == submit) {
			String ipad = JOptionPane.showInputDialog(null,
					"Enter Router IPAddress");
			try {

				Socket client = new Socket(ipad, 10000);

				String content = ta.getText();

				DataOutputStream dos = new DataOutputStream(
						client.getOutputStream());

				dos.writeUTF(content);
				JOptionPane.showMessageDialog(null,
						"File Uploaded Successfully");

			} catch (Exception e1) {

				e1.printStackTrace();
			}

		}

	}

}
