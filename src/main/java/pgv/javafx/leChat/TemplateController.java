package pgv.javafx.leChat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class TemplateController implements Initializable {
	
	@FXML
	private static BorderPane view;

    @FXML
    private TextField mensajeText;

    @FXML
    private TextField chatText;

    @FXML
    private Button enviarButton;

    @FXML
    private Button salirButton;

    @FXML
    private ListView<String> listaClientes;

	
	public TemplateController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/leChat.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public BorderPane getView() {
		return view;
	}

}
