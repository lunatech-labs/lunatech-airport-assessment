CREATE DATABASE lunatech_airport;

CREATE TABLE IF NOT EXISTS countries (
  id              INTEGER CONSTRAINT PK_COUNTRIES PRIMARY KEY,
  code            VARCHAR(10) NOT NULL,
  name            VARCHAR(255) NOT NULL,
  continent       VARCHAR(10),
  wikipedia_link  VARCHAR(255),
  keywords        VARCHAR(100),
  CONSTRAINT UNQ_CODE UNIQUE(code),
  CONSTRAINT UNQ_NAME UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS airports (
  id                    INTEGER CONSTRAINT PK_AIRPORTS PRIMARY KEY,
  ident                 VARCHAR(10),
  type                  VARCHAR(100),
  name                  VARCHAR(255) NOT NULL,
  latitude_deg          FLOAT8,
  longitude_deg         FLOAT8,
  elevation_ft          INTEGER,
  continent             VARCHAR(10),
  iso_country           VARCHAR(10),
  iso_region            VARCHAR(10),
  municipality          VARCHAR(100),
  scheduled_service     VARCHAR(100),
  gps_code              VARCHAR(100),
  iata_code             VARCHAR(100),
  local_code            VARCHAR(100),
  home_link             VARCHAR(255),
  wikipedia_link        VARCHAR(255),
  keywords              VARCHAR(255),
  FOREIGN KEY (iso_country) REFERENCES countries(code)
);

CREATE TABLE IF NOT EXISTS runways (
  id                        INTEGER CONSTRAINT PK_RUNWAYS PRIMARY KEY,
  airport_ref               INTEGER,
  airport_ident             VARCHAR(100),
  length_ft                 INTEGER,
  width_ft                  INTEGER,
  surface                   VARCHAR(100),
  lighted                   BOOL,
  closed                    BOOL,
  le_ident                  VARCHAR(10),
  le_latitude_deg           FLOAT8,
  le_longitude_deg          FLOAT8,
  le_elevation_ft           INTEGER,
  le_heading_degT           FLOAT8,
  le_displaced_threshold_ft INTEGER,
  he_ident                  VARCHAR(100),
  he_latitude_deg           FLOAT8,
  he_longitude_deg          FLOAT8,
  he_elevation_ft           INTEGER,
  he_heading_degT           FLOAT8,
  he_displaced_threshold_ft INTEGER,
  FOREIGN KEY (airport_ref) REFERENCES airports(id)
);
