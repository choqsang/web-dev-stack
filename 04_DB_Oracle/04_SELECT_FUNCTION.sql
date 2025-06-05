/*
    함수 : 컬럼값을 읽어서 가공된 값을 반환

    - 단일행 함수 : N개의 값을 받아서 N개의 결과를 반환한다.
    - 그룹 함수 : N개의 값을 받아서 '1개'의 결과를 반환한다.

    >> 단일행 함수와 그룹 함수는 SELECT 절에서 함께 사용할 수 없음!
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/
-- 단일행 함수
/*
    문자 처리 함수
    
    LENGTH : 문자 수 반환
    - 한글 1글자 => 1
    - 영문/숫자/특수문자 => 1

    LENGTHB : 바이트(BYTE) 수 반환
    - 한글 1글자 => 3
    - 영문/숫자/특수문자 => 1
*/
SELECT
    LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
    LENGTH('DATABASE'), LENGTHB('DATABASE')
FROM DUAL;  -- 가상 테이블을 뜻한다.

/*
    INSTR(컬럼, 찾을 문자, 시작 위치, 몇 번째) 
    - 특정 문자가 몇 번째 위치하는 지 반환 (= Js의 indexOf 같은 기능)
    - 없으면 0 반환
    - 시작 위치 : 1 (앞에서부터), -1 (뒤에서부터)
*/
SELECT
    INSTR('AABAACAABBAA', 'B', -1, 2), -- 뒤에서부터 2번째에 위치한 B(를 앞에서부터 카운트했을 때) 인덱스값 반환됨.
    INSTR('AABAACAABBAA', 'D')
FROM DUAL;

-- USER_INFO에서 각 전화번호(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
SELECT CONTACT, INSTR(CONTACT,'5') FROM USER_INFO;

-- EMPLOYEE에서 's'가 포함되어 있는 이메일 중 @ 위치 조회
SELECT EMAIL,
INSTR(EMAIL,'@')
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%';

/*
    LPAD / RPAD(컬럼 혹은 문자열, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
    - 문자열을 조회 시 통일감 있게 조회하고자 할 때 사용한다.
*/
SELECT  -- 덧붙일 문자가 없을 경우 공백으로 차지함(띄어쓰기)
    LPAD('HELLO', 10), LPAD('HELLO',10,'A'),
    RPAD('HELLO', 10), RPAD('HELLO',10,'A')
FROM DUAL;  

/*
    LTRIM / RTRIM(컬럼, 제거하고자 하는 문자들)
    - 문자열에서 특정 문자를 제거한 나머지를 반환
*/
SELECT
    LTRIM('    KH    '), -- 왼쪽 공백 제거
    LTRIM('ACBAACCCKH', 'ABC'), -- 왼쪽에서 ABC에 해당하는 문자들 제거
    RTRIM('46548518KH54568', '0123456789') -- 오른쪽에서 해당하는 숫자들을 제거
FROM DUAL;

/*
    TRIM(LEADING|TRAILING|BOTH '제거하고자 하는 문자들' FROM 컬럼)
    - 문자열의 양쪽(앞/뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT
    TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'), -- LTRIM
    TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'), -- RTRIM
    TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'), -- 양쪽 모두 제거
    TRIM('          KH          ')
FROM DUAL;

/*
    SUBSTR(컬럼, 시작 위치, 추출 길이)
    - 문자열에서 특정 부분을 잘라서 추출
*/
SELECT
    SUBSTR('PROGRAMMING', 5, 2), -- RA
    SUBSTR('PROGRAMMING', 1, 6), -- PROGRA
    SUBSTR('PROGRAMMING', -8, 3) -- GRA // 시작점이 마이너스인 경우, 뒤에서부터 카운트한다.
FROM DUAL;

-- USER_INFO에서 전화번호(CONTACT)에서 가운데 번호 4자리만 조회
SELECT CONTACT, SUBSTR(CONTACT,5,4),
SUBSTR(CONTACT,INSTR(CONTACT,'-')+1,4) "중간번호"
FROM USER_INFO;

-- EMPLOYEE에서 이메일에서 아이디만(@ 앞에) 조회
-- SELECT EMAIL, RTRIM(EMAIL,SUBSTR(EMAIL,INSTR(EMAIL,'@'),20)) AS "아이디"
SELECT EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) "EMAIL ID"
FROM EMPLOYEE;

