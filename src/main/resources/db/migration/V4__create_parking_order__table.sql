create table PARKING_LOT_ORDER(
  order_id varchar(64) not null PRIMARY KEY ,
  parking_lot_name varchar(32) UNIQUE ,
  car_id varchar(32) UNIQUE,
  start_time datetime,
  end_time datetime,
  order_status int (10)
);