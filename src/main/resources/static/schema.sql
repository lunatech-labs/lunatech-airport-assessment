CREATE DATABASE lunatech_airport;

CREATE TABLE IF NOT EXISTS countries (
  id              INTEGER CONSTRAINT PK_COUNTRIES PRIMARY KEY,
  code            VARCHAR(10) NOT NULL,
  name            VARCHAR(255) NOT NULL,
  continent       VARCHAR(10),
  wikipedia_link  VARCHAR(255),
  keywords        VARCHAR(10),
  CONSTRAINT UNQ_CODE UNIQUE(code)
);