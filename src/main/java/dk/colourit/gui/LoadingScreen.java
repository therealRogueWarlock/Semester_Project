package dk.colourit.gui;

import java.io.IOException;

public class LoadingScreen extends Controller {

	@Override
	public void init( ) {

	}

	public void swapScreen() throws IOException {
		ColourItGui.setRoot("loginScreen");
	}

	@Override
	public void goBack( ) throws IOException {

	}
}
