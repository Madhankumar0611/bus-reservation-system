public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bus_reservation";
        String username = "root";
        String password = ""; // your MySQL password
        return DriverManager.getConnection(url, username, password);
    }
}
