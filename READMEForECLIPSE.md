# General indications
Work environment settings
Install JKD (JEE) Version 1.8
Install Maven
Install IDE of your choice
Clone the GitHUb project: https://github.com/keyvalles/demoMetaWeather.git

After cloning the project, import into Eclipse IDE, perform the actions:

# 1. Configure JDK in the project:

1.1. On your Eclipse IDE, go into Window > Preferences > Java > Installed JREs > and check your installed JREs. 
You should have an entry with a JDK there. *JDK 1.8*

1.2. Select the Execution Env as show below (see Install JREs image attached in the mail). --> Click OK

1.3. Then Right-Click on your Project -> Maven -> Update Project.

Additionally,

# 2. Configure Maven JRE

2.1. You may have to change Maven JRE. Go to Run -> Run Configurations, selecting the Maven Build. I was running (from the left panel). Then, I clicked the JRE tab and selected the option Workspace default JRE (see run configuration image attached in the mail)

# Note: It is recommended to restart the IDE

Then, indicate in the IDE the main class of the application, in this case, indicate that it is SpringBoot Application and select the class DemoMetaWeatherApplication (see SpringApplication image attached in the mail)

# After this, perform the following actions
mvn clean
mvn compile
mvn install
debug in eclipse and verify that the project has been deployed.

# By postman tool, consume the service

URI: http://localhost:8080/getCity/{city}, (is the parameter to consume the demoMetaWeather service )

1 - You should define the request of the service (explaining why you choose this approach)

@GetMapping, Annotation for mapping HTTP GET requests onto specific handler methods. It supports consumes
Consume options are:
consumes = "text / plain"
consumes = {"text / plain", "application / *"}

@PathVariable, It is a request assignment, whose value is the input parameter of the API consumption needed to process the information.
Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods.

2 - You should define the response of the service (explaining why you choose this approach)

The service response object contains the necessary values to manage the requested information, according to the input parameter.
Displayed as json (app / json)

3 – You should explain the frameworks you used and why you used them.

When working under microservices architecture we can create one application for each microservice. Spring boot, makes it easy to set up the project as it is self-configuring and also makes packaging easy. 
This configuration is standard for working with services, so that they can be consumed without major problems.

That is why, I worked with the following tools:
Spring Boot, version 2.3.1 - with the Spring WEB dependency, which is ideal for working Restful architecture, has Tomcat embedded (already configured), for the deployment of the project. 
Allows resolution of dependencies

- Maven, for the management and construction of the project, which generates the directory structure, allows you to download the libraries, 
in order to resolve the artifact / library conflicts that are required for the project to work.

- Java programming language, version 8.

The demoMetaWeather service receives a request with the name of a city in the world, and returns the temperature of this city in degrees Celsius and Fahrenheit.
And obey the following restrictions:
The API used to obtain the meteorological data is:
This API returns the WOEID of the city that needs to be searched (${city} is the parameter) // ${city} is the parameter passed from the demoMetaWeather service
https://www.metaweather.com/api/location/search/?query=${city}
This API returns the weather for the WOEID of the previous service, in case there is more than one return value, it is considered the most recent:
https://www.metaweather.com/api/location/${woeid}/