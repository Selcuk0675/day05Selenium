package day16_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //ilk once su yapilara gitmem gerek
        //WORKBOOK > WORKSHEET/SHEET(SAYFA) > ROW (SATIR)> CELL>YAZDİR>KAYDET
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

        // İLK SATİR 3. SUTUN U CREATE ET
        Cell cell3=row1.createCell(2);

        // Nufus yazdir
        cell3.setCellValue("Nufus");//Yazdik ama kaydetmedik

        //2. satir 3. sutuna 45000
        sheet1.getRow(1).createCell(2).setCellValue("45665656565");

        //3. satir 3. sutuna 35000 yazdir
        sheet1.getRow(2).createCell(2).setCellValue("1546462626");

        //Kaydet  :islemi FileOutputStream ile yapilir
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbok.write(fileOutputStream);

    }
}
