# Trivago TestNG Automation

This repository contains my Selenium automation project for testing the **Trivago website**.

I created the tests using **Java, Selenium WebDriver, TestNG, and Page Object Model (POM)**.

## What I Tested

The project covers the main hotel search and booking-related features:

* Search and destination suggestions
* Hotel search results
* Sorting by price
* Price filtering
* Offer card details
* Currency change
* Language change
* Favourites

## Test Cases

### 1. Search Results

Search for **Dubai** and verify that the returned suggestions and hotel results are related to the search keyword.

The test also covers:

* Check-in/check-out dates
* Guests and rooms
* Child age selection
* Result validation

### 2. Sort Functionality

Search for **Cairo**, select price ascending, and verify that the results are returned in the correct order.

### 3. Price Filter

Search for **Dubai**, set a minimum and maximum price, and verify that the returned results are within the selected range.

### 4. Offer Details

Verify that the details shown on an offer card match the details displayed on the offer page, including:

* Hotel name
* Price
* Company/provider
* Deal URL

### 5. Currency

Change the currency to **EGP** and verify that the displayed prices use the correct currency.

### 6. Language

Change the website language to **Arabic** and verify that the home page is displayed in Arabic.

### 7. Favourites

Add a hotel to favourites, verify that it appears in the favourites list, then remove it and verify that the list is empty.

## Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Page Object Model (POM)
* Maven
* ChromeDriver

## Project

**Website:** Trivago https://ar.trivago.com/
**Type:** Web Automation Testing
**Framework:** TestNG
**Language:** Java
