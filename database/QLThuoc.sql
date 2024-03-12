CREATE DATABASE QLTHUOC
GO

use QLTHUOC
go

CREATE TABLE NhanVien (
    idNV NVARCHAR(10) NOT NULL PRIMARY KEY,
    hoTen NVARCHAR(255) NOT NULL,
    sdt NVARCHAR(10) NOT NULL,
    gioiTinh NVARCHAR(10) NOT NULL,
    namSinh INT NOT NULL,
    ngayVaoLam DATE NOT NULL,
);
go

INSERT INTO NhanVien (idNV, hoTen, sdt, gioiTinh, namSinh, ngayVaoLam)
VALUES
	('ADMIN', N'Admin', '0111111111', N'Nam', 2003, '2024-01-01'),
    ('LKD2SFSL1', N'Nguyễn Phan Anh Tuấn', '0906765871', N'Nam', 2003, '2024-02-12'),
    ('IU42JDKJ2', N'Vũ Nương', '0931265687', N'Nữ', 2003, '2024-02-15'),
    ('DKJFJO1K2', N'Chí Phèo', '0967566712', N'Nam', 2003, '2024-02-20');
go

CREATE TABLE VaiTro (
    idVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    ten NVARCHAR(255) NOT NULL,
);
go

INSERT INTO VaiTro (idVT, ten)
VALUES
	('admin', N'Admin'),
    ('nvql', N'Nhân viên Quản Lý'),
	('nvbh', N'Nhân viên Bán hàng'),
	('nvsp', N'Nhân viên Quản lý Sản phẩm')
go

CREATE TABLE TaiKhoan (
	idTK NVARCHAR(10) NOT NULL PRIMARY KEY,
    username NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    idNV NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(idNV),
	idVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES VaiTro(idVT),
);
go

INSERT INTO TaiKhoan (idTK, username, password, idNV, idVT)
VALUES
    ('ADMIN0000', 'admin', '$2a$10$iisIo5/CQMiRzPHi6v8s8eUQfdDU8kiL3jOcEioy1B2d/dCkIb5ES', 'ADMIN', 'admin')
go

CREATE TABLE KhachHang (
    idKH NVARCHAR(10) NOT NULL PRIMARY KEY,
    hoTen NVARCHAR(255) NOT NULL,
    sdt NVARCHAR(10) NOT NULL,
    gioiTinh NVARCHAR(10) NOT NULL,
	ngayThamGia DATE NOT NULL,
);
go

INSERT INTO KhachHang (idKH, hoTen, sdt, gioiTinh, ngayThamGia)
VALUES
    ('ASDASN131', N'Nguyễn Văn Hùng', '0906765871', N'Nam', '2024-02-15'),
	('12ZAS1SX1', N'Nguyễn Thị Lan', '0931265687', N'Nữ', '2024-02-15'),
	('SDF3F13DZ', N'Lê Đức Anh', '0967566712', N'Nam', '2024-02-15'),
	('ABCD12345', N'Trần Mai Hương', '0987654321', N'Nữ', '2024-02-15'),
	('XYZ98765Z', N'Phạm Xuân Phong', '0912345678', N'Nam', '2024-02-15'),
	('KLM45678X', N'Lê Thị Linh', '0956789012', N'Nữ', '2024-02-15'),
	('PQR23456V', N'Hồ Ngọc Minh', '0923456789', N'Nam', '2024-02-15'),
	('789ABCDEF', N'Võ Thị Hải Yến', '0945678901', N'Nữ', '2024-02-15'),
	('456ZYXWVQ', N'Phạm Thị Anh', '0978901234', N'Nữ', '2024-02-15'),
	('QWE78901S', N'Hoàng Hữu Đức', '0912345678', N'Nam', '2024-02-15');
go

CREATE TABLE DonViTinh (
    idDVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    ten NVARCHAR(255) NOT NULL,
);
go
INSERT INTO DonViTinh (idDVT, ten)
VALUES
	('CVBDF123T', N'Viên'),
	('CV123GERT', N'Chai'),
	('CVB123ERT', N'Hộp'),
	('123DFGERT', N'Vỉ');
