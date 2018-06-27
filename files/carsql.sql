 
/* 사용자회원정보 */
DROP TABLE USER_INFO;
  
/* 사용자회원정보 */
CREATE TABLE USER_INFO (
  USER_NO NUMBER(10) NOT NULL, /* 회원번호 */
  USER_ID VARCHAR2(30) NOT NULL, /* 아이디 */
  USER_PWD VARCHAR2(30) NOT NULL, /* 암호 */
  CARTYPE_NAME NUMBER(10) NOT NULL, /* 차종명 */
  USER_NAME VARCHAR2(30), /* 이름 */
  USER_EMAIL VARCHAR2(30), /* 이메일 */
  USER_PHONE VARCHAR2(30) /* 핸드폰 */
);

COMMENT ON TABLE USER_INFO IS '사용자회원정보';
COMMENT ON COLUMN USER_INFO.USER_NO IS '회원번호';
COMMENT ON COLUMN USER_INFO.USER_ID IS '아이디';
COMMENT ON COLUMN USER_INFO.USER_PWD IS '암호';
COMMENT ON COLUMN USER_INFO.CARTYPE_NAME IS '차종명';
COMMENT ON COLUMN USER_INFO.USER_NAME IS '이름';
COMMENT ON COLUMN USER_INFO.USER_EMAIL IS '이메일';
COMMENT ON COLUMN USER_INFO.USER_PHONE IS '핸드폰';



/*시퀀스*/
  CREATE SEQUENCE USER_INFO_SEQ 
  INCREMENT BY 1
  START WITH 1;
  
select * from USER_INFO;




/* 직원정보 */
DROP TABLE EMP_INFO 
  CASCADE CONSTRAINTS;


/* 직원정보 */
CREATE TABLE EMP_INFO (
  EMP_NO NUMBER(10) NOT NULL, /* 사원번호 */
  EMP_ID VARCHAR2(30), /* 아이디 */
  EMP_PWD VARCHAR2(30), /* 암호 */
  EMP_NAME VARCHAR2(30), /* 이름 */
  EMP_BIRTH DATE, /* 생일 */
  EMP_EMAIL VARCHAR2(30), /* 이메일 */
  EMP_PHONE VARCHAR2(30), /* 핸드폰 */
  JOB_NO NUMBER(10), /* 직책번호 */
  BRANCH_NO NUMBER(10) /* 지점번호 */
);

COMMENT ON TABLE EMP_INFO IS '직원정보';
COMMENT ON COLUMN EMP_INFO.EMP_NO IS '사원번호';
COMMENT ON COLUMN EMP_INFO.EMP_ID IS '아이디';
COMMENT ON COLUMN EMP_INFO.EMP_PWD IS '암호';
COMMENT ON COLUMN EMP_INFO.EMP_NAME IS '이름';
COMMENT ON COLUMN EMP_INFO.EMP_BIRTH IS '생일';
COMMENT ON COLUMN EMP_INFO.EMP_EMAIL IS '이메일';
COMMENT ON COLUMN EMP_INFO.EMP_PHONE IS '핸드폰';
COMMENT ON COLUMN EMP_INFO.JOB_NO IS '직책번호';
COMMENT ON COLUMN EMP_INFO.BRANCH_NO IS '지점번호';

/*시퀀스*/
  CREATE SEQUENCE EMP_INFO_SEQ 
  INCREMENT BY 1
  START WITH 1;




  
  
  
/* 지점별 상영관리 */
DROP TABLE BRANCH_MOVIES;

/* 지점 */
DROP TABLE BRANCH;

/* 영화결제  */
DROP TABLE TICKET_PAY;

  
/* 영화결제 */
CREATE TABLE TICKET_PAY (
  TICKET_PAYNO NUMBER(10) NOT NULL, /* 결제번호 */
  USER_NO VARCHAR2(30), /* 회원번호 */
  BRANCH_NO NUMBER(10), /* 지점번호 */
  MOVIE_NO NUMBER(10), /* 영화번호 */
  TICKET_PAYTOTAL NUMBER(10), /* 총결제금액 */
  TICKET_PAYCASH NUMBER(10), /* 현금결제금액 */
  TICKET_PAYMILEAGE NUMBER(10), /* 마일리지결제금액 */
  TICKET_SALCOUNT NUMBER(10), /* 예매수량 */
  TICKET_PAYDATE DATE, /* 결제일자 */
  MOVIE_PALYDATE DATE
);

COMMENT ON TABLE TICKET_PAY IS '영화결제';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYNO IS '결제번호';
COMMENT ON COLUMN TICKET_PAY.USER_NO IS '회원번호';
COMMENT ON COLUMN TICKET_PAY.BRANCH_NO IS '지점번호';
COMMENT ON COLUMN TICKET_PAY.MOVIE_NO IS '영화번호';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYTOTAL IS '총결제금액';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYCASH IS '현금결제금액';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYMILEAGE IS '마일리지결제금액';
COMMENT ON COLUMN TICKET_PAY.TICKET_SALCOUNT IS '예매수량';
COMMENT ON COLUMN TICKET_PAY.TICKET_PAYDATE IS '결제일자';
COMMENT ON COLUMN TICKET_PAY.MOVIE_PALYDATE IS '상영일';


