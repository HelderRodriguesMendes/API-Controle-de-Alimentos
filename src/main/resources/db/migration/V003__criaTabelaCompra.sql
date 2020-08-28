create table compra(
	idCompra bigint not null auto_increment unique,
	DATACOMPRA date not null,
    SUPERMERCADO varchar(40),
    TELEFONE varchar(20),
    VALORCOMPRA bigint,
    inativo int,
    primary key(idCompra)
);