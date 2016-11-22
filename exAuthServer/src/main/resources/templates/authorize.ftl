
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

	<div class="panel-primary" style="background:#fff;border:#ddd 1px solid;margin: 20px;padding:20px;" >
	<h2>Please Confirm</h2>

		<p>
			Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your protected resources
			with scope ${authorizationRequest.scope?join(", ")}.
		</p>
		<div class="row" >
		<div class="col-md-1">
		<form id="confirmationForm" name="confirmationForm"	action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class="btn btn-primary" type="submit">Approve</button>
		</form>
		</div>
		<div class="col-md-1">
		<form id="denyForm" name="confirmationForm" action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="false" type="hidden" />
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class="btn btn-danger" type="submit">Deny</button>
		</form>
		</div>
		</div>
	</div>
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
