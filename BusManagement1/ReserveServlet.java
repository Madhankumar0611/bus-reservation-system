@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int busId = Integer.parseInt(request.getParameter("bus_id"));
        int seatNumber = Integer.parseInt(request.getParameter("seat_number"));

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO reservations (user_id, bus_id, seat_number, reservation_date) VALUES (?, ?, ?, CURDATE())"
            );
            stmt.setInt(1, userId);
            stmt.setInt(2, busId);
            stmt.setInt(3, seatNumber);
            stmt.executeUpdate();
            response.getWriter().println("Reservation successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
