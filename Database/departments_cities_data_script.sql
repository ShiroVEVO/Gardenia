-- --------- DEPARTAMENTOS ---------
INSERT INTO department VALUES(default,"Amazonas");
INSERT INTO department VALUES(default,"Antioquia");
INSERT INTO department VALUES(default,"Arauca");
INSERT INTO department VALUES(default,"Atlántico");
INSERT INTO department VALUES(default,"Bogotá");
INSERT INTO department VALUES(default,"Bolívar");
INSERT INTO department VALUES(default,"Boyacá");
INSERT INTO department VALUES(default,"Caldas");
INSERT INTO department VALUES(default,"Caquetá");
INSERT INTO department VALUES(default,"Casanare");
INSERT INTO department VALUES(default,"Cauca");
INSERT INTO department VALUES(default,"Cesar");
INSERT INTO department VALUES(default,"Chocó");
INSERT INTO department VALUES(default,"Córdoba");
INSERT INTO department VALUES(default,"Cundinamarca");
INSERT INTO department VALUES(default,"Guainía");
INSERT INTO department VALUES(default,"Guaviare");
INSERT INTO department VALUES(default,"Huila");
INSERT INTO department VALUES(default,"La Guajira");
INSERT INTO department VALUES(default,"Magdalena");
INSERT INTO department VALUES(default,"Meta");
INSERT INTO department VALUES(default,"Nariño");
INSERT INTO department VALUES(default,"Norte de Santander");
INSERT INTO department VALUES(default,"Putumayo");
INSERT INTO department VALUES(default,"Quindío");
INSERT INTO department VALUES(default,"Risaralda");
INSERT INTO department VALUES(default,"San Andrés y Providencia");
INSERT INTO department VALUES(default,"Santander");
INSERT INTO department VALUES(default,"Sucre");
INSERT INTO department VALUES(default,"Tolima");
INSERT INTO department VALUES(default,"Valle del Cauca");
INSERT INTO department VALUES(default,"Vaupés");
INSERT INTO department VALUES(default,"Vichada");
-- --------- CIUDADES ---------
INSERT INTO city VALUES(default,"Bogotá",7600,5);
-- ---------- CUENTAS ---------
INSERT INTO account VALUES (default, "1999-08-10", "adrianstratos@gmail.com", "perros20", "ADMIN");
-- --------- CLIENTES ---------
INSERT INTO client VALUES (1010043148,"CC", "Olmos Ardila","Adrian Stiven",3125544964,1);
INSERT INTO client VALUES (1018447035,"CC", "Montes Buitrago","Dalia Estefania",3016220266,NULL);
INSERT INTO client VALUES (1016041194,"CC", "Guerrero","Edwin",3212798623,NULL);
-- ------- DIRECCIONES --------
INSERT INTO address VALUES (default,NULL,"Calle 32B sur #6D - 08 Este",1,1010043148,"CC");
INSERT INTO address VALUES (default,NULL,"Calle 51 #26 - 36",1,1018447035,"CC");
INSERT INTO address VALUES (default,"casa 313 conjunto parques 1D","Calle 14 #107-54",1,1016041194,"CC");
-- --------- PEDIDO ---------
INSERT INTO request VALUES (default,"2023-12-11","FINALIZADO",12345,1010043148,"CC");
-- --------- REVIEW ---------
INSERT INTO review VALUES (default,"comment xd","2023-12-11",5,1);
-- --------- PRODUCTOS ---------
INSERT INTO product VALUES (default,"Trébol Mariposa",NULL,9000,5,"Esta planta endémica de Brasil presenta características muy llamativas, Similar a los tréboles, aunque difiere de ellos en su color y la forma de sus hojas, las cuales son de un morado intenso y tienen forma triangular lo que las hace confundirse fácilmente con una mariposa, Durante el día esta planta hace gala de un pompón de hojas mientras que por las noches o cuando se les molesta sus hojas se cerraran como si de un paraguas se tratara.
Sus usos son principalmente ornamentales sin embargo sus hojas y flores son usadas como aderezo para diversas comidas debido a su sabor ácido y sus rizomas como un acompañamiento debido a su sabor dulce.",9000);
INSERT INTO product VALUES (default,"Catnip, Hierba Gatuna",NULL,7000,5,"Conocida también como hierba gatera o menta gatuna, esta hierba hace que la mayoría de gatos entren en una especie de trance induciendoles excitación, ganas de jugar y un nivel de felicidad elevado. Los gatos tienden a frotarse con ella e incluso masticarla. La hierba en sí misma no representa ningún tipo de peligro para el animal sin embargo al momento de dársela es pertinente vigilarlo para que no se golpee con objetos que lo rodeen o caiga de lugares peligrosos. Darla en exceso puede hacer que el animal se vuelva menos sensible a los efectos de la hierba.",7000);
INSERT INTO product VALUES (default,"Punk Spike",NULL,6000,5,"De la familia de las Aloe vera sin embargo difiere en multiples aspectos, Su tamaño es diminuto y nunca superará los 8cm de radio, Sus hojas presentan unas diminutas puas que se confunden con pequeños pelitos los cuales son de color blanco, Asi mismo presenta pequeños lunares blancos en sus hojas que son tipicamente de un color gris oscuro. Así como cualquier sábila no requiere de gran cantidad de cuidados y el color del espécimen puede variar dependiendo de las condiciones de estrés a las cuales se vea expuesto",6000);

-- ---------- PLANTAS ----------
INSERT INTO plant VALUES (default,"care instructions xd", "description xd","Trébol Mariposa",12345,"Oxalis triangularis",5,5,3,19000);
INSERT INTO plant VALUES (default,"care instructions xd", "description xd","Catnip, Hierba Gatuna",12345,"Nepeta cataria",3,5,3,16000);
INSERT INTO plant VALUES (default,"care instructions xd", "description xd","Punk Spike",12345,"Aloe aristata",3,5,3,16000);
-- --------- CATEGORIA ---------
INSERT INTO category VALUES (default, "Follaje","url xd");
INSERT INTO category VALUES (default, "Aromáticas","url xd");
INSERT INTO category VALUES (default, "Suculentas","url xd");

-- --------- PRODUCTO X CATEGORIA ---------

INSERT INTO plant_has_category VALUES (1, 1);
INSERT INTO plant_has_category VALUES (2, 2);
INSERT INTO plant_has_category VALUES (3, 3);

-- --------- CUENTA ---------
Select * from account;
INSERT INTO account VALUES (default,"perro@gmail.com",curdate(),"contraseña","CC",1010043148)