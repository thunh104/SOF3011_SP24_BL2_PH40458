CREATE DATABASE Buoi12;
GO
USE Buoi12;
GO
CREATE TABLE sinh_vien (
	id int IDENTITY PRIMARY KEY NOT NULL,
	ma VARCHAR(100),
	ten VARCHAR(100) NULL,
	tuoi BIGINT NULL,
	dia_chi VARCHAR(100) NULL,
	gioi_tinh BIT NULL,
	lop_id int NULL,
)
GO
CREATE TABLE lop (
	id int IDENTITY PRIMARY KEY NOT NULL,
	ma VARCHAR(100),
	ten VARCHAR(100) NULL,
)

INSERT INTO lop(ma, ten) VALUES 
('SD18316', 'Lap trinh Java 4'),
('SD18322', 'Kiem thu nang cao')

INSERT INTO sinh_vien (ma, ten, tuoi, dia_chi, gioi_tinh, lop_id) VALUES
('PH01', 'Nguyen Hoai Thu', 19, 'Ha Noi 1', 0, 1),
('PH02', 'Hoang Thu Trang', 19, 'Ha Noi 2', 0, 2),
('PH03', 'Nguyen Hong Anh', 19, 'Ha Noi 3', 1, 3),
('PH04', 'Nguyen Hoang Anh', 19, 'Ha Noi 4', 1, 4)

DELETE FROM sinh_vien WHERE id = 6