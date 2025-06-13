/*
    시퀀스(SEQUENCE)
    - 번호를 자동으로 생성하는 객체
    - 주로 PK 값 자동 생성

    CREATE SEQUENCE 시퀀스명
    START WITH 시작값 (기본값 1) -- 생략(미지정) 시 기본값 입력
    INCREMENT BY 증가값 (기본값 1)
    MAXVALUE 최대값 (기본값 큼)
    MINVALUE 최소값 (기본값 1)
    CYCLE | NOCYCLE (기본값 NOCYCLE) -- 값 순환여부 / 최대값에서 다시 사이클을 도는 지, 끝나는 지
    CACHE | NOCACHE (기본값 CACHE 20) -- 캐시메모리 할당 여부;

    * 캐시메모리
    - 미리 발생된 값들을 생성해서 저장해두는 공간
    - 매번 호출될 때마다 새로 번호를 생성하는 게 아니라 캐시메모리 공간에 미리 생성된 값들을 가져다 쓸 수 있음 (속도가 빨라짐)
    - 접속이 해제되면 => 캐시메모리에 미리 만들어 둔 번호들은 다 날아감

    * 객체 명칭
    테이블명 : TB_
    시퀀스명 : SEQ_
    뷰명 : VW_
    트리거명 : TRG_
*/
DROP SEQUENCE SEQ_EMPID;
CREATE SEQUENCE SEQ_EMPID
    START WITH 300
    INCREMENT BY 5
    MAXVALUE 310
    NOCYCLE
    NOCACHE;

-- 현재 계정이 소유하고 있는 시퀀스들의 구조를 보고자 할 때
SELECT * FROM USER_SEQUENCES;

/*
    시퀀스명.CURRVAL : 현재 시퀀스 값(CURRENT VALUE)
    시퀀스명.NEXTVAL : 시퀀스 값에 일정값을 증가시켜서 발생된 값
                      시퀀스명.CURRVAL + INCREMENT BY 값
*/
-- CURRVAL는 한 번이라도 NEXTVAL이 수행되지 않으면 가져올 수 없음!
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
-- MAXVALUE가 초과하고 NOCYCLE인 경우 최대값 초과 요청 시 에러
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

/*
    시퀀스 변경

    ALTER SEQUENCE 시퀀스명 -
    INCREMENT BY 증가값
    MAXVALUE 최대값
    MINVALUE 최소값
    CYCLE | NOCYCLE
    CACHE | NOCACHE 바이트 크기;

    --> ALTER에서 START WITH는 변경 불가!
*/
ALTER SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

/*
    시퀀스 삭제
    DROP SEQUENCE 시퀀스명;
*/
DROP SEQUENCE SEQ_EMPID;

/*
    시퀀스명 : SEQ_TEST
    시작값 : 300
    증가값 : 1
    최대값 : 1000
    순환 없음
    캐시 사용 안함
*/
CREATE SEQUENCE SEQ_TEST
START WITH 300
INCREMENT BY 1
MAXVALUE 1000
NOCYCLE
NOCACHE;

/*
    뷰(VIEW)
    - SELECT문을 저장할 수 있는 객체
    - 가상 테이블 (실제 데이터가 담겨있는 건 아님 => 논리적인 테이블)
    - DML(INSERT, UPDATE, DELETE) 작업 가능 (단, 일부만!)

    * 사용 목적
    - 편리성 : SELECT문의 복잡도 완화
    - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우
*/
-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명 FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

SELECT * FROM VW_EMPLOYEE
WHERE 근무국가명 = '한국'; -- 컬럼명에 별칭을 지정했을 경우, 뷰에는 별칭으로 컬럼명이 저장되니 유의할 것

-- '중국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명 FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '중국';

SELECT * FROM VW_EMPLOYEE
WHERE 근무국가명 = '중국';

-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명 FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '일본';

SELECT * FROM VW_EMPLOYEE
WHERE 근무국가명 = '일본';

