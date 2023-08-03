CREATE TABLE GroupTBL (
  id INT NOT NULL Identity(1,1) primary key,
  groupname VARCHAR(50),
  description VARCHAR(100),
);

CREATE TABLE ContactTBL (
  id INT NOT NULL Identity(1,1) primary key,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  groupname INT foreign key references GroupTBL(id)  not null,
  phonenumber VARCHAR(20) NOT NULL,
);

Insert into GroupTBL ( groupname, description) values ('Family', 'Nhom gia dinh'), ('Colleague', 'Nhom dong nghiep'), ('Friend', 'Nhom ban be')
Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Tran',
    'Hoang',
    1,
    '0924151616'
)

Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Nguyen',
    'Phong',
    1,
    '0924112116'
)

Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Dinh',
    'Hoang Linh',
    2,
    '0924242616'
)

Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Phuong',
    'The Ngoc',
    3,
    '0924125116'
)

Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Luong',
    'Hong Dung',
    3,
    '0924262612'
)
Insert into ContactTBL (firstname, lastName, groupname, phonenumber) values 
(
    'Vu',
    'Dinh Cong',
    1,
    '0924112116'
)