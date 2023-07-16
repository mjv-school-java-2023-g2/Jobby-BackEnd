CREATE TABLE candidato
(
    id                        SERIAL PRIMARY KEY,
    nome                      VARCHAR(100) NOT NULL,
    cpf                       CHAR(11)     NOT NULL,
    data_nascimento           DATE,
    email                     VARCHAR      NOT NULL,
    telefone_numero           VARCHAR,
    telefone_is_whatsapp      BOOLEAN,
    telefone_tipo             VARCHAR,
    sexo                      VARCHAR,
    pretencao_salarial_minimo DECIMAL,
    pretencao_salarial_maximo DECIMAL,
    endereco_id               INTEGER,
    profissao_id              INTEGER
);

CREATE TABLE candidato_habilidades
(
    candidato_id INTEGER NOT NULL,
    habilidades   TEXT    NOT NULL,
    FOREIGN KEY (candidato_id) REFERENCES candidato (id)
);
