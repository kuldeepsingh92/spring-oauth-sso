# Spring OAuth SSO (Google and GitHub)
	- It is verity easy to implement SSO with spring OAuthClient
	- Dependency:
			implementation 'org.springframework.boot:spring-boot-starter-web'
			implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
	- Write a simple security filter
			@Bean
			public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
				    return httpSecurity
					            // Enable authentication for all urls
				        	    .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
					            // Enable oauth2 login
					            .oauth2Login(Customizer.withDefaults())
					            .build();
			}
	- And add client id and secrets for the SSO providers
		Ex: 
			spring.security.oauth2.client.registration.google.client-id=<client-id>
			spring.security.oauth2.client.registration.google.client-secret=<secret>

			spring.security.oauth2.client.registration.github.client-id=<client-id>
			spring.security.oauth2.client.registration.github.client-secret=<secret>
	
	- All set 🎉
