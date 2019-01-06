-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 24, 2018 at 02:42 pm
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hibernate_assign0`
--

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
  `customerId` int(11) NOT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`customerId`, `customerName`) VALUES
(0, 'some one'),
(1, 'abc'),
(2, 'b');

-- --------------------------------------------------------

--
-- Table structure for table `CustomerDetail`
--

CREATE TABLE IF NOT EXISTS `CustomerDetail` (
  `creditScore` int(11) DEFAULT NULL,
  `customerAddress` varchar(255) DEFAULT NULL,
  `rewardPoints` int(11) DEFAULT NULL,
  `customerId` int(11) NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CustomerDetail`
--

INSERT INTO `CustomerDetail` (`creditScore`, `customerAddress`, `rewardPoints`, `customerId`) VALUES
(7, 'H no 123, Street abc, City blank', 6, 0),
(1, 'H no 123, Street abc, City blank', 2, 1),
(4, 'H no 123, Street abc, City blank', 3, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CustomerDetail`
--
ALTER TABLE `CustomerDetail`
  ADD CONSTRAINT `FKagryk1v151t6tsnex37ehkwv4` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
