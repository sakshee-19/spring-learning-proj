CREATE TABLE IF NOT EXISTS USERS (
userid INT PRIMARY KEY auto_increment,
username VARCHAR(20),
salt VARCHAR,
password VARCHAR,
firstname VARCHAR(20),
lastname VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS MESSAGES (
message_id INT PRIMARY KEY auto_increment,
username VARCHAR NOT NULL,
message_text VARCHAR NOT NULL
);
