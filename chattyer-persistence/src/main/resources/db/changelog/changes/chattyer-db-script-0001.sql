SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;


CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';
SET default_table_access_method = heap;

CREATE TABLE public.chatbots
(
    id                           uuid                   NOT NULL,
    name                         character varying(255) NOT NULL,
    responses                    text,
    wit_application_access_token character varying(255) NOT NULL,
    wit_application_id           character varying(255) NOT NULL,
    space_id                     uuid                   NOT NULL,
    created_by                   character varying(255)
);

CREATE TABLE public.organizations
(
    id         uuid NOT NULL,
    name       character varying(255),
    created_by character varying(255)
);

CREATE TABLE public.roles
(
    id              uuid                   NOT NULL,
    type            character varying(255) NOT NULL,
    organization_id uuid,
    space_id        uuid,
    user_id         uuid                   NOT NULL
);

CREATE TABLE public.spaces
(
    id              uuid NOT NULL,
    name            character varying(255),
    organization_id uuid NOT NULL,
    created_by      character varying(255)
);

CREATE TABLE public.users
(
    id       uuid NOT NULL,
    password character varying(255),
    username character varying(255)
);

ALTER TABLE ONLY public.chatbots
    ADD CONSTRAINT chatbots_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.organizations
    ADD CONSTRAINT organizations_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.spaces
    ADD CONSTRAINT spaces_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.spaces
    ADD CONSTRAINT uk5a3jc8mxp6hfra3vs3gtd1nju UNIQUE (name, organization_id);

ALTER TABLE ONLY public.chatbots
    ADD CONSTRAINT ukbutbia9duv65kdrcbnoryyqyh UNIQUE (name, space_id);

ALTER TABLE ONLY public.organizations
    ADD CONSTRAINT ukp9pbw3flq9hkay8hdx3ypsldy UNIQUE (name);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.spaces
    ADD CONSTRAINT fk4mioqiotjxy1k6e1b0emk6wpc FOREIGN KEY (organization_id) REFERENCES public.organizations (id);

ALTER TABLE ONLY public.chatbots
    ADD CONSTRAINT fk6anb344i2ntbm4jrylcxeyhmt FOREIGN KEY (space_id) REFERENCES public.spaces (id);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fk97mxvrajhkq19dmvboprimeg1 FOREIGN KEY (user_id) REFERENCES public.users (id);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fkqjj9a6xa11cu9ch24cjo4a7lc FOREIGN KEY (organization_id) REFERENCES public.organizations (id);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fkrj77bg9xm2wr7hk3hddeu2dmx FOREIGN KEY (space_id) REFERENCES public.spaces (id);

-- DEFAULT GLOBAL_ADMIN USER
INSERT INTO public.users(id, username, password)
VALUES ('9fd7205e-0933-4de1-b2d8-2b67fb082c09', 'valentin.velkov',
        '$2y$10$B9mKYmwpHANSWDfvGwz31.faTfzi.SGNR7jeNlqUvQ6hThQ9RSuf6');

INSERT INTO public.roles(id, type, organization_id, space_id, user_id)
VALUES ('6a57baff-b22f-434f-9e2a-2971d82c70f6', 'GLOBAL_ADMIN', null, null, '9fd7205e-0933-4de1-b2d8-2b67fb082c09');