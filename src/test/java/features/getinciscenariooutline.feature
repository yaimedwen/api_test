Feature: servicenow incident management

Scenario: get all the incident with query param

Given set the endpoint
And add the auth
And add the query params as "sysparm_fields" and "sys_id,number,category"
When when post request with short description as "<short_desc>",and catagery as "<category>"
Then validate the response 201

Examples:
|short_desc|category|
#1st row data
|create incident with body as string|software|
#1st row data
|create incident with body as string2|hardware|

