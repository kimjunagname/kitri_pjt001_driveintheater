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

CREATE SEQUENCE EMP_NO_SEQ 
	INCREMENT BY 1
	START WITH 1;

CREATE TABLE JOB (
	JOB_NO NUMBER(10) NOT NULL, /* ��å��ȣ */
	JOB_NAME VARCHAR2(20) /* ��å�� */
);
CREATE TABLE BRANCH (
	BRANCH_NO NUMBER(10) NOT NULL, /* ������ȣ */
	BRANCH_NAME VARCHAR2(30), /* ������ */
	BRANCH_CAPACITY NUMBER(10) /* ���� */
);

insert into job values(1, '�ְ������');
insert into job values(2, '����������');
insert into job values(3, '����');

insert into branch values(1, '����', 10);
insert into branch values(2, '��õ', 20);


commit;

select * from emp_info;
select * from emp_info where emp_id = 'test' and emp_pwd = 'test';
select * from job;
select * from branch;

select e.emp_no, e.emp_id, e.emp_pwd, e.emp_name, e.emp_birth, e.emp_email, e.emp_phone, e.job_no, j.job_name, e.branch_no, b.branch_name from emp_info e, job j, branch b where emp_id='test' and emp_pwd='test' and e.job_no = j.job_no and e.branch_no = b.branch_no;

