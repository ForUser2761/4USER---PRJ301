use master
go
drop database if exists PRJ301_SE1873_WS2
go
create database PRJ301_SE1873_WS2
go
use PRJ301_SE1873_WS2
go

-- Create Instructors table
CREATE TABLE Instructors (
    InstructorID INT PRIMARY KEY,
    FirstName NVARCHAR(50),
    LastName NVARCHAR(50),
    Email NVARCHAR(100),
    Phone NVARCHAR(20),
	Gender char(1),
	BirthDate date
);

-- Create Courses table
CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName NVARCHAR(100),
    CreditHours INT,
    ManageByInstructorID INT,
    FOREIGN KEY (ManageByInstructorID) REFERENCES Instructors(InstructorID)
);

-- Inserting data into Instructors table
INSERT INTO Instructors (InstructorID, FirstName, LastName, Email, Phone, Gender, BirthDate)
VALUES (1, 'John', 'Smith', 'john.smith@example.com', '+1234567890','M','1983-04-20'),
       (2, 'Emily', 'Davis', 'emily.davis@example.com', '+1987654321','F','1980-04-14'),
       (3, 'Michael', 'Johnson', 'michael.johnson@example.com', '+1654321987','M','1975-09-12');

-- Inserting data into Courses table
INSERT INTO Courses (CourseID, CourseName, CreditHours, ManageByInstructorID)
VALUES (101, 'Introduction to SQL', 3, 1),   
       (102, 'Database Management Systems', 4, 2),  
       (103, 'Data Analysis with Python', 3, 3),  
	   (104, 'Web Development Fundamentals', 3, 1),
       (105, 'Machine Learning Basics', 4, 3),  
       (106, 'Software Engineering Principles', 3, 2);

	   

