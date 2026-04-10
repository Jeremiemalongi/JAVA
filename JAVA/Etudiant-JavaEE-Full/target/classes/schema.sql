-- Run in SSMS
CREATE DATABASE StudentDB;
GO
USE StudentDB;
GO

CREATE TABLE Users (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(200) NOT NULL,
    Role NVARCHAR(20) NULL
);

CREATE TABLE Students (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Course NVARCHAR(100) NOT NULL,
    Fee DECIMAL(18,2) NOT NULL,
    PhotoPath NVARCHAR(300) NULL,
    CreatedAt DATETIME2 NOT NULL DEFAULT SYSDATETIME()
);

-- Default user:
-- username: admin
-- password: Admin@123
INSERT INTO Users(Username, PasswordHash, Role)
VALUES ('admin', '$2a$10$kSrwS8GzS5eC2rESdczf9u4oBErzY8MZbqHnXg9zO1p6Z3v6R0S4q', 'ADMIN');
