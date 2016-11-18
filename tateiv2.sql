USE tatei;

DROP TABLE IF EXISTS parametros;
DROP TABLE IF EXISTS empleado_documentos;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS herramienta;



DROP TABLE IF EXISTS catalogo;
DROP TABLE IF EXISTS tipo_catalogo;


DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS perfil_menu;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS menu;

CREATE TABLE usuario (
    usuario VARCHAR(20) NOT NULL,
	id_empleado INT NULL,
    id_perfil INT NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    cambio_contrasena CHAR(1) NOT NULL CHECK(cambio_contrasena IN('S','N')),
	fecha_ult_acceso DATETIME NOT NULL,
    fecha_alta DATETIME NOT NULL,
	fecha_ult_mod DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
    PRIMARY KEY(usuario),
    KEY(usuario)
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
        administracion CHAR(1) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(tipo_catalogo)
    );
 
    CREATE TABLE catalogo (
        tipo_catalogo VARCHAR(10) NOT NULL,
        codigo VARCHAR(10) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,
        usuario_alta VARCHAR(20) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        usuario_ult_mod VARCHAR(20) NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(codigo)
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
        KEY(id_menu)
    );
    
    CREATE TABLE empleado (
        id_empleado INT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(80) NOT NULL,
        apellido_pat VARCHAR(80) NOT NULL,
        apellido_mat VARCHAR(80) NOT NULL,
        sexo  CHAR(1) NOT NULL CHECK(sexo IN('F','M')),
        rfc VARCHAR(13) NULL,
        rfc_calculado VARCHAR(15) NULL, 
        curp VARCHAR(20) NULL,
        fecha_nacimiento DATE NOT NULL,
        fecha_ingreso DATE NOT NULL,
        codigo_puesto  VARCHAR(10) NOT NULL,
        codigo_vialidad VARCHAR(10) NOT NULL,
        codigo_area VARCHAR(10) NULL,
        codigo_talla VARCHAR(10) NULL,
		sueldo DECIMAL(10,2) NOT NULL DEFAULT 0,
        nss VARCHAR(20) NULL,
        no_credito_infonavit VARCHAR(20) NULL,
        telefono VARCHAR(10) NOT NULL,
        observaciones VARCHAR(100) NULL,
        fecha_alta DATETIME NOT NULL,
        fecha_baja DATETIME NOT NULL,
        codigo_tipo_salida VARCHAR(10) NULL,
        codigo_causa_salida VARCHAR(10) NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_empleado)
    );

    CREATE TABLE empleado_documentos (
		id_empleado INT NOT NULL,
		codigo_emp_doc VARCHAR(10) NOT NULL,
		fecha_alta DATETIME NOT NULL,
		fecha_ult_mod DATETIME NOT NULL,
		estatus CHAR(2) NOT NULL CHECK(estatus IN('SI','NO','NA'))
    );

ALTER TABLE catalogo ADD CONSTRAINT FK_tipo_catalogo FOREIGN KEY(tipo_catalogo) REFERENCES tipo_catalogo(tipo_catalogo);

ALTER TABLE catalogo ADD CONSTRAINT FK_cat_usuario FOREIGN KEY(usuario_alta) REFERENCES usuario(usuario);

ALTER TABLE catalogo ADD CONSTRAINT FK_cat_usuariom FOREIGN KEY(usuario_ult_mod) REFERENCES usuario(usuario);
	
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil);

ALTER TABLE perfil_menu ADD CONSTRAINT FK_perfil_menu FOREIGN KEY (id_menu) REFERENCES menu(id_menu);

ALTER TABLE perfil_menu ADD CONSTRAINT FK_Perfil_menu_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfil(id_perfil);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_puesto FOREIGN KEY(codigo_puesto) REFERENCES catalogo(codigo);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_vialidad FOREIGN KEY(codigo_vialidad) REFERENCES catalogo(codigo);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_area FOREIGN KEY(codigo_area) REFERENCES catalogo(codigo);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_talla FOREIGN KEY(codigo_talla) REFERENCES catalogo(codigo);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_tipo_salida FOREIGN KEY(codigo_tipo_salida) REFERENCES catalogo(codigo);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_causa_salida FOREIGN KEY(codigo_causa_salida) REFERENCES catalogo(codigo);

ALTER TABLE herramienta ADD CONSTRAINT FK_codigo_tipo_combustible  FOREIGN KEY (codigo_tipo_combustible) REFERENCES catalogo(codigo);

ALTER TABLE herramienta ADD CONSTRAINT FK_codigo_tipo_articulo  FOREIGN KEY (codigo_tipo_articulo) REFERENCES catalogo(codigo);

ALTER TABLE herramienta ADD CONSTRAINT FK_codigo_estado  FOREIGN KEY (codigo_estado) REFERENCES catalogo(codigo);

ALTER TABLE empleado_documentos ADD CONSTRAINT FK_empleado  FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado);