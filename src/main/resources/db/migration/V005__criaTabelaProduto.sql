create table produto(
	id bigint not null auto_increment,
    TIPO varbinary(40) not null,
    NOME varbinary(40) not null,
    MARCA varbinary(20) not null,
    VALOR bigint not null,
    DATAVALIDADE date not null,
    STATUSCONSUMO bigint not null,
    COMPRA_ID bigint,
    primary key(id)
);