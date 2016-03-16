package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar;
	private Button btSair;
	private static Stage stage;

	private void inicializaComponentes() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		txLogin = new TextField();
		txLogin.setPromptText("Digite aqui seu login");
		txSenha = new PasswordField();
		txSenha.setPromptText("Digite aqui sua senha");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
	}

	private void posicionaElementos() {
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(200);
	}

	// inicia a construÁ„o da tela

	@Override
	public void start(Stage stage) throws Exception {
		LoginApp.stage = stage;
		inicializaComponentes();

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		posicionaElementos();

		// define lugar de botoes ou textos

		// btSair.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// System.exit(0);
		//
		// }
		// });

		// Sair.setOnAction(e -> System.exit(0));
	}

	private void sair() {
		System.exit(0);
	}

	// private void Entrar() {
	// if ("123456".equals(txSenha.getText()) &&
	// "alunos".equals(txLogin.getText())) {
	// JOptionPane.showMessageDialog(null, "Acertou Miseravi", "Login",
	// JOptionPane.INFORMATION_MESSAGE);

	// } else {
	// JOptionPane.showMessageDialog(null, "ERROU", "Login",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// }

	private void entrar() {
		if ("123456".equals(txSenha.getText()) && "alunos".equals(txLogin.getText())) {
			Alert alert = new Alert(AlertType.INFORMATION, "Login realizado", ButtonType.CLOSE);
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Usu√°rio ou seja inv√°lido", ButtonType.CLOSE);
			alert.show();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
