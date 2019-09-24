create table cuser(
  id number(10) primary key,
  usercode varchar(20),
  password varchar(20),
  roleId number(10)
);
create sequence cuser_seq;
/*drop sequence user_seq;*/

create table student(
	id number(10) primary key,
	name varchar(20),
	sex char(2),
	age number(4),
	birth date,
	sclassId number(10)
);
create sequence student_seq;

create table result(
	id number(10) primary key,
	courseId  number(10),
	studentId number(10),
	grade number(4,1),
	time date
);
create sequence result_seq;

create table course(
	id number(10) primary key,
	name varchar(20),
	credit number(5,2)
);
create sequence course_seq;

create table teacher(
	id number(10) primary key,
	name varchar(20),
	sex  char(2),
	tel  varchar(20),
	work date
);
create sequence teacher_seq;

create table teaching(
	id number(10) primary key,
	courseId number(10),
	teacherId number(10),
	sclassId number(10),
	time date
);
create sequence teaching_seq;

create table sclass(
	id number(10) primary key,
	name varchar(20),
	address varchar(30),
	teacherId number(10)
);
create sequence sclass_seq;