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

drop table if exists risk_types;
create table risk_types(
	risk_type_id int auto_increment primary key,
    risk_type_info varchar(512) not null,
    risk_type_created_by int default -1 comment'-1代表系统通用 其余的各个用户自定义创建的'
)default charset = utf8;

drop table if exists risks;
create table risks(
	risk_id int auto_increment primary key,
    risk_project_id int not null,
    risk_type_id int default 0 comment '新添风险类型，默认为0',
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
    risk_status_isHappened int default 0 comment '新添是否发生属性，0是未发生，1是发生',
    risk_status_created_by int not null,
    risk_status_created_at timestamp default current_timestamp
)default charset = utf8;

drop table if exists risk_plans;
create table risk_plans(
	risk_plan_id int auto_increment primary key,
    risk_plan_created_by int not null comment '创建风险管理计划的项目经理的id',
    risk_plan_created_at timestamp default current_timestamp
)default charset = utf8;

drop table if exists risk_plan_items;
create table risk_plan_items(
	risk_plan_item_id int auto_increment primary key,
    risk_plan_item_plan_id int not null,
    risk_plan_item_type_id int not null,
    risk_plan_item_info varchar(511) default '',
    risk_plan_item_probability int default 0 comment '0为低，1为中，2为高',
    risk_plan_item_impact int default 0 comment '0为低，1为严重性一般，2为严重性高',
    risk_plan_item_trigger varchar(512) default ''
)default charset = utf8;

 -- 获取被识别风险的排序列表
select riskTypes.risk_type_id, riskTypes.risk_type_info, count(risks.risk_id)
from risk_types riskTypes, risks risks 
where riskTypes.risk_type_id = risks.risk_type_id 
group by riskTypes.risk_type_id
order by count(risks.risk_id)desc
limit 5;

-- 获取问题风险的排序列表 
select riskType.risk_type_id, riskType.risk_type_info, count(riskStatus.risk_status_id)
from risk_types riskType, risks risks, risk_status riskStatus
where riskType.risk_type_id = risks.risk_type_id  and risks.risk_id = riskStatus.risk_status_risk_id and riskStatus.risk_status_isHappened = 1
	and riskStatus.risk_status_created_at <= '2016-11-21' and riskStatus.risk_status_created_at >='2016-11-1'
group by riskType.risk_type_id
order by count(riskStatus.risk_status_id) desc
limit 5;
