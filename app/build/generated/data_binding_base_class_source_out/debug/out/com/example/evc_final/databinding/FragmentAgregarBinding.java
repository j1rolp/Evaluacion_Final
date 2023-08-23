// Generated by view binder compiler. Do not edit!
package com.example.evc_final.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.evc_final.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAgregarBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton btnAgregar;

  @NonNull
  public final RecyclerView rvFirebase;

  private FragmentAgregarBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton btnAgregar, @NonNull RecyclerView rvFirebase) {
    this.rootView = rootView;
    this.btnAgregar = btnAgregar;
    this.rvFirebase = rvFirebase;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAgregarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAgregarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_agregar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAgregarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_agregar;
      FloatingActionButton btnAgregar = ViewBindings.findChildViewById(rootView, id);
      if (btnAgregar == null) {
        break missingId;
      }

      id = R.id.rv_firebase;
      RecyclerView rvFirebase = ViewBindings.findChildViewById(rootView, id);
      if (rvFirebase == null) {
        break missingId;
      }

      return new FragmentAgregarBinding((ConstraintLayout) rootView, btnAgregar, rvFirebase);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
