create table cliente (
	id bigint not null auto_increment,
    nome varchar(60) not null,
	rg varchar(10) not null,
	cpf varchar(11) not null,
	endereco varchar(255) not null,
	data_nascimento varchar(10) not null,
	profissao varchar(50) not null,
	tel_fixo varchar(20) null,
	celular varchar(20) null,
	is_celular_zap varchar(1) null,
    email varchar(255) not null,

    
    primary key(id)
);