SELECT * FROM EMPLOYEE; -- EMP_ID, EMP_NAME, DEPT_CODE, SALARY
SELECT * FROM DEPARTMENT; -- DEPT_ID, DEPT_TITLE, LOCATION_ID
SELECT * FROM LOCATION; -- LOCAL_CODE, NATIONAL_CODE, LOCAL_NAME
SELECT * FROM NATIONAL; -- NATIONAL_CODE, NATIONAL_NAME

/*
    뷰 생성
    
    CREATE OR REPLACE [FORCE | NOFORCE] VIEW 뷰명
    AS 서브쿼리
    WITH CHECK OPTION
    WITH READ ONLY;

    * VIEW 옵션들
    - OR REPLACE : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성, 기존에 중복된 이름의 뷰가 있다면 해당 뷰 변경하는 옵션(덮어쓰기)
    - FORCE : 서브 쿼리에 기술된 테이블이 존재하지 않는 테이블이어도 뷰 생성 (강제)
    - NOFORCE : 서브 쿼리에 기술된 테이블이 존재해야만 뷰 생성 (기본값)
    - WITH CHECK OPTION : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로 수정하는 경우 오류 발생
    - WITH READ ONLY : 뷰에 대해 조회만 가능 (읽기 전용: DML 수행 불가)
*/
-- 관리자 계정으로 CREATE VIEW 권한 부여
-- 권한 부여 시에만 developer 혹은 하단 Dedicated에서 system 계정으로 변경하였다가 이후 kh로 재지정
ALTER SESSION SET CONTAINER = XEPDB1;
GRANT CREATE VIEW TO kh;

CREATE VIEW VW_EMPLOYEE
AS SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, SALARY 급여, NATIONAL_NAME 근무국가명
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE);

/*
    뷰 컬럼에 별칭을 부여해야 하는 경우
    - 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 부여!
*/
-- VIEW를 이용하여 사원의 사번, 사원명, 직급명, 성별, 근무년수 조회
-- 뷰명: VW_EMP_JOB

-- 1. 일부만 별칭 부여할 시 서브쿼리에서 지정
CREATE OR REPLACE VIEW VW_EMP_JOB AS
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_NAME 직급명,
CASE WHEN SUBSTR(EMP_NO,8,1) = 1 THEN '남' ELSE '여' END 성별, 
FLOOR((SYSDATE - HIRE_DATE)/365) 근무년수
-- EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

SELECT ROUND((SYSDATE - HIRE_DATE)/365) FROM EMPLOYEE;
SELECT FLOOR((SYSDATE - HIRE_DATE)/365) FROM EMPLOYEE;
SELECT (SYSDATE - HIRE_DATE)/365 FROM EMPLOYEE;
SELECT HIRE_DATE FROM EMPLOYEE;
SELECT EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) FROM EMPLOYEE;
SELECT * FROM VW_EMP_JOB;

-- 2. 뷰 생성 시 모든 컬럼에 별칭 부여할 경우
-- 컬럼 순서에 맞춰서 한꺼번에 지정 가능하다
CREATE OR REPLACE VIEW VW_EMP_JOB("사번", "사원명", "직급명", "성별", "근무년수")
AS SELECT EMP_ID, EMP_NAME, JOB_NAME,
CASE WHEN SUBSTR(EMP_NO,8,1) = 1 THEN '남' ELSE '여' END, 
FLOOR((SYSDATE - HIRE_DATE)/365)
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

-- 성별이 남자인 사원의 사원명, 직급명 조회
SELECT 사원명, 직급명 FROM VW_EMP_JOB
WHERE 성별='남';

-- 근무년수가 20년 이상인 사원 조회
SELECT * FROM VW_EMP_JOB
WHERE 근무년수 >= 20;

/*
    VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용 가능
    - 뷰를 통해서 조작하게 되면 실제 데이터가 담겨 있는 베이스 테이블에 반영
*/
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME FROM JOB;

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- INSERT
INSERT INTO VW_JOB VALUES('J8', '인턴'); 

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

-- DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';

