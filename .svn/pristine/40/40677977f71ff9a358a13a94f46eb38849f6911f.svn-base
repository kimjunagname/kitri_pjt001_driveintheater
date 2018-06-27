
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
values(movie_no_seq.nextval, '영화1', '장르1', '줄거리1', '배우1', 120);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화2', '장르2', '줄거리2', '배우2', 135);

insert into movie_info (movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime)
values(movie_no_seq.nextval, '영화3', '장르3', '줄거리3', '배우3', 135);

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