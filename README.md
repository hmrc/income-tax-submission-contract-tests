# income-tax-submission-contract-tests
API test suite for the `<digital service name>` using Cucumber and [play-ws](https://github.com/playframework/play-ws) client.  

## Running the tests

Prior to executing the tests ensure you have:
 - Installed [MongoDB](https://docs.mongodb.com/manual/installation/) 
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

    sudo mongod
    sm --start INCOME_TAX_SUBMISSION_ALL -r

Then execute the Cucumber tests:

    ./run_tests.sh <environment>

The tests default to the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 

#### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf).

 For example, to execute the `run_tests.sh` script against QA  environment

     ./run_tests.sh qa