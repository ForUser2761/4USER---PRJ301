create database [lab2t]
go
USE [lab2t]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/17/2024 3:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nchar](50) NOT NULL,
	[password] [nchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 5/17/2024 3:39:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[SKU] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Price] [float] NOT NULL,
	[Description] [nvarchar](50) NOT NULL,
	[Quantity] [int] NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'khanh                                             ', N'12345                                             ')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'admin                                             ', N'000                                               ')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'khanh123                                          ', N'123                                               ')
GO
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK01', N'Java', 150000, N'Java Book', 45)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK010', N'EL', 100000, N'Fundamental Book', 12)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK011', N'EU', 150000, N'EU Book', 25)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK02', N'MVC2', 90000, N'MVC2 Book', 80)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK03', N'Tomcat', 180000, N'Tomcat Book', 70)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK04', N'C++', 75000, N'C++ Book', 15)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK05', N'Servlet', 60000, N'Servlet Book', 50)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK06', N'JavaBean', 50000, N'JavaBeansBook', 40)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK07', N'JSP', 30000, N'JSP Book', 30)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK08', N'JDBC', 30000, N'JDBC Book', 20)
INSERT [dbo].[Product] ([SKU], [Name], [Price], [Description], [Quantity]) VALUES (N'BOOK09', N'Scripting Elements', 250000, N'Scripting Elements', 10)
GO
