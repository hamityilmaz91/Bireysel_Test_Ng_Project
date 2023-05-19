package pearlymarket.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    // simdi configuration.properties  dis kaynak dosyasi. Bu dosyayi once sisteme dahil etmemiz gerekiyor
    // ve bu clasi obje üzerinden takip ederiz. Bu da dmek oluyorki configuration.propeties dis kaynak dosyasini
    // obje uzerinden okuruz.
    // . properties uzantili dosyalari okumak icin özel class olusturulmustur.
    // Propeties dosyasi fileinputstream ile ice aktarilir
    //


    public static Properties properties;

    static {


        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties= new Properties();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }
}
