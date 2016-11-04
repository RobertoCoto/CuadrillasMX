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
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil);

INSERT INTO perfil(id_perfil,nombre,descripcion,estatus) VALUES(1,'Prueba Perfil','Prueba Perfil','A');

INSERT INTO tipo_catalogo (tipo_catalogo,descripcion,orden,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","PERFIL EMPLEADO",'D','2016-11-02 22:00:00','2016-11-02 22:00:00','A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","CABO","Cabo",'2016-11-02 22:00:00','2016-11-02 22:00:00','A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","PODA","Podador",'2016-11-02 22:00:00','2016-11-02 22:00:00','A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","MAQU","Maquinista",'2016-11-02 22:00:00','2016-11-02 22:00:00','A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","AYGE","Ayudante en General",'2016-11-02 22:00:00','2016-11-02 22:00:00','A');

INSERT INTO catalogo(tipo_catalogo,codigo,descripcion,fecha_alta,fecha_ult_mod,estatus)
VALUES("PERFIL_EMP","CHOF","Chofer",'2016-11-02 22:00:00','2016-11-02 22:00:00','A');