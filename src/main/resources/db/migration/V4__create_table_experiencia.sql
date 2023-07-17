CREATE TABLE experiencia
(
    id              SERIAL PRIMARY KEY,
    candidato_id    INTEGER NOT NULL,
    profissao_id    INTEGER NOT NULL,
    salario         DECIMAL NOT NULL,
    emprego_atual   BOOLEAN NOT NULL,
    dt_entrada      DATE    NOT NULL,
    dt_desligamento DATE    NOT NULL,
    regime          VARCHAR NOT NULL,
    empresa         VARCHAR NOT NULL
);