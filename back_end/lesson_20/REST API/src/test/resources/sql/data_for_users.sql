insert into account(email, state, role)
values ('test@mail.com', 'NOT_CONFIRMED', 'USER');
insert into account(email, state, role)
values ('test1@mail.com', 'CONFIRMED', 'ADMIN');

insert into article(text, about_id)
values ('Article 1', 1);
insert into article(text, about_id)
values ('Article 2', 1);