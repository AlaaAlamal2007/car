CREATE TABLE IF NOT EXISTS teacher(
   id bigint not null GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255),
   PRIMARY KEY(id)
);