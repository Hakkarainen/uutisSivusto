

INSERT INTO EditorUser (userName, password) VALUES ('Kayttaja_a', 'pw1');
INSERT INTO EditorUser (userName, password) VALUES ('Kayttaja_b', 'pw2');
INSERT INTO EditorUser (userName, password) VALUES ('Kayttaja_c', 'pw3');
INSERT INTO EditorUser (userName, password) VALUES ('Admin_a', 'apw1');
INSERT INTO EditorUser (userName, password) VALUES ('Admin_b', 'apw2');
INSERT INTO EditorUser (userName, password) VALUES ('Admin_c', 'apw3');

INSERT INTO NewsGenre (newsGenre, editor, header) VALUES (1, 1, 'News_genre_a');
INSERT INTO NewsGenre (newsGenre, editor, header) VALUES (2, 2,'Kayttaja_b', 'News_genre_b');
INSERT INTO NewsGenre (newsGenre, editor, header) VALUES (3, 3, 'Kayttaja_c', 'News_genre_c');

INSERT INTO PieceOfNewsHeader (startedBy, genre, header, numberOfPieceOfNewsContent, started) VALUES (1, 1, 'Uutisaihe_a', 2, '2017-07-08 22:00:00.000');
INSERT INTO PieceOfNewsHeader (startedBy, genre, header, numberOfPieceOfNewsContent, started) VALUES (2, 2, 'Uutisaihe_b', 2, '2017-07-08 22:00:00.000');
INSERT INTO PieceOfNewsHeader (startedBy, genre, header, numberOfPieceOfNewsContent, started) VALUES (3, 3, 'Uutisaihe_c', 2, '2017-07-08 22:00:00.000');

INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (1, 1, 'Kayttaja_a', 'Testiuutinen 1', '2017-07-05 20:00:00.000');
INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (2, 2, 'Kayttaja_b', 'Testiuutinen 2', '2017-07-06 20:00:00.000');
INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (3, 3, 'Kayttaja_c', 'Testiuutinen 3', '2017-07-07 20:00:00.000');

INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (1, 1, 'Kayttaja_c', 'Genrelistaus', '2017-07-05 21:00:00.000');
INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (2, 2, 'Kayttaja_c', 'Uutisten aiheenmukainen listaus', '2017-07-06 21:00:00.000');
INSERT INTO PieceOfNewsContent (user, newsHeader, editor ,content, sendTime) VALUES (3, 3, 'Kayttaja_c', 'Yksittäisen aiheenmukaisen uutisen sisällön listaus', '2017-07-07 21:00:00.000');


