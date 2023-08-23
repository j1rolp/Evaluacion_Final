package com.example.evc_final.view.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.evc_final.model.Ec_final
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val ecFinal: Ec_final
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Ec_final::class.java)) {
      result.set("ec_final", this.ecFinal as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Ec_final::class.java)) {
      result.set("ec_final", this.ecFinal as Serializable)
    } else {
      throw UnsupportedOperationException(Ec_final::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __ecFinal : Ec_final?
      if (bundle.containsKey("ec_final")) {
        if (Parcelable::class.java.isAssignableFrom(Ec_final::class.java) ||
            Serializable::class.java.isAssignableFrom(Ec_final::class.java)) {
          __ecFinal = bundle.get("ec_final") as Ec_final?
        } else {
          throw UnsupportedOperationException(Ec_final::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__ecFinal == null) {
          throw IllegalArgumentException("Argument \"ec_final\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ec_final\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__ecFinal)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __ecFinal : Ec_final?
      if (savedStateHandle.contains("ec_final")) {
        if (Parcelable::class.java.isAssignableFrom(Ec_final::class.java) ||
            Serializable::class.java.isAssignableFrom(Ec_final::class.java)) {
          __ecFinal = savedStateHandle.get<Ec_final?>("ec_final")
        } else {
          throw UnsupportedOperationException(Ec_final::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__ecFinal == null) {
          throw IllegalArgumentException("Argument \"ec_final\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ec_final\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__ecFinal)
    }
  }
}
