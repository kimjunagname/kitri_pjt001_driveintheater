 
/* �����ȸ������ */
DROP TABLE USER_INFO;
  
/* �����ȸ������ */
CREATE TABLE USER_INFO (
  USER_NO NUMBER(10) NOT NULL, /* ȸ����ȣ */
  USER_ID VARCHAR2(30) NOT NULL, /* ���̵� */
  USER_PWD VARCHAR2(30) NOT NULL, /* ��ȣ */
  CARTYPE_NAME NUMBER(10) NOT NULL, /* ������ */
  USER_NAME VARCHAR2(30), /* �̸� */
  USER_EMAIL VARCHAR2(30), /* �̸��� */
  USER_PHONE VARCHAR2(30) /* �ڵ��� */
);

COMMENT ON TABLE USER_INFO IS '�����ȸ������';
COMMENT ON COLUMN USER_INFO.USER_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN USER_INFO.USER_ID IS '���̵�';
COMMENT ON COLUMN USER_INFO.USER_PWD IS '��ȣ';
COMMENT ON COLUMN USER_INFO.CARTYPE_NAME IS '������';
COMMENT ON COLUMN USER_INFO.USER_NAME IS '�̸�';
COMMENT ON COLUMN USER_INFO.USER_EMAIL IS '�̸���';
COMMENT ON COLUMN USER_INFO.USER_PHONE IS '�ڵ���';



/*������*/
  CREATE SEQUENCE USER_INFO_SEQ 
  INCREMENT BY 1
  START WITH 1;
  
select * from USER_INFO;




/* �������� */
DROP TABLE EMP_INFO 
  CASCADE CONSTRAINTS;


/* �������� */
CREATE TABLE EMP_INFO (
  EMP_NO NUMBER(10) NOT NULL, /* �����ȣ */
  EMP_ID VARCHAR2(30), /* ���̵� */
  EMP_PWD VARCHAR2(30), /* ��ȣ */
  EMP_NAME VARCHAR2(30), /* �̸� */
  EMP_BIRTH DATE, /* ���� */
  EMP_EMAIL VARCHAR2(30), /* �̸��� */
  EMP_PHONE VARCHAR2(30), /* �ڵ��� */
  JOB_NO NUMBER(10), /* ��å��ȣ */
  BRANCH_NO NUMBER(10) /* ������ȣ */
);

COMMENT ON TABLE EMP_INFO IS '��������';
COMMENT ON COLUMN EMP_INFO.EMP_NO IS '�����ȣ';
COMMENT ON COLUMN EMP_INFO.EMP_ID IS '���̵�';
COMMENT ON COLUMN EMP_INFO.EMP_PWD IS '��ȣ';
COMMENT ON COLUMN EMP_INFO.EMP_NAME IS '�̸�';
COMMENT ON COLUMN EMP_INFO.EMP_BIRTH IS '����';
COMMENT ON COLUMN EMP_INFO.EMP_EMAIL IS '�̸���';
COMMENT ON COLUMN EMP_INFO.EMP_PHONE IS '�ڵ���';
COMMENT ON COLUMN EMP_INFO.JOB_NO IS '��å��ȣ';
COMMENT ON COLUMN EMP_INFO.BRANCH_NO IS '������ȣ';

/*������*/
  CREATE SEQUENCE EMP_INFO_SEQ 
  INCREMENT BY 1
  START WITH 1;




  
  
  
/* ������ �󿵰��� */
DROP TABLE BRANCH_MOVIES;

/* ���� */
DROP TABLE BRANCH;

/* ��ȭ����  */
DROP TABLE TICKET_PAY;

  
/* ��ȭ���� */
CREATE TABLE TICKET_PAY (
  TICKET_PAYNO NUMBER(10) NOT NULL, /* ������ȣ */
  USER_NO VARCHAR2(30), /* ȸ����ȣ */
  BRANCH_NO NUMBER(10), /* ������ȣ */
  MOVIE_NO NUMBER(10), /* ��ȭ��ȣ */
  TICKET_PAYTOTAL NUMBER(10), /* �Ѱ����ݾ� */
  TICKET_PAYCASH NUMBER(10), /* ���ݰ����ݾ� */
  TICKET_PAYMILEAGE NUMBER(10), /* ���ϸ��������ݾ� */
  TICKET_SALCOUNT NUMBER(10), /* ���ż��� */
  TICKET_PAYDATE DATE, /* �������� */
  MOVIE_PALYDATE DATE
);

