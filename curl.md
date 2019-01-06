### curl samples (application deployed in application context `voting`).

##Restaurants ++++

#### get All Restaurants
`curl -s http://localhost:8080/voting/view/restaurants --user Admin:admin`

#### get All Restaurants With Dishes & Votes
`curl -s http://localhost:8080/voting/view/results --user Admin:admin`

#### add Restaurant 100023
`curl -s -X POST -d '{"name":"New Restaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/restaurant --user Admin:admin`

#### del Restaurant 100023
`curl -s -X DELETE http://localhost:8080/voting/admin/restaurant/100023 --user Admin:admin`

##Users       ++++

#### get all Users
`curl -s http://localhost:8080/voting/admin/users  --user Admin:admin`

#### get User 100004
`curl -s http://localhost:8080/voting/admin/users/100004  --user Admin:admin`

#### add User 100024
`curl -s -X POST -d '{"name": "New User","roles": ["ROLE_USER"],"password": "new pass"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/users --user Admin:admin`

#### del User 100024
`curl -s -X DELETE http://localhost:8080/voting/admin/users/100024 --user Admin:admin`

#### update User 100004
`curl -s -X PUT -d '{"id": 100004, "name": "Update User","roles": ["ROLE_USER"], "password": "up pass"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/users/100004 --user Admin:admin`

##Dishes      ++++

#### get all Dishes today by Restaurant 100007
`curl -s http://localhost:8080/voting/view/dishesBy/100007  --user Admin:admin`

#### get all Dishes today
`curl -s http://localhost:8080/voting/admin/dishes  --user Admin:admin`

#### get Dish 100012
`curl -s http://localhost:8080/voting/admin/dishes/100012  --user Admin:admin`

#### add Dish 100025
`curl -s -X POST -d '{"name": "New Dish","price": 5001,"restaurant": 100007}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/dishes --user Admin:admin`

#### del Dish 100025
`curl -s -X DELETE http://localhost:8080/voting/admin/dishes/100025 --user Admin:admin`

#### update Dish 100018
`curl -s -X PUT -d ' {"id": 100018,"name": "Update Dish","price": 2001,"restaurant": 100007}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/dishes/100018 --user Admin:admin`

##Voting      ++++

#### add NEW Vote by Restaurant 100007 (works always if a new vote!!!)
`curl -s -X POST http://localhost:8080/voting/vote/100007 --user User4:password4`

#### add REPEAT Vote by Restaurant 100007 (works always if a repeat vote and time less 11!!!)
`curl -s -X POST http://localhost:8080/voting/vote/100007 --user User1:password1`

#### del Vote (works always if time less 11!!!)
`curl -s -X DELETE http://localhost:8080/voting/vote --user User1:password1`