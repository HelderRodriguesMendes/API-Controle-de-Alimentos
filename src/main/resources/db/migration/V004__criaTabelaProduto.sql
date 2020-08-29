create table produto(
	id bigint not null primary key auto_increment,
    datavalidade date not null,
    marca varchar(25) not null,
    nome varchar(40) not null,
    statusconsumo bigint not null,
    tipo varchar(20) not null,
    valor int not null,
    compraid bigint,
    FOREIGN KEY(compraid) REFERENCES compra(id)
);