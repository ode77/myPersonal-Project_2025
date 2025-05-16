package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaders {
    File file = new File("src/main/resources/Config.Properties");
    FileInputStream fs = new FileInputStream(file);
    public Properties property;

    public PropertyReaders() throws IOException {
        property = new Properties();
        property.load(fs);
    }
    public String getSwagLab_Url(){
        return property.getProperty("SwagLab_Url");
    }
    public String getMortgageCal_Url(){
        return property.getProperty("MortgageCal_Url");

    }
    public String getBlazeDemo_Url(){
        return property.getProperty("BlazeDemo_Url");
    }
    public String getAutoExercise_Url(){
        return property.getProperty("AutoExercise_Url");
    }
    public String getLambdaTest_Url(){
        return property.getProperty("LambdaTest_Url");
    }
    public String getNewTour_Url(){
        return property.getProperty("NewTour_Url");
    }
    public String getNopCommerce_Url(){
        return property.getProperty("NopCommerce_Url");
    }
    public String getUKBA_Url(){
        return property.getProperty("UKBA_Url");
    }
    public String getDEMOQA_Url() {
        return property.getProperty("DEMOQA_Url");
    }
    public String getFullName(){
        return property.getProperty("FullName");
    }
    public String getLastName(){
        return property.getProperty("odeleye");
    }
    public String getPostCode(){
        return property.getProperty("k32");
    }

}
