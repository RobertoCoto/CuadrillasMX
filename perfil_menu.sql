USE tatei;

DELETE FROM perfil_menu;
DELETE FROM usuario;
DELETE FROM perfil;
DELETE FROM menu;


INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (0,'Sistemas','Sistemas','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (1,'Residente','Residente','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (2,'Oficina Central','Oficina Central','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (3,'Recursos Humanos','Recursos Humanos','A');




INSERT INTO usuario (usuario, id_empleado, id_perfil, contrasena, cambio_contrasena, fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES  ('rcoto', 1, 1, 'rcoto', 'N', now(), now(), now(), 'A');

INSERT INTO usuario (usuario, id_empleado, id_perfil, contrasena, cambio_contrasena, fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES  ('mimejorada', 2, 2, 'mimejorada', 'N', now(), now(), now(), 'A');




INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Menu Padre','Menu Padre','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (2,1,'Menu Hijo 1.1','Menu Hijo 1','/Hijo1.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (3,1,'Menu Hijo 1.2','Menu Hijo 2','/Hijo2.html','A');


INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (4,NULL,'Menu Padre 2','Menu Padre','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (5,4,'Menu Hijo 2.1','Menu Hijo 1','/Hijo1.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (6,4,'Menu Hijo 2.2','Menu Hijo 2','/Hijo2.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (7,4,'Menu Hijo 2.3','Menu Hijo 2','/Hijo3.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (8,NULL,'Menu Padre 3','Menu Padre','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (9,8,'Menu Hijo 3.1','Menu Hijo 1','/Hijo1.html','A');



INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (1,1,10,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (1,2,20,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (1,3,30,'A');


INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (1,8,40,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (1,9,50,'A');



INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,1,10,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,2,20,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,3,30,'A');


INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,4,40,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,5,50,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,6,60,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (2,7,70,'A');
