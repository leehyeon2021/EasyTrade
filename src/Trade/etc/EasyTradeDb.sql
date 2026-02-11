DROP DATABASE IF EXISTS EasyTradeDb;
CREATE DATABASE EasyTradeDb;
USE EasyTradeDb;

CREATE TABLE product(
	pno int auto_increment,
    constraint primary key(pno),
    pname varchar(8),
    ppro varchar(20) not null,
    pdes varchar(100),
    ppri int not null,
    ppw varchar(50) not null,
    ppn char(13),
    pdate date,
    pout varchar(5)
);

INSERT INTO product VALUES
(1,'홍길동','금괴','훔친 거 아님. 싸게 내놓으니 필요한 사람 가져가셈.','1000','1234','010-0101-0101','2025-01-25','거래 완료'),
(2,'허난설헌','문진','그림 그리다 남았습니다. 새 거 싼 값에 내놉니다.','20000','1234','010-0101-0102','2025-11-16','판매 중'),
(3,'허균','붓','책 쓸 때 좋은 붓 팝니다. 깨끗하게 썼어요.','2500','1234','010-0101-0103','2026-12-25','판매 중');

select*from product;