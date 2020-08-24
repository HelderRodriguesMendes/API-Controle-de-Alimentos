create table compra(
	id bigint not null auto_increment,
	DATACOMPRA date not null,
    SUPERMECADO_ID bigint not null,
    VALORCOMPRA bigint,
    primary key(id)
);