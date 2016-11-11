INSERT INTO perfil(id_perfil,nombre,descripcion,estatus) VALUES(4,'Prueba Perfil','Prueba Perfil','A');

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","PERFIL EMPLEADO",'D',now(),now(),'A');

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","TIPO COMBUSTIBLE",'D',now(),now(),'A');

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_ARTIC","TIPO ARTICULO",'D',now(),now(),'A');

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","ESTADO HERRAMIENTA",'D',now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","CABO","Cabo",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","PODA","Podador",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","MAQU","Maquinista",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","AYGE","Ayudante en General",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","CHOF","Chofer",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","GASO","Gasolina",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","DISE","Disel",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","ACEI","Aceite",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","PREP","Preparado",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_COMBU","NAPL","No Aplica",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_ARTIC","NUEV","Nuevo",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("TIPO_ARTIC","REUS","Reuso",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","BUEN","Bueno",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","REGU","Regular",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","DANA","Dañado",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","ENRE","En reparación",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","DESE","Desechado",now(),now(),'A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("ESTA_HERRA","PERD","Perdida",now(),now(),'A');

