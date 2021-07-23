




create table User_trades
(
    id       serial
        constraint trade_model_pkey
            primary key,

    user_id_trades int,

    close_date DATE,

    open_date DATE NOT NULL DEFAULT CURRENT_DATE,

    gain float,

    CONSTRAINT fk_user_trade
        FOREIGN KEY(user_id_trades)
            REFERENCES user_model(id)

);



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


create table dashboard_model
(
    id       serial
        constraint trade_model_pkey
            primary key,

    name varchar(255) not null,

    ressource varchar(255),

    dashboard_trade varchar(255),

    user_id int not null,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES user_model(id)
);