# Import webdriver from selenium
import string
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
    driver = webdriver.Firefox()
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")
    i= driver.find_element(By.XPATH, "/html/body/div[1]/div/div[2]/div[1]/img")
    #item_web_element = driver.find_element(By.XPATH, img_xpath)
    img = i.get_attribute("src")
    print("The source is:", img)
    driver.quit() 
    