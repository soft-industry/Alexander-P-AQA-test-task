@smokes-ui
Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: User get results of different products
    When user execute  request to get results by "<productName>" products
    Then user  sees the results displayed for "<productName>"
    Examples:
      | productName |
      | apple       |
      | mango       |

  Scenario Outline: User get error when get results of non existing products
    When user execute  request to get results by "<productName>" products
    Then error message is displayed for item "<productName>"
    Examples:
      | productName |
      | car         |
      | null        |