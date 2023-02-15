--liquibase formatted sql

--changeset jsanchez:1
--comment creating initial tables
create table users
(
    id         UUID         NOT NULL PRIMARY KEY,
    name       VARCHAR(55)  NOT NULL,
    email      VARCHAR (55) NOT NULL CONSTRAINT user_email_constraint UNIQUE,
    password   VARCHAR(255)  NOT NULL,
    is_active  boolean      NOT NULL,
    token      VARCHAR(255) NOT NULL,
    last_login TIMESTAMP    NOT NULL,
    created    TIMESTAMP    NOT NULL,
    modified   TIMESTAMP    NOT NULL
);


create table phone
(
    id           bigint       NOT NULL PRIMARY KEY,
    city_code    VARCHAR(15)  NOT NULL,
    country_code VARCHAR(15)  NOT NULL,
    number       VARCHAR(15)  NOT NULL,
    user_id      UUID         NOT NULL constraint pk_user references users
);

create sequence phone_seq  increment by 1;
