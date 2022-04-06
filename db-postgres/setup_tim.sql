-- Insert into 'tim' table random footbal teams from EUROPE with values:
-- NEXTVAL('tim_id_req'),
-- name of footbal tim,
-- Year founded,
-- City,
-- Footbal league the team is in;
-- (e.g. INSERT INTO tim VALUES(NEXTVAL('tim_id_req'), 'FC Bayern München',  to_date('1900','yyyy'), 'Munich', 'Bundesliga');)
-- Language: sql
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'FC Bayern München',
        to_date('1900', 'yyyy'),
        'Munich',
        'Bundesliga'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Borussia Dortmund',
        to_date('1905', 'yyyy'),
        'Dortmund',
        'Bundesliga'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'FC Köln',
        to_date('1908', 'yyyy'),
        'Köln',
        'Bundesliga'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'FC Kaiserslautern',
        to_date('1913', 'yyyy'),
        'Kaiserslautern',
        'Bundesliga'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Juventus F.C.',
        to_date('1897', 'yyyy'),
        'Turin',
        'Serie A'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'AC Milan',
        to_date('1898', 'yyyy'),
        'Milan',
        'Serie A'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'UC Sampdoria',
        to_date('1901', 'yyyy'),
        'Sampdoria',
        'Serie A'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'SSC Napoli',
        to_date('1903', 'yyyy'),
        'Napoli',
        'Serie A'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Arsenal F.C.',
        to_date('1886', 'yyyy'),
        'London',
        'Premier League'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Manchester United F.C.',
        to_date('1887', 'yyyy'),
        'Manchester',
        'Premier League'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Liverpool F.C.',
        to_date('1888', 'yyyy'),
        'Liverpool',
        'Premier League'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Chelsea F.C.',
        to_date('1889', 'yyyy'),
        'London',
        'Premier League'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Burnley F.C.',
        to_date('1893', 'yyyy'),
        'Burnley',
        'Premier League'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'AS Monaco FC',
        to_date('1924', 'yyyy'),
        'Monaco',
        'Ligue 1'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Toulouse FC',
        to_date('1928', 'yyyy'),
        'Toulouse',
        'Ligue 1'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'FC Nantes',
        to_date('1929', 'yyyy'),
        'Nantes',
        'Ligue 1'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'Stade Rennais FC',
        to_date('1931', 'yyyy'),
        'Rennes',
        'Ligue 1'
    );
INSERT INTO tim
VALUES(
        NEXTVAL('tim_id_req'),
        'FC Lorient',
        to_date('1932', 'yyyy'),
        'Lorient',
        'Ligue 1'
    );