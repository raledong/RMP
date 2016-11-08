drop table if exists users;
create table users(
	user_id int auto_increment primary key,
    user_password varchar(64) not null,
    user_name varchar(255) not null,
    user_gender int default 0,
    user_role int default 1
)default charset = utf8;
alter table users auto_increment=10000000;

drop table if exists projects;
create table projects(
	project_id int auto_increment primary key,
    project_name varchar(255) not null,
    project_created_at timestamp default current_timestamp,
    project_created_by int not null,
    project_description varchar(511) default ''
    
)default charset = utf8;

drop table if exists projects_programmers;
create table projects_programmers(
	project_id int not null,
    programmer_id int not null,
    primary key(project_id, programmer_id)
);

drop table if exists risks;
create table risks(
	risk_id int auto_increment primary key,
    risk_project_id int not null,
    risk_info varchar(512) not null,
    risk_probability int default 0 comment '0为低，1为中，2为高',
    risk_impact int default 0 comment '0为低，1为严重性一般，2为严重性高',
    risk_trigger varchar(512) default '',
    risk_created_by int not null,
    risk_created_at timestamp default current_timestamp,
    risk_followed_by int not null
)default charset = utf8;

drop table if exists risk_status;
create table risk_status(
	risk_status_id int auto_increment primary key,
    risk_status_risk_id int default null,
    risk_status_info varchar(512) not null,
    risk_status_created_by int not null,
    risk_status_created_at timestamp default current_timestamp
)default charset = utf8;

