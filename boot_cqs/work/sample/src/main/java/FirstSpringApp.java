public class FirstSpringApp {

    // psvm 자동완성으로 메인 메서드 생성
    public static void main(String[] args) {
        System.out.println("hello spring boot");

        /*
        Setting -- 인텔리제이와 친해지기

        우측 코끼리(Gradle) Tasks -> build -> jar
        D:\web-dev-stack\boot_cqs\work\sample\build\libs 경로에
        sample-1.0-SNAPSHOT.jar 파일 생성됨 
        
        Terminal 에서 cd .\build/libs 경로 입력 후,
        java -cp .\sample-1.0-SNAPSHOT.jar FirstSpringApp 입력 시
        위 sout 출력 확인 가능

        MYSQL 8.0 Command Line Client 실행
        => 비밀번호 입력 후, 접속 성공 시 쿼리문 작성 가능

        여러 개의 DB를 사용할 시에 클라이언트 필요
        https://dbeaver.io/download/ => community window installer

        비버 실행 => 데이터베이스 메뉴 => 새 데이터베이스 연결 => mysql
        main 기본 세팅에서 비밀번호 입력 => Test Connection => 다운로드
        Driver properties => allowPublicKeyRetrieval 항목 true로 변경

        localhost에서 SQL편집기(F3) 실행
        ** ctrl + enter : 한 줄 실행
        ** alt + x : 스크립트 내 모든 쿼리문 전체 실행

        설정 - 플러그인에서 lombok 설치
        https://start.spring.io/ : 스프링 세팅을 위해 제공하는 initializr
        Java 버전 일치 시키고 디펜던시 추가
        Explore 에서 Download => demo 파일 workspace에 압축 해제 후 open
        
        build.gradle 파일에 dependencies 정상적으로 반영되었는 지 확인
        디펜던시에 변경사항 있을 경우 팝업되는 코끼리 아이콘 눌러 새로고침 필수

        https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.2.0
        Gradle tab에 있는 내용 복사하여 build.gradle에 디펜던시 추가
        오류가 있는 빨간 밑줄에서 alt + enter 누르면 해결을 위한 팝업창
        ( IJ 특징 : 파라미터 넣는 곳에 "" 를 넣으면 무엇을 입력해야 하는 지 보인다! )

        */
    }
}
