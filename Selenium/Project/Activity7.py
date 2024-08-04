from tkinter.tix import Select
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
    driver.find_element(By.XPATH, "//*[@id=\"sidenav\"]/li[9]/a").click()
    driver.find_element(By.ID, "addWorkExperience").click()
    driver.find_element(By.ID, "experience_employer").send_keys("IBM2")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Testin2")
    driver.find_element(By.ID, "btnWorkExpSave").click()
    driver.close()
