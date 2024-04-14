﻿USE master
GO
CREATE DATABASE PTPM_FINALLY_JAVA_SOF3011
GO 
USE [PTPM_FINALLY_JAVA_SOF3011]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgaySinh] [date] NULL,
	[SoThich] [nvarchar](30) NULL,
	[GioiTinh] [int] NULL,
	[IdMQH] [int] NULL,
	[TrangThai] [int] NULL,
)
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
)
GO
CREATE TABLE [dbo].[LoaiSP](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
)
GO
CREATE TABLE [dbo].[LoaiXM](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
)
GO
CREATE TABLE [dbo].[MoiQuanHe](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
)
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Sdt] [varchar](30) NULL,
	[MatKhau] [varchar](50) NULL,
	[IdCV] [int] NULL,
	[TrangThai] [int] NULL,
)
GO
CREATE TABLE [dbo].[NXB](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
)
GO
CREATE TABLE [dbo].[Sach](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayXuatBan] [date] NULL,
	[SoTrang] [int] NULL,
	[DonGia] [decimal](20, 0) NULL,
	[IdNXB] [int] NULL,
	[TrangThai] [int] NULL,
)
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgaySX] [date] NULL,
	[Mota] [nvarchar](30) NULL,
	[Website] [nvarchar](30) NULL,
	[GiaBan] [decimal](20, 0) NULL,
	[SoLuong] [int] NULL,
	[IdLoaiSP] [int] NULL,
	[TrangThai] [int] NULL,
)
GO
CREATE TABLE [dbo].[XeMay](
	[Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgaySX] [date] NULL,
	[Mota] [nvarchar](30) NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
	[SoLuong] [int] NULL,
	[Website] [nvarchar](30) NULL,
	[IdLXM] [int] NULL,
	[TrangThai] [int] NULL,
)
GO
SET IDENTITY_INSERT [dbo].[Ban] ON 

INSERT [dbo].[Ban] ([Id], [Ma], [Ten], [NgaySinh], [SoThich], [GioiTinh], [IdMQH], [TrangThai]) VALUES (1, N'B001', N'Nguyễn Văn A', CAST(N'2004-04-28' AS Date), N'Ăn', 1, 1, 1)
INSERT [dbo].[Ban] ([Id], [Ma], [Ten], [NgaySinh], [SoThich], [GioiTinh], [IdMQH], [TrangThai]) VALUES (2, N'B002', N'Nguyễn Thị C', CAST(N'2005-11-21' AS Date), N'Ngủ', 0, 2, 1)
INSERT [dbo].[Ban] ([Id], [Ma], [Ten], [NgaySinh], [SoThich], [GioiTinh], [IdMQH], [TrangThai]) VALUES (3, N'B003', N'Phạm Văn B', CAST(N'2002-12-25' AS Date), N'Lăn', 1, 3, 1)
INSERT [dbo].[Ban] ([Id], [Ma], [Ten], [NgaySinh], [SoThich], [GioiTinh], [IdMQH], [TrangThai]) VALUES (4, N'B004', N'Trần Quang D', CAST(N'2004-07-12' AS Date), N'Xem Phim', 1, 2, 1)
INSERT [dbo].[Ban] ([Id], [Ma], [Ten], [NgaySinh], [SoThich], [GioiTinh], [IdMQH], [TrangThai]) VALUES (5, N'B005', N'Nguyễn Diệu L', CAST(N'2002-09-21' AS Date), N'Ngủ', 0, 1, 1)
SET IDENTITY_INSERT [dbo].[Ban] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiSP] ON 

INSERT [dbo].[LoaiSP] ([Id], [Ma], [Ten]) VALUES (1, N'LSP001', N'Đồ Dùng Trong Nhà')
INSERT [dbo].[LoaiSP] ([Id], [Ma], [Ten]) VALUES (2, N'LSP002', N'Đồ Dùng Học Tập')
INSERT [dbo].[LoaiSP] ([Id], [Ma], [Ten]) VALUES (3, N'LSP003', N'Đồ Chơi Trẻ Em')
SET IDENTITY_INSERT [dbo].[LoaiSP] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiXM] ON 

