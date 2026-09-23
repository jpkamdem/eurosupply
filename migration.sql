set time zone 'utc';
create extension if not exists "uuid-ossp";

drop table if exists food cascade;
drop table if exists materials cascade;
drop table if exists medics;
drop type if exists unit cascade;

create type unit as enum ('kg', 'unit', 'L');

create table if not exists food (
    id uuid primary key unique not null default uuid_generate_v4(),
    name varchar(75) unique not null,
    quantity integer not null,
    unit unit not null,
    expiration timestamptz not null default (now() + interval '1 week')
);

create table if not exists materials (
    id uuid primary key unique not null default uuid_generate_v4(),
    name varchar(75) unique not null,
    quantity integer not null
);

create table if not exists medics (
    id uuid primary key unique not null default uuid_generate_v4(),
    name varchar(75) unique not null,
    quantity integer not null,
    expiration timestamptz not null default (now() + interval '6 months')
);

-- FOOD
insert into food (name, quantity, unit) values
('Pomme de terre', 8, 'kg'),
('Banane', 7, 'kg'),
('Avocat', 5, 'unit'),
('Pomme', 9, 'unit'),
('Figue', 4, 'kg'),
('Ananas', 5, 'unit'),
('Eau', 11, 'L'),
('Carotte', 6, 'kg'),
('Tomate', 12, 'unit'),
('Courgette', 4, 'kg'),
('Orange', 8, 'unit'),
('Citron', 2, 'kg'),
('Fraise', 3, 'kg'),
('Raisin', 2, 'kg'),
('Poire', 6, 'unit'),
('Mangue', 4, 'unit'),
('Melon', 3, 'unit'),
('Pastèque', 5, 'kg'),
('Oignon', 4, 'kg'),
('Ail', 2, 'unit'),
('Lait', 6, 'L'),
('Jus d''orange', 3, 'L'),
('Huile d''olive', 2, 'L'),
('Farine', 5, 'kg'),
('Sucre', 3, 'kg'),
('Riz', 8, 'kg'),
('Pâtes', 6, 'kg'),
('Lentilles', 2, 'kg'),
('Pois chiches', 3, 'kg'),
('Haricots verts', 4, 'kg');

-- MATERIALS
insert into materials (name, quantity) values
('Assiette', 24),
('Verre', 30),
('Fourchette', 20),
('Couteau', 20),
('Cuillère', 20),
('Casserole', 4),
('Poêle', 3),
('Marmite', 2),
('Planche à découper', 5),
('Spatule', 6),
('Fouet', 3),
('Louche', 4),
('Passoire', 2),
('Saladier', 5),
('Bol', 12),
('Tasse', 16),
('Plateau', 4),
('Éponge', 10),
('Torchon', 15),
('Sac poubelle', 50),
('Boîte de conservation', 20),
('Film alimentaire', 4),
('Papier aluminium', 5),
('Bouteille réutilisable', 10),
('Thermos', 6),
('Ouvre-boîte', 3),
('Économe', 4),
('Tire-bouchon', 2),
('Balance de cuisine', 2),
('Bouilloire', 2);

-- MEDICS
insert into medics (name, quantity) values
('Paracétamol', 24),
('Ibuprofène', 18),
('Aspirine', 20),
('Antiseptique', 3),
('Pansements', 50),
('Compresses stériles', 30),
('Sérum physiologique', 12),
('Thermomètre', 2),
('Gel hydroalcoolique', 5),
('Crème cicatrisante', 3),
('Pommade anti-inflammatoire', 2),
('Collyre', 4),
('Spray nasal', 3),
('Pastilles pour la gorge', 40),
('Sirop contre la toux', 4),
('Vitamine C', 60),
('Vitamine D', 90),
('Magnésium', 60),
('Antihistaminique', 30),
('Crème solaire', 5),
('Baume à lèvres', 8),
('Pansements ampoules', 20),
('Bandage élastique', 6),
('Gants médicaux', 50),
('Masques chirurgicaux', 100),
('Désinfectant', 4),
('Coton médical', 10),
('Pince à épiler', 2),
('Ciseaux médicaux', 2),
('Kit de premiers secours', 3);