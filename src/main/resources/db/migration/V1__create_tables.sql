-- V1__create_tables.sql

CREATE TABLE country (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    continent  VARCHAR(100) NOT NULL
);

CREATE TABLE host (
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    name        VARCHAR(100) NOT NULL,
    surname     VARCHAR(100) NOT NULL,
    country_id  BIGINT NOT NULL REFERENCES country(id)
);

CREATE TABLE accommodation (
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    name        VARCHAR(200) NOT NULL,
    category    VARCHAR(20) NOT NULL,
    condition   VARCHAR(10) NOT NULL DEFAULT 'GOOD',
    is_rented   BOOLEAN NOT NULL DEFAULT FALSE,
    num_rooms   INTEGER NOT NULL,
    host_id     BIGINT NOT NULL REFERENCES host(id)
);
