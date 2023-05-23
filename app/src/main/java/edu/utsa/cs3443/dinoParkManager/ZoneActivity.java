package edu.utsa.cs3443.dinoParkManager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import edu.utsa.cs3443.dinoParkManager.controller.MainController;
import edu.utsa.cs3443.dinoParkManager.controller.ZoneController;

/**
 * ZoneActivity class that displays dino info on screen
 * @author Andres Tostado (wvm376)
 */
public class ZoneActivity extends AppCompatActivity {

    ZoneController controller;

    /**
     * Method called when view is created
     * @param savedInstanceState goes back to a previous state (Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        controller = new ZoneController(this);
        setupButton(R.id.buttonZoneR);
        controller.getZoneInfo(MainController.getZoneName(getIntent()));
    }

    /**
     * Method called when screen is not current (screen paused)
     */
    @Override
    protected void onPause(){
        super.onPause();
    }

    /**
     * Method called when screen is active again, displays updated info
     */
    @Override
    protected void onResume(){
        super.onResume();
        controller.getZoneInfo(MainController.getZoneName(getIntent()));
    }

    /**
     * Sets up buttons on screen
     * @param buttonID ID for button (int)
     */
    private void setupButton(int buttonID) {
        Button button = findViewById(buttonID);
        button.setOnClickListener(controller);
    }
}