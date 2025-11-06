/************ALTER COLUMN in request_archivist ************/
create schema if not exists public;
ALTER TABLE request_archivist
ADD COLUMN created_at timestamp without time zone DEFAULT now(),
ADD COLUMN created_by bigint,
ADD COLUMN updated_at timestamp without time zone DEFAULT now(),
ADD COLUMN updated_by bigint;

/************ CREAETE TABLE request_archivist_aud ************/
create schema if not exists aud;
CREATE TABLE request_archivist_audit
(
    id bigserial PRIMARY KEY,
    request_archivist_id bigint NOT NULL REFERENCES request_archivist(id),
    action varchar(50) NOT NULL, -- например: INSERT, UPDATE, DELETE
    created_at timestamp without time zone DEFAULT now(),
    created_by bigint,
    updated_at timestamp without time zone DEFAULT now(),
    updated_by bigint,
    details text -- сюда можно записывать изменения или комментарии
);
