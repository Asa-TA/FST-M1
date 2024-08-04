from tokenize import String
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

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
    driver.find_element(By.XPATH, "//*[@id=\"content\"]/div/div[1]/h1").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]/b").click()
    driver.find_element(By.XPATH, "//*[@id=\"pdMainContainer\"]/div[1]/h1").click()
    driver.find_element(By.XPATH, "//*[@id=\"sidenav\"]/li[3]/a").click()
    t = driver.find_element(By.XPATH, "//*[@id=\"emgcontact_list\"]")
    rows= t.find_elements(By.TAG_NAME, 'tr')
    col = t.find_elements(By.TAG_NAME, 'td')
    row_cnt =len(rows)
    col_cnt= len(col)
    for r in range(1,row_cnt+1):
        for c in range(1,col_cnt+1):
            if r==1:
                a=driver.rows.get(r).find_elements(By.TAG_NAME, "tr")
            print(a)
        else:
            b= driver.col.get(c).find_elements(By.TAG_NAME, "td")
            print(b)
driver.quit()



    