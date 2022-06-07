CREATE TABLE IF NOT EXISTS espm.cotacao (
	id_cotacao varchar(64) not null,
	id_moeda varchar(64) NOT NULL,
    dt_data date not null,
    vr_valor decimal(14,4),
    primary key pk_cotacao (id_cotacao)
);