CREATE TABLE MOVIE_INFO(
    MOVIE_NO        NUMBER(10) NOT NULL,
    MOVIE_TITLE     VARCHAR2(30),
    MOVIE_POSTER    VARCHAR2(30),
    MOVIE_GENRE     VARCHAR2(30),
    MOVIE_STORY     VARCHAR2(50),
    MOVIE_ACTOR     VARCHAR2(50),
    MOVIE_RUNNINGTIME   NUMBER(30)
);

CREATE SEQUENCE MOVIE_NO_SEQ 
	INCREMENT BY 1
	START WITH 1;
    
COMMIT;