
/*CUADRILLA*/
INSERT INTO cuadrilla (id_cuadrilla, nombre_cuadrilla, codigo_vialidad, id_contrato, calificacion, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, '5 DE MAYO', '5MAY', NULL, 6, '2017-06-28 19:58:21', 'mimejorada', NULL, NULL, NULL, NULL, 'A');


/*RESIDENTE*/


INSERT INTO empleado (id_empleado, no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, alta_imss, observaciones, codigo_empresa, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, 'EMP0020', 1, 'JOSE', 'MEJORADA', 'SANDHEZ', '1985-03-10', 'M', 'MAHJ830101', 'MESJ850310SA5', '2017-06-28', 1200, 10, 'S', '22233332', '22323244', '5555555555', 'N', 'CORRECTO', 'TATE', 'RESI', '', 'VERD', 'CHIC', 'SISTEMAS', '2017-06-28 20:07:42', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-06-28 20:07:42', 'A');

INSERT INTO empleado (id_empleado, no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, alta_imss, observaciones, codigo_empresa, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (2, 'EMP0021', 1, 'OTRO', 'OTRO', 'OTRO', '1985-03-10', 'M', 'MAHJ830101', 'MESJ850310SA5', '2017-06-28', 1200, 10, 'S', '22233332', '22323244', '5555555555', 'N', 'CORRECTO', 'TATE', 'CABO', '', 'VERD', 'CHIC', 'SISTEMAS', '2017-06-28 20:07:42', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-06-28 20:07:42', 'A');


INSERT INTO empleado (id_empleado, no_empleado, id_cuadrilla, nombre, apellido_pat, apellido_mat, fecha_nacimiento, sexo, rfc, rfc_calculado, fecha_ingreso, sueldo, calificacion, frecuencia_pago, nss, no_credito_infonavit, telefono, alta_imss, observaciones, codigo_empresa, codigo_puesto, codigo_vialidad, codigo_area, codigo_talla, usuario_alta, fecha_alta, usuario_baja, fecha_baja, codigo_tipo_salida, codigo_causa_salida, usuario_aut_imss, fecha_aut_imss, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (3, 'EMP0021', 1, 'OTRO', 'OTRO', 'OTRO', '1985-03-10', 'M', 'MAHJ830101', 'MESJ850310SA5', '2017-06-28', 1200, 10, 'S', '22233332', '22323244', '5555555555', 'N', 'CORRECTO', 'TATE', 'PODA', '', 'VERD', 'CHIC', 'SISTEMAS', '2017-06-28 20:07:42', NULL, NULL, NULL, NULL, NULL, NULL, 'SISTEMAS', '2017-06-28 20:07:42', 'A');


INSERT INTO usuario (usuario, id_perfil, id_empleado, nombre, apellido_pat, apellido_mat, sexo, rfc, rfc_calculado, fecha_nacimiento, contrasena, cambio_contrasena, fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES ('jmejorada', 1, 1, 'JOSE', 'MEJORADA', 'SANDHEZ', 'M', 'MAHJ830101', 'MESJ850310SA5', '1985-03-10', '99851000101020020311021012520000215616a96c7a29929c0443543c2mf8a9c8', 'N', '2017-06-28 20:22:19', '2017-06-28 20:22:19', '2017-06-28 20:22:19', 'A');


INSERT INTO usuario (usuario,id_empleado,nombre,apellido_pat,apellido_mat,sexo,rfc,rfc_calculado,fecha_nacimiento,id_perfil,contrasena,cambio_contrasena,fecha_ult_acceso, fecha_alta, fecha_ult_mod, estatus)
VALUES('mimejorada', 10000,'MARIO IVAN','MEJORADA','HERRERA','H','XXXX','XXXX','1977-09-21',10,'821610101001110220100012301263064791216bc07a5b6c8206cf634lg104sgs', 'N', now(), now(), now(), 'A');


/*CONTRATO*/ 
INSERT INTO contrato (id_contrato, codigo_vialidad, codigo_contrato, codigo_documento, codigo_empresa, numero_documento, monto, subtotal, fecha_inicio, fecha_fin, dias_duracion, pct_avance, fecha_registro, id_cuadrilla, observaciones, url, metros, usuario_alta, fecha_alta, usuario_baja, fecha_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, '5MAY', 'ARVE', 'CONT', 'TATE', '1', 100, 10, '2017-06-01', '2017-06-30', 29, 0, '2017-06-28', 1, 'prueba contrato', '', 2907.75, 'mimejorada', '2017-06-28 20:00:02', NULL, NULL, NULL, NULL, 'A');


/*CONTRATO COORDENADAS*/
INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (1, 1, 1, 'Calzada de Las Bombas 16, Canal Nacional, 04909 Ciudad de M�xico, CDMX, M�xico', 19.307200000000002, -99.101299999999995, '2017-06-28 20:00:02', 'A');

INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (2, 1, 2, 'Calzada de Las Bombas 871, Cafetales II, 04480 Ciudad de M�xico, CDMX, M�xico', 19.309200000000001, -99.105699999999999, '2017-06-28 20:00:02', 'A');

INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (3, 1, 3, 'Armada de Mexico 1511, Cafetales I, 04930 Ciudad de M�xico, CDMX, M�xico', 19.3109, -99.110900000000001, '2017-06-28 20:00:02', 'A');

INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (4, 1, 4, 'Calzada de Las Bombas 421, Parque Alameda del Sur, 04800 Ciudad de M�xico, CDMX, M�xico', 19.312000000000001, -99.118899999999996, '2017-06-28 20:00:02', 'A');

INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (5, 1, 5, 'Calzada de Las Bombas 300, Ex-Ejido Sta �rsula Coapa 27 Bis, 04890 Ciudad de M�xico, CDMX, M�xico', 19.3111, -99.124099999999999, '2017-06-28 20:00:02', 'A');

INSERT INTO contrato_coordenadas (id_coordenada, id_contrato, orden, direccion, latitud, longitud, fecha_alta, estatus)
VALUES (6, 1, 6, 'Av. Canal de Miramontes 2962-2970, Girasoles II, 04920 Ciudad de M�xico, CDMX, M�xico', 19.307500000000001, -99.124200000000002, '2017-06-28 20:00:02', 'A');



/*AGENDA*/


INSERT INTO agenda (id_agenda, id_contrato, id_cuadrilla, fecha_inicio, fecha_fin, no_semana, no_trabajadores, no_horas, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, 1, 1, '2017-06-12', '2017-06-18', 24, 1, 8, '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');



INSERT INTO agenda_detalle (id_agenda_detalle, id_agenda, fecha, avance_esperado, observaciones, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, 1, '2017-06-12', 2662.8200000000002, 'agenda 1', '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');

INSERT INTO agenda_detalle (id_agenda_detalle, id_agenda, fecha, avance_esperado, observaciones, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (2, 1, '2017-06-13', 1105.79, 'agenda 2', '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');





INSERT INTO agenda_materiales (id_agenda_detalle, codigo_material, usuario_alta, fecha_alta, estatus)
VALUES (1, 'DESM', 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_materiales (id_agenda_detalle, codigo_material, usuario_alta, fecha_alta, estatus)
VALUES (2, 'CU12', 'mimejorada', '2017-06-28 20:10:03', 'A');



INSERT INTO agenda_actividades (id_agenda_detalle, codigo_actividad, usuario_alta, fecha_alta, estatus)
VALUES (1, 'INCI', 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_actividades (id_agenda_detalle, codigo_actividad, usuario_alta, fecha_alta, estatus)
VALUES (2, 'DEST', 'mimejorada', '2017-06-28 20:10:03', 'A');




INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (1, 1, 1, 'Av. Adolfo López Mateos 1, Guadalupana, 56616 Valle de Chalco Solidaridad, Méx., México', 19.274000000000001, -98.935599999999994, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (2, 1, 2, 'Av. Adolfo López Mateos, Cerro del Marquez, Valle de Chalco Solidaridad, Méx., México', 19.273299999999999, -98.938199999999995, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (3, 1, 3, 'Av. Adolfo López Mateos 6, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.2698, -98.938999999999993, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (4, 1, 4, 'Av. Adolfo López Mateos 250, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.267299999999999, -98.941699999999997, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (5, 1, 5, 'Av. Adolfo López Mateos 23, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.265599999999999, -98.945999999999998, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (6, 1, 6, 'Juventino Rosas, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.262499999999999, -98.948300000000003, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (7, 1, 7, 'Emiliano Zapata, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.259, -98.948700000000002, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (8, 1, 8, 'Emiliano Zapata, San Miguel Xico, 56613 Valle de Chalco Solidaridad, Méx., México', 19.256699999999999, -98.947500000000005, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (9, 2, 1, 'Av Tierra y Libertad 157, Emiliano Zapata, 56608 Chalco de Díaz Covarrubias, Méx., México', 19.278099999999998, -98.886700000000005, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (10, 2, 2, 'Av Tierra y Libertad 1, Emiliano Zapata, 56608 Chalco de Díaz Covarrubias, Méx., México', 19.276199999999999, -98.884900000000002, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (11, 2, 3, 'Carr Federal Cuautla-México 869, La Bomba, 56609 Chalco de Díaz Covarrubias, Méx., México', 19.277899999999999, -98.882400000000004, 'mimejorada', '2017-06-28 20:10:03', 'A');

INSERT INTO agenda_coordenadas (id_coordenada, id_agenda_detalle, orden, direccion, latitud, longitud, usuario_alta, fecha_alta, estatus)
VALUES (12, 2, 4, 'Carr Federal Cuautla-México 1084, Santa Cruz Amalinalco, 56609 Chalco de Díaz Covarrubias, Méx., México', 19.2822, -98.881399999999999, 'mimejorada', '2017-06-28 20:10:03', 'A');




/*ACTIVIDADES*/




INSERT INTO actividad_diaria (id_actividad_diaria, id_agenda, id_agenda_detalle, metros_planificado, no_trabajadores, no_horas, no_horas_trabajadas, porcentaje, observaciones, envio_autorizacion, envio_fecha_autorizacion, envio_usuario_autorizacion, autorizacion, fecha_autorizacion, usuario_autorizacion, comentario_autorizacion, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, 1, 1, 2662.8200000000002, 1, 8, 0, 0, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');

INSERT INTO actividad_diaria (id_actividad_diaria, id_agenda, id_agenda_detalle, metros_planificado, no_trabajadores, no_horas, no_horas_trabajadas, porcentaje, observaciones, envio_autorizacion, envio_fecha_autorizacion, envio_usuario_autorizacion, autorizacion, fecha_autorizacion, usuario_autorizacion, comentario_autorizacion, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (2, 1, 2, 1105.79, 1, 8, 0, 0, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');


INSERT INTO actividad_diaria_detalle (id_actividad_diaria, codigo_actividad, codigo_prioridad, codigo_estado, codigo_listo_vencido, tiempo_destinado, numero_personas, numero_unidades, porcentaje, observaciones, planeada, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (1, 'INCI', 'NORM', 'NOIN', NULL, NULL, NULL, NULL, NULL, NULL, 'S', '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');

INSERT INTO actividad_diaria_detalle (id_actividad_diaria, codigo_actividad, codigo_prioridad, codigo_estado, codigo_listo_vencido, tiempo_destinado, numero_personas, numero_unidades, porcentaje, observaciones, planeada, fecha_alta, usuario_alta, fecha_baja, usuario_baja, usuario_ult_mod, fecha_ult_mod, estatus)
VALUES (2, 'DEST', 'NORM', 'NOIN', NULL, NULL, NULL, NULL, NULL, NULL, 'S', '2017-06-28 20:10:03', 'mimejorada', NULL, NULL, NULL, NULL, 'A');





