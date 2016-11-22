<!DOCTYPE html>
<!--[if IE 8]>         <html class="ie8"> <![endif]-->
<!--[if IE 9]>         <html class="ie9 gt-ie8"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="gt-ie8 gt-ie9 not-ie"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Sign In - PixelAdmin</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

	<!-- Open Sans font from Google CDN -->
	<link href="../fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300&amp;subset=latin" rel="stylesheet" type="text/css">

	<!-- Pixel Admin's stylesheets -->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/pixel-admin.min.css" rel="stylesheet" type="text/css">
	<link href="css/pages.min.css" rel="stylesheet" type="text/css">
	<link href="css/rtl.min.css" rel="stylesheet" type="text/css">
	<link href="css/themes.min.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
		<script src="assets/javascripts/ie.min.js"></script>
	<![endif]-->

</head>


<!-- 1. $BODY ======================================================================================
	
	Body

	Classes:
	* 'theme-{THEME NAME}'
	* 'right-to-left'     - Sets text direction to right-to-left
-->
<body class="theme-asphalt page-signin-alt">



<!-- 2. $MAIN_NAVIGATION ===========================================================================

	Main navigation
-->
	<div class="signin-header">
		<a href="index.html" class="logo">
			<div class="demo-logo bg-primary"><img src="/demo/logo-big.png" alt="" style="margin-top: -4px;"></div>&nbsp;
			<strong>Expedite</strong>
		</a> <!-- / .logo -->
	</div> <!-- / .header -->

	<h1 class="form-header">Sign in to your Account</h1>

	

	<!-- Form -->
	<form action="login" method="post" id="signin-form_id" class="panel">
	<#if RequestParameters['error']??>
		<div class="alert alert-danger alert-dismissible" role="alert" ng-show="showerror">
    	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	   		<ul><li>There was a problem logging in. Please try again.</li>
	   		<li>Wrong Username/Password </li>
	   		</ul>
	   		
		</div>
	</#if>
	
		<div class="form-group">
			<input type="text" name="username" id="username" class="form-control input-lg" placeholder="Username or email">
		</div> <!-- / Username -->

		<div class="form-group signin-password">
			<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
			<a href="pages-signin-alt.html#" class="forgot">Forgot?</a>
		</div> <!-- / Password -->

		<div class="form-actions">
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Sign In" class="btn btn-primary btn-block btn-lg">
		</div> <!-- / .form-actions -->
	</form>
	<!-- / Form -->
<!-- 
	<div class="signin-with">
		<div class="header">or sign in with</div>
		<a href="index.html" class="btn btn-lg btn-facebook rounded"><i class="fa fa-facebook"></i></a>&nbsp;&nbsp;
		<a href="index.html" class="btn btn-lg btn-info rounded"><i class="fa fa-twitter"></i></a>&nbsp;&nbsp;
		<a href="index.html" class="btn btn-lg btn-danger rounded"><i class="fa fa-google-plus"></i></a>
	</div>

 -->


<!-- Expedite's javascripts -->
		<script src="js/jquery-1.10.2.min.js"></script> 
		<script src="js/bootstrap.min.js"></script>
		<script src="js/pixel-admin.min.js"></script>
		<script src="js/angular.min.js"></script>
		<script src="js/angular-route.min.js"></script>
		<script src="js/angular-resource.min.js"></script>
		<script src="js/expedite.js"></script>


<script type="text/javascript">
	$(document).ready(function(){
			$("#signin-form_id").validate({ focusInvalid: true, errorPlacement: function () {} });
			
			// Validate username
			$("#username").rules("add", {
				required: true,
				minlength: 3
			});

			// Validate password
			$("#password").rules("add", {
				required: true,
				minlength: 6
			});
	});
</script>

</body>
</html>
