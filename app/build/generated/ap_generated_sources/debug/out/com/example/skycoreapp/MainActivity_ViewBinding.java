// Generated code from Butter Knife. Do not modify!
package com.example.skycoreapp;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.seekBar = Utils.findRequiredViewAsType(source, R.id.seekBar, "field 'seekBar'", SeekBar.class);
    target.progress_circular = Utils.findRequiredViewAsType(source, R.id.progress_circular, "field 'progress_circular'", ProgressBar.class);
    target.list_item = Utils.findRequiredViewAsType(source, R.id.list_item, "field 'list_item'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.seekBar = null;
    target.progress_circular = null;
    target.list_item = null;
  }
}
