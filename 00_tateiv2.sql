USE tatei;


DROP TABLE IF EXISTS parametros;
DROP TABLE IF EXISTS permiso_laboral;
DROP TABLE IF EXISTS asistencia;
DROP TABLE IF EXISTS empleado_huella;
DROP TABLE IF EXISTS empleado_documentos;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS perfil_menu;
DROP TABLE IF EXISTS menu;

DROP TABLE IF EXISTS cuadrilla;

DROP TABLE IF EXISTS actividad_diaria_detalle;
DROP TABLE IF EXISTS actividad_diaria;
DROP TABLE IF EXISTS actividad_diaria_coordenadas;
DROP TABLE IF EXISTS actividad_diaria_documentos;


DROP TABLE IF EXISTS agenda_coordenadas;
DROP TABLE IF EXISTS agenda_materiales;
DROP TABLE IF EXISTS agenda_actividades;
DROP TABLE IF EXISTS agenda_detalle;
DROP TABLE IF EXISTS agenda;
DROP TABLE IF EXISTS contrato_documentos;
DROP TABLE IF EXISTS contrato_coordenadas;
DROP TABLE IF EXISTS contrato;
DROP TABLE IF EXISTS catalogo;
DROP TABLE IF EXISTS tipo_catalogo;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS herramienta;




	CREATE TABLE perfil (
	    id_perfil INT NOT NULL,
	    nombre VARCHAR(100) NOT NULL,
	    descripcion VARCHAR(100) NOT NULL,
		codigo_puesto  VARCHAR(10) NULL,
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
        usuario_ult_mod VARCHAR(20)  NULL,
        fecha_ult_mod DATETIME  NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(codigo)
    );

	CREATE TABLE usuario (
	    usuario VARCHAR(20) NOT NULL,
	    id_perfil INT NOT NULL,
		id_empleado INT NULL,
		nombre VARCHAR(80) NULL,
	    apellido_pat VARCHAR(80) NULL,
	    apellido_mat VARCHAR(80) NULL,
	    sexo  CHAR(1)  NULL CHECK(sexo IN('F','M')),
	    rfc VARCHAR(13) NULL,
	    rfc_calculado VARCHAR(15) NULL,         
	    fecha_nacimiento DATE NULL,	   
	    contrasena VARCHAR(100) NOT NULL,
	    cambio_contrasena CHAR(1) NOT NULL CHECK(cambio_contrasena IN('S','N')),
		fecha_ult_acceso DATETIME NOT NULL,
	    fecha_alta DATETIME NOT NULL,
		fecha_ult_mod DATETIME NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	    PRIMARY KEY(usuario),
	    KEY(usuario)
    );

	
    CREATE TABLE herramienta (
        id_herramienta INT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(100) NOT NULL,
        descripcion VARCHAR(100) NOT NULL,        
        fecha_ingresa DATETIME NOT NULL,        
        codigo_tipo_articulo VARCHAR(10) NOT NULL,
        codigo_estado VARCHAR(10) NOT NULL,
        marca VARCHAR(100) NOT NULL,
        modelo VARCHAR(100) NOT NULL,
 		no_serie VARCHAR(100) NOT NULL,
        usuario_alta VARCHAR(20) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        usuario_ult_mod VARCHAR(20) NULL,
        fecha_ult_mod DATETIME  NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
        PRIMARY KEY(id_herramienta)
    );
	

	/* MENU */
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
    /* MENU */
	
    CREATE TABLE empleado (
        id_empleado INT NOT NULL AUTO_INCREMENT,
        no_empleado VARCHAR(80) NOT NULL,
        id_cuadrilla INTEGER NULL,
        nombre VARCHAR(80) NOT NULL,
        apellido_pat VARCHAR(80) NOT NULL,
        apellido_mat VARCHAR(80) NOT NULL,
        fecha_nacimiento DATE NOT NULL,
        sexo  CHAR(1) NOT NULL CHECK(sexo IN('F','M')),
        rfc VARCHAR(13) NULL,
        rfc_calculado VARCHAR(15) NULL,         
        fecha_ingreso DATE NOT NULL,                        				
		sueldo DECIMAL(10,2) NOT NULL DEFAULT 0,
		calificacion INTEGER NOT NULL,
		frecuencia_pago  CHAR(1) NOT NULL CHECK(frecuencia IN('M','Q','S','')),
        nss VARCHAR(20) NULL,
        no_credito_infonavit VARCHAR(20) NULL,        
        telefono VARCHAR(10) NOT NULL,
        alta_imss CHAR(1) NULL,
        observaciones VARCHAR(100) NULL,
        codigo_empresa  VARCHAR(10) NOT NULL,
        codigo_puesto  VARCHAR(10) NOT NULL,                
        codigo_vialidad VARCHAR(10) NULL,
        codigo_area VARCHAR(10) NULL,
        codigo_talla VARCHAR(10) NULL,
        
        usuario_alta VARCHAR(20) NOT NULL,
        fecha_alta DATETIME NOT NULL,
        
        usuario_baja VARCHAR(20) NULL,
        fecha_baja DATETIME NULL,        
        codigo_tipo_salida VARCHAR(10) NULL,
        codigo_causa_salida VARCHAR(10) NULL,
        
		usuario_aut_imss VARCHAR(20)  NULL,
        fecha_aut_imss DATETIME  NULL,
        
        usuario_ult_mod VARCHAR(20)  NULL,
        fecha_ult_mod DATETIME  NULL,
        estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_empleado)
    );

    CREATE TABLE empleado_documentos (
		id_empleado INT NOT NULL,
		codigo_emp_doc VARCHAR(10) NOT NULL,
		fecha_alta DATETIME NOT NULL,	 
		estatus CHAR(2) NOT NULL CHECK(estatus IN('SI','NO','NA'))
    );

	CREATE TABLE empleado_huella (
		id_huella INT NOT NULL AUTO_INCREMENT,
		id_empleado INT NOT NULL,
		huella VARCHAR(200) NOT NULL,
		codigo_mano VARCHAR(10) NOT NULL,
		codigo_dedo VARCHAR(10) NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_huella)
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
		codigo_permiso VARCHAR(10) NOT NULL,
		
		goce_sueldo CHAR(1)  NULL CHECK(goce_sueldo IN('S','N')),
		autorizacion CHAR(1) NULL CHECK(autorizacion IN('S','N')),
		fecha_autorizacion DATETIME NULL,
		usuario_autorizacion VARCHAR(20) NULL,
		
		fecha_alta DATETIME NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_baja DATETIME NULL,
		usuario_baja VARCHAR(20) NULL,
		usuario_ult_mod varchar(20) NULL,
		fecha_ult_mod  DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_permiso),
		KEY(id_empleado)
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
		usuario_ult_mod varchar(20)  NULL,
		fecha_ult_mod  DATETIME  NULL,
		hora_entrada TIME NULL,
		hora_salida  TIME NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_asistencia),
		KEY(id_empleado)
	);

	
	CREATE TABLE contrato (
		id_contrato INTEGER NOT NULL AUTO_INCREMENT,
		codigo_vialidad VARCHAR(10) NOT NULL,
		codigo_contrato VARCHAR(10) NOT NULL, 
		codigo_documento VARCHAR(10) NOT NULL,
		codigo_empresa VARCHAR(10) NOT NULL,
		numero_documento VARCHAR(20) NOT NULL,
		monto DECIMAL(10,2) NULL,
		subtotal DECIMAL(10,2) NULL,
		fecha_inicio DATE NOT NULL,
		fecha_fin DATE NOT NULL,
		dias_duracion INTEGER NULL,
		pct_avance DECIMAL(2,2) NOT NULL,		
		fecha_registro DATE NOT NULL,
		id_cuadrilla integer NULL,
		observaciones VARCHAR(150) NULL,
		url VARCHAR(200) NOT NULL,
		metros FLOAT NOT NULL,

		usuario_alta VARCHAR(20) NOT NULL,
		fecha_alta DATETIME NOT NULL,
		usuario_baja VARCHAR(20) NULL,
		fecha_baja DATETIME NULL,
		usuario_ult_mod varchar(20)  NULL,
		fecha_ult_mod  DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_contrato),
		KEY(id_contrato)
	);

	CREATE TABLE contrato_coordenadas (
		id_coordenada INTEGER NOT NULL AUTO_INCREMENT,
		id_contrato INTEGER NOT  NULL,
		orden INTEGER NOT NULL,
		direccion VARCHAR(150) NOT NULL,
		latitud FLOAT NOT NULL,
		longitud FLOAT NOT NULL,
		fecha_alta DATETIME NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_coordenada),
		KEY (id_coordenada)
	);

	CREATE TABLE contrato_documentos (
		id_documento INTEGER NOT NULL AUTO_INCREMENT,
		id_contrato INTEGER NOT  NULL,
		nombre VARCHAR(150) NOT NULL,
		codigo_documento VARCHAR(10) NOT NULL,		
		url VARCHAR(200) NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_alta DATETIME NOT NULL,		
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_documento),
		KEY (id_documento)
	);




	CREATE TABLE cuadrilla (
		id_cuadrilla INTEGER NOT NULL AUTO_INCREMENT,
		nombre_cuadrilla VARCHAR(50) NOT NULL,
		codigo_vialidad VARCHAR(10) NULL,
		id_contrato INTEGER NULL,
		calificacion INTEGER NOT NULL,
		fecha_alta DATETIME NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_baja DATETIME NULL,
		usuario_baja VARCHAR(20) NULL,
		usuario_ult_mod varchar(20) NULL,
		fecha_ult_mod  DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_cuadrilla)
	);

	CREATE TABLE agenda (
		id_agenda INTEGER NOT NULL AUTO_INCREMENT,
		id_contrato INTEGER NOT NULL,
		id_cuadrilla INTEGER NOT NULL,
		fecha_inicio DATE NOT NULL,
		fecha_fin DATE NOT NULL,
		no_semana INTEGER NOT NULL,
		no_trabajadores INTEGER NOT NULL,
		no_horas INTEGER NOT NULL,
		fecha_alta DATETIME NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_baja DATETIME NULL,
		usuario_baja VARCHAR(20) NULL,
		usuario_ult_mod varchar(20) NULL,
		fecha_ult_mod  DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_agenda),
		KEY (id_agenda)
	);
	
	CREATE TABLE agenda_detalle (
		id_agenda_detalle INTEGER NOT NULL AUTO_INCREMENT,
		id_agenda INTEGER NOT NULL,
		fecha DATE NOT NULL,
		avance_esperado FLOAT NOT NULL,
		observaciones VARCHAR(150) NULL,		
		fecha_alta DATETIME NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_baja DATETIME NULL,
		usuario_baja VARCHAR(20) NULL,
		usuario_ult_mod varchar(20) NULL,
		fecha_ult_mod  DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_agenda, fecha),
		KEY (id_agenda_detalle)
	);

	CREATE TABLE agenda_coordenadas (
		id_coordenada INTEGER NOT NULL AUTO_INCREMENT,
		id_agenda_detalle INTEGER NOT  NULL,
		orden INTEGER NOT NULL,
		direccion VARCHAR(150) NOT NULL,
		latitud FLOAT NOT NULL,
		longitud FLOAT NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_alta DATETIME NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_coordenada),
		KEY (id_coordenada)
	);

	CREATE TABLE agenda_actividades (		
		id_agenda_detalle INTEGER NOT NULL,
		codigo_actividad VARCHAR(10) NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_alta DATETIME NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
	);

	CREATE TABLE agenda_materiales (		
		id_agenda_detalle INTEGER NOT NULL,
		codigo_material VARCHAR(10) NOT NULL,
		usuario_alta VARCHAR(20) NOT NULL,
		fecha_alta DATETIME NOT NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
	);
	
	
	CREATE TABLE actividad_diaria (
		id_actividad_diaria		 	INTEGER NOT NULL AUTO_INCREMENT,				
		id_agenda 					INTEGER NOT NULL,
		id_agenda_detalle 			INTEGER NOT NULL,
		metros_planificado			FLOAT NOT NULL,		
		no_trabajadores 			INTEGER NOT NULL,
		no_horas 					INTEGER NOT NULL,		
		no_horas_trabajadas			INTEGER NOT NULL,
		porcentaje			 		FLOAT  NULL,					   		   						
		observaciones 	 			VARCHAR(500) NULL,
		
		envio_autorizacion 		 	CHAR(1) NULL CHECK(autorizacion IN('S','N')),
		envio_fecha_autorizacion 	DATETIME NULL,
		envio_usuario_autorizacion	VARCHAR(20) NULL,
								   	  										   	  				
		autorizacion 				CHAR(1) NULL CHECK(autorizacion IN('S','N')),
		fecha_autorizacion 			DATETIME NULL,
		usuario_autorizacion 		VARCHAR(20) NULL,
		comentario_autorizacion		VARCHAR(500) NULL,
		
		fecha_alta 					DATETIME NOT NULL,
		usuario_alta 				VARCHAR(20) NOT NULL,
		fecha_baja 					DATETIME NULL,
		usuario_baja 				VARCHAR(20) NULL,
		usuario_ult_mod 			VARCHAR(20)  NULL,
		fecha_ult_mod  				DATETIME  NULL,
		estatus 					CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		
		PRIMARY KEY(id_agenda, id_agenda_detalle),
		KEY (id_actividad_diaria)
	);
	
	
	CREATE TABLE actividad_diaria_detalle (	  
		id_actividad_diaria		 	INTEGER NOT NULL,	 
		codigo_actividad 			VARCHAR(10) NOT NULL,				
				
		codigo_prioridad 			VARCHAR(10) NOT NULL,
		codigo_estado  				VARCHAR(10) NOT NULL,	
		codigo_listo_vencido 		VARCHAR(10)  NULL,		
		tiempo_destinado  			INTEGER  NULL,
		numero_personas 			INTEGER  NULL,	 
		numero_unidades 			INTEGER  NULL,
		porcentaje			 		FLOAT  NULL,
		observaciones 	 			VARCHAR(500) NULL,		
		planeada 					CHAR NOT NULL,		
										   			   
		fecha_alta 					DATETIME NOT NULL,
		usuario_alta 				VARCHAR(20) NOT NULL,
		fecha_baja 					DATETIME NULL,
		usuario_baja 				VARCHAR(20)  NULL,		
		usuario_ult_mod 			VARCHAR(20)  NULL,
		fecha_ult_mod  				DATETIME  NULL,
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
		PRIMARY KEY(id_actividad_diaria, codigo_actividad)
	);
	
	
   
	CREATE TABLE actividad_diaria_coordenadas (	 
		id_actividad_diaria	INTEGER NOT NULL,
		orden 				INTEGER NOT NULL,
		direccion 			VARCHAR(150) NOT NULL,
		latitud 			FLOAT NOT NULL,
		longitud 			FLOAT NOT NULL,
		usuario_alta 		VARCHAR(20) NOT NULL,
		fecha_alta 			DATETIME NOT NULL,
		estatus 			CHAR(1) NOT NULL CHECK(estatus IN('A','I'))
	);
	
	CREATE TABLE actividad_diaria_documentos (
		id_actividad_diaria	INTEGER NOT NULL,
		codigo_actividad 	VARCHAR(10) NOT NULL,
		consecutivo 		INTEGER NOT NULL,				
		url 				VARCHAR(200) NOT NULL,
		usuario_alta 		VARCHAR(20) NOT NULL,
		fecha_alta 			DATETIME NOT NULL,		
		estatus CHAR(1) NOT NULL CHECK(estatus IN('A','I')),
	  	PRIMARY KEY(id_actividad_diaria,codigo_actividad,consecutivo)
	);

	
