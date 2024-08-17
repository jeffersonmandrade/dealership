<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>App: Dealership</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link active" href="/">AppVenda</a></li>
<%--            <li class="nav-item"><a class="nav-link" href="/car/list">Cars</a></li>--%>
<%--            <li class="nav-item"><a class="nav-link" href="/motorcycle/list">Motorcycles</a></li>--%>
<%--            <li class="nav-item"><a class="nav-link" href="/dealership/list">Dealership</a></li>--%>
        </ul>
    </div>
</nav>

<div class="container mt-3">

    <span class="badge rounded-pill bg-primary">Cars:${howManyCars}</span>
    <span class="badge rounded-pill bg-secondary">Motorcycles:${howManyMotorcycles}</span>
    <span class="badge rounded-pill bg-success">Dealership:${howManyDealership}</span>

    <c:if test="${not empty listagem}">
        <h2>AppVenda</h2>
        <p>Gestão de vendas de produtos:</p>
        <table class="table">
            <thead class="table-dark">
            <tr>
                <th>${titulo}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${listagem}">
                <tr>
                    <td>${item}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
