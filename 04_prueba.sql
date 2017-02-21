/*DATOS EXTRA PARA PRUEBAS*/



DELETE FROM usuario WHERE usuario != 'SISTEMAS';
DELETE FROM cuadrilla;
DELETE FROM empleado_documentos;
DELETE FROM empleado;

INSERT INTO `cuadrilla` (`id_cuadrilla`, `nombre_cuadrilla`, `codigo_vialidad`, `id_contrato`,`calificacion`, `fecha_alta`, `usuario_alta`, `fecha_baja`, `usuario_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'Equipo Insurgentes','INSU', NULL, 10, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A'),
(2, 'Equipo EJE 6', 'EJE6', NULL,  8, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');



INSERT INTO usuario (usuario,id_empleado,nombre,apellido_pat,apellido_mat,sexo,rfc,rfc_calculado,fecha_nacimiento,id_perfil,contrasena,cambio_contrasena,fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES('mimejorada', 1,'MARIO IVAN','MEJORADA','HERRERA','H','XXXX','XXXX','1977-09-21',10,'821610101001110220100012301263064791216bc07a5b6c8206cf634lg104sgs', 'N', now(), now(), now(), 'A');



/*Empleados*/

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0001', 1, 'MARIO IVAN', 'MEJORADA', 'HERRERA', '1985-06-03', 'M', 'MEHM850306MZ2', 'MEHM850603MZ7', '2017-02-09', 10000, 9, 'S', '1234567890', '1234567890', '5585379530', NULL, 'N', 'muy buen empleado', 'RESI', 'INSU', 'VERD', 'GRAN', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:41:27', 'A');

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0002', 1, 'VICTOR', 'HERRERA', 'CORTES', '1986-02-04', 'M', 'MEHM850306', 'HECV860204DT1', '2017-02-09', 5000, 7, 'S', '1234567890', '123456789', '1234567890', NULL, 'N', 'nuevo', 'CHOF', '5MAY', 'VERD', 'CHIC', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:45:49', 'A');

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0003', 1, 'LUIS RODRIGO', 'SOTO', 'SOLORZANO', '1971-02-26', 'M', 'LSTM710226JRR', 'SOSL710226LG1', '2017-02-09', 1000, 9, 'S', '12345678990', '12345678990', '1234567890', NULL, 'N', 'otro nuevo', 'PODA', '5MAY', 'VERD', 'CHIC', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:57:35', 'A');

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0004', 1, 'MARTIN', 'MARTINEZ', 'SUAREZ', '1971-02-26', 'M', 'LSTM710226JRR', 'SOSL710226LG2', '2017-02-09', 1000, 9, 'S', '12345678990', '12345678990', '1234567890', NULL, 'N', 'otro nuevo', 'PODA', '5MAY', 'VERD', 'CHIC', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:57:35', 'A');

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0005', 1, 'ELVIRA', 'GARCIA', 'SOLANO', '1971-02-26', 'M', 'LSTM710226JRR', 'SOSL710226LG3', '2017-02-09', 1000, 9, 'S', '12345678990', '12345678990', '1234567890', NULL, 'N', 'otro nuevo', 'PODA', '5MAY', 'VERD', 'CHIC', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:57:35', 'A');

INSERT INTO empleado ( no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, huella, alta_imss, observaciones, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES ('EMP0006', 2, 'HECTOR', 'RODRIGUEZ', 'SOLANO', '1985-06-03', 'M', 'MEHM850306MZ2', 'MEHM850603MZ7', '2017-02-09', 10000, 9, 'S', '1234567890', '1234567890', '5585379530', NULL, 'N', 'muy buen empleado', 'RESI', 'INSU', 'VERD', 'GRAN', 'SISTEMAS', '2017-02-09 19:41:27', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-02-09 19:41:27', 'A');


INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'ACNA', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'CDOM', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'CNFR', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'DOCM', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'IMSS', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'NINF', '2017-02-09 19:41:28', 'SI');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'CREL', '2017-02-09 19:41:28', 'NO');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'CURP', '2017-02-09 19:41:28', 'NA');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'CUVI', '2017-02-09 19:41:28', 'NA');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'DRFC', '2017-02-09 19:41:28', 'NA');

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
VALUES (1, 'SOEM', '2017-02-09 19:41:28', 'NA');


INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
SELECT 2, codigo_emp_doc, fecha_alta, estatus FROM empleado_documentos WHERE id_empleado = 1;

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
SELECT 3, codigo_emp_doc, fecha_alta, estatus FROM empleado_documentos WHERE id_empleado = 1;

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
SELECT 4, codigo_emp_doc, fecha_alta, estatus FROM empleado_documentos WHERE id_empleado = 1;

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
SELECT 5, codigo_emp_doc, fecha_alta, estatus FROM empleado_documentos WHERE id_empleado = 1;

INSERT INTO empleado_documentos (id_empleado, codigo_emp_doc, fecha_alta, estatus)
SELECT 6, codigo_emp_doc, fecha_alta, estatus FROM empleado_documentos WHERE id_empleado = 1;



INSERT INTO `contrato` (`id_contrato`, `codigo_vialidad`, `codigo_contrato`, `codigo_documento`, `codigo_empresa`, `numero_documento`, `monto`, `subtotal`, `fecha_inicio`, `fecha_fin`, `dias_duracion`, `pct_avance`, `fecha_registro`, `id_cuadrilla`, `observaciones`, `url`, `metros`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'UNIV', 'ARVE', 'CONT', 'TATE', 'A-12345567', '0.00', '0.00', '2015-12-01', '2016-12-01', 364, '0.00', '2017-02-20', 1, '', '', 2000, 'usuario', '2017-02-20 13:19:27', NULL, NULL, NULL, NULL, 'A');

INSERT INTO `contrato` (`id_contrato`, `codigo_vialidad`, `codigo_contrato`, `codigo_documento`, `codigo_empresa`, `numero_documento`, `monto`, `subtotal`, `fecha_inicio`, `fecha_fin`, `dias_duracion`, `pct_avance`, `fecha_registro`, `id_cuadrilla`, `observaciones`, `url`, `metros`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(2, 'UNIV', 'ARVE', 'CONT', 'TATE', 'A-12345567', '0.00', '0.00', '2015-12-01', '2016-12-01', 364, '0.00', '2017-02-20', 2, '', '', 2000, 'usuario', '2017-02-20 13:19:27', NULL, NULL, NULL, NULL, 'A');


INSERT INTO `contrato_coordenadas` (`id_coordenada`, `id_contrato`, `orden`, `direccion`, `latitud`, `longitud`, `fecha_alta`, `estatus`) VALUES
(1, 1, 1, '', 19.3507, -99.0748, '2017-02-20 13:19:27', 'A'),
(2, 1, 2, '', 19.3556, -99.0967, '2017-02-20 13:19:27', 'A');

INSERT INTO `contrato_coordenadas` (`id_coordenada`, `id_contrato`, `orden`, `direccion`, `latitud`, `longitud`, `fecha_alta`, `estatus`) VALUES
(3, 2, 1, '', 19.3507, -99.0748, '2017-02-20 13:19:27', 'A'),
(4, 2, 2, '', 19.3556, -99.0967, '2017-02-20 13:19:27', 'A');