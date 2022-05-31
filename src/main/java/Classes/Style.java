package Classes;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Style {
    public static void changePaneColorOnHover(Pane pane, String colorOnEnter, String colorOnLeave){
        pane.setOnMouseEntered(evt -> {
            pane.setBackground(Background.fill(Color.web(colorOnEnter)));
        });
        pane.setOnMouseExited(evt -> {
            pane.setBackground(Background.fill(Color.web(colorOnLeave)));
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
