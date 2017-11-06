import org.codehaus.jackson.map.ObjectMapper;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.Perceptron;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.*;

public class NNTrainAndCompare {

    private static double sigmoid(double x){
        return (1/(1 + Math.pow(Math.E,(-1*x))));
    }

    public static void main(String[] args){

        File movieDbTrain = new File("./MovieNNTrainDataset.json");
        File movieDvCompare = new File("./MovieNNDatasetCompare.json");
        NeuralNetwork nn = new Perceptron(2, 1);
        TrainNetwork(nn, movieDbTrain);
        Double errorAmount = CompareNetwork(nn, movieDvCompare);
        System.out.println(errorAmount);

        return;
    }

    private static void TrainNetwork(NeuralNetwork nn, File db){
        try{
            DataSet trainSet = new DataSet(2,1);
            ObjectMapper oMap = new ObjectMapper();
            BufferedReader br = new BufferedReader(new FileReader(db));
            JsonReader jsonReader = Json.createReader(br);
            JsonArray movieArray = jsonReader.readArray();
            for(int i = 0; i < movieArray.size(); i++){
                Movie movie = oMap.readValue(movieArray.getJsonObject(i).toString(), Movie.class);
                double budget = sigmoid(movie.getBudget());
                double revenue = sigmoid(movie.getRevenue());
                double voteAverage = sigmoid(movie.getVote_average());
                trainSet.addRow(new double[]{budget, revenue},
                        new double[]{voteAverage});
            }
            nn.learn(trainSet);
            nn.save("./userScore_perceptron.nnet");

        }catch (IOException e){
            e.printStackTrace();
        }
        return;
    }

    private static double CompareNetwork(NeuralNetwork nn, File db){
        double errorAverage = 0;
        try{
            ObjectMapper oMap = new ObjectMapper();
            BufferedReader br = new BufferedReader(new FileReader(db));
            JsonReader jsonReader = Json.createReader(br);
            JsonArray movieArray = jsonReader.readArray();
            for(int i = 0; i < movieArray.size(); i++){
                Movie movie = oMap.readValue(movieArray.getJsonObject(i).toString(), Movie.class);
                double budget = sigmoid(movie.getBudget());
                double revenue = sigmoid(movie.getRevenue());
                double voteAverage = sigmoid(movie.getVote_average());
                nn.setInput(budget, revenue);
                nn.calculate();
                errorAverage += nn.getOutput()[0];
            }
            errorAverage = errorAverage / movieArray.size();

        }catch (IOException e){
            e.printStackTrace();
        }

        return errorAverage;
    }
}

