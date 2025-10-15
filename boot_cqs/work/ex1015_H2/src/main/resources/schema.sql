create table member(
    id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null unique,
    age int
);

create table article(
    id int auto_increment primary key,
    title varchar(100),
    description varchar(4096),
    created datetime,
    updated datetime,
    memberid int,
    foreign key(memberid) references member(id) on delete cascade -- 외래키 설정 (id 삭제 시 memberid 또한 삭제되도록 세팅)
);

insert into member(name, email, age) values ('hong', 'hong@a.com', 10);
insert into member(name, email, age) values ('park', 'park@a.com', 12);
insert into member(name, email, age) values ('kim', 'kim@a.com', 18);