package calculator;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("Two input values, {int} and {int}")
    public void twoInputValuesAnd(Integer int1, Integer int2) {
        value1 = int1;
        value2 = int2;
    }

    @When("I add the two values")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
    }

    @Then("I expect the result {int}")
    public void iExpectTheResult(Integer expectedResult) {
        Assert.assertEquals(expectedResult.intValue(), result);
    }
}
