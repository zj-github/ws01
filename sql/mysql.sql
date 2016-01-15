create database ssh2;  
use ssh2;  
create table user(  
 id integer primary key,  
 firstname varchar(200) not null,  
 lastname varchar(200) not null,  
 age integer  
);  
alter table user modify id integer auto_increment ;  

-- 
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION; 
flush privileges