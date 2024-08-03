# Import webdriver from selenium
import unittest
from lib2to3.pgen2.token import STRING
from tokenize import String
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Print the title of the page
    print("Page title is: ", driver.title)
    if (driver.title == "OrangeHRM"):
        print("title matches")
        driver.close()



