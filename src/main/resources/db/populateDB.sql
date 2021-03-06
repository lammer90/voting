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
VALUES
       ('Старая еда', '2018-11-30', 10000, 100006),     /*100009*/

       ('ролл с угрем', CAST(now() AS DATE), 10000, 100006),
       ('суши с лососем', CAST(now() AS DATE), 12000, 100006),
       ('острый суп', CAST(now() AS DATE), 5000, 100006),

       ('бургер с говядиной', CAST(now() AS DATE), 14000, 100007),
       ('салат из овощей', CAST(now() AS DATE), 3000, 100007),
       ('суп грибной', CAST(now() AS DATE), 10000, 100007),

       ('паста с беконом', CAST(now() AS DATE), 12000, 100008),
       ('салат цезарь', CAST(now() AS DATE), 12000, 100008),
       ('булочка белая', CAST(now() AS DATE), 2000, 100008);

/*('ролл с угрем', '2018-11-30', 100.00, 100006),
('суши с лососем', '2018-11-30', 120.00, 100006),
('острый суп', '2018-11-30', 50.00, 100006),

('бургер с говядиной', '2018-11-30', 140.00, 100007),
('салат из овощей', '2018-11-30', 30.00, 100007),
('суп грибной', '2018-11-30', 100.00, 100007),

('паста с беконом', '2018-11-30', 120.00, 100008),
('салат цезарь', '2018-11-30', 120.00, 100008),
('булочка белая', '2018-11-30', 20.00, 100008);*/


INSERT INTO votes (date_time, restaurant_id, user_id)
VALUES (CAST(now() AS DATE), 100006, 100000),
       (CAST(now() AS DATE), 100007, 100001),
       (CAST(now() AS DATE), 100008, 100002),
     /*  (date_trunc('day', now()), 100007, 100003),*/
       (CAST(now() AS DATE), 100007, 100004);
/*('2018-11-30', 100006, 100000),
('2018-11-30', 100007, 100001),
('2018-11-30', 100008, 100002),
('2018-11-30', 100007, 100003),
('2018-11-30', 100007, 100004);*/
