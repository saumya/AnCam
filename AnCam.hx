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


class AnCam {
	
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

	public static function startCamera():Void {
	    start_camera_jni();
	}
	private static var start_camera_jni = JNI.createStaticMethod("org.haxe.extension.AnCam", "startCam", "()V");
	
	#end
	
}