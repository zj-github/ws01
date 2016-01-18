
create table errors(
	id int primary key auto_increment,
	os varchar(20),
	dev_tool varchar(20),
	sf varchar(20),
	error_info varchar(2000)
)