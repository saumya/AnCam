AnCam
==============
An [OpenFL][1] Android extension to use Camera.

 - Done with **OpenFL 4.9.2**.
 - [reference tutorial][2]
 - [Sending Data back from Native Code to Haxe][4]
 - The JNI [short code reference][3]

For the basics of an Android extension, [have a look at RayToast][5]

Available Methods
 - `initCamera()Void` : just a test
 - `startCamera():Void` : fires up camera and takes picture
 - `captureImageAs(imgName:String):Void` : **Mostly needed this one**. It takes the image name as a parameter and saves it

### Usage
 - Two steps
  1. Call it like `AnCam.captureImageAs("myPhoto");`
  2. Listen to the event as `AnCam.dispatcher.addEventListener(AnCam.CAM_CAPTURED_EVENT,onCamCaptured);`
 - [Complete Example implementation is here][6]
 - Sample code for implementation is as below
 
 ```
	// add the event listener
	AnCam.dispatcher.addEventListener(AnCam.CAM_CAPTURED_EVENT,onCamCaptured);
 ```
 
 ```
	// capture the image and save it
	AnCam.captureImageAs("myPhoto");// it will be saved as myPhoto.jpg
 ```

 ```
	// load it in the application
	private function onCamCaptured(e:Event):Void{
		var sCamImage:String = System.userDirectory + 'myPhoto' +'.jpg';
		var r:URLRequest = new URLRequest(sCamImage);
		var loaderImage:Loader = new Loader();
		loaderImage.load(r);
		addchild(loaderImage);
	}
 ```

### Notes

 - The JNI [short code reference][3]
 - change `build.gradle` located at `dependencies/android/build.gradle` to have `classpath 'com.android.tools.build:gradle:::ANDROID_GRADLE_PLUGIN::'`
   - it looks as
   ```
   dependencies {
		classpath 'com.android.tools.build:gradle:::ANDROID_GRADLE_PLUGIN::'
	}
   ``` 






[1]: http://www.openfl.org/learn/docs/tools/
[2]: https://player03.com/2014/08/09/openfl-extensions/
[3]: https://docs.oracle.com/javase/7/docs/technotes/guides/jni/spec/types.html
[4]: http://www.stencyl.com/help/viewPrint/229
[5]: https://github.com/saumya/RayToast
[6]: https://github.com/saumya/OpenFL-AnExt