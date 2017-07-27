insert into users (id, login, password, active) values (1, 'admin', 'fd66aa8bbeb27853026132a01068de7108a6a5b6d1a6bf3c423cdd1062ae33762eba7bc71bb90b0b', true);
insert into authorities (id, name) values(1, 'ROLE_ADMIN');
insert into users_authorities values(1,1);
insert into users (id, login, password, active) values (2, 'user', 'fd66aa8bbeb27853026132a01068de7108a6a5b6d1a6bf3c423cdd1062ae33762eba7bc71bb90b0b', true);
insert into authorities (id, name) values(2, 'ROLE_USER');
insert into users_authorities values(2,2);