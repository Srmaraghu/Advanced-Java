    import javax.swing.*;
    import java.sql.*;
    import javax.swing.table.DefaultTableModel;

    import utility.DBConnection;

    public class ViewLibrarians {

        // Frame and Table
        JFrame f;
        JTable j;

        // Constructor
        public ViewLibrarians() {
            // Frame initialization
            f = new JFrame("View Librarians");

            // Data and Column Names
            String[] columnNames = { "ID", "Name", "Email", "City", "Contact" };

            // Create the table model with column names and an empty data array
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // Initializing the JTable with the model
            j = new JTable(tableModel);

            // Adding JTable to JScrollPane
            JScrollPane sp = new JScrollPane(j);
            f.add(sp);

            // Fetch and load librarian data from the database
            loadLibrariansData(tableModel);

            // Frame settings
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setSize(700, 500);
            f.setLocation(310, 70);

            f.setVisible(true);
        }

        // Method to fetch librarian data from the database and populate the table
        private void loadLibrariansData(DefaultTableModel tableModel) {
            

            try (Connection conn = DBConnection.getConnection()) {
                String sql = "SELECT * FROM librarian";  // Query to get all librarians
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                // Clear existing data from the table
                tableModel.setRowCount(0);

                // Populate the table with fetched data
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String city = rs.getString("city");
                    String contact = rs.getString("contact");

                    // Add a row to the table
                    tableModel.addRow(new Object[]{id, name, email, city, contact});
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Driver method
        public static void main(String[] args) {
            new ViewLibrarians();
        }
    }
