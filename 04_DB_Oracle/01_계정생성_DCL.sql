-- 스키마(구조) > 사용자(계정) 있어야 한다. (사용자 안에 사용자를 생성)
-- Oracle 12c 이상부터 도입
-- CDB (Container Database) : 컨테이너 역할을 하는 DB, 여러 개의 PDB를 포함할 수 있음
-- PDB (Pluggable Database) : CDB 안에 존재하는 독립된 데이터베이스 (논리적 DB)
-- CDB에 접속하면 공용 사용자를 만들 수 있는데 계정 이름에 C## 접두사가 필요
-- PDB에 접속하면 PDB 전용 사용자를 만들 수 있으며 C## 접두사가 필요 없음

SELECT PDB_NAME FROM DBA_PDBS;

-- 쿼리문 실행은 CTRL + ENTER 로 한다.*** 작성만 하는 게 아니라 개별적으로 실행해주어야 한다.
ALTER SESSION SET CONTAINER = XEPDB1;

-- 사용자 계정 생성하는 구문 : 관리자 계정만 할 수 있는 역할
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER kh IDENTIFIED BY kh;
-- 아이디와 비밀번호 kh로 설정 / system 계정과 별도로 관리할 예정
-- 오라클에서 직접 동일한 생성 시도 시 다음과 같은 문구 노출됨.
-- 상태: 실패 -테스트 실패: ORA-01045: 사용자 KH는 CREATE SESSION 권한을 가지고있지 않음; 로그온이 거절되었습니다 https://docs.oracle.com/error-help/db/ora-01045/

/*
    DCL(Data Control Language) : 데이터 제어 언어
    - 계정에 시스템 권한 또는 객체 접근 권한을 부여(GRANT)하거나 회수(REVOKE)하는 구문
    GRANT 권한, 권한, ... TO 계정명;
    REVOKE 권한, 권한, ... FROM 계정명;
*/
-- CONNECT : 접속 권한 - 없으면 해당 유저로 접속이 되지 않음
-- RESOURCE : 객체(생성, 수정, 삭제), 데이터(입력, 수정, 조회, 삭제) 권한 부여
GRANT CONNECT, RESOURCE TO kh;

-- TABLESPACE : 오라클의 데이터를 저장하는 논리적 공간 단위 (보이지 않는 층)
-- 오라클에서는 계정 생성 이후 해당 기능을 활성화해주어야만 한다.
-- GRANT UNLIMITED TABLESPACE TO 계정명; (필수는 아니나 없을 시에 사용량 제한에 대한 오류가 지속 발생)
GRANT UNLIMITED TABLESPACE TO kh;