-- 주민등록번호(EMP_NO)를 000000-0******로 치환하여 조회
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')+1),LENGTH(EMP_NO),'*') AS "주민등록번호"
-- 문자열 추출 이후 패드가 아닌 연결연산자 ||'******' 을 연결하여도 무방하다.
FROM EMPLOYEE;

-- 남자 사원들만 조회
SELECT EMP_NAME, EMP_NO -- INSTR(EMP_NO,'-')+1 = 8고정
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,INSTR(EMP_NO,'-')+1,1) = 1; -- OR ='1';

/*
    LOWER : 다 소문자로 변경
    UPPER : 다 대문자로 변경
*/
SELECT LOWER('Welcome'), UPPER('Welcome')
FROM DUAL;

/*
    CONCAT(문자열, 문자열)
    - 문자열 두(2) 개를 전달받아 하나로 합친 후 결과 반환
*/
-- 가나다라, 1234를 합치기
SELECT CONCAT('가나다라', '1234') FROM DUAL;
SELECT '가나다라'||'1234' FROM DUAL;
-- 가나다라, ABCD, 1234를 합치기
SELECT CONCAT(CONCAT('가나다라','ABCD'),'1234') FROM DUAL;
SELECT '가나다라'||'ABCD'||'1234' FROM DUAL;

/*
    REPLACE(컬럼, 바꾸고 싶은 문자열, 바꿀 문자열)
    - 특정 문자열로 변경
*/
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;

    -- USER_INFO에서 서울이신 분들을 모두 경기로 바꾸기
SELECT NAME, ADDRESS, REPLACE(ADDRESS,'서울','경기') "변경된 주소" FROM USER_INFO;

-- EMPLOYEE에서 사원들의 이메일 kh.or.kr을 gmail.com으로 바꾸기
SELECT EMP_NAME, EMAIL, REPLACE(EMAIL,'kh.or.kr','gmail.com') "변경된 이메일" FROM EMPLOYEE;

-- EMPLOYEE에서 이메일에서 아이디만(@ 앞에) 조회 (REPLACE 활용)
SELECT EMP_NAME, EMAIL, REPLACE(EMAIL,'@kh.or.kr',''),
REPLACE(EMAIL,SUBSTR(EMAIL, INSTR(EMAIL,'@'),LENGTH(EMAIL)),'') "이메일 아이디" FROM EMPLOYEE;

-- 주민등록번호(EMP_NO)를 000000-0******로 치환하여 조회 (REPLACE 활용)
SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, -6, 6), '******'),
REPLACE(EMP_NO,SUBSTR(EMP_NO,INSTR(EMP_NO,'-')+2,6),'******') "주민등록번호" FROM EMPLOYEE;

/*
    숫자 처리 함수

    ABS : 절대값 반환
    MOD(숫자, 숫자) : 두 수를 나눈 나머지 값 반환
    CEIL : 올림
    FLOOR : 내림
    
*/
SELECT ABS(5.7), ABS(-10), 
MOD(10,3), -- 1
CEIL(123.152), FLOOR(123.952)
FROM DUAL;

/*
    ROUND(숫자, 위치) : 반올림한 결과 반환 (위치는 소숫점 기준 이동)
    TRUNC(숫자, 위치) : 위치 지정하여 버림 처리
*/
SELECT
ROUND(123.456), -- 123 (위치 생략 시 0)
ROUND(123.456,1), -- 123.5 (소숫점 첫 째자리까지)
ROUND(123.456,-2), -- 100 (100의 자리까지)
TRUNC(123.952), -- 123
TRUNC(123.952,1) -- 123.9
FROM DUAL;

/*
    날짜 처리 함수
    SYSDATE : 시스템의 날짜를 반환 (현재 날짜 표시)
*/
SELECT SYSDATE FROM DUAL; -- 기본값 일/월/년도

-- 날짜 포맷 변경 (세션 변경 시 위 데이터 표시형태가 변경된다.)
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YY'; -- 원래 포맷

/*
    MONTHS_BETWEEN(날짜, 날짜)
    - 입력받은 두 날짜 사이의 개월 수 반환
*/

SELECT FLOOR(MONTHS_BETWEEN('20251216', SYSDATE)) FROM DUAL;

-- USER INFO에서 출생 이후 몇 개월 지났는 지 조회 (BIRTHDATE)
SELECT NAME, BIRTHDATE, ABS(FLOOR(MONTHS_BETWEEN(BIRTHDATE, SYSDATE)))||'개월 경과' AS 출생
FROM USER_INFO;

