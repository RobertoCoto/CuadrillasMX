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
VALUES('ESTA_HERRA','DANA',upper('Da�ado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

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



/*CONTRATO DOCUMENTO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONT_DOCU','DOCUMENTOS CONTRATOS','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONT_DOCU','POLI',upper('Poliza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONT_DOCU','FACT',upper('Factura'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('CONT_DOCU','ACCO',upper('Act. Contrato'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

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

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','COPZ',upper('Construccion de Cajetes Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','DTSF',upper('Derribo y Troceado de Sujetos Forestales PZA'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','DEST',upper('Descompactacion de Terreno M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','OTRA',upper('Otra'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','PLCE',upper('Plantacion de cesped M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','PLAR',upper('Plantacion de Especies Arbostivas Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','PLCU',upper('Plantacion de Especies Cubresuelos Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','POCE',upper('Poda de cesped M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','POOR',upper('Poda de Ornamentales M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','POSM',upper('Poda de Seto M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','RAST',upper('Rastrillado M2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','REBA',upper('Recoleccion de Basura M3'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','REPC',upper('Recoleccion de Piedra y Cascajo M3'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','RETD',upper('Recoleccion y Traslado de Desecho M3'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','RECE',upper('Remate de Cesped ML'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','INCI',upper('Incidencia'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','TREA',upper('Transplante de Especies Arbustivas Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','TREC',upper('Transplante de Especies Cubresuelos Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','TREO',upper('Transplante de Especies Ornamentales Pza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ACTIVIDADE','TRMU',upper('Traslado de Mulch M3'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO ARTICULOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ARTICULOS','S',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','BIEL',upper('Bieldo 4 Puntas'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CU12',upper('Cuerda 1/2'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CAMI',upper('Camioneta'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CAPA',upper('Carretilla Pajera'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CU58',upper('Cuerda 5/8'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ESCA',upper('Escalera'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ESMI',upper('Escoba de Mijo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ESAR',upper('Escoba de Araña'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','HACH',upper('Hacha'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','MACH',upper('Machete'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','PACA',upper('Pala Carbonera'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','PAJR',upper('Pala Jardinera'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','SECU',upper('Serrote Curvo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','TIMA',upper('Tijerra 2 Manos'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CONO',upper('Conos'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','TRAF',upper('Trafitambos'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','DESM',upper('Desmalezadora'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','MO25',upper('Moto 25'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','MO14',upper('Moto 14'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ESTA',upper('Estacas'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','VOLT',upper('Volteo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','MECA',upper('Mecahilo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','SETE',upper('Seteadora'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CALE',upper('Careta o Lentes'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','CHAL',upper('Chalecos'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','FACU',upper('Faja de Cuero'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','GUCA',upper('Guantes de Carnaza'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','BOTI',upper('Botiquin'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ZAPT',upper('Zapatos de Trabajo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','GORR',upper('Gorra'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','TAMS',upper('Tambo de Señalamiento'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','UNIF',upper('Uniformes'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','LOVE',upper('Lona Vehiculos'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','ARNE',upper('Arnes'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','IMPE',upper('Impermeables'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','LORE',upper('Lona Para Recoger'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','BARS',upper('Barsinas'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','BOLS',upper('Bolsas'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ARTICULO','COST',upper('Costales'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO ESTATUS ACTIVIDADES*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_ACT','ESTADO ACTIVIDAD','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_ACT','NOIN',upper('No Iniciado'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_ACT','PROG',upper('En Progreso'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_ACT','APLA',upper('Aplazada'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('ESTA_ACT','COMP',upper('Completo'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO PRIORIDAD ACTIVIDAD*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('PRIO_ACT','PRIORIDAD ACTIVIDAD','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PRIO_ACT','BAJA',upper('Baja'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PRIO_ACT','NORM',upper('Normal'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('PRIO_ACT','ALTA',upper('Alta'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO LISTO VENCIDO*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('LIST_VENC','LISTO VENCIDO','N',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('LIST_VENC','PRIO',upper('Prioridad'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('LIST_VENC','PESP',upper('Puede Esperar'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*CATALOGO MANOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('LADO_MAN','LADO MANOS', 'N', now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('LADO_MAN','MIZQ',upper('Mano Izquierda'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('LADO_MAN','MDER',upper('Mano Derecha'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

/*Catalogo DEDOS*/

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,administracion,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','TIPO DEDOS', 'N', now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','MENI',upper('Menique'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','ANUL',upper('Anular'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','DMED',upper('Dedo Medio'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','INDI',upper('Indice'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion, usuario_alta,usuario_ult_mod,fecha_alta,fecha_ult_mod,estatus)
VALUES('TIPO_DEDO','PULG',upper('Pulgar'),'SISTEMAS', 'SISTEMAS',now(),now(),'A');