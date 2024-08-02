from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# with webdriver.Firefox as driver:

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net")
    print(driver.title)
    aboutus = driver.find_element(By.id,"about-link").click
    #aboutus.click()
    print(aboutus.getTitle())
    driver.quit()