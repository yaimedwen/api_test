Feature: servicenow incident management

Scenario: get all the incident with query param

Given set the endpoint
And add the auth
And add the query params
|sysparm_fields|sys_id,category|
|category|software|
When send the request with qp
Then validate the response
