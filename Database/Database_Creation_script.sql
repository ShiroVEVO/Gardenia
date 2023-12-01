-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gardenia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gardenia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gardenia` DEFAULT CHARACTER SET utf8 ;
USE `gardenia` ;

/*
-- -----------------------------------------------------
-- Table `gardenia`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`department` (
  `id_department` TINYINT(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`id_department`),
  UNIQUE INDEX `id_department_UNIQUE` (`id_department` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;
*/

/*
-- -----------------------------------------------------
-- Table `gardenia`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`city` (
  `id_city` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(22) NOT NULL,
  `shipping_cost` MEDIUMINT(8) UNSIGNED NOT NULL,
  `department_id` TINYINT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_city`),
  UNIQUE INDEX `id_city_UNIQUE` (`id_city` ASC) VISIBLE,
  INDEX `fk_city_department1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `gardenia`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
*/

-- -----------------------------------------------------
-- Table `gardenia`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`client` (
  `document_type` VARCHAR(2) NOT NULL CHECK (document_type in ('CC', 'PA', 'CE', 'TI')),
  `document_num` BIGINT(10) UNSIGNED NOT NULL,
  `phone_number` BIGINT(10) UNSIGNED NOT NULL,
  `names` VARCHAR(40) NOT NULL,
  `lastnames` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`document_type`, `document_num`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`address` (
  `id_address` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(100) NOT NULL,
  `references` VARCHAR(150) NULL,
  `city_id` SMALLINT(5) UNSIGNED NOT NULL,
  `client_document_type` VARCHAR(2) NOT NULL,
  `client_document_num` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_address`),
  UNIQUE INDEX `id_address_UNIQUE` (`id_address` ASC) VISIBLE,
  INDEX `fk_address_city_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_address_client1_idx` (`client_document_type` ASC, `client_document_num` ASC) VISIBLE,
  CONSTRAINT `fk_address_city`
    FOREIGN KEY (`city_id`)
    REFERENCES `gardenia`.`city` (`id_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_client1`
    FOREIGN KEY (`client_document_type` , `client_document_num`)
    REFERENCES `gardenia`.`client` (`document_type` , `document_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`account` (
  `id_account` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
  `birth_date` DATE NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `client_document_type` VARCHAR(2) NOT NULL,
  `client_document_num` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_account`, `client_document_type`, `client_document_num`),
  UNIQUE INDEX `id_account_UNIQUE` (`id_account` ASC) VISIBLE,
  INDEX `fk_account_client1_idx` (`client_document_type` ASC, `client_document_num` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_account_client1`
    FOREIGN KEY (`client_document_type` , `client_document_num`)
    REFERENCES `gardenia`.`client` (`document_type` , `document_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`order` (
  `id_order` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(10) NOT NULL CHECK (state IN ('En espera', 'Pagado', 'Enviado', 'Cancelado', 'Finalizado')),
  `total_amount` MEDIUMINT(10) UNSIGNED NOT NULL,
  `client_document_type` VARCHAR(2) NOT NULL,
  `client_document_num` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC) VISIBLE,
  INDEX `fk_order_client1_idx` (`client_document_type` ASC, `client_document_num` ASC) VISIBLE,
  CONSTRAINT `fk_order_client1`
    FOREIGN KEY (`client_document_type` , `client_document_num`)
    REFERENCES `gardenia`.`client` (`document_type` , `document_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`purchase_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`purchase_option` (
  `id_purchase_option` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `url_img` VARCHAR(300) NOT NULL,
  `total_base_cost` MEDIUMINT(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`id_purchase_option`),
  UNIQUE INDEX `id_purchase_option_UNIQUE` (`id_purchase_option` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`review` (
  `id_review` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(400) NOT NULL,
  `date` DATE NOT NULL,
  `score` TINYINT(1) NOT NULL,
  `order_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_review`),
  UNIQUE INDEX `id_review_UNIQUE` (`id_review` ASC) VISIBLE,
  INDEX `fk_review_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `gardenia`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`product` (
  `id_product` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `score` FLOAT UNSIGNED NULL,
  `total_cost` MEDIUMINT(8) UNSIGNED NOT NULL,
  `stock` SMALLINT(5) UNSIGNED ZEROFILL NOT NULL,
  `description` VARCHAR(800) NOT NULL,
  `production_cost` MEDIUMINT(8) NOT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE INDEX `id_product_UNIQUE` (`id_product` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`image` (
  `id_image` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `url_img` VARCHAR(300) NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_image`),
  UNIQUE INDEX `id_image_UNIQUE` (`id_image` ASC) VISIBLE,
  INDEX `fk_image_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_image_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `gardenia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`spent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`spent` (
  `id_spent` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `quantity` SMALLINT(5) UNSIGNED NOT NULL,
  `amount` MEDIUMINT(10) UNSIGNED NOT NULL,
  `date` DATE NOT NULL,
  `unit` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_spent`),
  UNIQUE INDEX `id_spent_UNIQUE` (`id_spent` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`product_has_purchase_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`product_has_purchase_option` (
  `product_id` INT UNSIGNED NOT NULL,
  `purchase_option_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`product_id`, `purchase_option_id`),
  INDEX `fk_product_has_purchase_option_purchase_option1_idx` (`purchase_option_id` ASC) VISIBLE,
  INDEX `fk_product_has_purchase_option_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_purchase_option_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `gardenia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_purchase_option_purchase_option1`
    FOREIGN KEY (`purchase_option_id`)
    REFERENCES `gardenia`.`purchase_option` (`id_purchase_option`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`plant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`plant` (
  `id_plant` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `scientific_name` VARCHAR(40) NULL,
  `stockeable_as` TINYINT(1) UNSIGNED NOT NULL,
  `care_instructions` VARCHAR(1500) NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_plant`),
  UNIQUE INDEX `id_plant_UNIQUE` (`id_plant` ASC) VISIBLE,
  INDEX `fk_plant_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_plant_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `gardenia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`category` (
  `id_category` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `url_img` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE INDEX `id_category_UNIQUE` (`id_category` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`product_has_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`product_has_category` (
  `product_id_product` INT UNSIGNED NOT NULL,
  `category_id_category` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`product_id_product`, `category_id_category`),
  INDEX `fk_product_has_category_category1_idx` (`category_id_category` ASC) VISIBLE,
  INDEX `fk_product_has_category_product1_idx` (`product_id_product` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_category_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `gardenia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_category_category1`
    FOREIGN KEY (`category_id_category`)
    REFERENCES `gardenia`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`order_has_product` (
  `order_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `fk_order_has_product_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_order_has_product_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `gardenia`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `gardenia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gardenia`.`purchase_option_has_spent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gardenia`.`purchase_option_has_spent` (
  `purchase_option_id_purchase_option` INT UNSIGNED NOT NULL,
  `spent_id_spent` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`purchase_option_id_purchase_option`, `spent_id_spent`),
  INDEX `fk_purchase_option_has_spent_spent1_idx` (`spent_id_spent` ASC) VISIBLE,
  INDEX `fk_purchase_option_has_spent_purchase_option1_idx` (`purchase_option_id_purchase_option` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_option_has_spent_purchase_option1`
    FOREIGN KEY (`purchase_option_id_purchase_option`)
    REFERENCES `gardenia`.`purchase_option` (`id_purchase_option`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_option_has_spent_spent1`
    FOREIGN KEY (`spent_id_spent`)
    REFERENCES `gardenia`.`spent` (`id_spent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
