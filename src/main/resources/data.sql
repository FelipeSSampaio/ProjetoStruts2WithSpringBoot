/*

-- Queries para construcao da estrutura do banco (Exceto a Create Database)

-- DROP SEQUENCE public.exame_sequence;

CREATE SEQUENCE public.exame_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
    
-- DROP TABLE public.exame;

CREATE TABLE public.exame
(
    id integer NOT NULL DEFAULT nextval('exame_sequence'::regclass),
    nome_paciente character varying(40) COLLATE pg_catalog."default" NOT NULL,
    status character varying(10) COLLATE pg_catalog."default" NOT NULL
)

*/