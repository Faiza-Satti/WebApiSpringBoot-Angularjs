<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../static/css/loginCss/style.css">
</head>
<body>
<div class="container">
	<div class="screen">
		<div class="screen__content">
			<form class="login">
				<div class="login__field">
					<input type="text" class="login__input" placeholder="User name / Email">
				</div>
				<div class="login__field">
					<input type="password" class="login__input" placeholder="Password">
				</div>
				<div class="login__field">
					<select class="login__input" name="cars" id="cars">
					  <option class="login__input" selected disabled>Select Your Role</option>
					  <option class="login__input" value="Administrator">Administrator</option>
					  <option class="login__input" value="Teacher">Teacher</option>
					  <option class="login__input" value="Student">Student</option>
					</select>				
				</div>
				<button class="button login__submit">
					<span class="button__text">LogIn</span>
				</button>
			</form>
		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>
	</div>
</div>
</body>
</html>