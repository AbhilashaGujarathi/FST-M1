from selenium.webdriver import Keys
from selenium.webdriver.support import expected_conditions as EC

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


# Create a fixture to initialize our webdriver
@pytest.fixture(scope="session")
def setup(request):
    # Initialize the webdriver
    driver = webdriver.Firefox()

    # Get the underlying collection
    session = request.node

    # Pass through the driver to the test class
    for item in session.items:
        cls = item.getparent(pytest.Class)
        setattr(cls.obj, "driver", driver)

    # Execute the test method
    yield

    # Close the browser once the test has ended
    request.addfinalizer(driver.close)


@pytest.mark.usefixtures("setup")
class TestSite:

    def test_orangeHRM(self):
        self.driver.get("http://alchemy.hguy.co/orangehrm")

        username = self.driver.find_element(By.ID, "txtUsername")
        password = self.driver.find_element(By.ID, "txtPassword")

        username.send_keys("orange")
        password.send_keys("orangepassword123")

        login = self.driver.find_element(By.ID, "btnLogin")
        login.click()

        dashboard = self.driver.find_element(By.ID, "menu_dashboard_index")
        dashboard.click()

        applyLeave = self.driver.find_element(By.XPATH, "//span[text()='Apply Leave']")
        applyLeave.click()

        selectleave = Select(self.driver.find_element(By.ID,"applyleave_txtLeaveType"))
        selectleave.select_by_visible_text('DayOff')

        applyLeaveFrom = self.driver.find_element(By.ID, "applyleave_txtFromDate")
        applyLeaveFrom.clear()
        applyLeaveFrom.send_keys("2024-07-25")
        applyLeaveTo = self.driver.find_element(By.ID, "applyleave_txtToDate")
        applyLeaveTo.send_keys(Keys.TAB)
        applyLeaveTo.send_keys(Keys.TAB)
        apply = self.driver.find_element(By.ID, "applyBtn")
        apply.click()
        myLeave = self.driver.find_element(By.XPATH, "//a[text()='My Leave']")
        myLeave.click()
        myLeave = self.driver.find_element(By.XPATH, "//a[text()='2024-07-25']/../../td[6]/a")
        status = myLeave.text
        print(status)
        assert status == "Pending Approval(1.00)", "Title mismatch"




