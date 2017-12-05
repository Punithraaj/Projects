import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

public class ClusterTopology implements ActionListener {
	JFrame jf;
	Container c;

	Timer timer;

	public JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,
			l15, l16, l17, l18;

	public JButton button = new JButton("Cluster-1 Status");
	public JButton button1 = new JButton("Cluster-2 Status");
	public JButton button2 = new JButton("Cluster-3 Status");

	JLabel ls1, ls2;
	JLabel imageLabel, imageLabel1, imageLabel2, imageLabel3, imageLabel4,
			imageLabel5, imageLabel6, imageLabel7, imageLabel8, imageLabel9,
			imageLabel10, imageLabel11, imageLabel12, imageLabel13,
			imageLabel14, imageLabel15, imageLabel16, imageLabel17,
			imageLabel18, imageLabel19, imageLabel20, imageLabel21,
			imageLabel22, imageLabel23;

	public Font f1 = new Font("Calibrie", Font.BOLD + Font.ITALIC, 25);

	public JLabel node1 = new JLabel("SOURCE");
	public JLabel node2 = new JLabel("Node-2");
	public JLabel node3 = new JLabel("Node-3");
	public JLabel node4 = new JLabel("CH-1");
	public JLabel node5 = new JLabel("Node-5");
	public JLabel node6 = new JLabel("Node-7");
	public JLabel node7 = new JLabel("Node-6");
	public JLabel node8 = new JLabel("Node-8");
	public JLabel node9 = new JLabel("Node-9");
	public JLabel node10 = new JLabel("Node-10");
	public JLabel node11 = new JLabel("CH-2");
	public JLabel node12 = new JLabel("Node-12");
	public JLabel node13 = new JLabel("Node-13");
	public JLabel node14 = new JLabel("Node-14");
	public JLabel node15 = new JLabel("Node-15");
	public JLabel node16 = new JLabel("Node-16");
	public JLabel node17 = new JLabel("Node-17");
	public JLabel node18 = new JLabel("CH-3");
	public JLabel node19 = new JLabel("Node-19");
	public JLabel node20 = new JLabel("Node-20");
	public JLabel node21 = new JLabel("DESTINATION");

	public JLabel imageLabels1;
	public JLabel imageLabeln34;
	public JLabel imageLabeln67;
	public JLabel imageLabeln1011;
	public JLabel imageLabeln1314;
	public JLabel imageLabeln45;
	public JLabel imageLabeln89;
	public JLabel imageLabeln1112;
	public JLabel imageLabeln1516;
	public JLabel imageLabeln1819;
	public JLabel imageLabeln1718;
	public JLabel imageLabelnd20;
	public JLabel Arrow;
	public JLabel Arrow1;

	public JLabel imageLabelsn3 = new JLabel();
	public JLabel imageLabeln46 = new JLabel();
	public JLabel imageLabeln24 = new JLabel();
	public JLabel imageLabeln57 = new JLabel();
	public JLabel imageLabeln911 = new JLabel();

	public JLabel imageLabeln1214 = new JLabel();
	public JLabel imageLabeln810 = new JLabel();
	public JLabel imageLabeln1113 = new JLabel();

	public JLabel imageLabeln1618 = new JLabel();
	public JLabel imageLabeln1517 = new JLabel();

	public JLabel imageLabeln1820 = new JLabel();
	public JLabel imageLabel19d = new JLabel();

	public JLabel c1 = new JLabel("CLUSTER-1");
	public JLabel c2 = new JLabel("CLUSTER-2");
	public JLabel c3 = new JLabel("CLUSTER-3");
	Socket client;

	MenuBar mbr = new MenuBar();
	Menu file = new Menu("File");
	Menu file2 = new Menu("Assign IPAddress");
	MenuItem ipc1, ipc2, ipc3;

	MenuItem item1 = new MenuItem("No Of Attacker Hits");
	MenuItem item11 = new MenuItem("View Spoofing Attackers");
	MenuItem item22 = new MenuItem("View Node IPAddress");
	MenuItem item2 = new MenuItem("Exit");

	String c1n1, c1n2, c1n3, c1n4, c1n5, c1n6, c1n7;
	String c2n1, c2n2, c2n3, c2n4, c2n5, c2n6, c2n7;
	String c3n1, c3n2, c3n3, c3n4, c3n5, c3n6, c3n7;
	String ip1, ip2, ip3, ip4, ip5, ip6, ip7, ip8, ip9, ip10, ip11, ip12, ip13,
			ip14, ip15, ip16, ip17, ip18, ip19, ip20, ip21, ip22;

	String DestIPAddress;

	ClusterTopology() {

		timer = new Timer(100, null);

		jf = new JFrame("Cluster Analysis Router::Detection and Localization of Multiple Spoofing Attackers in Wireless Networks");
		c = jf.getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.ORANGE);

		jf.setMenuBar(mbr);

		ipc1 = new MenuItem("Cluster-1");
		ipc2 = new MenuItem("Cluster-2");
		ipc3 = new MenuItem("Cluster-3");

		mbr.add(file);
		mbr.add(file2);
		file.add(item1);
		file.add(item11);
		file.add(item22);
		file.add(item2);

		file2.add(ipc1);
		file2.add(ipc2);
		file2.add(ipc3);

		c1.setFont(f1);
		c2.setFont(f1);
		c3.setFont(f1);

		c1.setForeground(Color.cyan);
		c2.setForeground(Color.cyan);
		c3.setForeground(Color.cyan);

		imageLabel = new JLabel();
		imageLabel1 = new JLabel();
		imageLabel2 = new JLabel();
		imageLabel3 = new JLabel();
		imageLabel4 = new JLabel();
		imageLabel5 = new JLabel();
		imageLabel6 = new JLabel();
		imageLabel7 = new JLabel();
		imageLabel8 = new JLabel();
		imageLabel9 = new JLabel();
		imageLabel10 = new JLabel();
		imageLabel11 = new JLabel();
		imageLabel12 = new JLabel();
		imageLabel13 = new JLabel();
		imageLabel14 = new JLabel();
		imageLabel15 = new JLabel();
		imageLabel16 = new JLabel();
		imageLabel17 = new JLabel();
		imageLabel18 = new JLabel();
		imageLabel19 = new JLabel();
		imageLabel20 = new JLabel();

		ImageIcon ii = new ImageIcon(this.getClass().getResource("Bnode.png"));

		ImageIcon line1 = new ImageIcon(this.getClass().getResource("sn1.png"));
		imageLabels1 = new JLabel();
		imageLabels1.setIcon(line1);
		imageLabels1.setBounds(10, 95, 100, 60);

		imageLabeln34 = new JLabel();
		imageLabeln34.setIcon(line1);
		imageLabeln34.setBounds(110, 180, 100, 50);

		imageLabeln67 = new JLabel();
		imageLabeln67.setIcon(line1);
		imageLabeln67.setBounds(310, 180, 100, 50);

		imageLabeln1011 = new JLabel();
		imageLabeln1011.setIcon(line1);
		imageLabeln1011.setBounds(650, 180, 100, 50);

		imageLabeln1314 = new JLabel();
		imageLabeln1314.setIcon(line1);
		imageLabeln1314.setBounds(850, 180, 100, 50);

		imageLabeln45 = new JLabel();
		imageLabeln45.setIcon(line1);
		imageLabeln45.setBounds(205, 100, 100, 50);

		imageLabeln89 = new JLabel();
		imageLabeln89.setIcon(line1);
		imageLabeln89.setBounds(550, 90, 100, 60);

		imageLabeln1112 = new JLabel();
		imageLabeln1112.setIcon(line1);
		imageLabeln1112.setBounds(750, 90, 100, 60);

		imageLabeln1516 = new JLabel();
		imageLabeln1516.setIcon(line1);
		imageLabeln1516.setBounds(490, 430, 100, 70);

		imageLabeln1819 = new JLabel();
		imageLabeln1819.setIcon(line1);
		imageLabeln1819.setBounds(690, 430, 100, 70);

		imageLabeln1718 = new JLabel();
		imageLabeln1718.setIcon(line1);
		imageLabeln1718.setBounds(590, 530, 100, 70);

		imageLabelnd20 = new JLabel();
		imageLabelnd20.setIcon(line1);
		imageLabelnd20.setBounds(800, 525, 100, 70);

		ImageIcon line2 = new ImageIcon(this.getClass().getResource("sn3.png"));

		imageLabelsn3.setIcon(line2);
		imageLabelsn3.setBounds(10, 200, 90, 70);

		imageLabeln46.setIcon(line2);
		imageLabeln46.setBounds(220, 200, 90, 80);

		imageLabeln24.setIcon(line2);
		imageLabeln24.setBounds(115, 110, 90, 80);

		imageLabeln57.setIcon(line2);
		imageLabeln57.setBounds(315, 110, 90, 80);

		imageLabeln911.setIcon(line2);
		imageLabeln911.setBounds(660, 110, 90, 80);

		imageLabeln1214.setIcon(line2);
		imageLabeln1214.setBounds(850, 110, 90, 80);

		imageLabeln810.setIcon(line2);
		imageLabeln810.setBounds(564, 188, 90, 90);

		imageLabeln1113.setIcon(line2);
		imageLabeln1113.setBounds(764, 188, 90, 90);

		imageLabeln1618.setIcon(line2);
		imageLabeln1618.setBounds(610, 450, 90, 90);

		imageLabeln1517.setIcon(line2);
		imageLabeln1517.setBounds(500, 558, 90, 90);

		imageLabeln1820.setIcon(line2);
		imageLabeln1820.setBounds(700, 558, 90, 90);

		imageLabel19d.setIcon(line2);
		imageLabel19d.setBounds(810, 450, 90, 90);

		ImageIcon arrow = new ImageIcon(this.getClass().getResource(
				"Arrow1.png"));
		Arrow = new JLabel();
		Arrow.setIcon(arrow);
		Arrow.setBounds(473, 148, 100, 50);

		ImageIcon arrow1 = new ImageIcon(this.getClass().getResource(
				"Arrow2.png"));
		Arrow1 = new JLabel();
		Arrow1.setIcon(arrow1);
		Arrow1.setBounds(673, 300, 100, 100);

		c1.setBounds(200, 10, 200, 100);
		c2.setBounds(750, 10, 200, 100);
		c3.setBounds(350, 450, 200, 100);

		imageLabel.setIcon(ii);
		imageLabel1.setIcon(ii);
		imageLabel2.setIcon(ii);
		imageLabel3.setIcon(ii);
		imageLabel4.setIcon(ii);
		imageLabel5.setIcon(ii);
		imageLabel6.setIcon(ii);
		imageLabel7.setIcon(ii);
		imageLabel8.setIcon(ii);
		imageLabel9.setIcon(ii);
		imageLabel10.setIcon(ii);
		imageLabel11.setIcon(ii);
		imageLabel12.setIcon(ii);
		imageLabel13.setIcon(ii);
		imageLabel14.setIcon(ii);
		imageLabel15.setIcon(ii);
		imageLabel16.setIcon(ii);
		imageLabel17.setIcon(ii);
		imageLabel18.setIcon(ii);
		imageLabel19.setIcon(ii);
		imageLabel20.setIcon(ii);

		button.setBounds(20, 10, 175, 30);
		button1.setBounds(600, 10, 175, 30);
		button2.setBounds(150, 450, 175, 30);

		imageLabel.setBounds(20, 150, 100, 50);
		node1.setBounds(20, 180, 100, 50);

		imageLabel1.setBounds(110, 70, 100, 50);
		node2.setBounds(110, 100, 100, 50);

		imageLabel2.setBounds(110, 220, 100, 50);
		node3.setBounds(110, 250, 100, 50);

		imageLabel3.setBounds(215, 150, 100, 50);
		node4.setBounds(215, 180, 100, 50);

		imageLabel4.setBounds(320, 70, 100, 50);
		node5.setBounds(320, 100, 100, 50);

		imageLabel5.setBounds(420, 145, 100, 50);
		node6.setBounds(420, 170, 100, 50);

		imageLabel6.setBounds(320, 220, 100, 50);
		node7.setBounds(320, 250, 100, 50);

		imageLabel7.setBounds(560, 145, 100, 50);
		node8.setBounds(560, 175, 100, 50);

		imageLabel8.setBounds(660, 70, 100, 50);
		node9.setBounds(660, 100, 100, 50);

		imageLabel9.setBounds(750, 145, 100, 50);
		node11.setBounds(750, 175, 100, 50);

		imageLabel10.setBounds(850, 70, 100, 50);
		node12.setBounds(850, 100, 100, 50);

		imageLabel11.setBounds(950, 145, 100, 50);
		node14.setBounds(950, 175, 100, 50);

		imageLabel12.setBounds(665, 220, 100, 50);
		node10.setBounds(665, 250, 100, 50);

		imageLabel13.setBounds(850, 220, 100, 50);
		node13.setBounds(850, 250, 100, 50);

		imageLabel14.setBounds(500, 500, 100, 50);
		node15.setBounds(500, 530, 100, 50);

		imageLabel15.setBounds(600, 400, 100, 50);
		node16.setBounds(600, 430, 100, 50);

