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
with webdriver.Firefox(service=service) as driver:
    driver = webdriver.Firefox()
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")
    username = driver.find_element(By.ID, "txtUsername")
    password = driver.find_element(By.ID, "txtPassword")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewPimModule\"]/b").click()
    driver.find_element(By.XPATH, "//*[@id=\"btnAdd\"]").click()
    driver.find_element(By.ID, "firstName").send_keys("Hibiscus6")
    driver.find_element(By.ID, "lastName").send_keys("test1")
    driver.find_element(By.ID, "btnSave").click()
    driver.find_element(By.ID, "menu_pim_viewEmployeeList").click()
    driver.find_element(By.ID, "empsearch_employee_name_empName").send_keys("Hibiscus6")
    driver.find_element(By.ID, "searchBtn").click()
    driver.close()

    

    #login.click()
