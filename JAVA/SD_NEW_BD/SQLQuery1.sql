CREATE DATABASE StudentDB2;


-- USERS (login)
CREATE TABLE Users (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(200) NOT NULL,  -- store bcrypt hash, not plain password
    Role NVARCHAR(20) NULL
);

-- STUDENTS
CREATE TABLE Students (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Course NVARCHAR(100) NOT NULL,
    Fee DECIMAL(18,2) NOT NULL,
    PhotoPath NVARCHAR(300) NULL,  -- ex: uploads/xxx.jpg
    CreatedAt DATETIME2 NOT NULL DEFAULT SYSDATETIME()
);

INSERT INTO Users(Username, PasswordHash, Role)
VALUES ('JEREMIE', '$2a$10$ZrJrhR6vtL0MIVUoZP..D.zFoF5/twKWzQc5Vzw4DZkDQq1HIIPP6', 'ADMIN');

select * from Users
