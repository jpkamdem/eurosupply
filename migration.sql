set time zone 'utc';
create extension if not exists "uuid-ossp";

drop table if exists food;

create table if not exists food (
    id uuid primary key unique not null default uuid_generate_v4(),
    name varchar(75) unique not null,
    quantity integer not null
);

insert into food (name, quantity) values 
('Pomme de terre', 45),
('Banane', 12),
('Avocat', 5),
('Pomme', 25),
('Figue', 4),
('Ananas', 5),
('Riz', 11)
;