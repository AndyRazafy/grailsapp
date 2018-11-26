<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'score.label', default: 'Score')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Mes resultats</h1>
                </div>
                <!-- /.col-lg-12 -->
                <sec:access expression="hasRole('ROLE_ADMIN')">
                    <a href="#list-score" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                    <div class="nav" role="navigation">
                        <ul>
                            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                        </ul>
                    </div>
                </sec:access>
                <div id="list-score" class="content scaffold-list" role="main">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <!--<f:table collection="${scoreList}" />-->
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>Resultat</td>
                                <td>Date</td>
                                <td>score</td>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${scoresList}" var="score">
                                <tr>
                                    <td>
                                        <a href="/resultat/show/${score.resultat.id}">${score.resultat.id}</a>
                                    </td>
                                    <td>
                                        <g:formatDate format="dd/MM/yyyy hh:mm:ss" date="${score.resultat.date}"/>
                                    </td>
                                    <td>
                                       ${score.score}
                                    </td>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                    </div>

                    <div class="pagination">
                        <g:paginate total="${scoreCount ?: 0}" />
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>