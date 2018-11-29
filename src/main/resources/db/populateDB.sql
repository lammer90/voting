DELETE
FROM user_roles;
DELETE
FROM votes;
DELETE
FROM dishes;
DELETE
FROM users;
DELETE
FROM restaurants;
ALTER SEQUENCE global_seq
  RESTART WITH 100000;

INSERT INTO users (name, password)
VALUES ('User1', 'password1'),  /*100000*/
       ('User2', 'password2'),  /*100001*/
       ('User3', 'password3'),  /*100002*/
       ('User4', 'password4'),  /*100003*/
       ('User5', 'password5'),  /*100004*/
       ('Admin', 'admin');    /*100005*/

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_USER', 100001),
       ('ROLE_USER', 100002),
       ('ROLE_USER', 100003),
       ('ROLE_USER', 100004),
       ('ROLE_ADMIN', 100005);

INSERT INTO restaurants (name)
VALUES ('SUSHI MARKET'),  /*100006*/
       ('PAPA BURGER'),   /*100007*/
       ('PASTA BAR');     /*100008*/

INSERT INTO dishes (name, date_time, price, restaurant_id)
VALUES ('ролл с угрем', '2018-11-29', 100.00, 100006),
       ('суши с лососем', '2018-11-29', 120.00, 100006),
       ('острый суп', '2018-11-29', 50.00, 100006),

       ('бургер с говядиной', '2018-11-29', 140.00, 100007),
       ('салат из овощей', '2018-11-29', 30.00, 100007),
       ('суп грибной', '2018-11-29', 100.00, 100007),

       ('паста с беконом', '2018-11-29', 120.00, 100008),
       ('салат цезарь', '2018-11-29', 120.00, 100008),
       ('булочка белая', '2018-11-29', 20.00, 100008);


INSERT INTO votes (date_time, restaurant_id, user_id)
VALUES ('2018-11-29', 100006, 100000),
       ('2018-11-29', 100007, 100001),
       ('2018-11-29', 100008, 100002),
       ('2018-11-29', 100007, 100003),
       ('2018-11-29', 100007, 100004);
