--- catalog airlines
CREATE TABLE AIRLINE(code varchar(2),
name varchar(30),
primary key (code));

--- catalog countries
CREATE TABLE COUNTRY (code varchar(2), name varchar(40),
PRIMARY KEY (code)); 

--- catalog city_country
CREATE TABLE CITY_COUNTRY(city_code varchar(4) primary KEY,
country_code varchar(4),
city_name varchar(30),
CONSTRAINT fk_country_city foreign key (country_code) REFERENCES COUNTRY(code));

--- catlog for airports
CREATE TABLE AIRPORT (code varchar(4) PRIMARY KEY,
city_code varchar(4),
 name varchar(80),
CONSTRAINT fk_airport_city_country FOREIGN KEY (city_code) REFERENCES CITY_COUNTRY(city_code));


--not created from here
-- catalog for flights
CREATE TABLE FLIGHT (code varchar(3),
code_airline varchar(2),
origin varchar(4),
destiny varchar(4),
day_time time,
PRIMARY KEY (code,code_airline),
CONSTRAINT fk_flight_airline FOREIGN KEY (code_airline) REFERENCES AIRLINE(code),
CONSTRAINT fk_flight_origin FOREIGN KEY (origin) REFERENCES AIRPORT(code),
CONSTRAINT fk_flight_destiny FOREIGN KEY (destiny) REFERENCES AIRPORT(code));

-- catalog for frequence
CREATE TABLE FREQUENCE (code varchar(6),
code_flight varchar(3),
code_airline varchar(2),
code_day varchar(1),
PRIMARY KEY (code),
CONSTRAINT fk_frequence_flight FOREIGN KEY (code_flight,code_airline) REFERENCES FLIGHT(code,code_airline)
);
ALTER TABLE FREQUENCE
ADD CONSTRAINT valid_day
CHECK (code_day IN ('M','T','W','X','F','S','U'));

INSERT INTO AIRLINE (code,name) VALUES ('AM','Aeromexico');
INSERT INTO AIRLINE (code,name) VALUES ('AA','American Airline');
INSERT INTO AIRLINE (code,name) VALUES ('DL','Delta Airlines LC');
INSERT INTO AIRLINE (code,name) VALUES ('AC','Air Canada');
INSERT INTO AIRLINE (code,name) VALUES ('LH','Lufthansa Cargo AG');
INSERT INTO AIRLINE (code,name) VALUES ('AR','Aereolìneas Argentina');
INSERT INTO AIRLINE (code,name) VALUES ('AF','Air France');
INSERT INTO AIRLINE (code,name) VALUES ('KL','KLM Royal Dutch Airlines');

INSERT INTO COUNTRY (code,name) VALUES ('MX','Mexico');
INSERT INTO COUNTRY (code,name) VALUES ('US','United States of America');
INSERT INTO COUNTRY (code,name) VALUES ('CA ','Canada');
INSERT INTO COUNTRY (code,name) VALUES ('DE','Germany');
INSERT INTO COUNTRY (code,name) VALUES ('FR','France');
INSERT INTO COUNTRY (code,name) VALUES ('NL','Netherlands');

INSERT INTO CITY_COUNTRY (city_code,country_code,city_name) VALUES ('CDMX','MX','Ciudad de México');
INSERT INTO CITY_COUNTRY (city_code,country_code,city_name) VALUES ('NY','US','New York');

INSERT INTO AIRPORT  (code,city_code,name) VALUES ('AICM','CDMX','Aeropuerto Internacional Benito Juárez');
INSERT INTO AIRPORT  (code,city_code,name) VALUES ('JFK','NY','John F. Kennedy');
INSERT INTO AIRPORT  (code,city_code,name) VALUES ('EWR','NY','Newark Liberty');
INSERT INTO AIRPORT  (code,city_code,name) VALUES ('LGA','NY','LaGuardia');

INSERT INTO FLIGHT (code,code_airline,origin,destiny,day_time) VALUES ('019','AM','LGA','AICM','11:30:00');
INSERT INTO FLIGHT (code,code_airline,origin,destiny,day_time) VALUES ('018','AM','EWR','AICM','13:00:00');
INSERT INTO FLIGHT (code,code_airline,origin,destiny,day_time) VALUES ('020','AM','AICM','AICM','10:30:00');

INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('MAM019','019','AM','M');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('TAM019','019','AM','T');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('WAM019','019','AM','W');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('FAM019','019','AM','F');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('SAM019','019','AM','S');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('FAM020','020','AM','F');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('MAM020','020','AM','M');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('UAM020','020','AM','U');
INSERT INTO FREQUENCE (code,code_flight,code_airline,code_day) VALUES ('TAM018','018','AM','T');