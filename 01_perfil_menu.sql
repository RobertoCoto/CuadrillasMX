USE tatei;

DELETE FROM perfil_menu;
DELETE FROM menu;
DELETE FROM usuario;
DELETE FROM perfil;



INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (100,'Sistemas','Sistemas','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (1,'Residente','Residente','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (2,'Oficina Central','Oficina Central','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (3,'Recursos Humanos','Recursos Humanos','A');



INSERT INTO usuario (usuario, id_empleado,id_perfil, contrasena, cambio_contrasena, fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES  ('SISTEMAS', NULL , 1, '2047011011010121213034305014141272007567403172f0a7h905i5gnig4oqf', 'N', now(), now(), now(), 'A');


/* QUITAR */
INSERT INTO usuario (usuario,id_empleado,nombre,apellido_pat,apellido_mat,sexo,rfc,rfc_calculado,fecha_nacimiento,id_perfil,contrasena,cambio_contrasena,fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES('rcoto', 1,'ROBERTO ANTONIO','COTO','IXTEPAN','H','COIR920801JE9','COIR920801JE9','1992-08-01',100,'898401110010002200022044311314421267a6326db26372c4a3a7059139q2sbm', 'N', now(), now(), now(), 'A');

INSERT INTO usuario (usuario,id_empleado,nombre,apellido_pat,apellido_mat,sexo,rfc,rfc_calculado,fecha_nacimiento,id_perfil,contrasena,cambio_contrasena,fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES('mimejorada', 2,'MARIO IVAN','MEJORADA','HERRERA','H','MEHM770921JK1','MEHM770921JK','1977-09-21',100,'821610101001110220100012301263064791216bc07a5b6c8206cf634lg104sgs', 'N', now(), now(), now(), 'A');
/* QUITAR */


--MENU PADRE
INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Administración','Administración','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Administración','Administración','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Administración','Administración','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Administración','Administración','A');

--MENU HIJOS

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (10, 1,'ABC Catalogos','ABC Catalogos','CuadrillasWEB/catalogo/index.html','A');


--

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (100,1,10,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (100,10,20,'A');

