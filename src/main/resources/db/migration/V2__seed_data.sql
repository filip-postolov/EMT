-- V2__seed_data.sql

-- Countries
INSERT INTO country (name, continent) VALUES
('Macedonia',       'Europe'),
('Germany',         'Europe'),
('France',          'Europe'),
('United States',   'North America'),
('Japan',           'Asia'),
('Brazil',          'South America'),
('Australia',       'Oceania');

-- Hosts
INSERT INTO host (created_at, updated_at, name, surname, country_id) VALUES
(NOW(), NOW(), 'Marko',   'Petrovski', 1),
(NOW(), NOW(), 'Ana',     'Jovanovska', 1),
(NOW(), NOW(), 'Hans',    'Müller',    2),
(NOW(), NOW(), 'Claire',  'Dupont',    3),
(NOW(), NOW(), 'John',    'Smith',     4),
(NOW(), NOW(), 'Yuki',    'Tanaka',    5);

-- Accommodations
INSERT INTO accommodation (created_at, updated_at, name, category, condition, is_rented, num_rooms, host_id) VALUES
(NOW(), NOW(), 'Cozy Room in Skopje Center', 'ROOM',      'GOOD', FALSE, 1, 1),
(NOW(), NOW(), 'Mountain House Mavrovo',     'HOUSE',     'GOOD', FALSE, 4, 2),
(NOW(), NOW(), 'Flat in Bitola Old Bazaar',  'FLAT',      'GOOD', TRUE,  2, 1),
(NOW(), NOW(), 'Studio Apartment Ohrid',     'APARTMENT', 'GOOD', FALSE, 1, 3),
(NOW(), NOW(), 'Boutique Hotel Struga',      'HOTEL',     'GOOD', FALSE, 20, 4),
(NOW(), NOW(), 'Motel on Highway A1',        'MOTEL',     'BAD',  FALSE, 10, 5),
(NOW(), NOW(), 'Penthouse Skopje',           'APARTMENT', 'GOOD', TRUE,  3, 6),
(NOW(), NOW(), 'Guest House Matka',          'HOUSE',     'GOOD', FALSE, 3, 2),
(NOW(), NOW(), 'City Flat Berlin',           'FLAT',      'GOOD', FALSE, 2, 3),
(NOW(), NOW(), 'Tokyo Capsule Room',         'ROOM',      'GOOD', FALSE, 1, 6);
