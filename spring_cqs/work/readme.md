## 새 프로젝트를 만들었을 때, 옮겨와야할 것들

1. src/main/resources -> 패키지 4개<br>
   ㄴ mybatis-config.xml에서 참조하는 mapper이름 변경<br>
   ㄴ mapper이름 변경 및 내용 수정<br>
   ㄴ context-3-dao.xml의 내용 비워두기<br>
   ㄴ servlet-context.xml의 내용 비워두기<br><br>

2. webapp/WEB-INF폴더에 web.xml 복사<br><br>

3. root폴더에 pom.xml 복사<br>
   ㄴ artifactId, name 이름 변경 (현재 프로젝트 패키지명과 일치하도록)

## 프로젝트에 오류 표시가 있을 경우

프로젝트명 우클릭 > Maven > Update Project로 체크 후 클린

다만 그 이후에 package구조가 불편하게 바뀔 수 있어서,

프로젝트명 우클릭 > Build path > Source에 들어가 Excluded: '\*\*/\*.java'가 되어 있다면,
Remove로 지워 (None)으로 값을 바꿔준 후에 Apply
