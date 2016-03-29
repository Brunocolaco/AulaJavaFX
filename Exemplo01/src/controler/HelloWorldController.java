package controler;

import java.util.Optional;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloWorldController {

	@FXML
	private TextField tfTexto;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Label lblMsgSalvar;

	@FXML
	private TableView<String> tblNomes;

	@FXML
	private TableColumn<String, String> colNome;

	@FXML
	private void initialize() {
		colNome.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue()));
	}

	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente Excluir", ButtonType.CANCEL, ButtonType.OK);

		Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);

		final Optional<ButtonType> result = alerta.showAndWait();

		if (result.get() == ButtonType.OK) {
			int posicaotabela = tblNomes.getSelectionModel().getSelectedIndex();
			tblNomes.getItems().remove(posicaotabela);
			lblMsgSalvar.setText("Registro Excluido com Sucesso");
			lblMsgSalvar.getStyleClass().remove("msgSalvar");
			lblMsgSalvar.getStyleClass().add("msgExcluir");

		}

	}

	@FXML
	void salvar(ActionEvent event) {
		tfTexto.getText();
		String nome = tfTexto.getText();
		String msg = "Salvo com Sucesso o cadastro: ";
		lblMsgSalvar.setText(msg + nome);
		// PARA REMOVER A COR VERMELHA
		lblMsgSalvar.getStyleClass().remove("msgExcluir");
		lblMsgSalvar.getStyleClass().add("msgSalvar");

		tblNomes.getItems().add(nome);

	}

}
