<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Student Login - StudentManager</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
  />
</head>
<body class="d-flex flex-column min-vh-100">
  <%@ include file="navbar.html" %>  <!-- Navbar Include -->
  
  	<!-- Session validation -->
	<%
		String user=(String) session.getAttribute("username");
		if(user!=null){
			response.sendRedirect("home.jsp");
		}
	%>

  <main class="container flex-grow-1 pt-5">
    <div class="container my-5">
      <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
          <div class="card shadow-sm">
            <div class="card-header bg-primary text-white fw-bold text-center">
              Student Login
            </div>
            <div class="card-body">
              <form action="AuthenticateServlet" method="post" >
                <div class="mb-3">
                  <label for="username" class="form-label">Username</label>
                  <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    placeholder="Enter Username"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input
                    type="password"
                    id="password"
                    name="password"
                    class="form-control"
                    placeholder="Enter Password"
                    required
                  />
                </div>
                <button type="submit" class="btn btn-primary w-100 fw-semibold">
                  Login
                </button>
              </form>
              <%= request.getAttribute("msg")!=null ? request.getAttribute("msg"): "" %>
              
              <div class="mt-3 text-center">
                <span>Don't have an account?</span>
                <a href="register.jsp">Register Here</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>

  <%@ include file="footer.html" %>  <!-- Footer Include -->

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
