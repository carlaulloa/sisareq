SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `DBHELPDESK` ;
CREATE SCHEMA IF NOT EXISTS `DBHELPDESK` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `DBHELPDESK` ;

-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Estado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Estado` (
  `id_estado` INT NOT NULL AUTO_INCREMENT ,
  `nombre_estado` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_estado`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT ,
  `nombre_rol` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_rol`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT ,
  `nombre_usuario` VARCHAR(45) NOT NULL ,
  `contrasenia` VARCHAR(45) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellido_pat` VARCHAR(45) NOT NULL ,
  `apellido_mat` VARCHAR(45) NOT NULL ,
  `estado` TINYINT(1) NOT NULL DEFAULT 1 ,
  `usuario_id` INT NULL ,
  `rol_id` INT NOT NULL ,
  PRIMARY KEY (`id_usuario`) ,
  CONSTRAINT `fk_usuario_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `DBHELPDESK`.`Usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Rol1`
    FOREIGN KEY (`rol_id` )
    REFERENCES `DBHELPDESK`.`Rol` (`id_rol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_usuario1_idx` ON `DBHELPDESK`.`Usuario` (`usuario_id` ASC) ;

CREATE INDEX `fk_usuario_Rol1_idx` ON `DBHELPDESK`.`Usuario` (`rol_id` ASC) ;

CREATE UNIQUE INDEX `nombre_usuario_UNIQUE` ON `DBHELPDESK`.`Usuario` (`nombre_usuario` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Prioridad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Prioridad` (
  `id_prioridad` INT NOT NULL AUTO_INCREMENT ,
  `nombre_prioridad` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_prioridad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`SLA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`SLA` (
  `id_sla` INT NOT NULL AUTO_INCREMENT ,
  `nombre_sla` VARCHAR(45) NOT NULL UNIQUE,
  `tresolucion_hh` INT NULL ,
  `tresolucion_mm` INT NULL ,
  `tresolucion_dd` INT NULL ,
  `trespuesta_hh` INT NULL ,
  `trespuesta_mm` INT NULL ,
  `trespuesta_dd` INT NULL ,
  `estado` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_sla`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Servicio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Servicio` (
  `id_servicio` INT NOT NULL AUTO_INCREMENT ,
  `si_autorizacion` TINYINT(1) NOT NULL DEFAULT 0 ,
  `nombre` VARCHAR(45) NOT NULL ,
  `nivel` INT NOT NULL ,
  `descripcion` LONGTEXT NULL ,
  `servicio_padre` INT NULL ,
  `sla_id` INT NOT NULL ,
  `estado` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_servicio`) ,
  CONSTRAINT `fk_SERVICIO_SERVICIO1`
    FOREIGN KEY (`servicio_padre` )
    REFERENCES `DBHELPDESK`.`Servicio` (`id_servicio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SERVICIO_SLA1`
    FOREIGN KEY (`sla_id` )
    REFERENCES `DBHELPDESK`.`SLA` (`id_sla` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_SERVICIO_SERVICIO1_idx` ON `DBHELPDESK`.`Servicio` (`servicio_padre` ASC) ;

CREATE INDEX `fk_SERVICIO_SLA1_idx` ON `DBHELPDESK`.`Servicio` (`sla_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Ticket`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Ticket` (
  `id_ticket` INT NOT NULL AUTO_INCREMENT ,
  `asunto` VARCHAR(100) NOT NULL ,
  `descripcion` LONGTEXT NOT NULL ,
  `archivo` LONGTEXT NULL ,
  `fecha_gen` DATE NOT NULL ,
  `hora_gen` TIME NOT NULL ,
  `aprobacion` TINYINT(1) NOT NULL DEFAULT 1 ,
  `estado_id` INT NOT NULL ,
  `usuario_id` INT NOT NULL ,
  `prioridad_id` INT NOT NULL ,
  `servicio_id` INT NOT NULL ,
  PRIMARY KEY (`id_ticket`) ,
  CONSTRAINT `fk_ticket_estado1`
    FOREIGN KEY (`estado_id` )
    REFERENCES `DBHELPDESK`.`Estado` (`id_estado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `DBHELPDESK`.`Usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_prioridad1`
    FOREIGN KEY (`prioridad_id` )
    REFERENCES `DBHELPDESK`.`Prioridad` (`id_prioridad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TICKET_SERVICIO1`
    FOREIGN KEY (`servicio_id` )
    REFERENCES `DBHELPDESK`.`Servicio` (`id_servicio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ticket_estado1_idx` ON `DBHELPDESK`.`Ticket` (`estado_id` ASC) ;

CREATE INDEX `fk_ticket_usuario1_idx` ON `DBHELPDESK`.`Ticket` (`usuario_id` ASC) ;

CREATE INDEX `fk_ticket_prioridad1_idx` ON `DBHELPDESK`.`Ticket` (`prioridad_id` ASC) ;

CREATE INDEX `fk_TICKET_SERVICIO1_idx` ON `DBHELPDESK`.`Ticket` (`servicio_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`RolOperador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`RolOperador` (
  `id_rol_operador` INT NOT NULL AUTO_INCREMENT ,
  `nombre_rol_ope` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_rol_operador`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Operador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Operador` (
  `id_operador` INT NOT NULL AUTO_INCREMENT ,
  `nivel` INT NOT NULL ,
  `rol_operador_id` INT NOT NULL ,
  `usuario_id` INT NOT NULL ,
  PRIMARY KEY (`id_operador`) ,
  CONSTRAINT `fk_OPERADOR_ROL_OPERADOR1`
    FOREIGN KEY (`rol_operador_id` )
    REFERENCES `DBHELPDESK`.`RolOperador` (`id_rol_operador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Operador_Usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `DBHELPDESK`.`Usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_OPERADOR_ROL_OPERADOR1_idx` ON `DBHELPDESK`.`Operador` (`rol_operador_id` ASC) ;

CREATE INDEX `fk_Operador_Usuario1_idx` ON `DBHELPDESK`.`Operador` (`usuario_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`CategoriaProblema`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`CategoriaProblema` (
  `id_categoria_problema` INT NOT NULL AUTO_INCREMENT ,
  `nombre_cat_prob` VARCHAR(45) NOT NULL ,
  `urgencia` VARCHAR(45) NOT NULL,
  `Impacto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria_problema`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Problema`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Problema` (
  `id_problema` INT NOT NULL AUTO_INCREMENT ,
  `asunto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_de_registro` DATE NOT NULL,
  `documentacion_registro` VARCHAR(45) NULL,
  `tratamiento_previo` VARCHAR(45) NOT NULL,
  `estado_actual` VARCHAR(45) NULL,
  `categoria_problema_id` INT NULL ,
  `atencion_id` INT NOT NULL,
  `operador_id` INT NOT NULL,
  PRIMARY KEY (`id_problema`) ,
  CONSTRAINT `fk_PROBLEMA_categoria1`
    FOREIGN KEY (`categoria_problema_id` )
    REFERENCES `DBHELPDESK`.`CategoriaProblema` (`id_categoria_problema` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Problema_Atencion1`
    FOREIGN KEY (`atencion_id`)
    REFERENCES `DBHELPDESK`.`Atencion` (`id_atencion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Problema_Operador1`
    FOREIGN KEY (`operador_id`)
    REFERENCES `DBHELPDESK`.`Operador` (`id_operador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PROBLEMA_categoriaProblema1_idx` ON `DBHELPDESK`.`Problema` (`categoria_problema_id` ASC) ;

CREATE INDEX `fk_Problema_Atencion1_idx` ON `DBHELPDESK`.`Problema` (`atencion_id` ASC);

CREATE INDEX `fk_Problema_Operador1_idx` ON `DBHELPDESK`.`Problema` (`operador_id` ASC);


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`ErrorConocido`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`ErrorConocido` (
  `id_error_conocido` INT NOT NULL AUTO_INCREMENT ,
  `fecha_detecion` DATE NOT NULL,
  `causas` LONGTEXT NOT NULL ,
  `documentacion` LONGTEXT NOT NULL ,
  `problema_id` INT NOT NULL ,
  PRIMARY KEY (`id_error_conocido`) ,
  CONSTRAINT `fk_errorConocido_PROBLEMA1`
    FOREIGN KEY (`problema_id` )
    REFERENCES `DBHELPDESK`.`Problema` (`id_problema` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_errorConocido_PROBLEMA1_idx` ON `DBHELPDESK`.`ErrorConocido` (`problema_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Soluciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Soluciones` (
  `id_soluciones` INT NOT NULL AUTO_INCREMENT ,
  `documentacion` LONGTEXT NOT NULL ,
  `fecha_envio` DATE NOT NULL ,
  `error_conocido_id` INT NOT NULL ,
  PRIMARY KEY (`id_soluciones`) ,
  CONSTRAINT `fk_SOLUCIONES_errorConocido1`
    FOREIGN KEY (`error_conocido_id` )
    REFERENCES `DBHELPDESK`.`ErrorConocido` (`id_error_conocido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_SOLUCIONES_errorConocido1_idx` ON `DBHELPDESK`.`Soluciones` (`error_conocido_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Atencion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Atencion` (
  `id_atencion` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` LONGTEXT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `hora` TIME NOT NULL ,
  `si_respuesta` TINYINT(1) NOT NULL DEFAULT 0 ,
  `soluciones_id` INT NULL ,
  `ticket_id` INT NOT NULL ,
  `operador_id` INT NOT NULL ,
  PRIMARY KEY (`id_atencion`) ,
  CONSTRAINT `fk_Atencion_SOLUCIONES1`
    FOREIGN KEY (`soluciones_id` )
    REFERENCES `DBHELPDESK`.`Soluciones` (`id_soluciones` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_Ticket1`
    FOREIGN KEY (`ticket_id` )
    REFERENCES `DBHELPDESK`.`Ticket` (`id_ticket` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_Operador1`
    FOREIGN KEY (`operador_id` )
    REFERENCES `DBHELPDESK`.`Operador` (`id_operador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Atencion_SOLUCIONES1_idx` ON `DBHELPDESK`.`Atencion` (`soluciones_id` ASC) ;

CREATE INDEX `fk_Atencion_Ticket1_idx` ON `DBHELPDESK`.`Atencion` (`ticket_id` ASC) ;

CREATE INDEX `fk_Atencion_Operador1_idx` ON `DBHELPDESK`.`Atencion` (`operador_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`PrestacionServicio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`PrestacionServicio` (
  `rol_operador_id` INT NOT NULL ,
  `servicio_id` INT NOT NULL ,
  PRIMARY KEY (`rol_operador_id`, `servicio_id`) ,
  CONSTRAINT `fk_ROL_OPERADOR_has_servicio_ROL_OPERADOR1`
    FOREIGN KEY (`rol_operador_id` )
    REFERENCES `DBHELPDESK`.`RolOperador` (`id_rol_operador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROL_OPERADOR_has_servicio_servicio1`
    FOREIGN KEY (`servicio_id` )
    REFERENCES `DBHELPDESK`.`Servicio` (`id_servicio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ROL_OPERADOR_has_servicio_servicio1_idx` ON `DBHELPDESK`.`PrestacionServicio` (`servicio_id` ASC) ;

CREATE INDEX `fk_ROL_OPERADOR_has_servicio_ROL_OPERADOR1_idx` ON `DBHELPDESK`.`PrestacionServicio` (`rol_operador_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`RFC`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`RFC` (
  `id_rfc` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL ,
  `estado` VARCHAR(45) NOT NULL ,
  `proposito` VARCHAR(45) NOT NULL,
  `motivacion` VARCHAR(45) NOT NULL,
  `estimacion_recursos` VARCHAR(45) NULL ,
  `estimacion_tiempo` INT NOT NULL,
  `categoria` VARCHAR(45) NULL,
  `prioridad` VARCHAR(45) NULL,
  `error_conocido_id` INT NOT NULL ,
  `operador_id` INT NOT NULL,
  PRIMARY KEY (`id_rfc`) ,
  CONSTRAINT `fk_RFC_errorConocido1`
    FOREIGN KEY (`error_conocido_id` )
    REFERENCES `DBHELPDESK`.`ErrorConocido` (`id_error_conocido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RFC_Operador1`
    FOREIGN KEY (`operador_id` )
    REFERENCES `DBHELPDESK`.`Operador` (`id_operador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_RFC_errorConocido1_idx` ON `DBHELPDESK`.`RFC` (`error_conocido_id` ASC) ;

CREATE INDEX `fk_RFC_Operador1_idx` ON `DBHELPDESK`.`RFC` (`operador_id` ASC) ;

-- -----------------------------------------------------
-- Table `DBHELPDESK`.`DocumentacionProblema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBHELPDESK`.`DocumentacionProblema` (
  `problema_id` INT NOT NULL,
  `id_documentacionproblema` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `documentacion` VARCHAR(45) NOT NULL,
  `operador_id` INT NOT NULL,
  PRIMARY KEY (`problema_id`, `id_documentacionproblema`),
  CONSTRAINT `fk_DocumentacionProblema_Problema1`
    FOREIGN KEY (`problema_id`)
    REFERENCES `DBHELPDESK`.`Problema` (`id_problema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DocumentacionProblema_Operador1`
    FOREIGN KEY (`operador_id`)
    REFERENCES `DBHELPDESK`.`Operador` (`id_operador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DocumentacionProblema_Problema1_idx` ON `DBHELPDESK`.`DocumentacionProblema` (`problema_id` ASC);

CREATE INDEX `fk_DocumentacionProblema_Operador1_idx` ON `DBHELPDESK`.`DocumentacionProblema` (`operador_id` ASC);


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`PER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`PER` (
  `id_per` INT NOT NULL AUTO_INCREMENT ,
  `estado` VARCHAR(45) NOT NULL ,
  `resultados` VARCHAR(45) NOT NULL ,
  `rfc_id` INT NOT NULL ,
  PRIMARY KEY (`id_per`) ,
  CONSTRAINT `fk_PER_RFC1`
    FOREIGN KEY (`rfc_id` )
    REFERENCES `DBHELPDESK`.`RFC` (`id_rfc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PER_RFC1_idx` ON `DBHELPDESK`.`PER` (`rfc_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`HistorialPER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`HistorialPER` (
  `id_historial_per` INT NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NOT NULL ,
  `evento` VARCHAR(45) NOT NULL ,
  `documentacion` VARCHAR(45) NOT NULL ,
  `per_id` INT NOT NULL ,
  PRIMARY KEY (`id_historial_per`) ,
  CONSTRAINT `fk_HistorialPER_PER1`
    FOREIGN KEY (`per_id` )
    REFERENCES `DBHELPDESK`.`PER` (`id_per` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_HistorialPER_PER1_idx` ON `DBHELPDESK`.`HistorialPER` (`per_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`ActivosTi`
-- Reemplaza a bd_activo_ti
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`ActivosTi` (
  `id_activos_ti` INT NOT NULL AUTO_INCREMENT ,
  `estado` VARCHAR(45) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `descripcion` LONGTEXT NOT NULL ,
  `marca` VARCHAR(45) NULL ,
  `version_activo` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_activos_ti`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Cambio`
-- Reemplaza a rfc_activo_ti
-- Reemplaza a activos_ti_incidencia (implícito en las tablas de otro módulo)
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Cambio` (
  `rfc_id` INT NOT NULL ,
  `activos_ti_id` INT NOT NULL ,
  PRIMARY KEY (`rfc_id`, `activos_ti_id`) ,
  CONSTRAINT `fk_RFC_has_ACTIVOS_TI_RFC1`
    FOREIGN KEY (`rfc_id` )
    REFERENCES `DBHELPDESK`.`RFC` (`id_rfc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RFC_has_ACTIVOS_TI_ACTIVOS_TI1`
    FOREIGN KEY (`activos_ti_id` )
    REFERENCES `DBHELPDESK`.`ActivosTi` (`id_activos_ti` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_RFC_has_ACTIVOS_TI_ACTIVOS_TI1_idx` ON `DBHELPDESK`.`Cambio` (`activos_ti_id` ASC) ;

CREATE INDEX `fk_RFC_has_ACTIVOS_TI_RFC1_idx` ON `DBHELPDESK`.`Cambio` (`rfc_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`TipoSoftware`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`TipoSoftware` (
  `id_tipo_software` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_tipo_software`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Software`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Software` (
  `id_software` INT NOT NULL AUTO_INCREMENT ,
  `licencia` VARCHAR(45) NOT NULL ,
  `fecha_instalado` DATE NOT NULL ,
  `tipo_software_id` INT NOT NULL ,
  `activos_ti_id` INT NOT NULL ,
  `hardware_id` INT NULL ,
  PRIMARY KEY (`id_software`) ,
  CONSTRAINT `fk_SOFTWARE_tipoSoftware1`
    FOREIGN KEY (`tipo_software_id` )
    REFERENCES `DBHELPDESK`.`TipoSoftware` (`id_tipo_software` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SOFTWARE_ACTIVOS_TI1`
    FOREIGN KEY (`activos_ti_id` )
    REFERENCES `DBHELPDESK`.`ActivosTi` (`id_activos_ti` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HARDWARE_ID1`
    FOREIGN KEY (`hardware_id`)
    REFERENCES `DBHELPDESK`.`Hardware` (`id_hardware`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_SOFTWARE_tipoSoftware1_idx` ON `DBHELPDESK`.`Software` (`tipo_software_id` ASC) ;

CREATE INDEX `fk_SOFTWARE_ACTIVOS_TI1_idx` ON `DBHELPDESK`.`Software` (`activos_ti_id` ASC) ;

CREATE INDEX `fk_SOFTWARE_HARDWARE_ID1_idx` ON `DBHELPDESK`.`Software` (`hardware_id` ASC) ;

-- -----------------------------------------------------
-- Table `DBHELPDESK`.`TipoHardware`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`TipoHardware` (
  `id_tipo_hardware` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_tipo_hardware`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`Hardware`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`Hardware` (
  `id_hardware` INT NOT NULL AUTO_INCREMENT ,
  `numero_serie` VARCHAR(45)  NULL ,
  `grupo_red` VARCHAR(45)  NULL ,
  `direccion_ip` VARCHAR(45)  NULL ,
  `ubicacion` LONGTEXT NULL ,
  `fecha_inst` VARCHAR(45) NULL,
  `activos_ti_id` INT NOT NULL ,
  `tipo_hardware_id` INT NOT NULL ,
  `usuario_id` INT NOT NULL ,
  `licencia_hardware_id` INT NOT NULL ,
  PRIMARY KEY (`id_hardware`) ,
  CONSTRAINT `fk_HARDWARE_ACTIVOS_TI1`
    FOREIGN KEY (`activos_ti_id` )
    REFERENCES `DBHELPDESK`.`ActivosTi` (`id_activos_ti` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HARDWARE_tipoHardware1`
    FOREIGN KEY (`tipo_hardware_id` )
    REFERENCES `DBHELPDESK`.`TipoHardware` (`id_tipo_hardware` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HARDWARE_USUARIO1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `DBHELPDESK`.`Usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_licenciaHardware1`
    FOREIGN KEY (`licencia_hardware_id`)
    REFERENCES `DBHELPDESK`.`LicenciaHardware` (`id_licencia_hardware`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_HARDWARE_ACTIVOS_TI1_idx` ON `DBHELPDESK`.`Hardware` (`activos_ti_id` ASC) ;

CREATE INDEX `fk_HARDWARE_tipoHardware1_idx` ON `DBHELPDESK`.`Hardware` (`tipo_hardware_id` ASC) ;

CREATE INDEX `fk_HARDWARE_USUARIO1_idx` ON `DBHELPDESK`.`Hardware` (`usuario_id` ASC) ;

CREATE INDEX `fk_HARDWARE_licenciaHardware1_idx` ON `DBHELPDESK`.`Hardware` (`licencia_hardware_id` ASC) ;


-- -----------------------------------------------------
-- Table `DBHELPDESK`.`LicenciaHardware`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBHELPDESK`.`LicenciaHardware` (
  `id_licencia_hardware` INT NOT NULL AUTO_INCREMENT ,
  `codigo` VARCHAR(45) NOT NULL ,
  `identificador` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_licencia_hardware`));


-- -----------------------------------------------------
-- Archivos
-- -----------------------------------------------------
ALTER TABLE TICKET 
  ADD ( adjunto MEDIUMBLOB NULL
);

ALTER TABLE TICKET
  ADD ( content_type LONGTEXT NULL
);


USE `DBHELPDESK` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
