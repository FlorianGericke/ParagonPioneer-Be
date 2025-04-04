-- MySQL dump 10.13  Distrib 8.0.41, for Linux (aarch64)
--
-- Host: localhost    Database: ppAssemblyLineBa
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `capacity` int DEFAULT NULL,
  `production_per_minute` float DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `recipe` binary(16) DEFAULT NULL,
  `dtype` varchar(31) NOT NULL,
  `name` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `slug` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dhln7gqbq9qt5lf8a28d0fy99` (`slug`),
  UNIQUE KEY `UK_ntxjs38j4ae4ewq5w8p915ij3` (`recipe`),
  CONSTRAINT `FKoqb8j1mlnygdpoj0gemfh3jls` FOREIGN KEY (`recipe`) REFERENCES `recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` (`capacity`, `production_per_minute`, `created_at`, `deleted_at`, `updated_at`, `id`, `recipe`, `dtype`, `name`, `remarks`, `slug`) VALUES (NULL,0.125,'2025-03-31 15:54:51.525302',NULL,NULL,_binary '�o��N̮\0',_binary '�~a�`JB�\�','ProductionBuilding','Gold Smelter','','goldsmelter'),(NULL,1,'2025-03-31 15:54:50.550610',NULL,NULL,_binary 'k@)S�AΕ�\�',_binary '�ivfDAr�\"Aq','ProductionBuilding','Potato Farm','','potatofarm'),(NULL,0.75,'2025-03-31 15:54:52.018529',NULL,NULL,_binary '	LUW��B�\�',_binary '\"� �5�Dۥ_','ProductionBuilding','Winepress','','winepress'),(NULL,0.75,'2025-03-31 15:54:51.996471',NULL,NULL,_binary '\\o��M-�\�',_binary '�7�Zw�Fo\�','ProductionBuilding','Cooper','','cooper'),(NULL,0.01667,'2025-03-31 15:54:51.188762',NULL,NULL,_binary '�.a~M�uR\�',_binary '��cֺCs�\�','ProductionBuilding','Cotton Field','','cottonfield'),(NULL,0.01667,'2025-03-31 15:54:51.644988',NULL,NULL,_binary '	jkJ��0\�',_binary 'Y�_��H�','ProductionBuilding','Mulberry Trees','','mulberrytrees'),(NULL,0.5,'2025-03-31 15:54:50.890607',NULL,NULL,_binary '�I�d]C�\�',_binary '%r��`Kd�\n','ProductionBuilding','Windmill','','windmill'),(NULL,0.75,'2025-03-31 15:54:51.977361',NULL,NULL,_binary ']��6�N�',NULL,'ProductionBuilding','Winery','','winery'),(NULL,0.25,'2025-03-31 15:54:51.083592',NULL,NULL,_binary '�/X�Fw�\�',_binary '�qn�4F,�\�','ProductionBuilding','Sailmaker','','sailmaker'),(NULL,0.25,'2025-03-31 15:54:51.202843',NULL,NULL,_binary '\"�M`y@��\�',_binary ';�$mIp��','ProductionBuilding','Tailor','','tailor'),(NULL,0.75,'2025-03-31 15:54:51.825598',NULL,NULL,_binary '\"�a�}F�\�',_binary '��	�!cNŮA','ProductionBuilding','Fine Forge','','fineforge'),(NULL,0.25,'2025-03-31 15:54:51.346182',NULL,NULL,_binary '&Ѥ�cAō�Ch',_binary '��aB��A\�','ProductionBuilding','Iron Mine','','ironmine'),(NULL,0.01667,'2025-03-31 15:54:51.609969',NULL,NULL,_binary '\'��4�ODj\�',NULL,'ProductionBuilding','Bathhouse','','bathhouse'),(NULL,0.01667,'2025-03-31 15:54:52.212837',NULL,NULL,_binary '(��C2�\�',NULL,'ProductionBuilding','Tiltyard','','tiltyard'),(NULL,0.5,'2025-03-31 15:54:51.231172',NULL,NULL,_binary '*�=`�G�',_binary 'h�\r��GE[\�','ProductionBuilding','Hop Farm','','hopfarm'),(NULL,0.14286,'2025-03-31 15:54:50.693038',NULL,NULL,_binary '/��OB%�\�',_binary '�,�OhG� \�','ProductionBuilding','Stonecutter','','stonecutter'),(NULL,0.01667,'2025-03-31 15:54:50.934870',NULL,NULL,_binary '3`��|�@�',_binary '9,��aL\'�D','ProductionBuilding','Horse Field','','horsefield'),(NULL,0.125,'2025-03-31 15:54:52.134075',NULL,NULL,_binary '3�*��|M�',_binary '�5�lqH��','ProductionBuilding','Cannon Foundry','','cannonfoundry'),(NULL,0.1,'2025-03-31 15:54:51.421014',NULL,NULL,_binary '9Ue�FɲY�\r',NULL,'ProductionBuilding','Knight Barracks','','knightbarracks'),(NULL,0.125,'2025-03-31 15:54:52.078424',NULL,NULL,_binary '9�ң*@m�3.\�',_binary '��ܟ�IG\�','ProductionBuilding','BookBinder','','bookbinder'),(NULL,0.125,'2025-03-31 15:54:50.768561',NULL,NULL,_binary '9��`�]L�',_binary '\'�穨zG^�\'T\�','ProductionBuilding','Copper Armory','','copperarmory'),(NULL,0.5,'2025-03-31 15:54:51.678248',NULL,NULL,_binary '<:���\\F�',_binary 'Q�����','ProductionBuilding','Silk Twine Mill','','silktwinemill'),(NULL,0.5,'2025-03-31 15:54:50.622356',NULL,NULL,_binary '>˙6Ȗ@ܧg{Qa�',_binary 'RO��E�\�','ProductionBuilding','Linen Weaver','','linenweaver'),(NULL,0.25,'2025-03-31 15:54:50.912738',NULL,NULL,_binary 'B}+Ğ�B��t',_binary '��H;�J�','ProductionBuilding','Bakery','','bakery'),(NULL,0.25,'2025-03-31 15:54:51.447037',NULL,NULL,_binary 'FK�>�fC7�1',_binary '\0Wz\n\n�BU��','ProductionBuilding','Cattle Ranch','','cattleranch'),(NULL,0.01667,'2025-03-31 15:54:50.852336',NULL,NULL,_binary 'J��T�YK߹5',_binary 'v��2U�Og\�','ProductionBuilding','Wheat Field','','wheatfield'),(NULL,0.33333,'2025-03-31 15:54:51.307583',NULL,NULL,_binary 'MR$�H؀�\�',_binary '�b���M\�','ProductionBuilding','Linseed Pil Press','','linseedpilpress'),(NULL,0.5,'2025-03-31 15:54:51.253178',NULL,NULL,_binary 'Mv���I�',_binary '�M����','ProductionBuilding','Malthouse','','malthouse'),(NULL,1.5,'2025-03-31 15:54:51.923789',NULL,NULL,_binary 'N��\0�eD�',_binary 'a���A�A\�','ProductionBuilding','Lobsterer','','lobsterer'),(NULL,0.25,'2025-03-31 15:54:51.463332',NULL,NULL,_binary 'X���@ֺ\�',_binary '��4��7H;','ProductionBuilding','Rock Salt Mine','','rocksaltmine'),(NULL,0.25,'2025-03-31 15:54:51.555887',NULL,NULL,_binary '[I�]�C��',_binary ')���jYLW\�','ProductionBuilding','Crossbow Maker','','crossbowmaker'),(NULL,0.5,'2025-03-31 15:54:50.677168',NULL,NULL,_binary '[mp�:OCx�\�',_binary '���p9G!\�','ProductionBuilding','Ropery','','ropery'),(NULL,0.01667,'2025-03-31 15:54:51.960664',NULL,NULL,_binary '_]�vG	C��',_binary '���r`HW\�','ProductionBuilding','Vineyard','','vineyard'),(NULL,0.5,'2025-03-31 15:54:51.660623',NULL,NULL,_binary 'e�\'+�%DU�\�',_binary '��^1�Nu\�','ProductionBuilding','Silk Plantation','','silkplantation'),(NULL,0.1,'2025-03-31 15:54:51.891489',NULL,NULL,_binary 'i�|���E\�',NULL,'ProductionBuilding','Cuirassier Academy','','cuirassieracademy'),(NULL,1,'2025-03-31 15:54:51.488672',NULL,NULL,_binary 'k�춸�K�\�',_binary 'f>�SBh�mO\�','ProductionBuilding','Butchers Shop','','butchersshop'),(NULL,0.01667,'2025-03-31 15:54:51.434352',NULL,NULL,_binary 'l`N��QMp�\�',NULL,'ProductionBuilding','Cattle Field','','cattlefield'),(NULL,5,'2025-03-31 15:54:50.508921',NULL,NULL,_binary 'm߉�2�JI�\�',_binary '�h�3F�\�','ProductionBuilding','Sawmill','','sawmill'),(NULL,0.25,'2025-03-31 15:54:51.581318',NULL,NULL,_binary 'n��GlGk�\�',_binary '.(6G�rE�g\�','ProductionBuilding','Marble Quarry','','marblequarry'),(NULL,1.5,'2025-03-31 15:54:51.945850',NULL,NULL,_binary 'u���aJ\�',_binary '�#�L�=','ProductionBuilding','Noble Kitchen','','noblekitchen'),(NULL,0.125,'2025-03-31 15:54:51.405569',NULL,NULL,_binary '|�	�0NK�l',_binary '/Zy�\n`N��\�','ProductionBuilding','Iron Armory','','ironarmory'),(NULL,0.5,'2025-03-31 15:54:51.065574',NULL,NULL,_binary '̉����D0',_binary '��£��O\�','ProductionBuilding','Cigar Manufacturer','','cigarmanufacturer'),(NULL,0.25,'2025-03-31 15:54:52.198698',NULL,NULL,_binary 'Ь�7G��\�',_binary 'ӵ3��D�\�','ProductionBuilding','Gunsmith','','gunsmith'),(NULL,0.5,'2025-03-31 15:54:51.044272',NULL,NULL,_binary 'ԡ�P׌OJ��',_binary '��5:+�DȪ\�','ProductionBuilding','Tobacco Farm','','tobaccofarm'),(NULL,0.1,'2025-03-31 15:54:50.790385',NULL,NULL,_binary 'Օb!�A!��',NULL,'ProductionBuilding','Barracks','','barracks'),(NULL,0.25,'2025-03-31 15:54:51.761897',NULL,NULL,_binary 'ر\'���@)\�',_binary '86�9[F~��','ProductionBuilding','Goblet Manufacturer','','gobletmanufacturer'),(NULL,0.01667,'2025-03-31 15:54:50.478970',NULL,NULL,_binary 'ٞ\Z\\KJK���',NULL,'ProductionBuilding','Well','','well'),(NULL,0.1,'2025-03-31 15:54:51.171710',NULL,NULL,_binary 'ۉ�?0K��Y',NULL,'ProductionBuilding','Longbow Archer Range','','longbowarcherrange'),(NULL,0.25,'2025-03-31 15:54:52.098758',NULL,NULL,_binary 'ߘ���	N~\�',NULL,'ProductionBuilding','Nitrate Maker','','nitratemaker'),(NULL,0.25,'2025-03-31 15:54:51.728996',NULL,NULL,_binary '�	r�Iz�\�',_binary 'N�0��L-�','ProductionBuilding','Noble Tailor','','nobletailor'),(NULL,0.01667,'2025-03-31 15:54:51.594775',NULL,NULL,_binary '���F�',NULL,'ProductionBuilding','School','','school'),(NULL,0.25,'2025-03-31 15:54:50.718880',NULL,NULL,_binary '��Q_Kn�',_binary 'v#Zi�C@?�?\�','ProductionBuilding','Copper Mine','','coppermine'),(NULL,0.5,'2025-03-31 15:54:50.868750',NULL,NULL,_binary '�\Z�C��L\"',_binary '��Y�L�','ProductionBuilding','Wheat Farm','','wheatfarm'),(NULL,0.25,'2025-03-31 15:54:51.874699',NULL,NULL,_binary '�\Z�t��J\�',_binary 'h���Nػ\�','ProductionBuilding','Armorsmith','','armorsmith'),(NULL,0.75,'2025-03-31 15:54:50.492866',NULL,NULL,_binary '�%���fDS',_binary '�zҫ)bE ��','ProductionBuilding','Fishermans Hut','','fishermanshut'),(NULL,0.5,'2025-03-31 15:54:51.281416',NULL,NULL,_binary '�+�U�FH#\�',_binary 'w���B\�','ProductionBuilding','Brewery','','brewery'),(NULL,0.5,'2025-03-31 15:54:51.806911',NULL,NULL,_binary '�2(Ӗ�A�\�',_binary '��b~d6J6�d','ProductionBuilding','Chandler','','chandler'),(NULL,0.25,'2025-03-31 15:54:51.125465',NULL,NULL,_binary '�4��Թ@P\�',_binary '��<��iDu','ProductionBuilding','Brickyard','','brickyard'),(NULL,0.5,'2025-03-31 15:54:51.102852',NULL,NULL,_binary '�:?���K\'',_binary '*�8e��H\\\�','ProductionBuilding','Clay Pit','','claypit'),(NULL,0.01667,'2025-03-31 15:54:50.587844',NULL,NULL,_binary '�;j���A	',_binary '@���Lǜ','ProductionBuilding','Linseed Field','','linseedfield'),(NULL,0.5,'2025-03-31 15:54:50.639600',NULL,NULL,_binary '�;���1L\�',_binary '�Y��N\�','ProductionBuilding','Bowyer','','bowyer'),(NULL,0.25,'2025-03-31 15:54:51.856662',NULL,NULL,_binary '�E���qBY',_binary 'I��R oE�\�','ProductionBuilding','Steel Furnace','','steelfurnace'),(NULL,0.1,'2025-03-31 15:54:50.974519',NULL,NULL,_binary '�MZ$ʸBʜ�\�',NULL,'ProductionBuilding','Riding Arena','','ridingarena'),(NULL,0.01667,'2025-03-31 15:54:52.225587',NULL,NULL,_binary '�N�	�B\'\�',NULL,'ProductionBuilding','University','','university'),(NULL,0.1,'2025-03-31 15:54:51.568233',NULL,NULL,_binary '�S�OiO��',NULL,'ProductionBuilding','Crossbow Shooting Range','','crossbowshootingrange'),(NULL,0.01667,'2025-03-31 15:54:50.565136',NULL,NULL,_binary '�]x���J3',NULL,'ProductionBuilding','Tavern','','tavern'),(NULL,0.5,'2025-03-31 15:54:51.713629',NULL,NULL,_binary '�e����',_binary '�b��YDK\�','ProductionBuilding','Indigo Plantation','','indigoplantation'),(NULL,0.125,'2025-03-31 15:54:51.363957',NULL,NULL,_binary '�j���GB',_binary '��\n��6B*','ProductionBuilding','Iron Smelter','','ironsmelter'),(NULL,0.5,'2025-03-31 15:54:50.606033',NULL,NULL,_binary '�kf�I�G�',_binary '0�҉*�J�\�','ProductionBuilding','Linseed Farm','','linseedfarm'),(NULL,0.01667,'2025-03-31 15:54:51.217856',NULL,NULL,_binary '�op˘�L4�\�',_binary '��u�\'8C\�','ProductionBuilding','Hop Field','','hopfield'),(NULL,5,'2025-03-31 15:54:50.463304',NULL,NULL,_binary '�sy䇬K߲gfǺ\Z',_binary '��K�\ZK9\�','ProductionBuilding','Lumberjack','','lumberjack'),(NULL,0.5,'2025-03-31 15:54:52.171724',NULL,NULL,_binary '�y3kcLѾ�\�',_binary '?��G@̇Kv\�','ProductionBuilding','Planing Mill','','planingmill'),(NULL,0.01667,'2025-03-31 15:54:51.011245',NULL,NULL,_binary '�y;��QO	\�',_binary '{�{���G','ProductionBuilding','Tobacco Field','','tobaccofield'),(NULL,0.125,'2025-03-31 15:54:51.540243',NULL,NULL,_binary '�zc��]C8\�',NULL,'ProductionBuilding','Goldsmith','','goldsmith'),(NULL,0.5,'2025-03-31 15:54:50.830937',NULL,NULL,_binary '�z�ŉ�D�',_binary '�,�-J.E̊�','ProductionBuilding','Sheep Farm','','sheepfarm'),(NULL,0.25,'2025-03-31 15:54:51.790737',NULL,NULL,_binary '�z����',_binary '�Ɣ��G\�','ProductionBuilding','Apiary','','apiary'),(NULL,0.25,'2025-03-31 15:54:52.114053',NULL,NULL,_binary '�{ފD[�`_3',_binary '�\\�T@�\�','ProductionBuilding','Powder Mill','','powdermill'),(NULL,0.01667,'2025-03-31 15:54:51.777186',NULL,NULL,_binary '�Ҕ�?�D�',NULL,'ProductionBuilding','Beehive','','beehive'),(NULL,0.1,'2025-03-31 15:54:50.660282',NULL,NULL,_binary '��l�vF߾\0',_binary '�SIJ�O��','ProductionBuilding','Archery Range','','archeryrange'),(NULL,0.25,'2025-03-31 15:54:51.505817',NULL,NULL,_binary '���lI�',_binary '�2�\n��FE','ProductionBuilding','Gold Mine','','goldmine'),(NULL,0.5,'2025-03-31 15:54:51.152149',NULL,NULL,_binary '��t�4JӍ\�',_binary '��ĺC��','ProductionBuilding','Longbowyer','','longbowyer'),(NULL,0.5,'2025-03-31 15:54:51.908479',NULL,NULL,_binary '�����',_binary '�k͆\\�@�\�','ProductionBuilding','Distillery','','distillery'),(NULL,0.33333,'2025-03-31 15:54:51.744735',NULL,NULL,_binary '��DJ�\�',NULL,'ProductionBuilding','Gemstone Mine','','gemstonemine'),(NULL,0.01667,'2025-03-31 15:54:51.697840',NULL,NULL,_binary '��\'��M\�',_binary '�om�?�N�','ProductionBuilding','Indigo Field','','indigofield'),(10,NULL,'2025-03-31 15:54:50.444954',NULL,NULL,_binary '��O�NgJ#\�',NULL,'PopulationBuilding','Pioneer\'s Hut','','pioneershut'),(NULL,0.01667,'2025-03-31 15:54:50.955290',NULL,NULL,_binary '��PXrA�\�',_binary '@�]a�L�;\�','ProductionBuilding','Horse Breeder','','horsebreeder'),(NULL,0.125,'2025-03-31 15:54:50.740717',NULL,NULL,_binary '��[%�NL\�',_binary '�K�A�\�','ProductionBuilding','Copper Smelter','','coppersmelter'),(NULL,0.01667,'2025-03-31 15:54:50.813082',NULL,NULL,_binary '��ko�Nq\�',_binary '���D��','ProductionBuilding','Sheep Field','','sheepfield'),(NULL,0.25,'2025-03-31 15:54:51.382007',NULL,NULL,_binary '��n#�O�',_binary '��\",��A\�','ProductionBuilding','Toolmaker','','toolmaker'),(NULL,0.25,'2025-03-31 15:54:51.840810',NULL,NULL,_binary '��v�,�H\�',_binary 'cL���M�','ProductionBuilding','Cokery','','cokery'),(NULL,0.1,'2025-03-31 15:54:52.153258',NULL,NULL,_binary '��w 3�H�',NULL,'ProductionBuilding','Cannoneers School','','cannoneersschool'),(NULL,0.5,'2025-03-31 15:54:52.041086',NULL,NULL,_binary '���>�M',NULL,'ProductionBuilding','Paper Mill','','papermill'),(NULL,0.01667,'2025-03-31 15:54:51.326776',NULL,NULL,_binary '���E�?A',NULL,'ProductionBuilding','Medicus','','medicus'),(NULL,0.01667,'2025-03-31 15:54:51.628028',NULL,NULL,_binary '����Q~L\�',NULL,'ProductionBuilding','Bathhouse providing water','','bathhouseprovidingwater'),(NULL,0.01667,'2025-03-31 15:54:50.532500',NULL,NULL,_binary '�����',_binary '�� �v�A\�','ProductionBuilding','Potato Field','','potatofield');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost_building_goods`
