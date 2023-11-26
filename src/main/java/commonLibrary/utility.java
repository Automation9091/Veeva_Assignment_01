package commonLibrary;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;

public class utility extends browser{
    basePage page;

    public HashMap readYmlFile(String fileName) throws FileNotFoundException, YamlException {
        String ymlPath = System.getProperty("user.dir") + "/src/main/java/store/" + fileName;
        YamlReader reader = new YamlReader(new FileReader(ymlPath));
        Object obj = reader.read();
        HashMap map = (HashMap) obj;
        return map;
    }

    public HashMap<String, String> getNestedValue(HashMap yaml, String node){
        String[] arr = node.split("/");
        int cnt = arr.length;
        HashMap<String, String> map = new HashMap<>();
        HashMap ymlMap = yaml;
        for(int i=0; i < cnt; i++){
            map = (HashMap) ymlMap.get(arr[i]);
            ymlMap = map;
        }
        return map;
    }

    public String getValueFromYml(String envName, String appName, String fieldName) throws YamlException, FileNotFoundException {
        utility ut = new utility();
        HashMap<String, String> outPut;
        HashMap<String, String> hOut = ut.getNestedValue(ut.readYmlFile("staticData.yml"),
                "Apps/" + envName + "/" + appName);
        return hOut.get(fieldName);
    }


}