/*
    DML 구문으로 VIEW 조작이 불가능한 경우
*/
-- 1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE FROM JOB;

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- INSERT
INSERT INTO VW_JOB VALUES('J8', '인턴'); -- 값의 수가 많아서 에러!
INSERT INTO VW_JOB VALUES('J8');

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바' -- JOB_NAME이 VIEW에 존재하지 않아서 에러
WHERE JOB_CODE = 'J8';

-- DELETE
DELETE FROM VW_JOB WHERE JOB_CODE = 'J8';
DELETE FROM VW_JOB WHERE JOB_NAME = '사원'; -- JOB_NAME이 VIEW에 존재하지 않아서 에러

-- 2. 뷰에 포함되지 않은 컬럼 중에서 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME FROM JOB;

SELECT * FROM VW_JOB;
SELECT * FROM JOB;
ROLLBACK;

-- INSERT
INSERT INTO VW_JOB VALUES('인턴'); -- JOB_CODE가 NOT NULL 제약조건이 있어서

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_NAME = '사원';

-- DELETE
DELETE FROM VW_JOB
WHERE JOB_NAME = '사원';

-- 3. 산술표현식 또는 함수식으로 정의된 경우
-- 뷰명: VW_EMP_SAL
-- 컬럼: EMP_ID, EMP_NAME, SALARY, 연봉

CREATE OR REPLACE VIEW VW_EMP_SAL
AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 연봉 FROM EMPLOYEE;
SELECT * FROM VW_EMP_SAL;

-- INSERT
INSERT INTO VW_EMP_SAL
VALUES(300, '최다인', 3000000, 36000000); -- 가상 열은 사용할 수 없습니다

ALTER TABLE EMPLOYEE MODIFY EMP_NO NULL;
INSERT INTO VW_EMP_SAL(EMP_ID, EMP_NAME, SALARY)
VALUES(300, '최다인', 3000000);

-- UPDATE
-- 300번 사원의 연봉을 9천6백만원으로 변경
UPDATE VW_EMP_SAL
-- SET 연봉 = 96000000 은 반영되지 않기 때문에 SALARY 값을 조정
SET SALARY = 8000000
WHERE EMP_ID = 300;

-- DELETE
DELETE FROM VW_EMP_SAL
WHERE 연봉 = 96000000; -- 삭제에는 적용이 된다.
ROLLBACK;

-- 4. 그룹함수나 GROUP BY 절을 포함하는 경우
-- 뷰명: VW_GROUPDEPT
-- 컬럼: (부서별) 급여 합계, 급여 평균

CREATE OR REPLACE VIEW VW_GROUPDEPT
AS SELECT
DEPT_CODE,
SUM(SALARY) "급여 합계",
AVG(SALARY) "급여 평균"
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * FROM VW_GROUPDEPT;

-- INSERT
INSERT INTO VW_GROUPDEPT
VALUES("D1", 1000000, 100000); -- 그룹 함수들은 이미 계산된 함수식이기 때문에 추가 불가

INSERT INTO VW_GROUPDEPT(DEPT_CODE)
VALUES("D0");

-- UPDATE
UPDATE VW_GROUPDEPT
SET "급여 합계" = 2000000
WHERE DEPT_CODE = 'D1';

-- DELETE
DELETE FROM VW_GROUPDEPT WHERE "급여 합계" = 17700000;
DELETE FROM VW_GROUPDEPT WHERE DEPT_CODE = 'D1';
-- 그룹화된 뷰의 경우 모든 명령어 처리 불가하다.

-- 5. DISTINCT 구문이 포함된 경우
CREATE OR REPLACE VIEW VW_DT_JOB
AS SELECT DISTINCT JOB_CODE FROM EMPLOYEE;

SELECT * FROM VW_DT_JOB;

-- INSERT
INSERT INTO VW_DT_JOB VALUES('J8');
-- UPDATE
UPDATE VW_DT_JOB SET JOB_CODE='J8' WHERE JOB_CODE='J7';
-- DELETE
DELETE VW_DT_JOB WHERE JOB_CODE='J1';

-- 6. JOIN을 이용해서 여러 테이블을 연결하는 경우
-- 뷰명: VW_JOINEMP
-- 컬럼: EMP_ID, EMP_NAME, DEPT_TITLE

