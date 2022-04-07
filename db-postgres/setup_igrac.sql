-- Insert into table 'igrac' player from leagues in db-postgres/setup_liga.sql, don't repeat same players from db-postgres/setup_igrac.sql
-- values: id, name, surname, number, date of birth, country code, team name;
-- Language: sql
-- Example: INSERT INTO igrac (NEXTVAL('liga_id_req'), 'Robert', 'Lewandowski', NEXTVAL('player_code'),  to_date('21.8.1988.','dd.MM.yyyy'), 'DEU', 'FC Bayern München');
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Robert',
		'Lewandowski',
		NEXTVAL('player_code'),
		to_date('21.8.1988', 'dd.MM.yyyy'),
		'DEU',
		'FC Bayern München'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Lionel',
		'Messi',
		NEXTVAL('player_code'),
		to_date('24.6.1987', 'dd.MM.yyyy'),
		'ARG',
		'FC Barcelona'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Cristiano',
		'Ronaldo',
		NEXTVAL('player_code'),
		to_date('5.2.1985', 'dd.MM.yyyy'),
		'PRT',
		'Juventus F.C.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Luka',
		'Modric',
		NEXTVAL('player_code'),
		to_date('9.9.1985', 'dd.MM.yyyy'),
		'CRO',
		'Real Madrid'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Neymar',
		'Jr',
		NEXTVAL('player_code'),
		to_date('5.2.1992', 'dd.MM.yyyy'),
		'BRA',
		'Paris Saint-Germain'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Sergio',
		'Ramos',
		NEXTVAL('player_code'),
		to_date('16.7.1989', 'dd.MM.yyyy'),
		'ESP',
		'FC Barcelona'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Gareth',
		'Bale',
		NEXTVAL('player_code'),
		to_date('24.6.1986', 'dd.MM.yyyy'),
		'GBR',
		'Real Madrid C.F.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Paul',
		'Pogba',
		NEXTVAL('player_code'),
		to_date('15.3.1993', 'dd.MM.yyyy'),
		'FRA',
		'Manchester United F.C.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Mohamed',
		'Salah',
		NEXTVAL('player_code'),
		to_date('24.6.1986', 'dd.MM.yyyy'),
		'EGY',
		'Liverpool'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Nemanja',
		'Matic',
		NEXTVAL('player_code'),
		to_date('1.8.1988', 'dd.MM.yyyy'),
		'SRB',
		'Manchester United F.C.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Gianluigi',
		'Buffon',
		NEXTVAL('player_code'),
		to_date('28.1.1978', 'dd.MM.yyyy'),
		'ITA',
		'Juventus F.C.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Eden',
		'Hazard',
		NEXTVAL('player_code'),
		to_date('7.1.1991', 'dd.MM.yyyy'),
		'BEL',
		'Real Madrid C.F.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Cesc',
		'Fàbregas',
		NEXTVAL('player_code'),
		to_date('4.5.1987', 'dd.MM.yyyy'),
		'ESP',
		'AS Monaco FC'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Mesut',
		'Ozil',
		NEXTVAL('player_code'),
		to_date('15.10.1988', 'dd.MM.yyyy'),
		'GER',
		'FC Bayern München'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Alex',
		'Griezmann',
		NEXTVAL('player_code'),
		to_date('21.3.1991', 'dd.MM.yyyy'),
		'FRA',
		'Paris Saint-Germain'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Ousmane',
		'Dembele',
		NEXTVAL('player_code'),
		to_date('15.5.1997', 'dd.MM.yyyy'),
		'FRA',
		'FC Barcelona'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Paulo',
		'Dybala',
		NEXTVAL('player_code'),
		to_date('21.8.1993', 'dd.MM.yyyy'),
		'ESP',
		'Juventus F.C.'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Robert',
		'Lewandowski',
		NEXTVAL('player_code'),
		to_date('21.8.1988', 'dd.MM.yyyy'),
		'POL',
		'FC Bayern München'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Daniel',
		'Hanslik',
		NEXTVAL('player_code'),
		to_date('6.10.1988', 'dd.MM.yyyy'),
		'DEU',
		'FC Kaiserslautern'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Terrence',
		'Boyd',
		NEXTVAL('player_code'),
		to_date('16.2.1991', 'dd.MM.yyyy'),
		'USA',
		'FC Kaiserslautern'
	);
INSERT INTO igrac (
		NEXTVAL('liga_id_req'),
		'Erling',
		'Haaaland',
		NEXTVAL('player_code'),
		to_date('16.2.1991', 'dd.MM.yyyy'),
		'GBR',
		'Borussia Dortmund'
	);