/*
    ADD_MONTHS(날짜, 숫자)
    - 특정 날짜에 입력받는 숫자만큼 개월 수를 더한 날짜 반환
*/
SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;

-- USER_INFO에서 태어난 날짜로부터 20년이 지난 시점 조회
SELECT NAME, BIRTHDATE, ADD_MONTHS(BIRTHDATE, 12*20) FROM USER_INFO;

/*
    NEXT_DAY(날짜, 요일(문자/숫자))
    - 특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    - 요일 : 1(일요일), 2(월요일), 3(화요일), ... , 7(토요일)
*/
SELECT SYSDATE, NEXT_DAY(SYSDATE,'MON') FROM DUAL; -- 기본값에서 한글로는 요일명 인식 불가 (영어는 3글자 이상 SPELL 모두 인식함 'TUES,THURSD,SUNDA,...')
SELECT SYSDATE, NEXT_DAY(SYSDATE,'월요일') FROM DUAL; -- '월, 월요, 월일, 월요일' 모두 인식 가능
SELECT SYSDATE, NEXT_DAY(SYSDATE,2) FROM DUAL;

-- 언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = ENGLISH; -- 'AMERICAN'도 가능

/*
    LAST_DAY(날짜)
    - 해당 월의 마지막 날짜 반환
*/
SELECT LAST_DAY(SYSDATE), LAST_DAY('20250815'), LAST_DAY('2025-12-16'), LAST_DAY('2025/05/05') FROM DUAL;

/*
    EXTRACT(YEAR|MONTH|DAY FROM '날짜')
    - 특정 날짜에서 연도, 월, 일 정보를 추출
*/
-- USER_INFO에서 BIRTHDATE로 연도,월,일 따로 조회
SELECT NAME,
    EXTRACT(YEAR FROM BIRTHDATE) "태어난 년도", 
    EXTRACT(MONTH FROM BIRTHDATE) "월", 
    EXTRACT(DAY FROM BIRTHDATE) "일"
FROM USER_INFO;

