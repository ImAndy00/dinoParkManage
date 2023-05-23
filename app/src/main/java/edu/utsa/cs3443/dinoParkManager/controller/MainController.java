package edu.utsa.cs3443.dinoParkManager.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.dinoParkManager.ZoneActivity;

/**
 * MainController class is the controller for MainActivity
 * @author Andres Tostado
 */
public class MainController implements View.OnClickListener {
    Activity activity;
    AssetManager manager;
    private static String key = "Zone_Name";

    /**
     * Constructor for MainController
     * @param activity Screen/App activity (Activity)
     */
    public MainController(Activity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
    }

    /**
     * Method called when a button is clicked, goes to next screen
     * @param view current screen view (View)
     */
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent = new Intent(activity, ZoneActivity.class);
        intent.putExtra(key, clickedButton.getText().toString());
        activity.startActivity(intent);

    }

    /**
     * Creates a copy of original file that will be edited, only occurs at start of app
     * @param firstRun tells if this is first time running method (boolean)
     * @throws IOException throws if IO error
     */
    public void createCpy(boolean firstRun) throws IOException {
        InputStream in;
        OutputStream out;
        Scanner scan;
        String line;
        ArrayList<String> lines = new ArrayList<>();
        if(firstRun) {
            in = manager.open("dinos.csv");
            scan = new Scanner(in);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                line = line + "\n";
                lines.add(line);
            }
            in.close();
            scan.close();
            out = activity.openFileOutput("dinos.csv", Context.MODE_PRIVATE);
            for (int i = 0; i < lines.size(); i++) {
                out.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }
            out.close();
        }
    }

    /**
     * Gets the zone name from button clicked
     * @param intent Intent that has extra key (Intent)
     * @return key (String)
     */
    public static String getZoneName(Intent intent){
        return intent.getStringExtra(key);
    }

}
