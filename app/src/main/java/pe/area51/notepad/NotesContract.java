package pe.area51.notepad;

import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

//contrato para llamar al content provider

public class NotesContract {

    public static final Uri URI = Uri.parse("content://pe.area51.notepad.ContentProvider/notes");

    public static final String MIME_ITEM = "vnd.android.cursor.item/vnd.pe.area51.notepad.note";
    public static final String MIME_DIR = "vnd.android.cursor.dir/vnd.pe.area51.notepad.note";

    public static final String LOCAL_ID = "_id";
    public static final String REMOTE_ID = "remoteId";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CREATION_UNIX_TIME = "creationUnixTime";
    public static final String MODIFICATION_UNIX_TIME = "modificationUnixTime";


    public static List<Note> manyFromCursor(final  Cursor cursor)  {

        final List<Note> notes = new ArrayList<>();
        //Recordar que el puntero del cursor empieza en una posición anterior al primer elemento.
        while (cursor.moveToNext()) {
            final long localId = cursor.getLong(cursor.getColumnIndex(NotesContract.LOCAL_ID));
            final String remoteId = cursor.getString(cursor.getColumnIndex(NotesContract.REMOTE_ID));
            final String title = cursor.getString(cursor.getColumnIndex(NotesContract.TITLE));
            final String content = cursor.getString(cursor.getColumnIndex(NotesContract.CONTENT));
            final long creationUnixTime = cursor.getLong(cursor.getColumnIndex(NotesContract.CREATION_UNIX_TIME));
            final long modificationUnixTime = cursor.getLong(cursor.getColumnIndex(NotesContract.MODIFICATION_UNIX_TIME));
            notes.add(new Note(localId, remoteId, creationUnixTime, modificationUnixTime, title, content));
        }
        cursor.close();
        return notes;
    }


    public static Note oneFromCursor(final Cursor cursor){
        cursor.moveToNext();
        final long localId = cursor.getLong(cursor.getColumnIndex(NotesContract.LOCAL_ID));
        final String remoteId = cursor.getString(cursor.getColumnIndex(NotesContract.REMOTE_ID));
        final String title = cursor.getString(cursor.getColumnIndex(NotesContract.TITLE));
        final String content = cursor.getString(cursor.getColumnIndex(NotesContract.CONTENT));
        final long creationUnixTime = cursor.getLong(cursor.getColumnIndex(NotesContract.CREATION_UNIX_TIME));
        final long modificationUnixTime = cursor.getLong(cursor.getColumnIndex(NotesContract.MODIFICATION_UNIX_TIME));
        cursor.close();
        return new Note(localId, remoteId, creationUnixTime, modificationUnixTime, title, content);

    }



}
