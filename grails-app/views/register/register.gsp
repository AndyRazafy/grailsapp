<html>
<head>
	<meta name="layout" content="blank"/>
	<s2ui:title messageCode='spring.security.ui.register.title'/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Grails - Le jeu</h3>
				</div>
				<div class="panel-body">
					<s2ui:formContainer type='register' focus='username'>
						<s2ui:form beanName='registerCommand'>
							<g:if test='${emailSent}'>
								<br/>
								<g:message code='spring.security.ui.register.sent'/>
							</g:if>
							<g:else>
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Username" name="username" type="text" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Email" name="email" type="email" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password" name="password" type="password" value="">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password (again)" name="password2" type="password" value="">
									</div>
									<div class="form-group">
										<button class="btn btn-lg btn-success btn-block" id="submit">Sign up</button>
									</div>
									<s2ui:linkButton elementId='login' controller='login' messageCode='Log in'/>
								</fieldset>
							</g:else>
						</s2ui:form>
					</s2ui:formContainer>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
