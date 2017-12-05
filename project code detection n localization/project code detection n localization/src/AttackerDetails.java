import java.awt.Color;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AttackerDetails {

	JFrame jf = new JFrame("Attcker Hits for Each cluster");
	Container c;
	JScrollPane pane;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	AttackerDetails() {

		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.lightGray);
		try {
			Vector heading = new Vector();

			heading.addElement("Cluster");
			heading.addElement("Number of hits");

			Vector data = new Vector();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect = DriverManager
					.getConnection("jdbc:odbc:Cluster");
			Statement stmt = connect.createStatement();

			// String count =
			// "SELECT  Cluster,   Count(Cluster) AS clusters FROM Attacker GROUP BY Cluster";
			String ex = "select  Cluster, count(*) from Attacker group by Cluster";
			// String query = "SELECT * From Attacker";
			ResultSet rs = stmt.executeQuery(ex);
			//
			// String hitrate =
			// "round((1 - (sum(  Count(Cluster)) / sum(  Count(Cluster)))) * 100,2) ";
			// Statement ss = connect.createStatement();
			// ss.executeQuery(hitrate);
			//

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
			table.setBackground(Color.cyan);
			pane = new JScrollPane(table);

			pane.setBounds(50, 50, 350, 200);
			c.add(pane);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		jf.setSize(450, 400);
		jf.setVisible(true);
		jf.setResizable(false);

	}

	public static void main(String[] args) {
		new AttackerDetails();
	}
}
