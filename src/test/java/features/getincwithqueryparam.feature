Feature: servicenow incident management

Scenario Outline: create incidents

Given set the endpoint
And add the auth
And add the query params as "sysparm_fields" and "sys_id"
When send the request with qp
Then validate the response
