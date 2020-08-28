create table produto(
	id bigint not null auto_increment unique,
    TIPO varchar(40) not null,
    NOME varchar(40) not null,
    MARCA varchar(20) not null,
    VALOR bigint not null,
    DATAVALIDADE date not null,
    STATUSCONSUMO bigint not null,
    COMPRAID bigint,
    primary key(id)
);