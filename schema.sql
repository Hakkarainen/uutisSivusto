--DROP TABLE User;
--DROP TABLE NewsGenre;
--DROP TABLE PieceOfNewsHeader;
--DROP TABLE PieceOfNewsContent;

CREATE TABLE EditorUser
(
    id  INT auto_increment primary key,
    userName VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(20) DEFAULT NULL
    --admin BOOLEAN DEFAULT 0);
  );

CREATE TABLE NewsGenre
(
    id INT auto_increment primary key,
    newsGenre INT, 
    editor INT,
    header VARCHAR(100) NOT NULL UNIQUE,

    FOREIGN KEY(editor) REFERENCES EditorUser(id),
  );

CREATE TABLE PieceOfNewsHeader
(
    id INT auto_increment primary key,
    startedBy INT,
    genre INT,
    header VARCHAR(100) NOT NULL UNIQUE,
    numberOfPieceOfNewsContent INT NOT NULL,
    started TIMESTAMP NOT NULL,

    FOREIGN KEY(startedBy) REFERENCES EditorUser(id),
    FOREIGN KEY(genre) REFERENCES NewsGenre(id)
  );

CREATE TABLE PieceOfNewsContent
(
    id INT auto_increment primary key,
    editorID INT,
    newsHeader INT,
    editor VARCHAR(30) NOT NULL,
    content VARCHAR(500) NOT NULL,
    sendTime TIMESTAMP NOT NULL,

    FOREIGN KEY(newsHeader) REFERENCES PieceOfNewsHeader(id)
  );

CREATE VIEW NewsGenreList AS
SELECT g.id, g.header, COUNT(c.id) as amount, MAX(c.sendTime) AS latest
FROM NewsGenre g
LEFT JOIN PieceOfNewsHeader p ON (g.id = p.genre)
LEFT JOIN PieceOfNewsContent c ON (p.id = c.newsHeader)
GROUP by g.id, g.header;

CREATE VIEW PieceOfNewsList AS
SELECT p.id, p.startedBy, p.genre, p.header,
COUNT(*) AS amount, MIN(c.sendTime) AS started,
MAX(c.sendTime) AS latest
FROM PieceOfNewsHeader p
LEFT JOIN PieceOfNewsContent c ON (p.id = c.newsHeader)
GROUP BY p.id, p.header, p.startedBy, p.genre
ORDER BY MAX(c.sendTime) DESC;
