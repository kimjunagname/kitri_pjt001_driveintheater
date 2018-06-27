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

CREATE SEQUENCE EMP_NO_SEQ 
	INCREMENT BY 1
	START WITH 1;

CREATE TABLE JOB (
	JOB_NO NUMBER(10) NOT NULL, /* 직책번호 */
	JOB_NAME VARCHAR2(20) /* 직책명 */
);
CREATE TABLE BRANCH (
	BRANCH_NO NUMBER(10) NOT NULL, /* 지점번호 */
	BRANCH_NAME VARCHAR2(30), /* 지점명 */
	BRANCH_CAPACITY NUMBER(10) /* 정원 */
);

insert into job values(1, '최고관리자');
insert into job values(2, '지점관리자');
insert into job values(3, '직원');

insert into branch values(1, '서울', 10);
insert into branch values(2, '인천', 20);


commit;

select * from emp_info;
select * from emp_info where emp_id = 'test' and emp_pwd = 'test';
select * from job;
select * from branch;

select e.emp_no, e.emp_id, e.emp_pwd, e.emp_name, e.emp_birth, e.emp_email, e.emp_phone, e.job_no, j.job_name, e.branch_no, b.branch_name from emp_info e, job j, branch b where emp_id='test' and emp_pwd='test' and e.job_no = j.job_no and e.branch_no = b.branch_no;

