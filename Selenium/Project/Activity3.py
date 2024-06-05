from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    username = driver.find_element(By.XPATH, "//input[@id = 'txtUsername']")
    password = driver.find_element(By.XPATH, "//input[@id = 'txtPassword']")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    driver.find_element(By.XPATH, "//input[@id = 'btnLogin']").click()
    welcome = driver.find_element(By.XPATH, "//a[@id = 'welcome']")
    assert welcome.text == "Welcome Abhi"

    driver.quit()