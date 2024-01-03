CREATE TABLE IF NOT EXISTS subject(
   id bigint not null GENERATED ALWAYS AS IDENTITY,
   subject_name VARCHAR(255),
  marks_obtained bigint ,
   PRIMARY KEY(id)

)