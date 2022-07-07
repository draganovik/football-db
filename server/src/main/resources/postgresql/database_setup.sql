-- DATABASE SETUP
DROP TABLE IF EXISTS liga CASCADE;
DROP TABLE IF EXISTS tim CASCADE;
DROP TABLE IF EXISTS igrac CASCADE;
DROP TABLE IF EXISTS nacionalnost CASCADE;
-- CREATE TABLE liga
CREATE TABLE liga
(
    id     INTEGER primary key,
    naziv  VARCHAR(100),
    oznaka VARCHAR(50)
);
-- CREATE TABLE tim
CREATE TABLE nacionalnost
(
    id         INTEGER primary key,
    naziv      VARCHAR(100),
    skracenica VARCHAR(50)
);
-- CREATE TABLE tim
CREATE TABLE tim
(
    id      INTEGER primary key,
    naziv   VARCHAR(100),
    osnovan DATE,
    sediste VARCHAR(100),
    liga    INTEGER NOT NULL,
    CONSTRAINT fk_tim_liga FOREIGN KEY (liga) REFERENCES liga (id) ON DELETE
        SET NULL
);
-- CREATE HELPER SEQUENCE FOR BROJ_REG
DROP SEQUENCE IF EXISTS player_code CASCADE;
CREATE SEQUENCE player_code MINVALUE 0 START WITH 1 INCREMENT BY 4;
-- CREATE TABLE igrac
CREATE TABLE igrac
(
    id             INTEGER primary key,
    ime            VARCHAR(50),
    prezime        VARCHAR(50),
    broj_reg       VARCHAR(50) DEFAULT NEXTVAL('player_code') NOT NULL,
    datum_rodjenja DATE,
    nacionalnost   INTEGER                                    NOT NULL,
    tim            INTEGER                                    NOT NULL,
    CONSTRAINT fk_igrac_nacionalnost FOREIGN KEY (nacionalnost) REFERENCES nacionalnost (id) ON DELETE
        SET NULL,
    CONSTRAINT fk_igrac_tim FOREIGN KEY (tim) REFERENCES tim (id) ON DELETE
        SET NULL
);
-- CREATE INDEXES
CREATE INDEX idx_liga_pk on liga (id);
CREATE INDEX idx_tim_pk on tim (id);
CREATE INDEX idx_nacionalnost_pk on nacionalnost (id);
CREATE INDEX idx_igrac_pk on igrac (id);
CREATE INDEX idx_igrac_fk_nacionalnost on igrac (nacionalnost);
CREATE INDEX idx_igrac_fk_tim on igrac (tim);
CREATE INDEX idx_tim_fk_liga on tim (liga);
-- CREATE INDEX SEQUENCES
DROP SEQUENCE IF EXISTS liga_id_req CASCADE;
DROP SEQUENCE IF EXISTS tim_id_req CASCADE;
DROP SEQUENCE IF EXISTS igrac_id_req CASCADE;
DROP SEQUENCE IF EXISTS nacionalnost_id_req CASCADE;
CREATE SEQUENCE liga_id_req MINVALUE 0 START WITH 1;
CREATE SEQUENCE tim_id_req MINVALUE 0 START WITH 1;
CREATE SEQUENCE igrac_id_req MINVALUE 0 START WITH 1;
CREATE SEQUENCE nacionalnost_id_req MINVALUE 0 START WITH 1;
-- MOCK DATA
INSERT INTO liga
VALUES (-99, 'Druga Liga', 'MNE');
INSERT INTO nacionalnost
VALUES (-99, 'Montenegro', 'MNE');
INSERT INTO tim
VALUES (-99,
        'Radnički',
        to_date('1914', 'yyyy'),
        'Sremska Mitrovica',
        -99);
INSERT INTO liga
VALUES (-100, 'Super Liga', 'SRB');
INSERT INTO nacionalnost
VALUES (-100, 'Serbia', 'SRB');
INSERT INTO tim
VALUES (-100,
        'Radnički',
        to_date('1914', 'yyyy'),
        'Sremska Mitrovica',
        -99);
INSERT INTO igrac
VALUES (-100,
        'Nemanja',
        'Matic',
        1,
        to_date('1.8.1988', 'dd.MM.yyyy'),
        -99,
        -99);