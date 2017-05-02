drop schema if exists buildingsTest;

drop user if exists javatester;

create schema buildingsTest;
use buildingsTest;

create table testbuilding like buildings01.building;

create user javatester IDENTIFIED BY 'testogeksperimenter=21coolstuf';
GRANT ALL PRIVILEGES ON buildingsTest.* TO javatester;

INSERT INTO testbuilding (id,street,contactName,zip,city,contactPhone) 
VALUES (110,'Louis Pios Gade 12','Antonina Lund',4100,' Ringsted','4613-8808');

INSERT INTO testbuilding (id,street,contactName,zip,city,contactPhone) 
VALUES (150,'Australiensvej 81','Anselm Jespersen',8310,' Tranbjerg Jylland','6284-9862');

INSERT INTO testbuilding (id,street,contactName,zip,city,contactPhone) 
VALUES (160,'Heisesgade 94','Lars Paulsen',2640,' Hedehusene','3184-3141');

INSERT INTO testbuilding (id,street,contactName,zip,city,contactPhone) 
VALUES (170,'Melchiors Plads 41','Janich Gade',8883,' Gjern','3407-4085');

INSERT INTO testbuilding (id,street,contactName,zip,city,contactPhone) 
VALUES (180,'Borgmester Christiansens Gade 78','Parly Olesen',5220,' Odense SØ','4317-4638');

