--- catalog airlines
CREATE TABLE AIRPLANE (model varchar(4),
name varchar(15),
capacity integer,
primary key (model));

--- catalog available flights
CREATE TABLE FLIGHT (code varchar(6),
 model_airplane varchar(10),
 sold_ticket integer,
 date date,
 time time,
PRIMARY KEY (code),
CONSTRAINT fk_flight_airplane FOREIGN KEY (model_airplane) REFERENCES AIRPLANE(model)
);

--------------------------------------

--- catalog for airplanes
INSERT INTO airplane (model,name,capacity) VALUES ('A320','Airbus 320',220);
INSERT INTO airplane (model,name,capacity) VALUES ('B737','Boeing 737',180);
INSERT INTO airplane (model,name,capacity) VALUES ('A380','Airbus 380',853);
INSERT INTO airplane (model,name,capacity) VALUES ('B777','Boeing 777',400);
INSERT INTO airplane (model,name,capacity) VALUES ('A350','Airbus 350',400);
INSERT INTO airplane (model,name,capacity) VALUES ('B747','Boeing 747',107);

--- catalog for flight


INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('MAM019','A320',0,'07-07-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('TAM019','B737',0,'07-08-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('WAM019','A380',0,'07-09-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('FAM019','B777',0,'07-10-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('SAM019','A350',1,'07-12-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('FAM020','B747',0,'07-10-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('MAM020','B747',0,'07-07-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('UAM020','A320',10,'07-13-2025');
INSERT INTO flight (code,model_airplane,sold_ticket,date) VALUES ('TAM018','B777',100,'07-08-2025');
