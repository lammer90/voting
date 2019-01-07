api предполагает пользователей с двумя типами прав: ROLE_USER и ROLE_ADMIN;

Пользователи с првом ROLE_ADMIN имеют следующие доступные возможности:
- создавать, удалять и просматривать все рестораны;
- создавать, обновлять, удалять и просматривать всех пользователей;
- создавать, обновлять, удалять и просматривать еду для ресторанов только за текущий день;
- просматривать все рестораны с количеством голосов и меню за сегодняшний день; 

Пользователи с првом ROLE_USER имеют следующие доступные возможности:
- просматривать все рестораны;
- просматривать все рестораны с количеством голосов и меню за сегодняшний день;
- просматривать всю еду у выбранного ресторана за текущий день;
- добавлять первичный голос за выбранный ресторан в течении всего дня;
- может изменить решение только до 11 часов текущего дня, удалить голос или переголосовать;

### curl samples (application deployed in application context `voting`).

##Restaurants ++++

##ROLE_USER & ROLE_ADMIN
#### get All Restaurants 
`curl -s http://localhost:8080/voting/view/restaurants --user Admin:admin`

##ROLE_USER & ROLE_ADMIN
#### get All Restaurants With Dishes & Votes (все рестораны с количеством голосо и едой за сегодня)
`curl -s http://localhost:8080/voting/view/results --user Admin:admin`

##ROLE_ADMIN
#### add Restaurant 100023
`curl -s -X POST -d '{"name":"New Restaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/restaurant --user Admin:admin`

##ROLE_ADMIN
#### del Restaurant 100023
`curl -s -X DELETE http://localhost:8080/voting/admin/restaurant/100023 --user Admin:admin`

##Users       ++++

##ROLE_ADMIN
#### get all Users
`curl -s http://localhost:8080/voting/admin/users  --user Admin:admin`

##ROLE_ADMIN
#### get User 100004
`curl -s http://localhost:8080/voting/admin/users/100004  --user Admin:admin`

##ROLE_ADMIN
#### add User 100024
`curl -s -X POST -d '{"name": "New User","roles": ["ROLE_USER"],"password": "new pass"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/users --user Admin:admin`

##ROLE_ADMIN
#### del User 100024
`curl -s -X DELETE http://localhost:8080/voting/admin/users/100024 --user Admin:admin`

##ROLE_ADMIN
#### update User 100004
`curl -s -X PUT -d '{"id": 100004, "name": "Update User","roles": ["ROLE_USER"], "password": "up pass"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/users/100004 --user Admin:admin`

##Dishes      ++++

##ROLE_USER & ROLE_ADMIN (вся еда за текущий день в выбранном ресторане)
#### get all Dishes today by Restaurant 100007
`curl -s http://localhost:8080/voting/view/dishesBy/100007  --user Admin:admin`

##ROLE_ADMIN
#### get all Dishes today (вся еда за текущий день)
`curl -s http://localhost:8080/voting/admin/dishes  --user Admin:admin`

##ROLE_ADMIN
#### get Dish 100012
`curl -s http://localhost:8080/voting/admin/dishes/100012  --user Admin:admin`

##ROLE_ADMIN
#### add Dish 100025 (добавить в сегодняшнее меню)
`curl -s -X POST -d '{"name": "New Dish","price": 5001,"restaurant": 100007}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/dishes --user Admin:admin`

##ROLE_ADMIN
#### del Dish 100025 (удалить из сегодняшнего меню)
`curl -s -X DELETE http://localhost:8080/voting/admin/dishes/100025 --user Admin:admin`

##ROLE_ADMIN
#### update Dish 100018 (обновить в сегодняшнем меню)
`curl -s -X PUT -d ' {"id": 100018,"name": "Update Dish","price": 2001,"restaurant": 100007}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/voting/admin/dishes/100018 --user Admin:admin`

##Voting      ++++

##ROLE_USER
#### add NEW Vote by Restaurant 100007 (работает целый день при первичном голосовании!!!)
`curl -s -X POST http://localhost:8080/voting/vote/100007 --user User4:password4`

##ROLE_USER
#### add REPEAT Vote by Restaurant 100007 (при вторичном голосовании работает только до 11!!!)
`curl -s -X POST http://localhost:8080/voting/vote/100007 --user User1:password1`

##ROLE_USER
#### del Vote (работает только до 11!!!)
`curl -s -X DELETE http://localhost:8080/voting/vote --user User1:password1`