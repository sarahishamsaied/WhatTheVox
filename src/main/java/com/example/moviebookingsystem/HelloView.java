package com.example.moviebookingsystem;

<<<<<<<< HEAD:src/main/java/com/example/moviebookingsystem/HelloView.java
public class HelloView {
}
========
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MoviesForm {
    @FXML
    private Button ComingSoonButton;

    @FXML
    private Button PlayingNowButton;

    @FXML
    private Button TrendingButton;

    @FXML
    private Pane PlayingNowPage;

   @FXML
   private Pane CategoryPage;

   @FXML
   private Pane TrendingPage;

    @FXML
    private Pane comingSoonPage;
    @FXML
    private MenuButton CategoryMenu;

    @FXML
    void onNavClick(ActionEvent event) {
        if (event.getSource()==ComingSoonButton){
            comingSoonPage.toFront();
        }
        if (event.getSource()==PlayingNowButton){
            PlayingNowPage.toFront();
        }
        if (event.getSource()==TrendingButton){
            TrendingPage.toFront();
        }
        if (event.getSource()==CategoryMenu){
            CategoryPage.toFront();
        }



    }
}
>>>>>>>> 56139b162cd970da65ac5143a94aefd0c7727ebc:src/main/java/com/example/moviebookingsystem/MoviesForm.java
