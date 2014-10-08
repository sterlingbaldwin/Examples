package com.example.coursemanager;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Activity for handling events on activity_main for people to add a course
 * 
 * @author Kevin Buffardi
 * @author CSCI 430 students, fall 2014
 */

public class MainActivity extends Activity
{
	private final static int MAX_SEATS = 100;
	private final static int MIN_SEATS = 2;
	private Button buttonCreate;
	private EditText name;
	private EditText catalogID;
	private NumberPicker capacity;
	private TextView messages;
	private ArrayList <Course> catalog;
	

	/**
	 * TODO: commenting!
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        catalog = new ArrayList <Course>();
        name = (EditText) findViewById(R.id.editName);
        catalogID = (EditText) findViewById(R.id.editNumber);
        capacity = (NumberPicker) findViewById(R.id.numPickCapacity);
        capacity.setMinValue(MIN_SEATS);
        capacity.setMaxValue(MAX_SEATS);
        int def = MIN_SEATS != 0 ? MAX_SEATS/MIN_SEATS: 0;
        capacity.setValue(def);
        
        messages = (TextView) findViewById(R.id.textFeedback);
    }
    
	/**
	 * TODO: commenting!
	 */
    public void buttonCreatePressed(View view)
    {
	    	System.out.println("Button was pressed!");
	    	String feedback = "";
	    	
	    	if( name.getText().toString().isEmpty() )
	    	{
	    		feedback = "Title can't be empty!\n";
	    	}
	    	if( catalogID.getText().toString().isEmpty() )
	    	{
	    		feedback += "Catalog can't be empty!\n";
	    	}
	    	if( capacity.getValue() > MAX_SEATS || capacity.getValue() < MIN_SEATS )
	    	{
	    		feedback += "Seats must be between (" + MIN_SEATS + "-" + MAX_SEATS + ")\n";
	    	}
	    	if( feedback.isEmpty() )
	    	{
	    		Course add = new Course(name.getText().toString(), catalogID.getText().toString(), capacity.getValue());
	    		catalog.add(add);
	    		feedback = add.getCatalogID() + ": " + add.getTitle() + " created!";
	    	}
	    	messages.setText(feedback);
    }
    
    void update(Observable Object)
    {
    	
    }
}