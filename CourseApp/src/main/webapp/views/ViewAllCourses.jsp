<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container">
        <a class="navbar-brand fs-1 fw-medium" href="#">Course App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="viewallcourses">All Courses</a></li>
                <li class="nav-item"><a class="nav-link" href="https://www.linkedin.com/in/arnab2002/">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="mb-4 text-center font-weight-bold">All Courses</h2>
    <div class="row row-cols-2">
        <c:forEach var="course" items="${courses}">
            <div class="col mb-4">
                <div class="card border-dark bg-light text-dark">
                    <div class="card-body">
                        <h5 class="card-title">${course.courseName}</h5>
                        <p class="card-text"><strong>Course ID:</strong> ${course.courseId}</p>
                        <p class="card-text"><strong>Tech Stack:</strong>
                            <ul>
                                <c:forEach var="tech" items="${course.techStack}">
                                    <li>${tech}</li>
                                </c:forEach>
                            </ul>
                        </p>
                        <p class="card-text"><strong>Teacher:</strong> ${course.teacherName}</p>
                        <p class="card-text"><strong>Duration:</strong> ${course.duration} hours</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
