/*DATOS EXTRA PARA PRUEBAS*/

INSERT INTO `vialidad` (`id_vialidad`, `nombre`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'INSURGENTES', 'SISTEMAS', '2017-01-12 00:00:00', NULL, NULL, '', '0000-00-00 00:00:00', 'A'),
(2, '5 DE MAYO', 'SISTEMAS', '2017-01-12 00:00:00', NULL, NULL, '', '0000-00-00 00:00:00', 'A');

INSERT INTO `vialidad_coordenadas` (`id_coordenada`, `id_vialidad`, `latitud`, `longitud`, `fecha_alta`, `estatus`) VALUES
(1, 1, 19.3673, -99.1758, '2017-01-12 00:00:00', 'A'),
(2, 2, 19.4202, -99.1559, '2017-01-12 00:00:00', 'A');

INSERT INTO `cuadrilla` (`id_cuadrilla`, `nombre_cuadrilla`, `id_vialidad`, `numero_personas`, `calificacion`, `fecha_alta`, `usuario_alta`, `fecha_baja`, `usuario_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'Equipo insurgentes', 2, 11, 5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A'),
(2, 'Equipo EJE 6', 1, 5, 5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado` (`id_empleado`, `no_empleado`, `id_cuadrilla`, `nombre`, `apellido_pat`, `apellido_mat`, `fecha_nacimiento`, `sexo`, `rfc`, `rfc_calculado`, `fecha_ingreso`, `sueldo`, `frecuencia_pago`, `nss`, `no_credito_infonavit`, `telefono`, `alta_imss`, `observaciones`, `codigo_puesto`, `codigo_vialidad`, `codigo_area`, `codigo_talla`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `codigo_tipo_salida`, `codigo_causa_salida`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'JUAN ALBERTO PEREZ ROMAN', 1, 'JUAN ALBERTO', 'PEREZ', 'ROMAN', '1987-01-28', 'H', 'PERJ870128JE7', 'PERJ870128JE7', '2016-09-01', '2000.00', 'M', NULL, NULL, '557904955', 'S', 'EXCELENTE', 'CHOF', 'EJE6', '5MAY', 'EXCH', 'SISTEMAS', '2016-09-15 00:00:00', NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado_documentos` (`id_empleado`, `codigo_emp_doc`, `fecha_alta`, `estatus`) VALUES
(1, 'ACNA', '2017-01-12 00:00:00', 'A'),
(1, 'CREL', '2017-01-12 00:00:00', 'A');