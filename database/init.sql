-- students table
CREATE TABLE students (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

-- feedback table
CREATE TABLE feedback (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    teaching_quality INTEGER,
    course_content INTEGER,
    lab_facilities INTEGER,
    time_management INTEGER,
    doubt_resolution INTEGER,
    comments TEXT
);

-- admin (optional - can be hardcoded)
CREATE TABLE admins (
    username TEXT PRIMARY KEY,
    password TEXT NOT NULL
);

-- Insert a default admin (if using DB-based login)
INSERT INTO admins (username, password) VALUES ('admin', 'admin123');
