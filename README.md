# flagpicker_submission
flag picker rest api 

Open up in intellij and run the spring boot application class #FlagPickerApplication and then use the following links to see the flags returned
uri to get the all flags 
http:localhost:8080/flags/

uri to get continent wise country and flag list use the following uri
http://localhost:8080/flags/continent/{name}
example : http://localhost:8080/flags/continent/africa

uri to get country specific flag use the following uri
http://localhost:8080/flags/country/{name}
example : http://localhost:8080/flags/country/india

Actutor to see the metrics and admin uri
http://localhost:8080/actuator
