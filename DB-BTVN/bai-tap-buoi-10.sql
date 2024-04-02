CREATE DATABASE BTVNBuoi7;

USE BTVNBuoi7;

CREATE TABLE giang_vien (
	id BIGINT IDENTITY NOT NULL,
	mssv varchar(100) NULL ,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	que_quan varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (id)
)	

INSERT INTO giang_vien
(mssv, ten, tuoi, gioi_tinh, que_quan)
VALUES('HangNT169', 'Nguyen Thuy Hang', 18, 1, 'Ha Noi');
INSERT INTO giang_vien
(mssv, ten, tuoi, gioi_tinh, que_quan)
VALUES('NganCT4', 'Chu Thi Ngan', 19, 1, 'Ha Noi');
INSERT INTO giang_vien
(mssv, ten, tuoi, gioi_tinh, que_quan)
VALUES('NguyenVV4', 'Vu Van Nguyen', 20, 0, 'Ha Noi');
INSERT INTO giang_vien
(mssv, ten, tuoi, gioi_tinh, que_quan)
VALUES('TienNH21', 'Nguyen Hoang Tien', 21, 0, 'Ha Noi');
INSERT INTO giang_vien
(mssv, ten, tuoi, gioi_tinh, que_quan)
VALUES('DungNA29', 'Nguyen Anh Dung', 22, 0, 'Ha Noi');
DELETE FROM giang_vien WHERE id = 10