go

CREATE TABLE XuatXu (
    idXX NVARCHAR(10) NOT NULL PRIMARY KEY,
    ten NVARCHAR(255) NOT NULL,
);
go
INSERT INTO XuatXu (idXX, ten)
VALUES
	('XCVSDF123', N'Việt Nam'),
	('XCVSDF122', N'Mỹ'),
	('XCVSDF124', N'Nhật Bản');
go

CREATE TABLE DanhMuc (
    idDM NVARCHAR(10) NOT NULL PRIMARY KEY,
    ten NVARCHAR(255) NOT NULL,
);
go
INSERT INTO DanhMuc (idDM, ten)
VALUES
	('ZXC311QWE', N'Hệ tim mạch & tạo máu'),
	('ZXC321QWE', N'Hệ tiêu hóa & gan mật'),
	('ZAQ321QWE', N'Thuốc giảm đau');
go


CREATE TABLE Thuoc (
    idThuoc NVARCHAR(10) NOT NULL PRIMARY KEY,
    tenThuoc NVARCHAR(255) NOT NULL,
    hinhAnh NVARCHAR(255) NOT NULL,
    thanhPhan NVARCHAR(255) NOT NULL,
	idDVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DonViTinh(idDVT),
	idDM NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DanhMuc(idDM),
	idXX NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES XuatXu(idXX),
	soLuongTon INT NOT NULL,
	giaNhap FLOAT NOT NULL,
	donGia FLOAT NOT NULL,
);
go
INSERT INTO Thuoc (idThuoc, tenThuoc, hinhAnh, thanhPhan, idDVT, idDM, idXX, soLuongTon, giaNhap, donGia)
VALUES 
	('THU123ZXC', 'Paracetamol Stada 500mg', '123', 'Paracetamol', 'CVB123ERT', 'ZAQ321QWE', 'XCVSDF123', 10, 40000, 50000);
go

CREATE TABLE PhieuDatHang (
    idPDH NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idKH NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES KhachHang(idKH),
    diaChi NVARCHAR(255) NOT NULL,
	phuongThucThanhToan NVARCHAR(50) NOT NULL,
	trangThai NVARCHAR(50) NOT NULL,
);
go

CREATE TABLE ChiTietPhieuDatHang (
	idPDH NVARCHAR(10) NOT NULL PRIMARY KEY,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	FOREIGN KEY(idPDH) REFERENCES PhieuDatHang(idPDH),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go

CREATE TABLE HoaDon (
    idHD NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idNV NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(idNV),
    idKH NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES KhachHang(idKH),
);
go

CREATE TABLE ChiTietHoaDon (
	idHD NVARCHAR(10) NOT NULL PRIMARY KEY,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	FOREIGN KEY(idHD) REFERENCES HoaDon(idHD),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go

CREATE TABLE NhaCungCap (
    idNCC NVARCHAR(10) NOT NULL PRIMARY KEY,
    tenNCC NVARCHAR(255) NOT NULL,
	sdt NVARCHAR(10) NOT NULL,
	diaChi NVARCHAR(255) NOT NULL,
);
go

INSERT INTO NhaCungCap (idNCC, tenNCC, sdt, diaChi)
VALUES
  ('N4M35KL1B', N'Công ty Dược phẩm Phano', '0243574133', N'286 P. Xã Đàn, Đống Đa, Hà Nội'),
  ('XCHUWE123', N'Công ty Dược phẩm Trung ương 2', N'0243825535', '138B Đội Cấn, Ba Đình, Hà Nội'),
  ('2B32N31B2', N'Công ty Dược phẩm VCP', '0285413833', N'780 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. Hồ Chí Minh');
go

CREATE TABLE PhieuThu (
    idPT NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idNV NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(idNV),
    idNCC NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhaCungCap(idNCC),
);
go

CREATE TABLE ChiTietPhieuThu (
	idPT NVARCHAR(10) NOT NULL PRIMARY KEY,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	FOREIGN KEY(idPT) REFERENCES PhieuThu(idPT),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go
