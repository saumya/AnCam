package;

/*
#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.utils.JNI;
#end
*/

import lime.system.JNI;
import openfl.events.Event;
import openfl.events.EventDispatcher;


class AnCam {

	// Event dispatcher composition
	public static var dispatcher = new EventDispatcher ();
	public static var CAM_CAPTURED_EVENT = "CAM_CAPTURED_EVENT";
	
	/*
	public static function sampleMethod (inputValue:Int):Int {
		
		#if (android && openfl)
		
		var resultJNI = ancam_sample_method_jni(inputValue);
		var resultNative = ancam_sample_method(inputValue);
		
		if (resultJNI != resultNative) {
			
			throw "Fuzzy math!";
			
		}
		
		return resultNative;
		
		#else
		
		return ancam_sample_method(inputValue);
		
		#end
		
	}
	
	
	private static var ancam_sample_method = Lib.load ("ancam", "ancam_sample_method", 1);
	
	#if (android && openfl)
	private static var ancam_sample_method_jni = JNI.createStaticMethod ("org.haxe.extension.AnCam", "sampleMethod", "(I)I");
	#end
	*/

	#if android

	public static function initCamera():Void {
	    init_JNI([new CamCallbackHandler()]);
	}
	public static function startCamera():Void {
		start_camera_jni( [new CamCallbackHandler()] );
	}

	private static var init_JNI = JNI.createStaticMethod ("org.haxe.extension.AnCam", "initCam", "(Lorg/haxe/lime/HaxeObject;)V", true);
	private static var start_camera_jni = JNI.createStaticMethod("org.haxe.extension.AnCam", "startCam", "(Lorg/haxe/lime/HaxeObject;)V", true);
	
	#end
}

private class CamCallbackHandler {
	public function new () { }
	public function onInit(msg:String):Void{
		trace('onInit:'+msg);
	}
	public function onCamDone(msg:String,requestCode:Int,resultCode:Int):Void{
		trace('onCamDone:msg:'+msg);
		trace('onCamDone:requestCode:'+requestCode);
		trace('onCamDone:resultCode:'+resultCode);
		//trace('onCamDone:imageData:'+imageData);

		var e:Event = new Event(AnCam.CAM_CAPTURED_EVENT);
		AnCam.dispatcher.dispatchEvent(e);
	}
}