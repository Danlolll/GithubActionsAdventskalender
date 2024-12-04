package htl.steyr.githubactionsadventskalender;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdventskalenderApplication extends Application {
    private static final String[] SPRUECHE = {
            "Heute ist ein schöner Tag!",
            "Ein Lächeln kostet nichts, bringt aber viel.",
            "Genieße den Moment!",
            "Weihnachten ist das Fest der Freude.",
            "Ein bisschen Liebe macht alles besser.",
            "Advent, Advent, ein Lichtlein brennt!",
            "Freue dich auf Weihnachten!",
            "Ein kleines Wunder wartet hinter jeder Ecke.",
            "Teilen macht glücklich.",
            "Besinnlichkeit und Frieden - das ist Advent.",
            "Heute duftet es nach Plätzchen!",
            "Ein Weihnachtsbaum ohne Stress – perfekt!",
            "Gönn dir eine heiße Schokolade.",
            "Schneeflocken tanzen in der Luft.",
            "Freunde machen den Advent besonders.",
            "Kerzenlicht bringt Wärme in die Herzen.",
            "Wunschzettel schreiben macht Spaß!",
            "Eine Umarmung macht alles besser.",
            "Es sind die kleinen Dinge, die zählen.",
            "Träume von einer weißen Weihnacht!",
            "Weihnachten ist, wenn Herzen leuchten.",
            "Der Duft von Zimt erfüllt den Raum.",
            "Hoffnung liegt in der Luft.",
            "Fröhliche Weihnachten!:)"
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // GridPane mit weihnachtlicher Optik
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setStyle("-fx-background-color: linear-gradient(to bottom, #ffcccc, #ff6666);");

        // Buttons für die Türchen
        for (int i = 0; i < 24; i++) {
            int day = i + 1; // Tage von 1 bis 24
            Button button = new Button("🎄 Tür " + day + " 🎄");
            button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
            button.setTextFill(Color.DARKGREEN);
            button.setStyle("-fx-background-color: #ffe680; -fx-border-color: #cc6600; -fx-border-width: 2px;");
            button.setPrefSize(150, 75);
            button.setOnAction(e -> showSpruch(day));
            grid.add(button, i % 6, i / 6); // 6 Spalten, mehrere Reihen
        }

        // Szene und Fenster
        Scene scene = new Scene(grid, 900, 600);
        primaryStage.setTitle("🎅 Weihnachts-Adventskalender 🎅");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showSpruch(int day) {
        // Festliche Nachricht
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("🎄 Adventskalender - Tür " + day + " 🎄");
        alert.setHeaderText("Spruch für den " + day + ". Dezember");
        alert.setContentText(SPRUECHE[day - 1]);
        alert.getDialogPane().setStyle("-fx-background-color: #ffcc99; -fx-font-family: 'Comic Sans MS';");
        alert.showAndWait();
    }
}