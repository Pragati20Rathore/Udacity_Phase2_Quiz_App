package com.google.udacity.quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class quizAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CompoundButton.OnCheckedChangeListener {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Quiz> mList;
    HashMap<Integer, String> dummyTrial = new HashMap<Integer, String>();

    private static final int TYPE_CHECKBOX = 1;
    private static final int TYPE_RADIO = 2;
    private static final int TYPE_FILL_BLANK = 3;

    IRecyclerListener mListner;


    public quizAdapter(Context mContext, ArrayList<Quiz> listQuiz, IRecyclerListener listener) {
        this.mContext = mContext;
        this.mList = listQuiz;
        this.mListner = listener;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        Quiz quizItem = mList.get(position);

        if (quizItem.getType().equals(MultipleItem.ItemType.CHECKBOX_TYPE)) {
            return TYPE_CHECKBOX;
        } else if (quizItem.getType().equals(MultipleItem.ItemType.RADIO_TYPE)) {
            return TYPE_RADIO;
        } else if (quizItem.getType().equals(MultipleItem.ItemType.FILL_BLANK_TYPE)) {
            return TYPE_FILL_BLANK;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {   //creates holder for the items views
        switch (viewType) {
            case TYPE_CHECKBOX:
                View checkBoxQueView = mInflater.inflate(R.layout.checkbox_type_que_item, viewGroup, false);
                return new ViewHolderCheckBox(checkBoxQueView);

            case TYPE_RADIO:
                View radioBtnQueView = mInflater.inflate(R.layout.radio_btn_type_que_item, viewGroup, false);
                return new ViewHolderRadio(radioBtnQueView);

            case TYPE_FILL_BLANK:
                View blankQueView = mInflater.inflate(R.layout.blank_type_que_item, viewGroup, false);
                return new ViewHolderFillBlank(blankQueView);

            default:
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_CHECKBOX:
                initLayoutCheckBox((ViewHolderCheckBox) holder, position);
                ((ViewHolderCheckBox) holder).cb_one.setTag(position);
                ((ViewHolderCheckBox) holder).cb_two.setTag(position);
                ((ViewHolderCheckBox) holder).cb_three.setTag(position);
                ((ViewHolderCheckBox) holder).cb_four.setTag(position);
                break;
            case TYPE_RADIO:
                initLayoutRadioBtn((ViewHolderRadio) holder, position);
                ((ViewHolderRadio) holder).rb_one.setTag(position);
                ((ViewHolderRadio) holder).rb_two.setTag(position);
                break;
            case TYPE_FILL_BLANK:
                initLayoutFillBlank((ViewHolderFillBlank) holder, position);
                ((ViewHolderFillBlank) holder).tv_fill_blank.setTag(position);
            default:
                break;
        }
    }

    private void initLayoutCheckBox(ViewHolderCheckBox holder, int pos) {
        Quiz quizItem = mList.get(pos);

        holder.que_checkbox.setText(quizItem.getQuestion());
        holder.cb_one.setText(quizItem.getOption().get(0));
        holder.cb_two.setText(quizItem.getOption().get(1));
        holder.cb_three.setText(quizItem.getOption().get(2));
        holder.cb_four.setText(quizItem.getOption().get(3));

        holder.cb_one.setOnCheckedChangeListener(this);
        holder.cb_two.setOnCheckedChangeListener(this);
        holder.cb_three.setOnCheckedChangeListener(this);
        holder.cb_four.setOnCheckedChangeListener(this);
    }

    private void initLayoutRadioBtn(ViewHolderRadio holder, int pos) {
        Quiz quizItem = mList.get(pos);

        holder.que_radio_btn.setText(quizItem.getQuestion());
        holder.rb_one.setText(quizItem.getOption().get(0));
        holder.rb_two.setText(quizItem.getOption().get(1));

        holder.rb_one.setOnCheckedChangeListener(this);
        holder.rb_two.setOnCheckedChangeListener(this);

        holder.rb_one.setTag(pos);
        holder.rb_two.setTag(pos);
    }

    private void initLayoutFillBlank(final ViewHolderFillBlank holder, int pos) {
        Quiz quizItem = mList.get(pos);

        holder.tv_fill_blank.setText(quizItem.getQuestion());
        holder.tv_fill_blank.setTag(pos);

//        holder.tv_fill_blank.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String inputAns = holder.tv_fill_blank.getText().toString();
//                onTextChangeListener(inputAns, (Integer) holder.tv_fill_blank.getTag());
//            }
//        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_one:
                int position1 = (int) buttonView.getTag();
                dummyTrial.put(position1, (String) buttonView.getText());
                break;
            case R.id.cb_two:
                int position2 = (int) buttonView.getTag();
                dummyTrial.put(position2, (String) buttonView.getText());
                break;
            case R.id.cb_three:
                int position3 = (int) buttonView.getTag();
                dummyTrial.put(position3, (String) buttonView.getText());
                break;
            case R.id.cb_four:
                int position4 = (int) buttonView.getTag();
                dummyTrial.put(position4, (String) buttonView.getText());
                break;
            case R.id.rb_one:
                int position5 = (int) buttonView.getTag();
                dummyTrial.put(position5, (String) buttonView.getText());
                break;
            case R.id.rb_two:
                int position6 = (int) buttonView.getTag();
                dummyTrial.put(position6, (String) buttonView.getText());
                break;
        }

//        if (dummyTrial.size() == 10) {
//            if (mListner != null) {
//                mListner.enableSubmitBtn(true);
//
//                for (Integer position : dummyTrial.keySet()) {
//
//                    String key = position.toString();
//                    String value = dummyTrial.get(position).toString();
//                    System.out.println(key + " " + value);
//                    Toast.makeText(mContext, "" + "" + key + " " + value, Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
    }

    //inflates the view groups used in holder view
    public class ViewHolderCheckBox extends RecyclerView.ViewHolder {

        private ViewHolderCheckBox(View itemView) {
            super(itemView);
        }

        TextView que_checkbox = (TextView) itemView.findViewById(R.id.que_checkbox);
        CheckBox cb_one = (CheckBox) itemView.findViewById(R.id.cb_one);
        CheckBox cb_two = (CheckBox) itemView.findViewById(R.id.cb_two);
        CheckBox cb_three = (CheckBox) itemView.findViewById(R.id.cb_three);
        CheckBox cb_four = (CheckBox) itemView.findViewById(R.id.cb_four);
    }

    public class ViewHolderRadio extends RecyclerView.ViewHolder {

        private ViewHolderRadio(View itemView) {
            super(itemView);
        }

        TextView que_radio_btn = (TextView) itemView.findViewById(R.id.que_radio_btn);
        RadioGroup rg = (RadioGroup) itemView.findViewById(R.id.rg);
        RadioButton rb_one = (RadioButton) itemView.findViewById(R.id.rb_one);
        RadioButton rb_two = (RadioButton) itemView.findViewById(R.id.rb_two);
    }

    public class ViewHolderFillBlank extends RecyclerView.ViewHolder {

        private ViewHolderFillBlank(View itemView) {
            super(itemView);
        }

        EditText et_fill_blank = (EditText) itemView.findViewById(R.id.et_fill_blank);
        TextView tv_fill_blank = (TextView) itemView.findViewById(R.id.tv_que_fill_blank);
    }
}
