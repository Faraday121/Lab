package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab5C extends Application {
    private final static double g = 9.8 ;
    private final static double height = 500;
    private final static double mass = 0.03;
    private final static double initialVelocity = 0;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    public static double Distance(double v ,double t){
        return height+initialVelocity*t-0.5*g*t*t;
    }

    public static double Velocity(double t){
        return initialVelocity-g*t;
    }


    private void init(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 450, 330);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("time");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("f(x)");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("f(x) vs time");
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        int dataLength = 0;
        for (double i = 0; i <=20&&i>=0;i=i+0.1) {
            dataLength = dataLength+1;
        }
        double[] time = new double[dataLength];
        int index = 0;
        for (double i = 0; i <=20&&i>=0;i=i+0.1) {
            time[index] = i;
            index++;
        }

        double[] velocity = new double[time.length];
        for (int i = 0; i <time.length ; i++) {
            velocity[i] = Velocity(time[i]);
        }
        double[] distance = new double[time.length];
        for (int i = 0; i <time.length ; i++) {
            distance[i] = Distance(velocity[i],time[i]);
        }

        for (int i = 0; i <time.length ; i++) {
            String xValue = String.valueOf(i);
            data.getData().add(new XYChart.Data<String, Number>(xValue, distance[i]));
        }

        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
