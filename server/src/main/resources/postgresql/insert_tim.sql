-- Insert into 'tim' table random footbal teams from EUROPE with values:
-- NEXTVAL('tim_id_req'),
-- name of footbal tim,
-- Year founded,
-- City,
-- Footbal league the team is in;
-- (e.g. INSERT INTO tim VALUES(NEXTVAL('tim_id_req'), 'FC Bayern München',  to_date('1900','yyyy'), 'Munich', 1);)
-- Language: sql
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'FC Bayern München',
        to_date('1900', 'yyyy'),
        'Munich',
        1);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'FC Barcelona',
        to_date('1899', 'yyyy'),
        'Barcelona',
        5);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Borussia Dortmund',
        to_date('1905', 'yyyy'),
        'Dortmund',
        1);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'FC Köln',
        to_date('1908', 'yyyy'),
        'Köln',
        1);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'FC Kaiserslautern',
        to_date('1913', 'yyyy'),
        'Kaiserslautern',
        1);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Juventus F.C.',
        to_date('1897', 'yyyy'),
        'Turin',
        2);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'AC Milan',
        to_date('1898', 'yyyy'),
        'Milan',
        2);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'UC Sampdoria',
        to_date('1901', 'yyyy'),
        'Sampdoria',
        2);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'SSC Napoli',
        to_date('1903', 'yyyy'),
        'Napoli',
        2);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Arsenal F.C.',
        to_date('1886', 'yyyy'),
        'London',
        3);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Manchester United F.C.',
        to_date('1887', 'yyyy'),
        'Manchester',
        3);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Liverpool F.C.',
        to_date('1888', 'yyyy'),
        'Liverpool',
        3);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Chelsea F.C.',
        to_date('1889', 'yyyy'),
        'London',
        3);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'AS Monaco FC',
        to_date('1924', 'yyyy'),
        'Monaco',
        4);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'FC Nantes',
        to_date('1929', 'yyyy'),
        'Nantes',
        4);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Stade Rennais FC',
        to_date('1931', 'yyyy'),
        'Rennes',
        4);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Paris Saint-Germain F.C.',
        to_date('1933', 'yyyy'),
        'Paris',
        4);
INSERT INTO tim
VALUES (NEXTVAL('tim_id_req'),
        'Real Madrid C.F.',
        to_date('1934', 'yyyy'),
        'Madrid',
        5);