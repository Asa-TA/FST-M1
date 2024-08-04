from tokenize import String
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from tkinter.tix import Select



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
    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span").click()
    ddelement= Select(driver.find_element(By.ID('applyleave_txtLeaveType')))
    ddelement.selectByVisibleText("Day off")
    driver.find_element(By.ID, "applyleave_txtFromDate").send_keys("IBM")
    driver.find_element(By.ID, "applyleave_txtToDate").send_keys("testing")
    driver.find_element(By.ID, "applyBtn").click()
    driver.quit()



