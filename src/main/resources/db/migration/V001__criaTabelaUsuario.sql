create table usuario(
	id bigint not null auto_increment,
	login varchar(30),
    senha varchar(30),
    
    primary key(id)
);