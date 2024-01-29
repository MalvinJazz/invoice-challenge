CREATE DATABASE `invoice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client` varchar(100) NOT NULL,
  `tax_id` varchar(100) DEFAULT NULL,
  `total` float NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `version` int NOT NULL DEFAULT '1',
  `status` enum('active','deleted') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`),
  KEY `invoice_tax_id_IDX` (`tax_id`) USING BTREE,
  KEY `invoice_client_IDX` (`client`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `invoice_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(100) NOT NULL,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  `invoice_id` int NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `invoice_detail_FK` (`invoice_id`),
  KEY `invoice_detail_product_IDX` (`product`) USING BTREE,
  CONSTRAINT `invoice_detail_FK` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;