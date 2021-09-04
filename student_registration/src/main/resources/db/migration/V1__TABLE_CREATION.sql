CREATE TABLE role
(
    id serial NOT NULL,
    role_name varchar(255),
    CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE course
(
    id serial NOT NULL ,
    course_no integer,
    course_name varchar(255) ,
    course_duration integer,
    course_fee double precision,
    CONSTRAINT course_pkey PRIMARY KEY (id),
    CONSTRAINT course_course_no_key UNIQUE (course_no)
);

CREATE TABLE users
(
    id serial NOT NULL,
    date_of_birth varchar(255),
    email_id varchar(255),
    first_name varchar(255),
    gender varchar(255),
    mobile_number varchar(255),
    password varchar(255),
    second_name varchar(255),
    username varchar(255),
    course_id integer,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT uk_lt2b8ocin3hdnm9q6fm4o8xnr UNIQUE (mobile_number),
    CONSTRAINT uk_r9kvst217faqa7vgeyy51oos0 UNIQUE (email_id),
    CONSTRAINT fkj8ce5cjkm11igsffixdxexrr9 FOREIGN KEY (course_id)
        REFERENCES course (id)
);

CREATE TABLE users_roles
(
    users_id integer NOT NULL,
    roles_id integer NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (users_id, roles_id),
    CONSTRAINT fk1 FOREIGN KEY (users_id)
        REFERENCES users (id),
    CONSTRAINT fk2 FOREIGN KEY (roles_id)
        REFERENCES role (id)
);