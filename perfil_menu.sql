DELETE FROM perfil_menu;
DELETE FROM perfil;
DELETE FROM menu;


INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (0,'Sistemas','Sistemas','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (2,'Residente','Residente','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (3,'Oficina Central','Oficina Central','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (4,'Recursos Humanos','Recursos Humanos','A');


INSERT INTO menu (id_menu,menu,descripcion,estatus)
VALUES (1,'Menu Padre','Menu Padre','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (2,1,'Menu Hijo 1','Menu Hijo 1','/Hijo.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (3,1,'Menu Hijo 2','Menu Hijo 2','/Hijo2.html','A');


INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,1,10,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,2,20,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,3,30,'A');