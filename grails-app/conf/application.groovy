

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'm2.grails.Users'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'm2.grails.UsersRole'
grails.plugin.springsecurity.authority.className = 'm2.grails.Role'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.ui.register.requireEmailValidation = []
grails.plugin.springsecurity.ui.register.postRegisterUrl = '/login/auth'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/users/index'
grails.plugin.springsecurity.ui.register.defaultRoleNames = ['ROLE_USER']
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

