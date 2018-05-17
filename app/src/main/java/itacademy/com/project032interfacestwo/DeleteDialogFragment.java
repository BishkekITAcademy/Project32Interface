package itacademy.com.project032interfacestwo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DeleteDialogFragment extends DialogFragment implements View.OnClickListener {

    private DeleteCallback mCallback;
    private String mItem;

    public static DeleteDialogFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        DeleteDialogFragment fragment = new DeleteDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        TextView textView = view.findViewById(R.id.textView);
        Button btnConfirm = view.findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(this);

        if (getArguments() != null) {
            String info = String.format("Are you sure to delete %s?", mItem = getArguments().getString("name"));
            textView.setText(info);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (DeleteCallback) context;
    }

    @Override
    public void onClick(View v) {
        mCallback.deleteItem(mItem);
        dismiss();
    }
}
