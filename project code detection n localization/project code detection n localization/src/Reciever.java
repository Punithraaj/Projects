import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Reciever {

	public JLabel T1a = new JLabel("");
	public JLabel T1b = new JLabel(" ");
	public JLabel fname = new JLabel();

	public Font f = new Font("Times new roman", Font.BOLD, 22);
	public Font f1 = new Font("Times new roman", Font.BOLD, 15);
	public Font f2 = new Font("Arial", Font.BOLD, 17);
	public Font f3 = new Font("Times new roman", Font.BOLD, 18);
	public JLabel T0 = new JLabel("");
	public JLabel T1 = new JLabel("File Receiving Path:");
	public JLabel T2 = new JLabel("Server Status     :");
	public JLabel T3 = new JLabel("File receive path ");
	public JLabel T4 = new JLabel("running and waiting");
	public JLabel T5 = new JLabel("Answer    :");

	public JCheckBox chk1 = new JCheckBox("");
	public JComboBox TAreu = new JComboBox();
	public JButton btn = new JButton("Send");
	public JTextArea tf = new JTextArea();
	public JScrollPane pane = new JScrollPane();

	public JButton btn2 = new JButton("Send");

	public JTextField txt = new JTextField();
	public JTextField txt1 = new JTextField();
	public JTextField txt2 = new JTextField();
	JLabel imageLabel = new JLabel();

	JLabel receive = new JLabel();

	JLabel image = new JLabel();
	JLabel imageLabel1 = new JLabel();
	JLabel image1 = new JLabel();

	JLabel imageLabel2 = new JLabel();
	JLabel image12 = new JLabel();
	public JLabel tfld = new JLabel();
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	public JLabel leftButton;
	public JLabel proxyques;
	String accesspoint;
	public JLabel line;
	public JLabel line1;
	public JLabel imagelabel = new JLabel();
	public JFrame jf;
	public Container c;
	JLabel sys = new JLabel();

	@SuppressWarnings("deprecation")
	Reciever() {

		String ip = JOptionPane.showInputDialog(null,
				"Enter the Cluster Topology IPAddress");

		jf = new JFrame("Receiver");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(650, 800);
		jf.setResizable(false);
		c.setBackground(new Color(193, 222, 216));
		T1a.setBounds(50, 5, 650, 45);
		T1a.setFont(f);
		T1a.setForeground(Color.white);
		T1b.setBounds(155, 40, 450, 45);
		T1b.setFont(f);
		T1b.setForeground(Color.white);

		ImageIcon redsys = new ImageIcon(this.getClass().getResource(
				"redsystem.png"));
		sys.setIcon(redsys);
		sys.setBounds(120, 140, 400, 300);

		LineBorder border1 = new LineBorder(Color.blue);
		Border b11 = BorderFactory.createRaisedBevelBorder();

		Border b0 = BorderFactory.createCompoundBorder(border1, b11);
		// Border lineBorder = BorderFactory.createLineBorder(new Color(211,
		// 217,
		// 184));
		line = new JLabel();
		line.setBorder(b0);
		line.setBounds(70, 140, 500, 280);

		TitledBorder leftBorder = BorderFactory
				.createTitledBorder("File Transmit");
		leftBorder.setTitleJustification(TitledBorder.LEFT);
		leftButton = new JLabel();
		leftButton.setBorder(leftBorder);
		leftButton.setBounds(70, 200, 500, 300);
		leftBorder.setTitleColor(Color.ORANGE);

		TitledBorder leftBorder1 = BorderFactory
				.createTitledBorder("Received File");

		Border b01 = BorderFactory.createCompoundBorder(border1, leftBorder1);

		leftBorder.setTitleJustification(TitledBorder.LEFT);
		proxyques = new JLabel();
		proxyques.setBorder(b01);

		proxyques.setBounds(70, 430, 500, 280);
		leftBorder1.setTitleColor(Color.ORANGE);

		c.add(fname);

		T0.setBounds(200, 80, 350, 45);
		T0.setFont(f);

		T0.setForeground(Color.CYAN);
		T2.setBounds(105, 660, 250, 45);
		T2.setFont(f1);
		T2.setForeground(new Color(211, 217, 184));

		T1.setForeground(new Color(211, 217, 184));
		T1.setBounds(105, 570, 300, 150);
		T1.setFont(f1);
		txt1.setBounds(105, 280, 300, 25);
		txt1.setFont(f1);

		T3.setBounds(265, 625, 250, 45);
		T3.setFont(f1);
		T3.setForeground(Color.cyan);

		T4.setBounds(255, 660, 350, 45);
		T4.setFont(f1);
		T4.setForeground(Color.RED);

		T5.setBounds(125, 590, 250, 45);
		T5.setFont(f3);
		T5.setForeground(new Color(211, 217, 184));
		txt2.setBounds(220, 595, 250, 30);
		txt2.setForeground(Color.BLUE);
		txt2.setFont(f1);

		btn.setBounds(420, 420, 120, 30);
		btn.setFont(f3);
		btn.setForeground(new Color(120, 0, 0));

		btn2.setBounds(420, 650, 120, 30);
		btn2.setFont(f3);
		btn2.setForeground(new Color(120, 0, 0));

		jp.setBounds(85, 110, 850, 550);
		jp.setBackground(new Color(211, 217, 184));

		jp1.setBounds(80, 105, 860, 560);

		receive.setBounds(445, 720, 250, 45);
		receive.setForeground(Color.RED);

		txt.setBounds(260, 150, 180, 25);
		txt.setForeground(Color.BLUE);
		txt.setFont(f1);
		TAreu.setBounds(650, 550, 200, 35);

		TAreu.addItem("Mesh Route");
		TAreu.addItem(" Node ");
		TAreu.setFont(f3);
		TAreu.setForeground(Color.BLUE);
		TAreu.setFont(f);
		pane.setBounds(115, 470, 400, 200);

		tf.setColumns(20);

		tf.setForeground(Color.MAGENTA);
		tf.setFont(f1);
		tf.setRows(10);
		// tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		tfld.setBounds(410, 160, 200, 30);
		tfld.setFont(f2);
		tfld.setForeground(new Color(120, 0, 0));
		btn.setMnemonic(KeyEvent.VK_S);
		jf.show();

		c.add(T1a);
		c.add(T1b);
		c.add(sys);
		c.add(line);
		c.add(receive);

		c.add(pane, BorderLayout.CENTER);

		c.add(T0);
		c.add(proxyques);

		try {
			Socket socket = new Socket(ip, 111);
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());

			InetAddress ia = InetAddress.getLocalHost();
			String ip1 = ia.getHostAddress();

			dos.writeUTF("Destination");
			dos.writeUTF("Topology");
			dos.writeUTF(ip1);
			dos.writeUTF("Connected");

		} catch (Exception exx) {
			System.out.println(exx.getMessage());
		}

		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		c.add(imagelabel);

		int[] ports = new int[] { 10001 };

		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();
		}

	}

	public static void main(String[] args) {
		new Reciever();
	}

	class PortListener implements Runnable {
		BufferedOutputStream bos = null;

		ServerSocket server;
		Socket connection;
		BufferedReader br = null;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

	
		public void run() {

			if (this.port == 10001) {

				try {

					Socket con1;
					ServerSocket server1 = new ServerSocket(10001);

					while (true) {

						con1 = server1.accept();

						System.out.println("Reciever Listening");
						DataInputStream din = new DataInputStream(
								con1.getInputStream());

						String data = din.readUTF();

						tf.setText(data);

						fname.setForeground(Color.red);
						fname.setBounds(150, 440, 100, 25);

						ImageIcon redsys = new ImageIcon(this.getClass()
								.getResource("bluescreensys.png"));
						sys.setIcon(redsys);
						sys.setBounds(120, 140, 400, 300);

					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
