package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button calculate;
    @FXML
    public TextField minCountOfOperator;
    @FXML
    public TextField callsPerHour;
    @FXML
    public TextField avgTimeConversation;
    @FXML
    public Label result;
    @FXML
    void initialize(){
        calculate.setOnAction(event->{
            if(avgTimeConversation.getText().equals("")){
                result.setText("Введите среднее время разговора оператора с клиентом.");
            }
            else {
                if(!callsPerHour.getText().equals("")) {
                    if (!minCountOfOperator.getText().equals("")) {
                        if (Integer.parseInt(avgTimeConversation.getText()) <= 5) {
                            if (Integer.parseInt(callsPerHour.getText()) <= 10) {
                                result.setText(minCountOfOperator.getText());
                            } else {
                                if (Integer.parseInt(callsPerHour.getText()) > 10) {
                                    if (Integer.parseInt(callsPerHour.getText()) < 30) {
                                        result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 2));
                                    } else {
                                        result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 3));
                                    }
                                } else {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 2));
                                }
                            }
                        } else {
                            if (Integer.parseInt(callsPerHour.getText()) <= 10) {
                                result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 1.2));
                            } else {
                                if (Integer.parseInt(callsPerHour.getText()) > 10 && Integer.parseInt(callsPerHour.getText()) < 30) {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 2 * 1.2));
                                } else {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfOperator.getText()) * 3 * 1.2));
                                }
                            }
                        }
                    }
                    else {
                        result.setText("Введите минимальное количество операторов.");
                    }
                }
                else {
                    result.setText("Введите количество звонков в час.");
                }
            }
        });
    }
}
