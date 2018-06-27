select * from ticket_pay;



CREATE TABLE TICKET_PAY (
	TICKET_PAYNO NUMBER(10) NOT NULL, /* ������ȣ */
	USER_NO VARCHAR2(30), /* ȸ����ȣ */
	BRANCH_NO NUMBER(10), /* ������ȣ */
	MOVIE_NO NUMBER(10), /* ��ȭ��ȣ */
	TICKET_PAYTOTAL NUMBER(10), /* �Ѱ����ݾ� */
	TICKET_PAYCASH NUMBER(10), /* ���ݰ����ݾ� */
	TICKET_PAYMILEAGE NUMBER(10), /* ���ϸ��������ݾ� */
	TICKET_SALCOUNT NUMBER(10), /* ���ż��� */
	TICKET_PAYDATE DATE /* �������� */
);

CREATE SEQUENCE TICKET_PAYNO_SEQ 
	INCREMENT BY 1
	START WITH 1;

	
	

insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 1, 20000, 19000, 1000, to_date('20180401', 'yyyymmdd'));
                
insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 1, 20000, 19000, 1000, to_date('20180501', 'yyyymmdd'));

insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 1, 20000, 19000, 1000, to_date('20180601', 'yyyymmdd'));
                
insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 1, 20000, 19000, 1000, to_date('20180701', 'yyyymmdd'));
                                                

insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 2, 120000, 119000, 1000, to_date('20180401', 'yyyymmdd'));
                
insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 2, 220000, 29000, 1000, to_date('20180501', 'yyyymmdd'));

insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 3, 420000, 419000, 1000, to_date('20180601', 'yyyymmdd'));
                
insert into ticket_pay (ticket_payno, branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage, ticket_paydate)
                values(ticket_payno_seq.nextval, 3, 420000, 419000, 1000, to_date('20180701', 'yyyymmdd'));
                                                

commit;



select sum(ticket_paytotal), sum(ticket_paycash), sum(ticket_paymileage) from ticket_pay
where ticket_paydate between to_date('20180101', 'yyyymmdd') and last_day(to_date('20181201', 'yyyymmdd'))
and branch_no = 3;


select branch_no, sum(ticket_paytotal), sum(ticket_paycash), sum(ticket_paymileage) ticket_paymileage from ticket_pay
where ticket_paydate between to_date('20180101', 'yyyymmdd') and last_day(to_date('20181201', 'yyyymmdd'))
group by branch_no
order by branch_no asc;