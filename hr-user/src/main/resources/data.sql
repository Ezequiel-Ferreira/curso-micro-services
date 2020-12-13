INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@nina.com', '$2a$10$NYFZ/123qddwdqd32r2rrwrfg');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@leia.com', '$2a$10$NYFZ/321swefwjhouifhoih2893089rukf');
INSERT INTO tb_user (name, email, password) VALUES ('Dora White', 'dora@dora.com', '$2a$10$NYFZ/456hnfuh2rf0h2r8y97yh2ufh');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');


INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (3, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);