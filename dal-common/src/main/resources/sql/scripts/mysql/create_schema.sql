-- Server version: 5.5.41-MariaDB

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `french_porzeczki`
--

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `parentCategory_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- RELATIONS FOR TABLE `Category`:
--

-- --------------------------------------------------------

--
-- Table structure for table `Item`
--

CREATE TABLE `Item` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- RELATIONS FOR TABLE `Item`:
--

-- --------------------------------------------------------

--
-- Table structure for table `LentItem`
--

CREATE TABLE `LentItem` (
  `id` bigint(20) NOT NULL,
  `lentDate` datetime DEFAULT NULL,
  `returnDate` datetime DEFAULT NULL,
  `borrower_id` bigint(20) NOT NULL,
  `borrowing_id` bigint(20) NOT NULL,
  `lender_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- RELATIONS FOR TABLE `LentItem`:
--

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

CREATE TABLE `Person` (
  `id` bigint(20) NOT NULL,
  `additionalInfo` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- RELATIONS FOR TABLE `Person`:
--

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `email` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- RELATIONS FOR TABLE `User`:
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_3v34vcvwua46xp9jd0bj7rk78` (`parentCategory_id`);

--
-- Indexes for table `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_59pwuale7q0ni8w5wtq0i0sp9` (`category_id`);

--
-- Indexes for table `LentItem`
--
ALTER TABLE `LentItem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_fm8rdhpfoddu74xxnjsltkh79` (`borrower_id`),
  ADD KEY `FK_biid6jvm5wqkduvntvr8uiv34` (`borrowing_id`),
  ADD KEY `FK_8svt74u2s9w0sdv6qk8bhy5q9` (`lender_id`);

--
-- Indexes for table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Item`
--
ALTER TABLE `Item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LentItem`
--
ALTER TABLE `LentItem`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Person`
--
ALTER TABLE `Person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
COMMIT;
