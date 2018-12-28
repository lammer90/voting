DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(255)            NOT NULL,
  password         VARCHAR(255)            NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  CONSTRAINT user_name_idx UNIQUE (name)
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR(255)            NOT NULL,
  CONSTRAINT restaurants_name_idx UNIQUE (name)
);


  CREATE TABLE dishes
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name          VARCHAR(255) NOT NULL,
  date_time     TIMESTAMP    NOT NULL,
  price         REAL         NOT NULL,
  restaurant_id INTEGER      NOT NULL,
  CONSTRAINT dishes_name_date_rest_idx UNIQUE (name, date_time, restaurant_id),
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE INDEX dishes_restaurant_date_idx
  ON dishes (restaurant_id, date_time);

CREATE TABLE votes
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date_time     TIMESTAMP DEFAULT now()    NOT NULL,
  restaurant_id INTEGER                    NOT NULL,
  user_id       INTEGER                    NOT NULL,
  CONSTRAINT votes_date_rest_user_idx UNIQUE (date_time, restaurant_id, user_id),
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE INDEX votes_datetime_idx
  ON votes (date_time, user_id);