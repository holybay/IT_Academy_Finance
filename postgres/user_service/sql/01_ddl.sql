CREATE SCHEMA app
    AUTHORIZATION postgres;

CREATE TABLE app.users
(
id uuid,
mail character varying NOT NULL,
full_name character varying NOT NULL,
role character varying NOT NULL,
status character varying NOT NULL,
password character varying NOT NULL,
created_at TIMESTAMP(3) NOT NULL,
updated_at TIMESTAMP(3) NOT NULL,
CONSTRAINT users_pk PRIMARY KEY (id),
CONSTRAINT users_mail_unq UNIQUE(mail)
);

ALTER TABLE IF EXISTS app.users
    OWNER to postgres;