
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
values(movie_no_seq.nextval, '��ȭ1', '�帣1', '�ٰŸ�1', '���1', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ2', '�帣2', '�ٰŸ�2', '���2', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '��ȭ3', '�帣3', '�ٰŸ�3', '���3', 135);

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