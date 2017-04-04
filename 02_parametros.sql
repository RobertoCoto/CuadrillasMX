USE tatei;

DELETE FROM parametros;

INSERT INTO parametros (parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES 	('usuario.edad.ano.minimo',	'18',	now(),	now(),	'A'	);

INSERT INTO parametros  (	parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES  ('perfil.residente',	'1',	now(),	now(),	'A'	);

INSERT INTO parametros  (	parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES  ('perfil.crea.usuario',	'RESI;OFCE',	now(),	now(),	'A'	);

INSERT INTO parametros  (	parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES  ('empleado.notifica.imss',	'90',	now(),	now(),	'A'	);

INSERT INTO parametros  (	parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES  ('empleado.hora.laboral',	'8',	now(),	now(),	'A'	);


 