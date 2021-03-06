package com.yarolegovich.lovelydialog;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;

import static android.view.View.*;

/**
 * Created by yarolegovich on 16.04.2016.
 * If null is passed instead on click listener - dialog will be just closed on click.
 */
public class LovelyStandardDialog extends AbsLovelyDialog<LovelyStandardDialog> {

    public static final int POSITIVE_BUTTON = R.id.ld_btn_yes;
    public static final int NEGATIVE_BUTTON = R.id.ld_btn_no;
    public static final int NEUTRAL_BUTTON = R.id.ld_btn_neutral;

    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;

    public LovelyStandardDialog(Context context) {
        super(context);
    }

    public LovelyStandardDialog(Context context, int theme) {
        super(context, theme);
    }

    {
        positiveButton = findView(R.id.ld_btn_yes);
        negativeButton = findView(R.id.ld_btn_no);
        neutralButton = findView(R.id.ld_btn_neutral);
    }

    public LovelyStandardDialog setPositiveButton(@StringRes int text, OnClickListener listener) {
        return setPositiveButton(string(text), listener);
    }

    public LovelyStandardDialog setPositiveButton(String text, @Nullable OnClickListener listener) {
        positiveButton.setVisibility(VISIBLE);
        positiveButton.setText(text);
        positiveButton.setOnClickListener(new CloseOnClickDecorator(listener));
        return this;
    }

    public LovelyStandardDialog setNegativeButtonText(@StringRes int text) {
        return setNegativeButton(string(text), null);
    }

    public LovelyStandardDialog setNegativeButtonText(String text) {
        return setNegativeButton(text, null);
    }

    public LovelyStandardDialog setNegativeButton(@StringRes int text, OnClickListener listener) {
        return setNegativeButton(string(text), listener);
    }

    public LovelyStandardDialog setNegativeButton(String text, @Nullable OnClickListener listener) {
        negativeButton.setVisibility(VISIBLE);
        negativeButton.setText(text);
        negativeButton.setOnClickListener(new CloseOnClickDecorator(listener));
        return this;
    }

    public LovelyStandardDialog setNeutralButtonText(@StringRes int text) {
        return setNeutralButton(string(text), null);
    }

    public LovelyStandardDialog setNeutralButtonText(String text) {
        return setNeutralButton(text, null);
    }

    public LovelyStandardDialog setNeutralButton(@StringRes int text, @Nullable OnClickListener listener) {
        return setNeutralButton(string(text), listener);
    }

    public LovelyStandardDialog setNeutralButton(String text, @Nullable OnClickListener listener) {
        neutralButton.setVisibility(VISIBLE);
        neutralButton.setText(text);
        neutralButton.setOnClickListener(new CloseOnClickDecorator(listener));
        return this;
    }

    public LovelyStandardDialog setButtonsColor(int color) {
        positiveButton.setTextColor(color);
        negativeButton.setTextColor(color);
        neutralButton.setTextColor(color);
        return this;
    }

    public LovelyStandardDialog setOnButtonClickListener(View.OnClickListener listener) {
        return setOnButtonClickListener(true, listener);
    }

    public LovelyStandardDialog setOnButtonClickListener(boolean closeOnClick, View.OnClickListener listener) {
        View.OnClickListener clickHandler = closeOnClick ?
                new CloseOnClickDecorator(listener) :
                listener;
        positiveButton.setOnClickListener(clickHandler);
        neutralButton.setOnClickListener(clickHandler);
        negativeButton.setOnClickListener(clickHandler);
        return this;
    }

    public LovelyStandardDialog setPositiveButtonText(@StringRes int text) {
        return setPositiveButton(string(text), null);
    }

    public LovelyStandardDialog setPositiveButtonText(String text) {
        return setPositiveButton(text, null);
    }

    public LovelyStandardDialog setPositiveButtonColor(int color) {
        positiveButton.setTextColor(color);
        return this;
    }

    public LovelyStandardDialog setNegativeButtonColor(int color) {
        negativeButton.setTextColor(color);
        return this;
    }

    public LovelyStandardDialog setNeutralButtonColor(int color) {
        neutralButton.setTextColor(color);
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_standard;
    }
}
