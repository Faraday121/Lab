package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab5A extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
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
        for (double i = -2; i <=2&&i>=-2;i=i+0.1) {
            dataLength = dataLength+1;
        }
        double[] x = new double[dataLength];
        int index = 0;
        for (double i = -2; i <=2&&i>=-2;i=i+0.1) {
            x[index] = i;
            index++;
        }
        double[] f = new double[dataLength];
        for (int i = 0; i <dataLength ; i++) {
            f[i] = Q1A(x[i]);
        }

        for (int i = 0; i <dataLength ; i++) {
            String xValue = String.valueOf(i);
            data.getData().add(new XYChart.Data<String, Number>(xValue, f[i]));
        }

        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static double Q1A(double x){
        return 3.0+3.2*x+2.0*x*x-5.0*x*x*x;
    }
}
