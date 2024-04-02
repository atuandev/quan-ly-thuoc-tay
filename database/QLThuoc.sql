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
    ('ADMIN', 'admin', '$2a$10$iisIo5/CQMiRzPHi6v8s8eUQfdDU8kiL3jOcEioy1B2d/dCkIb5ES', 'ADMIN', 'admin')
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
	('CVB141ERT', N'Gói'),
	('CV1223ERT', N'Vỉ');
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
	('XCVSDF125', N'Pháp'),
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
    hinhAnh VARBINARY(MAX),
    thanhPhan NVARCHAR(255),
	idDVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DonViTinh(idDVT),
	idDM NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DanhMuc(idDM),
	idXX NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES XuatXu(idXX),
	soLuongTon INT NOT NULL,
	giaNhap FLOAT NOT NULL,
	donGia FLOAT NOT NULL,
	hanSuDung DATE NOT NULL,
);
go

select * from thuoc

INSERT INTO Thuoc(idThuoc, tenThuoc, hinhAnh, thanhPhan, idDVT, idDM, idXX, soLuongTon, giaNhap, donGia, hanSuDung)
VALUES
	('X12IFO4BZ', N'Hapacol 650 DHG', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\hapacol_650_extra_dhg.png', SINGLE_BLOB) as image), N'Paracetamol', 'CVB123ERT', 'ZAQ321QWE', 'XCVSDF123', 1021, 18000, 25000, '2026-02-15'),
	('XRZXFO4BZ', N'Bột pha hỗn dịch uống Smecta vị cam', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bot-pha-hon-dich-uong-smecta.jpg', SINGLE_BLOB) as image), N'Diosmectite', 'CVB141ERT', 'ZXC321QWE', 'XCVSDF125', 1021, 3000, 4000, '2026-05-21'),
	('XRBIFO4BZ', N'Siro C.C Life 100mg/5ml Foripharm', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\C.c-Life-100MgChai.jpg', SINGLE_BLOB) as image), N'Vitamin C', 'CV123GERT', 'ZXC321QWE', 'XCVSDF123', 1032, 23000, 30000, '2026-03-01'),
	('VFZCHLHIE', N'Panadol Extra đỏ', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\Panadol-Extra.png', SINGLE_BLOB) as image), N'Caffeine, Paracetamol', 'CVB123ERT', 'ZAQ321QWE', 'XCVSDF122', 1034, 150000, 250000, '2026-08-07'),
	('MJ9AB7J1I', N'Viên sủi Vitatrum C BRV', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\vitatrum-c-brv.png', SINGLE_BLOB) as image), N'Sỏi thận, Rối loạn chuyển hoá fructose, Bệnh Thalassemia, Tăng oxalat niệu, Rối loạn chuyển hoá oxalat', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF122', 1076, 15000, 24000, '2027-12-31'),
	('ESMJMM7T1', N'Bổ Gan Trường Phúc', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bo-gan-tuong-phu.jpg', SINGLE_BLOB) as image), N'Diệp hạ châu, Đảng Sâm, Bạch truật, Cam thảo, Phục Linh, Nhân trần, Trần bì', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1034, 70000, 95000, '2026-02-15'),
	('BV07519DS', N'Bài Thạch Trường Phúc', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bai-trang-truong-phuc.jpg', SINGLE_BLOB) as image), N'Xa tiền tử, Bạch mao căn, Sinh Địa, Ý Dĩ, Kim tiền thảo', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1076, 70000, 95000, '2026-02-10'),
	('798E63U16', N'Đại Tràng Trường Phúc', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\dai-trang-truong-phuc.jpg', SINGLE_BLOB) as image), N'Hoàng liên, Mộc hương, Bạch truật, Bạch thược, Ngũ bội tử, Hậu phác, Cam thảo, Xa tiền tử, Hoạt thạch', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1021, 80000, 105000, '2026-09-03'),
	('745KCI1KX', N'Ninh Tâm Vương Hồng Bàng', (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\ninh-tam-vuong-hong-bang.png', SINGLE_BLOB) as image), N'L-Carnitine, Taurine, Đan sâm, Khổ sâm bắc, Nattokinase, Hoàng đằng, Magie, Tá dược vừa đủ', 'CVB123ERT', 'ZXC311QWE', 'XCVSDF124', 1054, 120000, 180000, '2026-08-15');
go

CREATE TABLE PhieuDatHang (
    idPDH NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idKH NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES KhachHang(idKH),
	tongTien FLOAT NOT NULL,
    diaChi NVARCHAR(255) NOT NULL,
	phuongThucThanhToan NVARCHAR(50) NOT NULL,
	trangThai NVARCHAR(50) NOT NULL,
);
go

CREATE TABLE ChiTietPhieuDatHang (
	idPDH NVARCHAR(10) NOT NULL,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	CONSTRAINT idCTPDH PRIMARY KEY (idPDH,idThuoc),
	FOREIGN KEY(idPDH) REFERENCES PhieuDatHang(idPDH),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go

CREATE TABLE HoaDon (
    idHD NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idNV NVARCHAR(10) NOT NULL,
    idKH NVARCHAR(10) NOT NULL,
	tongTien FLOAT NOT NULL,
    FOREIGN KEY (idNV) REFERENCES NhanVien(idNV),
    FOREIGN KEY (idKH) REFERENCES KhachHang(idKH)
);
go
INSERT INTO HoaDon (idHD, thoiGian, idNV, idKH, tongTien)
VALUES
	('ASZS32JZX', '20240303 6:24:09 PM', 'DKJFJO1K2', N'12ZAS1SX1', 520000),
	('MNXS72JXA', '20240301 10:24:09 AM', 'IU42JDKJ2', N'ASDASN131', 465000);
go

CREATE TABLE ChiTietHoaDon (
	idHD NVARCHAR(10) NOT NULL,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	CONSTRAINT idCTHD PRIMARY KEY (idHD,idThuoc),
	FOREIGN KEY(idHD) REFERENCES HoaDon(idHD),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go
INSERT INTO ChiTietHoaDon(idHD, idThuoc, soLuong, donGia)
VALUES
	('ASZS32JZX', 'X12IFO4BZ', 3,120000),
	('ASZS32JZX', 'XRZXFO4BZ', 2, 80000),
	('MNXS72JXA', 'ESMJMM7T1', 2, 95000),
	('MNXS72JXA', 'VFZCHLHIE', 1, 250000),
	('MNXS72JXA', 'X12IFO4BZ', 1, 25000);
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
  ('XCZXWE123', N'Công ty Cổ phần Dược phẩm An Khang', '0283820618', N'282-284 Trần Hưng Đạo, Phường Nguyễn Cư Trinh, Quận 1, TP.HCM'),
  ('23HUSZ173', N'Công ty Cổ phần Dược phẩm Pharmacity', '0243825353', N'426 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, TP.HCM'),
  ('ZXHUWE12S', N'Hệ thống nhà thuốc ECO', '0283689339', N'336 Phan Văn Trị, Phường 11, Quận Bình Thạnh, TP.HCM'),
  ('N4M35KL1B', N'Công ty Dược phẩm Phano', '0243574133', N'286 P. Xã Đàn, Đống Đa, Hà Nội'),
  ('XCHUWE123', N'Công ty Dược phẩm Trung ương 2', '0243825535', '138B Đội Cấn, Ba Đình, Hà Nội'),
  ('2B32N31B2', N'Công ty Dược phẩm VCP', '0285413833', N'780 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. Hồ Chí Minh');
go

CREATE TABLE PhieuNhap (
    idPN NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    idNV NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(idNV),
    idNCC NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhaCungCap(idNCC),
	tongTien FLOAT NOT NULL,
);
go

CREATE TABLE ChiTietPhieuNhap (
	idPN NVARCHAR(10) NOT NULL,
    idThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	CONSTRAINT idCTPN PRIMARY KEY (idPN,idThuoc),
	FOREIGN KEY(idPN) REFERENCES PhieuNhap(idPN),
	FOREIGN KEY(idThuoc) REFERENCES Thuoc(idThuoc),
);
go