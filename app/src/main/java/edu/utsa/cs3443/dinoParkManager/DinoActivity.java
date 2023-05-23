package edu.utsa.cs3443.dinoParkManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import edu.utsa.cs3443.dinoParkManager.controller.DinoController;
import edu.utsa.cs3443.dinoParkManager.controller.ZoneController;

/**
 * DinoActivity class displays the relocate dino screen
 * @author Andres Tostado (wvm376)
 */
public class DinoActivity extends AppCompatActivity {

    DinoController controller;

    /**
     * Method called when view is created
     * @param savedInstanceState returns to a previous state (Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);
        controller = new DinoController(this);
        controller.setScreen(ZoneController.getZoneName(getIntent()));
        setupButton(R.id.buttonRelo);
        setupButton(R.id.buttonMap);
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