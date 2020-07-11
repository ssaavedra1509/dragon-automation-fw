# Dragon Test Automation Framework
This is the Dragon Test Automation Framework repository to support the online course

José Hurtado<br />
[@jhumbertoh](https://twitter.com/jhumbertoh)

License
=======
You can use this code for your own personal learning and development. Please do not use it to train others. 

And do not use it for commercial purposes.

## Running  all test classes
    mvn clean test

## Running Cucumber Test with a subset of scenarios tagged with "@E2E"
    mvn clean test -Dcucumber.filter.tags="@E2E"
    
## Running Cucumber Test with a subset of scenarios tagged with "@ApiRest"
    mvn clean test -Dcucumber.filter.tags="@ApiRest"