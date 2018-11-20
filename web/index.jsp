
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
        
        <!-- Ejemplo de Include -->
        
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="custom/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="custom/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="custom/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="custom/css/util.css">
	<link rel="stylesheet" type="text/css" href="custom/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('custom/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                            <form class="login100-form validate-form" action="ServLogin" method="POST">
					<!--<span class="login100-form-title p-b-49">Login</span>--->
                                        
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Usuario es requerido">
						<span class="label-input100">Usuario</span>
                                                    <input class="input100" type="text" name="txtUser" id="txtUser" placeholder="Ingresa tu usuario">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Contraseña es requerido">
						<span class="label-input100">Contraseña</span>
                                                    <input class="input100" type="password" name="txtPass" id="txtPass" placeholder="ingresa tu contraseña">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="text-right p-t-8 p-b-31">
						<c:out value="${error}"/>
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
                                                        <button class="login100-form-btn" type="submit">Iniciar Sesion</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<!--===============================================================================================-->
	<script src="custom/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="custom/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="custom/vendor/bootstrap/js/popper.js"></script>
	<script src="custom/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="custom/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="custom/vendor/daterangepicker/moment.min.js"></script>
	<script src="custom/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="custom/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="custom/js/main.js"></script>

</body>
</html>
