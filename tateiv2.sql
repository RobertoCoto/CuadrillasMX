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
DROP TABLE IF EXISTS cuadrilla;
DROP TABLE IF EXISTS asistencia;
DROP TABLE IF EXISTS permiso_laboral;
DROP TABLE IF EXISTS vialidad;
DROP TABLE IF EXISTS contrato;

CREATE TABLE usuario (
    usuario VARCHAR(20) NOT NULL,
	id_empleado INT NULL,
	nombre VARCHAR(80) NOT NULL,
    apellido_pat VARCHAR(80) NOT NULL,
    apellido_mat VARCHAR(80) NOT NULL,
    sexo  CHAR(1) NOT NULL CHECK(sexo IN('F','M')),
    rfc VARCHAR(13) NULL,
    rfc_calculado VARCHAR(15) NULL,         
    fecha_nacimiento DATE NOT NULL,
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
        usuario_alta VARCHAR(20) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        usuario_ult_mod VARCHAR(20) NOT NULL,
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
        fecha_nacimiento DATE NOT NULL,
        fecha_ingreso DATE NOT NULL,        
        codigo_puesto  VARCHAR(10) NOT NULL,                
        codigo_vialidad VARCHAR(10) NOT NULL,
        codigo_area VARCHAR(10) NULL,
        codigo_talla VARCHAR(10) NULL,
		id_cuadrilla INTEGER NOT NULL,
		sueldo DECIMAL(10,2) NOT NULL DEFAULT 0,
		frecuencia_pago  CHAR(1) NOT NULL CHECK(frecuencia IN('M','Q','S','')),
        nss VARCHAR(20) NULL,
        no_credito_infonavit VARCHAR(20) NULL,        
        telefono VARCHAR(10) NOT NULL,
        observaciones VARCHAR(100) NULL,
        usuario_alta VARCHAR(20) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        usuario_baja VARCHAR(20) NULL,
        fecha_baja DATETIME NULL,
        codigo_tipo_salida VARCHAR(10) NULL,
        codigo_causa_salida VARCHAR(10) NULL,
        usuario_ult_mod VARCHAR(20) NOT NULL,
        fecha_ult_mod DATETIME NOT NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_empleado)
    );

    CREATE TABLE empleado_documentos (
		id_empleado INT NOT NULL,
		codigo_emp_doc VARCHAR(10) NOT NULL,
		fecha_alta DATETIME NOT NULL,	 
		estatus CHAR(2) NOT NULL CHECK(estatus IN('SI','NO','NA'))
    );
	
	CREATE TABLE vialidad (
	id_vialidad INTEGER AUTO_INCREMENT NOT NULL,
	nombre varchar(40) NOT NULL,
	latitud float NOT NULL,
	longitud float NOT NULL,
	usuario_alta varchar(20)NOT NULL,
	fecha_alta DATETIME NOT NULL,
	usuario_baja varchar(20) NULL,
	fecha_baja  DATETIME NULL,
	usuario_ult_mod varchar(20) NOT NULL,
	fecha_ult_mod  DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
    PRIMARY KEY(id_vialidad)
	);
	
	CREATE TABLE asistencia (
	id_asistencia INTEGER NOT NULL AUTO_INCREMENT,
	id_empleado INTEGER NOT NULL,
	fecha DATE NOT NULL,
	comentarios VARCHAR(200) NULL,
	fecha_alta DATETIME NOT NULL,
	usuario_alta VARCHAR(20) NOT NULL,
	fecha_baja DATETIME NULL,
	usuario_baja VARCHAR(20) NULL,
	usuario_ult_mod varchar(20) NOT NULL,
	fecha_ult_mod  DATETIME NOT NULL,
	hora_entrada TIME NULL,
	hora_salida  TIME NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	PRIMARY KEY(id_asistencia)
	);
	
	CREATE TABLE contrato (
	id_contrato INTEGER NOT NULL AUTO_INCREMENT,
	numero_contrato INTEGER NOT NULL,
	id_empleado INTEGER NOT NULL,
	fecha_registro DATE NOT NULL,
	id_vialidad integer NOT NULL,
	direccion_inicial VARCHAR(150) NOT NULL,
	latitud_inicial float NOT NULL,
	longitud_incial float NOT NULL,
	direccion_final VARCHAR(150) NOT NULL,
	latitud_final  float NOT NULL,
	longitud_final float NOT NULL,
	fecha_alta DATETIME NOT NULL,
	usuario_alta VARCHAR(20) NOT NULL,
	fecha_baja DATETIME NULL,
	usuario_baja VARCHAR(20) NULL,
	usuario_ult_mod varchar(20) NOT NULL,
	fecha_ult_mod  DATETIME NOT NULL,
	observaciones VARCHAR(150) NULL,
	url VARCHAR(200) NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	PRIMARY KEY(id_contrato)
	);
	
	CREATE TABLE cuadrilla (
	id_cuadrilla INTEGER NOT NULL AUTO_INCREMENT,
	nombre_cuadrilla VARCHAR(50) NOT NULL,
	id_vialidad INTEGER NOT NULL,
	numero_personas INTEGER NOT NULL,
	calificacion INTEGER NOT NULL,
	fecha_alta DATETIME NOT NULL,
	usuario_alta VARCHAR(20) NOT NULL,
	fecha_baja DATETIME NULL,
	usuario_baja VARCHAR(20) NULL,
	usuario_ult_mod varchar(20) NOT NULL,
	fecha_ult_mod  DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	PRIMARY KEY(id_cuadrilla)
	);
	
	CREATE TABLE permiso_laboral (
	id_permiso INTEGER NOT NULL AUTO_INCREMENT,
	id_empleado INTEGER NOT NULL,
	comentarios VARCHAR(150) NULL,
	fecha_solicitud DATE NOT NULL,
	fecha_solicitud_minimo DATE NOT NULL,
	fecha_solicitud_maximo DATE NOT NULL,
	hora_solicitud_minimo TIME NOT NULL,
	hora_solicitud_maxima TIME NOT NULL,
	tipo_permiso VARCHAR(50) NOT NULL,
	autorizacion CHAR(1) NOT NULL CHECK(autorizacion IN('S','N')),
	fecha_autorizacion DATETIME NULL,
	usuario_autorizacion VARCHAR(20) NULL,
	fecha_alta DATETIME NOT NULL,
	usuario_alta VARCHAR(20) NOT NULL,
	fecha_baja DATETIME NULL,
	usuario_baja VARCHAR(20) NULL,
	usuario_ult_mod varchar(20) NOT NULL,
	fecha_ult_mod  DATETIME NOT NULL,
	estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	PRIMARY KEY(id_permiso),
	KEY(id_empleado)
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

ALTER TABLE permiso_laboral ADD CONSTRAINT FK_id_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado);