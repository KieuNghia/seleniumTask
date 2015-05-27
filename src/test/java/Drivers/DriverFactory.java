package Drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class DriverFactory {

    public WebDriver driver;


    private enum TypeDriver {
        FIREFOX, OPERA, CHROME, IE,
    }
    public WebDriver DriverBuilder(String typeDriver) throws MalformedURLException {
        TypeDriver type = TypeDriver.valueOf(typeDriver.toUpperCase());
        switch (type) {
            case FIREFOX:
                return new FirefoxDriverBuilder().createDriver();
            case OPERA:
                return new OperaDriverBuilder().createDriver();
            case CHROME:
                return new ChromeDriverBuilder().createDriver();
            case IE:
                return new IEDriverBulder().createDriver();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }

}
