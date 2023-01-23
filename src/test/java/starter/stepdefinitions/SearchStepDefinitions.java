package starter.stepdefinitions;

import dto.ErrorDTO;
import dto.ResultDTO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static starter.stepdefinitions.BaseSteps.BASE_URI;

public class SearchStepDefinitions {

    private Response response;

    public static String searchProduct = "api/v1/search/test/%s";

    @When("user execute  request to get results by {string} products")
    public void userExecuteRequestToGetResultsByProducts(String product) {
        RequestSpecification requestSpecification = SerenityRest.given().relaxedHTTPSValidation().baseUri(BASE_URI).basePath(String.format(searchProduct, product)).log().all();
        response = requestSpecification.get();
    }

    //there is a bug in search results for apple - title is "Organix Knijpfruit Appel, Aardbei & Quinoa 12 Maanden 100 g" not contains apple
    //there is a bug in search results for mango - title is "Bonbébé Appel Perzik Banaan Pouch 6 Maanden 90 g" not contains mango
    @Then("user  sees the results displayed for {string}")
    public void userSeesTheResultsDisplayedFor(String product) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        List<ResultDTO> resultDTO = Arrays.asList(response.as(ResultDTO[].class));
        List<String> titles = resultDTO.stream().map(ResultDTO::getTitle).collect(Collectors.toList());
        assertThat(titles.stream().allMatch(t -> t.toLowerCase().contains(product))).isTrue();
    }

    @Then("error message is displayed for item {string}")
    public void userDoesNotSeeTheResults(String item) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
        ErrorDTO errorDTO = response.as(ErrorDTO.class);
        assertThat(errorDTO.getDetail().getRequestedItem().equalsIgnoreCase(item)).isTrue();
    }

}
