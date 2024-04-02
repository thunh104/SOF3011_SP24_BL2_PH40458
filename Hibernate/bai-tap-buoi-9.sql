CREATE DATABASE BTVNBuoi9;

USE BTVNBuoi9;

CREATE TABLE giang_vien (
	id BIGINT IDENTITY NOT NULL,
	ma varchar(100) NULL,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	dia_chi varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (id)
)

CREATE TABLE tai_khoan (
	username varchar(100) NOT NULL,
	password varchar(100) NULL,
	CONSTRAINT tai_khoan_PK PRIMARY KEY (username)
)

INSERT INTO tai_khoan (username, password) VALUES ('HangNT169', '12345')
INSERT INTO giang_vien (ma, ten, tuoi, gioi_tinh, dia_chi) VALUES
('HangNT169', 'Nguyen Thuy Hang', 18, 1, 'Ha Noi 1'),
('NguyenVV4', 'Vu Van Nguyen', 19, 0, 'Ha Noi 2'),
('PhongTT35', 'Tran Tuan Phong', 20, 0, 'Ha Noi 3'),
('KhanhPG', 'Pham Gia Khanh', 21, 0, 'Ha Noi 4'),
('TienNH21', 'Nguyen Hoang Tien', 22, 0, 'Ha Noi 5')