ALTER TABLE catalogo ADD CONSTRAINT FK_tipo_catalogo FOREIGN KEY(tipo_catalogo) REFERENCES tipo_catalogo(tipo_catalogo);
ALTER TABLE catalogo ADD CONSTRAINT FK_cat_usuario FOREIGN KEY(usuario_alta) REFERENCES usuario(usuario);
ALTER TABLE catalogo ADD CONSTRAINT FK_cat_usuariom FOREIGN KEY(usuario_ult_mod) REFERENCES usuario(usuario);
	
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil);

ALTER TABLE perfil_menu ADD CONSTRAINT FK_perfil_menu FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
ALTER TABLE perfil_menu ADD CONSTRAINT FK_Perfil_menu_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfil(id_perfil);

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_puesto FOREIGN KEY(codigo_puesto) REFERENCES catalogo(codigo);
/*ALTER TABLE empleado ADD CONSTRAINT FK_codigo_vialidad FOREIGN KEY(codigo_vialidad) REFERENCES catalogo(codigo);*/

ALTER TABLE empleado ADD CONSTRAINT FK_codigo_area FOREIGN KEY(codigo_area) REFERENCES catalogo(codigo);
ALTER TABLE empleado ADD CONSTRAINT FK_codigo_talla FOREIGN KEY(codigo_talla) REFERENCES catalogo(codigo);
ALTER TABLE empleado ADD CONSTRAINT FK_codigo_tipo_salida FOREIGN KEY(codigo_tipo_salida) REFERENCES catalogo(codigo);
ALTER TABLE empleado ADD CONSTRAINT FK_codigo_causa_salida FOREIGN KEY(codigo_causa_salida) REFERENCES catalogo(codigo);
ALTER TABLE empleado ADD CONSTRAINT FK_codigo_empresa FOREIGN KEY(codigo_empresa) REFERENCES catalogo(codigo);
		
