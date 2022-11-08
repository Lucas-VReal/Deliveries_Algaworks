create table occurrence(
    id bigint not null auto_increment,
    delivery_id bigint not null,

    descricao text not null,
    data_registro datetime not null,

    primary key(id)
);

alter table occurrence add constraint fk_ocurrence_delivery
foreign key (delivery_id) references delivery (id);