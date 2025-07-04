/*
    TCL(Transaction Control Language)
    - 트랜잭션을 제어하는 언어
    - 데이터베이스는 데이터의 변경사항(INSERT, UPDATE, DELETE)들을 묶어서 하나의 트랜잭션에 담아서 처리

    트랜잭션(Transaction)
    - 하나의 논리적인 작업 단위

    예시) ATM기에서 돈을 뽑는 과정
        1. 카드 삽입
        2. 메뉴 선택
        3. 금액 확인 및 인증
        4. 실제 계좌에서 금액만큼 인출
        5. 현금 인출
        6. 완료
    - 각각의 업무들을 묶어서 하나의 작업 단위로 만드는 것을 트랜잭션이라고 한다.

    COMMIT : 모든 작업들을 정상적으로 처리하겠다고 확정
    ROLLBACK : 모든 작업들을 취소하겠다고 확정 (마지막 COMMIT 시점으로)
    SAVEPOINT : 임시 저장 시점을 정하고 ROLLBACK 진행 시 SAVEPOINT까지 일부 롤백
*/
CREATE TABLE USER_03
AS SELECT USER_ID, NAME, AGE, GENDER, HOBBY FROM USER_INFO;
SELECT * FROM USER_03;

-- USER_03에서 USER_ID가 80, 90인 사람들 삭제
DELETE FROM USER_03
-- WHERE USER_ID = 80 OR USER_ID = 90;
WHERE USER_ID IN(80,90);
-- 위 두 행이 삭제된 시점에서 SAVEPOINT 지정
SAVEPOINT SP;

-- USER_03에서 USER_ID가 83, 85인 사람들 삭제
DELETE FROM USER_03
WHERE USER_ID IN(83,85);
ROLLBACK TO SP; -- 세이브포인트까지 롤백

-- HOBBY가 게임이 포함되신 분들을 삭제
DELETE FROM USER_03
WHERE HOBBY LIKE ('%게임%');

-- DDL 구문을 실행하는 순간 임시 저장된 변경사항들이 무조건 반영된다. (이전 명령이 롤백되지 않음)
CREATE TABLE TEST_03(
    TID NUMBER
);

ROLLBACK;
SELECT * FROM USER_03;
