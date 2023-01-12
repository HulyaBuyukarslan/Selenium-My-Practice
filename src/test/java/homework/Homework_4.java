package homework;

import com.github.javafaker.Faker;
import junit_my_practice.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Homework_4 extends TestBase {
//    Faker Kutuphanesi HOMEWORK
//    Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
//    degerler uretmemize imkan tanir.
//    Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.

    @Test
    public void test1() {
          Faker faker = new Faker();
                //"https://facebook.com"  Adresine gidin
                driver.get("https://facebook.com");
                //"create new account"  butonuna basin
                waitFor(3);
                driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
                //"firstName" giris kutusuna bir isim yazin
                String name1 = faker.name().firstName();
                String surname = faker.name().lastName();
                String email = faker.internet().emailAddress();
                String sifre = faker.internet().password();
                int birtdayGun = faker.number().numberBetween(1, 31);
                int birtdayAy = faker.number().numberBetween(1, 12);
                int birtdayYil = faker.number().numberBetween(1905, 2023);
                driver.findElement(By.xpath("//*[@placeholder='Adın']")).sendKeys(name1, Keys.TAB, surname, Keys.TAB, email, Keys.TAB, sifre);
                driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']")).sendKeys(email);

                //"email" giris kutusuna bir email yazin
                //"email" onay kutusuna emaili tekrar yazin
                //Bir sifre girin
                //Tarih icin gun secin
                //Tarih icin ay secin
                //Tarih icin yil secin

            //"surname" giris kutusuna bir soyisim yazin
                WebElement birtday = driver.findElement(By.xpath("//*[@name='birthday_day']"));
                Select select = new Select(birtday);
                select.selectByValue(String.valueOf(birtdayGun));
                WebElement ay = driver.findElement(By.xpath("//*[@name='birthday_month']"));
                Select select1 = new Select(ay);
                select1.selectByValue(String.valueOf(birtdayAy));
                WebElement yil = driver.findElement(By.xpath("//*[@name='birthday_year']"));
                Select select2 = new Select(yil);
                select2.selectByValue(String.valueOf(birtdayYil));
                //Cinsiyeti secin
                WebElement cinsiyet = driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
                cinsiyet.click();
                WebElement erkek = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));
                WebElement ozel = driver.findElement(By.xpath("(//*[@name='sex'])[3]"));
                //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
                Assert.assertTrue(cinsiyet.isSelected());
                Assert.assertFalse(erkek.isSelected());
                Assert.assertFalse(ozel.isSelected());
                //Sayfayi kapatin
            }
        }


