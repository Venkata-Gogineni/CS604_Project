package edu.shu.com.shufinance.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Datamodel.TransactionHistory;


public class TransactionsAdapter extends ArrayAdapter {


    private Context context;
    ArrayList<TransactionHistory> transactionHistoryArrayList = new ArrayList<TransactionHistory>();

    int resource;

    public TransactionsAdapter(Context context, int resource, ArrayList<TransactionHistory> transactionHistoryArrayList) {
        super(context, resource, transactionHistoryArrayList);

        this.resource = resource;
        this.context = context;
        this.transactionHistoryArrayList = transactionHistoryArrayList;


    }


    static class ViewHolder {
        TextView transactionIDTextView;
        TextView transactionTypeTextView;
        TextView amountTextView;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.transactionIDTextView = (TextView) convertView.findViewById(R.id.value_transaction_id_textview);
            viewHolder.transactionTypeTextView = (TextView) convertView.findViewById(R.id.value_transaction_type_textview);
            viewHolder.amountTextView = (TextView) convertView.findViewById(R.id.value_amount_textView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.transactionIDTextView.setText(transactionHistoryArrayList.get(position).getTransactionID());
        viewHolder.transactionTypeTextView.setText(transactionHistoryArrayList.get(position).getTransactionType());
        viewHolder.amountTextView.setText("$" + transactionHistoryArrayList.get(position).getTransactionAmount());
        return convertView;
    }
}
