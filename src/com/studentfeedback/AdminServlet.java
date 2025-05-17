package com.studentfeedback;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Variables to store averages
        double teaching = 0, content = 0, labs = 0, time = 0, doubt = 0;
        int count = 0;

        try {
            Class.forName("org.sqlite.JDBC");
            String dbPath = getServletContext().getRealPath("/database/feedback.db");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            // Use AVG aggregate function to simplify queries
            ps = conn.prepareStatement(
                "SELECT AVG(teaching_quality) AS avgTeaching, AVG(course_content) AS avgContent, " +
                "AVG(lab_facilities) AS avgLabs, AVG(time_management) AS avgTime, AVG(doubt_resolution) AS avgDoubt, COUNT(*) AS total " +
                "FROM feedback"
            );
            rs = ps.executeQuery();

            if (rs.next()) {
                teaching = rs.getDouble("avgTeaching");
                content = rs.getDouble("avgContent");
                labs = rs.getDouble("avgLabs");
                time = rs.getDouble("avgTime");
                doubt = rs.getDouble("avgDoubt");
                count = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching feedback data: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }

        // Pass averages and count as request attributes
        request.setAttribute("teaching", teaching);
        request.setAttribute("content", content);
        request.setAttribute("labs", labs);
        request.setAttribute("time", time);
        request.setAttribute("doubt", doubt);
        request.setAttribute("count", count);

        // Forward to admin.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }
}
