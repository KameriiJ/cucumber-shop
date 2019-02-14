package ku.shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) Baht with quantity (.+) in the inventory")
    public void a_product_with_quantity_in_inventory(String name, double price, int quant) {
        catalog.addProduct(name, price, quant);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
        catalog.getProduct(name).updateQuantity(quant);
    }

    @Then("a product (.+) in the inventory should remain (.+) left")
    public void product_should_remain(String name, int remain) {
        assertEquals(remain, catalog.getProduct(name).getRemain());
    }
}
