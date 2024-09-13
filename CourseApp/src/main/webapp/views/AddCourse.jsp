<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" crossorigin="anonymous">
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

<div class="container mt-5">
    <h2 class="mb-4 text-center">Add New Course</h2>
    <form action="success" method="post">
        <div class="mb-3">
            <label for="courseId" class="form-label">Course ID</label>
            <input type="text" class="form-control" id="courseId" name="courseId" required>
        </div>
        <div class="mb-3">
            <label for="courseName" class="form-label">Course Name</label>
            <input type="text" class="form-control" id="courseName" name="courseName" required>
        </div>
        <div class="mb-3">
            <label for="techStack" class="form-label">Tech Stack (Comma Separated)</label>
            <input type="text" class="form-control" id="techStack" name="techStack" required>
        </div>
        <div class="mb-3">
            <label for="teacherName" class="form-label">Teacher Name</label>
            <input type="text" class="form-control" id="teacherName" name="teacherName" required>
        </div>
        <div class="mb-3">
            <label for="duration" class="form-label">Duration (in hours)</label>
            <input type="number" class="form-control" id="duration" name="duration" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Course</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