CREATE OR REPLACE VIEW VW_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE   -- 베이스 테이블 이외 JOIN된 컬럼 값 변형은 불가
        LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

SELECT * FROM VW_JOINEMP;

-- INSERT
-- 조인 뷰에 의하여 기본 테이블 이외의 컬럼을 수정하지 못한다
INSERT INTO VW_JOINEMP VALUES(300,'문채은','총무부');
INSERT INTO VW_JOINEMP(EMP_ID, EMP_NAME) VALUES(300,'문채은');

-- UPDATE
UPDATE VW_JOINEMP
SET EMP_NAME = '간성훈'
WHERE EMP_ID = 300;

UPDATE VW_JOINEMP
SET DEPT_TITLE = '인사관리부'
WHERE EMP_ID = 300;

-- DELETE // 삭제는 처리된다
DELETE FROM VW_JOINEMP
WHERE DEPT_TITLE = '총무부';
ROLLBACK;

-- * VIEW 옵션들 *
-- FORCE : 존재하지 않아도 일단 뷰부터 생성 가능
-- NOFORCE(기본값) : 존재하는 테이블만 뷰가 생성됨
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT * FROM TEST; -- 없는 테이블을 지정하여도, 강제로 생성됨 (컴파일 오류와 함께 뷰가 생성되었습니다.)

SELECT * FROM VW_EMP;

CREATE TABLE TEST(
    TID NUMBER
);                      -- 나중에 테이블을 만들면, 기존 만들어놓은 뷰를 조회할 수 있게 된다

-- WITH CHECK OPTION : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로 수정하는 경우 오류 발생
CREATE OR REPLACE VIEW VW_EMP
AS SELECT * FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;

SELECT * FROM VW_EMP;

-- WITH CHECK OPTION이 있는 경우 해당 조건에 위배가 되어 변경 불가
-- 200번 사원의 급여를 200만원으로 변경 (옵션이 없을 땐 SALARY값이 변경되면서 VIEW에서 제외됨)
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;
ROLLBACK;

-- 200번 사원의 급여를 400만원으로 변경
UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200;
ROLLBACK;

-- WITH READ ONLY : 뷰에 대해 조회만 가능 (DML 수행불가)
CREATE OR REPLACE VIEW VW_DEPT
AS SELECT * FROM DEPARTMENT
WITH READ ONLY;

SELECT * FROM VW_DEPT;

-- WITH READ ONLY가 추가되는 순간 모두 불가능
INSERT INTO VW_DEPT VALUES('D0','개발부','L1');
UPDATE VW_DEPT SET DEPT_TITLE = '디자인부' WHERE DEPT_ID = 'D0';
DELETE FROM VW_DEPT WHERE DEPT_ID = 'D0';

/*
    INDEX
    - SQL 명령문의 처리 속도를 향상시키기 위해서 행들의 위치 정보를 가지고 있다.
    - 일반적으로 PRIMARY KEY가 INDEX값을 가지고 있다.

    * 데이터 검색 방식
    1. Table Full Scan : 테이블 데이터를 처음부터 끝까지 검색하여 원하는 데이터를 찾는 방식
    2. Index Scan : 인덱스를 통해 데이터를 찾는 방식 (속도 ↑)
*/
-- 현재 인덱스 정보 조회 명령어
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;

-- 데이터가 얼마 없으면 오라클에서 굳이 인덱스 사용해서 데이터 조회 X

SELECT * FROM USER_INFO WHERE USER_ID = 1;
SELECT * FROM USER_INFO WHERE NAME = '간성훈';

/*
    INDEX 생성
    CREATE INDEX 인덱스명
    ON 테이블명(컬럼, 컬럼, ...);
*/
CREATE INDEX IDX_USER_NAME
ON USER_INFO(NAME);

CREATE INDEX IDX_USER_ID_NAME
ON USER_INFO(USER_ID, NAME); -- 결합 인덱스 생성

-- 인덱스 삭제
DROP INDEX IDX_USER_ID_NAME;

