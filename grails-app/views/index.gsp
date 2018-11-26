<!doctype html>
<html>
<head>
    <meta name="layout" content="blank"/>
    <title>Welcome to Grails</title>
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
                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger">${flash.message}</div>
                    </g:if>
                    <s2ui:form type='login' focus='username'>
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Username" name="${securityConfig.apf.usernameParameter}" id="username" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="${securityConfig.apf.passwordParameter}" id="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" name="${securityConfig.rememberMe.parameter}" id="remember_me" type="checkbox" checked="checked" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-lg btn-success btn-block" name="${securityConfig.apf.passwordParameter}" id="loginButton">Login</button>
                            </div>
                            <a href="/register/register">Create new user</a>
                        </fieldset>
                    </s2ui:form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
