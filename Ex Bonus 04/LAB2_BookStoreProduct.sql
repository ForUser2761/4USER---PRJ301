USE [master]
GO
ALTER DATABASE [Lab02] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO
DROP DATABASE IF EXISTS [Lab02]
GO
CREATE DATABASE Lab02
go
Use Lab02
go

CREATE TABLE BookStore (
  SKU varchar(10) PRIMARY KEY,
  Name varchar(255),
  Price DECIMAL(10,2),
  Description varchar(255),
  Quantity INT
);
go

INSERT INTO BookStore (SKU, Name, Price, Description, Quantity)
VALUES ('BOOK01', 'Java', 150000.00, 'Java Book', 45),
       ('BOOK010', 'EL', 10000.00, 'Fundamental Book', 12),
       ('BOOK011', 'EU', 150000.00, 'EU Book', 25),
       ('BOOK02', 'MVC2', 90000.00, 'MVC2 Book', 80),
       ('BOOK03', 'Tomcat', 180000.00, 'Tomcat Book', 70),
       ('BOOK04', 'C++', 75000.00, 'C++ Book', 15),
       ('BOOK05', 'Servlet', 60000.00, 'Servlet Book', 50),
       ('BOOK06', 'JavaBean', 50000.00, 'JavaBeansBook', 40),
       ('BOOK07', 'JSP', 40000.00, 'JSP Book', 30),
       ('BOOK08', 'JDBC', 30000.00, 'JDBC Book', 20),
       ('BOOK09', 'Scripting Elements', 250000.00, 'Scripting Elements', 10);
go