USE tatei;

DELETE FROM catalogo;
DELETE FROM tipo_catalogo;

/*CATALOGO PERFIL EMPLEADO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','PERFIL EMPLEADO', 'S', now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERFIL_EMP','RESI',upper('Residente'),'SISTEMAS', 'SISTEMAS', now(),now(),'A');

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
VALUES('ESTA_HERRA','ENRE',upper('En reparacion'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

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
	
/*CATALOGO TIPO PERMISO LABORAL*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','TIPO PERMISO LABORAL','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','ENFE',upper('Enfermedad'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PERMI_LABO','JUES',upper('Juntas Escolares'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');


/*CATALOGO TIPO DE CONTRATOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','TIPO DE CONTRATO','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','HIDR',upper('Hidro-Lavado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','FUMI',upper('Fumigacion'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','SUPE',upper('Supervision'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','CEHI',upper('Centro Historico'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONTR_TIPO','ARVE',upper('Areas Verdes'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');


/*CATALOGO DOCUMENTO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCUMENTO','TIPO DE DOCUMENTOS','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCUMENTO','CONT',upper('Contrato'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCUMENTO','POLI',upper('Poliza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('DOCUMENTO','FACT',upper('Factura'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');


/*CATALOGO EMPRESAS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('EMPRESAS','EMPRESAS','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('EMPRESAS','TATE',upper('Grupo Tatei'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO ACTIVIDADES*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','ACTIVIDADES','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','DESH',upper('Deshierbe M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','POAR',upper('Poda de Arbol Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','AMUL',upper('Aplicacion de Mulch M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');


/*CATALOGO ARTICULOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ARTICULOS','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','BIEL',upper('Bieldo 4 Puntas'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CU12',upper('Cuerda 1/2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CAMI',upper('Camioneta'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');
