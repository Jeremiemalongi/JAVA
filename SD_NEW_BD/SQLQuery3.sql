USE master;
GO

IF NOT EXISTS (SELECT 1 FROM sys.sql_logins WHERE name = 'student_user')
BEGIN
    CREATE LOGIN student_user WITH PASSWORD = 'Student@12345!';
END
GO

USE StudentDB2;
GO

IF NOT EXISTS (SELECT 1 FROM sys.database_principals WHERE name = 'student_user')
BEGIN
    CREATE USER student_user FOR LOGIN student_user;
END
GO

-- Minimal rights for this app:
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Users TO student_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Students TO student_user;
GO