COMMENT ON TABLE TICKET_PAY IS '��ȭ����';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYNO IS '������ȣ';
COMMENT ON COLUMN TICKET_PAY.USER_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN TICKET_PAY.BRANCH_NO IS '������ȣ';
COMMENT ON COLUMN TICKET_PAY.MOVIE_NO IS '��ȭ��ȣ';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYTOTAL IS '�Ѱ����ݾ�';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYCASH IS '���ݰ����ݾ�';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYMILEAGE IS '���ϸ��������ݾ�';
COMMENT ON COLUMN TICKET_PAY.TICKET_SALCOUNT IS '���ż���';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYDATE IS '��������';
COMMENT ON COLUMN TICKET_PAY.MOVIE_PALYDATE IS '����';


/*������*/
  CREATE SEQUENCE TICKET_PAYNO_SEQ 
  INCREMENT BY 1
  START WITH 1;








/* ȸ����ް��� */
DROP TABLE GRADE_MANAGE 
  CASCADE CONSTRAINTS;


/* ȸ����ް��� */
CREATE TABLE GRADE_MANAGE (
  GRADE_LOCOUNT NUMBER(10), /* ��޺��������� */
  GRADE_HICOUNT NUMBER(10), /* ��޺��������� */
  GRADE_NAME2 VARCHAR2(30), /* ����̸� */
  GRADE_PCT NUMBER(10,2) /* ������ */
);

COMMENT ON TABLE GRADE_MANAGE IS 'ȸ����ް���';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_LOCOUNT IS '������޺���������';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_HICOUNT IS '�ְ��޺���������';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_NAME2 IS '����̸�';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_PCT IS '������';

select * from GRADE_MANAGE;

INSERT INTO GRADE_MANAGE values (1, 4, '�Ϲ�', 0.01);
INSERT INTO GRADE_MANAGE values (5, 9, '�ǹ�', 0.05);
INSERT INTO GRADE_MANAGE values (10, 100, '���',0.1);

SELECT USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME2
FROM USER_INFO.USER_ID


select USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME2
from USER_INFO, USER_MILEAGE, GRADE_MANAGE
where USER_INFO.USER_NO = USER_MILEAGE.USER_NO
AND USER_MILEAGE.USER_RSVCOUNT  between GRADE_MANAGE.GRADE_LOCOUNT and GRADE_MANAGE.GRADE_HICOUNT
AND USER_INFO.USER_ID = 'many';
/*id ��ҹ��� ���� ��*/





SELECT * FROM USER_INFO;
SELECT * FROM USER_MILEAGE;

SELECT * FROM GRADE_MANAGE;

SELECT E.ENAME, D.DNAME, S.GRADE
FROM EMP E, DEPT D, SALGRADE S 
WHERE E.DEPTNO = D.DEPTNO AND E.SAL 
BETWEEN S.LOSAL AND S.HISAL; 


/* �������� */
DROP TABLE CAR_MANAGE;

DELETE CAR_MANAGE WHERE cartype_no= 1;

/* �������� */
CREATE TABLE CAR_MANAGE (
    CARTYPE_NO      NUMBER(10) NOT NULL, /* ������ȣ */
    CARTYPE_NAME    VARCHAR(30), /* ������ */
    CARTYPE_PRICE   NUMBER(10)/* å���ݾ� */
);

COMMENT ON TABLE CAR_MANAGE IS '��������';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_NO IS '������ȣ';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_NAME IS '������';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_PRICE IS 'å���ݾ�';


INSERT INTO car_manage values(1, '������', 3000);
INSERT INTO car_manage values(2, '������', 5000);
INSERT INTO car_manage values(3, '������', 7000);

commit;

select * from CAR_MANAGE;







/* ��ȭ���� */
DROP TABLE MOVIE_INFO;