/*시퀀스*/
  CREATE SEQUENCE TICKET_PAYNO_SEQ 
  INCREMENT BY 1
  START WITH 1;








/* 회원등급관리 */
DROP TABLE GRADE_MANAGE 
  CASCADE CONSTRAINTS;


/* 회원등급관리 */
CREATE TABLE GRADE_MANAGE (
  GRADE_LOCOUNT NUMBER(10), /* 등급별관람기준 */
  GRADE_HICOUNT NUMBER(10), /* 등급별관람기준 */
  GRADE_NAME2 VARCHAR2(30), /* 등급이름 */
  GRADE_PCT NUMBER(10,2) /* 적립률 */
);

COMMENT ON TABLE GRADE_MANAGE IS '회원등급관리';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_LOCOUNT IS '낮은등급별관람기준';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_HICOUNT IS '최고등급별관람기준';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_NAME2 IS '등급이름';
COMMENT ON COLUMN GRADE_MANAGE.GRADE_PCT IS '적립률';

select * from GRADE_MANAGE;

INSERT INTO GRADE_MANAGE values (1, 4, '일반', 0.01);
INSERT INTO GRADE_MANAGE values (5, 9, '실버', 0.05);
INSERT INTO GRADE_MANAGE values (10, 100, '골드',0.1);

SELECT USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME2
FROM USER_INFO.USER_ID


select USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME2
from USER_INFO, USER_MILEAGE, GRADE_MANAGE
where USER_INFO.USER_NO = USER_MILEAGE.USER_NO
AND USER_MILEAGE.USER_RSVCOUNT  between GRADE_MANAGE.GRADE_LOCOUNT and GRADE_MANAGE.GRADE_HICOUNT
AND USER_INFO.USER_ID = 'many';
/*id 대소문자 구분 함*/





SELECT * FROM USER_INFO;
SELECT * FROM USER_MILEAGE;

SELECT * FROM GRADE_MANAGE;

SELECT E.ENAME, D.DNAME, S.GRADE
FROM EMP E, DEPT D, SALGRADE S 
WHERE E.DEPTNO = D.DEPTNO AND E.SAL 
BETWEEN S.LOSAL AND S.HISAL; 


/* 차량관리 */
DROP TABLE CAR_MANAGE;

DELETE CAR_MANAGE WHERE cartype_no= 1;

/* 차량관리 */
CREATE TABLE CAR_MANAGE (
    CARTYPE_NO      NUMBER(10) NOT NULL, /* 차종번호 */
    CARTYPE_NAME    VARCHAR(30), /* 차종명 */
    CARTYPE_PRICE   NUMBER(10)/* 책정금액 */
);

COMMENT ON TABLE CAR_MANAGE IS '차량관리';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_NO IS '차종번호';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_NAME IS '차종명';
COMMENT ON COLUMN CAR_MANAGE.CARTYPE_PRICE IS '책정금액';


INSERT INTO car_manage values(1, '소형차', 3000);
INSERT INTO car_manage values(2, '중형차', 5000);
INSERT INTO car_manage values(3, '대형차', 7000);

commit;

select * from CAR_MANAGE;







/* 영화정보 */
DROP TABLE MOVIE_INFO;


/* 영화정보 */
CREATE TABLE MOVIE_INFO(
    MOVIE_NO        NUMBER(10) NOT NULL,/* 영화번호 */
    MOVIE_TITLE     VARCHAR2(30),/* 영화제목 */
    MOVIE_POSTER    VARCHAR2(30),/* 영화포스터 */
    MOVIE_GENRE     VARCHAR2(30),/* 장르 */
    MOVIE_STORY     VARCHAR2(50),/* 줄거리 */
    MOVIE_ACTOR     VARCHAR2(50),/* 출연진 */
    MOVIE_RUNNINGTIME   NUMBER(30)/* 런타임 */
);

CREATE SEQUENCE MOVIE_NO_SEQ 
  INCREMENT BY 1
  START WITH 1;

COMMENT ON TABLE MOVIE_INFO IS '영화정보';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_NO IS '영화번호';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_TITLE IS '영화제목';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_POSTER IS '영화포스터';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_GENRE IS '장르';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_STORY IS '줄거리';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_ACTOR IS '출연진';
COMMENT ON COLUMN MOVIE_INFO.MOVIE_RUNNINGTIME IS '런타임';


insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화1', '미스터리', '팀원이 사라졌다', '나, 사라진 팀원', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화2', '공포', '대답없는 너', '나, 답장없는 팀원', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화3', '스릴러', '카톡의 1이 사라진다', '나, 읽씹하는 팀원', 150);

