package day18_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {
            //  3. Logger object olustur:
            //  private static Logger logger = LogManager.getLogger(Demo1.class.getName());
            //  4. Logger fonksiyonuyla istenilen fonksiyonu kullan
            //  logger.debug("Debug logger");
            //  logger.info("Info logger");
            //  logger.error("Error logger");
            //  logger.fatal("Fatal logger");
    private static Logger logger= LogManager.getLogger(C01_Log4j.class.getName());
    @Test
    public void Log4j() {
        // logger objesi ile loglama işlemini yap
        logger.fatal("Fatal Log!");
        logger.error("error Log!");
        logger.warn("warn Log!");
        logger.debug("debug Log!");
        logger.info("info Log!");

    }
}
