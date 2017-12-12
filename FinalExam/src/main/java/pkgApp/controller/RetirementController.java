package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;

	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private Label amountToSaveLabel;
	@FXML
	private Label totalAmountSavedLabel;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		txtYearsToWork.clear();
		txtAnnualReturnWorking.clear();
		txtYearsRetired.clear();
		txtAnnualReturnRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
		amountToSaveLabel.setText("...");
		totalAmountSavedLabel.setText("...");
		// TODO: Clear all the text inputs
	}

	@FXML
	public void btnCalculate(ActionEvent event) {
		if (isValid()) {
		Retirement r = new Retirement(Integer.parseInt(txtYearsToWork.getText()),
				Double.parseDouble(txtAnnualReturnWorking.getText()), Integer.parseInt(txtYearsRetired.getText()),
				Double.parseDouble(txtAnnualReturnRetired.getText()), Double.parseDouble(txtRequiredIncome.getText()),
				Double.parseDouble(txtMonthlySSI.getText()));
		amountToSaveLabel.setText("$" + Double.toString(r.AmountToSave()));
		totalAmountSavedLabel.setText("$" + Double.toString(r.TotalAmountSaved()));
		System.out.println(r.AmountToSave());
		System.out.println(r.TotalAmountSaved());
		// TODO: Call AmountToSave and TotalAmountSaved and populate
		}
	}

	private boolean isValid() {
		String errorMessage = "";
		if (txtYearsToWork.getText() == null || txtYearsToWork.getText().length() == 0) {
			errorMessage += "invalid years to work field\n";
		} else {

			try {
				Integer.parseInt(txtYearsToWork.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid years to work field (must be an integer)\n";
			}
		}
		if (txtAnnualReturnWorking.getText() == null || txtAnnualReturnWorking.getText().length() == 0) {
			errorMessage += "invalid annual return working\n";
		} else {
			try {
				Double.parseDouble(txtAnnualReturnWorking.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid annual return working field (must be a decimal less than 1)!\n";
			}
		}
		if (txtYearsRetired.getText() == null || txtYearsRetired.getText().length() == 0) {
			errorMessage += "invalid years retired\n";
		} else {

			try {
				Integer.parseInt(txtYearsRetired.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid years retired field (must be an integer)\n";
			}
		}
		if (txtAnnualReturnRetired.getText() == null || txtAnnualReturnRetired.getText().length() == 0) {
			errorMessage += "invalid annual return retired\n";
		} else {
			try {
				Double.parseDouble(txtAnnualReturnRetired.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid annual return retired field (must be a decimal less than 1)!\n";
			}
		}
		if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() == 0) {
			errorMessage += "invalid required income field\n";
		} else {
			try {
				Double.parseDouble(txtRequiredIncome.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid required income field (must be a number)\n";
			}
		}
		if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() == 0) {
			errorMessage += "invalid monthly SSI field\n";
		} else {
			try {
				Double.parseDouble(txtMonthlySSI.getText());
			} catch (NumberFormatException e) {
				errorMessage += "invalid Monthly SSI field (must be a number)\n";
			}
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
		}
	}
}