INSERT [dbo].[LoaiXM] ([Id], [Ma], [Ten]) VALUES (1, N'LXM001', N'Xe Ga')
INSERT [dbo].[LoaiXM] ([Id], [Ma], [Ten]) VALUES (2, N'LXM002', N'Xe Số')
INSERT [dbo].[LoaiXM] ([Id], [Ma], [Ten]) VALUES (3, N'LXL003', N'Xe Điện')
SET IDENTITY_INSERT [dbo].[LoaiXM] OFF
GO
SET IDENTITY_INSERT [dbo].[MoiQuanHe] ON 

INSERT [dbo].[MoiQuanHe] ([Id], [Ma], [Ten]) VALUES (1, N'MQH001', N'Độc Thân')
INSERT [dbo].[MoiQuanHe] ([Id], [Ma], [Ten]) VALUES (2, N'MQH002', N'Có Người Yêu')
INSERT [dbo].[MoiQuanHe] ([Id], [Ma], [Ten]) VALUES (3, N'MQH003', N'Mập Mờ')
SET IDENTITY_INSERT [dbo].[MoiQuanHe] OFF
GO
SET IDENTITY_INSERT [dbo].[NXB] ON 

INSERT [dbo].[NXB] ([Id], [Ma], [Ten]) VALUES (1, N'N001', N'Nguyễn Văn Anh')
INSERT [dbo].[NXB] ([Id], [Ma], [Ten]) VALUES (2, N'N002', N'Trần Thị Ngọc')
INSERT [dbo].[NXB] ([Id], [Ma], [Ten]) VALUES (3, N'N003', N'Phạm Văn Đồng')
SET IDENTITY_INSERT [dbo].[NXB] OFF
GO
SET IDENTITY_INSERT [dbo].[Sach] ON 

INSERT [dbo].[Sach] ([Id], [Ma], [Ten], [NgayXuatBan], [SoTrang], [DonGia], [IdNXB], [TrangThai]) VALUES (1, N'S001', N'Tại Sao Không Có Em', CAST(N'2023-04-21' AS Date), 100, CAST(100000 AS Decimal(20, 0)), 1, 1)
INSERT [dbo].[Sach] ([Id], [Ma], [Ten], [NgayXuatBan], [SoTrang], [DonGia], [IdNXB], [TrangThai]) VALUES (2, N'S002', N'Yêu Từ Đâu Mà Ra', CAST(N'2022-11-11' AS Date), 200, CAST(200000 AS Decimal(20, 0)), 2, 1)
INSERT [dbo].[Sach] ([Id], [Ma], [Ten], [NgayXuatBan], [SoTrang], [DonGia], [IdNXB], [TrangThai]) VALUES (3, N'S003', N'Tìm Lại Chính Mình', CAST(N'2019-02-21' AS Date), 150, CAST(150000 AS Decimal(20, 0)), 2, 1)
INSERT [dbo].[Sach] ([Id], [Ma], [Ten], [NgayXuatBan], [SoTrang], [DonGia], [IdNXB], [TrangThai]) VALUES (4, N'S004', N'Vì Sao', CAST(N'2022-05-19' AS Date), 320, CAST(200000 AS Decimal(20, 0)), 1, 1)
INSERT [dbo].[Sach] ([Id], [Ma], [Ten], [NgayXuatBan], [SoTrang], [DonGia], [IdNXB], [TrangThai]) VALUES (5, N'S005', N'Tư Duy Nhanh Và Chậm', CAST(N'2024-03-11' AS Date), 400, CAST(300000 AS Decimal(20, 0)), 3, 1)
SET IDENTITY_INSERT [dbo].[Sach] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [NgaySX], [Mota], [Website], [GiaBan], [SoLuong], [IdLoaiSP], [TrangThai]) VALUES (6, N'SP001', N'Chổi', CAST(N'2023-02-19' AS Date), N'Loại tốt', N'shopee.vn', CAST(200000 AS Decimal(20, 0)), 1000, 1, 1)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [NgaySX], [Mota], [Website], [GiaBan], [SoLuong], [IdLoaiSP], [TrangThai]) VALUES (7, N'SP002', N'Quyển Vở', CAST(N'2023-03-12' AS Date), N'Loại tốt', N'shopee.vn', CAST(10000 AS Decimal(20, 0)), 10000, 2, 1)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [NgaySX], [Mota], [Website], [GiaBan], [SoLuong], [IdLoaiSP], [TrangThai]) VALUES (8, N'SP003', N'Bút Bi', CAST(N'2023-03-12' AS Date), N'Loại tốt', N'shopee.vn', CAST(5000 AS Decimal(20, 0)), 10000, 2, 1)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [NgaySX], [Mota], [Website], [GiaBan], [SoLuong], [IdLoaiSP], [TrangThai]) VALUES (9, N'SP004', N'Oto Điều Khiển Từ Xa', CAST(N'2023-05-12' AS Date), N'Loại tốt', N'shopee.vn', CAST(200000 AS Decimal(20, 0)), 200000, 3, 1)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [NgaySX], [Mota], [Website], [GiaBan], [SoLuong], [IdLoaiSP], [TrangThai]) VALUES (10, N'SP005', N'Mô Hình Oto', CAST(N'2024-01-12' AS Date), N'Loại tốt', N'shopee.vn', CAST(300000 AS Decimal(20, 0)), 100000, 3, 1)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[XeMay] ON 

