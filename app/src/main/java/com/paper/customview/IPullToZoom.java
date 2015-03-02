package com.paper.customview;

import android.content.res.TypedArray;
import android.view.View;

/**
 * ,==.              |~~~
 * /  66\             |
 * \c  -_)         |~~~
 * `) (           |
 * /   \       |~~~
 * /   \ \      |
 * ((   /\ \_ |~~~
 * \\  \ `--`|
 * / / /  |~~~
 * ___ (_(___)_|
 * <p/>
 * Created by Paper on 15-2-1 2015.
 */
public interface IPullToZoom<T extends View> {
    /**
     * Get the Wrapped Zoom View. Anything returned here has already been
     * added to the content view.
     *
     * @return The View which is currently wrapped
     */
    public View getZoomView();

    public View getHeaderView();

    /**
     * Get the Wrapped root View.
     *
     * @return The View which is currently wrapped
     */
    public T getRootView();

    /**
     * Whether Pull-to-Refresh is enabled
     *
     * @return enabled
     */
    public boolean isPullToZoomEnabled();

    /**
     * Returns whether the Widget is currently in the Zooming state
     *
     * @return true if the Widget is currently zooming
     */
    public boolean isZooming();

    /**
     * Returns whether the Widget is currently in the Zooming anim type
     *
     * @return true if the anim is parallax
     */
    public boolean isParallax();

    public boolean isHideHeader();

    public void handleStyledAttributes(TypedArray a);
}