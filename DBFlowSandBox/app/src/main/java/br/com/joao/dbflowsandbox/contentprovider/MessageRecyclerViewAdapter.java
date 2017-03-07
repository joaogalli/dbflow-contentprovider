package br.com.joao.dbflowsandbox.contentprovider;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.joao.dbflowsandbox.R;

/**
 * Created by joao.galli on 06/03/2017.
 */

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder> {

    private Cursor cursor;

    public MessageRecyclerViewAdapter() {
    }

    public MessageRecyclerViewAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    public void swapCursor(Cursor cursor) {
        this.cursor = cursor;
        //notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.messageView.setText(cursor.getString(cursor.getColumnIndex(Message_Table.message.getContainerKey())));
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Message item;
        TextView messageView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            messageView = (TextView) view.findViewById(R.id.message);
        }
    }

}