/*
    동의어(SYNONYM)
    - 데이터베이스 객체에 별칭을 생성
    
    CREATE (PUBLIC) SYNONYM 동의어명 -- PUBLIC이 아닐 경우, 해당 계정 내에서만 사용 가능
    FOR 사용자.객체명;
*/
-- kh 계정
GRANT CREATE SYNONYM TO kh;
CREATE SYNONYM EMP
FOR EMPLOYEE;
SELECT * FROM EMP;

-- system 계정
-- 관리자 계정으로 접속해서 공개 SYNONYM 생성
CREATE PUBLIC SYNONYM DEPT FOR kh.DEPARTMENT;
GRANT SELECT ON kh.DEPARTMENT TO test;

-- test계정 / 생성하고 권한 부여
ALTER SESSION SET CONTAINER = XEPDB1;
CREATE USER test IDENTIFIED BY test;
GRANT CONNECT, RESOURCE TO test;

SELECT * FROM EMP;
SELECT * FROM DEPT;

/*
    커서(CURSOR)
    - SQL 쿼리의 결과가 여러 행일 때 처리 결과를 한 행씩 처리하는 객체

    1. 묵시적(implicit) 커서
    오라클에서 자동으로 생성되어 사용하는 커서
    PL/SQL에서 SQL문 실행 시 자동으로 만들어져서 사용

    2. 명시적(ecplicit) 커서
    사용자가 직접 선언해서 사용할 수 있는 커서

    CURSOR 커서명 IS SELECT문 

    OPEN 커서명
    FETCH 커서명 INTO 변수,...
    ...
    CLOSE 커서명;
*/
SELECT * FROM EMPLOYEE;
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

-- 1. 묵시적 커서
-- PL/SQL에서 EMP_COPY 테이블에 BONUS가 NULL인 사원의 BONUS를 0으로 수정
BEGIN
    UPDATE EMP_COPY
    SET BONUS = 0
    WHERE BONUS IS NULL;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'행 수정됨');
END;
/

-- 2. 명시적 커서
-- PL/SQL에서 급여가 300만원 이상인 사원들 출력 (사번, 사원, 급여)
DECLARE
    EID EMP_COPY.EMP_ID%TYPE;
    ENAME EMP_COPY.EMP_NAME%TYPE;
    SAL EMP_COPY.SALARY%TYPE;

    CURSOR C1 IS SELECT EMP_ID, EMP_NAME, SALARY
                FROM EMP_COPY
                WHERE SALARY >= 3000000;
BEGIN
    OPEN C1;
    LOOP
        FETCH C1 INTO EID, ENAME, SAL;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(EID||' '||ENAME||' '||SAL);
    END LOOP;
    CLOSE C1;
END;
/

-- FOR LOOP를 이용한 커서 사용
-- 1. LOOP 시작 시 자동으로 커서 OPEN
-- 2. 반복할 때마다 FETCH도 자동
-- 3. LOOP 종료 시 자동으로 커서 CLOSE // 따라서 별도 명령어 추가가 필요하지 않다.
DECLARE
    EMP EMPLOYEE%ROWTYPE;
BEGIN
    FOR EMP IN (SELECT * FROM EMPLOYEE
                WHERE SALARY >= 3000000)
    LOOP
        DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID||' '||EMP.EMP_NAME||' '||EMP.SALARY);
    END LOOP;
END;
/

/*
    프로시저(PROCEDURE)
    - PL/SQL 문을 저장하여 필요할 때마다 복잡한 구문을 다시 입력할 필요 없이 간단하게 호출

    CREATE OR REPLACE PROCEDURE 프로시저명(
        매개변수 IN|OUT 데이터타입, ...
        - IN : 사용자로부터 값을 입력받아 PROCEDURE로 전달해주는 역할
        - OUT : PROCEDURE에서 호출 환경으로 값을 전달하는 역할
    )
    IS 선언부(DECLARE 대신)
    BEGIN 실행부
    EXCEPTION 예외처리부
    END 프로시저명;
    /

    호출 시
    EXECUTE(또는 EXEC) 프로시저명(매개값, ..);

    삭제
    DROP PROCEDURE 프로시저명;
*/