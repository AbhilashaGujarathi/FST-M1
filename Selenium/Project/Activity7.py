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
    # Find and click on "My Info"
    myInfo = driver.find_element(By.CSS_SELECTOR, "a#menu_pim_viewMyDetails")
    myInfo.click()

    # Find and click on "Qualifications"
    qualification = driver.find_element(By.XPATH, "//*[@id='sidenav']/li/a[text()='Qualifications']")
    qualification.click()

    # Find and click on "Add Work Experience"
    add = driver.find_element(By.XPATH, "//*[@id='addWorkExperience']")
    add.click()

    # Fill in company and job title
    company = driver.find_element(By.XPATH, "//*[@id='experience_employer']")
    company.send_keys("IBM India")

    jobTitle = driver.find_element(By.XPATH, "//*[@id='experience_jobtitle']")
    jobTitle.send_keys("Test Specialist")

    # Click the save button
    driver.find_element(By.XPATH, "//*[@id='btnWorkExpSave']").click()
    driver.quit()
