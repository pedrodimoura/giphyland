package com.github.pedrodimoura.ui.card

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import com.github.pedrodimoura.ui.R
import com.github.pedrodimoura.ui.extensions.loadGif
import com.google.android.material.card.MaterialCardView

class GifCardView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val rootLayout: ConstraintLayout = ConstraintLayout(context)
    private val gifImageView: AppCompatImageView = AppCompatImageView(context)
    private val favoriteButton: AppCompatToggleButton = AppCompatToggleButton(context)
    private val shareButton: AppCompatImageButton = AppCompatImageButton(context)

    var gifUrl: String = ""
        set(value) {
            if (value != field) {
                field = value
                gifImageView.loadGif(value)
            }
        }
    var isFavorite: Boolean = false
        set(value) {
            if (value != field) {
                field = value
                favoriteButton.isChecked = value
            }
        }
    var isShareEnabled: Boolean = true
        set(value) {
            if (value != field) {
                field = value
                shareButton.isVisible = value
            }
        }

    init {
        getAttributes()
        setRootViewProperties()
        inflateView()
        setAttributesOnUI()
    }

    private fun getAttributes() {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GifCardView)

        gifUrl = typedArray.getString(R.styleable.GifCardView_gifUrl).orEmpty()
        isFavorite = typedArray.getBoolean(R.styleable.GifCardView_isFavorite, isFavorite)
        isShareEnabled = typedArray.getBoolean(R.styleable.GifCardView_isShareEnabled, isEnabled)

        typedArray.recycle()
    }

    private fun setRootViewProperties() {
        this.layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.gif_card_height)
        )
        this.cardElevation = resources.getDimension(R.dimen.gif_card_elevation)
        this.useCompatPadding = true

        val rootLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.gif_card_height)
        )
        rootLayout.layoutParams = rootLayoutParams

        addView(rootLayout)
    }

    private fun inflateView() {

        val gifLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        gifImageView.layoutParams = gifLayoutParams
        gifImageView.scaleType = ImageView.ScaleType.CENTER_CROP

        val constraintSet = ConstraintSet()
        constraintSet.clone(rootLayout)
        constraintSet.connect(
            gifImageView.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP
        )
        constraintSet.connect(
            gifImageView.id,
            ConstraintSet.START,
            ConstraintSet.PARENT_ID,
            ConstraintSet.START
        )
        constraintSet.connect(
            gifImageView.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END
        )
        constraintSet.applyTo(rootLayout)

        rootLayout.addView(gifImageView)
    }

    private fun setAttributesOnUI() {
        gifImageView.loadGif(gifUrl)
        favoriteButton.isChecked = isFavorite
        shareButton.isVisible = isShareEnabled
    }
}
