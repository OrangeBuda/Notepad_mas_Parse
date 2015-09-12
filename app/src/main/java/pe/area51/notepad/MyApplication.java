package pe.area51.notepad;

import android.app.Application;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.net.ProxySelector;
import java.util.List;

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
        final ParseObject parseObject = new ParseObject("testObject");
        parseObject.add("message", "Hello World!");
        parseObject.saveInBackground();


        //TEST BEGIN
        ParseQuery parseQuery = ParseQuery.getQuery("TestClass");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                for (ParseObject parseObject1 : list) {
                    Log.d("Parse server response", parseObject1.getString("message"));

                }
            }
        });

        //Test END
    }
}
