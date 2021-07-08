create table Resource_model
(
    id       serial
        constraint trade_model_pkey
            primary key,

    name varchar(255) not null,

    value float,

    time_update DATE NOT NULL DEFAULT CURRENT_DATE,
);



