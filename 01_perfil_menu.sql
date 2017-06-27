USE tatei;

DELETE FROM perfil_menu;
DELETE FROM menu;
DELETE FROM usuario;
DELETE FROM perfil;


INSERT INTO perfil (id_perfil,nombre,descripcion,codigo_puesto,estatus) 
VALUES (1,'Residente','Residente','RESI','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,codigo_puesto,estatus) 
VALUES (2,'Oficina Central','Oficina Central','OFCE','A');

INSERT INTO perfil (id_perfil,nombre,descripcion,codigo_puesto,estatus) 
VALUES (3,'Recursos Humanos','Recursos Humanos',NULL,'A');

INSERT INTO perfil (id_perfil,nombre,descripcion,codigo_puesto,estatus) 
VALUES (10,'Sistemas','Sistemas',NULL,'A');


INSERT INTO usuario (usuario, id_empleado,id_perfil, contrasena, cambio_contrasena, fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES  ('SISTEMAS', NULL , 1, '2047011011010121213034305014141272007567403172f0a7h905i5gnig4oqf', 'N', now(), now(), now(), 'A');


/*MENU PADRE*/

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (1,NULL,'Administracion','Administracion','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (2,NULL,'Empleados','Empleados','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (3,NULL,'Operacion','Operacion','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (4,NULL,'Buzones','Buzones','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,estatus)
VALUES (5,NULL,'Reportes','Reportes','A');


/*MENU HIJOS*/

/*Administracion*/
INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (10, 1,'ABC Catalogos','ABC Catalogos','CuadrillasWEB/catalogo/index.html','A');


INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (12, 1,'Cambio Contraseña','Cambio Contraseña','CuadrillasWEB/usuario/cambio_contra.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (13, 1,'Cambio Contraseña General','Cambio Contraseña General','CuadrillasWEB/usuario/cambio_contra_gral.html','A');

/*Empleados*/
INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (20, 2,'ABC Empleados','ABC Empleados','CuadrillasWEB/empleado/index.html','A');


/*Operacion*/
INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (30, 3,'ABC Cuadrillas','ABC Cuadrillas','CuadrillasWEB/cuadrillas/admin_cuadrillas.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (31, 3,'ABC Contratos','ABC Contratos','CuadrillasWEB/altaContrato/index.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (32, 3,'Registro Agenda','Registro Agenda','CuadrillasWEB/registroAgenda/index.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (33, 3,'Consulta Agenda','Consulta Agenda','CuadrillasWEB/','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (34, 3,'Toma de Asistencia','Toma de Asistencia','CuadrillasWEB/asistencia/index.html','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (35, 3,'ABC Herramientas','ABC Herramientas','CuadrillasWEB/herramientas/index.html','A');


/*Buzones*/
INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (40, 4,'Buzon Oficina Central','Buzon Oficina Central','CuadrillasWEB/','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (41, 4,'Buzon Residente','Buzon Residente','CuadrillasWEB/','A');

/*Reportes*/
INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (50, 5,'Reporte 1','Reporte 1','CuadrillasWEB/','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (51, 5,'Reporte 2','Reporte 2','CuadrillasWEB/','A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (52, 5,'Reporte 3','Reporte 3','CuadrillasWEB/','A');


/*SISTEMAS*/

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,1,20,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,2,10,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,3,30,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,4,40,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,5,50,'A');

/*Administracion*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,10,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,12,3,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,13,4,'A');

/*Empleados*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,20,1,'A');

/*Operacion */
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,30,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,31,2,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,32,3,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,33,4,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,34,5,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,35,6,'A');

/*Buzon*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,40,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,41,2,'A');

/*Reportes*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,50,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,51,2,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (10,52,3,'A');


/*OFICINA CENTRAL*/

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,1,20,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,2,10,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,3,30,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,4,40,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,5,50,'A');

/*Administracion*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,10,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,12,3,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,13,4,'A');

/*Empleados*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,20,1,'A');

/*Operacion */
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,30,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,31,2,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,32,3,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,35,6,'A');

/*Buzon*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,40,1,'A');

/*Reportes*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,50,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,51,2,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (2,52,3,'A');



/*RESIDENTE*/


INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,1,20,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,3,30,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,4,40,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,5,50,'A');

/*Administracion*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,12,3,'A');


/*Operacion */
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,33,4,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,34,5,'A');

/*Buzon*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,41,2,'A');

/*Reportes*/
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,50,1,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,51,2,'A');
INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus) VALUES (1,52,3,'A');

