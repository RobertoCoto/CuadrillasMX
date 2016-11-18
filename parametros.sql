USE tatei;

DELETE FROM parametros;

INSERT INTO parametros
	(	parametro,	valor,	fecha_alta,	fecha_ult_mod,	estatus	)
VALUES 
	(	'usuario.edad.ano.minimo',	'1900',	now(),	now(),	'A'	);