## 새 프로젝트를 만들었을 때, 옮겨와야할 것들

1. src/main/resources -> 패키지 4개<br>
   ㄴ mybatis-config.xml에서 참조하는 mapper이름 변경<br>
   ㄴ mapper이름 변경 및 내용 수정<br>
   ㄴ context-3-dao.xml의 내용 비워두기<br>
   ㄴ servlet-context.xml의 내용 비워두기<br><br>

2. webapp/WEB-INF폴더에 web.xml 복사<br><br>

3. root폴더에 pom.xml 복사<br>
   ㄴ artifactId, name 이름 변경 (현재 프로젝트 패키지명과 일치하도록)
