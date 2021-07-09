




create table User_trades
(
    id       serial
        constraint trade_model_pkey
            primary key,

    user_id_trades int,

    close_date DATE NOT NULL,

    open_date DATE NOT NULL DEFAULT CURRENT_DATE,

    gain float
        constraint user_model_email_key
            unique,


    CONSTRAINT fk_user_trade
        FOREIGN KEY(user_id_trades)
            REFERENCES user_model(id)

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