/* ��ȭ���� */
CREATE TABLE MOVIE_INFO(
    MOVIE_NO        NUMBER(10) NOT NULL,/* ��ȭ��ȣ */
    MOVIE_TITLE     VARCHAR2(30),/* ��ȭ���� */
    MOVIE_POSTER    VARCHAR2(30),/* ��ȭ������ */
    MOVIE_GENRE     VARCHAR2(30),/* �帣 */
    MOVIE_STORY     VARCHAR2(50),/* �ٰŸ� */
    MOVIE_ACTOR     VARCHAR2(50),/* �⿬�� */
    MOVIE_RUNNINGTIME   NUMBER(30)/* ��Ÿ�� */
);

CREATE SEQUENCE MOVIE_NO_SEQ 
  INCREMENT BY 1
  START WITH 1;

COMMENT ON TABLE MOVIE_INFO IS '��ȭ����';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_NO IS '��ȭ��ȣ';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_TITLE IS '��ȭ����';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_POSTER IS '��ȭ������';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_GENRE IS '�帣';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_STORY IS '�ٰŸ�';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_ACTOR IS '�⿬��';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_RUNNINGTIME IS '��Ÿ��';


insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ1', '�̽��͸�', '������ �������', '��, ����� ����', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ2', '����', '������ ��', '��, ������� ����', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ3', '������', 'ī���� 1�� �������', '��, �о��ϴ� ����', 150);

commit;


CREATE TABLE BRANCH_MOVIE (
  BRANCH_NO NUMBER(10), /* ������ȣ */
  MOVIE_NO NUMBER(10), /* ��ȭ��ȣ */
  MOVIE_STARTDATE DATE, /* �󿵽����� */
  MOVIE_ENDDATE DATE, /* �������� */
  MOVIE_COUNT NUMBER(10), /* ��Ƚ�� */
  MOVIE_START1 VARCHAR2(30), /* ���۽ð�1 */
  MOVIE_START2 VARCHAR2(30), /* ���۽ð�2 */
  MOVIE_START3 VARCHAR2(30) /* ���۽ð�3 */
);

select * from branch_movie;

insert into BRANCH_MOVIE (BRANCH_NO, MOVIE_NO, MOVIE_STARTDATE, MOVIE_ENDDATE, MOVIE_COUNT, MOVIE_START1, MOVIE_START2, MOVIE_START3)
     values(BRANCH_NO_seq.nextval,        1,         SYSDATE,       SYSDATE,           1,        '08:00', '16:00', '18:00');


insert into BRANCH_MOVIE (BRANCH_NO, MOVIE_NO, MOVIE_STARTDATE, MOVIE_ENDDATE, MOVIE_COUNT, MOVIE_START1, MOVIE_START2, MOVIE_START3)
     values(BRANCH_NO_seq.nextval,        2,         SYSDATE,       SYSDATE,           2,        '08:00', '16:00', '18:00');

     
CREATE SEQUENCE BRANCH_NO_SEQ 
  INCREMENT BY 1
  START WITH 1;
  
COMMIT;






/* �������� */
DROP TABLE EMP_TIMEMANAGE 
  CASCADE CONSTRAINTS;


/* �������� */
CREATE TABLE EMP_TIMEMANAGE (
  TIMEMNG_NO NUMBER(10), /* ���°�����ȣ */
  EMP_NO NUMBER(10) NOT NULL, /* �����ȣ */
  EMP_INTIME DATE, /* ��ٽð� */
  EMP_OUTTIME DATE /* ��ٽð� */
);

COMMENT ON TABLE EMP_TIMEMANAGE IS '��������';
COMMENT ON COLUMN EMP_TIMEMANAGE.TIMEMNG_NO IS '���°�����ȣ';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_NO IS '�����ȣ';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_INTIME IS '��ٽð�';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_OUTTIME IS '��ٽð�';






/* ���ϸ��� */
DROP TABLE USER_MILEAGE 
  CASCADE CONSTRAINTS;



