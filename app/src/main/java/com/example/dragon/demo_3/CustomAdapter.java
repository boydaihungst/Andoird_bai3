package com.example.dragon.demo_3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Product> {
    private Context context;
    private int resource;
    private List<Product> arrContact;

    public CustomAdapter(Context context, int resource, ArrayList<Product> arrContact) {
        super(context, resource, arrContact);
        this.context = context;
        this.resource = resource;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvProName = (TextView) convertView.findViewById(R.id.tvProName);
            viewHolder.tvProPrice = (TextView) convertView.findViewById(R.id.tvProPrice);
            viewHolder.btnDetails = (TextView) convertView.findViewById(R.id.btnDetails);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Product product = arrContact.get(position);
        viewHolder.tvProName.setText(product.getName());
        viewHolder.tvProPrice.setText(String.valueOf(product.getPrice()));
        viewHolder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Details.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("product", product);
                context.startActivity(i);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvProName, tvProPrice, btnDetails;

    }
}

