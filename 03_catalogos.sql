USE tatei;

DELETE FROM catalogo;
DELETE FROM tipo_catalogo;

/*CATALOGO PERFIL EMPLEADO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','PERFIL EMPLEADO', 'S', now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','CABO',upper('Cabo'),'SISTEMAS', 'SISTEMAS', now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','PODA',upper('Podador'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','MAQU',upper('Maquinista'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','AYGE',upper('Ayudante en General'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','CHOF',upper('Chofer'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','OFCE',upper('Oficina Central'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO TIPO COMBUSTIBLE*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','TIPO COMBUSTIBLE','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','GASO',upper('Gasolina'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','DISE',upper('Disel'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','ACEI',upper('Aceite'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','PREP',upper('Preparado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','NAPL',upper('No Aplica'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO TIPO ARTICULO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','TIPO ARTICULO','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','NUEV',upper('Nuevo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','REUS',upper('Reuso'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO ESTADO HERRAMIENTA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','ESTADO HERRAMIENTA','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','BUEN',upper('Bueno'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','REGU',upper('Regular'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','DANA',upper('Dañado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','ENRE',upper('En reparación'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','DESE',upper('Desechado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','PERD',upper('Perdida'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO VIALIDAD*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','VIALIDAD','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','5MAY',upper('5 de Mayo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','EJE6',upper('Eje 6 Norte'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','EJE7',upper('Eje 7 Sur'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','INSU',upper('Insurgentes'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','UNIV',upper('Universidad'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('VIALIDAD','ZARA',upper('Zaragoza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO AREA INCORPORARSE*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('AREA_INC','AREA INCORPORARSE','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('AREA_INC','VERD',upper('Areas Verde'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO TALLA DE ROPA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','TALLA DE ROPA','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','EXCH','XCH','SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','CHIC','CH','SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','MEDI','ME','SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','GRAN','GR','SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ROPA_TALLA','EXGR','XGR','SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO DOCUMENTOS EMPLEADOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','DOCUMENTOS EMPLEADOS','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','SOEM',upper('Solicitud Elaborada'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','CURP',upper('CURP'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','ACNA',upper('Acta Nacimiento'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','IMSS',upper('Documentos IMSS'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','DRFC',upper('RFC'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','CUVI',upper('Curriculum Vitae'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','CREL',upper('Credencial de Elector'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','CDOM',upper('Comprobante de Domicilio'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','NINF',upper('No de Credito Infonavit'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','DOCM',upper('Documentacion Comprobatoria'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCU_EMPLE','CNFR',upper('Contrato Firmado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO BAJA EMPLEADO TIPO SALIDA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_SALID','BAJA EMPLEADO TIPO SALIDA','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_SALID','TSBP',upper('Baja Planeada'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_SALID','TSRE',upper('Renuncia'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_SALID','TSAB',upper('Abandono'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO BAJA EMPLEADO CAUSA RENUNCIA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('CAUSA_RENU','BAJA EMPLEADO CAUSA RENUNCIA','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CAUSA_RENU','CROE',upper('Otro Empleo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CAUSA_RENU','CRMA',upper('Mal Ambiente'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CAUSA_RENU','CREN',upper('Enfermedad'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CAUSA_RENU','CRAP',upper('Asunto Personal'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
	
/*CATALOGO BAJA EMPLEADO CAUSA RENUNCIA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','TIPO PERMISO LABORAL','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','ENFE',upper('Enfermedad'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','JUES',upper('Juntas Escolares'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*DATOS EXTRA PARA PRUEBAS*/

INSERT INTO `vialidad` (`id_vialidad`, `nombre`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'INSURGENTES', 'SISTEMAS', '2017-01-12 00:00:00', NULL, NULL, '', '0000-00-00 00:00:00', 'A'),
(2, '5 DE MAYO', 'SISTEMAS', '2017-01-12 00:00:00', NULL, NULL, '', '0000-00-00 00:00:00', 'A');

INSERT INTO `vialidad_coordenadas` (`id_coordenada`, `id_vialidad`, `latitud`, `longitud`, `fecha_alta`, `estatus`) VALUES
(1, 1, 19.3673, -99.1758, '2017-01-12 00:00:00', 'A'),
(2, 2, 19.4202, -99.1559, '2017-01-12 00:00:00', 'A');

INSERT INTO `cuadrilla` (`id_cuadrilla`, `nombre_cuadrilla`, `id_vialidad`, `numero_personas`, `calificacion`, `fecha_alta`, `usuario_alta`, `fecha_baja`, `usuario_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'Equipo insurgentes', 2, 11, 5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A'),
(2, 'Equipo EJE 6', 1, 5, 5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado` (`id_empleado`, `no_empleado`, `id_cuadrilla`, `nombre`, `apellido_pat`, `apellido_mat`, `fecha_nacimiento`, `sexo`, `rfc`, `rfc_calculado`, `fecha_ingreso`, `sueldo`, `frecuencia_pago`, `nss`, `no_credito_infonavit`, `telefono`, `alta_imss`, `observaciones`, `codigo_puesto`, `codigo_vialidad`, `codigo_area`, `codigo_talla`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `codigo_tipo_salida`, `codigo_causa_salida`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'JUAN ALBERTO PEREZ ROMAN', 1, 'JUAN ALBERTO', 'PEREZ', 'ROMAN', '1987-01-28', 'H', 'PERJ870128JE7', 'PERJ870128JE7', '2016-09-01', '2000.00', 'M', NULL, NULL, '557904955', 'S', 'EXCELENTE', 'CHOF', 'EJE6', '5MAY', 'EXCH', 'SISTEMAS', '2016-09-15 00:00:00', NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado_documentos` (`id_empleado`, `codigo_emp_doc`, `fecha_alta`, `estatus`) VALUES
(1, 'ACNA', '2017-01-12 00:00:00', 'A'),
(1, 'CREL', '2017-01-12 00:00:00', 'A');