/* ���ϸ��� */
CREATE TABLE USER_MILEAGE (
  USER_NO NUMBER(10) NOT NULL, /* ȸ����ȣ */
  USER_MILEAGE NUMBER(10), /* ���ϸ��� */
  USER_RSVCOUNT NUMBER(10) /* ����Ƚ�� */
);

COMMENT ON TABLE USER_MILEAGE IS '���ϸ���';
COMMENT ON COLUMN USER_MILEAGE.USER_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN USER_MILEAGE.USER_MILEAGE IS '���ϸ���';
COMMENT ON COLUMN USER_MILEAGE.USER_RSVCOUNT IS '����Ƚ��';



INSERT INTO USER_MILEAGE values(2, 3000, 6);
INSERT INTO USER_MILEAGE values(3, 4000, 10);
INSERT INTO USER_MILEAGE values(4, 5000, 1);
INSERT INTO USER_MILEAGE values(22, 5000, 5);
INSERT INTO USER_MILEAGE values(21, 5000, 1);



select USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME2
from USER_INFO, USER_MILEAGE, GRADE_MANAGE
where USER_INFO.USER_NO = USER_MILEAGE.USER_NO
AND USER_MILEAGE.USER_RSVCOUNT  
between GRADE_MANAGE.GRADE_LOCOUNT and GRADE_MANAGE.GRADE_HICOUNT
and USER_INFO.USER_ID = 'many';

select * from USER_INFO;



CREATE SEQUENCE MOVIE_NO_SEQ 
  INCREMENT BY 1
  START WITH 1;

CREATE TABLE MOVIE_INFO (
  MOVIE_NO NUMBER(10), /* ��ȭ��ȣ */
  MOVIE_TITLE VARCHAR2(30), /* ��ȭ���� */
  MOVIE_POSTER VARCHAR2(50), /* ��ȭ������ */
  MOVIE_GENRE VARCHAR2(30), /* �帣 */
  MOVIE_STORY VARCHAR2(30), /* �ٰŸ� */
  MOVIE_ACTOR VARCHAR2(30), /* �⿬�� */
  MOVIE_RUNNINGTIME NUMBER(30) /* ��Ÿ�� */
);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ1', '�̽��͸�', '������ �������', '��, ����� ����', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ2', '����', '������ ��', '��, ������� ����', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ3', '������', 'ī���� 1�� �������', '��, �о��ϴ� ����', 150);

commit;

CREATE TABLE BRANCH_MOVIE (
  BRANCH_NO NUMBER(10), /* ������ȣ */
  MOVIE_NO NUMBER(10), /* ��ȭ��ȣ */
  MOVIE_STARTDATE DATE, /* �󿵽����� */
  MOVIE_ENDDATE DATE, /* �������� */
  MOVIE_COUNT NUMBER(10), /* ��Ƚ�� */
  MOVIE_START1 VARCHAR2(30), /* ���۽ð�1 */
  MOVIE_START2 VARCHAR2(30), /* ���۽ð�2 */
  MOVIE_START3 VARCHAR2(30) /* ���۽ð�3 */
);

select * from branch_movie;









/* ���� */
CREATE TABLE BRANCH (
  BRANCH_NO NUMBER(10) NOT NULL, /* ������ȣ */
  BRANCH_NAME VARCHAR2(30), /* ������ */
  BRANCH_CAPACITY NUMBER(10) /* ���� */
);

COMMENT ON TABLE BRANCH IS '����';
COMMENT ON COLUMN BRANCH.BRANCH_NO IS '������ȣ';
COMMENT ON COLUMN BRANCH.BRANCH_NAME IS '������';
COMMENT ON COLUMN BRANCH.BRANCH_CAPACITY IS '����';



/* ��å */
DROP TABLE JOB 
  CASCADE CONSTRAINTS;



/* ��å */
CREATE TABLE JOB (
  JOB_NO NUMBER(10) NOT NULL, /* ��å��ȣ */
  JOB_NAME VARCHAR2(20) /* ��å�� */
);

COMMENT ON TABLE JOB IS '��å';
COMMENT ON COLUMN JOB.JOB_NO IS '��å��ȣ';
COMMENT ON COLUMN JOB.JOB_NAME IS '��å��';
