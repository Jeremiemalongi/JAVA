<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap local -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>

    <style>
        body {
            background: #f4f6fb;
        }
        .title {
            font-weight: 800;
            letter-spacing: .4px;
        }
        .card {
            border: 0;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0,0,0,.08);
        }
        .form-control, .btn {
            border-radius: 10px;
        }
        .table thead th {
            background: #eef1ff;
        }
        .avatar {
            width: 45px;
            height: 45px;
            border-radius: 50%;
            object-fit: cover;
            border: 2px solid #fff;
            box-shadow: 0 3px 10px rgba(0,0,0,.12);
        }
        .avatar-placeholder {
            width: 45px;
            height: 45px;
            border-radius: 50%;
            background: #e9ecef;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 11px;
            color: #6c757d;
        }
    </style>
</head>

<body>

<div class="container py-4">

    <!-- TITLE -->
    <div class="text-center mb-4">
        <h2 class="title">Student Registration JSP CRUD</h2>
        <p class="text-muted mb-0">With Photo Upload</p>
    </div>

    <!-- ERROR MESSAGE -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <div class="row g-4">

        <!-- LEFT : FORM -->
        <div class="col-lg-4">
            <div class="card">
                <div class="card-body p-4">
                    <h5 class="mb-3">Add Student</h5>

                    <!-- IMPORTANT: enctype multipart -->
                    <form action="StudentServlet" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="insert"/>

                        <div class="mb-3">
                            <label class="form-label">Student Name</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Course</label>
                            <input type="text" name="course" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fee</label>
                            <input type="number" name="fee" class="form-control" step="0.01" required>
                        </div>

                        <!-- PHOTO -->
                        <div class="mb-3">
                            <label class="form-label">Photo</label>
                            <input type="file" name="photo" class="form-control" accept="image/*">
                            <div class="form-text">jpg, png, webp…</div>
                        </div>

                        <div class="d-flex gap-2">
                            <button class="btn btn-primary w-100">Submit</button>
                            <button type="reset" class="btn btn-outline-secondary w-100">Reset</button>
                        </div>
                    </form>

                    <div class="mt-3">
                        <a href="StudentServlet?action=list" class="btn btn-link p-0">Refresh list</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- RIGHT : TABLE -->
        <div class="col-lg-8">
            <div class="card">
                <div class="card-body p-4">

                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h5 class="mb-0">Students</h5>
                        <span class="badge bg-secondary">
                            Total :
                            <c:choose>
                                <c:when test="${not empty students}">
                                    ${students.size()}
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                        </span>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-hover align-middle">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Photo</th>
                                    <th>Name</th>
                                    <th>Course</th>
                                    <th>Fee</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty students}">
                                        <c:forEach var="s" items="${students}">
                                            <tr>
                                                <td>${s.id}</td>

                                                <!-- PHOTO DISPLAY -->
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${not empty s.photo}">
                                                            <img src="uploads/${s.photo}" class="avatar">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="avatar-placeholder">No Photo</div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>

                                                <td>${s.name}</td>
                                                <td>${s.course}</td>
                                                <td>
                                                    <fmt:formatNumber value="${s.fee}"
                                                                      type="number"
                                                                      minFractionDigits="0"
                                                                      maxFractionDigits="2"/>
                                                </td>

                                                <td>
                                                    <a href="StudentServlet?action=edit&id=${s.id}"
                                                       class="btn btn-sm btn-outline-primary">
                                                        Edit
                                                    </a>
                                                </td>

                                                <td>
                                                    <a href="StudentServlet?action=delete&id=${s.id}"
                                                       class="btn btn-sm btn-outline-danger"
                                                       onclick="return confirm('Delete this student?');">
                                                        Delete
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>

                                    <c:otherwise>
                                        <tr>
                                            <td colspan="7" class="text-center text-muted py-4">
                                                No data available
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>






