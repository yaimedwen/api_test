Feature: servicenow incident management

Scenario: create incidents

Given set the endpoint
And add the auth
And add the query params as "sysparm_fields" and "sys_id"
When send the request with qp
Then validate the response


Scenario: get all the incident with query param

Given set the endpoint
And add the auth
And add the query params
|sysparm_fields|sys_id,number,category|
When send the post request
Then validate the response as below
|result.approval|not requested|
|result.knowledge|false|
#|result.urgency|3|

