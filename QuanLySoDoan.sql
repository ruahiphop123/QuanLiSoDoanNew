create database QuanLySoDoan
go
use QuanLySoDoan
create table DoanVien
(
	idDoanVien char(5),
	tenDoanVien nvarchar(30),
	maSinhVien varchar(13),
	doB	date,
	queQuan nvarchar(30),
	tenLop varchar(10),
	tenKhoa varchar(10),
	tienCanNop money,
	tienDaNop money,
	tinhTrangSoDoan nvarchar(10),
	constraint PK_DoanVien_iDDoanVien primary key (idDoanVien),
	constraint CK_DoanVien_tinhTrangSoDoan check (tinhTrangSoDoan in (N'Đã nộp',N'Chưa nộp'))
)
create table TaiKhoan
(
	idTaiKhoan char(5),
	hoTen nvarchar(30),
	username varchar(20),
	pass varchar(20),
	chucVu varchar(5),
	constraint PK_TaiKhoan_idTaiKhoan primary key (idTaiKhoan),
	constraint CK_TaiKhoan_ChucVu check (chucVu in ('User','Admin'))
)
insert into TaiKhoan 
values	('AD001',N'Đinh Văn Huy','huy','12345','Admin'),
		('AD002',N'Nguyễn Trí Đức','duc','12345','Admin'),
		('US001',N'Nguyễn A','tam','123','User'),
		('US002',N'Nguyễn B','lan','1234','User')

set dateformat dmy
insert into DoanVien
values ('DV001',N'Nguyễn Văn A','2050531200131','21-12-2000',N'Đà Nẵng', '20T1', 'KH01', 24000, 12000, N'Đã nộp'),
	   ('DV002',N'Nguyễn Văn B','2050531200151','11-02-2000',N'Đà Nẵng', '20T2', 'KH01', 24000, 0, N'Đã nộp'),
	   ('DV003',N'Nguyễn Văn C','1950531200123','04-10-1999',N'Đà Nẵng', '19T1', 'KH01', 24000, 24000, N'Chưa nộp'),
	   ('DV004',N'Nguyễn Văn D','1950531200131','05-11-1999',N'Đà Nẵng', '19T3', 'KH02', 24000, 24000, N'Đã nộp'),
	   ('DV005',N'Nguyễn Văn E','1950531200101','13-12-2000',N'Đà Nẵng', '19T1', 'KH02', 24000, 0, N'Chưa nộp'),
	   ('DV006',N'Nguyễn Trí A','2050531200101','23-10-2002',N'Đà Nẵng', '20T1', 'KH01', 24000, 12000, N'Chưa nộp'),
	   ('DV007',N'Đinh Văn A','2050531200101','15-05-2002',N'Đà Nẵng', '20T1', 'KH01', 24000, 24000, N'Đã nộp')

go
create or alter function FN_getidDoanVien
()
returns char(5)
as
begin
	declare @id char(5)
	select top 1  @id=idDoanVien
	from DoanVien
	order by idDoanVien desc
	declare @lastnumber int
	set @lastnumber=right(@id,3)+1
	declare @nextchar char(5)
	set @nextchar=CONCAT('DV', format (@lastnumber, 'D3'))
	return @nextchar
end
go
select dbo.FN_getidDoanVien()