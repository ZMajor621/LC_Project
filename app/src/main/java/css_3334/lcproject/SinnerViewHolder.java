package css_3334.lcproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SinnerViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewHealth;
    TextView textViewRarity;
    TextView textViewLowSpeed;
    TextView textViewHighSpeed; //unused
    TextView textViewSlash;
    TextView textViewBlunt;
    TextView textViewPierce;

    ImageView imageViewSinAffinity1;
    ImageView imageViewSinAffinity2;
    ImageView imageViewSinAffinity3;

    ImageView imageViewAttackType1;
    ImageView imageViewAttackType2;
    ImageView imageViewAttackType3;

    /**
     * Constructor for SinnerViewHolder
     * @param itemView
     */
    public SinnerViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = (TextView) itemView.findViewById(R.id.textViewNameViewer);
        textViewHealth = (TextView) itemView.findViewById(R.id.textViewHealthViewer);
        textViewRarity = (TextView) itemView.findViewById(R.id.textViewRarityViewer);
        textViewLowSpeed = (TextView) itemView.findViewById(R.id.textViewSpeedViewer); // uses low speed but combines both speeds

        textViewSlash = (TextView) itemView.findViewById(R.id.textViewSlashViewer);
        textViewBlunt = (TextView) itemView.findViewById(R.id.textViewBluntViewer);
        textViewPierce = (TextView) itemView.findViewById(R.id.textViewPierceViewer);

        imageViewSinAffinity1 = (ImageView) itemView.findViewById(R.id.imageViewSinViewer1);
        imageViewSinAffinity2 = (ImageView) itemView.findViewById(R.id.imageViewSinViewer2);
        imageViewSinAffinity3 = (ImageView) itemView.findViewById(R.id.imageViewSinViewer3);

        imageViewAttackType1 = (ImageView) itemView.findViewById(R.id.imageViewAttack1Viewer);
        imageViewAttackType2 = (ImageView) itemView.findViewById(R.id.imageViewAttack1Viewer2);
        imageViewAttackType3 = (ImageView) itemView.findViewById(R.id.imageViewAttackViewer3);
    }
}
