package pe.area51.notepad;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by alumno on 12/09/15.
 */
public class MyApplication extends Application {

    private static final String PARSE_APPLICATION_ID = "G3jimsCuaazJ55jXKOswOx4Jf5mh630xqXcG4ds6";
    private static final String PARSE_CLIENT_ID = "tmhLVUMYu3DabZYhJiMF8M7EBDoE9kgSHR9CCeeD";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_ID);
    }
}
