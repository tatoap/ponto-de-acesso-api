set foreign_key_checks = 0;

delete from empresa;
delete from cidade;
delete from estado;
delete from banco_horas;
delete from movimentacao;
delete from calendario;
delete from tipo_data;
delete from ocorrencia;
delete from localidade;
delete from usuario;
delete from nivel_acesso;
delete from jornada_trabalho;
delete from categoria_usuario;

set foreign_key_checks = 1;

alter table empresa auto_increment = 1;
alter table cidade auto_increment = 1;
alter table estado auto_increment = 1;
alter table calendario auto_increment = 1;
alter table ocorrencia auto_increment = 1;
alter table jornada_trabalho auto_increment = 1;
alter table categoria_usuario auto_increment = 1;
alter table nivel_acesso auto_increment = 1;
alter table empresa auto_increment = 1;
alter table usuario auto_increment = 1;

insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Espírito Santo');
insert into estado (nome) values ('Bahia');
insert into estado (nome) values ('Ceará');
insert into estado (nome) values ('Pernambuco');
insert into estado (nome) values ('Alagoas');
insert into estado (nome) values ('Rio Grande do Norte');

insert into cidade (nome, estado_id) values ('Guarulhos', 1);
insert into cidade (nome, estado_id) values ('Campinas', 1);
insert into cidade (nome, estado_id) values ('Teófilo Otoni', 2);
insert into cidade (nome, estado_id) values ('Teixeira de Freitas', 5);

insert into empresa (descricao, cnpj, telefone, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep, endereco_cidade_id) values ('Microsoft', '22.222.222/2222-22', '11 2222-2222', 'Rua X', '25A', 'Centro', '02222-222', 1);

insert into nivel_acesso (descricao) values ('Administrador');

insert into localidade (id, nivel_acesso_id, descricao) values (1, 1, 'Sala reunião');

insert into categoria_usuario (descricao) values ('Diretor');

insert into jornada_trabalho (descricao) values ('Integral');

insert into usuario (categoria_id, nome, empresa_id, nivel_acesso_id, jornada_trabalho_id, tolerancia_atraso, hora_inicio, hora_saida) values (1, 'Renato', 1, 1, 1, 30, '09:00:00', '18:00:00'); 
