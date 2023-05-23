package edu.utsa.cs3443.dinoParkManager.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.utsa.cs3443.dinoParkManager.DinoActivity;
import edu.utsa.cs3443.dinoParkManager.R;
import edu.utsa.cs3443.dinoParkManager.model.Dinosaur;
import edu.utsa.cs3443.dinoParkManager.model.Park;
import edu.utsa.cs3443.dinoParkManager.model.Zone;

/**
 * ZoneController class is controller for ZoneActivity
 * @author Andres Tostado
 */
public class ZoneController implements View.OnClickListener {

    Activity activity;
    AssetManager manager;
    Park park;
    Zone zone;
    ArrayList<Dinosaur> dinosaurss;
    private static String key = "Zone_Name";

    /**
     * Constructor for ZoneController
     * @param activity activity on screen (Activity)
     */
    public ZoneController(Activity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
    }

    /**
     * Method called when relocate button is clicked
     * @param view view of screen (View)
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, DinoActivity.class);
        TextView zoneTxt = (TextView) activity.findViewById(R.id.textViewZone);
        String zone = zoneTxt.getText().toString();
        intent.putExtra(key, zone);
        activity.startActivity(intent);
    }

    /**
     * Get the zone name from key
     * @param intent intent that holds extra key
     * @return key (String)
     */
    public static String getZoneName(Intent intent){
        return intent.getStringExtra(key);
    }


    /**
     * Adds a TextView to the screen
     * @param textView TextView object to be added (TextView)
     * @param width Max width of the text (int)
     * @param height Max height of the text (int)
     * @param marginTop The distance between the top of the screen and the text (int)
     */
    public void addText(TextView textView, int width, int height, int marginTop) {
        RelativeLayout relativeLayout = activity.findViewById(R.id.RelativeLayoutScroll);
        RelativeLayout.LayoutParams paramaters = new RelativeLayout.LayoutParams(width, height);
        paramaters.setMargins(400, marginTop, 0, 10);
        textView.setLayoutParams(paramaters);
        relativeLayout.addView(textView);
    }


    /**
     * Adds an ImageView to the screen
     * @param imageView ImageView object to be added (ImageView)
     * @param width Width of image (int)
     * @param height Height of image (int)
     * @param marginTop Distance between the top of the screen and image (int)
     */
    public void addImage(ImageView imageView, int width, int height, int marginTop) {
        RelativeLayout relativeLayout = activity.findViewById(R.id.RelativeLayoutScroll);
        RelativeLayout.LayoutParams paramaters = new RelativeLayout.LayoutParams(width, height);
        paramaters.setMargins(50, marginTop, 0, 10);
        imageView.setLayoutParams(paramaters);
        relativeLayout.addView(imageView);
    }

    /**
     * Gets all zone info that will be printed on screen
     * @param zoneID the zone name (eg. B, TR, TY, etc) (String)
     */
    public void getZoneInfo(String zoneID) {
        displayZoneName(zoneID);
        displayDinosaurs(zoneID);
        displayPictures(zoneID);
    }

    /**
     * Displays the zone name as well as # of guests and dinos
     * @param zoneID zone name (String)
     */
    public void displayZoneName(String zoneID) {
        park = new Park();
        park.loadZones(manager, activity);
        zone = park.getZoneFromName(zoneID);
        int guests = zone.getNumGuests();
        int numberOfDinos = zone.getNumDinosZ();
        TextView tvTitle = (TextView) activity.findViewById(R.id.textViewZone);
        tvTitle.setText("Zone " + zoneID);
        TextView tvTitle2 = (TextView) activity.findViewById(R.id.textViewGuests);
        tvTitle2.setText("# of guests: " + guests);
        TextView tvTitle3 = (TextView) activity.findViewById(R.id.textViewDinos);
        tvTitle3.setText("# of dinos: " + numberOfDinos);
    }

    /**
     * Displays the picture for each dino in a zone
     * @param zoneID zone name (String)
     */
    public void displayPictures(String zoneID) {
        park = new Park();
        park.loadZones(manager, activity);
        zone = park.getZoneFromName(zoneID);
        int numDinos = zone.getNumDinosZ();
        int i;
        int marginTop = 1000;
        dinosaurss = zone.getDinoArray();
        for (i = 0; i < numDinos; i++) {
            String dinoName = dinosaurss.get(i).getName();
            dinoName = dinoName.toLowerCase();
            ImageView imageView = new ImageView(activity);
            int imageResource = activity.getResources().getIdentifier(dinoName, "drawable", activity.getPackageName());
            imageView.setImageResource(imageResource);
            addImage(imageView, 300, 350, marginTop);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY); //Sets the image to fit width and height no matter the size of image
            marginTop = marginTop + 375; //Adds to margin so images arent placed on top of each other
        }
    }

    /**
     * Displays dino name, type, and if carnivore
     * @param zoneID zone name (String)
     */
    public void displayDinosaurs(String zoneID) {
        park = new Park();
        park.loadZones(manager, activity);
        zone = park.getZoneFromName(zoneID);
        int numTxts = zone.getNumDinosZ(); //Gets number of dinos to determine how many texts to add
        dinosaurss = zone.getDinoArray();
        String carn;
        int marginTopP = 1000; //Default marginTop of position
        int marginTopN = 1100; //Default marginTop of name
        for (int i = 0; i < numTxts; i++) {
            String name = dinosaurss.get(i).getName();
            if(dinosaurss.get(i).isVegetarian()){
                carn = "not carnivore";
            }else{
                carn = "carnivore";
            }
            String type = dinosaurss.get(i).getType() + ", " + carn;
            TextView positionName = new TextView(activity);
            TextView rankAndName = new TextView(activity);
            positionName.setText(name);
            rankAndName.setText((type));
            positionName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            rankAndName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            positionName.setTextColor(Color.WHITE);
            rankAndName.setTextColor(Color.WHITE);
            positionName.setTypeface(null, Typeface.BOLD);
            rankAndName.setTypeface(null, Typeface.BOLD_ITALIC);
            addText(positionName, 600, 300, marginTopP);
            addText(rankAndName, 800, 300, marginTopN);
            marginTopP = marginTopP + 375;
            marginTopN = marginTopN + 375;
        }
    }

}
