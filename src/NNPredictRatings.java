import org.codehaus.jackson.map.ObjectMapper;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

public class NNPredictRatings {

    public double sigmoid(double x){
        return 1/(1+Math.pow(Math.E,(-1*x)));
    }

    public static void main(String[] args){

        ObjectMapper oMap = new ObjectMapper();
        File movieDb = new File("./MovieNNDataset.json");

        try{
            BufferedReader br = new BufferedReader(new FileReader(movieDb));
            JsonReader jsonReader = Json.createReader(br);
            JsonArray movieArray = jsonReader.readArray();
            for(int i = 0; i < movieArray.size(); i++){
                Movie movie = oMap.readValue(movieArray.getJsonObject(i).toString(), Movie.class);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

