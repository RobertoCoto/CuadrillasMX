DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS parametros;

CREATE TABLE usuario (
    usuario VARCHAR(20) NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    apellido_pat VARCHAR(80) NOT NULL,
    apellido_mat VARCHAR(80) NOT NULL,
    sexo  CHAR(1) NOT NULL CHECK(sexo IN('F','M')),
    rfc VARCHAR(13) NULL,
    rfc_calculado VARCHAR(15) NULL, 
    curp VARCHAR(20) NULL,
    fecha_nacimiento DATE NOT NULL,
    id_perfil INT NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    cambio_contrasena CHAR(1) NOT NULL CHECK(cambio_contrasena IN('S','N')),
    fecha_alta DATETIME NOT NULL,
	fecha_ult_mod DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
    PRIMARY KEY(usuario),
    KEY(id_perfil)
    );
    
    CREATE TABLE perfil (
    id_perfil INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
    PRIMARY KEY(id_perfil)
    );

    CREATE TABLE parametros (
    parametro VARCHAR(100) NOT NULL,
    valor VARCHAR(100) NOT NULL,
    fecha_alta DATETIME NOT NULL,
	fecha_ult_mod DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
    );

    CREATE TABLE tipo_catalogo (
        tipo_catalogo VARCHAR(10) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,
        orden char(1) NOT NULL CHECK(orden IN('C','D')),
        fecha_alta DATETIME NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
    );
 
    CREATE TABLE catalogo (
        tipo_catalogo VARCHAR(10) NOT NULL,
        codigo VARCHAR(10) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
    );

    CREATE TABLE herramienta (
        id_herramienta INT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(100) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,
        fecha_ingresa DATETIME NOT NULL,
        codigo_tipo_combustible VARCHAR(10) NOT NULL,
        codigo_tipo_articulo VARCHAR(10) NOT NULL,
        codigo_estado VARCHAR(10) NOT NULL,
        mantenimiento CHAR(1) NOT NULL CHECK(mantenimiento IN('S','N')),
        fecha_alta DATETIME NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
        PRIMARY KEY(id_herramienta)
    );

    CREATE TABLE menu (
        id_menu INT NOT NULL AUTO_INCREMENT,
        id_padre INT NULL,
        menu VARCHAR(50) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,
        url  VARCHAR(200) NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
        PRIMARY KEY(id_menu)
    );

    CREATE TABLE perfil_menu (
        id_perfil INT NOT NULL,
        id_menu INT(100) NOT NULL,
        orden INT(100) NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
        KEY(id_perfil),
        KEY(idmenu)
    );


ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil);

ALTER TABLE perfil_menu ADD CONSTRAINT FK_perfil_menu FOREIGN KEY (id_menu) REFERENCES menu(id_menu);

ALTER TABLE perfil_menu ADD CONSTRAINT FK_Perfil_menu_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfil(id_perfil);

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

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (0,"Sistemas","Sistemas",'A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (2,"Residente","Residente",'A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (3,"Oficina Central","Oficina Central",'A');

INSERT INTO perfil (id_perfil,nombre,descripcion,estatus) 
VALUES (4,"Recursos Humanos","Recursos Humanos",'A');

INSERT INTO menu (id_menu,menu,descripcion,estatus)
VALUES (1,"Menu Padre","Menu Padre",'A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (2,1,"Menu Hijo 1","Menu Hijo 1","/Hijo.html",'A');

INSERT INTO menu (id_menu,id_padre,menu,descripcion,url,estatus)
VALUES  (3,1,"Menu Hijo 2","Menu Hijo 2","/Hijo2.html",'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,1,10,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,2,20,'A');

INSERT INTO perfil_menu (id_perfil,id_menu,orden,estatus)
VALUES (0,3,30,'A');