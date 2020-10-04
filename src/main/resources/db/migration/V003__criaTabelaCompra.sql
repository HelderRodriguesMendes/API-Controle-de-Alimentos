create table compra(
	id bigint not null primary key auto_increment,
    datacompra date not null,
    inativo int not null,
    supermercado varchar(30),
    valorcompra double
);