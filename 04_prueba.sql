/*DATOS EXTRA PARA PRUEBAS*/

INSERT INTO `cuadrilla` (`id_cuadrilla`, `nombre_cuadrilla`,`id_contrato`,`calificacion`, `fecha_alta`, `usuario_alta`, `fecha_baja`, `usuario_baja`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, 'Equipo insurgentes',1,5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A'),
(2, 'Equipo EJE 6', 1, 5, '2017-01-12 00:00:00', 'SISTEMAS', NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado` (`id_empleado`, `no_empleado`, `id_cuadrilla`, `nombre`, `apellido_pat`, `apellido_mat`, `fecha_nacimiento`, `sexo`, `rfc`, `rfc_calculado`, `fecha_ingreso`, `sueldo`, `frecuencia_pago`, `nss`, `no_credito_infonavit`, `telefono`, `alta_imss`, `observaciones`, `codigo_puesto`, `codigo_vialidad`, `codigo_area`, `codigo_talla`, `usuario_alta`, `fecha_alta`, `usuario_baja`, `fecha_baja`, `codigo_tipo_salida`, `codigo_causa_salida`, `usuario_ult_mod`, `fecha_ult_mod`, `estatus`) VALUES
(1, '0394393004', 1, 'ROBERTO ANTONIO', 'COTO', 'IXTEPAN', '1987-01-28', 'H', 'COIR920801JE9', 'COIR920801JE9', '2016-09-01', '2000.00', 'M', NULL, NULL, '557904955', 'S', 'EXCELENTE', 'CHOF', 'EJE6', '5MAY', 'EXCH', 'SISTEMAS', '2016-09-15 00:00:00', NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-01-12 00:00:00', 'A');

INSERT INTO `empleado_documentos` (`id_empleado`, `codigo_emp_doc`, `fecha_alta`, `estatus`) VALUES
(1, 'ACNA', '2017-01-12 00:00:00', 'A'),
(1, 'CREL', '2017-01-12 00:00:00', 'A');


