/* =========================================================
   1) CREATE DATABASE
   ========================================================= */
IF DB_ID('StudentDB2') IS NULL
BEGIN
    CREATE DATABASE StudentDB2;
END
GO

USE StudentDB2;
GO

/* =========================================================
   2) TABLE: Users
   ========================================================= */
IF OBJECT_ID('dbo.Users', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Users (
        Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
        Username NVARCHAR(50) NOT NULL UNIQUE,
        PasswordHash NVARCHAR(200) NOT NULL,  -- bcrypt hash
        Role NVARCHAR(20) NULL
    );
END
GO

/* =========================================================
   3) TABLE: Students
   ========================================================= */
IF OBJECT_ID('dbo.Students', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Students (
        Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
        Name NVARCHAR(100) NOT NULL,
        Course NVARCHAR(100) NOT NULL,
        Fee DECIMAL(18,2) NOT NULL,
        PhotoPath NVARCHAR(300) NULL,
        CreatedAt DATETIME2 NOT NULL CONSTRAINT DF_Students_CreatedAt DEFAULT SYSDATETIME()
    );
END
GO

/* =========================================================
   4) OPTIONAL: indexes (helps speed when list grows)
   ========================================================= */
IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'IX_Students_Name' AND object_id = OBJECT_ID('dbo.Students'))
    CREATE INDEX IX_Students_Name ON dbo.Students(Name);
GO

IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'IX_Students_Course' AND object_id = OBJECT_ID('dbo.Students'))
    CREATE INDEX IX_Students_Course ON dbo.Students(Course);
GO

/* =========================================================
   5) DEFAULT ADMIN USER (avoid duplicate insert error)
   username: admin
   password: Admin@123  (bcrypt hash already provided by your project)
   ========================================================= */
IF NOT EXISTS (SELECT 1 FROM dbo.Users WHERE Username = 'admin')
BEGIN
    INSERT INTO dbo.Users(Username, PasswordHash, Role)
    VALUES (
        'admin',
        '$2a$10$kSrwS8GzS5eC2rESdczf9u4oBErzY8MZbqHnXg9zO1p6Z3v6R0S4q',
        'ADMIN'
    );
END
GO
   INSERT INTO dbo.Users (Username, PasswordHash, Role)
VALUES (
    'JEREMIE',
    '$2a$10$9dE4yZkFzRr4WJvF7b4lXu4v6MZzKX6gQFJ9U0n3dG1o3n7y9mQ5e',
    'ADMIN'
);


SELECT * FROM Users;