		imageLabel16.setBounds(600, 600, 100, 50);
		node17.setBounds(600, 630, 100, 50);

		imageLabel17.setBounds(700, 500, 100, 50);
		node18.setBounds(700, 530, 100, 50);

		imageLabel18.setBounds(800, 400, 100, 50);
		node19.setBounds(800, 430, 100, 50);

		imageLabel19.setBounds(800, 600, 100, 50);
		node20.setBounds(800, 630, 100, 50);

		imageLabel20.setBounds(900, 500, 100, 50);
		node21.setBounds(886, 530, 100, 50);

		c.add(imageLabel);
		c.add(imageLabel1);
		c.add(imageLabel2);
		c.add(imageLabel3);
		c.add(imageLabel4);
		c.add(imageLabel5);
		c.add(imageLabel6);
		c.add(imageLabel7);
		c.add(imageLabel8);
		c.add(imageLabel9);
		c.add(imageLabel10);
		c.add(imageLabel11);
		c.add(imageLabel12);
		c.add(imageLabel13);
		c.add(imageLabel14);
		c.add(imageLabel15);
		c.add(imageLabel16);
		c.add(imageLabel17);
		c.add(imageLabel18);
		c.add(imageLabel19);
		c.add(imageLabel20);

		c.add(node1);
		c.add(node2);
		c.add(node3);
		c.add(node4);
		c.add(node5);
		c.add(node6);
		c.add(node7);
		c.add(node8);
		c.add(node9);
		c.add(node10);
		c.add(node11);
		c.add(node12);
		c.add(node13);
		c.add(node14);
		c.add(node15);
		c.add(node16);
		c.add(node17);
		c.add(node18);
		c.add(node19);
		c.add(node20);
		c.add(node21);

		c.add(button);
		c.add(button1);
		c.add(button2);

		c.add(imageLabels1);
		c.add(imageLabeln34);
		c.add(imageLabeln67);
		c.add(imageLabeln1011);
		c.add(imageLabeln1314);
		c.add(imageLabeln45);
		c.add(imageLabeln89);
		c.add(imageLabeln1112);
		c.add(imageLabeln1516);
		c.add(imageLabeln1819);
		c.add(imageLabeln1718);
		c.add(imageLabelnd20);
		c.add(imageLabelsn3);
		c.add(imageLabeln46);
		c.add(imageLabeln24);
		c.add(imageLabeln57);
		c.add(imageLabeln911);
		c.add(imageLabeln1214);
		c.add(imageLabeln810);
		c.add(imageLabeln1113);
		c.add(imageLabeln1517);
		c.add(imageLabeln1618);
		c.add(imageLabeln1820);
		c.add(imageLabel19d);

		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(Arrow);
		c.add(Arrow1);

		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		item22.addActionListener(this);
		item2.addActionListener(this);
		item1.addActionListener(this);
		item11.addActionListener(this);

		ipc1.addActionListener(this);
		ipc2.addActionListener(this);
		ipc3.addActionListener(this);

		
		jf.setBounds(2, 2, 1020, 725);
		jf.setVisible(true);

