INSERT INTO User (userName, password) VALUES ('Kayttaja_a', 'pw1');
INSERT INTO User (userName, password) VALUES ('Kayttaja_b', 'pw2');
INSERT INTO User (userName, password) VALUES ('Kayttaja_c', 'pw3');
INSERT INTO User (userName, password) VALUES ('Admin_a', 'apw1');
INSERT INTO User (userName, password) VALUES ('Admin_b', 'apw2');
INSERT INTO User (userName, password) VALUES ('Admin_c', 'apw3');

INSERT INTO NewsGenre (newsGenre, header) VALUES (1, 'News_genre_a');
INSERT INTO NewsGenre (newsGenre, header) VALUES (2, 'News_genre_b');
INSERT INTO NewsGenre (newsGenre, header) VALUES (3, 'News_genre_c');

INSERT INTO PieceOfNewsHeader (header, numberOfPieceOfNewsContent, started) VALUES ( 'Uutisaihe_a', 2, '2017-07-08 22:00:00.000');
INSERT INTO PieceOfNewsHeader (header, numberOfPieceOfNewsContent, started) VALUES ( 'Uutisaihe_b', 2, '2017-07-08 22:00:00.000');
INSERT INTO PieceOfNewsHeader (header, numberOfPieceOfNewsContent, started) VALUES ( 'Uutisaihe_c', 2, '2017-07-08 22:00:00.000');

INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_a', 'Testiuutinen 1', '2017-07-05 20:00:00.000');
INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_b', 'Testiuutinen 2', '2017-07-06 20:00:00.000');
INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_c', 'Testiuutinen 3', '2017-07-07 20:00:00.000');

INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_c', 'Genrelistaus', '2017-07-05 21:00:00.000');
INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_c', 'Uutisten aiheenmukainen listaus', '2017-07-06 21:00:00.000');
INSERT INTO PieceOfNewsContent (editor ,content, sendTime) VALUES ('Kayttaja_c', 'Yksittäisen aiheenmukaisen uutisen sisällön listaus', '2017-07-07 21:00:00.000');


