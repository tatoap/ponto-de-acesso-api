create table nivel_acesso (
	id bigint not null auto_increment,
	descricao varchar(50) not null,
	
	primary key (id)
) engine=InnoDB;

create table localidade (
	id bigint not null,
	nivel_acesso_id bigint not null,
	descricao varchar(50) not null,
	
	primary key (id, nivel_acesso_id) 
) engine=InnoDB;

create table calendario (
	id bigint not null auto_increment,
	tipo_data_id bigint not null,
	descricao varchar(20) not null,
	data datetime not null,
	
	primary key (id)
) engine=InnoDB;

create table tipo_data (
	id bigint not null auto_increment,
	descricao varchar(20) not null,
	
	primary key (id)
) engine=InnoDB;

create table ocorrencia (
	id bigint not null auto_increment,
	nome varchar(50) not null,
	descricao varchar(200) not null,
	
	primary key (id)
) engine=InnoDB;

create table jornada_trabalho (
	id bigint not null auto_increment,
	descricao varchar(20) not null,
	
	primary key (id)
) engine=InnoDB;

create table categoria_usuario (
	id bigint not null auto_increment,
	descricao varchar(50) not null,
	
	primary key (id)
) engine=InnoDB;

create table estado (
	id bigint not null auto_increment,
	nome varchar(30) not null,
	
	primary key (id)
) engine=InnoDB;

create table cidade (
	id bigint not null auto_increment,
	nome varchar(40) not null,
	estado_id bigint not null,
	
	primary key (id)
) engine=InnoDB;

create table empresa (
	id bigint not null auto_increment,
	descricao varchar(30) not null,
	cnpj varchar(18) not null unique,
	telefone varchar(12) not null,
	endereco_logradouro varchar(80) not null,
	endereco_complemento varchar(80),
	endereco_bairro varchar(60) not null,
	endereco_numero varchar(12) not null,
	endereco_cep varchar(9) not null,
	endereco_cidade_id bigint not null,
	
	primary key (id)
) engine=InnoDB;

create table usuario (
	id bigint not null auto_increment,
	nome varchar(50) not null,
	categoria_id bigint not null,
	empresa_id bigint not null,
	nivel_acesso_id bigint not null,
	jornada_trabalho_id bigint not null,
	tolerancia_atraso decimal(2) not null,
	hora_inicio time not null,
	hora_saida time not null,
	
	primary key (id)
) engine=InnoDB;

create table movimentacao (
	id bigint not null,
	usuario_id bigint not null,
	data_entrada datetime not null,
	data_saida datetime,
	periodo_permanencia decimal(10,2),
	ocorrencia_id bigint,
	data_id bigint,
	
	primary key (id, usuario_id)
) engine=InnoDB; 

create table banco_horas (
	id bigint not null,
	movimentacao_id bigint not null,
	usuario_id bigint not null,
	data_trabalhada datetime not null,
	horas_trabalhadas decimal(10,2) not null,
	saldo_horas decimal(10,2) not null,
	
	primary key (id, movimentacao_id, usuario_id)
) engine=InnoDB;

alter table localidade add constraint fk_localidade_nivel_acesso
foreign key (nivel_acesso_id) references nivel_acesso (id);

alter table calendario add constraint fk_calendario_tipo_data
foreign key (tipo_data_id) references tipo_data (id);

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table empresa add constraint fk_empresa_cidade
foreign key (endereco_cidade_id) references cidade (id);

alter table usuario add constraint fk_usuario_categoria
foreign key (categoria_id) references categoria_usuario (id);

alter table usuario add constraint fk_usuario_empresa
foreign key (empresa_id) references empresa (id);

alter table usuario add constraint fk_usuario_nivel_acesso
foreign key (nivel_acesso_id) references nivel_acesso (id);

alter table usuario add constraint fk_usuario_jornada_trabalho
foreign key (jornada_trabalho_id) references jornada_trabalho (id);

alter table movimentacao add constraint fk_movimentacao_usuario
foreign key (usuario_id) references usuario (id);

alter table movimentacao add constraint fk_movimentacao_data
foreign key (data_id) references calendario (id);

alter table banco_horas add constraint fk_banco_horas_movimentacao
foreign key (movimentacao_id) references movimentacao (id);

alter table banco_horas add constraint fk_banco_horas_usuario
foreign key (usuario_id) references usuario (id);