/*M!999999\- enable the sandbox mode */
-- MariaDB dump 10.19-11.7.2-MariaDB, for osx10.20 (arm64)
--
-- Host: 127.0.0.1    Database: ppAssemblyLineBa
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `admin`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
                         `created_at` datetime(6) NOT NULL,
                         `deleted_at` datetime(6) DEFAULT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         `id` binary(16) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `role` enum('Admin') DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `building`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` (`capacity`, `production_per_minute`, `created_at`, `deleted_at`, `updated_at`, `id`, `recipe`, `dtype`, `name`, `remarks`, `slug`) VALUES (NULL,0.125,'2025-03-31 15:54:51.525302',NULL,NULL,'�o��N̮\0','�~a�`JB��','ProductionBuilding','Gold Smelter','','goldsmelter'),
                                                                                                                                                                  (NULL,1,'2025-03-31 15:54:50.550610',NULL,NULL,'k@)S�AΕ��','�ivfDAr�\"Aq','ProductionBuilding','Potato Farm','','potatofarm'),
                                                                                                                                                                  (NULL,0.75,'2025-03-31 15:54:52.018529',NULL,NULL,'	LUW��B��','\"� �5�Dۥ_','ProductionBuilding','Winepress','','winepress'),
                                                                                                                                                                  (NULL,0.75,'2025-03-31 15:54:51.996471',NULL,NULL,'\\o��M-��','�7�Zw�Fo�','ProductionBuilding','Cooper','','cooper'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.188762',NULL,NULL,'�.a~M�uR�','��cֺCs��','ProductionBuilding','Cotton Field','','cottonfield'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.644988',NULL,NULL,'	jkJ��0�','Y�_��H�','ProductionBuilding','Mulberry Trees','','mulberrytrees'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.890607',NULL,NULL,'�I�d]C��','%r��`Kd�\n','ProductionBuilding','Windmill','','windmill'),
                                                                                                                                                                  (NULL,0.75,'2025-03-31 15:54:51.977361',NULL,NULL,']��6�N�',NULL,'ProductionBuilding','Winery','','winery'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.083592',NULL,NULL,'�/X�Fw��','�qn�4F,��','ProductionBuilding','Sailmaker','','sailmaker'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.202843',NULL,NULL,'\"�M`y@���',';�$mIp��','ProductionBuilding','Tailor','','tailor'),
                                                                                                                                                                  (NULL,0.75,'2025-03-31 15:54:51.825598',NULL,NULL,'\"�a�}F��','��	�!cNŮA','ProductionBuilding','Fine Forge','','fineforge'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.346182',NULL,NULL,'&Ѥ�cAō�Ch','��aB��A�','ProductionBuilding','Iron Mine','','ironmine'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.609969',NULL,NULL,'\'��4�ODj�',NULL,'ProductionBuilding','Bathhouse','','bathhouse'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:52.212837',NULL,NULL,'(��C2��',NULL,'ProductionBuilding','Tiltyard','','tiltyard'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.231172',NULL,NULL,'*�=`�G�','h�\r��GE[�','ProductionBuilding','Hop Farm','','hopfarm'),
                                                                                                                                                                  (NULL,0.14286,'2025-03-31 15:54:50.693038',NULL,NULL,'/��OB%��','�,�OhG� �','ProductionBuilding','Stonecutter','','stonecutter'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.934870',NULL,NULL,'3`��|�@�','9,��aL\'�D','ProductionBuilding','Horse Field','','horsefield'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:52.134075',NULL,NULL,'3�*��|M�','�5�lqH��','ProductionBuilding','Cannon Foundry','','cannonfoundry'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:51.421014',NULL,NULL,'9Ue�FɲY�\r',NULL,'ProductionBuilding','Knight Barracks','','knightbarracks'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:52.078424',NULL,NULL,'9�ң*@m�3.�','��ܟ�IG�','ProductionBuilding','BookBinder','','bookbinder'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:50.768561',NULL,NULL,'9��`�]L�','\'�穨zG^�\'T�','ProductionBuilding','Copper Armory','','copperarmory'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.678248',NULL,NULL,'<:���\\F�','Q�����','ProductionBuilding','Silk Twine Mill','','silktwinemill'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.622356',NULL,NULL,'>˙6Ȗ@ܧg{Qa�','RO��E��','ProductionBuilding','Linen Weaver','','linenweaver'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:50.912738',NULL,NULL,'B}+Ğ�B��t','��H;�J�','ProductionBuilding','Bakery','','bakery'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.447037',NULL,NULL,'FK�>�fC7�1','\0Wz\n\n�BU��','ProductionBuilding','Cattle Ranch','','cattleranch'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.852336',NULL,NULL,'J��T�YK߹5','v��2U�Og�','ProductionBuilding','Wheat Field','','wheatfield'),
                                                                                                                                                                  (NULL,0.33333,'2025-03-31 15:54:51.307583',NULL,NULL,'MR$�H؀��','�b���M�','ProductionBuilding','Linseed Pil Press','','linseedpilpress'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.253178',NULL,NULL,'Mv���I�','�M����','ProductionBuilding','Malthouse','','malthouse'),
                                                                                                                                                                  (NULL,1.5,'2025-03-31 15:54:51.923789',NULL,NULL,'N��\0�eD�','a���A�A�','ProductionBuilding','Lobsterer','','lobsterer'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.463332',NULL,NULL,'X���@ֺ�','��4��7H;','ProductionBuilding','Rock Salt Mine','','rocksaltmine'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.555887',NULL,NULL,'[I�]�C��',')���jYLW�','ProductionBuilding','Crossbow Maker','','crossbowmaker'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.677168',NULL,NULL,'[mp�:OCx��','���p9G!�','ProductionBuilding','Ropery','','ropery'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.960664',NULL,NULL,'_]�vG	C��','���r`HW�','ProductionBuilding','Vineyard','','vineyard'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.660623',NULL,NULL,'e�\'+�%DU��','��^1�Nu�','ProductionBuilding','Silk Plantation','','silkplantation'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:51.891489',NULL,NULL,'i�|���E�',NULL,'ProductionBuilding','Cuirassier Academy','','cuirassieracademy'),
                                                                                                                                                                  (NULL,1,'2025-03-31 15:54:51.488672',NULL,NULL,'k�춸�K��','f>�SBh�mO�','ProductionBuilding','Butchers Shop','','butchersshop'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.434352',NULL,NULL,'l`N��QMp��',NULL,'ProductionBuilding','Cattle Field','','cattlefield'),
                                                                                                                                                                  (NULL,5,'2025-03-31 15:54:50.508921',NULL,NULL,'m߉�2�JI��','�h�3F��','ProductionBuilding','Sawmill','','sawmill'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.581318',NULL,NULL,'n��GlGk��','.(6G�rE�g�','ProductionBuilding','Marble Quarry','','marblequarry'),
                                                                                                                                                                  (NULL,1.5,'2025-03-31 15:54:51.945850',NULL,NULL,'u���aJ�','�#�L�=','ProductionBuilding','Noble Kitchen','','noblekitchen'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:51.405569',NULL,NULL,'|�	�0NK�l','/Zy�\n`N���','ProductionBuilding','Iron Armory','','ironarmory'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.065574',NULL,NULL,'̉����D0','��£��O�','ProductionBuilding','Cigar Manufacturer','','cigarmanufacturer'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:52.198698',NULL,NULL,'Ь�7G���','ӵ3��D��','ProductionBuilding','Gunsmith','','gunsmith'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.044272',NULL,NULL,'ԡ�P׌OJ��','��5:+�DȪ�','ProductionBuilding','Tobacco Farm','','tobaccofarm'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:50.790385',NULL,NULL,'Օb!�A!��',NULL,'ProductionBuilding','Barracks','','barracks'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.761897',NULL,NULL,'ر\'���@)�','86�9[F~��','ProductionBuilding','Goblet Manufacturer','','gobletmanufacturer'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.478970',NULL,NULL,'ٞ\Z\\KJK���',NULL,'ProductionBuilding','Well','','well'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:51.171710',NULL,NULL,'ۉ�?0K��Y',NULL,'ProductionBuilding','Longbow Archer Range','','longbowarcherrange'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:52.098758',NULL,NULL,'ߘ���	N~�',NULL,'ProductionBuilding','Nitrate Maker','','nitratemaker'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.728996',NULL,NULL,'�	r�Iz��','N�0��L-�','ProductionBuilding','Noble Tailor','','nobletailor'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.594775',NULL,NULL,'���F�',NULL,'ProductionBuilding','School','','school'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:50.718880',NULL,NULL,'��Q_Kn�','v#Zi�C@?�?�','ProductionBuilding','Copper Mine','','coppermine'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.868750',NULL,NULL,'�\Z�C��L\"','��Y�L�','ProductionBuilding','Wheat Farm','','wheatfarm'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.874699',NULL,NULL,'�\Z�t��J�','h���Nػ�','ProductionBuilding','Armorsmith','','armorsmith'),
                                                                                                                                                                  (NULL,0.75,'2025-03-31 15:54:50.492866',NULL,NULL,'�%���fDS','�zҫ)bE ��','ProductionBuilding','Fishermans Hut','','fishermanshut'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.281416',NULL,NULL,'�+�U�FH#�','w���B�','ProductionBuilding','Brewery','','brewery'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.806911',NULL,NULL,'�2(Ӗ�A��','��b~d6J6�d','ProductionBuilding','Chandler','','chandler'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.125465',NULL,NULL,'�4��Թ@P�','��<��iDu','ProductionBuilding','Brickyard','','brickyard'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.102852',NULL,NULL,'�:?���K\'','*�8e��H\\�','ProductionBuilding','Clay Pit','','claypit'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.587844',NULL,NULL,'�;j���A	','@���Lǜ','ProductionBuilding','Linseed Field','','linseedfield'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.639600',NULL,NULL,'�;���1L�','�Y��N�','ProductionBuilding','Bowyer','','bowyer'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.856662',NULL,NULL,'�E���qBY','I��R oE��','ProductionBuilding','Steel Furnace','','steelfurnace'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:50.974519',NULL,NULL,'�MZ$ʸBʜ��',NULL,'ProductionBuilding','Riding Arena','','ridingarena'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:52.225587',NULL,NULL,'�N�	�B\'�',NULL,'ProductionBuilding','University','','university'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:51.568233',NULL,NULL,'�S�OiO��',NULL,'ProductionBuilding','Crossbow Shooting Range','','crossbowshootingrange'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.565136',NULL,NULL,'�]x���J3',NULL,'ProductionBuilding','Tavern','','tavern'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.713629',NULL,NULL,'�e����','�b��YDK�','ProductionBuilding','Indigo Plantation','','indigoplantation'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:51.363957',NULL,NULL,'�j���GB','��\n��6B*','ProductionBuilding','Iron Smelter','','ironsmelter'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.606033',NULL,NULL,'�kf�I�G�','0�҉*�J��','ProductionBuilding','Linseed Farm','','linseedfarm'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.217856',NULL,NULL,'�op˘�L4��','��u�\'8C�','ProductionBuilding','Hop Field','','hopfield'),
                                                                                                                                                                  (NULL,5,'2025-03-31 15:54:50.463304',NULL,NULL,'�sy䇬K߲gfǺ\Z','��K�\ZK9�','ProductionBuilding','Lumberjack','','lumberjack'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:52.171724',NULL,NULL,'�y3kcLѾ��','?��G@̇Kv�','ProductionBuilding','Planing Mill','','planingmill'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.011245',NULL,NULL,'�y;��QO	�','{�{���G','ProductionBuilding','Tobacco Field','','tobaccofield'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:51.540243',NULL,NULL,'�zc��]C8�',NULL,'ProductionBuilding','Goldsmith','','goldsmith'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:50.830937',NULL,NULL,'�z�ŉ�D�','�,�-J.E̊�','ProductionBuilding','Sheep Farm','','sheepfarm'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.790737',NULL,NULL,'�z����','�Ɣ��G�','ProductionBuilding','Apiary','','apiary'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:52.114053',NULL,NULL,'�{ފD[�`_3','�\\�T@��','ProductionBuilding','Powder Mill','','powdermill'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.777186',NULL,NULL,'�Ҕ�?�D�',NULL,'ProductionBuilding','Beehive','','beehive'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:50.660282',NULL,NULL,'��l�vF߾\0','�SIJ�O��','ProductionBuilding','Archery Range','','archeryrange'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.505817',NULL,NULL,'���lI�','�2�\n��FE','ProductionBuilding','Gold Mine','','goldmine'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.152149',NULL,NULL,'��t�4JӍ�','��ĺC��','ProductionBuilding','Longbowyer','','longbowyer'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:51.908479',NULL,NULL,'�����','�k͆\\�@��','ProductionBuilding','Distillery','','distillery'),
                                                                                                                                                                  (NULL,0.33333,'2025-03-31 15:54:51.744735',NULL,NULL,'��DJ��',NULL,'ProductionBuilding','Gemstone Mine','','gemstonemine'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.697840',NULL,NULL,'��\'��M�','�om�?�N�','ProductionBuilding','Indigo Field','','indigofield'),
                                                                                                                                                                  (10,NULL,'2025-03-31 15:54:50.444954',NULL,NULL,'��O�NgJ#�',NULL,'PopulationBuilding','Pioneer\'s Hut','','pioneershut'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.955290',NULL,NULL,'��PXrA��','@�]a�L�;�','ProductionBuilding','Horse Breeder','','horsebreeder'),
                                                                                                                                                                  (NULL,0.125,'2025-03-31 15:54:50.740717',NULL,NULL,'��[%�NL�','�K�A��','ProductionBuilding','Copper Smelter','','coppersmelter'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.813082',NULL,NULL,'��ko�Nq�','���D��','ProductionBuilding','Sheep Field','','sheepfield'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.382007',NULL,NULL,'��n#�O�','��\",��A�','ProductionBuilding','Toolmaker','','toolmaker'),
                                                                                                                                                                  (NULL,0.25,'2025-03-31 15:54:51.840810',NULL,NULL,'��v�,�H�','cL���M�','ProductionBuilding','Cokery','','cokery'),
                                                                                                                                                                  (NULL,0.1,'2025-03-31 15:54:52.153258',NULL,NULL,'��w 3�H�',NULL,'ProductionBuilding','Cannoneers School','','cannoneersschool'),
                                                                                                                                                                  (NULL,0.5,'2025-03-31 15:54:52.041086',NULL,NULL,'���>�M',NULL,'ProductionBuilding','Paper Mill','','papermill'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.326776',NULL,NULL,'���E�?A',NULL,'ProductionBuilding','Medicus','','medicus'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:51.628028',NULL,NULL,'����Q~L�',NULL,'ProductionBuilding','Bathhouse providing water','','bathhouseprovidingwater'),
                                                                                                                                                                  (NULL,0.01667,'2025-03-31 15:54:50.532500',NULL,NULL,'�����','�� �v�A�','ProductionBuilding','Potato Field','','potatofield');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;

--
-- Table structure for table `cost_building_goods`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `cost_building_goods` DISABLE KEYS */;
INSERT INTO `cost_building_goods` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `good_id`, `id`) VALUES (20,'2025-03-31 15:54:52.451391',NULL,NULL,'m߉�2�JI��','��]�n|J�',' ����G~'),
                                                                                                                              (10,'2025-03-31 15:54:52.393446',NULL,NULL,'ٞ\Z\\KJK���','��]�n|J�',';j���El�'),
                                                                                                                              (10,'2025-03-31 15:54:52.471196',NULL,NULL,'k@)S�AΕ��','t��[UFO��','U����dC}'),
                                                                                                                              (5,'2025-03-31 15:54:52.338673',NULL,NULL,'�sy䇬K߲gfǺ\Z','��]�n|J�','[�����'),
                                                                                                                              (10,'2025-03-31 15:54:52.372305',NULL,NULL,'��O�NgJ#�','��]�n|J�','�h�)@Y�'),
                                                                                                                              (10,'2025-03-31 15:54:52.424633',NULL,NULL,'�%���fDS','��]�n|J�','��-�y�A�');
/*!40000 ALTER TABLE `cost_building_goods` ENABLE KEYS */;

--
-- Table structure for table `good`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` (`is_map_resource`, `created_at`, `deleted_at`, `updated_at`, `id`, `name`, `remarks`, `slug`) VALUES (0,'2025-03-31 15:54:47.648991',NULL,NULL,'�����','Clay','','clay'),
                                                                                                                         (0,'2025-03-31 15:54:47.830346',NULL,NULL,'�)�Ad��','Marble','Build material','marble'),
                                                                                                                         (0,'2025-03-31 15:54:47.891276',NULL,NULL,'���	B@E�','Gemstone','','gemstone'),
                                                                                                                         (0,'2025-03-31 15:54:48.063904',NULL,NULL,'����LP','Cannon','','cannon'),
                                                                                                                         (0,'2025-03-31 15:54:47.596950',NULL,NULL,'���ZE�','Bread','','bread'),
                                                                                                                         (0,'2025-03-31 15:54:47.758436',NULL,NULL,'��M��','Gold Ingot','','goldingot'),
                                                                                                                         (0,'2025-03-31 15:54:47.725710',NULL,NULL,'yD���@K�','Meat','','meat'),
                                                                                                                         (0,'2025-03-31 15:54:47.641003',NULL,NULL,'Ĥ�gC���','Longbow','','longbow'),
                                                                                                                         (0,'2025-03-31 15:54:47.605745',NULL,NULL,'ʜ�V\"@��]','Tobacco','','tobacco'),
                                                                                                                         (0,'2025-03-31 15:54:48.090899',NULL,NULL,'�\0	�A��','Vineyard','','vineyard'),
                                                                                                                         (0,'2025-03-31 15:54:47.965667',NULL,NULL,'J�Y�MM�','Barrel','','barrel'),
                                                                                                                         (0,'2025-03-31 15:54:47.796319',NULL,NULL,'#�&�jxK@��','Iron Sword','','ironsword'),
                                                                                                                         (0,'2025-03-31 15:54:48.072903',NULL,NULL,'$�%�RL��','Metal Cuttings','','metalcuttings'),
                                                                                                                         (1,'2025-03-31 15:54:47.352906',NULL,NULL,'\'�#�E6�r','Indigo Field','','indigofield'),
                                                                                                                         (0,'2025-03-31 15:54:47.524704',NULL,NULL,'\'��W�PL,�','Ropes','','ropes'),
                                                                                                                         (0,'2025-03-31 15:54:47.439986',NULL,NULL,'+1b�M���','Favor','Global, needed for more island slots','favor'),
                                                                                                                         (1,'2025-03-31 15:54:47.343648',NULL,NULL,'+c���qH[�','Horse Field','','horsefield'),
                                                                                                                         (0,'2025-03-31 15:54:47.553622',NULL,NULL,'1�{��G�','Copper Sword','','coppersword'),
                                                                                                                         (0,'2025-03-31 15:54:47.813353',NULL,NULL,'2�yԭ�L݁�','Tools','Build material','tools'),
                                                                                                                         (0,'2025-03-31 15:54:47.897934',NULL,NULL,';�:��D�','Goblet','','goblet'),
                                                                                                                         (0,'2025-03-31 15:54:47.987367',NULL,NULL,'<����Gu','Windjammer','','windjammer'),
                                                                                                                         (1,'2025-03-31 15:54:47.313810',NULL,NULL,'@��t�N�','Water tile','','watertile'),
                                                                                                                         (0,'2025-03-31 15:54:47.742101',NULL,NULL,'A�pJ!�;�','Gold Ore','','goldore'),
                                                                                                                         (0,'2025-03-31 15:54:47.515565',NULL,NULL,'A`��ޕI��','Archer','','archer'),
                                                                                                                         (0,'2025-03-31 15:54:47.921581',NULL,NULL,'D�Ѧ%,Go��','Candle Holder','','candleholder'),
                                                                                                                         (0,'2025-03-31 15:54:47.542601',NULL,NULL,'E��Fr��','Copper Ingot','','copperingot'),
                                                                                                                         (0,'2025-03-31 15:54:47.718073',NULL,NULL,'F�,|iC��','Salt','','salt'),
                                                                                                                         (0,'2025-03-31 15:54:47.764695',NULL,NULL,'J)�w�B��','Gold Jewelry','','goldjewelry'),
                                                                                                                         (0,'2025-03-31 15:54:47.772866',NULL,NULL,'L~9�}C*�Z�','Linseed Oil','','linseedoil'),
                                                                                                                         (0,'2025-03-31 15:54:47.878705',NULL,NULL,'M�����','Garment','','garment'),
                                                                                                                         (0,'2025-03-31 15:54:47.489265',NULL,NULL,'NkP5�F��','Linseed','','linseed'),
                                                                                                                         (0,'2025-03-31 15:54:47.657359',NULL,NULL,'P��Z#Ag��','Brick','Build material','brick'),
                                                                                                                         (0,'2025-03-31 15:54:47.588152',NULL,NULL,'R�!q^|O؏R��','Flour','','flour'),
                                                                                                                         (0,'2025-03-31 15:54:48.054792',NULL,NULL,'SwD���B[�','Gunpowder','','gunpowder'),
                                                                                                                         (0,'2025-03-31 15:54:47.473669',NULL,NULL,'T	�|:\nET��','Schnapps','','schnapps'),
                                                                                                                         (0,'2025-03-31 15:54:47.929836',NULL,NULL,'W\n,���Ly�','Liqueur','','liqueur'),
                                                                                                                         (0,'2025-03-31 15:54:47.804665',NULL,NULL,'\\sW5DH�lĦ�','Militia','','militia'),
                                                                                                                         (0,'2025-03-31 15:54:47.666409',NULL,NULL,']�C.$A��Q','Clothes','','clothes'),
                                                                                                                         (0,'2025-03-31 15:54:47.863823',NULL,NULL,'`|%���M�','Dye','','dye'),
                                                                                                                         (0,'2025-03-31 15:54:47.676072',NULL,NULL,'aQ�ͧAG��','Malt','','malt'),
                                                                                                                         (0,'2025-03-31 15:54:47.422326',NULL,NULL,'cK�uG@z��','Coin','Global','coin'),
                                                                                                                         (0,'2025-03-31 15:54:48.030587',NULL,NULL,'dWM��LH��','Armored Horse','','armoredhorse'),
                                                                                                                         (0,'2025-03-31 15:54:47.780291',NULL,NULL,'d���H�G�','Iron Ore','','ironore'),
                                                                                                                         (0,'2025-03-31 15:54:48.019353',NULL,NULL,'i��SzG�','Steel Ingot','','steelingot'),
                                                                                                                         (1,'2025-03-31 15:54:47.403956',NULL,NULL,'l��>��F�','Tobacco Field','','tobaccofield'),
                                                                                                                         (1,'2025-03-31 15:54:47.413331',NULL,NULL,'m��f�H\\�','Wheat Field','','wheatfield'),
                                                                                                                         (0,'2025-03-31 15:54:47.954565',NULL,NULL,'th���Kä ','Grapes','','grapes'),
                                                                                                                         (0,'2025-03-31 15:54:47.466225',NULL,NULL,'t��[UFO��','Plank','Build material','plank'),
                                                                                                                         (1,'2025-03-31 15:54:47.368883',NULL,NULL,'uL�}�{KǾ�','Potato Field','','potatofield'),
                                                                                                                         (0,'2025-03-31 15:54:47.937336',NULL,NULL,'x���E:Fy�','Lobster','','lobster'),
                                                                                                                         (0,'2025-03-31 15:54:47.631666',NULL,NULL,'yg��Kր]�','Horse','','horse'),
                                                                                                                         (1,'2025-03-31 15:54:47.323887',NULL,NULL,'ݧ�F|�Nm�','Mountain tile','','mountaintile'),
                                                                                                                         (1,'2025-03-31 15:54:47.333675',NULL,NULL,'ޥ\0��\ZN˺�','Hop Field','','hopfield'),
                                                                                                                         (0,'2025-03-31 15:54:48.002545',NULL,NULL,'�X2O\\��','Coke','','coke'),
                                                                                                                         (0,'2025-03-31 15:54:47.702332',NULL,NULL,'�\r6�fIS�h','Cattle','','cattle'),
                                                                                                                         (0,'2025-03-31 15:54:47.995284',NULL,NULL,'�	��	Mt�','Book','','book'),
                                                                                                                         (0,'2025-03-31 15:54:47.974715',NULL,NULL,'�s��ICщ�','Wine','','wine'),
                                                                                                                         (1,'2025-03-31 15:54:47.395876',NULL,NULL,'�g�Y�Dŏ.','Mulberry Trees','','mulberrytrees'),
                                                                                                                         (0,'2025-03-31 15:54:47.430892',NULL,NULL,'�\'p��7A�','Cartography','Global, used for Discovery','cartography'),
                                                                                                                         (1,'2025-03-31 15:54:47.299513',NULL,NULL,'�)y�%I��','Land tile','','landtile'),
                                                                                                                         (0,'2025-03-31 15:54:47.822323',NULL,NULL,'�)��?H�','Crossbow','','crossbow'),
                                                                                                                         (0,'2025-03-31 15:54:47.945861',NULL,NULL,'�.+^AzBλ=e�','Feast','','feast'),
                                                                                                                         (0,'2025-03-31 15:54:47.457685',NULL,NULL,'�@�(�O�','Fish','','fish'),
                                                                                                                         (0,'2025-03-31 15:54:47.710783',NULL,NULL,'�D�&�I^�','Rock Salt','','rocksalt'),
                                                                                                                         (0,'2025-03-31 15:54:47.614513',NULL,NULL,'�Oy�\'%EO�^','Cigar','','cigar'),
                                                                                                                         (0,'2025-03-31 15:54:47.684184',NULL,NULL,'�O��?TNi�','Hops','','hops'),
                                                                                                                         (1,'2025-03-31 15:54:47.387591',NULL,NULL,'�RWTH~��','Cotton Field','','cottonfield'),
                                                                                                                         (0,'2025-03-31 15:54:47.734173',NULL,NULL,'�VT�}�MF�','Coal','','coal'),
                                                                                                                         (0,'2025-03-31 15:54:47.787443',NULL,NULL,'�X�ޚsA��','Iron Ingot','','ironingot'),
                                                                                                                         (1,'2025-03-31 15:54:47.376191',NULL,NULL,'�Z�\ZnGڑ�','Sheep Field','','sheepfield'),
                                                                                                                         (0,'2025-03-31 15:54:47.481337',NULL,NULL,'�a���@H','Stone','Build material','stone'),
                                                                                                                         (0,'2025-03-31 15:54:47.571129',NULL,NULL,'�cP>j�Jc�V','Fabric','','fabric'),
                                                                                                                         (0,'2025-03-31 15:54:47.838115',NULL,NULL,'�e1:��K�','Silk','','silk'),
                                                                                                                         (0,'2025-03-31 15:54:48.082679',NULL,NULL,'�u?�cC��','Fireworks','','fireworks'),
                                                                                                                         (0,'2025-03-31 15:54:47.624190',NULL,NULL,'�ɢ���H9','Sail','','sail'),
                                                                                                                         (0,'2025-03-31 15:54:47.751525',NULL,NULL,'��A�[F�','Gold','','gold'),
                                                                                                                         (1,'2025-03-31 15:54:47.361209',NULL,NULL,'���n�L}','Linseed Field','','linseedfield'),
                                                                                                                         (0,'2025-03-31 15:54:47.850513',NULL,NULL,'��D�OϽD','Silk Cloth','','silkcloth'),
                                                                                                                         (0,'2025-03-31 15:54:47.449174',NULL,NULL,'��]�n|J�','Wood','Build material','wood'),
                                                                                                                         (0,'2025-03-31 15:54:47.497311',NULL,NULL,'��m�!N�','Linen','','linen'),
                                                                                                                         (0,'2025-03-31 15:54:47.692855',NULL,NULL,'��oVL4��','Beer','','beer'),
                                                                                                                         (0,'2025-03-31 15:54:47.533274',NULL,NULL,'��yс�D�','Copper Ore','','copperore'),
                                                                                                                         (0,'2025-03-31 15:54:47.579304',NULL,NULL,'���D܈O�','Wheat','','wheat'),
                                                                                                                         (0,'2025-03-31 15:54:48.041818',NULL,NULL,'���_��','Saltpeter','','saltpeter'),
                                                                                                                         (0,'2025-03-31 15:54:47.906275',NULL,NULL,'���b�Hݕ','Honey','','honey'),
                                                                                                                         (0,'2025-03-31 15:54:47.913650',NULL,NULL,'���t,I\Z�','Candle','','candle'),
                                                                                                                         (0,'2025-03-31 15:54:47.506028',NULL,NULL,'����6)G�','Bow','','bow'),
                                                                                                                         (0,'2025-03-31 15:54:47.562809',NULL,NULL,'�����\Z','Yarn','','yarn');
/*!40000 ALTER TABLE `good` ENABLE KEYS */;

--
-- Table structure for table `population`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `population` DISABLE KEYS */;
INSERT INTO `population` (`created_at`, `deleted_at`, `updated_at`, `id`, `name`, `slug`) VALUES ('2025-03-31 15:54:52.247264',NULL,NULL,'5����C�','Colonists','colonists'),
                                                                                                 ('2025-03-31 15:54:52.281515',NULL,NULL,'f����nB�','Paragons','paragons'),
                                                                                                 ('2025-03-31 15:54:52.255901',NULL,NULL,'�*�+|<H��','Townsmen','townsmen'),
                                                                                                 ('2025-03-31 15:54:52.236833',NULL,NULL,'��Ó\nKG\\�t','Pioneers','pioneers'),
                                                                                                 ('2025-03-31 15:54:52.265112',NULL,NULL,'���b*E}�','Merchants','merchants');
/*!40000 ALTER TABLE `population` ENABLE KEYS */;

--
-- Table structure for table `population_requirement`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `population_requirement` DISABLE KEYS */;
INSERT INTO `population_requirement` (`consumption`, `is_basic`, `produce`, `created_at`, `deleted_at`, `updated_at`, `good_id`, `id`, `population_id`) VALUES (0,0x01,0,'2025-03-31 15:54:52.297077',NULL,NULL,'@��t�N�','�-|gQ�I^�(','��Ó\nKG\\�t');
/*!40000 ALTER TABLE `population_requirement` ENABLE KEYS */;

--
-- Table structure for table `recipe`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` (`quantity_of_input_1`, `quantity_of_input_10`, `quantity_of_input_2`, `quantity_of_input_3`, `quantity_of_input_4`, `quantity_of_input_5`, `quantity_of_input_6`, `quantity_of_input_7`, `quantity_of_input_8`, `quantity_of_input_9`, `created_at`, `deleted_at`, `updated_at`, `id`, `input_1`, `input_10`, `input_2`, `input_3`, `input_4`, `input_5`, `input_6`, `input_7`, `input_8`, `input_9`, `output`, `production_building`, `name`, `slug`) VALUES (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.445547',NULL,NULL,'\0Wz\n\n�BU��','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�\r6�fIS�h',NULL,'Cattle','cattle'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.377896',NULL,NULL,'RO��E��','�)y�%I��',NULL,'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'��m�!N�',NULL,'Linen','linen'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,2,0,0,0,0,0,0,'2025-03-31 15:54:50.401633',NULL,NULL,'ӵ3��D��','�)y�%I��',NULL,'SwD���B[�','$�%�RL��',NULL,NULL,NULL,NULL,NULL,NULL,'�u?�cC��',NULL,'Fireworks','fireworks'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.555692',NULL,NULL,'�K�A��','�)y�%I��',NULL,'��yс�D�','��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,'E��Fr��',NULL,'Copper Ingot','copperingot'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.236058',NULL,NULL,'�h�3F��','�)y�%I��',NULL,'��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'t��[UFO��',NULL,'Plank','plank'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,10,0,0,0,0,0,0,'2025-03-31 15:54:49.063272',NULL,NULL,'��ĺC��','�)y�%I��',NULL,'NkP5�F��','��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,'Ĥ�gC���',NULL,'Longbow','longbow'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.324807',NULL,NULL,'@���Lǜ','�)y�%I��',NULL,'�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'���n�L}',NULL,'Linseed Field','linseedfield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.213505',NULL,NULL,'\"� �5�Dۥ_','�)y�%I��',NULL,'th���Kä ','J�Y�MM�',NULL,NULL,NULL,NULL,NULL,NULL,'�s��ICщ�',NULL,'Wine','wine'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.753776',NULL,NULL,'%r��`Kd�\n','�)y�%I��',NULL,'���D܈O�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'R�!q^|O؏R��',NULL,'Flour','flour'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.180554',NULL,NULL,'&g���bO�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'@��t�N�',NULL,'Water tile','watertile'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,10,0,0,0,0,0,0,'2025-03-31 15:54:48.590720',NULL,NULL,'\'�穨zG^�\'T�','�)y�%I��',NULL,'E��Fr��','��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,'1�{��G�',NULL,'Copper Sword','coppersword'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:49.580503',NULL,NULL,')���jYLW�','�)y�%I��',NULL,'NkP5�F��','�X�ޚsA��',NULL,NULL,NULL,NULL,NULL,NULL,'�)��?H�',NULL,'Crossbow','crossbow'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.006656',NULL,NULL,'*�8e��H\\�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�����',NULL,'Clay','clay'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:49.636291',NULL,NULL,'.(6G�rE�g�','�)y�%I��',NULL,'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�)�Ad��',NULL,'Marble','marble'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.376128',NULL,NULL,'/Zy�\n`N���','�)y�%I��',NULL,'�VT�}�MF�','�X�ޚsA��',NULL,NULL,NULL,NULL,NULL,NULL,'#�&�jxK@��',NULL,'Iron Sword','ironsword'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.353222',NULL,NULL,'0�҉*�J��','�)y�%I��',NULL,'���n�L}',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NkP5�F��',NULL,'Linseed','linseed'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.557586',NULL,NULL,'64��JI��','�)y�%I��',NULL,'�VT�}�MF�','��M��',NULL,NULL,NULL,NULL,NULL,NULL,'J)�w�B��',NULL,'Gold Jewelry','goldjewelry'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.842901',NULL,NULL,'86�9[F~��','�)y�%I��',NULL,'��M��','���	B@E�',NULL,NULL,NULL,NULL,NULL,NULL,';�:��D�',NULL,'Goblet','goblet'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.797934',NULL,NULL,'9,��aL\'�D','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'+c���qH[�',NULL,'Horse Field','horsefield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:49.133891',NULL,NULL,';�$mIp��','�)y�%I��',NULL,'�cP>j�Jc�V',NULL,NULL,NULL,NULL,NULL,NULL,NULL,']�C.$A��Q',NULL,'Clothes','clothes'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.374119',NULL,NULL,'?��G@̇Kv�','�)y�%I��',NULL,'�X�ޚsA��','E��Fr��',NULL,NULL,NULL,NULL,NULL,NULL,'$�%�RL��',NULL,'Metal Cuttings','metalcuttings'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,20,0,0,0,0,0,0,0,'2025-03-31 15:54:48.823886',NULL,NULL,'@�]a�L�;�','�)y�%I��',NULL,'+c���qH[�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'yg��Kր]�',NULL,'Horse','horse'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.011217',NULL,NULL,'I��R oE��','�)y�%I��',NULL,'�X�ޚsA��','�X2O\\��',NULL,NULL,NULL,NULL,NULL,NULL,'i��SzG�',NULL,'Steel Ingot','steelingot'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.801530',NULL,NULL,'N�0��L-�','�)y�%I��',NULL,'��D�OϽD','`|%���M�',NULL,NULL,NULL,NULL,NULL,NULL,'M�����',NULL,'Garment','garment'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.818531',NULL,NULL,'O^ྦྷBBb�;�','ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'���	B@E�',NULL,'Gemstone','gemstone'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.737671',NULL,NULL,'Q�����','�)y�%I��',NULL,'�e1:��K�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'��D�OϽD',NULL,'Silk Cloth','silkcloth'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.687504',NULL,NULL,'Y�_��H�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�g�Y�Dŏ.',NULL,'Mulberry Trees','mulberrytrees'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.099052',NULL,NULL,'a���A�A�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'x���E:Fy�',NULL,'Lobster','lobster'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.972788',NULL,NULL,'cL���M�','�)y�%I��',NULL,'�VT�}�MF�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�X2O\\��',NULL,'Coke','coke'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.492251',NULL,NULL,'f>�SBh�mO�','�)y�%I��',NULL,'F�,|iC��','�\r6�fIS�h',NULL,NULL,NULL,NULL,NULL,NULL,'yD���@K�',NULL,'Meat','meat'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.183994',NULL,NULL,'h�\r��GE[�','�)y�%I��',NULL,'ޥ\0��\ZN˺�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�O��?TNi�',NULL,'Hops','hops'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.036540',NULL,NULL,'h���Nػ�','�)y�%I��',NULL,'yg��Kր]�','i��SzG�',NULL,NULL,NULL,NULL,NULL,NULL,'dWM��LH��',NULL,'Armored Horse','armoredhorse'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.527808',NULL,NULL,'v#Zi�C@?�?�','ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'��yс�D�',NULL,'Copper Ore','copperore'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.702780',NULL,NULL,'v��2U�Og�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'m��f�H\\�',NULL,'Wheat Field','wheatfield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.238330',NULL,NULL,'w���B�','�)y�%I��',NULL,'�O��?TNi�','aQ�ͧAG��',NULL,NULL,NULL,NULL,NULL,NULL,'��oVL4��',NULL,'Beer','beer'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.870249',NULL,NULL,'{�{���G','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'l��>��F�',NULL,'Tobacco Field','tobaccofield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:48.987337',NULL,NULL,'�qn�4F,��','�)y�%I��',NULL,'\'��W�PL,�','�����\Z',NULL,NULL,NULL,NULL,NULL,NULL,'�ɢ���H9',NULL,'Sail','sail'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.298830',NULL,NULL,'�\\�T@��','�)y�%I��',NULL,'�VT�}�MF�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SwD���B[�',NULL,'Gunpowder','gunpowder'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.729025',NULL,NULL,'��Y�L�','�)y�%I��',NULL,'m��f�H\\�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'���D܈O�',NULL,'Wheat','wheat'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:50.126235',NULL,NULL,'�#�L�=','�)y�%I��',NULL,'W\n,���Ly�','x���E:Fy�',NULL,NULL,NULL,NULL,NULL,NULL,'�.+^AzBλ=e�',NULL,'Feast','feast'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.677234',NULL,NULL,'�,�-J.E̊�','�)y�%I��',NULL,'�Z�\ZnGڑ�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�����\Z',NULL,'Yarn','yarn'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.509373',NULL,NULL,'�,�OhG� �','�)y�%I��',NULL,'ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�a���@H',NULL,'Stone','stone'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.509728',NULL,NULL,'�2�\n��FE','ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A�pJ!�;�',NULL,'Gold Ore','goldore'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:50.324897',NULL,NULL,'�5�lqH��','�)y�%I��',NULL,'i��SzG�','SwD���B[�',NULL,NULL,NULL,NULL,NULL,NULL,'����LP',NULL,'Cannon','cannon'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,16,0,0,0,0,0,0,'2025-03-31 15:54:50.190440',NULL,NULL,'�7�Zw�Fo�','�)y�%I��',NULL,'�X�ޚsA��','t��[UFO��',NULL,NULL,NULL,NULL,NULL,NULL,'J�Y�MM�',NULL,'Barrel','barrel'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.208088',NULL,NULL,'�M����','�)y�%I��',NULL,'���D܈O�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'aQ�ͧAG��',NULL,'Malt','malt'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,1,1,0,0,0,0,0,'2025-03-31 15:54:48.457949',NULL,NULL,'�SIJ�O��','�)y�%I��',NULL,'��A�[F�','����6)G�','\\sW5DH�lĦ�',NULL,NULL,NULL,NULL,NULL,'A`��ޕI��',NULL,'Archer','archer'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,5,0,0,0,0,0,0,'2025-03-31 15:54:48.416319',NULL,NULL,'�Y��N�','�)y�%I��',NULL,'NkP5�F��','��]�n|J�',NULL,NULL,NULL,NULL,NULL,NULL,'����6)G�',NULL,'Bow','bow'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:49.263818',NULL,NULL,'�b���M�','�)y�%I��',NULL,'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'L~9�}C*�Z�',NULL,'Linseed Oil','linseedoil'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.776204',NULL,NULL,'�b��YDK�','�)y�%I��',NULL,'\'�#�E6�r',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'`|%���M�',NULL,'Dye','dye'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.284550',NULL,NULL,'�ivfDAr�\"Aq','�)y�%I��',NULL,'uL�}�{KǾ�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'T	�|:\nET��',NULL,'Schnapps','schnapps'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,1,0,0,0,0,0,0,'2025-03-31 15:54:50.082189',NULL,NULL,'�k͆\\�@��','�)y�%I��',NULL,'T	�|:\nET��','���b�Hݕ',NULL,NULL,NULL,NULL,NULL,NULL,'W\n,���Ly�',NULL,'Liqueur','liqueur'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.755394',NULL,NULL,'�om�?�N�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\'�#�E6�r',NULL,'Indigo Field','indigofield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,4,0,0,0,0,0,0,0,'2025-03-31 15:54:48.207501',NULL,NULL,'�zҫ)bE ��','�)y�%I��',NULL,'@��t�N�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�@�(�O�',NULL,'Fish','fish'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.532089',NULL,NULL,'�~a�`JB��','�)y�%I��',NULL,'�VT�}�MF�','A�pJ!�;�',NULL,NULL,NULL,NULL,NULL,NULL,'��M��',NULL,'Gold Ingot','goldingot'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.883946',NULL,NULL,'�Ɣ��G�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'���b�Hݕ',NULL,'Honey','honey'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.484096',NULL,NULL,'���p9G!�','�)y�%I��',NULL,'NkP5�F��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\'��W�PL,�',NULL,'Ropes','ropes'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:50.146086',NULL,NULL,'���r`HW�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�\0	�A��',NULL,'Vineyard','vineyard'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,3,1,0,0,0,0,0,0,'2025-03-31 15:54:49.935049',NULL,NULL,'��	�!cNŮA','�)y�%I��',NULL,'���t,I\Z�','E��Fr��',NULL,NULL,NULL,NULL,NULL,NULL,'D�Ѧ%,Go��',NULL,'Candle Holder','candleholder'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.319867',NULL,NULL,'��\n��6B*','�)y�%I��',NULL,'�VT�}�MF�','d���H�G�',NULL,NULL,NULL,NULL,NULL,NULL,'�X�ޚsA��',NULL,'Iron Ingot','ironingot'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:49.713856',NULL,NULL,'��^1�Nu�','�)y�%I��',NULL,'�g�Y�Dŏ.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�e1:��K�',NULL,'Silk','silk'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.258262',NULL,NULL,'�� �v�A�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'uL�}�{KǾ�',NULL,'Potato Field','potatofield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.347948',NULL,NULL,'��\",��A�','�)y�%I��',NULL,'�VT�}�MF�','�X�ޚsA��',NULL,NULL,NULL,NULL,NULL,NULL,'2�yԭ�L݁�',NULL,'Tools','tools'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.465852',NULL,NULL,'��4��7H;','ݧ�F|�Nm�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�D�&�I^�',NULL,'Rock Salt','rocksalt'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,8,0,0,0,0,0,0,0,'2025-03-31 15:54:48.912414',NULL,NULL,'��5:+�DȪ�','�)y�%I��',NULL,'l��>��F�',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ʜ�V\"@��]',NULL,'Tobacco','tobacco'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,12,0,0,0,0,0,0,0,'2025-03-31 15:54:50.167103',NULL,NULL,'��8X��Fg','�)y�%I��',NULL,'�\0	�A��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'th���Kä ',NULL,'Grapes','grapes'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,1,0,0,0,0,0,0,'2025-03-31 15:54:49.034764',NULL,NULL,'��<��iDu','�)y�%I��',NULL,'�VT�}�MF�','�����',NULL,NULL,NULL,NULL,NULL,NULL,'P��Z#Ag��',NULL,'Brick','brick'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,0,0,0,0,0,0,0,'2025-03-31 15:54:48.778734',NULL,NULL,'��H;�J�','�)y�%I��',NULL,'R�!q^|O؏R��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'���ZE�',NULL,'Bread','bread'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (7,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.149490',NULL,NULL,'��K�\ZK9�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'��]�n|J�',NULL,'Wood','wood'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.295538',NULL,NULL,'��aB��A�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'d���H�G�',NULL,'Iron Ore','ironore'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,1,2,0,0,0,0,0,0,'2025-03-31 15:54:49.910236',NULL,NULL,'��b~d6J6�d','�)y�%I��',NULL,'NkP5�F��','���b�Hݕ',NULL,NULL,NULL,NULL,NULL,NULL,'���t,I\Z�',NULL,'Candle','candle'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.109822',NULL,NULL,'��cֺCs��','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�RWTH~��',NULL,'Cotton Field','cottonfield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:49.156627',NULL,NULL,'��u�\'8C�','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ޥ\0��\ZN˺�',NULL,'Hop Field','hopfield'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,2,0,0,0,0,0,0,0,'2025-03-31 15:54:48.952686',NULL,NULL,'��£��O�','�)y�%I��',NULL,'ʜ�V\"@��]',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�Oy�\'%EO�^',NULL,'Cigar','cigar'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,4,2,0,0,0,0,0,0,'2025-03-31 15:54:50.263198',NULL,NULL,'��ܟ�IG�','�)y�%I��',NULL,NULL,'`|%���M�',NULL,NULL,NULL,NULL,NULL,NULL,'�	��	Mt�',NULL,'Book','book'),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    (1,0,0,0,0,0,0,0,0,0,'2025-03-31 15:54:48.647123',NULL,NULL,'���D��','�)y�%I��',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'�Z�\ZnGڑ�',NULL,'Sheep Field','sheepfield');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;

--
-- Table structure for table `requirement_population_building`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
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

/*!40000 ALTER TABLE `requirement_population_building` DISABLE KEYS */;
INSERT INTO `requirement_population_building` (`amount`, `created_at`, `deleted_at`, `updated_at`, `building_id`, `id`, `population_id`) VALUES (10,'2025-03-31 15:54:52.494902',NULL,NULL,'�%���fDS','J����TA�','��Ó\nKG\\�t'),
                                                                                                                                                (50,'2025-03-31 15:54:52.532531',NULL,NULL,'m߉�2�JI��','��,�gUIT�','��Ó\nKG\\�t');
/*!40000 ALTER TABLE `requirement_population_building` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-03-31 16:19:08