--

DROP TABLE IF EXISTS `cost_building_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cost_building_goods` (
  `amount` int DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `building_id` binary(16) DEFAULT NULL,
  `good_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp6middi6ytdu6swae7vij962a` (`building_id`),
  KEY `FKsbw6dqvuqebpntsjumc7g7mmt` (`good_id`),
  CONSTRAINT `FKp6middi6ytdu6swae7vij962a` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`),
  CONSTRAINT `FKsbw6dqvuqebpntsjumc7g7mmt` FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost_building_goods`
--

LOCK TABLES `cost_building_goods` WRITE;
/*!40000 ALTER TABLE `cost_building_goods` DISABLE KEYS */;
INSERT INTO `cost_building_goods` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `good_id`, `id`) VALUES (20,'2025-03-31 15:54:52.451391',NULL,NULL,_binary 'm߉�2�JI�\�',_binary '��]�n|J�',_binary ' ����G~'),(10,'2025-03-31 15:54:52.393446',NULL,NULL,_binary 'ٞ\Z\\KJK���',_binary '��]�n|J�',_binary ';j���El\�'),(10,'2025-03-31 15:54:52.471196',NULL,NULL,_binary 'k@)S�AΕ�\�',_binary 't��[UFO�\�',_binary 'U����dC}'),(5,'2025-03-31 15:54:52.338673',NULL,NULL,_binary '�sy䇬K߲gfǺ\Z',_binary '��]�n|J�',_binary '[�����'),(10,'2025-03-31 15:54:52.372305',NULL,NULL,_binary '��O�NgJ#\�',_binary '��]�n|J�',_binary '�h�)@Y�'),(10,'2025-03-31 15:54:52.424633',NULL,NULL,_binary '�%���fDS',_binary '��]�n|J�',_binary '��-�y�A\�');
/*!40000 ALTER TABLE `cost_building_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `is_map_resource` tinyint(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `slug` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s6la9h5sjmb40l2ldyrdgrvum` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` (`is_map_resource`, `created_at`, `deleted_at`, `updated_at`, `id`, `name`, `remarks`, `slug`) VALUES (0,'2025-03-31 15:54:47.648991',NULL,NULL,_binary '�����','Clay','','clay'),(0,'2025-03-31 15:54:47.830346',NULL,NULL,_binary '�)�Ad��','Marble','Build material','marble'),(0,'2025-03-31 15:54:47.891276',NULL,NULL,_binary '���	B@E\�','Gemstone','','gemstone'),(0,'2025-03-31 15:54:48.063904',NULL,NULL,_binary '����LP','Cannon','','cannon'),(0,'2025-03-31 15:54:47.596950',NULL,NULL,_binary '���ZE�','Bread','','bread'),(0,'2025-03-31 15:54:47.758436',NULL,NULL,_binary '��M�\�','Gold Ingot','','goldingot'),(0,'2025-03-31 15:54:47.725710',NULL,NULL,_binary 'yD���@K\�','Meat','','meat'),(0,'2025-03-31 15:54:47.641003',NULL,NULL,_binary 'Ĥ�gC��\�','Longbow','','longbow'),(0,'2025-03-31 15:54:47.605745',NULL,NULL,_binary 'ʜ�V\"@��]','Tobacco','','tobacco'),(0,'2025-03-31 15:54:48.090899',NULL,NULL,_binary '�\0	�A�\�','Vineyard','','vineyard'),(0,'2025-03-31 15:54:47.965667',NULL,NULL,_binary 'J�Y�MM�','Barrel','','barrel'),(0,'2025-03-31 15:54:47.796319',NULL,NULL,_binary '#�&�jxK@�\�','Iron Sword','','ironsword'),(0,'2025-03-31 15:54:48.072903',NULL,NULL,_binary '$�%�RL��','Metal Cuttings','','metalcuttings'),(1,'2025-03-31 15:54:47.352906',NULL,NULL,_binary '\'�#�E6�r','Indigo Field','','indigofield'),(0,'2025-03-31 15:54:47.524704',NULL,NULL,_binary '\'��W�PL,\�','Ropes','','ropes'),(0,'2025-03-31 15:54:47.439986',NULL,NULL,_binary '+1b�M��\�','Favor','Global, needed for more island slots','favor'),(1,'2025-03-31 15:54:47.343648',NULL,NULL,_binary '+c���qH[\�','Horse Field','','horsefield'),(0,'2025-03-31 15:54:47.553622',NULL,NULL,_binary '1�{��G�','Copper Sword','','coppersword'),(0,'2025-03-31 15:54:47.813353',NULL,NULL,_binary '2�yԭ�L݁�','Tools','Build material','tools'),(0,'2025-03-31 15:54:47.897934',NULL,NULL,_binary ';�:��D�','Goblet','','goblet'),(0,'2025-03-31 15:54:47.987367',NULL,NULL,_binary '<����Gu','Windjammer','','windjammer'),(1,'2025-03-31 15:54:47.313810',NULL,NULL,_binary '@��t�N�','Water tile','','watertile'),(0,'2025-03-31 15:54:47.742101',NULL,NULL,_binary 'A�pJ!�;\�','Gold Ore','','goldore'),(0,'2025-03-31 15:54:47.515565',NULL,NULL,_binary 'A`��ޕI�\�','Archer','','archer'),(0,'2025-03-31 15:54:47.921581',NULL,NULL,_binary 'D�Ѧ%,Go��','Candle Holder','','candleholder'),(0,'2025-03-31 15:54:47.542601',NULL,NULL,_binary 'E��Fr�\�','Copper Ingot','','copperingot'),(0,'2025-03-31 15:54:47.718073',NULL,NULL,_binary 'F�,|iC��','Salt','','salt'),(0,'2025-03-31 15:54:47.764695',NULL,NULL,_binary 'J)�w�B�\�','Gold Jewelry','','goldjewelry'),(0,'2025-03-31 15:54:47.772866',NULL,NULL,_binary 'L~9�}C*�Z\�','Linseed Oil','','linseedoil'),(0,'2025-03-31 15:54:47.878705',NULL,NULL,_binary 'M�����','Garment','','garment'),(0,'2025-03-31 15:54:47.489265',NULL,NULL,_binary 'NkP5�F��','Linseed','','linseed'),(0,'2025-03-31 15:54:47.657359',NULL,NULL,_binary 'P��Z#Ag�\�','Brick','Build material','brick'),(0,'2025-03-31 15:54:47.588152',NULL,NULL,_binary 'R�!q^|O؏R�\�','Flour','','flour'),(0,'2025-03-31 15:54:48.054792',NULL,NULL,_binary 'SwD���B[\�','Gunpowder','','gunpowder'),(0,'2025-03-31 15:54:47.473669',NULL,NULL,_binary 'T	�|:\nET��','Schnapps','','schnapps'),(0,'2025-03-31 15:54:47.929836',NULL,NULL,_binary 'W\n,���Ly\�','Liqueur','','liqueur'),(0,'2025-03-31 15:54:47.804665',NULL,NULL,_binary '\\sW5DH�lĦ\�','Militia','','militia'),(0,'2025-03-31 15:54:47.666409',NULL,NULL,_binary ']�C.$A��Q','Clothes','','clothes'),(0,'2025-03-31 15:54:47.863823',NULL,NULL,_binary '`|%���M�','Dye','','dye'),(0,'2025-03-31 15:54:47.676072',NULL,NULL,_binary 'aQ�ͧAG��','Malt','','malt'),(0,'2025-03-31 15:54:47.422326',NULL,NULL,_binary 'cK�uG@z��','Coin','Global','coin'),(0,'2025-03-31 15:54:48.030587',NULL,NULL,_binary 'dWM��LH�\�','Armored Horse','','armoredhorse'),(0,'2025-03-31 15:54:47.780291',NULL,NULL,_binary 'd���H�G\�','Iron Ore','','ironore'),(0,'2025-03-31 15:54:48.019353',NULL,NULL,_binary 'i��SzG�','Steel Ingot','','steelingot'),(1,'2025-03-31 15:54:47.403956',NULL,NULL,_binary 'l��>��F\�','Tobacco Field','','tobaccofield'),(1,'2025-03-31 15:54:47.413331',NULL,NULL,_binary 'm��f�H\\\�','Wheat Field','','wheatfield'),(0,'2025-03-31 15:54:47.954565',NULL,NULL,_binary 'th���Kä ','Grapes','','grapes'),(0,'2025-03-31 15:54:47.466225',NULL,NULL,_binary 't��[UFO�\�','Plank','Build material','plank'),(1,'2025-03-31 15:54:47.368883',NULL,NULL,_binary 'uL�}�{KǾ�','Potato Field','','potatofield'),(0,'2025-03-31 15:54:47.937336',NULL,NULL,_binary 'x���E:Fy\�','Lobster','','lobster'),(0,'2025-03-31 15:54:47.631666',NULL,NULL,_binary 'yg��Kր]\�','Horse','','horse'),(1,'2025-03-31 15:54:47.323887',NULL,NULL,_binary 'ݧ�F|�Nm�','Mountain tile','','mountaintile'),(1,'2025-03-31 15:54:47.333675',NULL,NULL,_binary 'ޥ\0��\ZN˺�','Hop Field','','hopfield'),(0,'2025-03-31 15:54:48.002545',NULL,NULL,_binary '�X2O\\��','Coke','','coke'),(0,'2025-03-31 15:54:47.702332',NULL,NULL,_binary '�\r6�fIS�h','Cattle','','cattle'),(0,'2025-03-31 15:54:47.995284',NULL,NULL,_binary '�	��	Mt\�','Book','','book'),(0,'2025-03-31 15:54:47.974715',NULL,NULL,_binary '�s��ICщ\�','Wine','','wine'),(1,'2025-03-31 15:54:47.395876',NULL,NULL,_binary '�g�Y�Dŏ.','Mulberry Trees','','mulberrytrees'),(0,'2025-03-31 15:54:47.430892',NULL,NULL,_binary '�\'p��7A�','Cartography','Global, used for Discovery','cartography'),(1,'2025-03-31 15:54:47.299513',NULL,NULL,_binary '�)y�%I�\�','Land tile','','landtile'),(0,'2025-03-31 15:54:47.822323',NULL,NULL,_binary '�)��?H�','Crossbow','','crossbow'),(0,'2025-03-31 15:54:47.945861',NULL,NULL,_binary '�.+^AzBλ=e�','Feast','','feast'),(0,'2025-03-31 15:54:47.457685',NULL,NULL,_binary '�@�(�O�','Fish','','fish'),(0,'2025-03-31 15:54:47.710783',NULL,NULL,_binary '�D�&�I^\�','Rock Salt','','rocksalt'),(0,'2025-03-31 15:54:47.614513',NULL,NULL,_binary '�Oy�\'%EO�^','Cigar','','cigar'),(0,'2025-03-31 15:54:47.684184',NULL,NULL,_binary '�O��?TNi\�','Hops','','hops'),(1,'2025-03-31 15:54:47.387591',NULL,NULL,_binary '�RWTH~��','Cotton Field','','cottonfield'),(0,'2025-03-31 15:54:47.734173',NULL,NULL,_binary '�VT�}�MF\�','Coal','','coal'),(0,'2025-03-31 15:54:47.787443',NULL,NULL,_binary '�X�ޚsA�\�','Iron Ingot','','ironingot'),(1,'2025-03-31 15:54:47.376191',NULL,NULL,_binary '�Z�\ZnGڑ�','Sheep Field','','sheepfield'),(0,'2025-03-31 15:54:47.481337',NULL,NULL,_binary '�a���@H','Stone','Build material','stone'),(0,'2025-03-31 15:54:47.571129',NULL,NULL,_binary '�cP>j�Jc�V','Fabric','','fabric'),(0,'2025-03-31 15:54:47.838115',NULL,NULL,_binary '�e1:��K\�','Silk','','silk'),(0,'2025-03-31 15:54:48.082679',NULL,NULL,_binary '�u?�cC�\�','Fireworks','','fireworks'),(0,'2025-03-31 15:54:47.624190',NULL,NULL,_binary '�ɢ���H9','Sail','','sail'),(0,'2025-03-31 15:54:47.751525',NULL,NULL,_binary '��A�[F�','Gold','','gold'),(1,'2025-03-31 15:54:47.361209',NULL,NULL,_binary '���n�L}','Linseed Field','','linseedfield'),(0,'2025-03-31 15:54:47.850513',NULL,NULL,_binary '��D�OϽD','Silk Cloth','','silkcloth'),(0,'2025-03-31 15:54:47.449174',NULL,NULL,_binary '��]�n|J�','Wood','Build material','wood'),(0,'2025-03-31 15:54:47.497311',NULL,NULL,_binary '��m�!N�','Linen','','linen'),(0,'2025-03-31 15:54:47.692855',NULL,NULL,_binary '��oVL4�\�','Beer','','beer'),(0,'2025-03-31 15:54:47.533274',NULL,NULL,_binary '��yс�D\�','Copper Ore','','copperore'),(0,'2025-03-31 15:54:47.579304',NULL,NULL,_binary '���D܈O�','Wheat','','wheat'),(0,'2025-03-31 15:54:48.041818',NULL,NULL,_binary '���_��','Saltpeter','','saltpeter'),(0,'2025-03-31 15:54:47.906275',NULL,NULL,_binary '���b�Hݕ','Honey','','honey'),(0,'2025-03-31 15:54:47.913650',NULL,NULL,_binary '���t,I\Z�','Candle','','candle'),(0,'2025-03-31 15:54:47.506028',NULL,NULL,_binary '����6)G\�','Bow','','bow'),(0,'2025-03-31 15:54:47.562809',NULL,NULL,_binary '�����\Z','Yarn','','yarn');
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population`
--

DROP TABLE IF EXISTS `population`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `population` (
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_m9q869h9yj6e396uevaj0grdp` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population`
--

LOCK TABLES `population` WRITE;
/*!40000 ALTER TABLE `population` DISABLE KEYS */;
INSERT INTO `population` (`created_at`, `deleted_at`, `updated_at`, `id`, `name`, `slug`) VALUES ('2025-03-31 15:54:52.247264',NULL,NULL,_binary '5����C\�','Colonists','colonists'),('2025-03-31 15:54:52.281515',NULL,NULL,_binary 'f����nB\�','Paragons','paragons'),('2025-03-31 15:54:52.255901',NULL,NULL,_binary '�*�+|<H�\�','Townsmen','townsmen'),('2025-03-31 15:54:52.236833',NULL,NULL,_binary '��Ó\nKG\\�t','Pioneers','pioneers'),('2025-03-31 15:54:52.265112',NULL,NULL,_binary '���b*E}\�','Merchants','merchants');
/*!40000 ALTER TABLE `population` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population_requirement`
--

DROP TABLE IF EXISTS `population_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `population_requirement` (
  `consumption` float DEFAULT NULL,
  `is_basic` bit(1) DEFAULT NULL,
  `produce` float DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `good_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `population_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbcr71dxrg9y3h2av04oasti89` (`good_id`),
  KEY `FKanqh1no2fb1ouj1cup4sbi6hb` (`population_id`),
  CONSTRAINT `FKanqh1no2fb1ouj1cup4sbi6hb` FOREIGN KEY (`population_id`) REFERENCES `population` (`id`),
  CONSTRAINT `FKbcr71dxrg9y3h2av04oasti89` FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population_requirement`
--

LOCK TABLES `population_requirement` WRITE;
/*!40000 ALTER TABLE `population_requirement` DISABLE KEYS */;
INSERT INTO `population_requirement` (`consumption`, `is_basic`, `produce`, `created_at`, `deleted_at`, `updated_at`, `good_id`, `id`, `population_id`) VALUES (0,_binary '',0,'2025-03-31 15:54:52.297077',NULL,NULL,_binary '@��t�N�',_binary '�-|gQ�I^�(',_binary '��Ó\nKG\\�t');
/*!40000 ALTER TABLE `population_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `quantity_of_input_1` int DEFAULT NULL,
  `quantity_of_input_10` int DEFAULT NULL,
  `quantity_of_input_2` int DEFAULT NULL,
  `quantity_of_input_3` int DEFAULT NULL,
  `quantity_of_input_4` int DEFAULT NULL,
  `quantity_of_input_5` int DEFAULT NULL,
  `quantity_of_input_6` int DEFAULT NULL,
  `quantity_of_input_7` int DEFAULT NULL,
  `quantity_of_input_8` int DEFAULT NULL,
  `quantity_of_input_9` int DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `input_1` binary(16) DEFAULT NULL,
  `input_10` binary(16) DEFAULT NULL,
  `input_2` binary(16) DEFAULT NULL,
  `input_3` binary(16) DEFAULT NULL,
  `input_4` binary(16) DEFAULT NULL,
  `input_5` binary(16) DEFAULT NULL,
  `input_6` binary(16) DEFAULT NULL,
  `input_7` binary(16) DEFAULT NULL,
  `input_8` binary(16) DEFAULT NULL,
  `input_9` binary(16) DEFAULT NULL,
  `output` binary(16) NOT NULL,
  `production_building` binary(16) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r6fr7vfovs1k2wq7bjeqberj5` (`slug`),
  UNIQUE KEY `UK_f4dq4cgv6n33926akdk7gp20s` (`production_building`),
  KEY `FKk2dnvk7u98noftg1hx6k76i62` (`input_1`),
  KEY `FKoslhn6r9w7ln2o3cs6k3lp7qw` (`input_10`),
  KEY `FKr1w9rj2jdk3te3bdfbk42lc7y` (`input_2`),
  KEY `FKq698ebgk1yrcrttqcuxtyiukc` (`input_3`),
  KEY `FKl9pixcpqdeytt2l6y34xh82ti` (`input_4`),
  KEY `FK1s1ofha5wphx7x3shtuewr8tg` (`input_5`),
  KEY `FK5mwifdj5qx2fsxinpo8wv3ujk` (`input_6`),
  KEY `FKaf9qawkonlo2biqrfmaqkgnac` (`input_7`),
  KEY `FK601j7ligefitu7kjynnjjkful` (`input_8`),
  KEY `FKldrekctvk1mxgc90yef310boa` (`input_9`),
  KEY `FKdr36q569c4aw810t4w7v8rl5v` (`output`),
  CONSTRAINT `FK1s1ofha5wphx7x3shtuewr8tg` FOREIGN KEY (`input_5`) REFERENCES `good` (`id`),
  CONSTRAINT `FK5mwifdj5qx2fsxinpo8wv3ujk` FOREIGN KEY (`input_6`) REFERENCES `good` (`id`),
  CONSTRAINT `FK601j7ligefitu7kjynnjjkful` FOREIGN KEY (`input_8`) REFERENCES `good` (`id`),
  CONSTRAINT `FKaf9qawkonlo2biqrfmaqkgnac` FOREIGN KEY (`input_7`) REFERENCES `good` (`id`),
  CONSTRAINT `FKdr36q569c4aw810t4w7v8rl5v` FOREIGN KEY (`output`) REFERENCES `good` (`id`),
  CONSTRAINT `FKk2dnvk7u98noftg1hx6k76i62` FOREIGN KEY (`input_1`) REFERENCES `good` (`id`),
  CONSTRAINT `FKl9pixcpqdeytt2l6y34xh82ti` FOREIGN KEY (`input_4`) REFERENCES `good` (`id`),
  CONSTRAINT `FKldrekctvk1mxgc90yef310boa` FOREIGN KEY (`input_9`) REFERENCES `good` (`id`),
  CONSTRAINT `FKoslhn6r9w7ln2o3cs6k3lp7qw` FOREIGN KEY (`input_10`) REFERENCES `good` (`id`),
  CONSTRAINT `FKq698ebgk1yrcrttqcuxtyiukc` FOREIGN KEY (`input_3`) REFERENCES `good` (`id`),
  CONSTRAINT `FKr1w9rj2jdk3te3bdfbk42lc7y` FOREIGN KEY (`input_2`) REFERENCES `good` (`id`),
  CONSTRAINT `FKrlc0eox7eht7lcydxamlduwrh` FOREIGN KEY (`production_building`) REFERENCES `building` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` (`quantity_of_input_1`, `quantity_of_input_10`, `quantity_of_input_2`, `quantity_of_input_3`, `quantity_of_input_4`, `quantity_of_input_5`, `quantity_of_input_6`, `quantity_of_input_7`, `quantity_of_input_8`, `quantity_of_input_9`, `created_at`, `deleted_at`, `updated_at`, `id`, `input_1`, `input_10`, `input_2`, `input_3`, `input_4`, `input_5`, `input_6`, `input_7`, `input_8`, `input_9`, `output`, `production_building`, `name`, `slug`) VALUES (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.445547',NULL,NULL,_binary '\0Wz\n\n�BU��',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�\r6�fIS�h',NULL,'Cattle','cattle'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.377896',NULL,NULL,_binary 'RO��E�\�',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '��m�!N�',NULL,'Linen','linen'),(1,0,2,2,0,0,0,0,0,0,'2025-03-31 15:54:50.401633',NULL,NULL,_binary 'ӵ3��D�\�',_binary '�)y�%I�\�',NULL,_binary 'SwD���B[\�',_binary '$�%�RL��',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�u?�cC�\�',NULL,'Fireworks','fireworks'),(1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.555692',NULL,NULL,_binary '�K�A�\�',_binary '�)y�%I�\�',NULL,_binary '��yс�D\�',_binary '��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'E��Fr�\�',NULL,'Copper Ingot','copperingot'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.236058',NULL,NULL,_binary '�h�3F�\�',_binary '�)y�%I�\�',NULL,_binary '��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 't��[UFO�\�',NULL,'Plank','plank'),(1,0,2,10,0,0,0,0,0,0,'2025-03-31 15:54:49.063272',NULL,NULL,_binary '��ĺC��',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',_binary '��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Ĥ�gC��\�',NULL,'Longbow','longbow'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.324807',NULL,NULL,_binary '@���Lǜ',_binary '�)y�%I�\�',NULL,_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '���n�L}',NULL,'Linseed Field','linseedfield'),(1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.213505',NULL,NULL,_binary '\"� �5�Dۥ_',_binary '�)y�%I�\�',NULL,_binary 'th���Kä ',_binary 'J�Y�MM�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�s��ICщ\�',NULL,'Wine','wine'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.753776',NULL,NULL,_binary '%r��`Kd�\n',_binary '�)y�%I�\�',NULL,_binary '���D܈O�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'R�!q^|O؏R�\�',NULL,'Flour','flour'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.180554',NULL,NULL,_binary '&g���bO\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '@��t�N�',NULL,'Water tile','watertile'),(1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.590720',NULL,NULL,_binary '\'�穨zG^�\'T\�',_binary '�)y�%I�\�',NULL,_binary 'E��Fr�\�',_binary '��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '1�{��G�',NULL,'Copper Sword','coppersword'),(1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:49.580503',NULL,NULL,_binary ')���jYLW\�',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',_binary '�X�ޚsA�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�)��?H�',NULL,'Crossbow','crossbow'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.006656',NULL,NULL,_binary '*�8e��H\\\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�����',NULL,'Clay','clay'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:49.636291',NULL,NULL,_binary '.(6G�rE�g\�',_binary '�)y�%I�\�',NULL,_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�)�Ad��',NULL,'Marble','marble'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.376128',NULL,NULL,_binary '/Zy�\n`N��\�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary '�X�ޚsA�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '#�&�jxK@�\�',NULL,'Iron Sword','ironsword'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.353222',NULL,NULL,_binary '0�҉*�J�\�',_binary '�)y�%I�\�',NULL,_binary '���n�L}',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'NkP5�F��',NULL,'Linseed','linseed'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.557586',NULL,NULL,_binary '64��JI�\�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary '��M�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'J)�w�B�\�',NULL,'Gold Jewelry','goldjewelry'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.842901',NULL,NULL,_binary '86�9[F~��',_binary '�)y�%I�\�',NULL,_binary '��M�\�',_binary '���	B@E\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary ';�:��D�',NULL,'Goblet','goblet'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.797934',NULL,NULL,_binary '9,��aL\'�D',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '+c���qH[\�',NULL,'Horse Field','horsefield'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:49.133891',NULL,NULL,_binary ';�$mIp��',_binary '�)y�%I�\�',NULL,_binary '�cP>j�Jc�V',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary ']�C.$A��Q',NULL,'Clothes','clothes'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.374119',NULL,NULL,_binary '?��G@̇Kv\�',_binary '�)y�%I�\�',NULL,_binary '�X�ޚsA�\�',_binary 'E��Fr�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '$�%�RL��',NULL,'Metal Cuttings','metalcuttings'),(1,0,20,0,0,0,0,0,0,0,'2025-03-31 15:54:48.823886',NULL,NULL,_binary '@�]a�L�;\�',_binary '�)y�%I�\�',NULL,_binary '+c���qH[\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'yg��Kր]\�',NULL,'Horse','horse'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.011217',NULL,NULL,_binary 'I��R oE�\�',_binary '�)y�%I�\�',NULL,_binary '�X�ޚsA�\�',_binary '�X2O\\��',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'i��SzG�',NULL,'Steel Ingot','steelingot'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.801530',NULL,NULL,_binary 'N�0��L-�',_binary '�)y�%I�\�',NULL,_binary '��D�OϽD',_binary '`|%���M�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'M�����',NULL,'Garment','garment'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.818531',NULL,NULL,_binary 'O^ྦྷBBb�;�',_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '���	B@E\�',NULL,'Gemstone','gemstone'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.737671',NULL,NULL,_binary 'Q�����',_binary '�)y�%I�\�',NULL,_binary '�e1:��K\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '��D�OϽD',NULL,'Silk Cloth','silkcloth'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.687504',NULL,NULL,_binary 'Y�_��H�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�g�Y�Dŏ.',NULL,'Mulberry Trees','mulberrytrees'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.099052',NULL,NULL,_binary 'a���A�A\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'x���E:Fy\�',NULL,'Lobster','lobster'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.972788',NULL,NULL,_binary 'cL���M�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�X2O\\��',NULL,'Coke','coke'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.492251',NULL,NULL,_binary 'f>�SBh�mO\�',_binary '�)y�%I�\�',NULL,_binary 'F�,|iC��',_binary '�\r6�fIS�h',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'yD���@K\�',NULL,'Meat','meat'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.183994',NULL,NULL,_binary 'h�\r��GE[\�',_binary '�)y�%I�\�',NULL,_binary 'ޥ\0��\ZN˺�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�O��?TNi\�',NULL,'Hops','hops'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.036540',NULL,NULL,_binary 'h���Nػ\�',_binary '�)y�%I�\�',NULL,_binary 'yg��Kր]\�',_binary 'i��SzG�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'dWM��LH�\�',NULL,'Armored Horse','armoredhorse'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.527808',NULL,NULL,_binary 'v#Zi�C@?�?\�',_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '��yс�D\�',NULL,'Copper Ore','copperore'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.702780',NULL,NULL,_binary 'v��2U�Og\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'm��f�H\\\�',NULL,'Wheat Field','wheatfield'),(1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.238330',NULL,NULL,_binary 'w���B\�',_binary '�)y�%I�\�',NULL,_binary '�O��?TNi\�',_binary 'aQ�ͧAG��',NULL,NULL,NULL,NULL,NULL,NULL,_binary '��oVL4�\�',NULL,'Beer','beer'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.870249',NULL,NULL,_binary '{�{���G',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'l��>��F\�',NULL,'Tobacco Field','tobaccofield'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:48.987337',NULL,NULL,_binary '�qn�4F,�\�',_binary '�)y�%I�\�',NULL,_binary '\'��W�PL,\�',_binary '�����\Z',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�ɢ���H9',NULL,'Sail','sail'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.298830',NULL,NULL,_binary '�\\�T@�\�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'SwD���B[\�',NULL,'Gunpowder','gunpowder'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.729025',NULL,NULL,_binary '��Y�L�',_binary '�)y�%I�\�',NULL,_binary 'm��f�H\\\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '���D܈O�',NULL,'Wheat','wheat'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:50.126235',NULL,NULL,_binary '�#�L�=',_binary '�)y�%I�\�',NULL,_binary 'W\n,���Ly\�',_binary 'x���E:Fy\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�.+^AzBλ=e�',NULL,'Feast','feast'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.677234',NULL,NULL,_binary '�,�-J.E̊�',_binary '�)y�%I�\�',NULL,_binary '�Z�\ZnGڑ�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�����\Z',NULL,'Yarn','yarn'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.509373',NULL,NULL,_binary '�,�OhG� \�',_binary '�)y�%I�\�',NULL,_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�a���@H',NULL,'Stone','stone'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.509728',NULL,NULL,_binary '�2�\n��FE',_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'A�pJ!�;\�',NULL,'Gold Ore','goldore'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.324897',NULL,NULL,_binary '�5�lqH��',_binary '�)y�%I�\�',NULL,_binary 'i��SzG�',_binary 'SwD���B[\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '����LP',NULL,'Cannon','cannon'),(1,0,1,16,0,0,0,0,0,0,'2025-03-31 15:54:50.190440',NULL,NULL,_binary '�7�Zw�Fo\�',_binary '�)y�%I�\�',NULL,_binary '�X�ޚsA�\�',_binary 't��[UFO�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'J�Y�MM�',NULL,'Barrel','barrel'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.208088',NULL,NULL,_binary '�M����',_binary '�)y�%I�\�',NULL,_binary '���D܈O�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'aQ�ͧAG��',NULL,'Malt','malt'),(1,0,0,1,1,0,0,0,0,0,'2025-03-31 15:54:48.457949',NULL,NULL,_binary '�SIJ�O��',_binary '�)y�%I�\�',NULL,_binary '��A�[F�',_binary '����6)G\�',_binary '\\sW5DH�lĦ\�',NULL,NULL,NULL,NULL,NULL,_binary 'A`��ޕI�\�',NULL,'Archer','archer'),(1,0,1,5,0,0,0,0,0,0,'2025-03-31 15:54:48.416319',NULL,NULL,_binary '�Y��N\�',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',_binary '��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '����6)G\�',NULL,'Bow','bow'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.263818',NULL,NULL,_binary '�b���M\�',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'L~9�}C*�Z\�',NULL,'Linseed Oil','linseedoil'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.776204',NULL,NULL,_binary '�b��YDK\�',_binary '�)y�%I�\�',NULL,_binary '\'�#�E6�r',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '`|%���M�',NULL,'Dye','dye'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.284550',NULL,NULL,_binary '�ivfDAr�\"Aq',_binary '�)y�%I�\�',NULL,_binary 'uL�}�{KǾ�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'T	�|:\nET��',NULL,'Schnapps','schnapps'),(1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:50.082189',NULL,NULL,_binary '�k͆\\�@�\�',_binary '�)y�%I�\�',NULL,_binary 'T	�|:\nET��',_binary '���b�Hݕ',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'W\n,���Ly\�',NULL,'Liqueur','liqueur'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.755394',NULL,NULL,_binary '�om�?�N�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\'�#�E6�r',NULL,'Indigo Field','indigofield'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.207501',NULL,NULL,_binary '�zҫ)bE ��',_binary '�)y�%I�\�',NULL,_binary '@��t�N�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�@�(�O�',NULL,'Fish','fish'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.532089',NULL,NULL,_binary '�~a�`JB�\�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary 'A�pJ!�;\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '��M�\�',NULL,'Gold Ingot','goldingot'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.883946',NULL,NULL,_binary '�Ɣ��G\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '���b�Hݕ',NULL,'Honey','honey'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.484096',NULL,NULL,_binary '���p9G!\�',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\'��W�PL,\�',NULL,'Ropes','ropes'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.146086',NULL,NULL,_binary '���r`HW\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�\0	�A�\�',NULL,'Vineyard','vineyard'),(1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.935049',NULL,NULL,_binary '��	�!cNŮA',_binary '�)y�%I�\�',NULL,_binary '���t,I\Z�',_binary 'E��Fr�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'D�Ѧ%,Go��',NULL,'Candle Holder','candleholder'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.319867',NULL,NULL,_binary '��\n��6B*',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary 'd���H�G\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�X�ޚsA�\�',NULL,'Iron Ingot','ironingot'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.713856',NULL,NULL,_binary '��^1�Nu\�',_binary '�)y�%I�\�',NULL,_binary '�g�Y�Dŏ.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�e1:��K\�',NULL,'Silk','silk'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.258262',NULL,NULL,_binary '�� �v�A\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'uL�}�{KǾ�',NULL,'Potato Field','potatofield'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.347948',NULL,NULL,_binary '��\",��A\�',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary '�X�ޚsA�\�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '2�yԭ�L݁�',NULL,'Tools','tools'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.465852',NULL,NULL,_binary '��4��7H;',_binary 'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�D�&�I^\�',NULL,'Rock Salt','rocksalt'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.912414',NULL,NULL,_binary '��5:+�DȪ\�',_binary '�)y�%I�\�',NULL,_binary 'l��>��F\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ʜ�V\"@��]',NULL,'Tobacco','tobacco'),(1,0,12,0,0,0,0,0,0,0,'2025-03-31 15:54:50.167103',NULL,NULL,_binary '��8X��Fg',_binary '�)y�%I�\�',NULL,_binary '�\0	�A�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'th���Kä ',NULL,'Grapes','grapes'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.034764',NULL,NULL,_binary '��<��iDu',_binary '�)y�%I�\�',NULL,_binary '�VT�}�MF\�',_binary '�����',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'P��Z#Ag�\�',NULL,'Brick','brick'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.778734',NULL,NULL,_binary '��H;�J�',_binary '�)y�%I�\�',NULL,_binary 'R�!q^|O؏R�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '���ZE�',NULL,'Bread','bread'),(7,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.149490',NULL,NULL,_binary '��K�\ZK9\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '��]�n|J�',NULL,'Wood','wood'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.295538',NULL,NULL,_binary '��aB��A\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'd���H�G\�',NULL,'Iron Ore','ironore'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.910236',NULL,NULL,_binary '��b~d6J6�d',_binary '�)y�%I�\�',NULL,_binary 'NkP5�F��',_binary '���b�Hݕ',NULL,NULL,NULL,NULL,NULL,NULL,_binary '���t,I\Z�',NULL,'Candle','candle'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.109822',NULL,NULL,_binary '��cֺCs�\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�RWTH~��',NULL,'Cotton Field','cottonfield'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.156627',NULL,NULL,_binary '��u�\'8C\�',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ޥ\0��\ZN˺�',NULL,'Hop Field','hopfield'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.952686',NULL,NULL,_binary '��£��O\�',_binary '�)y�%I�\�',NULL,_binary 'ʜ�V\"@��]',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�Oy�\'%EO�^',NULL,'Cigar','cigar'),(1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.263198',NULL,NULL,_binary '��ܟ�IG\�',_binary '�)y�%I�\�',NULL,NULL,_binary '`|%���M�',NULL,NULL,NULL,NULL,NULL,NULL,_binary '�	��	Mt\�',NULL,'Book','book'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.647123',NULL,NULL,_binary '���D��',_binary '�)y�%I�\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '�Z�\ZnGڑ�',NULL,'Sheep Field','sheepfield');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_population_building`
--

DROP TABLE IF EXISTS `requirement_population_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_population_building` (
  `amount` int DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `building_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `population_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h2xp8yfvhi2ygiaa5a03ksqb2` (`building_id`),
  KEY `FK4jrfuw2qd2g453dbwe827d89i` (`population_id`),
  CONSTRAINT `FK4jrfuw2qd2g453dbwe827d89i` FOREIGN KEY (`population_id`) REFERENCES `population` (`id`),
  CONSTRAINT `FKfax1aoc78u08wa8klwl1v9mfw` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_population_building`
--

LOCK TABLES `requirement_population_building` WRITE;
/*!40000 ALTER TABLE `requirement_population_building` DISABLE KEYS */;
INSERT INTO `requirement_population_building` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `id`, `population_id`) VALUES (10,'2025-03-31 15:54:52.494902',NULL,NULL,_binary '�%���fDS',_binary 'J����TA\�',_binary '��Ó\nKG\\�t'),(50,'2025-03-31 15:54:52.532531',NULL,NULL,_binary 'm߉�2�JI�\�',_binary '��,�gUIT\�',_binary '��Ó\nKG\\�t');
/*!40000 ALTER TABLE `requirement_population_building` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-03  9:42:49
