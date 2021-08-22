package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static java.lang.Math.*;

public class Lab5B extends Application {

    private final static double f1 = 100;//HZ
    private final static double f2 = 110;//HZ

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    public static double Q1B(double t){
        return 2*cos(2* PI*(((f1-f2)/2)*t))*cos(2* PI*(((f1+f2)/2)*t));
    }

    private void init(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 450, 330);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("x");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("f(x)");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("f(x) vs x");
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        int dataLength = 0;
        for (double i = -0.15; i <=0.15&&i>=-0.15;i=i+0.01) {
            dataLength = dataLength+1;
        }
        double[] x = new double[dataLength];
        int index = 0;
        for (double i = -0.15; i <=0.15&&i>=-0.15;i=i+0.01) {
            x[index] = i;
            index++;
        }

        double[] f = new double[x.length];
        for (int i = 0; i <x.length ; i++) {
            f[i] = Q1B(x[i]);
        }
        for (int i = 0; i <x.length ; i++) {
            String xValue = String.valueOf(i);
            data.getData().add(new XYChart.Data<String, Number>(xValue, f[i]));
        }

        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
