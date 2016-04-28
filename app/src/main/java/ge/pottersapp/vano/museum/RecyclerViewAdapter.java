package ge.pottersapp.vano.museum;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private static Context context;
    private ArrayList<ExhibitionObject> mDataset;
    private static MyClickListener myClickListener;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        public  TextView exhibitonTitle;
        public  ImageView exhibitionImage;



       /* public View view;
        public ClipData.Item currentItem;*/

        public DataObjectHolder(View itemView) {
            super(itemView);
            exhibitonTitle = (TextView) itemView.findViewById(R.id.exhibitionTitle);
            exhibitionImage = (ImageView) itemView.findViewById(R.id.exhibitionImage);

            Log.i(LOG_TAG, "Adding Listener");


          /*  user_photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(context, NewsContent.class);
                    intent.putExtra("fullInfo", String.valueOf(user_text));

                    context.startActivity(intent);
                }
            });*/
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
          /*  Fragment nameAdd = new NewsContent();

            FragmentManager manager = context.getFragmentManager();
            FragmentTransaction transaction = getFragmentManager.beginTransaction();
            transaction.replace(R.id.container, nameAdd); // newInstance() is a static factory method.
            transaction.commit();
*/


            //replace content frame with your own view.
             /*final Intent intent;
           intent =  new Intent(context, NewsContent.class);
            System.out.println(context);
            context.startActivity(intent);*/
        }


    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerViewAdapter(ArrayList<ExhibitionObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exhibition_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.exhibitonTitle.setText(mDataset.get(position).getTitle());

        Uri uriImage = Uri.parse(mDataset.get(position).getImg_url());
        context = holder.exhibitionImage.getContext();
        Picasso.with(context)
                .load(uriImage)
                .resize(1050, 1100)
                .centerCrop()
                .into(holder.exhibitionImage);



        holder.exhibitonTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String test = mDataset.get(position).getLink_url();
                Uri uri = Uri.parse(test); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

     /*   holder.user_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(context, NewsContent.class);
                intent.putExtra("fullInfo", mDataset.get(position));

                context.startActivity(intent);

            }
        });*/
    }


    public void addItem(ExhibitionObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {

        return mDataset == null ? 0 : mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
