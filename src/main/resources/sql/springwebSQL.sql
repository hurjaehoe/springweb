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

create table tbl_reply (
   replyno INT NOT NULL AUTO_INCREMENT,
   bbsno INT NOT NULL DEFAULT 0,
   replytext VARCHAR(1000) NOT NULL,
   replyer VARCHAR(50) NOT NULL,
   regdate TIMESTAMP NOT NULL DEFAULT now(),
   updatedate TIMESTAMP NOT NULL DEFAULT now(),
   primary key(replyno)
);

alter table tbl_reply add constraint fk_board
foreign key (bbsno) references tbl_board(bbsno);
   
select * from tbl_board where bbsno > 0 order by bbsno desc, regdate desc limit 20,20;

insert into tbl_board (title,content,writer)
(select title,content,writer from tbl_board);

select count(*) from tbl_board;

create table tbl_user ( 
 uid varchar(50) NOT NULL, 
 upw varchar(50) NOT NULL,
 uname varchar(100) NOT NULL,
 upoint int NOT NULL DEFAULT 0,
 primary key(uid)
);

create table tbl_message (
 mid int not null auto_increment,
 targetid varchar(50) not null, 
 sender varchar(50) not null, 
 message text not null,
 opendate timestamp,
 senddate timestamp not null default now(),
 primary key(mid)
);

alter table tbl_message add constraint fk_usertarget 
foreign key (targetid) references tbl_user (uid); 

alter table tbl_message add constraint fk_usersender 
foreign key (targetid) references tbl_user (uid); 

insert into tbl_user(uid, upw, uname) values ('user00','user00','IRON MAN');
insert into tbl_user(uid, upw, uname) values ('user01','user01','CAPTAIN');
insert into tbl_user(uid, upw, uname) values ('user02','user02','HULK');
insert into tbl_user(uid, upw, uname) values ('user03','user03','Thor');
insert into tbl_user(uid, upw, uname) values ('user10','user10','Quick Silver');
