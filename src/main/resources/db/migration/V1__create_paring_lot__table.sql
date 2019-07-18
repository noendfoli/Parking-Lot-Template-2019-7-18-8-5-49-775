create table PARKING_LOT(
  parkingLotId varchar(64) not null PRIMARY KEY ,
  parkingLotName varchar(32) UNIQUE ,
  parkingLotcapacity int not null,
  parkingLotPosition varchar(64) not null
);