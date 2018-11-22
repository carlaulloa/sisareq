USE DBHELPDESK;

-- ROL
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (1,'SOLICITANTE','Solicitante');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (2,'SOLICITANTE_AV','Solicitante avanzado');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (3,'OPERADOR','Operador');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (4,'ADMINISTRADOR','Adm. de Configuración');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (5,'ADMIN_ACTIVOS_TI','Adm. de activos de TI');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (6,'GESTOR_PROBLEMAS','Gestor de problemas');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (7,'GESTOR_CAMBIOS','Gestor de cambios');
INSERT INTO Rol(id_rol,nombre_rol,descripcion) VALUES (8,'USUARIO_CAB','Usuario CAB');

COMMIT;

-- USUARIO
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (1,'solicitanteav1','123','Carla','Contreras','Ulloa',2,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (2,'solicitanteav2','123','Favio','Vasquez','Casana',2,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (3,'ope01','000','Favio','VasquezWXYZ','Casanax',3,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (4,'ope02','000','Ajax','Sarmek','Visco',3,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,usuario_id,rol_id,estado) VALUES (5,'solicitante1','456','Edwin','Mallma','R',1,1,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,usuario_id,rol_id,estado) VALUES (6,'solicitante2','456','Jhonatan','Urbina','K',2,1,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (7,'adminconf','123456','Chito','Elvio','Iador',4,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (8,'ope03','000','Atari','Sarmek','Visco',3,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (9,'adm_ti','234','Arya','Stark','G',5,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (10,'gstprob','567','John','Snow','Visco',6,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (11,'gstcmbs','567','Ramsey','Bolton','G',7,1);
INSERT INTO Usuario(id_usuario,nombre_usuario,contrasenia,nombre,apellido_pat, apellido_mat,rol_id,estado) VALUES (12,'usercab','567','Elice','Fer','G',8,1);


COMMIT;


-- ROL OPERADOR
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (1,'NIVEL1_SHD', 'Supervisor de nivel 1, deriva tickets');
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (2,'NIVEL1_HD', 'Primer nivel, atención tickets');
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (3,'NIVEL2_SH', 'Segundo nivel, Soporte Hardware');
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (4,'NIVEL2_SI', 'Segundo nivel, Soporte Infraestructura');
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (5,'NIVEL2_SERP', 'Segundo nivel, Soporte ERP');
INSERT INTO RolOperador(ID_ROL_OPERADOR,NOMBRE_ROL_OPE, DESCRIPCION) VALUES (6,'NIVEL2_SSC', 'Segundo nivel, Soporte Servicio de Correo');

COMMIT;

-- OPERADOR
INSERT INTO Operador(ID_OPERADOR,NIVEL, ROL_OPERADOR_ID, USUARIO_ID) VALUES (1,1,1,3);
INSERT INTO Operador(ID_OPERADOR,NIVEL, ROL_OPERADOR_ID, USUARIO_ID) VALUES (2,2,3,4);
INSERT INTO Operador(ID_OPERADOR,NIVEL, ROL_OPERADOR_ID, USUARIO_ID) VALUES (3,1,2,8);

COMMIT;

-- SLA
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(1,'SLA1',1,0,0,0,10,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(2,'SLA2',2,0,0,0,20,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(3,'SLA3',3,0,0,0,30,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(4,'SLA4',4,0,0,0,40,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(5,'SLA5',5,0,0,0,50,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(6,'SLA6',6,0,0,1,0,0,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(7,'SLA7',7,0,0,0,0,1,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(8,'SLA8',8,0,0,0,0,1,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(9,'SLA9',0,0,1,0,0,1,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(10,'SLA10',1,1,0,0,0,1,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(11,'SLA11',2,1,0,0,0,1,1);
INSERT INTO SLA(id_sla,nombre_sla,tresolucion_hh,tresolucion_mm,tresolucion_dd,trespuesta_hh,trespuesta_mm,trespuesta_dd,estado) VALUES 
(12,'SLA12',3,1,0,0,0,1,1);

COMMIT;


-- SERVICIO
INSERT INTO SERVICIO(id_servicio,nombre, nivel, sla_id) VALUES (1,'servicios tecnologicos',1, 4);
	INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (2,'acceso',2,1,4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (3,'configuracion de wan',3,2, 1);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (4,'soporte de red',3,2, 3);
        INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (5, 1,'configuracion de firewall',3,2, 1);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (6, 1,'configuracion de switches',3,2, 5);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (7, 1,'configuracion de proxy',3,2, 4);
        
	INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (8,'aplicación y transacciones',2,1, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (9,'configuracion de correo electronico',3,8, 1);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (10,'soporte correo electronico',3,8, 1);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (11,'soporte agente anti-spam',3,8, 3);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (12,'soporte sistema contabilidad',3,8, 6);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (13,'soporte sistema departamento de personal',3,8, 6);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (14,'soporte sistema de stock',3,8, 7);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (15,'soporte sistema de facturacion',3,8, 8);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (16,'soporte sistema administrativo',3,8, 8);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (17,'soporte sistema proceso de produccion',3,8, 8);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (18,'soporte suite speed office',3,8, 5);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (19,'soporte otras aplicaciones',3,8, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (20,'soporte de base de datos',3,8, 8);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (21,'generacion de backups de datos',3,8, 12);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (22, 1,'administracion de versiones de aplicaciones',3,8, 12);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (23,'servidor de respaldo',3,8, 12);
        
	INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (24,'seguridad informatica',2,1, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (25,'configuracion de antivirus',3,24, 2);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (26,'actualizacion de firmas de antivirus',3,24, 4);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (27,'deteccion de codigos maliciosos',3,24, 4);
	
    INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (28,'comunicaciones',2,1, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (29,'sistema de intercomunicacion',3,28, 5);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (30,'servicio de datos',3,28, 6);
        INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (31,'servicio de voz',3,28, 6);
	
    INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (32,'hardware',2,1, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (33,'sistema de intercomunicacion',3,32, 4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (34,'servicio de datos',3,32, 4);
        
INSERT INTO SERVICIO(id_servicio,nombre, nivel, sla_id) VALUES (35,'servicios profesionales',1, 4);
	INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (36,'soporte y calidad de servicio',2,35,4);
		INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (37,'optimizacion de helpdesk',3,36, 12);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (38, 1,'admin. base de datos incidentes',3,36, 12);
        INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (39, 1,'admin. base de datos problemas',3,36, 12);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (40, 1,'admin. base de datos conocimientos',3,36, 12);
        
	INSERT INTO SERVICIO(id_servicio,nombre, nivel,servicio_padre, sla_id) VALUES (41,'servicios informaticos generales',2,35,4);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (42, 1,'administracion de active desktop',3,41, 4);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (43, 1,'conf. de redundancia de servidores',3,41, 12);
        INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (44, 1,'configuracion de servidores de backup',3,41, 12);
		INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (45, 1,'admin. agente de configuraciones',3,41, 6);
        INSERT INTO SERVICIO(id_servicio, si_autorizacion, nombre, nivel,servicio_padre, sla_id) VALUES (46, 1,'gestion de suministro electrico',3,41, 8);
        
INSERT INTO SERVICIO(id_servicio,nombre, nivel, sla_id) VALUES (47,'Otros',1, 4);

COMMIT;



-- PRESTACION_SERVICIO
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (1, 1);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (1, 2);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (1, 3);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (1, 4);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (1, 5);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (2, 1);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (2, 2);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (2, 3);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (2, 4);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (2, 5);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (3, 1);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (4, 2);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (5, 4);
INSERT INTO PrestacionServicio(ROL_OPERADOR_ID, SERVICIO_ID) VALUES (6, 3);

COMMIT;


-- PRIORIDAD
INSERT INTO Prioridad(ID_PRIORIDAD,NOMBRE_PRIORIDAD) VALUES (1,'Crítica');
INSERT INTO Prioridad(ID_PRIORIDAD,NOMBRE_PRIORIDAD) VALUES (2,'Alta');
INSERT INTO Prioridad(ID_PRIORIDAD,NOMBRE_PRIORIDAD) VALUES (3,'Media');
INSERT INTO Prioridad(ID_PRIORIDAD,NOMBRE_PRIORIDAD) VALUES (4,'Baja');

COMMIT;

-- ESTADO
INSERT INTO Estado(ID_ESTADO,NOMBRE_ESTADO) VALUES (1,'Sin asignar');
INSERT INTO Estado(ID_ESTADO,NOMBRE_ESTADO) VALUES (2,'Asignado');
INSERT INTO Estado(ID_ESTADO,NOMBRE_ESTADO) VALUES (3,'En espera');
INSERT INTO Estado(ID_ESTADO,NOMBRE_ESTADO) VALUES (4,'Cerrado');

COMMIT;


-- TICKET
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(1,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 0, 1, 3, 1, 20);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(2,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 2, 2, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(3,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 3, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(4,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 2, 2, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(5,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 2, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(6,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 2, 2, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(7,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 2, 2, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(8,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 2, 2, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(9,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 1, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(10,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 0, 1, 3, 2, 20);

INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(11,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 4, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(12,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 1, 2, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(13,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 4, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(14,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 1, 1, 1, 2, 18);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(15,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '03:43:00', 1, 1, 1, 3, 19);
INSERT INTO Ticket(id_ticket, ASUNTO, DESCRIPCION, ARCHIVO, FECHA_GEN, HORA_GEN, APROBACION, ESTADO_ID, USUARIO_ID, PRIORIDAD_ID, SERVICIO_ID) VALUES 
(16,'Este es un asunto', 'Esta una descripcion', 'Un archivo..', '2016-11-24', '14:33:00', 0, 1, 4, 2, 20);

COMMIT;


-- ATENCION
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES 
(1, 'Esta es tu solucion1', '2016-11-19', '14:55:00', 1, 1, 3);
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES 
(2, 'Esta es tu solucion2', '2016-11-19', '14:59:00', 1, 2, 3);
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES
(3, 'Esta es tu solucion3', '2016-11-19', '14:59:00', 1, 3, 3);
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES
(4, 'Esta es tu solucion4', '2016-11-19', '14:59:00', 1, 4, 3);
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES
(5, 'Esta es tu solucion5', '2016-11-19', '14:59:00', 1, 5, 3);
INSERT INTO Atencion (ID_ATENCION, DESCRIPCION, FECHA, HORA, SI_RESPUESTA, TICKET_ID, OPERADOR_ID) VALUES
(6, 'Esta es tu solucion6', '2016-11-19', '14:59:00', 1, 6, 3);

COMMIT;