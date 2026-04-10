# Etudiant - Java EE FULL (Tomcat 9 + Java 8)

## Requirements
- Java 8
- Tomcat 9 (ex: 9.0.115)
- SQL Server running on localhost:1433

## 1) Create DB
Run: `src/main/resources/schema.sql`

## 2) Configure DB
Edit: `src/main/java/dao/DBUtil.java`
- USER (ex: sa)
- PASS (your password)

## 3) Run
In NetBeans:
- Open Project
- Clean and Build
- Run

## URLs
- Home: / (redirects to login)
- Login: /login.jsp
- Students (after login): /student?action=list

## Default login
admin / Admin@123

## Photos
Stored as files under deployed app folder: /uploads/
Database stores only PhotoPath like: uploads/xxxx.jpg
