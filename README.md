# Cucumber tests to incoporate WAVE & Google Accessibility Audits

## Setup

1. clone the repo `git clone git@dps-gitlab.service.nhsbsa:TestAutomation/WaveAndAccessibilityAudit.git` (ssh) or `git clone https://dps-gitlab.service.nhsbsa/shabh/CCCHS_AT.git` (If you are using https your personal clone link is foun on the project page)

2. In the project folder structure open any feature file from src > test > resources > features > Cloud
accessibility_audit.feature
WaveAccessibility.feature

3. run the features

## Running via Maven

Running the tests via maven allow run time arguments to passed in easily and enable more advanced report to be created when test have been run.

1. View run configurations
2. Select Maven Build >> New
3. Set Base directory `${workspace_loc:/WaveAndAccessibilityAudit}`
4. Set Goals `verify -Dcucumber.options="src/test/resources/features/Cloud --tags @waveaccessibility --no-dry-run"` replacing the folder and tags as requires

or 

Set Goals `verify -Dcucumber.options="src/test/resources/features/Cloud --tags @accessibilityaudit --no-dry-run"` replacing the folder and tags as requires

5. Apply and Run

## Running via Maven Command

### Google Accessibility Audit:
mvn verify -Dbrowser=chrome_linux -Dcucumber.options="src/test/resources/features/Cloud --tags @accessibilityaudit --no-dry-run"

### Wave Accessibility:
mvn verify -Dbrowser=chrome_linux_wave -Dcucumber.options="src/test/resources/features/Cloud --tags @waveaccessibility --no-dry-run"


## NOTE:-
1. Accessibility tests are integrated in the current selenium cucumber framework used in NHSBSA
2. Becomes part of the testing cycle for the accessibility checking on the web app pages