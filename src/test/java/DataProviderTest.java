import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider(name = "validAges")
    public Object[][] validAges(){
        return new Object[][] {
                {18}, {99}, {25}, {11}, {33}
        };
    }

    @Test (dataProvider = "validAges")
    public void validAgesTest(int age){
        System.out.println("Проверяем возраст " + age);
        assert age >= 18 && age <= 99 : "Недопустимый возраст!";
    }
}