import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0 ;
    private boolean arrayFilled = false ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       AnchorPane root= new AnchorPane();
        primaryStage.setTitle("Hello World");

        Rectangle r = new Rectangle(20, 20, Color.BLACK);
        r.setX(10);k
        r.setY(15);
        r.setWidth(20);
        r.setHeight(10);

        Label frames = new Label("FFFljkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkDFDF");

        AnimationTimer frameRate = new AnimationTimer() {
            @Override
            public void handle(long l) {


                r.setRotate(r.getRotate() + 1);
                long oldFrameTime =frameTimes[frameTimeIndex];
                frameTimes[frameTimeIndex]= l;
                frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
                if (frameTimeIndex == 0) {
                    arrayFilled = true ;
                }
                if (arrayFilled) {
                    long elapsedNanos = l - oldFrameTime;
                    long elapsedNanosPerFrame = elapsedNanos / 100;//frameTimes.length;
                    double frameRate = 1_000_000_000.0 / elapsedNanosPerFrame;
                    frames.setText(String.format("Current frame rate: %.3f", frameRate));
                    System.out.println(l);

                }

            }
        };


        frameRate.start();


        

       root.getChildren().addAll(frames,r);
        Scene scene = new Scene(root, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
