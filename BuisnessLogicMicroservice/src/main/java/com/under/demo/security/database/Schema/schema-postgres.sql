






create table trade_model
(
    id       serial
        constraint trade_model_pkey
            primary key,

    close_date DATE NOT NULL,

    open_date DATE NOT NULL DEFAULT CURRENT_DATE,

    gain float
        constraint user_model_email_key
            unique,

    dashboard_id int not null,
    CONSTRAINT fk_dashboard
        FOREIGN KEY(dashboard_id)
            REFERENCES dashboard_model(id)
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