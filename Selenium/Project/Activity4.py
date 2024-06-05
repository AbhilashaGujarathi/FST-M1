from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    # Navigate to the webpage
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Find and fill in the username and password fields
    username = driver.find_element(By.XPATH, "//input[@id = 'txtUsername']")
    password = driver.find_element(By.XPATH, "//input[@id = 'txtPassword']")
    username.send_keys("orange")
    password.send_keys("orangepassword123")

    # Click the login button
    driver.find_element(By.XPATH, "//input[@id = 'btnLogin']").click()

    # Implicitly wait for 10 seconds
    driver.implicitly_wait(10)

    # Find the PIM element and click on it
    PIM = driver.find_element(By.XPATH, "//*[@id='menu_pim_viewPimModule']")
    PIM.click()

    # Add new employee
    addBtn = driver.find_element(By.XPATH, "//*[@id='btnAdd']")
    addBtn.click()

    firstName = driver.find_element(By.XPATH, "//*[@id='firstName']")
    lastName = driver.find_element(By.XPATH, "//*[@id='lastName']")
    firstName.send_keys("Orange")
    lastName.send_keys("OrangeHRM")

    # Save new employee
    btnSave = driver.find_element(By.XPATH, "//*[@id='btnSave']")
    btnSave.click()

    # View employee list
    viewEmployee = driver.find_element(By.XPATH, "//*[@id='menu_pim_viewEmployeeList']")
    viewEmployee.click()

    # Search by Name
    searchName = driver.find_element(By.XPATH, "//*[@id='empsearch_employee_name_empName']")
    searchName.send_keys("Orange")

    searchBtn = driver.find_element(By.XPATH, "//*[@id='searchBtn']")
    searchBtn.click()
    driver.quit()
