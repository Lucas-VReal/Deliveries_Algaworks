create table delivery (
                         id bigint not null auto_increment,
                         taxa decimal(10,2) not null,
                         data_pedido datetime not null,
                         data_finalizacao datetime,
                         client_id bigint not null,
                         status varchar (20) not null,

                         destinatario_nome varchar(60) not null,
                         destinatario_logradouro varchar(255) not null,
                         destinatario_numero varchar(30) not null,
                         destinatario_complemento varchar(60),
                         destinatario_bairro varchar(30) not null,

                         primary key(id)
);

alter table delivery add constraint fk_delivery_cliente
  foreign key (client_id) references client (id);