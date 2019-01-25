# flagpicker_submission
flag picker rest api


Please ensure that you have installed Lombok plugin https://projectlombok.org/setup/intellij

Open up in intellij and run the spring boot application class #FlagPickerApplication and then use the following links to see the flags returned

uri to get the all flags

http://localhost:8080/flags/

uri to get continent wise country and flag list use the following uri
http://localhost:8080/flags/continent/{name}
example : http://localhost:8080/flags/continent/africa

uri to get country specific flag use the following uri
http://localhost:8080/flags/country/{name}
example : http://localhost:8080/flags/country/india

Actutor to see the metrics and admin uri (bonus)
http://localhost:8080/actuator


to see the stats (bonus)
http:localhost:8080/flags/status-metric


```
CREATE TABLE IF NOT EXISTS continents (
	ID SERIAL PRIMARY KEY DEFAULT,
	name varchar(40) NOT NULL CHECK (name <> '')
)

CREATE TABLE IF NOT EXISTS countries (
	ID SERIAL PRIMARY KEY ,
	name varchar(40) NOT NULL CHECK (name <> ''),
	flag varchar(40) NOT NULL CHECK(flag <> ''),
	continent_ID INTEGER REFERENCES continents(ID)
)

insert into continents(name) values("africa")
insert into countries(name, flag, continent_ID) values("South Africa", "🇿🇦", "1");

select name, flag from countries 
where continent_id = (select ID from continents where name="africa")
```
