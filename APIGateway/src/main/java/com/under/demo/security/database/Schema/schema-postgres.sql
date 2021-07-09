
select * from user_roles;
select * from user_model;

insert into user_roles (user_id, roles) values (73,'ADMIN');

create table User_roles
(
    id       serial
        primary key,
    user_id     integer not null,

    roles    varchar(255),
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES user_model(id)


);


drop table user_roles;

drop table user_model;




create table user_model
(
    id       serial
        constraint user_model_pkey
            primary key,
    name     varchar(255) not null
        constraint user_model_name_key
            unique,
    email    varchar(255)
        constraint user_model_email_key
            unique,
    password varchar(255) not null,
    capital  double precision
);

create table Resource_model
(
    id       serial
        primary key,

    name varchar(255) not null,

    value float,

    time_update DATE NOT NULL DEFAULT CURRENT_DATE
);



