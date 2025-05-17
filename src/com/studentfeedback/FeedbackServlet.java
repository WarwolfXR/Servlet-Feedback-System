package com.studentfeedback;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        int teaching = Integer.parseInt(request.getParameter("teaching"));
        int content = Integer.parseInt(request.getParameter("content"));
        int labs = Integer.parseInt(request.getParameter("labs"));
        int time = Integer.parseInt(request.getParameter("time"));
        int doubt = Integer.parseInt(request.getParameter("doubt"));
        String comments = request.getParameter("comments");

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO feedback (username, teaching_quality, course_content, lab_facilities, time_management, doubt_resolution, comments) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, username);
            ps.setInt(2, teaching);
            ps.setInt(3, content);
            ps.setInt(4, labs);
            ps.setInt(5, time);
            ps.setInt(6, doubt);
            ps.setString(7, comments);
            ps.executeUpdate();

            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error submitting feedback");
        }
    }
}
