CREATE TABLE ticket_pay(
    ticket_payno        number(10) NOT NULL,
    user_no             number(10),
    branch_no           number(10),
    movie_no            number(10),
    ticket_paytotal     number(10),
    ticket_paycash      number(10),
    movie_palydate       date,
    ticket_paymileage   number(10),
    ticket_salcount     number(10),
    ticket_paydate      date
);

drop table ticket_pay;

select * from ticket_pay;

commit;

SELECT u.user_no
FROM user_info u, ticket_pay t
WHERE u.user_no= t.user_no AND u.user_name= '';

INSERT INTO ticket_pay(ticket_payno, user_no, branch_no, movie_no, ticket_paytotal, ticket_paycash, movie_palydate, 
            ticket_paymileage, ticket_salcount, ticket_paydate) 
            VALUES(1, 1, 1, 1, 100, 30, sysdate, 70, 1, sysdate);
            
SELECT * FROM ticket_pay;

CREATE SEQUENCE TICKET_PAYNO_SEQ 
INCREMENT BY 1
START WITH 1;