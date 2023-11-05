package css_3334.lcproject;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SinnerAdapter extends RecyclerView.Adapter<SinnerViewHolder>{

    private Application application;
    private Context context; //possible switch to secondary activity

    private List<Sinner> sinnerList;

    /**
     * Updates Sinner list
     * @param newSinnerList
     */
    public void updateSinnerList(List<Sinner> newSinnerList) {sinnerList = newSinnerList;}

    public SinnerAdapter(Application application, Context context)
    {
        this.application = application;
        this.context = context;
        sinnerList = new ArrayList<>();
    }
    @NonNull
    @Override
    public SinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sinner_row, parent, false);
        SinnerViewHolder holder = new SinnerViewHolder(view);
        return new SinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinnerViewHolder holder, int position) {
        Sinner currentSinner = sinnerList.get(position);
        holder.textViewName.setText(currentSinner.getName());
        holder.textViewHealth.setText(""+currentSinner.getHealth());
        holder.textViewRarity.setText(currentSinner.getRarity());
        holder.textViewLowSpeed.setText(currentSinner.getSpeedLow() + "~" + currentSinner.getSpeedHigh());

        holder.textViewBlunt.setText(currentSinner.getBlunt());
        holder.textViewPierce.setText(currentSinner.getPierce());
        holder.textViewSlash.setText(currentSinner.getSlash());


        holder.imageViewSinAffinity1.setImageResource(getImageViewSin(currentSinner.getSin1()));
        holder.imageViewSinAffinity2.setImageResource(getImageViewSin(currentSinner.getSin2()));
        holder.imageViewSinAffinity3.setImageResource(getImageViewSin(currentSinner.getSin3()));

        holder.imageViewAttackType1.setImageResource(getImageViewAttack(currentSinner.getAttack1()));
        holder.imageViewAttackType2.setImageResource(getImageViewAttack(currentSinner.getAttack2()));
        holder.imageViewAttackType3.setImageResource(getImageViewAttack(currentSinner.getAttack3()));
    }

    /**
     * Determines the drawable id to be used depending on attack type
     * @param attack
     * @return
     */
    public int getImageViewAttack(String attack)
    {
        int imageId;
        switch (attack.toLowerCase())
        {
            case "slash":
            imageId=R.drawable.slash;
            break;

            case "blunt":
            imageId=R.drawable.blunt;
            break;

            case "pierce":
                imageId=R.drawable.pierce;
                break;
            default:
                imageId=R.drawable.slash;
        }
        return imageId;
    }

    /**
     * Determines the sin drawable depending on sin type
     * @param sin
     * @return
     */
    public int getImageViewSin(String sin)
    {
        int imageId;
        switch (sin.toLowerCase())
        {
            case "wrath":
            imageId = R.drawable.wrath;
            break;

            case "lust":
            imageId = R.drawable.lust;
            break;

            case "sloth":
            imageId = R.drawable.sloth;
            break;

            case "gluttony":
            imageId = R.drawable.gluttony;
            break;

            case "gloom":
            imageId = R.drawable.gloom;
            break;

            case "pride":
            imageId = R.drawable.pride;
            break;

            case "envy":
            imageId = R.drawable.envy;
            break;

            default:
            imageId = R.drawable.wrath;
        }
        return imageId;
    }
    @Override
    public int getItemCount() {
        return sinnerList.size();
    }
}
