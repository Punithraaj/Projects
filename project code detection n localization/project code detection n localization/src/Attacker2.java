import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Attacker2 implements ActionListener {

	JFrame jf = new JFrame("cluster-2 Attacker");
	Container c;
	JLabel src = new JLabel("Cluster");
	JLabel dest = new JLabel("Node");
	JLabel cluster = new JLabel("IPAddress");

	JComboBox jc = new JComboBox();
	JTextField t1 = new JTextField();
	JTextField textip = new JTextField();

	JButton request = new JButton("Display");
	JButton update = new JButton("Update IP");
	JButton reset = new JButton("Reset");

	JScrollPane pane = new JScrollPane();
	JTextArea ta = new JTextArea();

	ImageIcon im;
	JLabel l1;
	String ip;

	Attacker2() {

		c = jf.getContentPane();
		c.setLayout(null);

		im = new ImageIcon(this.getClass().getResource("green.png"));
		l1 = new JLabel();
		l1.setIcon(im);
		l1.setBounds(-10, 0, 520, 700);

		src.setBounds(50, 100, 100, 25);
		dest.setBounds(50, 150, 100, 25);
		cluster.setBounds(50, 200, 100, 25);

		src.setForeground(Color.white);
		dest.setForeground(Color.white);
		cluster.setForeground(Color.white);

		jc.addItem("Node8");
		jc.addItem("Node9");
		jc.addItem("Node10");
		jc.addItem("Node12");
		jc.addItem("Node13");
		jc.addItem("Node14");

		t1.setText("Cluster2");
		t1.setEditable(false);

		ta.setRows(15);
		ta.setColumns(15);
		pane.setViewportView(ta);

		t1.setBounds(165, 100, 150, 25);
		jc.setBounds(165, 150, 150, 25);
		textip.setBounds(165, 200, 150, 25);

		request.setBounds(325, 100, 125, 25);
		update.setBounds(75, 250, 125, 25);
		reset.setBounds(220, 250, 125, 25);

		pane.setBounds(80, 350, 350, 280);

		c.add(cluster);
		c.add(textip);
		c.add(t1);
		c.add(dest);
		c.add(jc);
		c.add(src);
		c.add(request);
		c.add(update);
		c.add(reset);
		c.add(pane);

		c.add(l1);
		jf.setSize(500, 700);
		jf.setVisible(true);
		jf.setResizable(false);

		request.addActionListener(this);
		update.addActionListener(this);
		reset.addActionListener(this);

	}

	public static void main(String[] args) {
		new Attacker2();
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

		Object o = e.getSource();
		if (o == request) {

			String cluster = t1.getText();
			String node = (String) jc.getSelectedItem();

			ip = JOptionPane.showInputDialog(null, "Enter Router IPAddress");

			try {

				Socket soc = new Socket(ip, 500);
				DataOutputStream dos = new DataOutputStream(
						soc.getOutputStream());
				dos.writeUTF(cluster);
				dos.writeUTF(node);

				DataInputStream dis = new DataInputStream(soc.getInputStream());
				String res = dis.readUTF();

				if (res.equals("no")) {
					JOptionPane.showMessageDialog(null, "Enter Valid data");
				} else {
					textip.setText(res);
				}

			} catch (Exception exx) {
				System.out.println(exx.getMessage());
			}

		}

		if (o == update) {

			try {

				String cl = t1.getText();
				String node = (String) jc.getSelectedItem();
				String ipadd = textip.getText();

				Socket socket = new Socket(ip, 501);

				DataOutputStream ds = new DataOutputStream(
						socket.getOutputStream());
				ds.writeUTF(cl);
				ds.writeUTF(node);
				ds.writeUTF(ipadd);

				JOptionPane.showMessageDialog(null, "IPAddress Updated");

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}
}