		int[] ports = new int[] { 10000, 10001, 111, 500, 501 };

		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();
		}
	}

	public static void main(String[] args) {
		new ClusterTopology();
	}

	class PortListener implements Runnable {

		BufferedOutputStream bos = null;

		ServerSocket server;

		BufferedReader br = null;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		
		public void run() {

			if (this.port == 111) {

				try {

					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection connect = DriverManager
							.getConnection("jdbc:odbc:Cluster");
					Statement stmt = connect.createStatement();
					Statement st = connect.createStatement();
					ServerSocket server = new ServerSocket(111);
					Socket con;
					while (true) {

						con = server.accept();
						DataInputStream dis = new DataInputStream(
								con.getInputStream());

						String node = dis.readUTF();
						String cluster = dis.readUTF();
						String ip = dis.readUTF();
						String status = dis.readUTF();
						int option = JOptionPane.showConfirmDialog(null,
								"Do you want to Connect Node '" + node + "' ");

						if (option == 0) {

							String sql = "insert into NodeStatus values( '"
									+ node + "','" + ip + "','" + cluster
									+ "' ) ";

							stmt.executeUpdate(sql);

							String sql1 = "insert into NodeStatusUpdated values( '"
									+ node
									+ "','"
									+ ip
									+ "','"
									+ cluster
									+ "','" + status + "' ) ";

							st.executeUpdate(sql1);

						} else {
							JOptionPane.showMessageDialog(null,
									"Connection refused");
						}
					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}

			if (this.port == 500) {

				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection connect = DriverManager
							.getConnection("jdbc:odbc:Cluster");
					Statement st = connect.createStatement();
					ServerSocket server = new ServerSocket(500);
					System.out.println("listening 500");
					while (true) {

						Socket con = server.accept();
						DataInputStream dis = new DataInputStream(
								con.getInputStream());

						String cluster = dis.readUTF();
						String node = dis.readUTF();

						String sql = "select * from NodeStatusUpdated where Node = '"
								+ node + "' and cluster='" + cluster + "' ";

						ResultSet rs = st.executeQuery(sql);
						while (rs.next() == true) {
							String ip = rs.getString(2);

							DataOutputStream dos = new DataOutputStream(
									con.getOutputStream());
							dos.writeUTF(ip);

						}
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}

			if (this.port == 501) {
				try {

					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection connect = DriverManager
							.getConnection("jdbc:odbc:Cluster");
					Statement st = connect.createStatement();
					Statement stmt = connect.createStatement();
					ServerSocket server = new ServerSocket(501);
					System.out.println("listening 501");

					SimpleDateFormat sdfDate = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

					java.util.Date now = new Date();

					String strDate = sdfDate.format(now);
					String strTime = sdfTime.format(now);
					String dt = strDate + "   " + strTime;

					while (true) {

						Socket con = server.accept();
						DataInputStream dis = new DataInputStream(
								con.getInputStream());

						String cluster = dis.readUTF();
						String node = dis.readUTF();
						String ip = dis.readUTF();

						String query = "insert into Attacker values ('" + node
								+ "','" + ip + "' ,'" + cluster + "','" + dt
								+ "') ";

						String status = "updated";
						String update = "update NodeStatusUpdated set IPaddress= '"
								+ ip
								+ "' , status= '"
								+ status
								+ "' where Node = '" + node + "'  ";
						st.executeUpdate(query);
						stmt.executeUpdate(update);
						System.out.println("IPAddress is : " + ip);
						System.out
								.println("Attacker found in network for Cluster  '"
										+ cluster + "' ");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			if (this.port == 10000) {

				try {
					String status = "default";
					ServerSocket server1 = new ServerSocket(10000);
					Socket con;
					while (true) {
						con = server1.accept();

						JOptionPane.showConfirmDialog(null,
								"Du you Want to Connect..???");

						DataInputStream dis = new DataInputStream(
								con.getInputStream());

						String data = dis.readUTF();
						System.out.println(data + "At router");

						ImageIcon line2 = new ImageIcon(this.getClass()
								.getResource("Gnode.png"));
						imageLabel.setIcon(line2);
						imageLabel.setBounds(20, 150, 100, 50);

						try {

							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection connect = DriverManager
									.getConnection("jdbc:odbc:Cluster");

							String dest = "Destination";
							String topology = "Topology";
							Statement dst = connect.createStatement();
							String dsql = "select * from NodeStatus where Node = '"
									+ dest
									+ "' and cluster = '"
									+ topology
									+ "'";
							ResultSet rsql = dst.executeQuery(dsql);
							if (rsql.next() == true) {
								DestIPAddress = rsql.getString(2);
								System.out.println(DestIPAddress);
							}

							Statement stmt = connect.createStatement();
							String sql = " Select * from Cluster1";

							ResultSet rs = stmt.executeQuery(sql);

							if (rs.next()) {

								int n2 = rs.getInt(1);
								int n3 = rs.getInt(2);
								int n4 = rs.getInt(3);
								int n5 = rs.getInt(4);
								int n6 = rs.getInt(5);

								System.out.println("values are : " + n2 + ""
										+ n3 + "" + n4 + "" + n5 + "" + n6);
								System.out.println("energies found");
								Statement st = connect.createStatement();
								String c1 = "Cluster1";
								String nod = "Node2";
								String query = "select * from  NodeStatusUpdated where Node = '"
										+ nod + "' and cluster = '" + c1 + "' ";

								ResultSet rs11 = st.executeQuery(query);
								System.out.println("resuktset");
								if (rs11.next() == true) {
									c1n2 = rs11.getString(4);
								}
								System.out.println("value is:  " + c1n2);

								if (n2 < n3) {

									System.out.println("node 2");

									if (c1n2.equals("updated")) {

										int x = JOptionPane
												.showConfirmDialog(
														null,
														"IP Spoofing attacker found in the Cluster1 \n Do you want to Apply Relocalization");

										if (x == 1) {
											JOptionPane.showMessageDialog(null,
													"Packets Dropped");
										}
										if (x == 0) {

											Statement st1 = connect
													.createStatement();
											String sel1 = "select * from NodeStatus where Node = '"
													+ nod
													+ "' and cluster= '"
													+ c1 + "' ";

											ResultSet rs2 = st1
													.executeQuery(sel1);
											if (rs2.next() == true) {
												ip1 = rs2.getString(2);
											}

											String up1 = "update NodeStatusUpdated set IPaddress = '"
													+ ip1
													+ "' ,status = '"
													+ status
													+ "'  where Node = '"
													+ nod
													+ "' and cluster= '"
													+ c1
													+ "'  ";
											Statement ss1 = connect
													.createStatement();
											ss1.executeUpdate(up1);
											timer.start();
											Thread.sleep(2000);
											ImageIcon green = new ImageIcon(
													this.getClass()
															.getResource(
																	"sn1green.png"));

											imageLabels1.setIcon(green);
											imageLabels1.setBounds(10, 95, 100,
													60);

											ImageIcon green1 = new ImageIcon(
													this.getClass()
															.getResource(
																	"Gnode.png"));

											imageLabel1.setIcon(green1);
											imageLabel1.setBounds(110, 70, 100,
													50);

											ImageIcon green2 = new ImageIcon(
													this.getClass()
															.getResource(
																	"green3.png"));

											imageLabeln24.setIcon(green2);
											imageLabeln24.setBounds(116, 108,
													100, 80);
											timer.start();
											Thread.sleep(2000);

											imageLabel3.setIcon(green1);
											imageLabel3.setBounds(215, 150,
													100, 50);
											timer.start();
											Thread.sleep(2000);
											System.out.println("bigin node5");
											// /////////////
											if (n5 < n6) {
												String node = "Node5";
												System.out.println("query"
														+ node);
												Statement ss2 = connect
														.createStatement();
												String query1 = "select * from  NodeStatusUpdated where Node = '"
														+ node
														+ "' and cluster = '"
														+ c1 + "' ";
												System.out.println("query");

												ResultSet rs3 = ss2
														.executeQuery(query1);
												if (rs3.next() == true) {
													System.out
															.println("inside resultset");
													c1n5 = rs3.getString(4);

													if (c1n5.equals("updated")) {

														int x1 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster1 \n Do you wnt to Aplly Relocalization...???");

														if (x == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet dropped");
														}
														if (x1 == 0) {

															Statement stt1 = connect
																	.createStatement();
															String cc = "select * from NodeStatus where Node= '"
																	+ node
																	+ "' and cluster = '"
																	+ c1 + "' ";
															ResultSet rs4 = stt1
																	.executeQuery(cc);
															if (rs4.next() == true) {
																ip2 = rs4
																		.getString(2);
															}

															String up2 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip2
																	+ "' ,status = '"
																	+ status
																	+ "'  where Node = '"
																	+ node
																	+ "' and cluster= '"
																	+ c1
																	+ "'  ";
															Statement ss3 = connect
																	.createStatement();
															ss3.executeUpdate(up2);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green45 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln45
																	.setIcon(green45);
															imageLabeln45
																	.setBounds(
																			205,
																			100,
																			100,
																			50);
															timer.start();
															Thread.sleep(2000);

															ImageIcon green5 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel4
																	.setIcon(green5);
															imageLabel4
																	.setBounds(
																			320,
																			70,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);

															ImageIcon green11 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln57
																	.setIcon(green11);
															imageLabeln57
																	.setBounds(
																			325,
																			110,
																			95,
																			90);
															timer.start();
															Thread.sleep(2000);
															ImageIcon green6 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel5
																	.setIcon(green6);
															imageLabel5
																	.setBounds(
																			420,
																			145,
																			100,
																			50);
															timer.start();
															Thread.sleep(2000);
															ImageIcon arrowg = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow1.png"));
															Arrow.setIcon(arrowg);
															Arrow.setBounds(
																	473, 148,
																	100, 50);
														}
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green45 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln45
																.setIcon(green45);
														imageLabeln45
																.setBounds(205,
																		100,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green5 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel4
																.setIcon(green5);
														imageLabel4.setBounds(
																320, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green11 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln57
																.setIcon(green11);
														imageLabeln57
																.setBounds(325,
																		110,
																		95, 90);

														timer.start();
														Thread.sleep(2000);
														imageLabel5
																.setIcon(green5);
														imageLabel5.setBounds(
																420, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrowg = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow1.png"));
														Arrow.setIcon(arrowg);
														Arrow.setBounds(473,
																148, 100, 50);
													}
												}
											}

											if (n5 > n6) {

												String node6 = "Node6";
												String query3 = "select * from  NodeStatusUpdated where Node = '"
														+ node6
														+ "' and cluster = '"
														+ c1 + "' ";

												Statement ss3 = connect
														.createStatement();
												ResultSet rs5 = ss3
														.executeQuery(query3);
												if (rs5.next() == true) {
													c1n6 = rs5.getString(4);
												}
												System.out.println("inside n6"
														+ c1n6);
												if (c1n6.equals("updated")) {

													int x2 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in Cluster1 \n Do you want to Apply Relocalization..???");
													if (x2 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packets Dropped");

													}
													if (x2 == 0) {
														System.out
																.println("inside n6"
																		+ "Approved");
														String up13 = "select * from NodeStatus where Node= '"
																+ node6
																+ "' and cluster= '"
																+ c1 + "' ";

														Statement ss4 = connect
																.createStatement();
														ResultSet rs6 = ss4
																.executeQuery(up13);

														if (rs6.next() == true) {
															ip6 = rs6
																	.getString(2);
														}
														System.out
																.println("ip6"
																		+ ip6);
														String up3 = " update NodeStatusUpdated set IPaddress = '"
																+ ip6
																+ "', status= '"
																+ status
																+ "'  where Node = '"
																+ node6
																+ "' and cluster= '"
																+ c1 + "' ";

														Statement ss5 = connect
																.createStatement();
														ss5.executeUpdate(up3);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green4 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln46
																.setIcon(green4);
														imageLabeln46
																.setBounds(220,
																		200,
																		90, 80);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green6 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel6
																.setIcon(green6);
														imageLabel6.setBounds(
																320, 220, 100,
																50);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green34 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln67
																.setIcon(green34);
														imageLabeln67
																.setBounds(310,
																		180,
																		100, 50);
														timer.start();
														Thread.sleep(2000);
														imageLabel5
																.setIcon(green6);
														imageLabel5.setBounds(
																420, 145, 100,
																50);
													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green4 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln46
															.setIcon(green4);
													imageLabeln46.setBounds(
															220, 200, 90, 80);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green6 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel6.setIcon(green6);
													imageLabel6.setBounds(320,
															220, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green34 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln67
															.setIcon(green34);
													imageLabeln67.setBounds(
															310, 180, 100, 50);

													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green6);
													imageLabel5.setBounds(420,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrowg = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow1.png"));
													Arrow.setIcon(arrowg);
													Arrow.setBounds(473, 148,
															100, 50);
												}
											}
										}
									} else {
										timer.start();
										Thread.sleep(2000);
										ImageIcon green = new ImageIcon(this
												.getClass().getResource(
														"sn1green.png"));

										imageLabels1.setIcon(green);
										imageLabels1.setBounds(10, 95, 100, 60);

										ImageIcon green1 = new ImageIcon(this
												.getClass().getResource(
														"Gnode.png"));

										imageLabel1.setIcon(green1);
										imageLabel1.setBounds(110, 70, 100, 50);

										ImageIcon green2 = new ImageIcon(this
												.getClass().getResource(
														"green3.png"));

										imageLabeln24.setIcon(green2);
										imageLabeln24.setBounds(116, 108, 100,
												80);
										timer.start();
										Thread.sleep(2000);

										imageLabel3.setIcon(green1);
										imageLabel3
												.setBounds(215, 150, 100, 50);
										timer.start();
										Thread.sleep(2000);

										if (n5 < n6) {

											String node = "Node5";
											System.out.println("query" + node);
											Statement ss2 = connect
													.createStatement();
											String query1 = "select * from  NodeStatusUpdated where Node = '"
													+ node
													+ "' and cluster = '"
													+ c1
													+ "' ";
											System.out.println("query");

											ResultSet rs3 = ss2
													.executeQuery(query1);
											if (rs3.next() == true) {
												System.out
														.println("inside resultset");
												c1n5 = rs3.getString(4);

												if (c1n5.equals("updated")) {

													int x1 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in the cluster1 \n Do you wnt to Aplly Relocalization...???");

													if (x1 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet dropped");
													}
													if (x1 == 0) {

														Statement stt1 = connect
																.createStatement();
														String cc = "select * from NodeStatus where Node= '"
																+ node
																+ "' and cluster = '"
																+ c1 + "' ";
														ResultSet rs4 = stt1
																.executeQuery(cc);
														if (rs4.next() == true) {
															ip2 = rs4
																	.getString(2);
														}

														String up2 = "update NodeStatusUpdated set IPaddress = '"
																+ ip2
																+ "' ,status = '"
																+ status
																+ "'  where Node = '"
																+ node
																+ "' and cluster= '"
																+ c1 + "'  ";
														Statement ss3 = connect
																.createStatement();
														ss3.executeUpdate(up2);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green45 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln45
																.setIcon(green45);
														imageLabeln45
																.setBounds(205,
																		100,
																		100, 50);
														timer.start();
														Thread.sleep(2000);

														ImageIcon green5 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel4
																.setIcon(green5);
														imageLabel4.setBounds(
																320, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green11 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln57
																.setIcon(green11);
														imageLabeln57
																.setBounds(325,
																		110,
																		95, 90);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green6 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel5
																.setIcon(green6);
														imageLabel5.setBounds(
																420, 145, 100,
																50);
														timer.start();
														Thread.sleep(2000);
														ImageIcon arrowg = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow1.png"));
														Arrow.setIcon(arrowg);
														Arrow.setBounds(473,
																148, 100, 50);
													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green45 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln45
															.setIcon(green45);
													imageLabeln45.setBounds(
															205, 100, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green5 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel4.setIcon(green5);
													imageLabel4.setBounds(320,
															70, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green11 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln57
															.setIcon(green11);
													imageLabeln57.setBounds(
															325, 110, 95, 90);

													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green5);
													imageLabel5.setBounds(420,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrowg = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow1.png"));
													Arrow.setIcon(arrowg);
													Arrow.setBounds(473, 148,
															100, 50);

												}

											}
										}

										if (n5 > n6) {

											String node6 = "Node6";
											String query3 = "select * from  NodeStatusUpdated where Node = '"
													+ node6
													+ "' and cluster = '"
													+ c1
													+ "' ";

											Statement ss3 = connect
													.createStatement();
											ResultSet rs5 = ss3
													.executeQuery(query3);
											if (rs5.next() == true) {
												c1n6 = rs5.getString(4);
											}
											System.out.println("inside n6"
													+ c1n6);
											if (c1n6.equals("updated")) {

												int x2 = JOptionPane
														.showConfirmDialog(
																null,
																"Spoofing attacker found in Cluster1 \n Do you want to Apply Relocalization..???");
												if (x2 == 1) {
													JOptionPane
															.showMessageDialog(
																	null,
																	"Packets Dropped");

												}
												if (x2 == 0) {
													System.out
															.println("inside n6"
																	+ "Approved");
													String up13 = "select * from NodeStatus where Node= '"
															+ node6
															+ "' and cluster= '"
															+ c1 + "' ";

													Statement ss4 = connect
															.createStatement();
													ResultSet rs6 = ss4
															.executeQuery(up13);

													if (rs6.next() == true) {
														ip6 = rs6.getString(2);
													}
													System.out.println("ip6"
															+ ip6);
													String up3 = " update NodeStatusUpdated set IPaddress = '"
															+ ip6
															+ "', status= '"
															+ status
															+ "'  where Node = '"
															+ node6
															+ "' and cluster= '"
															+ c1 + "' ";

													Statement ss5 = connect
															.createStatement();
													ss5.executeUpdate(up3);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green4 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln46
															.setIcon(green4);
													imageLabeln46.setBounds(
															220, 200, 90, 80);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green6 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel6.setIcon(green6);
													imageLabel6.setBounds(320,
															220, 100, 50);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green34 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln67
															.setIcon(green34);
													imageLabeln67.setBounds(
															310, 180, 100, 50);
													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green6);
													imageLabel5.setBounds(420,
															145, 100, 50);
												}
											} else {

												timer.start();
												Thread.sleep(2000);
												ImageIcon green4 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));
												imageLabeln46.setIcon(green4);
												imageLabeln46.setBounds(220,
														200, 90, 80);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green6 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel6.setIcon(green6);
												imageLabel6.setBounds(320, 220,
														100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green34 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln67.setIcon(green34);
												imageLabeln67.setBounds(310,
														180, 100, 50);

												timer.start();
												Thread.sleep(2000);
												imageLabel5.setIcon(green6);
												imageLabel5.setBounds(420, 145,
														100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon arrowg = new ImageIcon(
														this.getClass()
																.getResource(
																		"greenArrow1.png"));
												Arrow.setIcon(arrowg);
												Arrow.setBounds(473, 148, 100,
														50);

											}
										}
									}
								}
								// 2-3
								if (n2 > n3) {

									String node3 = "Node3";
									Statement st2 = connect.createStatement();
									String sql3 = "select * from NodeStatusUpdated where Node = '"
											+ node3
											+ "' and cluster  = '"
											+ c1
											+ "' ";
									ResultSet rs3 = st2.executeQuery(sql3);
									if (rs3.next() == true) {
										c1n3 = rs3.getString(4);
									}

									if (c1n3.equals("updated")) {

										int x3 = JOptionPane
												.showConfirmDialog(null,
														"Spoofing Attack found in the network \n Do you want to Apply Relocalization");

										if (x3 == 1) {
											JOptionPane.showMessageDialog(null,
													"Packets Dropped");
										}
										if (x3 == 0) {

											Statement st21 = connect
													.createStatement();
											String sql31 = "select * from NodeStatus where Node = '"
													+ node3
													+ "' and cluster = '"
													+ c1
													+ "'  ";
											ResultSet rs33 = st21
													.executeQuery(sql31);
											if (rs33.next() == true) {
												ip3 = rs33.getString(2);
											}

											String up3 = "update NodeStatusUpdated set IPaddress = '"
													+ ip3
													+ "',status = '"
													+ status
													+ "' where Node = '"
													+ node3
													+ "'  and cluster = '"
													+ c1
													+ "' ";
											Statement st33 = connect
													.createStatement();
											st33.executeUpdate(up3);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green2 = new ImageIcon(
													this.getClass()
															.getResource(
																	"green3.png"));
											imageLabelsn3.setIcon(green2);
											imageLabelsn3.setBounds(10, 200,
													90, 70);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green1 = new ImageIcon(
													this.getClass()
															.getResource(
																	"Gnode.png"));

											imageLabel2.setIcon(green1);
											imageLabel2.setBounds(110, 220,
													100, 50);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green = new ImageIcon(
													this.getClass()
															.getResource(
																	"sn1green.png"));
											imageLabeln34.setIcon(green);
											imageLabeln34.setBounds(110, 180,
													100, 50);

											timer.start();
											Thread.sleep(2000);
											imageLabel3.setIcon(green1);
											imageLabel3.setBounds(215, 150,
													100, 50);

											if (n5 < n6) {
												String node = "Node5";
												System.out.println("query"
														+ node);
												Statement ss2 = connect
														.createStatement();
												String query1 = "select * from  NodeStatusUpdated where Node = '"
														+ node
														+ "' and cluster = '"
														+ c1 + "' ";
												System.out.println("query");

												ResultSet rs5 = ss2
														.executeQuery(query1);
												if (rs5.next() == true) {
													System.out
															.println("inside resultset");
													c1n5 = rs5.getString(4);

													if (c1n5.equals("updated")) {

														int x1 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster1 \n Do you wnt to Aplly Relocalization...???");

														if (x1 == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet dropped");
														}
														if (x1 == 0) {

															Statement stt1 = connect
																	.createStatement();
															String cc = "select * from NodeStatus where Node= '"
																	+ node
																	+ "' and cluster = '"
																	+ c1 + "' ";
															ResultSet rs4 = stt1
																	.executeQuery(cc);
															if (rs4.next() == true) {
																ip2 = rs4
																		.getString(2);
															}

															String up2 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip2
																	+ "' ,status = '"
																	+ status
																	+ "'  where Node = '"
																	+ node
																	+ "' and cluster= '"
																	+ c1
																	+ "'  ";
															Statement ss3 = connect
																	.createStatement();
															ss3.executeUpdate(up2);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green45 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln45
																	.setIcon(green45);
															imageLabeln45
																	.setBounds(
																			205,
																			100,
																			100,
																			50);
															timer.start();
															Thread.sleep(2000);

															ImageIcon green5 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel4
																	.setIcon(green5);
															imageLabel4
																	.setBounds(
																			320,
																			70,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);

															ImageIcon green11 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln57
																	.setIcon(green11);
															imageLabeln57
																	.setBounds(
																			325,
																			110,
																			95,
																			90);
															timer.start();
															Thread.sleep(2000);
															ImageIcon green6 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel5
																	.setIcon(green6);
															imageLabel5
																	.setBounds(
																			420,
																			145,
																			100,
																			50);
															timer.start();
															Thread.sleep(2000);
															ImageIcon arrowg = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow1.png"));
															Arrow.setIcon(arrowg);
															Arrow.setBounds(
																	473, 148,
																	100, 50);
														}
													}

													else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green45 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln45
																.setIcon(green45);
														imageLabeln45
																.setBounds(205,
																		100,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green5 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel4
																.setIcon(green5);
														imageLabel4.setBounds(
																320, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green11 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln57
																.setIcon(green11);
														imageLabeln57
																.setBounds(325,
																		110,
																		95, 90);

														timer.start();
														Thread.sleep(2000);
														imageLabel5
																.setIcon(green5);
														imageLabel5.setBounds(
																420, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrowg = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow1.png"));
														Arrow.setIcon(arrowg);
														Arrow.setBounds(473,
																148, 100, 50);
													}
												}
											}

											if (n5 > n6) {

												String node6 = "Node6";
												String query3 = "select * from  NodeStatusUpdated where Node = '"
														+ node6
														+ "' and cluster = '"
														+ c1 + "' ";

												Statement ss3 = connect
														.createStatement();
												ResultSet rs5 = ss3
														.executeQuery(query3);
												if (rs5.next() == true) {
													c1n6 = rs5.getString(4);
												}
												System.out.println("inside n6"
														+ c1n6);
												if (c1n6.equals("updated")) {

													int x2 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in Cluster1 \n Do you want to Apply Relocalization..???");
													if (x2 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packets Dropped");

													}
													if (x2 == 0) {
														System.out
																.println("inside n6"
																		+ "Approved");
														String up13 = "select * from NodeStatus where Node= '"
																+ node6
																+ "' and cluster= '"
																+ c1 + "' ";

														Statement ss4 = connect
																.createStatement();
														ResultSet rs6 = ss4
																.executeQuery(up13);

														if (rs6.next() == true) {
															ip6 = rs6
																	.getString(2);
														}
														System.out
																.println("ip6"
																		+ ip6);
														String up6 = " update NodeStatusUpdated set IPaddress = '"
																+ ip6
																+ "', status= '"
																+ status
																+ "'  where Node = '"
																+ node6
																+ "' and cluster= '"
																+ c1 + "' ";

														Statement ss5 = connect
																.createStatement();
														ss5.executeUpdate(up6);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green4 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln46
																.setIcon(green4);
														imageLabeln46
																.setBounds(220,
																		200,
																		90, 80);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green6 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel6
																.setIcon(green6);
														imageLabel6.setBounds(
																320, 220, 100,
																50);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green34 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln67
																.setIcon(green34);
														imageLabeln67
																.setBounds(310,
																		180,
																		100, 50);
														timer.start();
														Thread.sleep(2000);
														imageLabel5
																.setIcon(green6);
														imageLabel5.setBounds(
																420, 145, 100,
																50);
													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green4 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln46
															.setIcon(green4);
													imageLabeln46.setBounds(
															220, 200, 90, 80);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green6 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel6.setIcon(green6);
													imageLabel6.setBounds(320,
															220, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green34 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln67
															.setIcon(green34);
													imageLabeln67.setBounds(
															310, 180, 100, 50);

													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green6);
													imageLabel5.setBounds(420,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrowg = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow1.png"));
													Arrow.setIcon(arrowg);
													Arrow.setBounds(473, 148,
															100, 50);
												}
											}
										}
									} else {
										timer.start();
										Thread.sleep(2000);
										ImageIcon green2 = new ImageIcon(this
												.getClass().getResource(
														"green3.png"));
										imageLabelsn3.setIcon(green2);
										imageLabelsn3
												.setBounds(10, 200, 90, 70);

										timer.start();
										Thread.sleep(2000);
										ImageIcon green1 = new ImageIcon(this
												.getClass().getResource(
														"Gnode.png"));

										imageLabel2.setIcon(green1);
										imageLabel2
												.setBounds(110, 220, 100, 50);

										timer.start();
										Thread.sleep(2000);
										ImageIcon green = new ImageIcon(this
												.getClass().getResource(
														"sn1green.png"));
										imageLabeln34.setIcon(green);
										imageLabeln34.setBounds(110, 180, 100,
												50);

										timer.start();
										Thread.sleep(2000);
										imageLabel3.setIcon(green1);
										imageLabel3
												.setBounds(215, 150, 100, 50);

										if (n5 < n6) {
											String node = "Node5";
											System.out.println("query" + node);
											Statement ss2 = connect
													.createStatement();
											String query1 = "select * from  NodeStatusUpdated where Node = '"
													+ node
													+ "' and cluster = '"
													+ c1
													+ "' ";
											System.out.println("query");

											ResultSet rs5 = ss2
													.executeQuery(query1);
											if (rs5.next() == true) {
												System.out
														.println("inside resultset");
												c1n5 = rs5.getString(4);

												if (c1n5.equals("updated")) {

													int x1 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in the cluster1 \n Do you wnt to Aplly Relocalization...???");

													if (x1 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet dropped");
													}
													if (x1 == 0) {

														Statement stt1 = connect
																.createStatement();
														String cc = "select * from NodeStatus where Node= '"
																+ node
																+ "' and cluster = '"
																+ c1 + "' ";
														ResultSet rs4 = stt1
																.executeQuery(cc);
														if (rs4.next() == true) {
															ip2 = rs4
																	.getString(2);
														}

														String up2 = "update NodeStatusUpdated set IPaddress = '"
																+ ip2
																+ "' ,status = '"
																+ status
																+ "'  where Node = '"
																+ node
																+ "' and cluster= '"
																+ c1 + "'  ";
														Statement ss3 = connect
																.createStatement();
														ss3.executeUpdate(up2);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green45 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln45
																.setIcon(green45);
														imageLabeln45
																.setBounds(205,
																		100,
																		100, 50);
														timer.start();
														Thread.sleep(2000);

														ImageIcon green5 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel4
																.setIcon(green5);
														imageLabel4.setBounds(
																320, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green11 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln57
																.setIcon(green11);
														imageLabeln57
																.setBounds(325,
																		110,
																		95, 90);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green6 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel5
																.setIcon(green6);
														imageLabel5.setBounds(
																420, 145, 100,
																50);
														timer.start();
														Thread.sleep(2000);
														ImageIcon arrowg = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow1.png"));
														Arrow.setIcon(arrowg);
														Arrow.setBounds(473,
																148, 100, 50);
													}
												}

												else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green45 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln45
															.setIcon(green45);
													imageLabeln45.setBounds(
															205, 100, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green5 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel4.setIcon(green5);
													imageLabel4.setBounds(320,
															70, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green11 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln57
															.setIcon(green11);
													imageLabeln57.setBounds(
															325, 110, 95, 90);

													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green5);
													imageLabel5.setBounds(420,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrowg = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow1.png"));
													Arrow.setIcon(arrowg);
													Arrow.setBounds(473, 148,
															100, 50);
												}
											}
										}

										if (n5 > n6) {

											String node6 = "Node6";
											String query3 = "select * from  NodeStatusUpdated where Node = '"
													+ node6
													+ "' and cluster = '"
													+ c1
													+ "' ";

											Statement ss3 = connect
													.createStatement();
											ResultSet rs5 = ss3
													.executeQuery(query3);
											if (rs5.next() == true) {
												c1n6 = rs5.getString(4);
											}
											System.out.println("inside n6"
													+ c1n6);
											if (c1n6.equals("updated")) {

												int x2 = JOptionPane
														.showConfirmDialog(
																null,
																"Spoofing attacker found in Cluster1 \n Do you want to Apply Relocalization..???");
												if (x2 == 1) {
													JOptionPane
															.showMessageDialog(
																	null,
																	"Packets Dropped");

												}
												if (x2 == 0) {
													System.out
															.println("inside n6"
																	+ "Approved");
													String up13 = "select * from NodeStatus where Node= '"
															+ node6
															+ "' and cluster= '"
															+ c1 + "' ";

													Statement ss4 = connect
															.createStatement();
													ResultSet rs6 = ss4
															.executeQuery(up13);

													if (rs6.next() == true) {
														ip6 = rs6.getString(2);
													}
													System.out.println("ip6"
															+ ip6);
													String up6 = " update NodeStatusUpdated set IPaddress = '"
															+ ip6
															+ "', status= '"
															+ status
															+ "'  where Node = '"
															+ node6
															+ "' and cluster= '"
															+ c1 + "' ";

													Statement ss5 = connect
															.createStatement();
													ss5.executeUpdate(up6);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green4 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln46
															.setIcon(green4);
													imageLabeln46.setBounds(
															220, 200, 90, 80);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green6 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel6.setIcon(green6);
													imageLabel6.setBounds(320,
															220, 100, 50);
													timer.start();
													Thread.sleep(2000);
													ImageIcon green34 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln67
															.setIcon(green34);
													imageLabeln67.setBounds(
															310, 180, 100, 50);
													timer.start();
													Thread.sleep(2000);
													imageLabel5.setIcon(green6);
													imageLabel5.setBounds(420,
															145, 100, 50);
												}
											} else {

												timer.start();
												Thread.sleep(2000);
												ImageIcon green4 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));
												imageLabeln46.setIcon(green4);
												imageLabeln46.setBounds(220,
														200, 90, 80);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green6 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel6.setIcon(green6);
												imageLabel6.setBounds(320, 220,
														100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green34 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln67.setIcon(green34);
												imageLabeln67.setBounds(310,
														180, 100, 50);

												timer.start();
												Thread.sleep(2000);
												imageLabel5.setIcon(green6);
												imageLabel5.setBounds(420, 145,
														100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon arrowg = new ImageIcon(
														this.getClass()
																.getResource(
																		"greenArrow1.png"));
												Arrow.setIcon(arrowg);
												Arrow.setBounds(473, 148, 100,
														50);
											}
										}
									}
								}
								// ///////////////--------cluster1-End-----/////////////////
								// ///////////////--------cluster2-start-----/////////////////
								String sql1 = " Select * from Cluster2 ";

								ResultSet rs1 = stmt.executeQuery(sql1);

								if (rs1.next() == true) {

									int n9 = rs1.getInt(2);
									int n10 = rs1.getInt(3);

									int n12 = rs1.getInt(5);
									int n13 = rs1.getInt(6);

									String c2 = "Cluster2";

									timer.start();
									Thread.sleep(2000);
									ImageIcon green7 = new ImageIcon(this
											.getClass()
											.getResource("Gnode.png"));
									imageLabel7.setIcon(green7);
									imageLabel7.setBounds(560, 145, 100, 50);
									System.out.println("begin Node10");
									if (n9 > n10) {
										System.out.println("in Node10");
										String node9 = "Node10";

										String sql9 = "select * from NodeStatusUpdated where Node = '"
												+ node9
												+ "' and cluster = '"
												+ c2 + "' ";

										Statement st9 = connect
												.createStatement();
										ResultSet rs9 = st9.executeQuery(sql9);
										if (rs9.next() == true) {
											c2n1 = rs9.getString(4);
										}
										System.out
												.println("begin Node10 status "
														+ c2n1);
										if (c2n1.equals("updated")) {

											int x9 = JOptionPane
													.showConfirmDialog(
															null,
															"Spoofing attacker found in Cluster2 \n Do you want to Apply Relocalization..???");

											if (x9 == 1) {
												JOptionPane.showMessageDialog(
														null, "Packet Dropped");
											}
											if (x9 == 0) {
												String sql91 = "select * from NodeStatus where Node = '"
														+ node9
														+ "' and cluster =  '"
														+ c2 + "'  ";
												Statement st91 = connect
														.createStatement();
												ResultSet rs91 = st91
														.executeQuery(sql91);
												if (rs91.next() == true) {
													ip9 = rs91.getString(2);
												}
												String up9 = "update NodeStatusUpdated set IPaddress = '"
														+ ip9
														+ "' ,status = '"
														+ status
														+ "' where Node = '"
														+ node9
														+ "' and cluster = '"
														+ c2 + "'  ";

												Statement stup9 = connect
														.createStatement();
												stup9.executeUpdate(up9);
												timer.start();
												Thread.sleep(2000);
												ImageIcon green810 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));

												imageLabeln810
														.setIcon(green810);
												imageLabeln810.setBounds(564,
														188, 90, 90);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green10 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel12.setIcon(green10);
												imageLabel12.setBounds(665,
														220, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1011 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));

												imageLabeln1011
														.setIcon(green1011);
												imageLabeln1011.setBounds(650,
														180, 100, 50);

												timer.start();
												Thread.sleep(2000);
												imageLabel9.setIcon(green10);
												imageLabel9.setBounds(750, 145,
														100, 50);

												if (n12 < n13) {

													String node12 = "Node12";
													Statement st12 = connect
															.createStatement();
													String sql12 = "select * from NodeStatusUpdated where Node = '"
															+ node12
															+ "' and cluster = '"
															+ c2 + "' ";

													ResultSet rs12 = st12
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c2n2 = rs12
																.getString(4);
													}

													if (c2n2.equals("updated")) {

														int x12 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker Found in Cluster2 \n Do you want to Apply RElocalization...???");

														if (x12 == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet Dropped");
														}
														if (x12 == 0) {

															Statement stm12 = connect
																	.createStatement();
															String query12 = "select * from NodeStatus where Node = '"
																	+ node12
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";

															ResultSet rsm12 = stm12
																	.executeQuery(query12);
															if (rsm12.next() == true) {
																ip12 = rsm12
																		.getString(2);
															}

															Statement stt12 = connect
																	.createStatement();
															String up12 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip12
																	+ "' ,status = '"
																	+ status
																	+ "' where Node = '"
																	+ node12
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";

															stt12.executeUpdate(up12);
															timer.start();
															Thread.sleep(2000);
															ImageIcon green1112 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln1112
																	.setIcon(green1112);
															imageLabeln1112
																	.setBounds(
																			750,
																			90,
																			100,
																			60);

															ImageIcon green12 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel10
																	.setIcon(green12);
															imageLabel10
																	.setBounds(
																			850,
																			70,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1214 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1214
																	.setIcon(green1214);
															imageLabeln1214
																	.setBounds(
																			850,
																			110,
																			90,
																			80);

															timer.start();
															Thread.sleep(2000);
															imageLabel11
																	.setIcon(green12);
															imageLabel11
																	.setBounds(
																			950,
																			145,
																			100,
																			50);

															ImageIcon arrow1 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow2.png"));
															Arrow1.setIcon(arrow1);
															Arrow1.setBounds(
																	673, 300,
																	100, 100);

															timer.start();
															Thread.sleep(2000);

															ImageIcon green14 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));

															imageLabel14
																	.setIcon(green14);
															imageLabel14
																	.setBounds(
																			500,
																			500,
																			100,
																			50);
														}
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1112 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1112
																.setIcon(green1112);
														imageLabeln1112
																.setBounds(750,
																		90,
																		100, 60);

														ImageIcon green12 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel10
																.setIcon(green12);
														imageLabel10.setBounds(
																850, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1214 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1214
																.setIcon(green1214);
														imageLabeln1214
																.setBounds(850,
																		110,
																		90, 80);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green12);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);

													}
												}
												// //
												if (n12 > n13) {

													String node13 = "Node13";

													Statement st13 = connect
															.createStatement();
													String sql12 = " Select * from NodeStatusUpdated where Node = '"
															+ node13
															+ "' and cluster= '"
															+ c2 + "'   ";

													ResultSet rs12 = st13
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c2n2 = rs12
																.getString(4);
													}

													if (c2n2.equals("updated")) {

														int x1 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in Cluster3 \n Do you want to Apply Reloxalization");
														if (x1 == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet Dropped");
														}
														if (x1 == 0) {

															String sql13 = "select * from NodeStatus where Node= '"
																	+ node13
																	+ "',status = '"
																	+ status
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";
															Statement st113 = connect
																	.createStatement();
															ResultSet rs13 = st113
																	.executeQuery(sql13);
															if (rs13.next() == true) {
																ip13 = rs13
																		.getString(2);
															}

															Statement upst13 = connect
																	.createStatement();
															String up13 = "Update NodeStatus set IPaddress = '"
																	+ ip13
																	+ "' where Node = '"
																	+ node13
																	+ "' and cluster = '"
																	+ c2
																	+ "'   ";
															upst13.executeUpdate(up13);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1113 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1113
																	.setIcon(green1113);
															imageLabeln1113
																	.setBounds(
																			764,
																			188,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green14 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));

															timer.start();
															Thread.sleep(2000);
															imageLabel13
																	.setIcon(green14);
															imageLabel13
																	.setBounds(
																			850,
																			220,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1314 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln1314
																	.setIcon(green1314);
															imageLabeln1314
																	.setBounds(
																			850,
																			180,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															imageLabel11
																	.setIcon(green14);
															imageLabel11
																	.setBounds(
																			950,
																			145,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															ImageIcon arrow1 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow2.png"));
															Arrow1.setIcon(arrow1);
															Arrow1.setBounds(
																	673, 300,
																	100, 100);

															timer.start();
															Thread.sleep(2000);
															imageLabel14
																	.setIcon(green14);
															imageLabel14
																	.setBounds(
																			500,
																			500,
																			100,
																			50);

														}
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1113 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1113
																.setIcon(green1113);
														imageLabeln1113
																.setBounds(764,
																		188,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														timer.start();
														Thread.sleep(2000);
														imageLabel13
																.setIcon(green14);
														imageLabel13.setBounds(
																850, 220, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1314 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1314
																.setIcon(green1314);
														imageLabeln1314
																.setBounds(850,
																		180,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green14);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

													}
												}
											} else {

												timer.start();
												Thread.sleep(2000);
												ImageIcon green810 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));

												imageLabeln810
														.setIcon(green810);
												imageLabeln810.setBounds(564,
														188, 90, 90);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green10 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel12.setIcon(green10);
												imageLabel12.setBounds(665,
														220, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1011 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));

												imageLabeln1011
														.setIcon(green1011);
												imageLabeln1011.setBounds(650,
														180, 100, 50);

												timer.start();
												Thread.sleep(2000);
												imageLabel9.setIcon(green10);
												imageLabel9.setBounds(750, 145,
														100, 50);

											}
										} else {
											System.out
													.println("begin Node10 default "
															+ c2n1);
											timer.start();
											Thread.sleep(2000);
											ImageIcon green810 = new ImageIcon(
													this.getClass()
															.getResource(
																	"green3.png"));

											imageLabeln810.setIcon(green810);
											imageLabeln810.setBounds(564, 188,
													90, 90);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green10 = new ImageIcon(
													this.getClass()
															.getResource(
																	"Gnode.png"));
											imageLabel12.setIcon(green10);
											imageLabel12.setBounds(665, 220,
													100, 50);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green1011 = new ImageIcon(
													this.getClass()
															.getResource(
																	"sn1green.png"));

											imageLabeln1011.setIcon(green1011);
											imageLabeln1011.setBounds(650, 180,
													100, 50);

											timer.start();
											Thread.sleep(2000);
											imageLabel9.setIcon(green10);
											imageLabel9.setBounds(750, 145,
													100, 50);

											if (n12 < n13) {

												String node12 = "Node12";
												Statement st12 = connect
														.createStatement();
												String sql12 = "select * from NodeStatusUpdated where Node = '"
														+ node12
														+ "' and cluster = '"
														+ c2 + "' ";

												ResultSet rs12 = st12
														.executeQuery(sql12);
												if (rs12.next() == true) {
													c2n2 = rs12.getString(4);
												}

												if (c2n2.equals("updated")) {

													int x12 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker Found in Cluster2 \n Do you want to Apply RElocalization...???");

													if (x12 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet Dropped");
													}
													if (x12 == 0) {

														Statement stm12 = connect
																.createStatement();
														String query12 = "select * from NodeStatus where Node = '"
																+ node12
																+ "' and cluster = '"
																+ c2 + "'  ";

														ResultSet rsm12 = stm12
																.executeQuery(query12);
														if (rsm12.next() == true) {
															ip12 = rsm12
																	.getString(2);
														}

														Statement stt12 = connect
																.createStatement();
														String up12 = "update NodeStatusUpdated set IPaddress = '"
																+ ip12
																+ "',status = '"
																+ status
																+ "' where Node = '"
																+ node12
																+ "' and cluster = '"
																+ c2 + "'  ";

														stt12.executeUpdate(up12);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1112 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1112
																.setIcon(green1112);
														imageLabeln1112
																.setBounds(750,
																		90,
																		100, 60);

														ImageIcon green12 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel10
																.setIcon(green12);
														imageLabel10.setBounds(
																850, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1214 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1214
																.setIcon(green1214);
														imageLabeln1214
																.setBounds(850,
																		110,
																		90, 80);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green12);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);
													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1112 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln1112
															.setIcon(green1112);
													imageLabeln1112.setBounds(
															750, 90, 100, 60);

													ImageIcon green12 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel10
															.setIcon(green12);
													imageLabel10.setBounds(850,
															70, 100, 50);

													timer.start();
													Thread.sleep(2000);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1214 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln1214
															.setIcon(green1214);
													imageLabeln1214.setBounds(
															850, 110, 90, 80);

													timer.start();
													Thread.sleep(2000);
													imageLabel11
															.setIcon(green12);
													imageLabel11.setBounds(950,
															145, 100, 50);

													ImageIcon arrow1 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow2.png"));
													Arrow1.setIcon(arrow1);
													Arrow1.setBounds(673, 300,
															100, 100);

													timer.start();
													Thread.sleep(2000);

													ImageIcon green14 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));

													imageLabel14
															.setIcon(green14);
													imageLabel14.setBounds(500,
															500, 100, 50);

												}
											}
											// //////////////////
											if (n12 > n13) {

												String node13 = "Node13";

												Statement st13 = connect
														.createStatement();
												String sql12 = " Select * from NodeStatusUpdated where Node = '"
														+ node13
														+ "' and cluster= '"
														+ c2 + "'   ";

												ResultSet rs12 = st13
														.executeQuery(sql12);
												if (rs12.next() == true) {
													c2n2 = rs12.getString(4);
												}

												if (c2n2.equals("updated")) {

													int x1 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in Cluster3 \n Do you want to Apply Reloxalization");
													if (x1 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet Dropped");
													}
													if (x1 == 0) {

														String sql13 = "select * from NodeStatus where Node= '"
																+ node13
																+ "' and cluster = '"
																+ c2 + "'  ";
														Statement st113 = connect
																.createStatement();
														ResultSet rs13 = st113
																.executeQuery(sql13);
														if (rs13.next() == true) {
															ip13 = rs13
																	.getString(2);
														}

														Statement upst13 = connect
																.createStatement();
														String up13 = "Update NodeStatus set IPaddress = '"
																+ ip13
																+ "',status = '"
																+ status
																+ "'  where Node = '"
																+ node13
																+ "' and cluster = '"
																+ c2 + "'   ";
														upst13.executeUpdate(up13);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1113 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1113
																.setIcon(green1113);
														imageLabeln1113
																.setBounds(764,
																		188,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														timer.start();
														Thread.sleep(2000);
														imageLabel13
																.setIcon(green14);
														imageLabel13.setBounds(
																850, 220, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1314 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1314
																.setIcon(green1314);
														imageLabeln1314
																.setBounds(850,
																		180,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green14);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);
														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);

													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1113 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln1113
															.setIcon(green1113);
													imageLabeln1113.setBounds(
															764, 188, 90, 90);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green14 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));

													timer.start();
													Thread.sleep(2000);
													imageLabel13
															.setIcon(green14);
													imageLabel13.setBounds(850,
															220, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1314 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln1314
															.setIcon(green1314);
													imageLabeln1314.setBounds(
															850, 180, 100, 50);

													timer.start();
													Thread.sleep(2000);
													imageLabel11
															.setIcon(green14);
													imageLabel11.setBounds(950,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrow1 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow2.png"));
													Arrow1.setIcon(arrow1);
													Arrow1.setBounds(673, 300,
															100, 100);

												}
											}
										}
									}
									System.out.println("closing 1st Condtion");

									if (n9 < n10) {

										String node9 = "Node9";
										String sql9 = "select * from NodeStatusUpdated where Node= '"
												+ node9
												+ "' and cluster= '"
												+ c2 + "' ";
										Statement stm9 = connect
												.createStatement();
										ResultSet rs19 = stm9
												.executeQuery(sql9);
										if (rs19.next() == true) {
											c2n3 = rs19.getString(4);
										}
										if (c2n3.equals("updated")) {
											int x = JOptionPane
													.showConfirmDialog(null,
															"Spoofing Attacker found in cluster2 \n Do you want to Apply Relocalization");

											if (x == 1) {
												JOptionPane.showMessageDialog(
														null, "Packet Dropped");
											}
											if (x == 0) {

												String sql99 = "select * from NodeStatus where Node= '"
														+ node9
														+ "' and cluster = '"
														+ c2 + "' ";
												Statement st9 = connect
														.createStatement();
												ResultSet rs9 = st9
														.executeQuery(sql99);
												if (rs9.next() == true) {
													ip10 = rs9.getString(2);
												}
												String up10 = "update NodeStatusUpdated set IPaddress = '"
														+ ip10
														+ "' , status = '"
														+ status
														+ "' where Node = '"
														+ node9
														+ "' and cluster = '"
														+ c2 + "'  ";
												Statement sup10 = connect
														.createStatement();
												sup10.executeUpdate(up10);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green89 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln89.setIcon(green89);
												imageLabeln89.setBounds(550,
														90, 100, 60);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green8 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel8.setIcon(green8);
												imageLabel8.setBounds(660, 70,
														100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green911 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));
												imageLabeln911
														.setIcon(green911);
												imageLabeln911.setBounds(660,
														110, 90, 80);

												timer.start();
												Thread.sleep(2000);
												imageLabel9.setIcon(green8);
												imageLabel9.setBounds(750, 145,
														100, 50);
												System.out.println("Node12 ");

												if (n12 < n13) {

													String node12 = "Node12";
													Statement st12 = connect
															.createStatement();
													System.out
															.println("connected");
													String sql12 = "select * from NodeStatusUpdated where Node ='"
															+ node12
															+ "' and cluster ='"
															+ c2 + "' ";

													System.out
															.println("query  :"
																	+ sql12);

													ResultSet rs12 = st12
															.executeQuery(sql12);
													System.out
															.println("Resultset");
													if (rs12.next() == true) {
														c2n2 = rs12
																.getString(4);
													}
													System.out
															.println("Node12 "
																	+ c2n2);
													if (c2n2.equals("updated")) {

														int x12 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker Found in Cluster2 \n Do you want to Apply RElocalization...???");

														if (x12 == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet Dropped");
														}
														if (x12 == 0) {

															Statement stm12 = connect
																	.createStatement();
															String query12 = "select * from NodeStatus where Node = '"
																	+ node12
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";

															ResultSet rsm12 = stm12
																	.executeQuery(query12);
															if (rsm12.next() == true) {
																ip12 = rsm12
																		.getString(2);
															}

															Statement stt12 = connect
																	.createStatement();
															String up12 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip12
																	+ "' ,status = '"
																	+ status
																	+ "' where Node = '"
																	+ node12
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";

															stt12.executeUpdate(up12);
															timer.start();
															Thread.sleep(2000);
															ImageIcon green1112 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln1112
																	.setIcon(green1112);
															imageLabeln1112
																	.setBounds(
																			750,
																			90,
																			100,
																			60);

															ImageIcon green12 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel10
																	.setIcon(green12);
															imageLabel10
																	.setBounds(
																			850,
																			70,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1214 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1214
																	.setIcon(green1214);
															imageLabeln1214
																	.setBounds(
																			850,
																			110,
																			90,
																			80);

															timer.start();
															Thread.sleep(2000);
															imageLabel11
																	.setIcon(green12);
															imageLabel11
																	.setBounds(
																			950,
																			145,
																			100,
																			50);

															ImageIcon arrow1 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow2.png"));
															Arrow1.setIcon(arrow1);
															Arrow1.setBounds(
																	673, 300,
																	100, 100);

															timer.start();
															Thread.sleep(2000);

															ImageIcon green14 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));

															imageLabel14
																	.setIcon(green14);
															imageLabel14
																	.setBounds(
																			500,
																			500,
																			100,
																			50);
														}
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1112 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1112
																.setIcon(green1112);
														imageLabeln1112
																.setBounds(750,
																		90,
																		100, 60);

														ImageIcon green12 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel10
																.setIcon(green12);
														imageLabel10.setBounds(
																850, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1214 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1214
																.setIcon(green1214);
														imageLabeln1214
																.setBounds(850,
																		110,
																		90, 80);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green12);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);

													}
												}
												// ///////////////////
												if (n12 > n13) {

													String node13 = "Node13";

													Statement st13 = connect
															.createStatement();
													String sql12 = " Select * from NodeStatusUpdated where Node = '"
															+ node13
															+ "' and cluster= '"
															+ c2 + "'   ";

													ResultSet rs12 = st13
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c2n2 = rs12
																.getString(4);
													}

													if (c2n2.equals("updated")) {

														int x1 = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in Cluster3 \n Do you want to Apply Reloxalization");
														if (x1 == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packet Dropped");
														}
														if (x1 == 0) {

															String sql13 = "select * from NodeStatus where Node= '"
																	+ node13
																	+ "' and cluster = '"
																	+ c2
																	+ "'  ";
															Statement st113 = connect
																	.createStatement();
															ResultSet rs13 = st113
																	.executeQuery(sql13);
															if (rs13.next() == true) {
																ip13 = rs13
																		.getString(2);
															}

															Statement upst13 = connect
																	.createStatement();
															String up13 = "Update NodeStatus set IPaddress = '"
																	+ ip13
																	+ "' ,status = '"
																	+ status
																	+ "' where Node = '"
																	+ node13
																	+ "' and cluster = '"
																	+ c2
																	+ "'   ";
															upst13.executeUpdate(up13);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1113 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1113
																	.setIcon(green1113);
															imageLabeln1113
																	.setBounds(
																			764,
																			188,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green14 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));

															timer.start();
															Thread.sleep(2000);
															imageLabel13
																	.setIcon(green14);
															imageLabel13
																	.setBounds(
																			850,
																			220,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1314 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabeln1314
																	.setIcon(green1314);
															imageLabeln1314
																	.setBounds(
																			850,
																			180,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															imageLabel11
																	.setIcon(green14);
															imageLabel11
																	.setBounds(
																			950,
																			145,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															ImageIcon arrow1 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"greenArrow2.png"));
															Arrow1.setIcon(arrow1);
															Arrow1.setBounds(
																	673, 300,
																	100, 100);

															timer.start();
															Thread.sleep(2000);
															imageLabel14
																	.setIcon(green14);
															imageLabel14
																	.setBounds(
																			500,
																			500,
																			100,
																			50);

														}
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1113 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1113
																.setIcon(green1113);
														imageLabeln1113
																.setBounds(764,
																		188,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														timer.start();
														Thread.sleep(2000);
														imageLabel13
																.setIcon(green14);
														imageLabel13.setBounds(
																850, 220, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1314 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1314
																.setIcon(green1314);
														imageLabeln1314
																.setBounds(850,
																		180,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green14);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

													}
												}
											}
										}

										else {

											timer.start();
											Thread.sleep(2000);
											ImageIcon green89 = new ImageIcon(
													this.getClass()
															.getResource(
																	"sn1green.png"));
											imageLabeln89.setIcon(green89);
											imageLabeln89.setBounds(550, 90,
													100, 60);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green8 = new ImageIcon(
													this.getClass()
															.getResource(
																	"Gnode.png"));
											imageLabel8.setIcon(green8);
											imageLabel8.setBounds(660, 70, 100,
													50);

											timer.start();
											Thread.sleep(2000);
											ImageIcon green911 = new ImageIcon(
													this.getClass()
															.getResource(
																	"green3.png"));
											imageLabeln911.setIcon(green911);
											imageLabeln911.setBounds(660, 110,
													90, 80);

											timer.start();
											Thread.sleep(2000);
											imageLabel9.setIcon(green8);
											imageLabel9.setBounds(750, 145,
													100, 50);
											System.out.println("Node12 ");

											if (n12 < n13) {

												String node12 = "Node12";
												Statement st12 = connect
														.createStatement();
												System.out.println("connected");
												String sql12 = "select * from NodeStatusUpdated where Node = '"
														+ node12
														+ "' and cluster = '"
														+ c2 + "' ";
												System.out.println(sql12);
												ResultSet rs12 = st12
														.executeQuery(sql12);
												if (rs12.next() == true) {
													c2n2 = rs12.getString(4);
												}
												System.out.println("Node12 "
														+ c2n2);
												if (c2n2.equals("updated")) {

													int x12 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker Found in Cluster2 \n Do you want to Apply RElocalization...???");

													if (x12 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet Dropped");
													}
													if (x12 == 0) {

														Statement stm12 = connect
																.createStatement();
														String query12 = "select * from NodeStatus where Node = '"
																+ node12
																+ "' and cluster = '"
																+ c2 + "'  ";

														ResultSet rsm12 = stm12
																.executeQuery(query12);
														if (rsm12.next() == true) {
															ip12 = rsm12
																	.getString(2);
														}

														Statement stt12 = connect
																.createStatement();
														String up12 = "update NodeStatusUpdated set IPaddress = '"
																+ ip12
																+ "' ,status = '"
																+ status
																+ "' where Node = '"
																+ node12
																+ "' and cluster = '"
																+ c2 + "'  ";

														stt12.executeUpdate(up12);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1112 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1112
																.setIcon(green1112);
														imageLabeln1112
																.setBounds(750,
																		90,
																		100, 60);

														ImageIcon green12 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel10
																.setIcon(green12);
														imageLabel10.setBounds(
																850, 70, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1214 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1214
																.setIcon(green1214);
														imageLabeln1214
																.setBounds(850,
																		110,
																		90, 80);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green12);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);
													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1112 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln1112
															.setIcon(green1112);
													imageLabeln1112.setBounds(
															750, 90, 100, 60);

													ImageIcon green12 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));
													imageLabel10
															.setIcon(green12);
													imageLabel10.setBounds(850,
															70, 100, 50);

													timer.start();
													Thread.sleep(2000);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1214 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln1214
															.setIcon(green1214);
													imageLabeln1214.setBounds(
															850, 110, 90, 80);

													timer.start();
													Thread.sleep(2000);
													imageLabel11
															.setIcon(green12);
													imageLabel11.setBounds(950,
															145, 100, 50);

													ImageIcon arrow1 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow2.png"));
													Arrow1.setIcon(arrow1);
													Arrow1.setBounds(673, 300,
															100, 100);

													timer.start();
													Thread.sleep(2000);

													ImageIcon green14 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));

													imageLabel14
															.setIcon(green14);
													imageLabel14.setBounds(500,
															500, 100, 50);

												}
											}

											if (n12 > n13) {

												String node13 = "Node13";

												Statement st13 = connect
														.createStatement();
												String sql12 = " Select * from NodeStatusUpdated where Node = '"
														+ node13
														+ "' and cluster= '"
														+ c2 + "'   ";

												ResultSet rs12 = st13
														.executeQuery(sql12);
												if (rs12.next() == true) {
													c2n2 = rs12.getString(4);
												}

												if (c2n2.equals("updated")) {

													int x1 = JOptionPane
															.showConfirmDialog(
																	null,
																	"Spoofing attacker found in Cluster3 Node13 \n Do you want to Apply Reloxalization");
													if (x1 == 1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Packet Dropped");
													}
													if (x1 == 0) {

														String sql13 = "select * from NodeStatus where Node= '"
																+ node13
																+ "' and cluster = '"
																+ c2 + "'  ";
														Statement st113 = connect
																.createStatement();
														ResultSet rs13 = st113
																.executeQuery(sql13);
														if (rs13.next() == true) {
															ip13 = rs13
																	.getString(2);
														}
														System.out
																.println("IPAddress is : "
																		+ ip13);
														Statement upst13 = connect
																.createStatement();
														String up13 = "Update NodeStatusUpdated set IPaddress = '"
																+ ip13
																+ "' ,status = '"
																+ status
																+ "' where Node = '"
																+ node13
																+ "' and cluster = '"
																+ c2 + "'   ";
														upst13.executeUpdate(up13);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1113 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1113
																.setIcon(green1113);
														imageLabeln1113
																.setBounds(764,
																		188,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green14 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));

														timer.start();
														Thread.sleep(2000);
														imageLabel13
																.setIcon(green14);
														imageLabel13.setBounds(
																850, 220, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1314 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1314
																.setIcon(green1314);
														imageLabeln1314
																.setBounds(850,
																		180,
																		100, 50);

														timer.start();
														Thread.sleep(2000);
														imageLabel11
																.setIcon(green14);
														imageLabel11.setBounds(
																950, 145, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon arrow1 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"greenArrow2.png"));
														Arrow1.setIcon(arrow1);
														Arrow1.setBounds(673,
																300, 100, 100);

														timer.start();
														Thread.sleep(2000);
														imageLabel14
																.setIcon(green14);
														imageLabel14.setBounds(
																500, 500, 100,
																50);

													}
												} else {

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1113 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"green3.png"));
													imageLabeln1113
															.setIcon(green1113);
													imageLabeln1113.setBounds(
															764, 188, 90, 90);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green14 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"Gnode.png"));

													timer.start();
													Thread.sleep(2000);
													imageLabel13
															.setIcon(green14);
													imageLabel13.setBounds(850,
															220, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon green1314 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"sn1green.png"));
													imageLabeln1314
															.setIcon(green1314);
													imageLabeln1314.setBounds(
															850, 180, 100, 50);

													timer.start();
													Thread.sleep(2000);
													imageLabel11
															.setIcon(green14);
													imageLabel11.setBounds(950,
															145, 100, 50);

													timer.start();
													Thread.sleep(2000);
													ImageIcon arrow1 = new ImageIcon(
															this.getClass()
																	.getResource(
																			"greenArrow2.png"));
													Arrow1.setIcon(arrow1);
													Arrow1.setBounds(673, 300,
															100, 100);

												}
											}
										}
									}
									// ///------Cluster2-End-------//////////
									// ///------Cluster3-start-------//////////
									ImageIcon green14 = new ImageIcon(this
											.getClass()
											.getResource("Gnode.png"));

									timer.start();
									Thread.sleep(2000);
									imageLabel14.setIcon(green14);
									imageLabel14.setBounds(500, 500, 100, 50);
									System.out.println("cluster3 started");
									Statement stmt1 = connect.createStatement();
									String sql2 = " Select * from Cluster3  ";
									ResultSet rs211 = stmt1.executeQuery(sql2);
									System.out.println("opened rs" + rs211);

									if (rs211.next() == true) {

										int n16 = rs211.getInt(2);
										int n17 = rs211.getInt(3);
										int n18 = rs211.getInt(4);
										int n19 = rs211.getInt(5);
										int n20 = rs211.getInt(6);
										String c33 = "cluster3";
										System.out.println(n18);
										if (n16 < n17) {

											System.out.println("n16 value "
													+ n16);
											String node16 = "Node16";

											Statement st7 = connect
													.createStatement();
											String sql7 = "select * from NodeStatusUpdated  where Node= '"
													+ node16
													+ "' and cluster = '"
													+ c33
													+ "'  ";
											ResultSet rs7 = st7
													.executeQuery(sql7);
											if (rs7.next() == true) {
												c3n1 = rs7.getString(4);
											}
											System.out.println("C3 status is :"
													+ c3n1);
											if (c3n1.equals("updated")) {
												String sql17 = "select * from NodeStatus where Node='"
														+ node16
														+ "' and cluster = '"
														+ c33 + "' ";
												Statement ss7 = connect
														.createStatement();
												ResultSet rs17 = ss7
														.executeQuery(sql17);
												if (rs17.next() == true) {
													ip17 = rs17.getString(2);
												}
												System.out
														.println("IPAddress is : "
																+ ip17);
												Statement sup17 = connect
														.createStatement();
												String up17 = "update NodeStatusUpdated set IPaddress = '"
														+ ip17
														+ "' ,status = '"
														+ status
														+ "' where Node= '"
														+ node16
														+ "' and cluster = '"
														+ c33 + "'";
												sup17.executeUpdate(up17);
												timer.start();
												Thread.sleep(2000);
												ImageIcon green1516 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln1516
														.setIcon(green1516);
												imageLabeln1516.setBounds(490,
														430, 100, 70);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green16 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel15.setIcon(green16);
												imageLabel15.setBounds(600,
														400, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1113 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));
												imageLabeln1618
														.setIcon(green1113);
												imageLabeln1618.setBounds(610,
														450, 90, 90);

												timer.start();
												Thread.sleep(2000);
												imageLabel17.setIcon(green16);

												imageLabel17.setBounds(700,
														500, 100, 50);

												if (n19 < n20) {

													String node19 = "Node19";

													Statement st11 = connect
															.createStatement();
													String sql11 = "select * from NodeStatusUpdated where Node = '"
															+ node19
															+ "' and cluster = '"
															+ c33 + "'  ";
													ResultSet rs01 = st11
															.executeQuery(sql11);
													if (rs01.next() == true) {
														c3n2 = rs01
																.getString(4);
													}
													if (c3n2.equals("updated")) {
														Statement ss07 = connect
																.createStatement();
														String sql19 = "select * from NodeStatus where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "' ";

														ResultSet rs19 = ss07
																.executeQuery(sql19);
														if (rs19.next() == true) {
															ip19 = rs19
																	.getString(2);
														}
														Statement st19 = connect
																.createStatement();
														String up19 = "update NodeStatusUpdated set IPaddress = '"
																+ ip19
																+ "',status = '"
																+ status
																+ "' where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "'  ";

														st19.executeUpdate(up19);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}
												if (n19 > n20) {

													String node20 = "Node20";
													Statement ss20 = connect
															.createStatement();
													String sql12 = " select * from NodeStatusUpdated where Node= '"
															+ node20
															+ "' and cluster = '"
															+ c33 + "'    ";
													ResultSet rs12 = ss20
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c3n3 = rs12
																.getString(4);
													}
													if (c3n3.equals("updated")) {

														int x = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster3 \n Do you want to Apply Relocalization ");

														if (x == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packets Dropped");
														}
														if (x == 0) {

															Statement s19 = connect
																	.createStatement();
															String sql9 = "select * from NodeStatus where Node = '"
																	+ node20
																	+ "' and cluster ='"
																	+ c33
																	+ "'   ";
															ResultSet rs20 = s19
																	.executeQuery(sql9);

															if (rs20.next() == true) {
																ip20 = rs20
																		.getString(2);
															}

															String up20 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip20
																	+ "',status = '"
																	+ status
																	+ "' where Node = '"
																	+ node20
																	+ "' and cluster = '"
																	+ c33
																	+ "'  ";
															Statement st20 = connect
																	.createStatement();
															st20.executeUpdate(up20);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1820 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1820
																	.setIcon(green1820);
															imageLabeln1820
																	.setBounds(
																			700,
																			558,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green19 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel19
																	.setIcon(green19);
															imageLabel19
																	.setBounds(
																			800,
																			600,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															imageLabelnd20
																	.setIcon(green1516);
															imageLabelnd20
																	.setBounds(
																			800,
																			525,
																			100,
																			70);

															timer.start();
															Thread.sleep(2000);
															ImageIcon greendest = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Destination.png"));
															imageLabel20
																	.setIcon(greendest);
															imageLabel20
																	.setBounds(
																			900,
																			500,
																			100,
																			50);

															client = new Socket(
																	DestIPAddress,
																	10001);
															DataOutputStream dos = new DataOutputStream(
																	client.getOutputStream());

															dos.writeUTF(data);
														}
													} else {
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1820 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1820
																.setIcon(green1820);
														imageLabeln1820
																.setBounds(700,
																		558,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel19
																.setIcon(green19);
														imageLabel19.setBounds(
																800, 600, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														imageLabelnd20
																.setIcon(green1516);
														imageLabelnd20
																.setBounds(800,
																		525,
																		100, 70);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}
											}

											else {
												Thread.sleep(2000);
												ImageIcon green1516 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln1516
														.setIcon(green1516);
												imageLabeln1516.setBounds(490,
														430, 100, 70);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green16 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel15.setIcon(green16);
												imageLabel15.setBounds(600,
														400, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1113 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));
												imageLabeln1618
														.setIcon(green1113);
												imageLabeln1618.setBounds(610,
														450, 90, 90);

												timer.start();
												Thread.sleep(2000);
												imageLabel17.setIcon(green16);

												imageLabel17.setBounds(700,
														500, 100, 50);

												if (n19 < n20) {
													String node19 = "Node19";

													Statement st11 = connect
															.createStatement();
													String sql11 = "select * from NodeStatusUpdated where Node = '"
															+ node19
															+ "' and cluster = '"
															+ c33 + "'  ";
													ResultSet rs01 = st11
															.executeQuery(sql11);
													if (rs01.next() == true) {
														c3n2 = rs01
																.getString(4);
													}
													if (c3n2.equals("updated")) {
														Statement ss07 = connect
																.createStatement();
														String sql19 = "select * from NodeStatus where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "' ";

														ResultSet rs19 = ss07
																.executeQuery(sql19);
														if (rs19.next() == true) {
															ip19 = rs19
																	.getString(2);
														}
														Statement st19 = connect
																.createStatement();
														String up19 = "update NodeStatusUpdated set IPaddress = '"
																+ ip19
																+ "',status = '"
																+ status
																+ "' where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "'  ";

														st19.executeUpdate(up19);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}

												if (n19 > n20) {

													String node20 = "Node20";
													Statement ss20 = connect
															.createStatement();
													String sql12 = " select * from NodeStatusUpdated where Node= '"
															+ node20
															+ "' and cluster = '"
															+ c33 + "'    ";
													ResultSet rs12 = ss20
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c3n3 = rs12
																.getString(4);
													}
													if (c3n3.equals("updated")) {

														int x = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster3 \n Do you want to Apply Relocalization ");

														if (x == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packets Dropped");
														}
														if (x == 0) {

															Statement s19 = connect
																	.createStatement();
															String sql9 = "select * from NodeStatus where Node = '"
																	+ node20
																	+ "' and cluster ='"
																	+ c33
																	+ "'   ";
															ResultSet rs20 = s19
																	.executeQuery(sql9);

															if (rs20.next() == true) {
																ip20 = rs20
																		.getString(2);
															}

															String up20 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip20
																	+ "',status = '"
																	+ status
																	+ "' where Node = '"
																	+ node20
																	+ "' and cluster = '"
																	+ c33
																	+ "'  ";
															Statement st20 = connect
																	.createStatement();
															st20.executeUpdate(up20);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1820 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1820
																	.setIcon(green1820);
															imageLabeln1820
																	.setBounds(
																			700,
																			558,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green19 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel19
																	.setIcon(green19);
															imageLabel19
																	.setBounds(
																			800,
																			600,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															imageLabelnd20
																	.setIcon(green1516);
															imageLabelnd20
																	.setBounds(
																			800,
																			525,
																			100,
																			70);

															timer.start();
															Thread.sleep(2000);
															ImageIcon greendest = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Destination.png"));
															imageLabel20
																	.setIcon(greendest);
															imageLabel20
																	.setBounds(
																			900,
																			500,
																			100,
																			50);

															client = new Socket(
																	DestIPAddress,
																	10001);
															DataOutputStream dos = new DataOutputStream(
																	client.getOutputStream());

															dos.writeUTF(data);
														}
													} else {
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1820 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1820
																.setIcon(green1820);
														imageLabeln1820
																.setBounds(700,
																		558,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel19
																.setIcon(green19);
														imageLabel19.setBounds(
																800, 600, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														imageLabelnd20
																.setIcon(green1516);
														imageLabelnd20
																.setBounds(800,
																		525,
																		100, 70);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}

											}
										}

										if (n16 > n17) {

											String node17 = "Node17";

											String sql21 = "select * from NodeStatusUpdated where Node= '"
													+ node17
													+ "' and cluster = '"
													+ c33
													+ "'  ";
											Statement ss21 = connect
													.createStatement();
											System.out.println(node17 + "\n"
													+ "c3");

											ResultSet rs21 = ss21
													.executeQuery(sql21);
											if (rs21.next() == true) {
												c3n3 = rs21.getString(4);
											}

											System.out.println("status is: "
													+ c3n3);
											if (c3n3.equals("updated")) {
												String sql22 = "select * from NodeStatus where Node = '"
														+ node17
														+ "' and cluster = '"
														+ c33 + "'  ";
												Statement st22 = connect
														.createStatement();
												ResultSet rs22 = st22
														.executeQuery(sql22);
												if (rs22.next() == true) {
													ip17 = rs22.getString(2);
												}

												Statement st17 = connect
														.createStatement();
												String up17 = " update NodeStatusUpdated set IPaddress = '"
														+ ip17
														+ "',status = '"
														+ status
														+ "' where Node= '"
														+ node17
														+ "'  and cluster = '"
														+ c33 + "'  ";

												st17.executeUpdate(up17);
												timer.start();
												Thread.sleep(2000);
												ImageIcon green1517 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));

												imageLabeln1517
														.setIcon(green1517);
												imageLabeln1517.setBounds(500,
														558, 90, 90);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green17 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel16.setIcon(green17);
												imageLabel16.setBounds(600,
														600, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1718 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln1718
														.setIcon(green1718);
												imageLabeln1718.setBounds(590,
														530, 100, 70);

												ImageIcon green16 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel17.setIcon(green16);
												imageLabel17.setBounds(700,
														500, 100, 50);

												if (n19 < n20) {
													String node19 = "Node19";

													Statement st11 = connect
															.createStatement();
													String sql11 = "select * from NodeStatusUpdated where Node = '"
															+ node19
															+ "' and cluster = '"
															+ c33 + "'  ";
													ResultSet rs01 = st11
															.executeQuery(sql11);
													if (rs01.next() == true) {
														c3n2 = rs01
																.getString(4);
													}
													if (c3n2.equals("updated")) {
														Statement ss07 = connect
																.createStatement();
														String sql19 = "select * from NodeStatus where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "' ";

														ResultSet rs19 = ss07
																.executeQuery(sql19);
														if (rs19.next() == true) {
															ip19 = rs19
																	.getString(2);
														}
														Statement st19 = connect
																.createStatement();
														String up19 = "update NodeStatusUpdated set IPaddress = '"
																+ ip19
																+ "',status = '"
																+ status
																+ "' where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "'  ";

														st19.executeUpdate(up19);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}
												// //////////////////
												if (n19 > n20) {

													String node20 = "Node20";
													Statement ss20 = connect
															.createStatement();
													String sql12 = " select * from NodeStatusUpdated where Node= '"
															+ node20
															+ "' and cluster = '"
															+ c33 + "'    ";
													ResultSet rs12 = ss20
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c3n3 = rs12
																.getString(4);
													}
													if (c3n3.equals("updated")) {

														int x = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster3 \n Do you want to Apply Relocalization ");

														if (x == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packets Dropped");
														}
														if (x == 0) {
															ImageIcon green1516 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															Statement s19 = connect
																	.createStatement();
															String sql9 = "select * from NodeStatus where Node = '"
																	+ node20
																	+ "' and cluster ='"
																	+ c33
																	+ "'   ";
															ResultSet rs20 = s19
																	.executeQuery(sql9);

															if (rs20.next() == true) {
																ip20 = rs20
																		.getString(2);
															}

															String up20 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip20
																	+ "',status = '"
																	+ status
																	+ "' where Node = '"
																	+ node20
																	+ "' and cluster = '"
																	+ c33
																	+ "'  ";
															Statement st20 = connect
																	.createStatement();
															st20.executeUpdate(up20);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1820 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1820
																	.setIcon(green1820);
															imageLabeln1820
																	.setBounds(
																			700,
																			558,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green19 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel19
																	.setIcon(green19);
															imageLabel19
																	.setBounds(
																			800,
																			600,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															imageLabelnd20
																	.setIcon(green1516);
															imageLabelnd20
																	.setBounds(
																			800,
																			525,
																			100,
																			70);

															timer.start();
															Thread.sleep(2000);
															ImageIcon greendest = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Destination.png"));
															imageLabel20
																	.setIcon(greendest);
															imageLabel20
																	.setBounds(
																			900,
																			500,
																			100,
																			50);

															client = new Socket(
																	DestIPAddress,
																	10001);
															DataOutputStream dos = new DataOutputStream(
																	client.getOutputStream());

															dos.writeUTF(data);
														}
													} else {
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1820 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1820
																.setIcon(green1820);
														imageLabeln1820
																.setBounds(700,
																		558,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel19
																.setIcon(green19);
														imageLabel19.setBounds(
																800, 600, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1516 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabelnd20
																.setIcon(green1516);
														imageLabelnd20
																.setBounds(800,
																		525,
																		100, 70);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}

											} else {
												// default part
												System.out
														.println("default execurion part");
												timer.start();
												Thread.sleep(2000);
												ImageIcon green1517 = new ImageIcon(
														this.getClass()
																.getResource(
																		"green3.png"));

												imageLabeln1517
														.setIcon(green1517);
												imageLabeln1517.setBounds(500,
														558, 90, 90);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green17 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel16.setIcon(green17);
												imageLabel16.setBounds(600,
														600, 100, 50);

												timer.start();
												Thread.sleep(2000);
												ImageIcon green1718 = new ImageIcon(
														this.getClass()
																.getResource(
																		"sn1green.png"));
												imageLabeln1718
														.setIcon(green1718);
												imageLabeln1718.setBounds(590,
														530, 100, 70);

												ImageIcon green16 = new ImageIcon(
														this.getClass()
																.getResource(
																		"Gnode.png"));
												imageLabel17.setIcon(green16);
												imageLabel17.setBounds(700,
														500, 100, 50);

												if (n19 < n20) {
													String node19 = "Node19";

													Statement st11 = connect
															.createStatement();
													String sql11 = "select * from NodeStatusUpdated where Node = '"
															+ node19
															+ "' and cluster = '"
															+ c33 + "'  ";
													ResultSet rs01 = st11
															.executeQuery(sql11);
													if (rs01.next() == true) {
														c3n2 = rs01
																.getString(4);
													}
													if (c3n2.equals("updated")) {
														Statement ss07 = connect
																.createStatement();
														String sql19 = "select * from NodeStatus where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "' ";

														ResultSet rs19 = ss07
																.executeQuery(sql19);
														if (rs19.next() == true) {
															ip19 = rs19
																	.getString(2);
														}
														Statement st19 = connect
																.createStatement();
														String up19 = "update NodeStatusUpdated set IPaddress = '"
																+ ip19
																+ "',status = '"
																+ status
																+ "' where Node = '"
																+ node19
																+ "' and cluster = '"
																+ c33 + "'  ";

														st19.executeUpdate(up19);
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													} else {

														timer.start();
														Thread.sleep(2000);
														ImageIcon green1819 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabeln1819
																.setIcon(green1819);
														imageLabeln1819
																.setBounds(690,
																		430,
																		100, 70);

														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel18
																.setIcon(green19);
														imageLabel18.setBounds(
																800, 400, 100,
																50);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19d = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabel19d
																.setIcon(green19d);
														imageLabel19d
																.setBounds(810,
																		450,
																		90, 90);

														imageLabel18
																.setIcon(green16);
														imageLabel18.setBounds(
																800, 400, 100,
																50);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}
												// ///////////////
												if (n19 > n20) {

													String node20 = "Node20";
													Statement ss20 = connect
															.createStatement();
													String sql12 = " select * from NodeStatusUpdated where Node= '"
															+ node20
															+ "' and cluster = '"
															+ c33 + "'    ";
													ResultSet rs12 = ss20
															.executeQuery(sql12);
													if (rs12.next() == true) {
														c3n3 = rs12
																.getString(4);
													}
													if (c3n3.equals("updated")) {

														int x = JOptionPane
																.showConfirmDialog(
																		null,
																		"Spoofing attacker found in the cluster3 \n Do you want to Apply Relocalization ");

														if (x == 1) {
															JOptionPane
																	.showMessageDialog(
																			null,
																			"Packets Dropped");
														}
														if (x == 0) {

															Statement s19 = connect
																	.createStatement();
															String sql9 = "select * from NodeStatus where Node = '"
																	+ node20
																	+ "' and cluster ='"
																	+ c33
																	+ "'   ";
															ResultSet rs20 = s19
																	.executeQuery(sql9);

															if (rs20.next() == true) {
																ip20 = rs20
																		.getString(2);
															}

															String up20 = "update NodeStatusUpdated set IPaddress = '"
																	+ ip20
																	+ "',status = '"
																	+ status
																	+ "' where Node = '"
																	+ node20
																	+ "' and cluster = '"
																	+ c33
																	+ "'  ";
															Statement st20 = connect
																	.createStatement();
															st20.executeUpdate(up20);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1820 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"green3.png"));
															imageLabeln1820
																	.setIcon(green1820);
															imageLabeln1820
																	.setBounds(
																			700,
																			558,
																			90,
																			90);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green19 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Gnode.png"));
															imageLabel19
																	.setIcon(green19);
															imageLabel19
																	.setBounds(
																			800,
																			600,
																			100,
																			50);

															timer.start();
															Thread.sleep(2000);
															ImageIcon green1516 = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"sn1green.png"));
															imageLabelnd20
																	.setIcon(green1516);
															imageLabelnd20
																	.setBounds(
																			800,
																			525,
																			100,
																			70);

															timer.start();
															Thread.sleep(2000);
															ImageIcon greendest = new ImageIcon(
																	this.getClass()
																			.getResource(
																					"Destination.png"));
															imageLabel20
																	.setIcon(greendest);
															imageLabel20
																	.setBounds(
																			900,
																			500,
																			100,
																			50);

															client = new Socket(
																	DestIPAddress,
																	10001);
															DataOutputStream dos = new DataOutputStream(
																	client.getOutputStream());

															dos.writeUTF(data);
														}
													} else {
														timer.start();
														Thread.sleep(2000);
														ImageIcon green1820 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"green3.png"));
														imageLabeln1820
																.setIcon(green1820);
														imageLabeln1820
																.setBounds(700,
																		558,
																		90, 90);

														timer.start();
														Thread.sleep(2000);
														ImageIcon green19 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Gnode.png"));
														imageLabel19
																.setIcon(green19);
														imageLabel19.setBounds(
																800, 600, 100,
																50);

														timer.start();
														Thread.sleep(2000);

														ImageIcon green1516 = new ImageIcon(
																this.getClass()
																		.getResource(
																				"sn1green.png"));
														imageLabelnd20
																.setIcon(green1516);
														imageLabelnd20
																.setBounds(800,
																		525,
																		100, 70);

														timer.start();
														Thread.sleep(2000);
														ImageIcon greendest = new ImageIcon(
																this.getClass()
																		.getResource(
																				"Destination.png"));
														imageLabel20
																.setIcon(greendest);
														imageLabel20.setBounds(
																900, 500, 100,
																50);

														client = new Socket(
																DestIPAddress,
																10001);
														DataOutputStream dos = new DataOutputStream(
																client.getOutputStream());

														dos.writeUTF(data);
													}
												}
											}
										}
									}
								}
							}
						} catch (Exception Ex) {
							System.out.println(Ex);
						}
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == item1) {
			new AttackerDetails();
		}

		if (e.getSource() == item2) {

			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect = DriverManager
						.getConnection("jdbc:odbc:Cluster");
				Statement stmt = connect.createStatement();
				Statement stmt0 = connect.createStatement();
				Statement stmt1 = connect.createStatement();
				Statement stmt2 = connect.createStatement();
				Statement stmt3 = connect.createStatement();
				Statement stmt4 = connect.createStatement();
				Statement stmt5 = connect.createStatement();

				String ip = "";
				String sts = "";
				String c1 = "Cluster1";
				String c2 = "Cluster2";
				String c3 = "Cluster3";
				String des = "Destination";

				String sql = "update NodeStatus set IPaddress = '" + ip
						+ "'  where cluster = '" + c1 + "' ";
				stmt.executeUpdate(sql);

				String sql0 = "update NodeStatus set IPaddress = '" + ip
						+ "'  where cluster = '" + c2 + "' ";
				stmt.executeUpdate(sql0);

				String sql01 = "update NodeStatus set IPaddress = '" + ip
						+ "' where cluster = '" + c3 + "' ";
				stmt0.executeUpdate(sql01);

				String sql1 = "update NodeStatusUpdated set IPaddress = '" + ip
						+ "',status ='" + sts + "' where cluster = '" + c1
						+ "' ";
				stmt1.executeUpdate(sql1);

				String sql2 = "update NodeStatusUpdated set IPaddress = '" + ip
						+ "',status ='" + sts + "' where cluster = '" + c2
						+ "' ";
				stmt2.executeUpdate(sql2);

				String sql3 = "update NodeStatusUpdated set IPaddress = '" + ip
						+ "',status ='" + sts + "' where cluster = '" + c3
						+ "' ";
				stmt3.executeUpdate(sql3);
				
				
				String sql4 = "delete from  NodeStatusUpdated where Node= '" + des
				+ "' ";
				stmt4.executeUpdate(sql4);
		
		
				String sql5 = "delete from  NodeStatus where Node= '" + des+ "' ";
				stmt5.executeUpdate(sql5);

				System.exit(0);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		if (e.getSource() == button) {

			try {

				Vector heading = new Vector();

				heading.addElement("N-2");
				heading.addElement("N-3");
				heading.addElement("N-4");
				heading.addElement("N-5");
				heading.addElement("N-6");
				heading.addElement("N-7");

				Vector data = new Vector();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect = DriverManager
						.getConnection("jdbc:odbc:Cluster");
				Statement stmt = connect.createStatement();

				String query = "SELECT * FROM Cluster1";
				ResultSet rs = stmt.executeQuery(query);

				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();

				while (rs.next()) {
					Vector row = new Vector();
					for (int i = 1; i <= col; i++) {
						row.addElement(rs.getObject(i));

					}

					data.addElement(row);
				}

				JTable table = new JTable(data, heading);

				JScrollPane pane = new JScrollPane(table);

				pane.setBounds(30, 500, 300, 150);
				c.add(pane);
				// c.add(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (e.getSource() == ipc1) {
			new IPCluster1();
		}

		if (e.getSource() == ipc2) {
			new IPCluster2();
		}

		if (e.getSource() == ipc3) {
			new IPCluster3();
		}

		if (e.getSource() == button1) {

			try {

				Vector heading = new Vector();

				heading.addElement("N-8");
				heading.addElement("N-9");
				heading.addElement("N-10");
				heading.addElement("N-11");
				heading.addElement("N-12");
				heading.addElement("N-13");
				heading.addElement("N-14");

				Vector data = new Vector();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect = DriverManager
						.getConnection("jdbc:odbc:Cluster");
				Statement stmt = connect.createStatement();

				String query = "SELECT * FROM Cluster2";
				ResultSet rs = stmt.executeQuery(query);

				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();

				while (rs.next()) {
					Vector row = new Vector();
					for (int i = 1; i <= col; i++) {
						row.addElement(rs.getObject(i));

					}

					data.addElement(row);
				}

				JTable table = new JTable(data, heading);

				JScrollPane pane = new JScrollPane(table);

				pane.setBounds(30, 500, 300, 150);
				c.add(pane);
				// c.add(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		
		if (e.getSource() == item11) {
			SpoofingAttackers sa=new SpoofingAttackers();
			sa.setSize(600,600);
			sa.setVisible(true);
		}
		
		if (e.getSource() == item22) {
			ViewIpDetails vip=new ViewIpDetails(); 
			vip.setSize(600,600);
			vip.setVisible(true);
		}
		
		
		if (e.getSource() == button2) {
			try {

				Vector heading = new Vector();

				heading.addElement("N-15");
				heading.addElement("N-16");
				heading.addElement("N-17");
				heading.addElement("N-18");
				heading.addElement("N-19");
				heading.addElement("N-20");

				Vector data = new Vector();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect = DriverManager
						.getConnection("jdbc:odbc:Cluster");
				Statement stmt = connect.createStatement();

				String query = "SELECT * FROM Cluster3";
				ResultSet rs = stmt.executeQuery(query);

				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();

				while (rs.next()) {
					Vector row = new Vector();
					for (int i = 1; i <= col; i++) {
						row.addElement(rs.getObject(i));

					}

					data.addElement(row);
				}

				JTable table = new JTable(data, heading);

				JScrollPane pane = new JScrollPane(table);

				pane.setBounds(30, 500, 300, 150);
				c.add(pane);
				// c.add(image);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
