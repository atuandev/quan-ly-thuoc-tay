CREATE DATABASE QLTHUOC
GO

use QLTHUOC
go

CREATE TABLE Users (
    userId NVARCHAR(50) PRIMARY KEY,
    password NVARCHAR(50),
	role NVARCHAR(10),
    hoTen NVARCHAR(50),
    sdt NVARCHAR(10),
    gmail NVARCHAR(50)
);

INSERT INTO Users (userId, password, role, hoTen, sdt, gmail)
VALUES
    ('admin', '123456', 'ADMIN', N'Admin', '1234567890', 'admin@gmail.com'),
    ('nv001', '123456', 'USER', N'Trần Thị Thanh', '0987654321', 'thanh@gmail.com'),
    ('nv002', '123456', 'USER', N'Lê Văn Cường', '0986543210', 'cuong@gmail.com')
