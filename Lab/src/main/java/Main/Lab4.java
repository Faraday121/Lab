package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab4 extends Application{
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }
    private void init(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 450, 330);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("time");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Velocity");
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Velocity vs time");
        XYChart.Series<String, Number> data = new XYChart.Series<>();

//        for (int i = 0; i <10 ; i++) {
//            String xValue = String.valueOf(i);
//            data.getData().add(new XYChart.Data<String, Number>(xValue, 60-i*9.8));
//        }

        for (int i = 0; i <20 ; i++) {
            String xValue = String.valueOf(i);
            data.getData().add(new XYChart.Data<String, Number>(xValue, 60*i-0.5*9.8*i*i+100));
        }

        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
