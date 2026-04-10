<%-- 
    Document   : edit
    Created on : Jan 29, 2026, 4:38:09 PM
    Author     : jerem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Student</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>

    <style>
        body { background:#f4f6fb; }
        .card { border:0; border-radius:16px; box-shadow:0 10px 30px rgba(0,0,0,.08); }
        .btn,.form-control { border-radius:10px; }
        .avatar-lg {
            width: 90px; height: 90px;
            border-radius: 50%;
            object-fit: cover;
            border: 3px solid #fff;
            box-shadow: 0 3px 12px rgba(0,0,0,.15);
        }
        .avatar-placeholder{
            width:90px; height:90px; border-radius:50%;
            display:flex; align-items:center; justify-content:center;
            background:#e9ecef; color:#6c757d; font-weight:700;
            border: 3px solid #fff;
        }
    </style>
</head>
<body>

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-6">

            <div class="card">
                <div class="card-body p-4">
                    <h4 class="mb-4 text-center">Edit Student</h4>

                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>

                    <!-- ✅ enctype obligatoire pour update photo -->
                    <form action="StudentServlet" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="update"/>
                        <input type="hidden" name="id" value="${student.id}"/>

                        <!-- Aperçu photo actuelle -->
                        <div class="d-flex align-items-center gap-3 mb-4">
                            <c:choose>
                                <c:when test="${not empty student.photo}">
                                    <img class="avatar-lg" src="uploads/${student.photo}" alt="photo">
                                </c:when>
                                <c:otherwise>
                                    <div class="avatar-placeholder">N/A</div>
                                </c:otherwise>
                            </c:choose>

                            <div>
                                <div class="fw-bold">${student.name}</div>
                                <div class="text-muted small">Current photo preview</div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Student Name</label>
                            <input type="text" name="name" value="${student.name}" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Course</label>
                            <input type="text" name="course" value="${student.course}" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fee</label>
                            <input type="number" name="fee" value="${student.fee}" class="form-control" step="0.01" required>
                        </div>

                        <!-- ✅ Nouvelle photo (facultatif) -->
                        <div class="mb-4">
                            <label class="form-label">Change Photo (optional)</label>
                            <input type="file" name="photo" class="form-control" accept="image/*">
                            <div class="form-text">If you don’t choose a file, keep the current photo.</div>
                        </div>

                        <div class="d-flex gap-2">
                            <button class="btn btn-primary w-100">Update</button>
                            <a href="StudentServlet?action=list" class="btn btn-outline-secondary w-100">Back</a>
                        </div>
                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

