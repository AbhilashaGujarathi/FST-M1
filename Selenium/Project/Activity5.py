from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import Select

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    username = driver.find_element(By.XPATH,"//input[@id = 'txtUsername']")
    password = driver.find_element(By.XPATH,"//input[@id = 'txtPassword']")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    driver.find_element(By.XPATH,"//input[@id = 'btnLogin']").click()
    myInfo = driver.find_element(By.XPATH,"//*[@id = 'menu_pim_viewMyDetails']")
    myInfo.click()
    driver.find_element(By.XPATH,"//input[@value = 'Edit']").click()
    firstName = driver.find_element(By.XPATH,"//input[@title= 'First Name']")
    lastName = driver.find_element(By.XPATH,"//input[@title= 'Last Name']")
    firstName.clear()
    firstName.send_keys("Abhi")
    lastName.clear()
    lastName.send_keys("ghghg")
    driver.find_element(By.XPATH,"//*[@id= 'personal_optGender_1']").click()
    select = Select(driver.find_element(By.XPATH, "//select[@id= 'personal_cmbNation']"))
    select.select_by_visible_text("Indian")
    dob = driver.find_element(By.XPATH,"//input[@id= 'personal_DOB']")
    dob.send_keys("1993-09-20")
    driver.find_element(By.XPATH,"//input[@id= 'btnSave']").click()
    driver.quit()