commit;


CREATE TABLE BRANCH_MOVIE (
  BRANCH_NO NUMBER(10), /* 지점번호 */
  MOVIE_NO NUMBER(10), /* 영화번호 */
  MOVIE_STARTDATE DATE, /* 상영시작일 */
  MOVIE_ENDDATE DATE, /* 상영종료일 */
  MOVIE_COUNT NUMBER(10), /* 상영횟수 */
  MOVIE_START1 VARCHAR2(30), /* 시작시간1 */
  MOVIE_START2 VARCHAR2(30), /* 시작시간2 */
  MOVIE_START3 VARCHAR2(30) /* 시작시간3 */
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






/* 직원근태 */
DROP TABLE EMP_TIMEMANAGE 
  CASCADE CONSTRAINTS;


/* 직원근태 */
CREATE TABLE EMP_TIMEMANAGE (
  TIMEMNG_NO NUMBER(10), /* 근태관리번호 */
  EMP_NO NUMBER(10) NOT NULL, /* 사원번호 */
  EMP_INTIME DATE, /* 출근시간 */
  EMP_OUTTIME DATE /* 퇴근시간 */
);

COMMENT ON TABLE EMP_TIMEMANAGE IS '직원근태';
COMMENT ON COLUMN EMP_TIMEMANAGE.TIMEMNG_NO IS '근태관리번호';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_NO IS '사원번호';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_INTIME IS '출근시간';
COMMENT ON COLUMN EMP_TIMEMANAGE.EMP_OUTTIME IS '퇴근시간';






/* 마일리지 */
DROP TABLE USER_MILEAGE 
  CASCADE CONSTRAINTS;



/* 마일리지 */
CREATE TABLE USER_MILEAGE (
  USER_NO NUMBER(10) NOT NULL, /* 회원번호 */
  USER_MILEAGE NUMBER(10), /* 마일리지 */
  USER_RSVCOUNT NUMBER(10) /* 예매횟수 */
);

COMMENT ON TABLE USER_MILEAGE IS '마일리지';
COMMENT ON COLUMN USER_MILEAGE.USER_NO IS '회원번호';
COMMENT ON COLUMN USER_MILEAGE.USER_MILEAGE IS '마일리지';
COMMENT ON COLUMN USER_MILEAGE.USER_RSVCOUNT IS '예매횟수';



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
  MOVIE_NO NUMBER(10), /* 영화번호 */
  MOVIE_TITLE VARCHAR2(30), /* 영화제목 */
  MOVIE_POSTER VARCHAR2(50), /* 영화포스터 */
  MOVIE_GENRE VARCHAR2(30), /* 장르 */
  MOVIE_STORY VARCHAR2(30), /* 줄거리 */
  MOVIE_ACTOR VARCHAR2(30), /* 출연진 */
  MOVIE_RUNNINGTIME NUMBER(30) /* 런타임 */
);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화1', '미스터리', '팀원이 사라졌다', '나, 사라진 팀원', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화2', '공포', '대답없는 너', '나, 답장없는 팀원', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화3', '스릴러', '카톡의 1이 사라진다', '나, 읽씹하는 팀원', 150);

commit;

CREATE TABLE BRANCH_MOVIE (
  BRANCH_NO NUMBER(10), /* 지점번호 */
  MOVIE_NO NUMBER(10), /* 영화번호 */
  MOVIE_STARTDATE DATE, /* 상영시작일 */
  MOVIE_ENDDATE DATE, /* 상영종료일 */
  MOVIE_COUNT NUMBER(10), /* 상영횟수 */
  MOVIE_START1 VARCHAR2(30), /* 시작시간1 */
  MOVIE_START2 VARCHAR2(30), /* 시작시간2 */
  MOVIE_START3 VARCHAR2(30) /* 시작시간3 */
);

select * from branch_movie;









/* 지점 */
CREATE TABLE BRANCH (
  BRANCH_NO NUMBER(10) NOT NULL, /* 지점번호 */
  BRANCH_NAME VARCHAR2(30), /* 지점명 */
  BRANCH_CAPACITY NUMBER(10) /* 정원 */
);

COMMENT ON TABLE BRANCH IS '지점';
COMMENT ON COLUMN BRANCH.BRANCH_NO IS '지점번호';
COMMENT ON COLUMN BRANCH.BRANCH_NAME IS '지점명';
COMMENT ON COLUMN BRANCH.BRANCH_CAPACITY IS '정원';



/* 직책 */
DROP TABLE JOB 
  CASCADE CONSTRAINTS;



/* 직책 */
CREATE TABLE JOB (
  JOB_NO NUMBER(10) NOT NULL, /* 직책번호 */
  JOB_NAME VARCHAR2(20) /* 직책명 */
);

COMMENT ON TABLE JOB IS '직책';
COMMENT ON COLUMN JOB.JOB_NO IS '직책번호';
COMMENT ON COLUMN JOB.JOB_NAME IS '직책명';
