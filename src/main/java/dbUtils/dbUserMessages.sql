CREATE DATABASE IF NOT EXISTS 'mydb';

USE 'mydb';

CREATE TABLE 'user' (
	'idUser' int (10) DEFAULT NOT NULL,
	'name' VARCHAR2(255),
	'email' VARCHAR2(255),
	PRIMARY KEY ('idUser')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE 'message' (
	'userId' int (10) DEFAULT NOT NULL,
	'msg' VARCHAR2(255)
	CONSTRAINT 'userId' FOREIGN KEY ('userId') REFERENCES 'user'('idUser')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

private int userId;
	private String msg;