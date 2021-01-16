-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
	id integer NOT NULL DEFAULT nextval('person_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;