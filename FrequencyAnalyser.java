import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ass1FINAL extends Application{
    public static void main(String args[]) throws IOException {

        Application.launch(args);
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    
        stage.setTitle("Frequency of each letter in text file");
        
        int[] myfrequencies = array();
        
        CategoryAxis xAxis = new CategoryAxis();  
        xAxis.setLabel("Alphabet");
       
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Frequencies");
     
        //Creating the Bar chart
        BarChart barChart = new BarChart(xAxis, yAxis);
        barChart.setStyle("-fx-background-color: rgba(0,168,355,0.05);-fx-background-radius: 10;");
        
      
        XYChart.Series series1 = new XYChart.Series();
        
        series1.setName("Letters");
        
        int mycounter = 0;
        
        for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            mycounter ++;
            series1.getData().add(new XYChart.Data<>(String.valueOf(alphabet), myfrequencies[mycounter]));
        }
        
        //Setting the data to bar chart       
        barChart.getData().add(series1);
        
        VBox box = new VBox(barChart);

        Scene myScene = new Scene(box,300, 150);

        stage.setScene(myScene);
        stage.setHeight(500);
        stage.setWidth(1000);

        stage.show();

    
    }
  
    
  
  
  public int[] array() throws Exception{
  
        File file = new File("/home/cim/ug/zhac291/javaProgramming/ass1/jc.txt");
        
        FileReader filereader = new FileReader(file);
        BufferedReader bufferreader = new BufferedReader(filereader);  
        
        String mystring;
        int nooflines = 0;
        
        while ((mystring=bufferreader.readLine()) != null) {
            nooflines +=1;
        }
        System.out.println("Number of Lines: " + nooflines);
        
        
        FileReader filereader2 = new FileReader(file);
        BufferedReader bufferreader2 = new BufferedReader(filereader2);
        
        int[] frequencies;
        frequencies = new int[28]; 
        
        for(int i=0;i<frequencies.length;i++) {
            frequencies[i] = 0;
        }
        
        int c = 0; 
        while((c = bufferreader2.read()) != -1) {
                char character = Character.toLowerCase((char)c);       
                if(Character.isLetter(character)) {
                    int int2 = (int)character - 97;
                    frequencies[int2+1] +=1;
                }
                
                else {
                    frequencies[27] +=1;
                }
        }
        
        
        int counter = 0;
        
        for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            counter ++;
            System.out.println(frequencies[counter] + " " + alphabet);
        }
        
        System.out.println(frequencies[27] + " Other Characters");
        
        return frequencies;
  
  
  
  
  }
  
}
        
        
        
        
        
        
        
        
        
