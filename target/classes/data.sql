INSERT INTO User (userName, password) VALUES ('Kayttaja_a', 'pw1');
INSERT INTO User (userName, password) VALUES ('Kayttaja_b', 'pw2');
INSERT INTO User (userName, password) VALUES ('Kayttaja_c', 'pw3');
INSERT INTO User (userName, password) VALUES ('Admin_a', 'apw1');
INSERT INTO User (userName, password) VALUES ('Admin_b', 'apw2');
INSERT INTO User (userName, password) VALUES ('Admin_c', 'apw3');

INSERT INTO NewsGenre (genre, editor, header) VALUES (1, 4, 'News_genre_a');
INSERT INTO NewsGenre (genre, editor, header) VALUES (2, 5, 'News_genre_b');
INSERT INTO NewsGenre (genre, editor, header) VALUES (3, 6, 'News_genre_c');

INSERT INTO PieceOfNewsHeader (header, startedBy, numberOfPieceOfNewsContent, started, genre) VALUES ( 'Uutisaihe_a',1, 2, '2017-07-08 22:00:00.000',1);
INSERT INTO PieceOfNewsHeader (header, startedBy, numberOfPieceOfNewsContent, started, genre) VALUES ( 'Uutisaihe_b',2, 2, '2017-07-08 22:00:00.000',2);
INSERT INTO PieceOfNewsHeader (header, startedBy, numberOfPieceOfNewsContent, started, genre) VALUES ( 'Uutisaihe_c',3, 2, '2017-07-08 22:00:00.000',3);

INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (2, 1, 'Kayttaja_a', 'Testiuutinen 1', '2017-07-05 20:00:00.000');
INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (3, 2, 'Kayttaja_b', 'Testiuutinen 2', '2017-07-06 20:00:00.000');
INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (1, 3, 'Kayttaja_c', 'Testiuutinen 3', '2017-07-07 20:00:00.000');

INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (2, 1, 'Kayttaja_c', 'Genrelistaus', '2017-07-05 21:00:00.000');
INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (3, 1, 'Kayttaja_c', 'Uutisten aiheenmukainen listaus', '2017-07-06 21:00:00.000');
INSERT INTO PieceOfNewsContent (editorID, newsHeader, editor , content, sendTime) VALUES (1, 1, 'Kayttaja_c', 'Yksittäisen aiheenmukaisen uutisen sisällön listaus', '2017-07-07 21:00:00.000');


