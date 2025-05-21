# Servlet Feedback System

## Overview

The **Servlet Feedback System** is a web-based application for collecting and managing user feedback. Users can register, log in, submit feedback, and view submission statuses. Administrators can manage and view feedback submissions. This system is built using **Apache Tomcat 10.0.x** and **Jakarta EE 8+**, with servlet-based back-end functionality and JSP front-end pages.

## Features

- **User Registration**: Users can create accounts by providing necessary details.
- **Login System**: Registered users can log in to their accounts.
- **Feedback Submission**: Users can submit feedback about services or products.
- **Admin Panel**: Admins can view and manage feedback submitted by users.
- **Feedback Confirmation**: After submitting feedback, users are shown a success page.
- **Database**: SQLite is used to store feedback and user data.

## Technologies Used

- **Apache Tomcat 10.0.x**: Web server and servlet container to run the application.
- **Jakarta EE 8+**: Java EE specification, including Servlets and JSP for the web application.
- **JSP (JavaServer Pages)**: Used for rendering dynamic web pages.
- **SQLite**: Database used for storing user and feedback data.

## File Structure

The project has the following structure:

### Root Directory
- **admin.jsp**: Admin panel for managing and viewing feedback submissions.
- **feedback.jsp**: Form for submitting user feedback.
- **login.jsp**: User login page.
- **register.jsp**: User registration page.
- **success.jsp**: Confirmation page after feedback submission.
- **test.jsp**: Sample JSP page, possibly for testing purposes.
- **WEB-INF**: Contains configuration files and compiled Java classes.
- **database**: Contains the database file and initialization SQL script.
- **lib**: External libraries (JAR files) required by the application.
- **WebContent**: Contains static web content like CSS and JavaScript files.
- **src**: Java source code for the servlets and utility classes.

### Subdirectories

#### **/database**
- **feedback.db**: SQLite database containing feedback and user data.
- **init.sql**: SQL script to initialize the database schema.

#### **/lib**
- **jakarta.servlet-api-6.1.0.jar**: Jakarta Servlet API.
- **sqlite-jdbc-3.49.1.0.jar**: JDBC driver for SQLite.

#### **/src**
- **/com/studentfeedback**: Contains Java classes (servlets, utility classes) for handling application logic:
  - **AdminServlet.java**: Handles admin functionalities like viewing and managing feedback.
  - **FeedbackServlet.java**: Manages feedback submission and retrieval.
  - **RegisterServlet.java**: Handles user registration.
  - **LoginServlet.java**: Handles user login and session management.
  - **DBUtil.java**: Utility class for database connection and operations.

#### **/WebContent**
- **/css/styles.css**: CSS styles for the web pages.
- **/js/chart.min.js**: JavaScript library for rendering charts (likely used in the admin panel).

#### **/WEB-INF**
- **/classes**: Compiled Java classes for servlets and utility classes.
- **web.xml**: Web application configuration file for defining servlets, servlet mappings, and other configuration settings.

## Setup

### Prerequisites

- **Apache Tomcat 10.0.x**: To host the web application.
- **JDK 8+**: For compiling and running the Java servlets.
- **SQLite**: To store user and feedback data.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/WarwolfXR/Servlet-Feedback-System.git

2. **Deploy the project in Apache Tomcat:**
Copy the project files or WAR file into the `webapps` directory of Tomcat.

3. **Set up the database:**
- Import the `init.sql` script into your SQLite database to set up the required tables and structure.
- Make sure the `feedback.db` file is placed in the correct location and that the `DBUtil.java` class is properly configured with the correct database path.

4. **Build and start Tomcat:**
- Start Tomcat, and the application should be accessible in your browser.

5. **Access the application:**
- Navigate to `/login.jsp` to log in or `/register.jsp` to create a new user.
- Admin users can access `/admin.jsp` to manage and view feedback.

## Database Schema

- **users**: Stores user data (username, password, etc.).
- **feedback**: Stores user feedback, including the user's ID, feedback message, and submission timestamp.

## Usage

### For Users

1. **Register an Account**: Go to `/register.jsp` and fill in the registration form.
2. **Login**: Log in using `/login.jsp` after registering.
3. **Submit Feedback**: Once logged in, go to `/feedback.jsp` to submit feedback.
4. **Feedback Confirmation**: Upon successful feedback submission, the user will be redirected to `/success.jsp`.

### For Admins

1. **Login**: Admins can log in using the same `/login.jsp` page.
2. **View and Manage Feedback**: Admins can view all submitted feedback and manage it using `/admin.jsp`.

## Known Issues

- **Login Security**: The login system is basic and lacks advanced security measures, such as password hashing.
- **Feedback Management**: There are limited features for categorizing or filtering feedback in the admin panel.
