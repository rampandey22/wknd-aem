A sample AEM project which creates a servlet to accept firsname , lastname and email address as input .
For example :  http://localhost:4502/bin/eventregistrationform?firstname=ra&lastname=pandey&email=ram010489@yahho.co.in
and calls https://api.genderize.io/?name=firstname to check the gender of the name and the probability around it .
Servlet can be found at com.adobe.aem.guides.wknd.core.servlets.EventRegistrationServlet
 and the service can be found at com.adobe.aem.guides.wknd.core.service.FormProcessor
 
 A unit test to test the FormProcessor has been written in FormProcessorTest 
 
 To run the project you will need AEM 6.5.0 and use the below command :
 
 mvn clean install -PautoInstallSinglePackage
 
 To run just the core bundle use below command from the core folder :
 
 mvn clean install -PautoInstallBundle