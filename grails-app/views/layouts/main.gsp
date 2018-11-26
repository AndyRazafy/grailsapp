<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="startmin.css"/>
    <asset:stylesheet src="metisMenu.min.css"/>

    <g:layoutHead/>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="wrapper">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">Grails</a>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <sec:ifLoggedIn>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><sec:username /><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><g:link controller="users" action="show" id="${sec.loggedInUserInfo(field:'id')}">Profile</g:link></li>
                                <li class="divider"></li>
                                <li><g:link controller="logout">logout</g:link></li>
                            </ul>
                        </li>
                    </sec:ifLoggedIn>
                </ul>
            </div>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="/users" class="active"><i class="fa fa-dashboard fa-fw"></i> Acceuil</a>
                        </li>
                        <li>
                            <a href="/users/list" class="active"><i class="fa fa-dashboard fa-fw"></i> Jouer</a>
                        </li>
                        <li>
                            <a href="/score/index" class="active"><i class="fa fa-dashboard fa-fw"></i> Mes resultats</a>
                        </li>
                        <li>
                            <a href="/message/index" class="active"><i class="fa fa-dashboard fa-fw"></i> Messages</a>
                        </li>
                    </ul>
                </div>
            </div>
    </div>
</nav>

<g:layoutBody/>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="startmin.js"/>
<asset:javascript src="metisMenu.min.js"/>

</body>
</html>
