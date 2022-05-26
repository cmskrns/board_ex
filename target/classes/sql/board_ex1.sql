drop table if exists board_tbl;

create table board_tbl(
	bno int auto_increment primary key,
    title varchar(300) not null,
    content text not null,
    writer varchar(50) not null,
    regDate timestamp default current_timestamp,
    updateDate timestamp default current_timestamp
);

insert into board_tbl(title,content,writer) value ('게시물입니다 ','배가 고프다','에후');
insert into board_tbl(title,content,writer) value ('게시물입니다2 ','배가 고프다2','에후2');
insert into board_tbl(title,content,writer) value ('게시물입니다3 ','배가 고프다3','에후3');
insert into board_tbl(title,content,writer) value ('게시물입니다4 ','배가 고프다4','에후4');
