-- Вставка администратора с паролем "admin123"
insert into employee (username, password, email, role)
values (
    'admin',
    '$2a$10$BWfA5g6DTX5lVtvaonPxTu.OWYmf86sn2eYd48ucafKoJVgK/tghu',
     -- bcrypt хеш для "my_1secret1_password"
    'admin@example.com',
    'ADMIN'
);