/*ALTER TABLE contrato ADD CONSTRAINT FK_con_codigo_vialidad  FOREIGN KEY (codigo_vialidad) REFERENCES catalogo(codigo);*/
ALTER TABLE contrato ADD CONSTRAINT FK_con_codigo_contrato  FOREIGN KEY (codigo_contrato) REFERENCES catalogo(codigo);
ALTER TABLE contrato ADD CONSTRAINT FK_con_codigo_documento  FOREIGN KEY (codigo_documento) REFERENCES catalogo(codigo);
ALTER TABLE contrato ADD CONSTRAINT FK_con_codigo_empresa  FOREIGN KEY (codigo_empresa) REFERENCES catalogo(codigo);

ALTER TABLE empleado_documentos ADD CONSTRAINT FK_empleado  FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado);
ALTER TABLE empleado_documentos ADD CONSTRAINT FK_emp_codigo_emp_doc  FOREIGN KEY (codigo_emp_doc) REFERENCES catalogo(codigo);

ALTER TABLE permiso_laboral ADD CONSTRAINT FK_id_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado);

/*ALTER TABLE actividad_diaria ADD CONSTRAINT FK_id_cuadrilla FOREIGN KEY (id_cuadrilla) REFERENCES cuadrilla(id_cuadrilla);*/

