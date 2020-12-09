package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.TeamMember;
import dk.colourit.model.TeamMemberList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class CreateProjectPopUpController extends Controller
{

	@FXML private TextField projectName;
	@FXML private DatePicker startDate;
	@FXML private DatePicker deadLine;

	@FXML private ComboBox<TeamMember> selectMember;
	@FXML private Button addMember;
	@FXML private Button confirm;
	@FXML private Button reject;

	@FXML public Label statusLabel;

	@Override public void init()
	{

		selectMember.getItems().addAll(ColourItGui.getModel().getTeamMemberList().getTeamMembers());

	}

	@Override public void goBack()
	{

	}

	public void confirmCreateProject()
	{
		String projectName = this.projectName.getText();
		LocalDate startDate = this.startDate.getValue();
		LocalDate deadLine = this.deadLine.getValue();
		try
		{
			ColourItGui.getModel().createProject(projectName, new MyDate(startDate), new MyDate(deadLine));
			statusLabel.setText("Project Created");
			statusLabel.setTextFill(Color.web("#22DD33"));
			getParentController().init();
		}
		catch (RuntimeException e)
		{
			statusLabel.setText("Project Creation Failed");
			statusLabel.setTextFill(Color.web("#FF3344"));
		}



	}

	public void closePopUp()
	{
		// Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
		((Stage) confirm.getScene().getWindow()).close();
	}





  /*
  Mangler noget til TableView
  De 3 kolloner
  Name
  ID
  Role
  */

}
