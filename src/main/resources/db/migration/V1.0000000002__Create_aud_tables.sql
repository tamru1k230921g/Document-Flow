create schema if not exists aud;
/************ REVINFO TABLE ************/
create table if not exists aud.revinfo
(
    rev        bigserial not null primary key,
    revtstmp   bigint,
    auditor_id bigint references employee (id)
);

/************ EMPLOYEE_AUD ************/
create table if not exists aud.employee_aud
(
    id                  bigserial,
    created_at          timestamp,
    updated_at          timestamp,
    created_by          bigint,
    updated_by          bigint,
    username            varchar(255),
    password            varchar(255),
    email               varchar(255),
    role                varchar(50),
    rev                 bigint not null references aud.revinfo (rev),
    revtype             smallint,
    constraint employee_aud_pkey primary key (id, rev)
);

/************ DOCUMENTS_AUD ************/
create table if not exists aud.document_aud
(
    id                  bigserial,
    created_at          timestamp,
    updated_at          timestamp,
    created_by          bigint,
    updated_by          bigint,
    deleted_at          timestamp,
    deleted_by          bigint,
    document_name       varchar(255),
    file_path           varchar(500),
    description         text,
    status              varchar(50),
    document_action     varchar(50),
    owner_id            bigint,
    rev                 bigint not null references aud.revinfo (rev),
    revtype             smallint,
    constraint document_aud_pkey primary key (id, rev)
);

/************ DOCUMENT_HISTORY_AUD ************/
create table if not exists aud.document_history_aud
(
    id                  bigserial,
    created_at          timestamp,
    updated_at          timestamp,
    created_by          bigint,
    updated_by          bigint,
    document_action     varchar(50),
    time_action         timestamp,
    document_id         bigint,
    document_name       varchar(255),
    file_path           varchar(500),
    description         text,
    status              varchar(50),
    owner_id            bigint,
    rev                 bigint not null references aud.revinfo (rev),
    revtype             smallint,
    constraint document_history_aud_pkey primary key (id, rev)
);