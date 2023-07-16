CREATE TABLE endereco
(
    id          SERIAL PRIMARY KEY,
    cep         VARCHAR NOT NULL,
    logradouro  VARCHAR,
    numero      VARCHAR NOT NULL,
    complemento VARCHAR NOT NULL,
    bairro      VARCHAR,
    cidade_id   INTEGER
);