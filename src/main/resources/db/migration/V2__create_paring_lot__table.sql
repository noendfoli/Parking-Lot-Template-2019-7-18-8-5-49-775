drop  table PARKING_LOT;
create table PARKING_LOT(
  parking_lot_id varchar(64) not null PRIMARY KEY ,
  parking_lot_name varchar(32) UNIQUE ,
  parking_lot_capacity int not null,
  parking_lot_position varchar(64) not null
);