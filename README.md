# CROHAVIOR Web Service

## Overview
This is a Web Service for the Crohavior project.

##WS API DEMO

1. GET Heatmaps without api_key:

https://crohavior-ws.herokuapp.com/api/heatmaps/1?interval=10&startTime=1224734010000&endTime=1224734045000

expected response: {"apiResponseMessage":{"message":"Parameter api_key has to be provided","type":"error"}}

2. GET Heatmaps correct:

https://crohavior-ws.herokuapp.com/api/heatmaps/1?interval=10&startTime=1224734010000&endTime=1224734045000&api_key=test

expected response: the first page of data

3. GET Heatmaps page 2:

https://crohavior-ws.herokuapp.com/api/heatmaps/1?interval=10&startTime=1224734010000&endTime=1224734045000&pageNmb=2&api_key=test

expected response: no content, page is empty

4. GET trajectories batches

https://crohavior-ws.herokuapp.com/api/trajectories/batches/1?api_key=akmahousing

expected response: list of trajectories with links

5. GET trajectories batch by link from 4.

http://crohavior-ws.herokuapp.com/api/trajectories/1?batchId=ss2008-10-23T03%3A53%3A30e2008-10-23T05%3A53%3A30&api_key=akmahousing

expected response: valid list of trajectories

6. GET heatmaps by the link from the trajectories

http://crohavior-ws.herokuapp.com/api/heatmaps/1?startTime=1224734010000&endTime=1224741210000&interval=10&api_key=akmahousing

expected response: heatmaps page 1 with/without data

7. GET User by username

http://crohavior-ws.herokuapp.com/api/users/CROHAVIOR?api_key=crohavior

expected response: user with links and embedded projects

8. DELETE user by following the link from the _links

DELETE https://crohavior-ws.herokuapp.com/api/users/CROHAVIOR?api_key=crohavior

expected response: User has to be ADMIN

9. DELETE same user with ADMIN api_key

DELETE https://crohavior-ws.herokuapp.com/api/users/CROHAVIOR?api_key=akmahousing

expected: works!

10. GET User to check it's deleted

GET https://crohavior-ws.herokuapp.com/api/users/CROHAVIOR?api_key=akmahousing

11. Create project

POST https://crohavior-ws.herokuapp.com/api/projects?api_key=akmahousing
{
"id":5,
  "projectName": "Demeter",
"minLatitude": 40.333,
"minLongitude": 161.666, 
"maxLatitude": 40.666,
"maxLongitude": 161.999,
"userId":1

}

expected: OK

12. Update the same project: change id

PUT https://crohavior-ws.herokuapp.com/api/projects/5?api_key=akmahousing
{
"id":6,
  "projectName": "Demeter",
"minLatitude": 40.333,
"minLongitude": 161.666, 
"maxLatitude": 40.666,
"maxLongitude": 161.999,
"userId":1

}

expected: cannot change ID

13. Update correct

PUT https://crohavior-ws.herokuapp.com/api/projects/5?api_key=akmahousing

{
"id":5,
  "projectName": "Demeter 2.0",
"minLatitude": 40.333,
"minLongitude": 161.666, 
"maxLatitude": 40.666,
"maxLongitude": 161.999,
"userId":1

}

expected: OK

14. GET to check the change

https://crohavior-ws.herokuapp.com/api/projects/5?api_key=akmahousing

expected: Demeter 2.0 as name






