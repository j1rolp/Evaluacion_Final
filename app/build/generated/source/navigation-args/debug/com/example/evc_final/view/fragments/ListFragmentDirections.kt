package com.example.evc_final.view.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.evc_final.R
import com.example.evc_final.model.Ec_final
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToDetailFragment(
    public val ecFinal: Ec_final
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listFragment_to_detailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Ec_final::class.java)) {
          result.putParcelable("ec_final", this.ecFinal as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Ec_final::class.java)) {
          result.putSerializable("ec_final", this.ecFinal as Serializable)
        } else {
          throw UnsupportedOperationException(Ec_final::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionListFragmentToDetailFragment(ecFinal: Ec_final): NavDirections =
        ActionListFragmentToDetailFragment(ecFinal)
  }
}
