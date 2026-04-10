<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Students</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body { background:#f5f6fb; }

        .sidebar{
            width:260px;
            position:fixed; top:0; bottom:0; left:0;
            background:linear-gradient(180deg,#3b2bbd,#2d229a);
            color:#fff; padding:20px;
        }
        .content{
            margin-left:260px;
            padding:25px;
        }
        .navItem{
            display:block;
            padding:12px 14px;
            border-radius:12px;
            color:#fff;
            text-decoration:none;
            margin-bottom:10px;
        }
        .navItem.active, .navItem:hover{
            background:rgba(255,255,255,.15);
        }
        .cardSoft{
            border-radius:18px;
            border:none;
            box-shadow:0 16px 28px rgba(0,0,0,.08);
        }
        .avatar{
            width:44px;height:44px;
            border-radius:50%;
            object-fit:cover;
        }
        .studentRow{
            display:flex;
            align-items:center;
            gap:12px;
        }
        .studentName{ font-weight:800; }
        .studentEmail{ font-size:13px; color:#6b7280; }
    </style>
</head>

<body>

<!-- SIDEBAR -->
<div class="sidebar">
    <h4 class="mb-4">🎓 JM Manager</h4>

    <a class="navItem active" href="student?action=list">👥 Étudiants</a>
    <a class="navItem" href="#">📚 Cours</a>

    <div class="mt-5">
        <div><b>${sessionScope.user}</b></div>
        <a class="btn btn-light btn-sm mt-3 w-100" href="logout">Déconnexion</a>
    </div>
</div>

<!-- CONTENT -->
<div class="content">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <div>
            <h2 class="mb-0">Étudiants</h2>
            <div class="text-muted">Gestion des étudiants</div>
        </div>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#studentModal">
            + Ajouter
        </button>
    </div>

    <!-- TABLE -->
    <div class="card cardSoft">
        <div class="card-body p-0">
            <table class="table mb-0 align-middle">
                <thead class="table-light">
                <tr>
                    <th class="ps-4">Étudiant</th>
                    <th>Filière</th>
                    <th>Frais</th>
                    <th class="text-end pe-4">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="s" items="${students}">
                    <tr>
                        <td class="ps-4">
                            <div class="studentRow">
                                <c:choose>
                                    <c:when test="${not empty s.photoPath}">
                                        <img src="${s.photoPath}" class="avatar"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img src="https://ui-avatars.com/api/?name=${s.name}&background=4f46e5&color=fff"
                                             class="avatar"/>
                                    </c:otherwise>
                                </c:choose>
                                <div>
                                    <div class="studentName">${s.name}</div>
                                    <div class="studentEmail">${s.email}</div>
                                </div>
                            </div>
                        </td>
                        <td>${s.course}</td>
                        <td>${s.fee}</td>
                        <td class="text-end pe-4">
                            <a class="btn btn-sm btn-outline-primary"
                               href="student?action=edit&id=${s.id}">Edit</a>
                            <a class="btn btn-sm btn-outline-danger"
                               href="student?action=delete&id=${s.id}"
                               onclick="return confirm('Supprimer cet étudiant ?');">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:if test="${empty students}">
                <div class="p-4 text-muted">Aucun étudiant.</div>
            </c:if>
        </div>
    </div>
</div>

<!-- MODAL ADD / EDIT -->
<div class="modal fade" id="studentModal" tabindex="-1">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <form action="student" method="post" enctype="multipart/form-data">
                <div class="modal-header">
                    <h5 class="modal-title">
                        <c:choose>
                            <c:when test="${not empty editStudent}">Modifier étudiant</c:when>
                            <c:otherwise>Ajouter étudiant</c:otherwise>
                        </c:choose>
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
                    <c:choose>
                        <c:when test="${not empty editStudent}">
                            <input type="hidden" name="action" value="update"/>
                            <input type="hidden" name="id" value="${editStudent.id}"/>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="action" value="add"/>
                        </c:otherwise>
                    </c:choose>

                    <div class="row g-3">
                        <div class="col-md-6">
                            <label class="form-label">Nom</label>
                            <input class="form-control" name="name" required value="${editStudent.name}">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Email</label>
                            <input class="form-control" type="email" name="email" required
                                   value="${editStudent.email}">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Filière</label>
                            <input class="form-control" name="course" required value="${editStudent.course}">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Frais</label>
                            <input class="form-control" name="fee" required value="${editStudent.fee}">
                        </div>

                        <div class="col-md-12">
                            <label class="form-label">Photo</label>
                            <input class="form-control" type="file" name="photo" accept="image/*">
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-light" data-bs-dismiss="modal">Annuler</button>
                    <button class="btn btn-primary" type="submit">Enregistrer</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<c:if test="${not empty editStudent}">
    <script>
        new bootstrap.Modal(document.getElementById('studentModal')).show();
    </script>
</c:if>

</body>
</html>
