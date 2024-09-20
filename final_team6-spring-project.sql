-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2024-09-12 21:26:21 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE
CREATE SCHEMA team6_igo;
use team6_igo;

CREATE TABLE COMMENT (
    comment_no    INTEGER NOT NULL,
    content       VARCHAR(200),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    post_post_no  INTEGER NOT NULL,
    user_user_no  INTEGER NOT NULL
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_pk PRIMARY KEY ( comment_no);
    
ALTER TABLE COMMENT
    MODIFY COLUMN comment_no INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE keyword (
    key_no        INTEGER NOT NULL,
    mbti          CHAR(4),
    key_sort       CHAR(4),
    key_location  VARCHAR(50),
    key_type      VARCHAR(50),
    mobility      VARCHAR(50),
    house         VARCHAR(50),
    post_post_no  INTEGER NOT NULL,
    user_user_no  INTEGER NOT NULL
);

ALTER TABLE keyword ADD CONSTRAINT keyword_pk PRIMARY KEY ( key_no );
ALTER TABLE keyword
    MODIFY COLUMN key_no INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE LIKES (
    like_no    INTEGER NOT NULL ,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    post_post_no  INTEGER NOT NULL,
    user_user_no  INTEGER NOT NULL
);

ALTER TABLE LIKES
    ADD CONSTRAINT like_pk PRIMARY KEY ( like_no );
    
ALTER TABLE LIKES
    MODIFY COLUMN like_no INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE location (
    location_no   INTEGER NOT NULL,
    address       VARCHAR(50),
    latitude      decimal(10, 7),
    longitude     decimal(10, 7),
    schedule_schedule_no integer
);

ALTER TABLE location ADD CONSTRAINT location_pk PRIMARY KEY ( location_no );
ALTER TABLE location
    MODIFY COLUMN location_no INTEGER NOT NULL AUTO_INCREMENT;


CREATE TABLE post (
    post_no         INTEGER NOT NULL,
    post_title           VARCHAR(50),
    content         TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    img             VARCHAR(200),
    user_user_no    INTEGER NOT NULL
);

select * 
from post p join USER u 
on p.user_user_no=u.user_no;

select * from post;

ALTER TABLE post ADD CONSTRAINT post_pk PRIMARY KEY ( post_no );
ALTER TABLE post
    MODIFY COLUMN post_no INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE schedule (
    schedule_no           INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    content               TEXT,
    post_post_no          INTEGER NOT NULL,
    user_user_no          INTEGER NOT NULL
);

ALTER TABLE schedule ADD CONSTRAINT schedule_pk PRIMARY KEY ( schedule_no );
ALTER TABLE schedule
    MODIFY COLUMN schedule_no INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE USER (
    user_no         INTEGER NOT NULL,
    name            VARCHAR(50),
    id              VARCHAR(50),
    password        VARCHAR(50),
    gender          CHAR(1),
    tel_num         VARCHAR(50),
    email           VARCHAR(50),
    birth_date      DATE,
    img             VARCHAR(200),
    user_type       INTEGER
);

ALTER TABLE USER ADD CONSTRAINT user_pk PRIMARY KEY ( user_no );
ALTER TABLE USER
    MODIFY COLUMN user_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_post_fk FOREIGN KEY ( post_post_no )
        REFERENCES post ( post_no );

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_user_fk FOREIGN KEY ( user_user_no )
        REFERENCES USER ( user_no );

ALTER TABLE keyword
    ADD CONSTRAINT keyword_post_fk FOREIGN KEY ( post_post_no )
        REFERENCES post ( post_no );

ALTER TABLE keyword
    ADD CONSTRAINT keyword_user_fk FOREIGN KEY ( user_user_no )
        REFERENCES USER ( user_no );

ALTER TABLE LIKES
    ADD CONSTRAINT like_post_fk FOREIGN KEY ( post_post_no )
        REFERENCES post ( post_no );

ALTER TABLE LIKES
    ADD CONSTRAINT like_user_fk FOREIGN KEY ( user_user_no )
        REFERENCES USER ( user_no );
        
ALTER TABLE post
    ADD CONSTRAINT post_user_fk FOREIGN KEY ( user_user_no )
        REFERENCES USER ( user_no );

ALTER TABLE location
    ADD CONSTRAINT location_schedule_fk FOREIGN KEY ( schedule_schedule_no )
        REFERENCES schedule ( schedule_no );

ALTER TABLE schedule
    ADD CONSTRAINT schedule_post_fk FOREIGN KEY ( post_post_no )
        REFERENCES post ( post_no );

ALTER TABLE schedule
    ADD CONSTRAINT schedule_user_fk FOREIGN KEY ( user_user_no )
        REFERENCES USER ( user_no );



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             1
-- ALTER TABLE                             21
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
