CREATE TABLE "AUTHOR" 
( 
 "AUTHOR_ID" NUMBER(10,0) NOT NULL ENABLE,
 "AUTHOR_NAME" VARCHAR2(40 BYTE) NOT NULL ENABLE,
 PRIMARY KEY (AUTHOR_ID)
);

CREATE TABLE "BOOK" 
 ( "BOOK_ID" NUMBER(10,0) NOT NULL ENABLE, 
 "AUTHOR_ID" NUMBER(10,0) NOT NULL ENABLE, 
 "BOOK_TITLE" VARCHAR2(255 CHAR), 
 "BOOK_DESCRIPTION" VARCHAR2(255 CHAR), 
 PRIMARY KEY ("BOOK_ID"),
 CONSTRAINT fk_book FOREIGN KEY("AUTHOR_ID") REFERENCES AUTHOR("AUTHOR_ID")
 );
 
 
 CREATE SEQUENCE SEQUENCE1 START WITH 1 INCREMENT BY 1 NOCYCLE;
 

 
 create table ADDRESS (
   address_id NUMBER(19) NOT NULL,
   street VARCHAR2(30) NOT NULL,
   city  VARCHAR2(30) NOT NULL,
   country  VARCHAR2(30) NOT NULL,
   PRIMARY KEY (address_id)
);

-- Generate ID using sequence and trigger
create sequence ADDRESS_seq start with 1 increment by 1;

create or replace trigger ADDRESS_seq_tr
 before insert on ADDRESS for each row
 when (new.address_id is null)
begin
 select ADDRESS_seq.nextval into :new.address_id from dual;
end;
/
 
create table STUDENT (
   student_id NUMBER(19) NOT NULL,
   home_address_id NUMBER(19) NOT NULL,
   first_name VARCHAR2(30) NOT NULL,
   last_name  VARCHAR2(30) NOT NULL,
   section    VARCHAR2(30) NOT NULL,
   PRIMARY KEY (student_id),
   CONSTRAINT student_address FOREIGN KEY (home_address_id) REFERENCES ADDRESS ( address_id)
);

-- Generate ID using sequence and trigger
create sequence STUDENT_seq start with 1 increment by 1;

create or replace trigger STUDENT_seq_tr
 before insert on STUDENT for each row
 when (new.student_id is null)
begin
 select STUDENT_seq.nextval into :new.student_id from dual;
end;
/


create table UNIVERSITY (
   university_id NUMBER(19) NOT NULL,
   name VARCHAR2(30) NOT NULL,
   country  VARCHAR2(30) NOT NULL,
   PRIMARY KEY (university_id)
);

-- Generate ID using sequence and trigger
create sequence UNIVERSITY_seq start with 1 increment by 1;

create or replace trigger UNIVERSITY_seq_tr
 before insert on UNIVERSITY for each row
 when (new.university_id is null)
begin
 select UNIVERSITY_seq.nextval into :new.university_id from dual;
end;
/
 
create table STUDENT_INFO (
   student_id NUMBER(19) NOT NULL,
   university_id NUMBER(19) NOT NULL,
   first_name VARCHAR2(30) NOT NULL,
   last_name  VARCHAR2(30) NOT NULL,
   section    VARCHAR2(30) NOT NULL,
   PRIMARY KEY (student_id)
   --CONSTRAINT student_university FOREIGN KEY (university_id) REFERENCES UNIVERSITY (university_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Generate ID using sequence and trigger
create sequence STUDENT_seq start with 1 increment by 1;

create or replace trigger STUDENT_seq_tr
 before insert on STUDENT_INFO for each row
 when (new.student_id is null)
begin
 select STUDENT_seq.nextval into :new.student_id from dual;
end;
/
 
 --drop table BOOK;
 --drop table AUTHOR;
-- drop table ADDRESS;
-- drop table STUDENT;
 --drop table UNIVERSITY;
 
-- drop table STUDENT_INFO;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 