INSERT [dbo].[XeMay] ([Id], [Ma], [Ten], [NgaySX], [Mota], [GiaNhap], [GiaBan], [SoLuong], [Website], [IdLXM], [TrangThai]) VALUES (1, N'XM001', N'SH350i', CAST(N'2022-02-12' AS Date), N'Loại tốt', CAST(100000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), 10, N'shopee.vn', 1, 1)
INSERT [dbo].[XeMay] ([Id], [Ma], [Ten], [NgaySX], [Mota], [GiaNhap], [GiaBan], [SoLuong], [Website], [IdLXM], [TrangThai]) VALUES (2, N'XM002', N'Vision', CAST(N'2022-03-21' AS Date), N'Loại tốt', CAST(200000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), 20, N'shopee.vn', 1, 1)
INSERT [dbo].[XeMay] ([Id], [Ma], [Ten], [NgaySX], [Mota], [GiaNhap], [GiaBan], [SoLuong], [Website], [IdLXM], [TrangThai]) VALUES (3, N'XM003', N'Wave Anpha 110', CAST(N'2021-02-19' AS Date), N'Loại tốt', CAST(300000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), 20, N'shopee.vn', 2, 1)
INSERT [dbo].[XeMay] ([Id], [Ma], [Ten], [NgaySX], [Mota], [GiaNhap], [GiaBan], [SoLuong], [Website], [IdLXM], [TrangThai]) VALUES (4, N'XM004', N'VinFast Klara', CAST(N'2022-03-22' AS Date), N'Loại tốt', CAST(400000 AS Decimal(20, 0)), CAST(500000 AS Decimal(20, 0)), 30, N'shopee.vn', 3, 1)
INSERT [dbo].[XeMay] ([Id], [Ma], [Ten], [NgaySX], [Mota], [GiaNhap], [GiaBan], [SoLuong], [Website], [IdLXM], [TrangThai]) VALUES (5, N'XM005', N'Pega eSH', CAST(N'2023-02-12' AS Date), N'Loại tốt', CAST(200000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), 12, N'shopee.vn', 3, 1)
SET IDENTITY_INSERT [dbo].[XeMay] OFF
GO

INSERT INTO NhanVien(Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCV, TrangThai)
VALUES
('NV01', 'Thu', N'Hoài', N'Nguyễn', N'Nữ', '10/22/2004', N'Hà Nội 1', '0388082344', 'mdo@', 1, 1),
('NV02', 'Nhung', N'Hồng', N'Nguyễn', N'Nữ', '06/07/2010', N'Hà Nội 2', '0376558965', '1abc@', 2, 2),
('NV03', 'Tám', N'Văn', N'Nguyễn', N'Nam', '11/12/2004', N'Hà Nội 3', '0911067746', 'abc@', 1, 1),
('NV04', 'Hường', N'Thị', N'Nguyễn', N'Nữ', '09/02/2004', N'Hà Nội 4', '0979974163', '123@', 2, 2)
PTPM_FINALLY_JAVA_SOF3011.sql
Displaying PTPM_FINALLY_JAVA_SOF3011.sql.