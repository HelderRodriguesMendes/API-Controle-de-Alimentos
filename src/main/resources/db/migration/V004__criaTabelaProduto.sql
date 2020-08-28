create table produto(
	idProduto bigint not null auto_increment unique,
    TIPO varchar(40) not null,
    NOME varchar(40) not null,
    MARCA varchar(20) not null,
    VALOR bigint not null,
    DATAVALIDADE date not null,
    STATUSCONSUMO bigint not null,
    COMPRA_ID bigint not null,
    primary key(idProduto)
);