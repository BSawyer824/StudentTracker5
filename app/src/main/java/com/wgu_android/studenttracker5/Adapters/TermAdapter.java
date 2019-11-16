package com.wgu_android.studenttracker5.Adapters;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wgu_android.studenttracker5.Entities.TermsEntity;
import com.wgu_android.studenttracker5.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.ViewHolder> {

    private final List<TermsEntity> mTerms;
    private final Context mContext;

    public TermAdapter(List<TermsEntity> mTerms, Context mContext) {
        this.mTerms = mTerms;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TermAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //layout inflaters
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.term_listitem, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.ViewHolder holder, int position) {
        //called each time a row is refreshed with a data object
        final TermsEntity term = mTerms.get(position);

        //assign start and end dates to a string
        Date startDate = term.getTermStart();
        Date endDate = term.getTermEnd();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String strDate = dateFormat.format(startDate);
        String strDateEnd = dateFormat.format(endDate);
        String label = strDate + "  to  " + strDateEnd;

        holder.mTextView_TermName.setText(term.getTermName());
        holder.mTextView_TermDates.setText(label);
    }

    @Override
    public int getItemCount() {

        return mTerms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //manages the view, references any views used to display data

        @BindView(R.id.textView_TermSummary_Name)
        TextView mTextView_TermName;

        @BindView(R.id.textView_TermSummary_Dates)
        TextView mTextView_TermDates;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
