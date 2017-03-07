package br.com.joao.dbflowsandbox.contentprovider;

import com.raizlabs.android.dbflow.annotation.provider.ContentProvider;

import br.com.joao.dbflowsandbox.simplecrud.AppDatabase;

/**
 * Created by joao.galli on 06/03/2017.
 */
@ContentProvider(authority = MessageContentProvider.AUTHORITY,
        database = AppDatabase.class,
        baseContentUri = MessageContentProvider.BASE_CONTENT_URI)
public class MessageContentProvider {
    public static final String AUTHORITY = "br.com.joao.dbflowsandbox.contentprovider";

    public static final String BASE_CONTENT_URI = "content://";
}
