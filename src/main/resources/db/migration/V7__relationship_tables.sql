ALTER TABLE candidato
    ADD FOREIGN KEY (endereco_id) REFERENCES endereco (id) ON DELETE CASCADE,
    ADD FOREIGN KEY (profissao_id) REFERENCES profissao (id) ON
DELETE
CASCADE;


ALTER TABLE experiencia
    ADD FOREIGN KEY (candidato_id) REFERENCES candidato (id) ON DELETE CASCADE,
    ADD FOREIGN KEY (profissao_id) REFERENCES profissao (id) ON
DELETE
CASCADE;

ALTER TABLE endereco
    ADD FOREIGN KEY (cidade_id) REFERENCES cidade (id) ON DELETE CASCADE;