ALTER TABLE contrato_coordenadas ADD CONSTRAINT FK_id_contrato FOREIGN KEY (id_contrato) REFERENCES contrato(id_contrato);
ALTER TABLE contrato_documentos ADD CONSTRAINT FK_cd_id_contrato FOREIGN KEY (id_contrato) REFERENCES contrato(id_contrato);


ALTER TABLE asistencia ADD CONSTRAINT FK_idEmpleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado);

ALTER TABLE agenda ADD CONSTRAINT FK_a_id_contrato FOREIGN KEY (id_contrato) REFERENCES contrato (id_contrato);

ALTER TABLE agenda_detalle ADD CONSTRAINT FK_d_id_agenda FOREIGN KEY (id_agenda) REFERENCES agenda (id_agenda);

ALTER TABLE agenda_coordenadas ADD CONSTRAINT FK_id_agenda_detalle FOREIGN KEY (id_agenda_detalle) REFERENCES agenda_detalle (id_agenda_detalle);

ALTER TABLE agenda_actividades ADD CONSTRAINT FK_a_id_agenda FOREIGN KEY (id_agenda_detalle) REFERENCES agenda_detalle (id_agenda_detalle);
ALTER TABLE agenda_actividades ADD CONSTRAINT FK_codigo_actividad FOREIGN KEY (codigo_actividad) REFERENCES catalogo(codigo);

