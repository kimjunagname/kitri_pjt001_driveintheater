CREATE TABLE CAR_MANAGE (
    CARTYPE_NO      NUMBER(10) NOT NULL,
    CARTYPE_NAME    VARCHAR(30),
    CARTYPE_PRICE   NUMBER(10)
);

INSERT INTO car_manage values(1, '������', 3000);
INSERT INTO car_manage values(2, '������', 5000);
INSERT INTO car_manage values(3, '������', 7000);

DELETE CAR_MANAGE WHERE cartype_no= 1;

commit;