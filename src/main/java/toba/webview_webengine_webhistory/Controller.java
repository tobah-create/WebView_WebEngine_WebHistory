package toba.webview_webengine_webhistory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private Hyperlink hlBackward;
    @FXML
    private Hyperlink hlForward;
    @FXML
    private Hyperlink hlReload;
    @FXML
    private Hyperlink hlHome;
    @FXML
    private TextField tfSearch;
    @FXML
    private Hyperlink hlSearch;
    @FXML
    private Hyperlink hlZoomIn;
    @FXML
    private Hyperlink hlZoomOut;
    @FXML
    private Hyperlink hlFontPlus;
    @FXML
    private Hyperlink hlFontMinus;
    @FXML
    private Hyperlink hlAbout;
    @FXML
    private Hyperlink hlYouTube;
    @FXML
    private WebEngine webEngine;

    public void handleBackward(ActionEvent actionEvent) {
    }

    public void handleForward(ActionEvent actionEvent) {
    }

    public void handleReload(ActionEvent actionEvent) {
    }

    public void handleHome(ActionEvent actionEvent) {
    }

    public void handleSearch(ActionEvent actionEvent) {
        hlSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                webEngine.load(tfSearch.getText());
            }
        });
    }

    public void handleZoomIn(ActionEvent actionEvent) {
    }

    public void handleZoomOut(ActionEvent actionEvent) {
    }

    public void handleFontPlus(ActionEvent actionEvent) {
    }

    public void handleFontMinus(ActionEvent actionEvent) {
    }

    public void handleAbout(ActionEvent actionEvent) {
    }

    public void handleYouTube(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // To create the webEngine
        WebEngine webEngine = webView.getEngine();
        // To load the webEngine
        webEngine.load("https://www.google.com");
        // To create a webHistory
        WebHistory webHistory = webEngine.getHistory();
        // To set HTTP header
        System.out.println(webEngine.getUserAgent());
        webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/613.1 (KHTML, like Gecko) JavaFX/19 Safari/613.1");
        // To reload the page
        hlReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                webEngine.reload();
            }
        });
        // Home page
        hlHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                webEngine.load("https://www.google.com");
            }
        });
        // Search page/link
        hlSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                webEngine.load(tfSearch.getText());
            }
        });
        // To zoom in
        hlZoomIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double size = 1.0;
                size = webView.getZoom() + 0.1;
                webView.setZoom(size);
            }
        });
        // To zoom out
        hlZoomOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double size = 1.0;
                size = webView.getZoom() - 0.1;
                webView.setZoom(size);
            }
        });
        // To size font upwards
        hlFontPlus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double size = 1.0;
                size = webView.getFontScale() + 0.1;
                webView.setFontScale(size);
            }
        });
        // To size font downwards
        hlFontMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double size = 1.0;
                size = webView.getFontScale() - 0.1;
                webView.setFontScale(size);
            }
        });
        // To display contents
        hlAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String content = "This is about us ...";
                webEngine.loadContent(content, "text/html");
            }
        });
        // To move forward
        hlForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                webHistory.go(+1);
            }
        });
        // To move backwards
        hlBackward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                webHistory.go(-1);
                webEngine.executeScript("history.back()");
            }
        });
        // To navigate to YouTube
        hlYouTube.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String script = "window.location=\"https://www.youtube.com\"";
                webEngine.executeScript(script);
            }
        });
    }
}