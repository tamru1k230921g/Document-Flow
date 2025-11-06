create schema if not exists public;
/************ request_archivist ************/
create table request_archivist
(
id bigserial primary key,
owner_id        bigint not null references employee (id),
document_id     bigint not null references document  (id),
request_message varchar(255),
request_status  varchar(50) not null
);