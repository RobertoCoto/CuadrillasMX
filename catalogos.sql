USE tatei;

DELETE FROM catalogo;
DELETE FROM tipo_catalogo;

/*CATALOGO PERFIL EMPLEADO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','PERFIL EMPLEADO','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','CABO','Cabo',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','PODA','Podador',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','MAQU','Maquinista',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','AYGE','Ayudante en General',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','CHOF','Chofer',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','OFCE','Oficina Central',now(),now(),'A');

/*CATALOGO TIPO COMBUSTIBLE*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','TIPO COMBUSTIBLE','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','GASO','Gasolina',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','DISE','Disel',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','ACEI','Aceite',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','PREP','Preparado',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_COMBU','NAPL','No Aplica',now(),now(),'A');

/*CATALOGO TIPO COMBUSTIBLE*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','TIPO ARTICULO','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','NUEV','Nuevo',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_ARTIC','REUS','Reuso',now(),now(),'A');

/*CATALOGO ESTADO HERRAMIENTA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','ESTADO HERRAMIENTA','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','BUEN','Bueno',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','REGU','Regular',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','DANA','Dañado',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','ENRE','En reparación',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','DESE','Desechado',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_HERRA','PERD','Perdida',now(),now(),'A');

/*CATALOGO VIALIDAD*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','VIALIDAD','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','5MAY','5 de Mayo',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','EJE6','Eje 6 Norte',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','EJE7','Eje 7 Sur',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','INSU','Insurgentes',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','UNIV','Universidad',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('VIALIDAD','ZARA','Zaragoza',now(),now(),'A');

/*CATALOGO AREA INCORPORARSE*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('AREA_INC','AREA INCORPORARSE','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('AREA_INC','VERD','Areas Verde',now(),now(),'A');

/*CATALOGO TALLA DE ROPA*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','TALLA DE ROPA','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','EXCH','XCH',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','CHIC','CH',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','MEDI','ME',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','GRAN','GR',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('ROPA_TALLA','EXGR','XGR',now(),now(),'A');

/*CATALOGO DOCUMENTOS EMPLEADOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','DOCUMENTOS EMPLEADOS','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','SOEM','Solicitud Elaborada',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','CURP','CURP',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','ACNA','Acta Nacimiento',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','IMSS','Documentos IMSS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','DRFC','RFC',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('DOCU_EMPLE','CUVI','Curriculum Vitae',now(),now(),'A');

/*CATALOGO DOCUMENTOS EMPLEADOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('TIPO_SALID','BAJA EMPLEADO TIPO SALIDA','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('TIPO_SALID','TSBP','Baja Planeada',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('TIPO_SALID','TSRE','Renuncia',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('TIPO_SALID','TSAB','Abandono',now(),now(),'A');

/*CATALOGO DOCUMENTOS EMPLEADOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','BAJA EMPLEADO CAUSA RENUNCIA','D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','CROE','Otro Empleo',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','CRMA','Mal Ambiente',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','CREN','Enfermedad',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','CRAP','Asunto Personal',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus) VALUES('CAUSA_RENU','CROT','Otro',now(),now(),'A');
	
	