/*
    형(TYPE) 변환 함수
    
    TO_CHAR(날짜|숫자, 포맷)
    - 날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/
SELECT TO_CHAR(1234, 'L99,999') FROM DUAL; -- (현재 설정된) 화폐 단위로 변경
ALTER SESSION SET NLS_CURRENCY = '￦'; -- 화폐 단위 변경

-- EMPLOYEE에서 연봉을 TO_CHAR를 이용해서 조회(,)
SELECT EMP_NAME, TO_CHAR(SALARY*12, 'L99,999,999') "연봉" FROM EMPLOYEE
ORDER BY 연봉; -- 별칭으로도 정렬 가능함!

-- 날짜 => 문자
SELECT
    TO_CHAR(SYSDATE, 'YYYY'), -- 년: YYYY,RRRR,YY,RR,(YEAR는 비추천)
    TO_CHAR(SYSDATE, 'MM'), -- 월: MM, MON, MONTH, RM(로마숫자)
    TO_CHAR(SYSDATE, 'DD'), -- 일: D(WEEK단위), DD(월단위), DDD(연단위:1/1부터)
    TO_CHAR(SYSDATE, '(DY)'), -- 요일: DY(수), DAY(수요일)
    TO_CHAR(SYSDATE, 'PM HH:MI:SS'), -- 오전/오후 시:분:초 (= AM HH:MI:SS)
    TO_CHAR(SYSDATE, 'HH24:MI:SS') -- (24시간 기준)시:분:초
FROM DUAL;

-- BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회
SELECT NAME, BIRTHDATE, TO_CHAR(BIRTHDATE, 'YYYY')||'년 '||TO_CHAR(BIRTHDATE, 'MM')||'월 '||TO_CHAR(BIRTHDATE, 'DD')||'일 '||TO_CHAR(BIRTHDATE, 'DAY') "생일",
TO_CHAR(BIRTHDATE, 'YYYY"년" MM"월" DD"일" DAY') -- *위와 같은 연결연산자 필요 없이 해당 형태로 포맷 지정 가능하다!
FROM USER_INFO
ORDER BY 생일 ASC;

/*
    TO_DATE(숫자|문자, 포맷)
    - 숫자 또는 문자형 데이터를 날짜 타입으로 변환
*/
-- 숫자 => 날짜
SELECT TO_DATE(20250604) FROM DUAL;
SELECT TO_DATE(20250604164230, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

-- 문자 => 날짜
SELECT TO_DATE('20250604') FROM DUAL;
SELECT TO_DATE('20250604164230', 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

/*
    TO_NUMBER(문자, 포맷)
    - 문자형 데이터를 숫자 타입으로 변환
*/
SELECT '100000' + '550000' FROM DUAL;
SELECT TO_NUMBER('100,000','999,999') + TO_NUMBER('550,000','999,999') FROM DUAL;

/*
    NULL 처리 함수

    NVL/COALESCE(값1, 값2)
    - 값1이 NULL이 아니면 값1 반환하고, 값1이 NULL이면 값2 반환
*/
-- USER_INFO에서 MBTI가 NULL인 경우 'MBTI 모름' 처리
SELECT NAME, MBTI, NVL(MBTI, 'MBTI 모름') AS 성격유형 FROM USER_INFO;

-- COALESCE(값1, 값2, ....) : 여러 값(2개 초과) 들어올 수 있음
-- MBTI가 NULL이 아니면 MBTI, NULL이면 HOBBY, 이것 또한 NULL이면 '모름'
SELECT NAME, COALESCE(MBTI, HOBBY, '모름') FROM USER_INFO;

/*
    NVL2(값1, 값2, 값3)
    - 값1이 NULL이 아니면 값2, NULL이면 값3
*/
-- EMPLOYEE에서 부서코드(DEPT_CODE)가 있으면 '부서있음', 없으면 '부서없음'
SELECT EMP_NAME 이름, NVL2(DEPT_CODE, '부서있음', '부서없음') 소속, DEPT_CODE FROM EMPLOYEE;

/*
    NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL, 동일하지 않으면 값1
*/
SELECT NULLIF('123','123'), NULLIF('123','456') FROM DUAL;

/*
    선택 함수 : 여러 가지 경우에 선택할 수 있는 기능을 제공

    DECODE(값, 조건값1, 결과값1, 조건값2, 결과값2, ..., 조건 없을 때의 결과값)
    - 비교하고자 하는 값이 조건값과 일치하는 경우 그에 해당하는 결과값 반환

    CASE WHEN 조건식1 THEN 결과값1
         WHEN 조건식2 THEN 결과값2
         ...
         ELSE 결과값N
    END
*/
-- EMPLOYEE에서 주민번호(EMP_NO)로 성별(남,여) 조회
SELECT EMP_NAME, EMP_NO,
DECODE(SUBSTR(EMP_NO,INSTR(EMP_NO,'-')+1,1), 1, '남', 2, '여') GENDER
FROM EMPLOYEE;

SELECT EMP_NAME, EMP_NO,
CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남'
     WHEN SUBSTR(EMP_NO, 8, 1) = 2 THEN '여'
END AS "성별"
FROM EMPLOYEE;

-- 직급 코드가 J7인 사원은 급여를 10% 인상
-- 직급 코드가 J6인 사원은 급여를 15% 인상
-- 직급 코드가 J5인 사원은 급여를 20% 인상
-- 그 외 직급 사원은 급여를 5% 인상
-- 정렬 : 직급코드(JOB_CODE) J1부터, 인상된 급여 높은 순서대로

SELECT EMP_NAME, JOB_CODE, SALARY, 
NVL(DECODE(JOB_CODE, 'J7', SALARY*1.1, 'J6', SALARY*1.15, 'J5', SALARY*1.2), SALARY*1.05) "급여인상"
FROM EMPLOYEE
ORDER BY JOB_CODE, 급여인상 DESC;

SELECT EMP_NAME, JOB_CODE, SALARY, 
CASE WHEN JOB_CODE='J7' THEN SALARY*1.1
     WHEN JOB_CODE='J6' THEN SALARY*1.15
     WHEN JOB_CODE='J5' THEN SALARY*1.2
     ELSE SALARY*1.05

-- CASE JOB_CODE
--     WHEN 'J7' THEN SALARY*1.1
--     WHEN 'J6' THEN SALARY*1.15
--     WHEN 'J5' THEN SALARY*1.2 
--     ELSE SALARY*1.05     => 위 조건문으로 이런 형태로도 나타낼 수 있다!

END AS "급여인상"
FROM EMPLOYEE
ORDER BY JOB_CODE, 급여인상 DESC;

-- 급여가 500만원 초과일 경우 1등급
-- 급여가 500만원 이하 350만원 초과일 경우 2등급
-- 급여가 350만원 이하 200만원 초과일 경우 3등급
-- 그 외의 경우 4등급

SELECT EMP_NAME, SALARY,
CASE WHEN SALARY>5000000 THEN '1등급'
WHEN SALARY<=5000000 AND SALARY>3500000 THEN '2등급' -- SALARY > 3500000
-- (*어차피 위 조건에서 걸리기 때문에 굳이 '이하'는 안걸어줘도 무방하며 사잇값의 경우 BETWEEN도 사용 가능하다.)
WHEN SALARY<=3500000 AND SALARY>2000000 THEN '3등급' -- SALARY > 2000000
ELSE '4등급'
END AS "등급"
FROM EMPLOYEE
ORDER BY 등급, SALARY DESC;

/*
    그룹 함수 => 결과값이 1개! (단일행 함수와 동시에 사용할 수 없다.)
    - 대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우
    - 모든 그룹 함수는 NULL값을 자동으로 제외하고 값이 있는 것들만 계산
*/
-- SUM : 해당 컬럼 값들의 총 합계
-- USER_INFO에서 나이(AGE) 모두 더한 값
SELECT SUM(AGE) FROM USER_INFO;

-- EMPLOYEE에서 부서코드가 D5인 사원들의 총 연봉 조회
SELECT SUM(SALARY*12) FROM EMPLOYEE WHERE DEPT_CODE='D5';

SELECT SUM(DECODE(DEPT_CODE, 'D5', SALARY*12, 0)) "연봉"
-- WHERE 없이도 선택함수를 이용하면 조건식에 특정 상황에서만 값을 도출할 수 있게끔 지정 가능하다.
-- (조건에 맞지 않을 경우 SUM에 반영되지 않도록 값을 0으로 처리)
-- , SUM(CASE WHEN DEPT_CODE='D5' THEN SALARY*12 ELSE 0 END)
FROM EMPLOYEE;

/*
    AVG
    - 해당 컬럼값들의 평균값
    - 모든 그룹 함수는 NULL값을 자동으로 제외하기 때문에 NVL 함수와 함께 사용할 것을 권장
*/
-- USER_INFO에서 평균 나이 도출
SELECT FLOOR(AVG(CASE WHEN AGE < 100 THEN AGE END))||'세' "평균 나이" FROM USER_INFO;

-- EMPLOYEE에서 평균 보너스값 (BONUS)
SELECT FLOOR(AVG(NVL(BONUS,0)*SALARY))||'원' "보너스 평균" FROM EMPLOYEE;

/*
    MIN : 해당 컬럼 값들 중에 가장 작은 값
    MAX : 해당 컬럼 값들 중에 가장 큰 값
*/
-- EMPLOYEE에서 MIN, MAX 전부 사용해서
-- 사원명(EMP_NAME), 급여(SALARY), 입사일(HIRE_DATE)
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE),
       MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

/*
    COUNT => 가장 많이 사용하는 그룹 함수
    - 컬럼 또는 행의 개수를 세서 반환
    - * : 조회 결과에 해당하는 모든 행 개수 반환
    - 컬럼 : 해당 컬럼값이 NULL이 아닌 행 개수 반환
    - DISTINCT 컬럼 : 해당 컬럼값의 중복을 제거한 행 개수 반환

    PAGE 페이징 처리 - 한 번에 불러올 수 있는 메모리의 한계에 따라 각 컨텐츠를 페이지로 나누어 불러옴
    스크롤 방식, 더보기 방식, 1~10페이지 나열 방식 등
    기본으로 전체 카운트 COUNT(*) 이후에 나눌 수가 있음.
*/
-- USER_INFO 전체 사람 수 조회
SELECT COUNT(*) FROM USER_INFO;

-- 서울에 사는 사람들 수 조회
SELECT COUNT(ADDRESS) FROM USER_INFO WHERE ADDRESS LIKE '서울%';
SELECT COUNT(CASE WHEN ADDRESS LIKE '%서울%' THEN 1 END) FROM USER_INFO;

-- EMPLOYEE 보너스를 받은 사원 수 조회
SELECT COUNT(*) FROM EMPLOYEE WHERE BONUS IS NOT NULL;
SELECT COUNT(BONUS) FROM EMPLOYEE; -- 알아서 NULL처리를 해주기 때문에 별도 조건 없이 카운트 가능.

-- 부서가 배치된 사원 수 조회
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE;

-- 현재 사원들이 속해있는 부서 수 조회
SELECT COUNT(DISTINCT(DEPT_CODE))
FROM EMPLOYEE;

