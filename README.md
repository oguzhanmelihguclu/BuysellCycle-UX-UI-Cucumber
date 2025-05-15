# 🌐 **BuySellCycle Web Test Automation Project**

This project is designed to test the **responsive web UI** of the [BuySellCycle](https://buysellcycle.com/) website. The tests are implemented using **Selenium WebDriver** in combination with **Cucumber** for BDD-style scenarios. Test results are reported using **Allure Reports**.

---

## 🚀 **Technologies and Tools Used**

| **Tool / Technology**    | **Description**                                           |
|--------------------------|-----------------------------------------------------------|
| **Java (Corretto 17)**   | Programming language used for automation                  |
| **Selenium WebDriver**   | Automates browser UI interactions                         |
| **Cucumber**             | Enables Behavior Driven Development (BDD) with Gherkin    |
| **TestNG**               | Test execution and management framework                   |
| **Allure Reports**       | Advanced visual test report tool                          |
| **Maven**                | Dependency and project build management                   |
| **Chrome / Edge Drivers**| For cross-browser testing                                  |



## 🖥️ **Tested Platform**

- **Website:** [BuySellCycle](https://buysellcycle.com/)
- **Device:** Windows 
- **Browsers Tested:** Chrome, Edge
- **Test Type:** Responsive Web UI Automation



## 📁 **BuySellCycleTest Project Structure**

---
```
BuySellCycleTest/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── config/
│   │       ├── drivers/
│   │       ├── pages/
│   │       └── utilities/
│   ├── test/
│   │   └── java/
│   │       ├── stepdefinitions/
│   │       └── runners/
├── resources/
│   ├── features/
│   └── config.properties
├── testng.xml
├── pom.xml
├── logs/
├── allure-results/
└── README.md
```

---

## 🧭 **Test Coverage (Backlog)**

The project covers **44 user stories** including, but not limited to:

- ✅ **US_001** - User can access homepage
- ✅ **US_005** - User can view product categories
- ✅ **US_010** - User can search for products
- ✅ **US_017** - User can add/remove items from cart
- ✅ **US_024** - User can view and edit profile

You can find detailed feature files in the `resources/features/` folder or review the complete backlog under `docs/backlog.md`.

---

## 📊 **Reporting**

All test execution results are generated in **Allure Report** format. After running tests::

```bash
mvn clean test
allure serve allure-results

🧑‍💻 Contact
QA Engineer: Oğuzhan Melih Güçlü

Email: oguzhanmguclu@gmail.com

LinkedIn: Oğuzhan Melih Güçlü
