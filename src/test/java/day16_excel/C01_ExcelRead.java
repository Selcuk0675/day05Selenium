package day16_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    /*
        https://files.slack.com/files-pri/T03MPM084DV-F04K2BUMMPW/image.png

        https://files.slack.com/files-pri/T03MPM084DV-F04KPKL97UY/image.png

        *************ADImLaR:*********

         *Java dosyasina sag tikla ve resources adinda bir klasor olustur
         *Excel dosyasini bu klasore at

        Resources dosyasi excel,work,text,.. gibi data dosyalarinin oldugu klasor olaacaktir.














     */

    @Test
    public void readExcelTest() throws IOException {
        //    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)
       String path="./src/test/java/resources/Capitals.xlsx";
         //String path ="./src/test/java/resources/Capitals.xlsx";
        //src/test/java/resources
        //src/test/java/resources/Capitals.xlsx



        //DOSYA AC
        FileInputStream fileInputStream=new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbok= WorkbookFactory.create(fileInputStream);
//        SAYFAYI AC / Sheet1
//        Sheet sheet1=workbok.getSheetAt(0);
        Sheet sheet1=workbok.getSheet("sheet1");//sheet1 isimli sayfayi ac

//        ILK SATIRA GIT / Row
       Row row1= sheet1.getRow(0);//ilk satira git

//        INK SATIRDAKI ILK VERIYI AL
        Cell cell1=row1.getCell(0);//ilk hucredeki datayi ver

//        O VERIYI YAZDIR
        System.out.println(cell1);

        //1.SAtir  2.Sutun
      Cell cell2=  sheet1.getRow(0).getCell(1);
        System.out.println(cell2);

        //3.SAtir  1.Sutun yazdir ve o verinin france oldugunu test et
        String cell31=sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //Excell de ki toplam satir sayisini bul
        int toplamSatirSys=sheet1.getLastRowNum()+1;//son satir numarasi    not: index sifirdan baslayarak saydigi icin 1 ekliyoruz
                                                    //sayma sayilari 1 den basliyor
        System.out.println(toplamSatirSys);

        //Kullanilan toplam satirsayisini bul
        int sumOfRow= sheet1.getPhysicalNumberOfRows();//1den basliyor
        System.out.println(sumOfRow);


        // COUNTRY,CAPİTALS key ve valuelari map a alip print et
        //france paris---turkey ankara


        //Variable olusturalim .Bu variable exceldeki country ,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri=new HashMap<>();
        sheet1.getRow(0).getCell(0);//Country
        sheet1.getRow(1).getCell(0);//Usa
        sheet1.getRow(2).getCell(0);//france
        sheet1.getRow(3).getCell(0);//ingiltere


        sheet1.getRow(0).getCell(1);//Capital
        sheet1.getRow(1).getCell(1);//D.c
        sheet1.getRow(2).getCell(1);//Paris
        sheet1.getRow(3).getCell(1);//london
        
        for (int satirSayisi=1;satirSayisi<toplamSatirSys;satirSayisi++){//indexle caslisiyoruz
            String country=sheet1.getRow(satirSayisi).getCell(0).toString();//Country
            String capitals=sheet1.getRow(satirSayisi).getCell(1).toString();//Capital
            ulkeBaskentleri.put(country,capitals);
            
        }
        System.out.println("ulkeBaskentleri = " + ulkeBaskentleri);
        
        
        
        
        


    }
}
