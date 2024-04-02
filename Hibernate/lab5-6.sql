USE [PTPM_JAVA_HangNT169_Lab_SOF3011]
GO
/****** Object:  Table [dbo].[dien_thoai]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dien_thoai](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[gia] [float] NULL,
	[bo_nho] [nvarchar](100) NULL,
	[mau_sac] [nvarchar](100) NULL,
	[hang] [nvarchar](100) NULL,
	[mieu_ta] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dong_vat]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dong_vat](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[tuoi] [int] NULL,
	[gioi_tinh] [bit] NULL,
	[khu_vuc_song] [nvarchar](100) NULL,
	[loai] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[giang_vien]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giang_vien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[tuoi] [int] NULL,
	[gioi_tinh] [bit] NULL,
	[dia_chi] [nvarchar](100) NULL,
	[bac] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lop_hoc]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lop_hoc](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[chuyen_nganh] [int] NULL,
	[so_luong_sv] [int] NULL,
	[toa] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[may_tinh]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[may_tinh](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[gia] [float] NULL,
	[bo_nho] [nvarchar](100) NULL,
	[mau_sac] [nvarchar](100) NULL,
	[hang] [nvarchar](100) NULL,
	[mieu_ta] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sach]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sach](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten_sach] [nvarchar](100) NULL,
	[ten_tac_gia] [nvarchar](100) NULL,
	[gia] [float] NULL,
	[so_trang] [int] NULL,
	[loai] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[san_pham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[gia] [float] NULL,
	[chat_lieu] [nvarchar](100) NULL,
	[mau_sac] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sinh_vien]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sinh_vien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[tuoi] [int] NULL,
	[gioi_tinh] [bit] NULL,
	[dia_chi] [nvarchar](100) NULL,
	[ky_hoc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tac_gia]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tac_gia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[tuoi] [int] NULL,
	[gioi_tinh] [bit] NULL,
	[loai_sach_viet] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thuc_vat]    Script Date: 29/03/2024 11:23:27 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thuc_vat](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](100) NULL,
	[ten] [nvarchar](100) NULL,
	[tuoi] [int] NULL,
	[gioi_tinh] [bit] NULL,
	[khu_vuc_song] [nvarchar](100) NULL,
	[loai] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[dien_thoai] ON 

INSERT [dbo].[dien_thoai] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (1, N'DT001', N'Iphone 6', 120000, N'120GB', N'Vàng', N'Apple', N'Tốt')
INSERT [dbo].[dien_thoai] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (2, N'DT002', N'Iphone 11', 100000, N'256GB', N'Trắng', N'Apple', N'Tốt')
INSERT [dbo].[dien_thoai] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (3, N'DT003', N'amsung Galaxy S21 Ultra', 100000, N'512GB', N'Trắng', N'Samsung', N'Không tốt')
INSERT [dbo].[dien_thoai] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (4, N'DT004', N'Samsung Galaxy A52', 250000, N'120GB', N'Đen', N'Samsung', N'Tốt')
INSERT [dbo].[dien_thoai] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (5, N'DT005', N'Xiaomi Mi 11', 320000, N'120GB', N'Vàng', N'Xiaomi', N'Tốt')
SET IDENTITY_INSERT [dbo].[dien_thoai] OFF
GO
SET IDENTITY_INSERT [dbo].[dong_vat] ON 

INSERT [dbo].[dong_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (1, N'DV001', N'Chim', 2, 1, N'Trên Trời', N'Bi?t Bay')
INSERT [dbo].[dong_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (2, N'DV002', N'Cá Sấu', 3, 0, N'Dưới Nước', N'Bò Sát')
INSERT [dbo].[dong_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (3, N'DV003', N'Mèo', 4, 1, N'Trên Cạn', N'Bò Sát')
INSERT [dbo].[dong_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (4, N'DV004', N'Chó', 5, 0, N'Trên Cạn', N'Bò Sát')
INSERT [dbo].[dong_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (5, N'DV005', N'Khỉ', 3, 1, N'Trên Cạn', N'Bò Sát')
SET IDENTITY_INSERT [dbo].[dong_vat] OFF
GO
SET IDENTITY_INSERT [dbo].[giang_vien] ON 

INSERT [dbo].[giang_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [bac]) VALUES (1, N'GV001', N'Nguyễn Văn Anh', 21, 1, N'Hà Nội', 1)
INSERT [dbo].[giang_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [bac]) VALUES (2, N'GV002', N'Nguyễn Thị Vân', 19, 0, N'Hà Nội', 2)
INSERT [dbo].[giang_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [bac]) VALUES (3, N'GV003', N'Nguyễn Văn Trường', 18, 1, N'Hà Nội', 2)
INSERT [dbo].[giang_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [bac]) VALUES (4, N'GV004', N'Trần Văn An', 19, 0, N'Hải Phòng', 1)
INSERT [dbo].[giang_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [bac]) VALUES (5, N'GV005', N'Phạm Thu Thảo', 22, 0, N'Nam Định', 3)
SET IDENTITY_INSERT [dbo].[giang_vien] OFF
GO
SET IDENTITY_INSERT [dbo].[lop_hoc] ON 

INSERT [dbo].[lop_hoc] ([id], [ma], [ten], [chuyen_nganh], [so_luong_sv], [toa]) VALUES (1, N'LH001', N'P309', 1, 39, N'P')
INSERT [dbo].[lop_hoc] ([id], [ma], [ten], [chuyen_nganh], [so_luong_sv], [toa]) VALUES (2, N'LH002', N'P303', 2, 40, N'P')
INSERT [dbo].[lop_hoc] ([id], [ma], [ten], [chuyen_nganh], [so_luong_sv], [toa]) VALUES (3, N'LH003', N'P204', 3, 41, N'P')
INSERT [dbo].[lop_hoc] ([id], [ma], [ten], [chuyen_nganh], [so_luong_sv], [toa]) VALUES (4, N'LH004', N'L101', 2, 42, N'L')
INSERT [dbo].[lop_hoc] ([id], [ma], [ten], [chuyen_nganh], [so_luong_sv], [toa]) VALUES (5, N'LH005', N'F401', 2, 43, N'F')
SET IDENTITY_INSERT [dbo].[lop_hoc] OFF
GO
SET IDENTITY_INSERT [dbo].[may_tinh] ON 

INSERT [dbo].[may_tinh] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (1, N'MT001', N'Dell XPS 13', 120000, N'120GB', N'Vàng', N'Dell', N'Tốt')
INSERT [dbo].[may_tinh] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (2, N'MT002', N'Dell Inspiron 15', 100000, N'256GB', N'Trắng', N'Dell', N'Tốt')
INSERT [dbo].[may_tinh] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (3, N'MT003', N'HP Spectre x360', 2100000, N'120GB', N'Trắng', N'HP', N'Tốt')
INSERT [dbo].[may_tinh] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (4, N'MT004', N'HP Envy 13', 100000, N'120GB', N'Đen', N'HP', N'Tốt')
INSERT [dbo].[may_tinh] ([id], [ma], [ten], [gia], [bo_nho], [mau_sac], [hang], [mieu_ta]) VALUES (5, N'MT005', N'Lenovo ThinkPad X1 Carbon', 200000, N'512GB', N'Đen', N'Lenovo', N'Tốt')
SET IDENTITY_INSERT [dbo].[may_tinh] OFF
GO
SET IDENTITY_INSERT [dbo].[sach] ON 

INSERT [dbo].[sach] ([id], [ma], [ten_sach], [ten_tac_gia], [gia], [so_trang], [loai]) VALUES (1, N'S001', N'Tôi Đi Tìm Tôi', N'Nguyễn Văn A', 120000, 400, N'Sách Tâm Lý')
INSERT [dbo].[sach] ([id], [ma], [ten_sach], [ten_tac_gia], [gia], [so_trang], [loai]) VALUES (2, N'S002', N'Tư Duy Nhanh Và Chậm', N' Nguyễn Thị Thảo', 210000, 320, N'Sách Tư Duy')
INSERT [dbo].[sach] ([id], [ma], [ten_sach], [ten_tac_gia], [gia], [so_trang], [loai]) VALUES (3, N'S003', N'Tôi Là Ai', N'Nguyễn Thị Thảo', 120000, 322, N'Sách Tâm Lý')
INSERT [dbo].[sach] ([id], [ma], [ten_sach], [ten_tac_gia], [gia], [so_trang], [loai]) VALUES (4, N'S004', N'Cha Giàu Cha Nghèo', N'Phạm Văn Bảo', 200000, 2000, N'Sách Tư Duy')
INSERT [dbo].[sach] ([id], [ma], [ten_sach], [ten_tac_gia], [gia], [so_trang], [loai]) VALUES (5, N'S005', N'Đi Ngủ Sớm', N'Nguyễn Thị Hường', 210000, 210, N'Sách Tâm Lý')
SET IDENTITY_INSERT [dbo].[sach] OFF
GO
SET IDENTITY_INSERT [dbo].[san_pham] ON 

INSERT [dbo].[san_pham] ([id], [ma], [ten], [gia], [chat_lieu], [mau_sac]) VALUES (1, N'SP001', N'Chổi', 12000, N'Nhựa', N'Vàng')
INSERT [dbo].[san_pham] ([id], [ma], [ten], [gia], [chat_lieu], [mau_sac]) VALUES (2, N'SP002', N'Ghế', 12200, N'Gỗ', N'Vàng')
INSERT [dbo].[san_pham] ([id], [ma], [ten], [gia], [chat_lieu], [mau_sac]) VALUES (3, N'SP003', N'Bút', 5000, N'Nhựa', N'Xanh')
INSERT [dbo].[san_pham] ([id], [ma], [ten], [gia], [chat_lieu], [mau_sac]) VALUES (4, N'SP004', N'Khăn Giấy', 12000, N'Giấy', N'Trắng')
INSERT [dbo].[san_pham] ([id], [ma], [ten], [gia], [chat_lieu], [mau_sac]) VALUES (5, N'SP005', N'Khăn Mặt', 12000, N'Vải', N'Trắng')
SET IDENTITY_INSERT [dbo].[san_pham] OFF
GO
SET IDENTITY_INSERT [dbo].[sinh_vien] ON 

INSERT [dbo].[sinh_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [ky_hoc]) VALUES (1, N'SV001', N'Nguyễn Văn A', 12, 1, N'Hà Nội', 1)
INSERT [dbo].[sinh_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [ky_hoc]) VALUES (2, N'SV002', N'Nguyễn Thị C', 21, 0, N'Nam Định', 2)
INSERT [dbo].[sinh_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [ky_hoc]) VALUES (3, N'SV003', N'Nguyễn Thanh T', 18, 1, N'Hà Nội', 3)
INSERT [dbo].[sinh_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [ky_hoc]) VALUES (4, N'SV004', N'Nguyễn Thu T', 17, 0, N'Nam Định', 4)
INSERT [dbo].[sinh_vien] ([id], [ma], [ten], [tuoi], [gioi_tinh], [dia_chi], [ky_hoc]) VALUES (5, N'DV005', N'Trần Công Quang', 20, 1, N'Hải Phòng', 5)
SET IDENTITY_INSERT [dbo].[sinh_vien] OFF
GO
SET IDENTITY_INSERT [dbo].[tac_gia] ON 

INSERT [dbo].[tac_gia] ([id], [ma], [ten], [tuoi], [gioi_tinh], [loai_sach_viet]) VALUES (1, N'TG001', N'Nguyễn Văn C', 12, 1, N'Tâm Lý')
INSERT [dbo].[tac_gia] ([id], [ma], [ten], [tuoi], [gioi_tinh], [loai_sach_viet]) VALUES (2, N'TG002', N'Nguyễn Văn A', 21, 0, N'Tâm Lý')
INSERT [dbo].[tac_gia] ([id], [ma], [ten], [tuoi], [gioi_tinh], [loai_sach_viet]) VALUES (3, N'TG003', N'Trần Thanh Thảo', 18, 0, N'Tội Phạm')
INSERT [dbo].[tac_gia] ([id], [ma], [ten], [tuoi], [gioi_tinh], [loai_sach_viet]) VALUES (4, N'TG004', N'Nguyễn Thanh A', 19, 1, N'Tội Phạm')
INSERT [dbo].[tac_gia] ([id], [ma], [ten], [tuoi], [gioi_tinh], [loai_sach_viet]) VALUES (5, N'TG005', N'Phạm Văn A', 19, 0, N'Tôi Phạm')
SET IDENTITY_INSERT [dbo].[tac_gia] OFF
GO
SET IDENTITY_INSERT [dbo].[thuc_vat] ON 

INSERT [dbo].[thuc_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (1, N'TV001', N'Hoa Hồng Anh', 21, 1, N'Dưới Nước', N'Hoa H?ng')
INSERT [dbo].[thuc_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (2, N'TV002', N'Hoa Hồng Pháp', 2, 0, N'Đồng Bằng', N'Hoa H?ng')
INSERT [dbo].[thuc_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (3, N'TV003', N'Cây Dừa', 1, 1, N'Đồng Bằng', N'Hoa H?ng')
INSERT [dbo].[thuc_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (4, N'TV004', N'Cây Dừa Hồng', 3, 1, N'Đồng Bằng', N'Cây D?a')
INSERT [dbo].[thuc_vat] ([id], [ma], [ten], [tuoi], [gioi_tinh], [khu_vuc_song], [loai]) VALUES (5, N'TV005', N'Măng Cụt Bò', 4, 0, N'Đồng Bằng', N'Cây Mang C?t ')
SET IDENTITY_INSERT [dbo].[thuc_vat] OFF
GO
SELECT * FROM san_pham
