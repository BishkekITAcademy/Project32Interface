package itacademy.com.project032interfacestwo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoAdapter extends ArrayAdapter<ToDoModel> {

    private AdapterCallback mCallback;

    public ToDoAdapter(@NonNull Context context, ArrayList<ToDoModel> arrayList, AdapterCallback callback) {
        super(context, 0, arrayList);
        this.mCallback = callback;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_todo, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ToDoModel model = getItem(position);

        if (model != null) {
            holder.mTvAction.setText(model.action);
            holder.mTvDescription.setText(model.description);
            holder.mBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.deleteModel(model);
                }
            });
        }

        return convertView;
    }

    private class ViewHolder {
        private TextView mTvAction;
        private TextView mTvDescription;
        private Button mBtnDelete;

        public ViewHolder(View view) {
            mBtnDelete = view.findViewById(R.id.btnDelete);
            mTvAction = view.findViewById(R.id.tvAction);
            mTvDescription = view.findViewById(R.id.tvDescription);
        }
    }
}
