// Generated code from Butter Knife. Do not modify!
package com.example.skycoreapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.skycoreapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListItemAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private ListItemAdapter.MyViewHolder target;

  @UiThread
  public ListItemAdapter$MyViewHolder_ViewBinding(ListItemAdapter.MyViewHolder target,
      View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.text_Subtitle = Utils.findRequiredViewAsType(source, R.id.text_Subtitle, "field 'text_Subtitle'", TextView.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.ratingImag = Utils.findRequiredViewAsType(source, R.id.ratingImag, "field 'ratingImag'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListItemAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.text_Subtitle = null;
    target.image = null;
    target.ratingImag = null;
  }
}
