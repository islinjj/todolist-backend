DROP TABLE IF EXISTS todoitem;
CREATE TABLE todoitem (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  status Boolean,
  content varchar(20)
);
insert
into todoitem
values (1,true,'vicky')