create table tbl_member (
    userid varchar(50) not null,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate timestamp default now(),
    updatedate timestamp default now(),
    primary key(userid)
);

create table tbl_board (
   bbsno INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(200) NOT NULL,
   content TEXT NULL,
   writer VARCHAR(50) NOT NULL,
   regdate TIMESTAMP NOT NULL DEFAULT now(),
   viewcnt INT DEFAULT 0,
   primary key (bbsno)
);
   
select * from tbl_board where bbsno > 0 order by bbsno desc, regdate desc limit 20,20;

insert into tbl_board (title,content,writer)
(select title,content,writer from tbl_board);

select count(*) from tbl_board;