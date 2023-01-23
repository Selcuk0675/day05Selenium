package day11;

import com.github.javafaker.Faker;
import org.junit.Test;


public class C03_Faker  {

    @Test
    public void javaFakerTest() {
        //1. Adim: Faker objesi olustur
        Faker faker=new Faker();
        //2.Adim: Fakre objesi lle fake data olustur
        //first name datasi
        String fname=faker.name().firstName();
        System.out.println(fname);
        //last name datasi
        System.out.println(faker.name().lastName());
        //kullanici adi
        faker.name().username();
        //meslek ismi
        faker.name().title();
        //sehir
        faker.address().state();

    }
}
