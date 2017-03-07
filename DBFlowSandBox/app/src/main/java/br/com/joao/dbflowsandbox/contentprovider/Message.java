package br.com.joao.dbflowsandbox.contentprovider;

import android.net.Uri;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.provider.ContentUri;
import com.raizlabs.android.dbflow.annotation.provider.TableEndpoint;
import com.raizlabs.android.dbflow.structure.provider.BaseProviderModel;

import br.com.joao.dbflowsandbox.simplecrud.AppDatabase;

import static br.com.joao.dbflowsandbox.contentprovider.MessageContentProvider.AUTHORITY;
import static br.com.joao.dbflowsandbox.contentprovider.MessageContentProvider.BASE_CONTENT_URI;

/**
 * Created by joao.galli on 06/03/2017.
 */
@Table(database = AppDatabase.class)
@TableEndpoint(name = Message.ENDPOINT, contentProvider = MessageContentProvider.class)
public class Message extends BaseProviderModel<Message> {
    public static final String ENDPOINT = "Message";

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String message;

    private static Uri buildUri(String... paths) {
        Uri.Builder builder = Uri.parse(BASE_CONTENT_URI + AUTHORITY).buildUpon();
        for (String path : paths) {
            builder.appendPath(path);
        }
        return builder.build();
    }

    @ContentUri(path = Message.ENDPOINT,
            type = ContentUri.ContentType.VND_MULTIPLE + ENDPOINT)
    public static Uri CONTENT_URI = buildUri(ENDPOINT);

    @Override
    public Uri getDeleteUri() {
        return null;
    }

    @Override
    public Uri getInsertUri() {
        return null;
    }

    @Override
    public Uri getUpdateUri() {
        return null;
    }

    @Override
    public Uri getQueryUri() {
        return null;
    }
}
