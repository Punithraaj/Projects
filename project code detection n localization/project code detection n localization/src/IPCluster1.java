import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPCluster1 implements ActionListener {

	JFrame jf = new JFrame("Cluster-1");
	Container c;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton submit, reset;

	IPCluster1() {
		c = jf.getContentPane();
		c.setLayout(null);

		l1 = new JLabel("Node-2");
		l2 = new JLabel("Node-3");
		l3 = new JLabel("Node-5");
		l4 = new JLabel("Node-6");
		l5 = new JLabel("Node-7");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();

		submit = new JButton("Assign IPAddress");
		reset = new JButton("Reset");

		l1.setBounds(50, 50, 100, 25);
		l2.setBounds(50, 100, 100, 25);
		l3.setBounds(50, 150, 100, 25);
		l4.setBounds(50, 200, 100, 25);
		l5.setBounds(50, 250, 100, 25);

		t1.setBounds(150, 50, 150, 25);
		t2.setBounds(150, 100, 150, 25);
		t3.setBounds(150, 150, 150, 25);
		t4.setBounds(150, 200, 150, 25);
		t5.setBounds(150, 250, 150, 25);

		submit.setBounds(35, 320, 150, 30);
		reset.setBounds(190, 320, 125, 30);

		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(t5);
		c.add(submit);
		c.add(reset);

		c.setBackground(Color.cyan);
		jf.setSize(380, 450);
		jf.setVisible(true);
		jf.setResizable(false);

		submit.addActionListener(this);
		reset.addActionListener(this);

	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

		if (e.getSource() == submit) {

			String ip1 = t1.getText();
			String ip2 = t2.getText();
			String ip3 = t3.getText();
			String ip4 = t4.getText();
			String ip5 = t5.getText();

			String Node2 = "Node2";
			String Node3 = "Node3";
			String Node5 = "Node5";
			String Node6 = "Node6";
			String Node7 = "Node7";
			String cluster = "Cluster1";
			String status = "default";
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect = DriverManager
						.getConnection("jdbc:odbc:Cluster");
				Statement stmt = connect.createStatement();
				Statement stmt2 = connect.createStatement();
				Statement stmt3 = connect.createStatement();
				Statement stmt4 = connect.createStatement();
				Statement stmt5 = connect.createStatement();
				Statement stmt6 = connect.createStatement();
				Statement stmt7 = connect.createStatement();
				Statement stmt8 = connect.createStatement();
				Statement stmt9 = connect.createStatement();
				Statement stmt10 = connect.createStatement();

				String sql = "Update NodeStatus set IPaddress = '" + ip1
						+ "' where Node = '" + Node2 + "' and cluster = '"
						+ cluster + "'  ";

				String sql1 = "Update NodeStatus set IPaddress = '" + ip2
						+ "' where Node = '" + Node3 + "' and cluster = '"
						+ cluster + "'  ";

				String sql2 = "Update NodeStatus set IPaddress = '" + ip3
						+ "' where Node = '" + Node5 + "' and cluster = '"
						+ cluster + "'  ";

				String sql3 = "Update NodeStatus set IPaddress = '" + ip4
						+ "' where Node = '" + Node6 + "' and cluster = '"
						+ cluster + "'  ";

				String sql4 = "Update NodeStatus set IPaddress = '" + ip5
						+ "' where Node = '" + Node7 + "' and cluster = '"
						+ cluster + "'  ";

				stmt.executeUpdate(sql);
				stmt2.executeUpdate(sql1);
				stmt3.executeUpdate(sql2);
				stmt4.executeUpdate(sql3);
				stmt5.executeUpdate(sql4);

				String sql5 = "Update NodeStatusUpdated set IPaddress = '"
						+ ip1 + "', status = '" + status + "' where Node = '"
						+ Node2 + "' and cluster = '" + cluster + "'   ";

				String sql6 = "Update NodeStatusUpdated set IPaddress = '"
						+ ip2 + "', status = '" + status + "' where Node = '"
						+ Node3 + "' and cluster = '" + cluster + "'   ";
				String sql7 = "Update NodeStatusUpdated set IPaddress = '"
						+ ip3 + "', status = '" + status + "' where Node = '"
						+ Node5 + "' and cluster = '" + cluster + "'   ";

				String sql8 = "Update NodeStatusUpdated set IPaddress = '"
						+ ip4 + "', status = '" + status + "' where Node = '"
						+ Node6 + "' and cluster = '" + cluster + "'   ";

				String sql9 = "Update NodeStatusUpdated set IPaddress = '"
						+ ip5 + "', status = '" + status + "' where Node = '"
						+ Node7 + "' and cluster = '" + cluster + "'   ";

				stmt6.executeUpdate(sql5);
				stmt7.executeUpdate(sql6);
				stmt8.executeUpdate(sql7);
				stmt9.executeUpdate(sql8);
				stmt10.executeUpdate(sql9);

				JOptionPane.showMessageDialog(null, "IPAddress Assigned");

			} catch (Exception exx) {
				System.out.println(exx);
				JOptionPane.showMessageDialog(null, exx.getMessage());
			}
		}
	}
}
