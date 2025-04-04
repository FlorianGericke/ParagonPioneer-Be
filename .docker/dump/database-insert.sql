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
INSERT INTO `building` (`capacity`, `production_per_minute`, `created_at`, `deleted_at`, `updated_at`, `id`, `recipe`, `dtype`, `name`, `remarks`, `slug`) VALUES (NULL,0.125,'2025-03-31 15:54:51.525302',NULL,NULL,_binary 'ï¿½oï¿½ï¿½NÌ®\0',_binary 'ï¿½~aï¿½`JBï¿½\ï¿','ProductionBuilding','Gold Smelter','','goldsmelter'),(NULL,1,'2025-03-31 15:54:50.550610',NULL,NULL,_binary 'k@)Sï¿½AÎ•ï¿½\ï¿',_binary 'ï¿½ivfDArï¿½\"Aq','ProductionBuilding','Potato Farm','','potatofarm'),(NULL,0.75,'2025-03-31 15:54:52.018529',NULL,NULL,_binary '	LUWï¿½ï¿½Bï¿½\ï¿',_binary '\"ï¿½ ï¿½5ï¿½DÛ¥_','ProductionBuilding','Winepress','','winepress'),(NULL,0.75,'2025-03-31 15:54:51.996471',NULL,NULL,_binary '\\oï¿½ï¿½M-ï¿½\ï',_binary 'ï¿½7ï¿½Zwï¿½Fo\ï¿','ProductionBuilding','Cooper','','cooper'),(NULL,0.01667,'2025-03-31 15:54:51.188762',NULL,NULL,_binary 'ï¿½.a~Mï¿½uR\ï',_binary 'ï¿½ï¿½cÖºCsï¿½\ï','ProductionBuilding','Cotton Field','','cottonfield'),(NULL,0.01667,'2025-03-31 15:54:51.644988',NULL,NULL,_binary '	jkJï¿½ï¿½0\ï¿',_binary 'Yï¿½_ï¿½ï¿½Hï¿½','ProductionBuilding','Mulberry Trees','','mulberrytrees'),(NULL,0.5,'2025-03-31 15:54:50.890607',NULL,NULL,_binary 'ï¿½Iï¿½d]Cï¿½\ï¿',_binary '%rï¿½ï¿½`Kdï¿½\n','ProductionBuilding','Windmill','','windmill'),(NULL,0.75,'2025-03-31 15:54:51.977361',NULL,NULL,_binary ']ï¿½ï¿½6ï¿½Nï¿½',NULL,'ProductionBuilding','Winery','','winery'),(NULL,0.25,'2025-03-31 15:54:51.083592',NULL,NULL,_binary 'ï¿½/Xï¿½Fwï¿½\ï',_binary 'ï¿½qnï¿½4F,ï¿½\ï','ProductionBuilding','Sailmaker','','sailmaker'),(NULL,0.25,'2025-03-31 15:54:51.202843',NULL,NULL,_binary '\"ï¿½M`y@ï¿½ï¿½\ï',_binary ';ï¿½$mIpï¿½ï¿½','ProductionBuilding','Tailor','','tailor'),(NULL,0.75,'2025-03-31 15:54:51.825598',NULL,NULL,_binary '\"ï¿½aï¿½}Fï¿½\ï¿',_binary 'ï¿½ï¿½	ï¿½!cNÅ®A','ProductionBuilding','Fine Forge','','fineforge'),(NULL,0.25,'2025-03-31 15:54:51.346182',NULL,NULL,_binary '&Ñ¤ï¿½cAÅï¿½Ch',_binary 'ï¿½ï¿½aBï¿½ï¿½A\ï','ProductionBuilding','Iron Mine','','ironmine'),(NULL,0.01667,'2025-03-31 15:54:51.609969',NULL,NULL,_binary '\'ï¿½ï¿½4ï¿½ODj\ï¿',NULL,'ProductionBuilding','Bathhouse','','bathhouse'),(NULL,0.01667,'2025-03-31 15:54:52.212837',NULL,NULL,_binary '(ï¿½ï¿½C2ï¿½\ï',NULL,'ProductionBuilding','Tiltyard','','tiltyard'),(NULL,0.5,'2025-03-31 15:54:51.231172',NULL,NULL,_binary '*ï¿½=`ï¿½Gï¿½',_binary 'hï¿½\rï¿½ï¿½GE[\ï¿','ProductionBuilding','Hop Farm','','hopfarm'),(NULL,0.14286,'2025-03-31 15:54:50.693038',NULL,NULL,_binary '/ï¿½ï¿½OB%ï¿½\ï',_binary 'ï¿½,ï¿½OhGï¿½ \ï','ProductionBuilding','Stonecutter','','stonecutter'),(NULL,0.01667,'2025-03-31 15:54:50.934870',NULL,NULL,_binary '3`ï¿½ï¿½|ï¿½@ï¿½',_binary '9,ï¿½ï¿½aL\'ï¿½D','ProductionBuilding','Horse Field','','horsefield'),(NULL,0.125,'2025-03-31 15:54:52.134075',NULL,NULL,_binary '3ï¿½*ï¿½ï¿½|Mï¿½',_binary 'ï¿½5ï¿½lqHï¿½ï¿½','ProductionBuilding','Cannon Foundry','','cannonfoundry'),(NULL,0.1,'2025-03-31 15:54:51.421014',NULL,NULL,_binary '9Ueï¿½FÉ²Yï¿½\r',NULL,'ProductionBuilding','Knight Barracks','','knightbarracks'),(NULL,0.125,'2025-03-31 15:54:52.078424',NULL,NULL,_binary '9ï¿½Ò£*@mï¿½3.\ï',_binary 'ï¿½ï¿½ÜŸï¿½IG\ï¿','ProductionBuilding','BookBinder','','bookbinder'),(NULL,0.125,'2025-03-31 15:54:50.768561',NULL,NULL,_binary '9ï¿½ï¿½`ï¿½]Lï¿½',_binary '\'ï¿½ç©¨zG^ï¿½\'T\ï','ProductionBuilding','Copper Armory','','copperarmory'),(NULL,0.5,'2025-03-31 15:54:51.678248',NULL,NULL,_binary '<:ï¿½ï¿½ï¿½\\Fï¿½',_binary 'Qï¿½ï¿½ï¿½ï¿½ï¿½','ProductionBuilding','Silk Twine Mill','','silktwinemill'),(NULL,0.5,'2025-03-31 15:54:50.622356',NULL,NULL,_binary '>Ë™6È–@Ü§g{Qaï¿½',_binary 'ROï¿½ï¿½Eï¿½\ï','ProductionBuilding','Linen Weaver','','linenweaver'),(NULL,0.25,'2025-03-31 15:54:50.912738',NULL,NULL,_binary 'B}+Äï¿½Bï¿½ï¿½t',_binary 'ï¿½ï¿½H;ï¿½Jï¿½','ProductionBuilding','Bakery','','bakery'),(NULL,0.25,'2025-03-31 15:54:51.447037',NULL,NULL,_binary 'FKï¿½>ï¿½fC7ï¿½1',_binary '\0Wz\n\nï¿½BUï¿½ï¿½','ProductionBuilding','Cattle Ranch','','cattleranch'),(NULL,0.01667,'2025-03-31 15:54:50.852336',NULL,NULL,_binary 'Jï¿½ï¿½Tï¿½YKß¹5',_binary 'vï¿½ï¿½2Uï¿½Og\ï¿','ProductionBuilding','Wheat Field','','wheatfield'),(NULL,0.33333,'2025-03-31 15:54:51.307583',NULL,NULL,_binary 'MR$ï¿½HØ€ï¿½\ï¿',_binary 'ï¿½bï¿½ï¿½ï¿½M\ï','ProductionBuilding','Linseed Pil Press','','linseedpilpress'),(NULL,0.5,'2025-03-31 15:54:51.253178',NULL,NULL,_binary 'Mvï¿½ï¿½ï¿½Iï¿½',_binary 'ï¿½Mï¿½ï¿½ï¿½ï¿½','ProductionBuilding','Malthouse','','malthouse'),(NULL,1.5,'2025-03-31 15:54:51.923789',NULL,NULL,_binary 'Nï¿½ï¿½\0ï¿½eDï¿½',_binary 'aï¿½ï¿½ï¿½Aï¿½A\ï','ProductionBuilding','Lobsterer','','lobsterer'),(NULL,0.25,'2025-03-31 15:54:51.463332',NULL,NULL,_binary 'Xï¿½ï¿½ï¿½@Öº\ï',_binary 'ï¿½ï¿½4ï¿½ï¿½7H;','ProductionBuilding','Rock Salt Mine','','rocksaltmine'),(NULL,0.25,'2025-03-31 15:54:51.555887',NULL,NULL,_binary '[Iï¿½]ï¿½Cï¿½ï¿½',_binary ')ï¿½ï¿½ï¿½jYLW\ï¿','ProductionBuilding','Crossbow Maker','','crossbowmaker'),(NULL,0.5,'2025-03-31 15:54:50.677168',NULL,NULL,_binary '[mpï¿½:OCxï¿½\ï¿',_binary 'ï¿½ï¿½ï¿½p9G!\ï¿','ProductionBuilding','Ropery','','ropery'),(NULL,0.01667,'2025-03-31 15:54:51.960664',NULL,NULL,_binary '_]ï¿½vG	Cï¿½ï¿½',_binary 'ï¿½ï¿½ï¿½r`HW\ï¿','ProductionBuilding','Vineyard','','vineyard'),(NULL,0.5,'2025-03-31 15:54:51.660623',NULL,NULL,_binary 'eï¿½\'+ï¿½%DUï¿½\ï',_binary 'ï¿½ï¿½^1ï¿½Nu\ï¿','ProductionBuilding','Silk Plantation','','silkplantation'),(NULL,0.1,'2025-03-31 15:54:51.891489',NULL,NULL,_binary 'iï¿½|ï¿½ï¿½ï¿½E\ï',NULL,'ProductionBuilding','Cuirassier Academy','','cuirassieracademy'),(NULL,1,'2025-03-31 15:54:51.488672',NULL,NULL,_binary 'kï¿½ì¶¸ï¿½Kï¿½\ï¿',_binary 'f>ï¿½SBhï¿½mO\ï¿','ProductionBuilding','Butchers Shop','','butchersshop'),(NULL,0.01667,'2025-03-31 15:54:51.434352',NULL,NULL,_binary 'l`Nï¿½ï¿½QMpï¿½\ï',NULL,'ProductionBuilding','Cattle Field','','cattlefield'),(NULL,5,'2025-03-31 15:54:50.508921',NULL,NULL,_binary 'mß‰ï¿½2ï¿½JIï¿½\ï',_binary 'ï¿½hï¿½3Fï¿½\ï¿','ProductionBuilding','Sawmill','','sawmill'),(NULL,0.25,'2025-03-31 15:54:51.581318',NULL,NULL,_binary 'nï¿½ï¿½GlGkï¿½\ï',_binary '.(6Gï¿½rEï¿½g\ï','ProductionBuilding','Marble Quarry','','marblequarry'),(NULL,1.5,'2025-03-31 15:54:51.945850',NULL,NULL,_binary 'uï¿½ï¿½ï¿½aJ\ï¿',_binary 'ï¿½#ï¿½Lï¿½=','ProductionBuilding','Noble Kitchen','','noblekitchen'),(NULL,0.125,'2025-03-31 15:54:51.405569',NULL,NULL,_binary '|ï¿½	ï¿½0NKï¿½l',_binary '/Zyï¿½\n`Nï¿½ï¿½\ï','ProductionBuilding','Iron Armory','','ironarmory'),(NULL,0.5,'2025-03-31 15:54:51.065574',NULL,NULL,_binary 'Ì‰ï¿½ï¿½ï¿½ï¿½D0',_binary 'ï¿½ï¿½Â£ï¿½ï¿½O\ï','ProductionBuilding','Cigar Manufacturer','','cigarmanufacturer'),(NULL,0.25,'2025-03-31 15:54:52.198698',NULL,NULL,_binary 'Ğ¬ï¿½7Gï¿½ï¿½\ï',_binary 'Óµ3ï¿½ï¿½Dï¿½\ï¿','ProductionBuilding','Gunsmith','','gunsmith'),(NULL,0.5,'2025-03-31 15:54:51.044272',NULL,NULL,_binary 'Ô¡ï¿½P×ŒOJï¿½ï¿½',_binary 'ï¿½ï¿½5:+ï¿½DÈª\ï','ProductionBuilding','Tobacco Farm','','tobaccofarm'),(NULL,0.1,'2025-03-31 15:54:50.790385',NULL,NULL,_binary 'Õ•b!ï¿½A!ï¿½ï¿½',NULL,'ProductionBuilding','Barracks','','barracks'),(NULL,0.25,'2025-03-31 15:54:51.761897',NULL,NULL,_binary 'Ø±\'ï¿½ï¿½ï¿½@)\ï¿',_binary '86ï¿½9[F~ï¿½ï¿½','ProductionBuilding','Goblet Manufacturer','','gobletmanufacturer'),(NULL,0.01667,'2025-03-31 15:54:50.478970',NULL,NULL,_binary 'Ù\Z\\KJKï¿½ï¿½ï¿½',NULL,'ProductionBuilding','Well','','well'),(NULL,0.1,'2025-03-31 15:54:51.171710',NULL,NULL,_binary 'Û‰ï¿½?0Kï¿½ï¿½Y',NULL,'ProductionBuilding','Longbow Archer Range','','longbowarcherrange'),(NULL,0.25,'2025-03-31 15:54:52.098758',NULL,NULL,_binary 'ß˜ï¿½ï¿½ï¿½	N~\ï¿',NULL,'ProductionBuilding','Nitrate Maker','','nitratemaker'),(NULL,0.25,'2025-03-31 15:54:51.728996',NULL,NULL,_binary 'ï¿½	rï¿½Izï¿½\ï',_binary 'Nï¿½0ï¿½ï¿½L-ï¿½','ProductionBuilding','Noble Tailor','','nobletailor'),(NULL,0.01667,'2025-03-31 15:54:51.594775',NULL,NULL,_binary 'ï¿½ï¿½ï¿½Fï¿½',NULL,'ProductionBuilding','School','','school'),(NULL,0.25,'2025-03-31 15:54:50.718880',NULL,NULL,_binary 'ï¿½ï¿½Q_Knï¿½',_binary 'v#Ziï¿½C@?ï¿½?\ï','ProductionBuilding','Copper Mine','','coppermine'),(NULL,0.5,'2025-03-31 15:54:50.868750',NULL,NULL,_binary 'ï¿½\Zï¿½Cï¿½ï¿½L\"',_binary 'ï¿½ï¿½Yï¿½Lï¿½','ProductionBuilding','Wheat Farm','','wheatfarm'),(NULL,0.25,'2025-03-31 15:54:51.874699',NULL,NULL,_binary 'ï¿½\Zï¿½tï¿½ï¿½J\ï',_binary 'hï¿½ï¿½ï¿½NØ»\ï','ProductionBuilding','Armorsmith','','armorsmith'),(NULL,0.75,'2025-03-31 15:54:50.492866',NULL,NULL,_binary 'ï¿½%ï¿½ï¿½ï¿½fDS',_binary 'ï¿½zÒ«)bE ï¿½ï¿½','ProductionBuilding','Fishermans Hut','','fishermanshut'),(NULL,0.5,'2025-03-31 15:54:51.281416',NULL,NULL,_binary 'ï¿½+ï¿½Uï¿½FH#\ï¿',_binary 'wï¿½ï¿½ï¿½B\ï¿','ProductionBuilding','Brewery','','brewery'),(NULL,0.5,'2025-03-31 15:54:51.806911',NULL,NULL,_binary 'ï¿½2(Ó–ï¿½Aï¿½\ï¿',_binary 'ï¿½ï¿½b~d6J6ï¿½d','ProductionBuilding','Chandler','','chandler'),(NULL,0.25,'2025-03-31 15:54:51.125465',NULL,NULL,_binary 'ï¿½4ï¿½ï¿½Ô¹@P\ï¿',_binary 'ï¿½ï¿½<ï¿½ï¿½iDu','ProductionBuilding','Brickyard','','brickyard'),(NULL,0.5,'2025-03-31 15:54:51.102852',NULL,NULL,_binary 'ï¿½:?ï¿½ï¿½ï¿½K\'',_binary '*ï¿½8eï¿½ï¿½H\\\ï¿','ProductionBuilding','Clay Pit','','claypit'),(NULL,0.01667,'2025-03-31 15:54:50.587844',NULL,NULL,_binary 'ï¿½;jï¿½ï¿½ï¿½A	',_binary '@ï¿½ï¿½ï¿½LÇœ','ProductionBuilding','Linseed Field','','linseedfield'),(NULL,0.5,'2025-03-31 15:54:50.639600',NULL,NULL,_binary 'ï¿½;ï¿½ï¿½ï¿½1L\ï',_binary 'ï¿½Yï¿½ï¿½ÂŠN\ï¿','ProductionBuilding','Bowyer','','bowyer'),(NULL,0.25,'2025-03-31 15:54:51.856662',NULL,NULL,_binary 'ï¿½Eï¿½ï¿½ï¿½qBY',_binary 'Iï¿½ï¿½R oEï¿½\ï¿','ProductionBuilding','Steel Furnace','','steelfurnace'),(NULL,0.1,'2025-03-31 15:54:50.974519',NULL,NULL,_binary 'ï¿½MZ$Ê¸BÊœï¿½\ï¿',NULL,'ProductionBuilding','Riding Arena','','ridingarena'),(NULL,0.01667,'2025-03-31 15:54:52.225587',NULL,NULL,_binary 'ï¿½Nï¿½	ï¿½B\'\ï¿',NULL,'ProductionBuilding','University','','university'),(NULL,0.1,'2025-03-31 15:54:51.568233',NULL,NULL,_binary 'ï¿½Sï¿½OiOï¿½ï¿½',NULL,'ProductionBuilding','Crossbow Shooting Range','','crossbowshootingrange'),(NULL,0.01667,'2025-03-31 15:54:50.565136',NULL,NULL,_binary 'ï¿½]xï¿½ï¿½ï¿½J3',NULL,'ProductionBuilding','Tavern','','tavern'),(NULL,0.5,'2025-03-31 15:54:51.713629',NULL,NULL,_binary 'ï¿½eï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½bï¿½ï¿½YDK\ï¿','ProductionBuilding','Indigo Plantation','','indigoplantation'),(NULL,0.125,'2025-03-31 15:54:51.363957',NULL,NULL,_binary 'ï¿½jï¿½ï¿½ï¿½GB',_binary 'ï¿½ï¿½\nï¿½ï¿½6B*','ProductionBuilding','Iron Smelter','','ironsmelter'),(NULL,0.5,'2025-03-31 15:54:50.606033',NULL,NULL,_binary 'ï¿½kfï¿½Iï¿½Gï¿½',_binary '0ï¿½Ò‰*ï¿½Jï¿½\ï¿','ProductionBuilding','Linseed Farm','','linseedfarm'),(NULL,0.01667,'2025-03-31 15:54:51.217856',NULL,NULL,_binary 'ï¿½opË˜ï¿½L4ï¿½\ï',_binary 'ï¿½ï¿½uï¿½\'8C\ï¿','ProductionBuilding','Hop Field','','hopfield'),(NULL,5,'2025-03-31 15:54:50.463304',NULL,NULL,_binary 'ï¿½syä‡¬Kß²gfÇº\Z',_binary 'ï¿½ï¿½Kï¿½\ZK9\ï¿','ProductionBuilding','Lumberjack','','lumberjack'),(NULL,0.5,'2025-03-31 15:54:52.171724',NULL,NULL,_binary 'ï¿½y3kcLÑ¾ï¿½\ï¿',_binary '?ï¿½ï¿½G@Ì‡Kv\ï','ProductionBuilding','Planing Mill','','planingmill'),(NULL,0.01667,'2025-03-31 15:54:51.011245',NULL,NULL,_binary 'ï¿½y;ï¿½ï¿½QO	\ï¿',_binary '{ï¿½{ï¿½ï¿½ï¿½G','ProductionBuilding','Tobacco Field','','tobaccofield'),(NULL,0.125,'2025-03-31 15:54:51.540243',NULL,NULL,_binary 'ï¿½zcï¿½ï¿½]C8\ï¿',NULL,'ProductionBuilding','Goldsmith','','goldsmith'),(NULL,0.5,'2025-03-31 15:54:50.830937',NULL,NULL,_binary 'ï¿½zï¿½Å‰ï¿½Dï¿½',_binary 'ï¿½,ï¿½-J.EÌŠï¿½','ProductionBuilding','Sheep Farm','','sheepfarm'),(NULL,0.25,'2025-03-31 15:54:51.790737',NULL,NULL,_binary 'ï¿½zï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½Æ”ï¿½ï¿½G\ï¿','ProductionBuilding','Apiary','','apiary'),(NULL,0.25,'2025-03-31 15:54:52.114053',NULL,NULL,_binary 'ï¿½{ŞŠD[ï¿½`_3',_binary 'ï¿½\\ï¿½T@ï¿½\ï¿','ProductionBuilding','Powder Mill','','powdermill'),(NULL,0.01667,'2025-03-31 15:54:51.777186',NULL,NULL,_binary 'ï¿½Ò”ï¿½?ï¿½Dï¿½',NULL,'ProductionBuilding','Beehive','','beehive'),(NULL,0.1,'2025-03-31 15:54:50.660282',NULL,NULL,_binary 'ï¿½ï¿½lï¿½vFß¾\0',_binary 'ï¿½SIJï¿½Oï¿½ï¿½','ProductionBuilding','Archery Range','','archeryrange'),(NULL,0.25,'2025-03-31 15:54:51.505817',NULL,NULL,_binary 'ï¿½ï¿½ï¿½lIï¿½',_binary 'ï¿½2ï¿½\nï¿½ï¿½FE','ProductionBuilding','Gold Mine','','goldmine'),(NULL,0.5,'2025-03-31 15:54:51.152149',NULL,NULL,_binary 'ï¿½ï¿½tï¿½4JÓ\ï',_binary 'ï¿½ï¿½ÄºCï¿½ï¿½','ProductionBuilding','Longbowyer','','longbowyer'),(NULL,0.5,'2025-03-31 15:54:51.908479',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½kÍ†\\ï¿½@ï¿½\ï','ProductionBuilding','Distillery','','distillery'),(NULL,0.33333,'2025-03-31 15:54:51.744735',NULL,NULL,_binary 'ï¿½ï¿½Â—DJï¿½\ï',NULL,'ProductionBuilding','Gemstone Mine','','gemstonemine'),(NULL,0.01667,'2025-03-31 15:54:51.697840',NULL,NULL,_binary 'ï¿½ï¿½\'ï¿½ï¿½M\ï¿',_binary 'ï¿½omï¿½?ï¿½Nï¿½','ProductionBuilding','Indigo Field','','indigofield'),(10,NULL,'2025-03-31 15:54:50.444954',NULL,NULL,_binary 'ï¿½ï¿½Oï¿½NgJ#\ï¿',NULL,'PopulationBuilding','Pioneer\'s Hut','','pioneershut'),(NULL,0.01667,'2025-03-31 15:54:50.955290',NULL,NULL,_binary 'ï¿½ï¿½PXrAï¿½\ï',_binary '@ï¿½]aï¿½Lï¿½;\ï','ProductionBuilding','Horse Breeder','','horsebreeder'),(NULL,0.125,'2025-03-31 15:54:50.740717',NULL,NULL,_binary 'ï¿½ï¿½[%ï¿½NL\ï¿',_binary 'ï¿½Kï¿½Aï¿½\ï¿','ProductionBuilding','Copper Smelter','','coppersmelter'),(NULL,0.01667,'2025-03-31 15:54:50.813082',NULL,NULL,_binary 'ï¿½ï¿½koï¿½Nq\ï¿',_binary 'ï¿½ï¿½ï¿½Dï¿½ï¿½','ProductionBuilding','Sheep Field','','sheepfield'),(NULL,0.25,'2025-03-31 15:54:51.382007',NULL,NULL,_binary 'ï¿½ï¿½n#ï¿½Oï¿½',_binary 'ï¿½ï¿½\",ï¿½ï¿½A\ï','ProductionBuilding','Toolmaker','','toolmaker'),(NULL,0.25,'2025-03-31 15:54:51.840810',NULL,NULL,_binary 'ï¿½ï¿½vï¿½,ï¿½H\ï',_binary 'cLï¿½ï¿½ï¿½Mï¿½','ProductionBuilding','Cokery','','cokery'),(NULL,0.1,'2025-03-31 15:54:52.153258',NULL,NULL,_binary 'ï¿½ï¿½w 3ï¿½Hï¿½',NULL,'ProductionBuilding','Cannoneers School','','cannoneersschool'),(NULL,0.5,'2025-03-31 15:54:52.041086',NULL,NULL,_binary 'ï¿½ï¿½ï¿½>ï¿½M',NULL,'ProductionBuilding','Paper Mill','','papermill'),(NULL,0.01667,'2025-03-31 15:54:51.326776',NULL,NULL,_binary 'ï¿½ï¿½ï¿½Eï¿½?A',NULL,'ProductionBuilding','Medicus','','medicus'),(NULL,0.01667,'2025-03-31 15:54:51.628028',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½Q~L\ï',NULL,'ProductionBuilding','Bathhouse providing water','','bathhouseprovidingwater'),(NULL,0.01667,'2025-03-31 15:54:50.532500',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½ï¿½ ï¿½vï¿½A\ï','ProductionBuilding','Potato Field','','potatofield');
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
INSERT INTO `cost_building_goods` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `good_id`, `id`) VALUES (20,'2025-03-31 15:54:52.451391',NULL,NULL,_binary 'mß‰ï¿½2ï¿½JIï¿½\ï',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',_binary ' ï¿½ï¿½ï¿½ï¿½G~'),(10,'2025-03-31 15:54:52.393446',NULL,NULL,_binary 'Ù\Z\\KJKï¿½ï¿½ï¿½',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',_binary ';jï¿½ï¿½ï¿½El\ï¿'),(10,'2025-03-31 15:54:52.471196',NULL,NULL,_binary 'k@)Sï¿½AÎ•ï¿½\ï¿',_binary 'tï¿½ï¿½[UFOï¿½\ï¿',_binary 'Uï¿½ï¿½ï¿½ï¿½dC}'),(5,'2025-03-31 15:54:52.338673',NULL,NULL,_binary 'ï¿½syä‡¬Kß²gfÇº\Z',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',_binary '[ï¿½ï¿½ï¿½ï¿½ï¿½'),(10,'2025-03-31 15:54:52.372305',NULL,NULL,_binary 'ï¿½ï¿½Oï¿½NgJ#\ï¿',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',_binary 'ï¿½hï¿½)@Yï¿½'),(10,'2025-03-31 15:54:52.424633',NULL,NULL,_binary 'ï¿½%ï¿½ï¿½ï¿½fDS',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',_binary 'ï¿½ï¿½-ï¿½yï¿½A\ï');
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
INSERT INTO `good` (`is_map_resource`, `created_at`, `deleted_at`, `updated_at`, `id`, `name`, `remarks`, `slug`) VALUES (0,'2025-03-31 15:54:47.648991',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½','Clay','','clay'),(0,'2025-03-31 15:54:47.830346',NULL,NULL,_binary 'ï¿½)ï¿½Adï¿½ï¿½','Marble','Build material','marble'),(0,'2025-03-31 15:54:47.891276',NULL,NULL,_binary 'ï¿½ï¿½ï¿½	B@E\ï¿','Gemstone','','gemstone'),(0,'2025-03-31 15:54:48.063904',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½LP','Cannon','','cannon'),(0,'2025-03-31 15:54:47.596950',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ZEï¿½','Bread','','bread'),(0,'2025-03-31 15:54:47.758436',NULL,NULL,_binary 'ï¿½ï¿½Mï¿½\ï¿','Gold Ingot','','goldingot'),(0,'2025-03-31 15:54:47.725710',NULL,NULL,_binary 'yDï¿½ï¿½ï¿½@K\ï¿','Meat','','meat'),(0,'2025-03-31 15:54:47.641003',NULL,NULL,_binary 'Ä¤ï¿½gCï¿½ï¿½\ï¿','Longbow','','longbow'),(0,'2025-03-31 15:54:47.605745',NULL,NULL,_binary 'Êœï¿½V\"@ï¿½ï¿½]','Tobacco','','tobacco'),(0,'2025-03-31 15:54:48.090899',NULL,NULL,_binary 'ï¿½\0	ï¿½Aï¿½\ï¿','Vineyard','','vineyard'),(0,'2025-03-31 15:54:47.965667',NULL,NULL,_binary 'Jï¿½Yï¿½MMï¿½','Barrel','','barrel'),(0,'2025-03-31 15:54:47.796319',NULL,NULL,_binary '#ï¿½&ï¿½jxK@ï¿½\ï','Iron Sword','','ironsword'),(0,'2025-03-31 15:54:48.072903',NULL,NULL,_binary '$ï¿½%ï¿½RLï¿½ï¿½','Metal Cuttings','','metalcuttings'),(1,'2025-03-31 15:54:47.352906',NULL,NULL,_binary '\'ï¿½#ï¿½E6ï¿½r','Indigo Field','','indigofield'),(0,'2025-03-31 15:54:47.524704',NULL,NULL,_binary '\'ï¿½ï¿½Wï¿½PL,\ï¿','Ropes','','ropes'),(0,'2025-03-31 15:54:47.439986',NULL,NULL,_binary '+1bï¿½Mï¿½ï¿½\ï','Favor','Global, needed for more island slots','favor'),(1,'2025-03-31 15:54:47.343648',NULL,NULL,_binary '+cï¿½ï¿½ï¿½qH[\ï¿','Horse Field','','horsefield'),(0,'2025-03-31 15:54:47.553622',NULL,NULL,_binary '1ï¿½{ï¿½ï¿½Gï¿½','Copper Sword','','coppersword'),(0,'2025-03-31 15:54:47.813353',NULL,NULL,_binary '2ï¿½yÔ­ï¿½Lİï¿½','Tools','Build material','tools'),(0,'2025-03-31 15:54:47.897934',NULL,NULL,_binary ';ï¿½:ï¿½ï¿½Dï¿½','Goblet','','goblet'),(0,'2025-03-31 15:54:47.987367',NULL,NULL,_binary '<ï¿½ï¿½ï¿½ï¿½Gu','Windjammer','','windjammer'),(1,'2025-03-31 15:54:47.313810',NULL,NULL,_binary '@ï¿½ï¿½tï¿½Nï¿½','Water tile','','watertile'),(0,'2025-03-31 15:54:47.742101',NULL,NULL,_binary 'Aï¿½pJ!ï¿½;\ï','Gold Ore','','goldore'),(0,'2025-03-31 15:54:47.515565',NULL,NULL,_binary 'A`ï¿½ï¿½Ş•Iï¿½\ï¿','Archer','','archer'),(0,'2025-03-31 15:54:47.921581',NULL,NULL,_binary 'Dï¿½Ñ¦%,Goï¿½ï¿½','Candle Holder','','candleholder'),(0,'2025-03-31 15:54:47.542601',NULL,NULL,_binary 'Eï¿½ï¿½ï‡ŸFrï¿½\ï','Copper Ingot','','copperingot'),(0,'2025-03-31 15:54:47.718073',NULL,NULL,_binary 'Fï¿½,|iCï¿½ï¿½','Salt','','salt'),(0,'2025-03-31 15:54:47.764695',NULL,NULL,_binary 'J)ï¿½wï¿½Bï¿½\ï¿','Gold Jewelry','','goldjewelry'),(0,'2025-03-31 15:54:47.772866',NULL,NULL,_binary 'L~9ï¿½}C*ï¿½Z\ï¿','Linseed Oil','','linseedoil'),(0,'2025-03-31 15:54:47.878705',NULL,NULL,_binary 'Mï¿½ï¿½ï¿½ï¿½ï¿½','Garment','','garment'),(0,'2025-03-31 15:54:47.489265',NULL,NULL,_binary 'NkP5ï¿½Fï¿½ï¿½','Linseed','','linseed'),(0,'2025-03-31 15:54:47.657359',NULL,NULL,_binary 'Pï¿½ï¿½Z#Agï¿½\ï','Brick','Build material','brick'),(0,'2025-03-31 15:54:47.588152',NULL,NULL,_binary 'Rï¿½!q^|OØRï¿½\ï','Flour','','flour'),(0,'2025-03-31 15:54:48.054792',NULL,NULL,_binary 'SwDï¿½ï¿½ï¿½B[\ï¿','Gunpowder','','gunpowder'),(0,'2025-03-31 15:54:47.473669',NULL,NULL,_binary 'T	ï¿½|:\nETï¿½ï¿½','Schnapps','','schnapps'),(0,'2025-03-31 15:54:47.929836',NULL,NULL,_binary 'W\n,ï¿½ï¿½ï¿½Ly\ï¿','Liqueur','','liqueur'),(0,'2025-03-31 15:54:47.804665',NULL,NULL,_binary '\\sW5DHï¿½lÄ¦\ï¿','Militia','','militia'),(0,'2025-03-31 15:54:47.666409',NULL,NULL,_binary ']ï¿½C.$Aï¿½ï¿½Q','Clothes','','clothes'),(0,'2025-03-31 15:54:47.863823',NULL,NULL,_binary '`|%ï¿½ï¿½ï¿½Mï¿½','Dye','','dye'),(0,'2025-03-31 15:54:47.676072',NULL,NULL,_binary 'aQï¿½Í§AGï¿½ï¿½','Malt','','malt'),(0,'2025-03-31 15:54:47.422326',NULL,NULL,_binary 'cKï¿½uG@zï¿½ï¿½','Coin','Global','coin'),(0,'2025-03-31 15:54:48.030587',NULL,NULL,_binary 'dWMï¿½ï¿½LHï¿½\ï¿','Armored Horse','','armoredhorse'),(0,'2025-03-31 15:54:47.780291',NULL,NULL,_binary 'dï¿½ï¿½ï¿½Hï¿½G\ï','Iron Ore','','ironore'),(0,'2025-03-31 15:54:48.019353',NULL,NULL,_binary 'iï¿½ï¿½SzGï¿½','Steel Ingot','','steelingot'),(1,'2025-03-31 15:54:47.403956',NULL,NULL,_binary 'lï¿½ï¿½>ï¿½ï¿½F\ï','Tobacco Field','','tobaccofield'),(1,'2025-03-31 15:54:47.413331',NULL,NULL,_binary 'mï¿½ï¿½fï¿½H\\\ï¿','Wheat Field','','wheatfield'),(0,'2025-03-31 15:54:47.954565',NULL,NULL,_binary 'thï¿½ï¿½ï¿½KÃ¤ ','Grapes','','grapes'),(0,'2025-03-31 15:54:47.466225',NULL,NULL,_binary 'tï¿½ï¿½[UFOï¿½\ï¿','Plank','Build material','plank'),(1,'2025-03-31 15:54:47.368883',NULL,NULL,_binary 'uLï¿½}ï¿½{KÇ¾ï¿½','Potato Field','','potatofield'),(0,'2025-03-31 15:54:47.937336',NULL,NULL,_binary 'xï¿½ï¿½ï¿½E:Fy\ï¿','Lobster','','lobster'),(0,'2025-03-31 15:54:47.631666',NULL,NULL,_binary 'ygï¿½ï¿½KÖ€]\ï¿','Horse','','horse'),(1,'2025-03-31 15:54:47.323887',NULL,NULL,_binary 'İ§ï¿½F|ï¿½Nmï¿½','Mountain tile','','mountaintile'),(1,'2025-03-31 15:54:47.333675',NULL,NULL,_binary 'Ş¥\0ï¿½ï¿½\ZNËºï¿½','Hop Field','','hopfield'),(0,'2025-03-31 15:54:48.002545',NULL,NULL,_binary 'ï¿½X2O\\ï¿½ï¿½','Coke','','coke'),(0,'2025-03-31 15:54:47.702332',NULL,NULL,_binary 'ï¿½\r6ï¿½fISï¿½h','Cattle','','cattle'),(0,'2025-03-31 15:54:47.995284',NULL,NULL,_binary 'ï¿½	ï¿½ï¿½	Mt\ï¿','Book','','book'),(0,'2025-03-31 15:54:47.974715',NULL,NULL,_binary 'ï¿½sï¿½ï¿½ICÑ‰\ï','Wine','','wine'),(1,'2025-03-31 15:54:47.395876',NULL,NULL,_binary 'ï¿½gï¿½Yï¿½DÅ.','Mulberry Trees','','mulberrytrees'),(0,'2025-03-31 15:54:47.430892',NULL,NULL,_binary 'ï¿½\'pï¿½ï¿½7Aï¿½','Cartography','Global, used for Discovery','cartography'),(1,'2025-03-31 15:54:47.299513',NULL,NULL,_binary 'ï¿½)yï¿½%Iï¿½\ï¿','Land tile','','landtile'),(0,'2025-03-31 15:54:47.822323',NULL,NULL,_binary 'ï¿½)ï¿½ï¿½?Hï¿½','Crossbow','','crossbow'),(0,'2025-03-31 15:54:47.945861',NULL,NULL,_binary 'ï¿½.+^AzBÎ»=eï¿½','Feast','','feast'),(0,'2025-03-31 15:54:47.457685',NULL,NULL,_binary 'ï¿½@ï¿½(ï¿½Oï¿½','Fish','','fish'),(0,'2025-03-31 15:54:47.710783',NULL,NULL,_binary 'ï¿½Dï¿½&ï¿½I^\ï¿','Rock Salt','','rocksalt'),(0,'2025-03-31 15:54:47.614513',NULL,NULL,_binary 'ï¿½Oyï¿½\'%EOï¿½^','Cigar','','cigar'),(0,'2025-03-31 15:54:47.684184',NULL,NULL,_binary 'ï¿½Oï¿½ï¿½?TNi\ï¿','Hops','','hops'),(1,'2025-03-31 15:54:47.387591',NULL,NULL,_binary 'ï¿½RWTH~ï¿½ï¿½','Cotton Field','','cottonfield'),(0,'2025-03-31 15:54:47.734173',NULL,NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿','Coal','','coal'),(0,'2025-03-31 15:54:47.787443',NULL,NULL,_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿','Iron Ingot','','ironingot'),(1,'2025-03-31 15:54:47.376191',NULL,NULL,_binary 'ï¿½Zï¿½\ZnGÚ‘ï¿½','Sheep Field','','sheepfield'),(0,'2025-03-31 15:54:47.481337',NULL,NULL,_binary 'ï¿½aï¿½ï¿½ï¿½@H','Stone','Build material','stone'),(0,'2025-03-31 15:54:47.571129',NULL,NULL,_binary 'ï¿½cP>jï¿½Jcï¿½V','Fabric','','fabric'),(0,'2025-03-31 15:54:47.838115',NULL,NULL,_binary 'ï¿½e1:ï¿½ï¿½K\ï¿','Silk','','silk'),(0,'2025-03-31 15:54:48.082679',NULL,NULL,_binary 'ï¿½u?ï¿½cCï¿½\ï','Fireworks','','fireworks'),(0,'2025-03-31 15:54:47.624190',NULL,NULL,_binary 'ï¿½É¢ï¿½ï¿½ï¿½H9','Sail','','sail'),(0,'2025-03-31 15:54:47.751525',NULL,NULL,_binary 'ï¿½ï¿½Aï¿½[Fï¿½','Gold','','gold'),(1,'2025-03-31 15:54:47.361209',NULL,NULL,_binary 'ï¿½ï¿½ï¿½nï¿½L}','Linseed Field','','linseedfield'),(0,'2025-03-31 15:54:47.850513',NULL,NULL,_binary 'ï¿½ï¿½Dï¿½OÏ½D','Silk Cloth','','silkcloth'),(0,'2025-03-31 15:54:47.449174',NULL,NULL,_binary 'ï¿½ï¿½]ï¿½n|Jï¿½','Wood','Build material','wood'),(0,'2025-03-31 15:54:47.497311',NULL,NULL,_binary 'ï¿½ï¿½mï¿½!Nï¿½','Linen','','linen'),(0,'2025-03-31 15:54:47.692855',NULL,NULL,_binary 'ï¿½ï¿½oVL4ï¿½\ï','Beer','','beer'),(0,'2025-03-31 15:54:47.533274',NULL,NULL,_binary 'ï¿½ï¿½yÑï¿½D\ï¿','Copper Ore','','copperore'),(0,'2025-03-31 15:54:47.579304',NULL,NULL,_binary 'ï¿½ï¿½ï¿½DÜˆOï¿½','Wheat','','wheat'),(0,'2025-03-31 15:54:48.041818',NULL,NULL,_binary 'ï¿½ï¿½ï¿½_ï¿½ï¿½','Saltpeter','','saltpeter'),(0,'2025-03-31 15:54:47.906275',NULL,NULL,_binary 'ï¿½ï¿½ï¿½bï¿½Hİ•','Honey','','honey'),(0,'2025-03-31 15:54:47.913650',NULL,NULL,_binary 'ï¿½ï¿½ï¿½t,I\Zï¿½','Candle','','candle'),(0,'2025-03-31 15:54:47.506028',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½6)G\ï','Bow','','bow'),(0,'2025-03-31 15:54:47.562809',NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½\Z','Yarn','','yarn');
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
INSERT INTO `population` (`created_at`, `deleted_at`, `updated_at`, `id`, `name`, `slug`) VALUES ('2025-03-31 15:54:52.247264',NULL,NULL,_binary '5ï¿½ï¿½ï¿½ï¿½C\ï','Colonists','colonists'),('2025-03-31 15:54:52.281515',NULL,NULL,_binary 'fï¿½ï¿½ï¿½ï¿½nB\ï','Paragons','paragons'),('2025-03-31 15:54:52.255901',NULL,NULL,_binary 'ï¿½*ï¿½+|<Hï¿½\ï¿','Townsmen','townsmen'),('2025-03-31 15:54:52.236833',NULL,NULL,_binary 'ï¿½ï¿½Ã“\nKG\\ï¿½t','Pioneers','pioneers'),('2025-03-31 15:54:52.265112',NULL,NULL,_binary 'ï¿½ï¿½ï¿½b*E}\ï¿','Merchants','merchants');
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
INSERT INTO `population_requirement` (`consumption`, `is_basic`, `produce`, `created_at`, `deleted_at`, `updated_at`, `good_id`, `id`, `population_id`) VALUES (0,_binary '',0,'2025-03-31 15:54:52.297077',NULL,NULL,_binary '@ï¿½ï¿½tï¿½Nï¿½',_binary 'ï¿½-|gQï¿½I^ï¿½(',_binary 'ï¿½ï¿½Ã“\nKG\\ï¿½t');
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
INSERT INTO `recipe` (`quantity_of_input_1`, `quantity_of_input_10`, `quantity_of_input_2`, `quantity_of_input_3`, `quantity_of_input_4`, `quantity_of_input_5`, `quantity_of_input_6`, `quantity_of_input_7`, `quantity_of_input_8`, `quantity_of_input_9`, `created_at`, `deleted_at`, `updated_at`, `id`, `input_1`, `input_10`, `input_2`, `input_3`, `input_4`, `input_5`, `input_6`, `input_7`, `input_8`, `input_9`, `output`, `production_building`, `name`, `slug`) VALUES (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.445547',NULL,NULL,_binary '\0Wz\n\nï¿½BUï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½\r6ï¿½fISï¿½h',NULL,'Cattle','cattle'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.377896',NULL,NULL,_binary 'ROï¿½ï¿½Eï¿½\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½mï¿½!Nï¿½',NULL,'Linen','linen'),(1,0,2,2,0,0,0,0,0,0,'2025-03-31 15:54:50.401633',NULL,NULL,_binary 'Óµ3ï¿½ï¿½Dï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'SwDï¿½ï¿½ï¿½B[\ï¿',_binary '$ï¿½%ï¿½RLï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½u?ï¿½cCï¿½\ï',NULL,'Fireworks','fireworks'),(1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.555692',NULL,NULL,_binary 'ï¿½Kï¿½Aï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½yÑï¿½D\ï¿',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Eï¿½ï¿½ï‡ŸFrï¿½\ï',NULL,'Copper Ingot','copperingot'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.236058',NULL,NULL,_binary 'ï¿½hï¿½3Fï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'tï¿½ï¿½[UFOï¿½\ï¿',NULL,'Plank','plank'),(1,0,2,10,0,0,0,0,0,0,'2025-03-31 15:54:49.063272',NULL,NULL,_binary 'ï¿½ï¿½ÄºCï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Ä¤ï¿½gCï¿½ï¿½\ï¿',NULL,'Longbow','longbow'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.324807',NULL,NULL,_binary '@ï¿½ï¿½ï¿½LÇœ',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½nï¿½L}',NULL,'Linseed Field','linseedfield'),(1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.213505',NULL,NULL,_binary '\"ï¿½ ï¿½5ï¿½DÛ¥_',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'thï¿½ï¿½ï¿½KÃ¤ ',_binary 'Jï¿½Yï¿½MMï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½sï¿½ï¿½ICÑ‰\ï',NULL,'Wine','wine'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.753776',NULL,NULL,_binary '%rï¿½ï¿½`Kdï¿½\n',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½ï¿½DÜˆOï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Rï¿½!q^|OØRï¿½\ï',NULL,'Flour','flour'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.180554',NULL,NULL,_binary '&gï¿½ï¿½ï¿½bO\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '@ï¿½ï¿½tï¿½Nï¿½',NULL,'Water tile','watertile'),(1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.590720',NULL,NULL,_binary '\'ï¿½ç©¨zG^ï¿½\'T\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'Eï¿½ï¿½ï‡ŸFrï¿½\ï',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary '1ï¿½{ï¿½ï¿½Gï¿½',NULL,'Copper Sword','coppersword'),(1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:49.580503',NULL,NULL,_binary ')ï¿½ï¿½ï¿½jYLW\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½)ï¿½ï¿½?Hï¿½',NULL,'Crossbow','crossbow'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.006656',NULL,NULL,_binary '*ï¿½8eï¿½ï¿½H\\\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½',NULL,'Clay','clay'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:49.636291',NULL,NULL,_binary '.(6Gï¿½rEï¿½g\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½)ï¿½Adï¿½ï¿½',NULL,'Marble','marble'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.376128',NULL,NULL,_binary '/Zyï¿½\n`Nï¿½ï¿½\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary '#ï¿½&ï¿½jxK@ï¿½\ï',NULL,'Iron Sword','ironsword'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.353222',NULL,NULL,_binary '0ï¿½Ò‰*ï¿½Jï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½ï¿½nï¿½L}',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',NULL,'Linseed','linseed'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.557586',NULL,NULL,_binary '64ï¿½ï¿½JIï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'ï¿½ï¿½Mï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'J)ï¿½wï¿½Bï¿½\ï¿',NULL,'Gold Jewelry','goldjewelry'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.842901',NULL,NULL,_binary '86ï¿½9[F~ï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½Mï¿½\ï¿',_binary 'ï¿½ï¿½ï¿½	B@E\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary ';ï¿½:ï¿½ï¿½Dï¿½',NULL,'Goblet','goblet'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.797934',NULL,NULL,_binary '9,ï¿½ï¿½aL\'ï¿½D',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '+cï¿½ï¿½ï¿½qH[\ï¿',NULL,'Horse Field','horsefield'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:49.133891',NULL,NULL,_binary ';ï¿½$mIpï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½cP>jï¿½Jcï¿½V',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary ']ï¿½C.$Aï¿½ï¿½Q',NULL,'Clothes','clothes'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.374119',NULL,NULL,_binary '?ï¿½ï¿½G@Ì‡Kv\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',_binary 'Eï¿½ï¿½ï‡ŸFrï¿½\ï',NULL,NULL,NULL,NULL,NULL,NULL,_binary '$ï¿½%ï¿½RLï¿½ï¿½',NULL,'Metal Cuttings','metalcuttings'),(1,0,20,0,0,0,0,0,0,0,'2025-03-31 15:54:48.823886',NULL,NULL,_binary '@ï¿½]aï¿½Lï¿½;\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary '+cï¿½ï¿½ï¿½qH[\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ygï¿½ï¿½KÖ€]\ï¿',NULL,'Horse','horse'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.011217',NULL,NULL,_binary 'Iï¿½ï¿½R oEï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',_binary 'ï¿½X2O\\ï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'iï¿½ï¿½SzGï¿½',NULL,'Steel Ingot','steelingot'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.801530',NULL,NULL,_binary 'Nï¿½0ï¿½ï¿½L-ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½Dï¿½OÏ½D',_binary '`|%ï¿½ï¿½ï¿½Mï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Mï¿½ï¿½ï¿½ï¿½ï¿½',NULL,'Garment','garment'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.818531',NULL,NULL,_binary 'O^à¾§BBbï¿½;ï¿½',_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½	B@E\ï¿',NULL,'Gemstone','gemstone'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.737671',NULL,NULL,_binary 'Qï¿½ï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½e1:ï¿½ï¿½K\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½Dï¿½OÏ½D',NULL,'Silk Cloth','silkcloth'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.687504',NULL,NULL,_binary 'Yï¿½_ï¿½ï¿½Hï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½gï¿½Yï¿½DÅ.',NULL,'Mulberry Trees','mulberrytrees'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.099052',NULL,NULL,_binary 'aï¿½ï¿½ï¿½Aï¿½A\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'xï¿½ï¿½ï¿½E:Fy\ï¿',NULL,'Lobster','lobster'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.972788',NULL,NULL,_binary 'cLï¿½ï¿½ï¿½Mï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½X2O\\ï¿½ï¿½',NULL,'Coke','coke'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.492251',NULL,NULL,_binary 'f>ï¿½SBhï¿½mO\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'Fï¿½,|iCï¿½ï¿½',_binary 'ï¿½\r6ï¿½fISï¿½h',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'yDï¿½ï¿½ï¿½@K\ï¿',NULL,'Meat','meat'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.183994',NULL,NULL,_binary 'hï¿½\rï¿½ï¿½GE[\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'Ş¥\0ï¿½ï¿½\ZNËºï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½Oï¿½ï¿½?TNi\ï¿',NULL,'Hops','hops'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.036540',NULL,NULL,_binary 'hï¿½ï¿½ï¿½NØ»\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ygï¿½ï¿½KÖ€]\ï¿',_binary 'iï¿½ï¿½SzGï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'dWMï¿½ï¿½LHï¿½\ï¿',NULL,'Armored Horse','armoredhorse'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.527808',NULL,NULL,_binary 'v#Ziï¿½C@?ï¿½?\ï',_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½yÑï¿½D\ï¿',NULL,'Copper Ore','copperore'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.702780',NULL,NULL,_binary 'vï¿½ï¿½2Uï¿½Og\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'mï¿½ï¿½fï¿½H\\\ï¿',NULL,'Wheat Field','wheatfield'),(1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.238330',NULL,NULL,_binary 'wï¿½ï¿½ï¿½B\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½Oï¿½ï¿½?TNi\ï¿',_binary 'aQï¿½Í§AGï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½oVL4ï¿½\ï',NULL,'Beer','beer'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.870249',NULL,NULL,_binary '{ï¿½{ï¿½ï¿½ï¿½G',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'lï¿½ï¿½>ï¿½ï¿½F\ï',NULL,'Tobacco Field','tobaccofield'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:48.987337',NULL,NULL,_binary 'ï¿½qnï¿½4F,ï¿½\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary '\'ï¿½ï¿½Wï¿½PL,\ï¿',_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½\Z',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½É¢ï¿½ï¿½ï¿½H9',NULL,'Sail','sail'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.298830',NULL,NULL,_binary 'ï¿½\\ï¿½T@ï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'SwDï¿½ï¿½ï¿½B[\ï¿',NULL,'Gunpowder','gunpowder'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.729025',NULL,NULL,_binary 'ï¿½ï¿½Yï¿½Lï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'mï¿½ï¿½fï¿½H\\\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½DÜˆOï¿½',NULL,'Wheat','wheat'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:50.126235',NULL,NULL,_binary 'ï¿½#ï¿½Lï¿½=',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'W\n,ï¿½ï¿½ï¿½Ly\ï¿',_binary 'xï¿½ï¿½ï¿½E:Fy\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½.+^AzBÎ»=eï¿½',NULL,'Feast','feast'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.677234',NULL,NULL,_binary 'ï¿½,ï¿½-J.EÌŠï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½Zï¿½\ZnGÚ‘ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½\Z',NULL,'Yarn','yarn'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.509373',NULL,NULL,_binary 'ï¿½,ï¿½OhGï¿½ \ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½aï¿½ï¿½ï¿½@H',NULL,'Stone','stone'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.509728',NULL,NULL,_binary 'ï¿½2ï¿½\nï¿½ï¿½FE',_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Aï¿½pJ!ï¿½;\ï',NULL,'Gold Ore','goldore'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.324897',NULL,NULL,_binary 'ï¿½5ï¿½lqHï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'iï¿½ï¿½SzGï¿½',_binary 'SwDï¿½ï¿½ï¿½B[\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½LP',NULL,'Cannon','cannon'),(1,0,1,16,0,0,0,0,0,0,'2025-03-31 15:54:50.190440',NULL,NULL,_binary 'ï¿½7ï¿½Zwï¿½Fo\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',_binary 'tï¿½ï¿½[UFOï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Jï¿½Yï¿½MMï¿½',NULL,'Barrel','barrel'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.208088',NULL,NULL,_binary 'ï¿½Mï¿½ï¿½ï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½ï¿½DÜˆOï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'aQï¿½Í§AGï¿½ï¿½',NULL,'Malt','malt'),(1,0,0,1,1,0,0,0,0,0,'2025-03-31 15:54:48.457949',NULL,NULL,_binary 'ï¿½SIJï¿½Oï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½Aï¿½[Fï¿½',_binary 'ï¿½ï¿½ï¿½ï¿½6)G\ï',_binary '\\sW5DHï¿½lÄ¦\ï¿',NULL,NULL,NULL,NULL,NULL,_binary 'A`ï¿½ï¿½Ş•Iï¿½\ï¿',NULL,'Archer','archer'),(1,0,1,5,0,0,0,0,0,0,'2025-03-31 15:54:48.416319',NULL,NULL,_binary 'ï¿½Yï¿½ï¿½ÂŠN\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½ï¿½6)G\ï',NULL,'Bow','bow'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.263818',NULL,NULL,_binary 'ï¿½bï¿½ï¿½ï¿½M\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'L~9ï¿½}C*ï¿½Z\ï¿',NULL,'Linseed Oil','linseedoil'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.776204',NULL,NULL,_binary 'ï¿½bï¿½ï¿½YDK\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary '\'ï¿½#ï¿½E6ï¿½r',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '`|%ï¿½ï¿½ï¿½Mï¿½',NULL,'Dye','dye'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.284550',NULL,NULL,_binary 'ï¿½ivfDArï¿½\"Aq',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'uLï¿½}ï¿½{KÇ¾ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'T	ï¿½|:\nETï¿½ï¿½',NULL,'Schnapps','schnapps'),(1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:50.082189',NULL,NULL,_binary 'ï¿½kÍ†\\ï¿½@ï¿½\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'T	ï¿½|:\nETï¿½ï¿½',_binary 'ï¿½ï¿½ï¿½bï¿½Hİ•',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'W\n,ï¿½ï¿½ï¿½Ly\ï¿',NULL,'Liqueur','liqueur'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.755394',NULL,NULL,_binary 'ï¿½omï¿½?ï¿½Nï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\'ï¿½#ï¿½E6ï¿½r',NULL,'Indigo Field','indigofield'),(1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.207501',NULL,NULL,_binary 'ï¿½zÒ«)bE ï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary '@ï¿½ï¿½tï¿½Nï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½@ï¿½(ï¿½Oï¿½',NULL,'Fish','fish'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.532089',NULL,NULL,_binary 'ï¿½~aï¿½`JBï¿½\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'Aï¿½pJ!ï¿½;\ï',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½Mï¿½\ï¿',NULL,'Gold Ingot','goldingot'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.883946',NULL,NULL,_binary 'ï¿½Æ”ï¿½ï¿½G\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½bï¿½Hİ•',NULL,'Honey','honey'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.484096',NULL,NULL,_binary 'ï¿½ï¿½ï¿½p9G!\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\'ï¿½ï¿½Wï¿½PL,\ï¿',NULL,'Ropes','ropes'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.146086',NULL,NULL,_binary 'ï¿½ï¿½ï¿½r`HW\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½\0	ï¿½Aï¿½\ï¿',NULL,'Vineyard','vineyard'),(1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.935049',NULL,NULL,_binary 'ï¿½ï¿½	ï¿½!cNÅ®A',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½ï¿½ï¿½t,I\Zï¿½',_binary 'Eï¿½ï¿½ï‡ŸFrï¿½\ï',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Dï¿½Ñ¦%,Goï¿½ï¿½',NULL,'Candle Holder','candleholder'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.319867',NULL,NULL,_binary 'ï¿½ï¿½\nï¿½ï¿½6B*',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'dï¿½ï¿½ï¿½Hï¿½G\ï',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',NULL,'Iron Ingot','ironingot'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.713856',NULL,NULL,_binary 'ï¿½ï¿½^1ï¿½Nu\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½gï¿½Yï¿½DÅ.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½e1:ï¿½ï¿½K\ï¿',NULL,'Silk','silk'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.258262',NULL,NULL,_binary 'ï¿½ï¿½ ï¿½vï¿½A\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'uLï¿½}ï¿½{KÇ¾ï¿½',NULL,'Potato Field','potatofield'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.347948',NULL,NULL,_binary 'ï¿½ï¿½\",ï¿½ï¿½A\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'ï¿½Xï¿½ŞšsAï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,_binary '2ï¿½yÔ­ï¿½Lİï¿½',NULL,'Tools','tools'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.465852',NULL,NULL,_binary 'ï¿½ï¿½4ï¿½ï¿½7H;',_binary 'İ§ï¿½F|ï¿½Nmï¿½',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½Dï¿½&ï¿½I^\ï¿',NULL,'Rock Salt','rocksalt'),(1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.912414',NULL,NULL,_binary 'ï¿½ï¿½5:+ï¿½DÈª\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'lï¿½ï¿½>ï¿½ï¿½F\ï',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Êœï¿½V\"@ï¿½ï¿½]',NULL,'Tobacco','tobacco'),(1,0,12,0,0,0,0,0,0,0,'2025-03-31 15:54:50.167103',NULL,NULL,_binary 'ï¿½ï¿½8Xï¿½ï¿½Fg',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½\0	ï¿½Aï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'thï¿½ï¿½ï¿½KÃ¤ ',NULL,'Grapes','grapes'),(1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.034764',NULL,NULL,_binary 'ï¿½ï¿½<ï¿½ï¿½iDu',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'ï¿½VTï¿½}ï¿½MF\ï¿',_binary 'ï¿½ï¿½ï¿½ï¿½ï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Pï¿½ï¿½Z#Agï¿½\ï',NULL,'Brick','brick'),(1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.778734',NULL,NULL,_binary 'ï¿½ï¿½H;ï¿½Jï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'Rï¿½!q^|OØRï¿½\ï',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½ZEï¿½',NULL,'Bread','bread'),(7,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.149490',NULL,NULL,_binary 'ï¿½ï¿½Kï¿½\ZK9\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½]ï¿½n|Jï¿½',NULL,'Wood','wood'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.295538',NULL,NULL,_binary 'ï¿½ï¿½aBï¿½ï¿½A\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'dï¿½ï¿½ï¿½Hï¿½G\ï',NULL,'Iron Ore','ironore'),(1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.910236',NULL,NULL,_binary 'ï¿½ï¿½b~d6J6ï¿½d',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'NkP5ï¿½Fï¿½ï¿½',_binary 'ï¿½ï¿½ï¿½bï¿½Hİ•',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½ï¿½ï¿½t,I\Zï¿½',NULL,'Candle','candle'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.109822',NULL,NULL,_binary 'ï¿½ï¿½cÖºCsï¿½\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½RWTH~ï¿½ï¿½',NULL,'Cotton Field','cottonfield'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.156627',NULL,NULL,_binary 'ï¿½ï¿½uï¿½\'8C\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'Ş¥\0ï¿½ï¿½\ZNËºï¿½',NULL,'Hop Field','hopfield'),(1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.952686',NULL,NULL,_binary 'ï¿½ï¿½Â£ï¿½ï¿½O\ï',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,_binary 'Êœï¿½V\"@ï¿½ï¿½]',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½Oyï¿½\'%EOï¿½^',NULL,'Cigar','cigar'),(1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.263198',NULL,NULL,_binary 'ï¿½ï¿½ÜŸï¿½IG\ï¿',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,_binary '`|%ï¿½ï¿½ï¿½Mï¿½',NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½	ï¿½ï¿½	Mt\ï¿',NULL,'Book','book'),(1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.647123',NULL,NULL,_binary 'ï¿½ï¿½ï¿½Dï¿½ï¿½',_binary 'ï¿½)yï¿½%Iï¿½\ï¿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary 'ï¿½Zï¿½\ZnGÚ‘ï¿½',NULL,'Sheep Field','sheepfield');
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
INSERT INTO `requirement_population_building` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `id`, `population_id`) VALUES (10,'2025-03-31 15:54:52.494902',NULL,NULL,_binary 'ï¿½%ï¿½ï¿½ï¿½fDS',_binary 'Jï¿½ï¿½ï¿½ï¿½TA\ï',_binary 'ï¿½ï¿½Ã“\nKG\\ï¿½t'),(50,'2025-03-31 15:54:52.532531',NULL,NULL,_binary 'mß‰ï¿½2ï¿½JIï¿½\ï',_binary 'ï¿½ï¿½,ï¿½gUIT\ï¿',_binary 'ï¿½ï¿½Ã“\nKG\\ï¿½t');
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
