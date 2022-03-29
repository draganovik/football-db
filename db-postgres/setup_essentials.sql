DROP TABLE IF EXISTS liga CASCADE;
DROP TABLE IF EXISTS tim CASCADE;
DROP TABLE IF EXISTS igrac CASCADE;
DROP TABLE IF EXISTS nacionalnost CASCADE;

CREATE TABLE liga(
	id INTEGER primary key, naziv VARCHAR(100), oznaka VARCHAR(50)
);

CREATE TABLE nacionalnost(
	id INTEGER primary key, naziv VARCHAR(100), skracenica VARCHAR(50)
);

CREATE TABLE tim(
	id INTEGER primary key, naziv VARCHAR(100), osnovan DATE, sediste VARCHAR(100), liga INTEGER NOT NULL, CONSTRAINT fk_tim_liga FOREIGN KEY(liga) REFERENCES liga(id)
);

CREATE TABLE igrac(
	id INTEGER primary key, ime VARCHAR(50), prezime VARCHAR(50), broj_reg VARCHAR(50), datum_rodjenja DATE, nacionalnost INTEGER NOT NULL, tim INTEGER NOT NULL, CONSTRAINT fk_igrac_nacionalnost FOREIGN KEY(nacionalnost) REFERENCES nacionalnost(id), CONSTRAINT fk_igrac_tim FOREIGN KEY(tim) REFERENCES tim(id)
);

CREATE INDEX idx_liga_pk on liga(id);
CREATE INDEX idx_tim_pk on tim(id);
CREATE INDEX idx_nacionalnost_pk on nacionalnost(id);
CREATE INDEX idx_igrac_pk on igrac(id);

CREATE INDEX idx_igrac_fk_nacionalnost on igrac(nacionalnost);
CREATE INDEX idx_igrac_fk_tim on igrac(tim);

CREATE INDEX idx_tim_fk_liga on tim(liga);

DROP SEQUENCE liga_id_req CASCADE;
DROP SEQUENCE tim_id_req CASCADE;
DROP SEQUENCE igrac_id_req CASCADE;
DROP SEQUENCE nacionalnost_id_req CASCADE;

CREATE SEQUENCE liga_id_req
	MINVALUE 0 START WITH 1;

CREATE SEQUENCE tim_id_req
	MINVALUE 0 START WITH 1;

CREATE SEQUENCE igrac_id_req
	MINVALUE 0 START WITH 1;

CREATE SEQUENCE nacionalnost_id_req
	MINVALUE 0 START WITH 1;