ALTER TABLE agenda_materiales ADD CONSTRAINT FK_m_id_agenda FOREIGN KEY (id_agenda_detalle) REFERENCES agenda_detalle (id_agenda_detalle);

/*ALTER TABLE cuadrilla ADD CONSTRAINT FK_cua_id_contrato FOREIGN KEY (id_contrato) REFERENCES contrato (id_contrato);*/

ALTER TABLE permiso_laboral ADD CONSTRAINT FK_codigo_permiso  FOREIGN KEY (codigo_permiso) REFERENCES catalogo(codigo);


ALTER TABLE actividad_diaria_detalle ADD CONSTRAINT FK_adcodigo_actividad  FOREIGN KEY (codigo_actividad) REFERENCES catalogo(codigo);
ALTER TABLE actividad_diaria_detalle ADD CONSTRAINT FK_adcodigo_prioridad  FOREIGN KEY (codigo_prioridad) REFERENCES catalogo(codigo);
ALTER TABLE actividad_diaria_detalle ADD CONSTRAINT FK_adcodigo_estado  FOREIGN KEY (codigo_estado) REFERENCES catalogo(codigo);
ALTER TABLE actividad_diaria_detalle ADD CONSTRAINT FK_adcodigo_listo_vencido  FOREIGN KEY (codigo_listo_vencido) REFERENCES catalogo(codigo);
