<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Student Registration - StudentManager</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body class="d-flex flex-column min-vh-100">
	<%@ include file="navbar.html"%>

	<!-- Main Content -->
	<main class=" container flex-grow-1 pt-5">
		<div class="container my-5">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card shadow-sm">
						<div class="card-header bg-primary text-white fw-bold">Student
							Registration</div>
						<div class="card-body">
							<form action="SignupController" method="post">
								<div class="mb-3">
									<label for="studentId" class="form-label">Student ID</label> <input
										type="text" id="studentId" name="studentId"
										class="form-control" placeholder="Enter Student ID" required />
								</div>
								<div class="mb-3">
									<label for="firstname" class="form-label">First Name</label> <input
										type="text" id="firstname" name="firstname"
										class="form-control" placeholder="Enter First Name" required />
								</div>
								<div class="mb-3">
									<label for="lastname" class="form-label">Last Name</label> <input
										type="text" id="name" name="lastname" class="form-control"
										placeholder="Enter Last Name" required />
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">Email Address</label> <input
										type="email" id="email" name="email" class="form-control"
										placeholder="Enter your Email" required />
								</div>
								<div class="mb-3">
									<label for="course" class="form-label">Course</label> <input
										type="text" id="course" name="course" class="form-control"
										placeholder="Enter Course" required />
								</div>
								<div class="mb-3">
									<label for="gender" class="form-label">Gender</label> <select
										id="gender" name="gender" class="form-select" required>
										<option value="" disabled selected>Select Gender</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
										<option value="other">Other</option>
									</select>
								</div>
								<div class="mb-3">
									<label for="password" class="form-label">Password</label> <input
										type="password" id="password" name="password"
										class="form-control" placeholder="Enter Password" required />
								</div>
								<button type="submit" class="btn btn-primary w-100 fw-semibold">Register</button>
							</form>
							<%= request.getAttribute("msg")!=null ? request.getAttribute("msg"): "" %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>


	<%@ include file="footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>