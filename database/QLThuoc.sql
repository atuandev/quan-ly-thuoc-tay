CREATE DATABASE QLTHUOC
GO

use QLTHUOC
go

CREATE TABLE NhanVien (
    id NVARCHAR(9) NOT NULL,
    hoTen NVARCHAR(50) NOT NULL,
    sdt NVARCHAR(10) NOT NULL,
    gioiTinh NVARCHAR(10) NOT NULL,
    namSinh INT NOT NULL,
    ngayVaoLam DATE NOT NULL,
	PRIMARY KEY (id),
);
go

INSERT INTO NhanVien (id, hoTen, sdt, gioiTinh, namSinh, ngayVaoLam)
VALUES
    ('LKD2SFSL1', N'Nguyễn Phan Anh Tuấn', '0906765871', 'Nam', 2003, '2024-02-12'),
    ('IU42JDKJ2', 'Tran Thi B', '0931265687', 'Nu', 2003, '2024-02-15'),
    ('DKJFJO1K2', 'Le Van C', '096756671', 'Nam', 2003, '2024-02-20');
go

CREATE TABLE KhachHang (
    id NVARCHAR(9) NOT NULL,
    hoTen NVARCHAR(50) NOT NULL,
    sdt NVARCHAR(10) NOT NULL,
    gioiTinh NVARCHAR(10) NOT NULL,
	PRIMARY KEY (id),
);
go

INSERT INTO KhachHang (id, hoTen, sdt, gioiTinh)
VALUES
    ('ASDASN131', N'Nguyễn Văn Hùng', '0906765871', 'Nam'),
	('12ZAS1SX1', N'Nguyễn Thị Lan', '0931265687', 'Nữ'),
	('SDF3F13DZ', N'Lê Đức Anh', '096756671', 'Nam'),
	('ABCD12345', N'Trần Mai Hương', '0987654321', 'Nữ'),
	('XYZ98765Z', N'Phạm Xuân Phong', '0912345678', 'Nam'),
	('KLM45678X', N'Lê Thị Linh', '0956789012', 'Nữ'),
	('PQR23456V', N'Hồ Ngọc Minh', '0923456789', 'Nam'),
	('789ABCDEF', N'Võ Thị Hải Yến', '0945678901', 'Nữ'),
	('456ZYXWVQ', N'Phạm Thị Anh', '0978901234', 'Nữ'),
	('QWE78901S', N'Hoàng Hữu Đức', '0912345678', 'Nam');
go
