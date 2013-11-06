package com.example.sentmailtest;

import java.util.List;
import org.apache.cordova.*;
import com.example.sentmailtest.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends DroidGap  {

	private static final int REQUEST_SEND_MAIL = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void goToSentMail(View View){
		
		
		
		 
	    
	    try{
	    	//set the main intent to ACTION_SEND for looking for applications that share information
		    Intent intent = new Intent(Intent.ACTION_SEND, null);

		    //intent.addCategory(Intent.CATEGORY_LAUNCHER); //if you want extra filters

		    //filter out apps that are able to send plain text
		    intent.setType("plain/text");

		    //get a list of apps that meet your criteria above
	    List<ResolveInfo> pkgAppsList = this.getPackageManager().queryIntentActivities( intent, PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_RESOLVED_FILTER); 
	    
	    //select the first one in the list	    
	    ResolveInfo info = pkgAppsList.get(0);  
	    String packageName = info.activityInfo.packageName;
	    String className = info.activityInfo.name;

	    //set the intent to luanch that specific app
	    intent.setClassName(packageName, className);

	    //some samples on adding more then one email address
	    String aEmailList[] = { "veeramani.d@dsninfosoft.in"};
	    String aEmailCCList[] = { "vinoth.r@dsninfosoft.in","kavitha.g@dsninfosoft.in"};
	    //String aEmailBCCList[] = { "veeramani.d@dsninfosoft.in" };

	    //all the extras that will be passed to the email app       
	    intent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
	    intent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
	    //intent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
	    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your Username & Password......");
	    intent.putExtra(android.content.Intent.EXTRA_TEXT, "Welcome to DSN Infosoft Pvt Ltd., Your username is: veera    Password is: kjhkjh886*kju");

	    //start the app
	    startActivity(intent);
	    
	    Toast.makeText(this, "Mail send successfully...", Toast.LENGTH_LONG).show();
	    
		
	    }
	    catch (Exception ex){
	    	 Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
	    }
		
		
		
	    
	    
	    
		
		
		
//		Intent i = new Intent(Intent.ACTION_SEND);  
//		i.setType("text/plain"); //use this line for testing in the emulator  
//		i.setType("message/rfc822") ; // use from live device
//		i.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");//sending email via gmail
//		i.putExtra(Intent.EXTRA_EMAIL, new String[]{"veeramani.d@dsninfosoft.in"});  
//		i.putExtra(Intent.EXTRA_SUBJECT,"subject goes here");  
//		i.putExtra(Intent.EXTRA_TEXT,"body goes here");  
//		//startActivity(Intent.createChooser(i, "Send mail..."));
//		startActivity(i.createChooser(i, "dfgdfg"));
//		Toast.makeText(this, "Msg Sent Successfully !!!!", Toast.LENGTH_LONG).show();
		
//		Intent i = new Intent(Intent.ACTION_SEND);
//		i.setType("message/rfc822");
//		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"veeramani.d@dsninfosoft.in"});
//		i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
//		i.putExtra(Intent.EXTRA_TEXT   , "body of email");
//		try {
//		    startActivity(Intent.createChooser(i, "Send mail..."));
//		    Toast.makeText(this, "Message Sent Successfully", Toast.LENGTH_LONG).show();
//		} catch (android.content.ActivityNotFoundException ex) {
//		    Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//		}
//		Toast.makeText(this, "Welcome to sent mail page !!!!", Toast.LENGTH_LONG).show();
	}

}
