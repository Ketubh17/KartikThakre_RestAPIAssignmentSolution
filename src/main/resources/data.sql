
INSERT INTO users (user_id,password,username) VALUES ( 1,'$2a$12$gIk5/ddKI.ACAjW3PYL5Yerx1leyGqwVVZ2v92ggytq6Bgigkz2E.','admin');
INSERT INTO roles (role_id,role_name) VALUES ( 1, 'ADMIN' );
INSERT INTO users_roles (user_id,role_id) VALUES ( 1, 1);