<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'users.label', default: 'Users')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Dashboard</h1>
        </div>
        <!-- /.col-lg-12 -->
        <sec:access expression="hasRole('ROLE_ADMIN')">
            <a href="#list-users" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
            <div class="nav" role="navigation">
                <ul>
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </ul>
            </div>
        </sec:access>
        <div id="list-users" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="alert alert-info" role="status">${flash.message}</div>
            </g:if>
            <g:if test="${flash.error}">
                <div class="alert alert-danger" role="status">${flash.error}</div>
            </g:if>
        <!--<f:table collection="${usersList}" properties="username"/>-->

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>Username</td>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${usersList}" var="user">
                        <tr>
                            <td><a href="/users/show/${user.id}">${user.username}</a></td>
                            <td>
                                <a href="/users/jouer?user1=${currUser.id}&user2=${user.id}">
                                    <button type="button" class="btn btn-primary">Jouer</button>
                                </a>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>

            <div class="pagination">
                <g:paginate total="${usersCount ?: 0}" />
            </div>
        </div>
    </div>
</div>
</body>
</html>