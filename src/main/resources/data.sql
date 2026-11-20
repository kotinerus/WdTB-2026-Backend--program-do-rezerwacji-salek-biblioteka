-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
-- LAB 03: klucze obce wskazują na numery wierszy tabel nadrzędnych (np. building_id = 1).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
 insert into user_account (email, display_name, role, created_at) values
         ('artur.lazanowski@student.merito.pl', 'Artur', 'USER',   current_timestamp),
         ('aleksander.luczycki@student.merito.pl', 'Aleksander', 'USER',   current_timestamp),
         ('krzysztof.wysocki@student.merito.pl', 'Krzysztof', 'USER',   current_timestamp);

-- ===== LAB 02 · building =====
insert into building (name, address, city, postal_code) values
    ('Biblioteka Główna',     'ul. Fabryczna 29-31', 'Wrocław', '53-609'),
    ('Centrum Informatyczne', 'ul. Fabryczna 10',    'Wrocław', '53-609'),
    ('Czytelnia Akademicka',  'ul. Ostrowskiego 22', 'Wrocław', '53-238');

-- ===== LAB 03 · equipment =====
insert into equipment (name, category, inventory_number, active) values
    ('Projektor',                 'AV',    'INV-001', true),
    ('Tablica suchościeralna',    'Biuro', 'INV-002', true),
    ('Zestaw wideokonferencyjny', 'AV',    'INV-003', true);

-- ===== LAB 02 · room (LAB 03: building_id) =====
insert into room (name, capacity, floor, room_type, building_id) values
    ('Cicha 101',          6,  1, 'SILENT_STUDY', 1),
    ('Grupowa 2.04',       10, 2, 'GROUP_STUDY',  1),
    ('Pracownia IT',       20, 0, 'COMPUTER_LAB', 2),
    ('Sala konferencyjna', 30, 3, 'CONFERENCE',   2);

-- ===== LAB 03 · room_equipment (tabela łącząca @ManyToMany) =====
insert into room_equipment (room_id, equipment_id) values
    (2, 1),
    (2, 2),
    (3, 1),
    (4, 3);

-- ===== LAB 03 · library_card (@OneToOne z user_account) =====
insert into library_card (card_number, issued_at, expires_at, active, user_account_id) values
    ('LC-0001', date '2026-09-01', date '2027-09-01', true, 1),
    ('LC-0002', date '2026-09-01', date '2027-09-01', true, 2),
    ('LC-0003', date '2026-09-15', date '2027-09-15', true, 5);

-- ===== LAB 02 · reservation (LAB 03: room_id, user_account_id) =====
-- Kolumny modification_date i modified_by pochodzą z klasy wbudowanej ModificationInfo.
insert into reservation (start_time, end_time, status, note, modification_date, modified_by, room_id, user_account_id) values
    (timestamp '2026-11-02 10:00:00', timestamp '2026-11-02 12:00:00', 'CONFIRMED', 'Nauka do kolokwium',           current_timestamp, 'ola@student.merito.pl',  1, 1),
    (timestamp '2026-11-03 14:00:00', timestamp '2026-11-03 16:00:00', 'PENDING',   'Praca grupowa nad projektem', current_timestamp, 'kuba@student.merito.pl', 2, 2),
    (timestamp '2026-11-04 09:00:00', timestamp '2026-11-04 10:00:00', 'CANCELLED', null,                          current_timestamp, 'ola@student.merito.pl',  1, 1);

-- ===== LAB 02 · notification (LAB 03: user_account_id zamiast user_to) =====
insert into notification (user_account_id, message, template, created_at) values
    (1, 'Rezerwacja salki Cicha 101 została potwierdzona.',      'RESERVATION_CONFIRMED', current_timestamp),
    (2, 'Rezerwacja salki Grupowa 2.04 czeka na potwierdzenie.', 'RESERVATION_PENDING',   current_timestamp),
    (1, 'Rezerwacja z 4 listopada została anulowana.',           'RESERVATION_CANCELLED', current_timestamp);