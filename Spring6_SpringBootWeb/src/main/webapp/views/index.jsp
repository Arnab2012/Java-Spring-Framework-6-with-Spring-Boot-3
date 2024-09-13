<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="container">
                <%--
                <h2>Addition Form</h2>
                <form action="add">
                    <label for="number1">Enter first number:</label><br>
                    <input type="number" id="number1" name="number1" required><br>

                    <label for="number2">Enter second number:</label><br>
                    <input type="number" id="number2" name="number2" required><br>

                    <input type="submit" value="Submit">
                </form>
                --%>

                <h2>Student Registration</h2>
                <form action="addStudent">
                    <label for="sid">Enter Id:</label><br>
                    <input type="number" id="sid" name="sid" required><br>

                    <label for="sname">Enter Name:</label><br>
                    <input type="text" id="sname" name="sname" required><br>

                    <input type="submit" value="Submit">
                </form>
            </div>
    </body>
</html>
