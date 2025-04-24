package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField display;

    // Variáveis para armazenar o operador selecionado.
    private String operador = "";
    private double num1 = 0;
    private boolean novoNumero = true;

 	// Método acionado ao clicar em um número.
    @FXML
    private void handleNumero(javafx.event.ActionEvent event) {
        String valor = ((Button) event.getSource()).getText();
     // Verifica se é um novo número ou um número a ser concatenado.
        if (novoNumero) {
            display.setText(valor);
            novoNumero = false;
        } else {
            display.setText(display.getText() + valor);
        }
    }
    
    // Método acionado ao clicar em um operador.
    @FXML
    private void handleOperador(javafx.event.ActionEvent event) {
        operador = ((Button) event.getSource()).getText();
        num1 = Double.parseDouble(display.getText());
        novoNumero = true;
    }
    
 // Método acionado ao clicar no botão "=" para calcular o resultado.
    @FXML
    private void handleResultado() {
        double num2 = Double.parseDouble(display.getText());
        double resultado = 0;
        
        // Realiza o cálculo de acordo com o operador selecionado.
        switch (operador) {
            case "+": resultado = num1 + num2; break;
            case "-": resultado = num1 - num2; break;
            case "×": resultado = num1 * num2; break;
            case "÷": resultado = num2 != 0 ? num1 / num2 : 0; break;
        }

        display.setText(String.valueOf(resultado));
        novoNumero = true;
    }
    
    // Método acionado ao clicar no botão "C" para limpar o display e resetar a calculadora.
    @FXML
    private void handleClear() {
        display.setText("0");
        operador = "";
        num1 = 0;
        novoNumero = true;
    }
}
