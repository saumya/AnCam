package org.haxe.extension;


import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.util.Log;
import android.net.Uri;

import java.lang.String;
import java.util.Date;
import java.io.File;
import java.net.URI;
import android.os.Environment;
import android.content.Intent;
import android.provider.MediaStore;

// ref: https://github.com/openfl/extension-iap/blob/master/dependencies/android/src/org/haxe/extension/iap/InAppPurchase.java
import org.haxe.lime.HaxeObject;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class AnCam extends Extension {

	private static HaxeObject cbObj = null;

	public static void initCam(final HaxeObject callBackObj){
		AnCam.cbObj = callBackObj;

		Extension.mainActivity.runOnUiThread(new Runnable() {
			@Override public void run() {
				Log.d("INFO","=======================================");
				Log.d("INFO","initCam");
				Log.d("INFO","=======================================");
				AnCam.cbObj.call("onInit",new Object[]{"Back From JAVA"});
			}
		});
	}

	public static void startCam(final HaxeObject callBackObj){
		AnCam.cbObj = callBackObj;

		//Extension.callbackHandler.post(new Runnable() {
		Extension.mainActivity.runOnUiThread(new Runnable() {
			@Override public void run() {

				/*
				String name = dateToString(new Date(), "yyyy-MM-dd-hh-mm-ss");
				destination = new File(Environment.getExternalStorageDirectory(), name + ".jpg");
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(destination));
		        startActivityForResult(intent, PICK_Camera_IMAGE);
		        */

		        //
		        // ref : https://stackoverflow.com/questions/16799818/open-camera-using-intent
		        // ref : https://stackoverflow.com/questions/10165302/dialog-to-pick-image-from-gallery-or-from-camera
		        //
		        Intent iTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		        /*
		        Context oContext;
		        oContext= Extension.mainContext;
		        oContext.startActivity(iTakePicture);
		        */
		        /*
		        // ref : https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android#10407371
		        Activity aThis;
		        aThis = Extension.mainActivity;
		        aThis.startActivityForResult(iTakePicture, 1);
		        */

		        Activity aThis;
		        aThis = Extension.mainActivity;

		        //String path = Environment.getExternalStorageDirectory() + "/CameraImages/example.jpg";
		        String path = Environment.getExternalStorageDirectory() + "/example.jpg";
		        //String path = Environment.DIRECTORY_DCIM + "/example.jpg";
		        //String path = Environment.getExternalStorageDirectory() + "sdcard/DCIM/Camera/example.jpg";
		        //
		        File file = new File(path);
		        Uri outputFileUri = Uri.fromFile( file );
		        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
		        intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
		        aThis.startActivityForResult( intent, 1 );
	    	}
    	});

	}
	
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		
		//Intent iData = data.getDate()

		Log.d("INFO","=======================================");
		Log.d("INFO","=======================================");
		Log.d("INFO","onActivityResult");
		Log.d("INFO","=======================================");
		Log.d("INFO","=======================================");
		
		/*
		if(requestCode==1){
			// Camera
			Log.d("CAMERA","=======================================");
			Log.d("CAMERA","=======================================");
		}
		*/

		AnCam.cbObj.call("onInit",new Object[]{"Back From JAVA"});

		return true;
		
	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		
		
		
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}