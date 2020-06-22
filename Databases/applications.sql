-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2019 at 02:16 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `applications`
--

-- --------------------------------------------------------

--
-- Table structure for table `application_details_mle`
--

CREATE TABLE `application_details_mle` (
  `app_id` int(100) NOT NULL,
  `First_Name` varchar(100) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Graduation` varchar(100) NOT NULL,
  `Percentage` varchar(100) NOT NULL,
  `Research_experience` varchar(100) NOT NULL,
  `Total_experience` varchar(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `Interview_assigned` varchar(100) NOT NULL,
  `Interview_taken` varchar(100) NOT NULL,
  `Interview_result` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `application_details_mle`
--

INSERT INTO `application_details_mle` (`app_id`, `First_Name`, `Last_Name`, `email`, `Gender`, `Graduation`, `Percentage`, `Research_experience`, `Total_experience`, `Status`, `Interview_assigned`, `Interview_taken`, `Interview_result`) VALUES
(3, 'riya', 'saini', 'r@gmail.com', 'female', 'B.Tech + M.tech', 'between 80% - 90%', 'Core Machine Learning', '1 year', 'approved', 'Yes', 'No', 20),
(4, 'Dimpy', 'Varshni', 'dim@gmail.com', 'female', 'B.Tech + M.tech', 'between 80% - 90%', 'Core Machine Learning', '1 year', 'approved', 'Yes', 'No', 20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
