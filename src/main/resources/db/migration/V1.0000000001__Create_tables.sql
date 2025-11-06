create schema if not exists public;
/************ EMPLOYEE ************/
create table if not exists employee
(
    id          bigserial primary key,
    created_at  timestamp without time zone default now(),
    created_by  bigint,
    updated_at  timestamp without time zone default now(),
    updated_by  bigint,
    username    varchar(255) not null unique,
    password    varchar(255) not null,
    email       varchar(255) not null unique,
    role        varchar(50) not null
);

/************ DOCUMENTS ************/
create table if not exists document
(
    id              bigserial primary key,
    created_at      timestamp without time zone default now(),
    created_by      bigint,
    updated_at      timestamp without time zone default now(),
    updated_by      bigint,
    deleted_at      timestamp without time zone,
    deleted_by      bigint,
    document_name   varchar(255),
    file_path       varchar(500),
    description     text,
    status          varchar(50),
    document_action varchar(50),
    owner_id        bigint references employee (id)
);

/************ DOCUMENT HISTORY ************/
create table if not exists document_history
(
    id                  bigserial primary key,
    created_at          timestamp without time zone default now(),
    created_by          bigint,
    updated_at          timestamp without time zone default now(),
    updated_by          bigint,
    document_action     varchar(50),
    document_id         bigint not null references document (id),
    document_name       varchar(255),
    file_path           varchar(500),
    description         text,
    status              varchar(50),
    owner_id            bigint references employee (id)
);