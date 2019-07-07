create table project
(
  no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) not null,
  starTime VARCHAR(20),
  outTime VARCHAR(20),
  finashTime VARCHAR(20),
  place VARCHAR(20),
  PRIMARY KEY (no)
);

insert into project (no,name,starTime,outTime,finashTime,place)
values (1, '时代广场', '2016.06.01','2016.10.21','2019.09.21','陕西西安未央区');