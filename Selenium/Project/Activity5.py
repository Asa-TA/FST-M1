import string
from tkinter.tix import Select
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
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.ID, "btnSave").click()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Hibiscus6change")
    driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("test1chagne")
    driver.find_element(By.XPATH, "//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[1]/ul/li[2]/label").click()
    ddelement= Select(driver.find_element(By.ID('personal_cmbNation')))
    ddelement.selectByVisibleText("Barbudans")
    driver.find_element(By.ID, "btnSave").click()
    driver.close()


