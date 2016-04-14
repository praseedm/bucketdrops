package praseed.p6c.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by praseedm on 4/15/2016.
 */
public class AddDialog extends DialogFragment {
    private ImageButton close;
    private EditText input;
    private DatePicker inputDate;
    private Button btnAdd;

    private View.OnClickListener btnClose = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };
    public AddDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_drop,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        close = (ImageButton) view.findViewById(R.id.btn_close);
        input = (EditText) view.findViewById(R.id.et_add);
        inputDate = (DatePicker) view.findViewById(R.id.date_picker);
        btnAdd = (Button) view.findViewById(R.id.btn_addit);

        close.setOnClickListener(btnClose);
    }

}
