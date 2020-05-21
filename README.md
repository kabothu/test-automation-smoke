# Web Automation Project


This is a automation framework to support planned smoke test plan
## Salient Features of the framework :
-  Maven, TestNG (TDD approach), Page Object Modal
- Reporting : Allure Reports - along with reports, allure annotataions are used to properly define various features of allure like @Story, @Feature, @Epic, @Owner, @Step 
- Usage of lombok plugin :  @Slf4j annotation for Logging framework
- Support for cross-browser testing ( browser value can be defined in config file or can be provided at run time), also there is a choice to run tests in headless and incognito mode
- Support for cross-envirinment testing(Assuming there are 3 environments : Dev, QA, Prod), environemnt value can be provided at run time and tests will be executed against the respective config file which has specific environment variables  
- Default browser and environment : QA/Chrome
- Useful generic utilities like Browser Actions, Browser Wait to dynamically apply wait and perform common browser/element actions
- Usage of WebDriverManager : in order to automatically download the driver's binary files (.exe files) for Web Automation (to get rid off compatibility issues between driver's .exe file and browser version installed in the system) 
## Getting started 
### Setup Instructions : 
 -  Make sure that Maven, Java (v1.8) is installed and system environment variables are configured correctly
 - Clone this GitHub repo into any IDE (preferred intellij)
 - Check that lombok plugin is installed and enabled for this project in the IDE 
 ### How to run tests? : 


  | Command | Explaination | 
| ------ | ------ |  
| mvn clean install | open terminal and go to project root directory. This command will execute tests as per TestNG suite file provided in pom.xml file. This will run with default browser (chrome) and environment-QA  | 
 | mvn -Dbrowser=firefox clean install|This executes tests with firefox browser and deafult environment-QA|  
  | mvn -Dbrowser=chrome -Dheadless=true clean install| This executes tests with chrome browser in headless mode|
  | mvn -Dbrowser=chrome -Dincognito=true clean install| This executes tests with chrome browser in incognito mode|
   |allure serve allure-results |Once any one of the command is executed, this command will help to generate allure reports and will open the report in user's default browser  |

 #### Contact Info:  Your feedback matters a lot, please feel free to contact me [Email](surendrasingh.db@gmail.com) [LinkedIn](https://www.linkedin.com/in/surendra-singh-db/)

