package Classes;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class Style {
    public static void changeColorOnHover(Pane pane, String colorOnEnter, String colorOnLeave){
        pane.setOnMouseEntered(evt -> {
            pane.setBackground(Background.fill(Color.web(colorOnEnter)));
        });
        pane.setOnMouseExited(evt -> {
            pane.setBackground(Background.fill(Color.web(colorOnLeave)));
        });
    }
    public static void changeColorOnHover(Button button,String backgroundColorOnEnter,String backgroundColorOnLeave,String textColorOnEnter,String textColorOnLeave){
        button.setOnMouseEntered(event -> {
            button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s; -fx-border-color:%s; -fx-border-width: 0 0 0 1;",backgroundColorOnEnter,textColorOnEnter,textColorOnEnter));
        });
        button.setOnMouseExited(event -> {
            button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s;-fx-border-color:%s; -fx-border-width: 0 0 0 0;",backgroundColorOnLeave,textColorOnLeave,textColorOnEnter));

        });
    }
    public static void transition(Pane pane,Double duration){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration),pane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
    public static void transition(Label label,Double duration){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration),label);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
}
