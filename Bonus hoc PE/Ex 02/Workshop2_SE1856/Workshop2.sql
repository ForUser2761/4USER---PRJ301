USE [master]
GO
Create database WORKSHOP2
GO
USE WORKSHOP2
GO
CREATE TABLE [dbo].[Major](
	[MajorID] [varchar](10) NOT NULL primary key,
	[MajorName] [nvarchar](max) NOT NULL,
)
GO
insert into [Major] values('SE','Sofware Engineering')
insert into [Major] values('BA','Business Administration')
insert into [Major] values('IA','Imformation Assurance')
insert into [Major] values('MC','Multimedia Communications')

GO
CREATE TABLE [dbo].[Students](
	[StudentID] [nvarchar](10) NOT NULL primary key,
	[StudentName] [nvarchar](30) NOT NULL,
	[BirthDate] datetime not NULL,
	[Gender] [bit] NULL,
	[MajorID] [varchar](10) NULL references [Major](MajorID)
)
GO
insert into [Students] values('HE05001','Dao Thanh Hung',CAST(N'2001-04-04' AS Date),1,'SE')
insert into [Students] values('HE05002','Tran Hung Dung',CAST(N'2003-03-04' AS Date),1,'SE')
insert into [Students] values('BA05003','Le Khanh Van',CAST(N'2001-05-04' AS Date),0,'BA')
insert into [Students] values('IA05008','Tran Hung Son',CAST(N'2001-10-02' AS Date),1,'IA')
insert into [Students] values('MC05009','Le Khanh Ha',CAST(N'1999-02-04' AS Date),0,'MC')
insert into [Students] values('BA05031','Ha Hung Dung',CAST(N'2001-03-01' AS Date),1,'BA')
insert into [Students] values('IA05201','Tran Hung Cuong',CAST(N'2001-11-06' AS Date),1,'IA')
insert into [Students] values('HE05102','Le Khanh Van',CAST(N'1999-01-05' AS Date),0,'SE')
insert into [Students] values('MC05603','Nguyen Phu Dat',CAST(N'2003-04-04' AS Date),1,'MC')

GO

