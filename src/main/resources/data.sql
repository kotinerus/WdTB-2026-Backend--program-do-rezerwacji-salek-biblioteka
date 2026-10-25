-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
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

-- ===== LAB 02 · room =====
-- Klucz obcy do budynku dojdzie na kolejnych zajęciach
insert into room (name, capacity, floor, room_type) values
    ('Cicha 101',          6,  1, 'SILENT_STUDY'),
    ('Grupowa 2.04',       10, 2, 'GROUP_STUDY'),
    ('Pracownia IT',       20, 0, 'COMPUTER_LAB'),
    ('Sala konferencyjna', 30, 3, 'CONFERENCE');

-- ===== LAB 02 · reservation =====
-- Kolumny modification_date i modified_by pochodzą z klasy wbudowanej ModificationInfo.
-- Klucze obce do salki i użytkownika (UserAccount) dojdą na kolejnych zajęciach
insert into reservation (start_time, end_time, status, note, modification_date, modified_by) values
    (timestamp '2026-11-02 10:00:00', timestamp '2026-11-02 12:00:00', 'CONFIRMED', 'Nauka do kolokwium',           current_timestamp, 'ola@student.merito.pl'),
    (timestamp '2026-11-03 14:00:00', timestamp '2026-11-03 16:00:00', 'PENDING',   'Praca grupowa nad projektem', current_timestamp, 'kuba@student.merito.pl'),
    (timestamp '2026-11-04 09:00:00', timestamp '2026-11-04 10:00:00', 'CANCELLED', null,                          current_timestamp, 'ola@student.merito.pl');

