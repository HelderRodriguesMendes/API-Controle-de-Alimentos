create table compra(
	id bigint not null auto_increment,
	DATACOMPRA date not null,
    SUPERMERCADO_ID bigint not null,
    VALORCOMPRA bigint,
    inativo int,
    primary key(id)
);