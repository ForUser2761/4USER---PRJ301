USE [lab1_hcm]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/12/2024 9:56:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[txtUser] [nvarchar](50) NOT NULL,
	[txtPassword] [nchar](50) NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([txtUser], [txtPassword]) VALUES (N'admin', N'123                                               ')
GO
