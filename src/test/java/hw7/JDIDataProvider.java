package hw7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.*;

public class JDIDataProvider {

    public static final String path = "src\\test\\resources\\hw7\\ex8_jdi_metalsColorsDataSet.json";

    @DataProvider(name = "testDataset")
    public Object[] getData (){
        Map<String, MetalsAndColorsData> dataMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            dataMap = mapper.readValue(new File(path), new TypeReference<Map<String, MetalsAndColorsData>>(){});
        } catch (Exception e){
            e.printStackTrace();
        }
        List<MetalsAndColorsData> testData = new ArrayList<>(dataMap.values());
        return testData.toArray();
    }
}
