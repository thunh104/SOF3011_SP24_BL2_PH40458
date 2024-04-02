CREATE DATABASE demo_lab_01;
GO
USE demo_lab_01;
GO
CREATE TABLE nhan_vien (
	id int IDENTITY PRIMARY KEY NOT NULL,
	ma VARCHAR(100),
	ten VARCHAR(100) NULL,
	tuoi BIGINT NULL,
	dia_chi VARCHAR(100) NULL,
		 BIT NULL,
)
GO

INSERT INTO nhan_vien (ma, ten, tuoi, dia_chi, gioi_tinh) VALUES
('PH01', 'Nguyen Hoai Thu', 19, 'Ha Noi 1', 0),
('PH02', 'Hoang Thu Trang', 19, 'Ha Noi 2', 0),
('PH03', 'Nguyen Hong Anh', 19, 'Ha Noi 3', 1),
('PH04', 'Nguyen Hoang Anh', 19, 'Ha Noi 4', 1)