USE `employee_directory`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `employee` values
(1,"Sunsan","Hung","zogunf@gmail.com"),
(2,"Petter","Zrung","dfhhtrtrht@gmail.com"),
(3,"lEMO","Aniu","hgudsc1221@gmail.com"),
(4,"Zong","Tan","chungs@gmail.com")

