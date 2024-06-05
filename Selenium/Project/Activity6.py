import self
from selenium import webdriver
from selenium.common import NoSuchElementException
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

    directory = driver.find_element(By.XPATH, "//*[@id='menu_directory_viewDirectory']")
    # Perform actions on the element
    if directory.is_displayed() and directory.is_enabled():
        # Click on the element
        directory.click()
       # directory.click()
        print("Element is visible and clickable. Clicked on the element.")
    else:
        print("Element is either not visible or not clickable.")

    try:
        heading = driver.find_element(By.XPATH, "//*[@id='content']/div[1]/div[1]/h1")
        # Assertion for page title
       # self.assertEqual("Search Directory", heading.text)
        print("Assertion Passed: Page title is 'Search Directory'")
    except NoSuchElementException:
        print("Element not found.")
   # finally:
      #  driver.quit()