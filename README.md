[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/pedes/okta-jwt-spring-boot-authentication)

# Okta JWT spring-boot Authentication
Example on how to authenticate your app using Okta as IdP, and using spring-boot to control the authentication flow.

## How to run it
Set the environment properties for your OKTA account (First create a okta developer account if you still don't have it)
- yourOktaDomain (example -> export yourOktaDomain="https://dev-4851486.okta.com")
- clientId
- clientSecret

Or as a last resort, change those values in the application.properties 

Run the spring-boot:run goal, either using the maven wrapper or your local installation
./mvnw spring-boot:run

Invoke the local endpoint
curl http://localhost:8080/ (Expect the 401, Unathorized)

Get the JWT
One way is using this tool: https://oidcdebugger.com/
Provide the configuration details:
- Authorize URI (Example https://dev-4851486.okta.com/oauth2/default/v1/authorize, change it with your own OKTA account)
- Redirect URI https://oidcdebugger.com/debug
- Client ID
- State (Provide anything here, e.g. test)
- Change response type to token 

Now with the JWT sent it in the Authorization header 
curl http://localhost:8080/ -H "Authorization: Bearer $TOKEN"

You could also run this project in Gitpod, so just create a fork and follow the same steps.


curl https://8080-a01fb572-b232-4cb7-955b-37bc21c4bdf7.ws-eu01.gitpod.io/ -H "Authorization: Bearer $TOKEN"