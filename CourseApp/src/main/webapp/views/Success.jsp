<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Details</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <style>
        .card {
            border: 2px solid #343a40; /* Dark border color */
            background-color: #f8f9fa; /* Light background color */
            margin-bottom: 20px;
        }

        .bg-clr {
            background-color: #f1faee;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-clr">
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

<%-- Success message --%>
<div class="container mt-5">
    <div class="alert alert-success text-center">
        <h4>Course Added Successfully!</h4>
        <a href="addcourse" class="btn btn-primary mt-3">Add Another Course</a>
        <a href="viewallcourses" class="btn btn-primary mt-3">View All Courses</a>
    </div>
</div>

<%-- Course Details Display --%>
<%-- Assuming course data is passed to this JSP --%>
<div class="container mt-5">
    <h2 class="mb-4 text-center font-weight-bold">Course Details</h2>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card border-dark bg-light text-dark">
                <div class="card-body">
                    <h5 class="card-title">${course.courseName}</h5>
                    <p class="card-text">
                        <strong>Course ID:</strong>
                        ${course.courseId}
                    </p>
                    <p class="card-text">
                        <strong>Course Name:</strong>
                        ${course.courseName}
                    </p>
                    <p class="card-text">
                        <strong>Duration:</strong>
                        ${course.duration} hours
                    </p>
                    <p class="card-text">
                        <strong>Teacher:</strong>
                        ${course.teacherName}
                    </p>
                    <p class="card-text">
                        <strong>Tech Stack:</strong>
                        <ul>
                            <c:forEach var="tech" items="${course.techStack}">
                                <li>${tech}</li>
                            </c:forEach>
                        </ul>
                    </p>
                </div>
                <div class="card-footer">
                    <!-- Optional footer content -->
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
