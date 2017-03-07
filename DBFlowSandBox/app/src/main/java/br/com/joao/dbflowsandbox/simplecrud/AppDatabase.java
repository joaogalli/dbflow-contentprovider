package br.com.joao.dbflowsandbox.simplecrud;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by joao.galli on 27/01/2017.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "SimpleCrud";

    public static final int VERSION = 1;

}
