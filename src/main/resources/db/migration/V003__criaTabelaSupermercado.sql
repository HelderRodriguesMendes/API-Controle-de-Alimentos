create table supermercado(
	id bigint not null auto_increment,
    NOME varchar(40) not null,
    TELEFONE varchar(20),
    ENDERECO varchar(50),
    inativo int,
	primary key(id)
);