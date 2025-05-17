<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Feedback Summary</title>
    <!-- Use CDN for Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- Use any online CSS or omit for now -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" />
</head>

<body>
    <h2>Feedback Overview</h2>

    <canvas id="feedbackChart" width="600" height="400"></canvas>

    <%
        // Retrieve attributes set by the AdminServlet
        Double teaching = (Double) request.getAttribute("teaching");
        Double content = (Double) request.getAttribute("content");
        Double labs = (Double) request.getAttribute("labs");
        Double time = (Double) request.getAttribute("time");
        Double doubt = (Double) request.getAttribute("doubt");
        Integer count = (Integer) request.getAttribute("count");

        if (count == null || count == 0) {
    %>
        <p>No feedback data available.</p>
    <%
        } else {
            // Fallback in case attributes are null (avoid NPE)
            teaching = (teaching == null) ? 0.0 : teaching;
            content = (content == null) ? 0.0 : content;
            labs = (labs == null) ? 0.0 : labs;
            time = (time == null) ? 0.0 : time;
            doubt = (doubt == null) ? 0.0 : doubt;
    %>
    <script>
        const ctx = document.getElementById('feedbackChart').getContext('2d');
        const chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Teaching Quality', 'Course Content', 'Lab Facilities', 'Time Management', 'Doubt Resolution'],
                datasets: [{
                    label: 'Average Rating (1-10)',
                    data: [<%= teaching %>, <%= content %>, <%= labs %>, <%= time %>, <%= doubt %>],
                    backgroundColor: 'rgba(0, 123, 255, 0.5)',
                    borderColor: 'rgba(0, 123, 255, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        max: 10
                    }
                }
            }
        });
    </script>
    <%
        }
    %>
</body>
</html>
