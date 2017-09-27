/*
 ********************************************************************************
 * Copyright (c) 2012 Samsung Electronics, Inc.
 * All rights reserved.
 *
 * This software is a confidential and proprietary information of Samsung
 * Electronics, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Samsung Electronics.
 ********************************************************************************
 */

package com.manojbhadane.view;

import android.util.FloatMath;
import android.view.View;
import android.widget.AbsListView;

public class CircularViewModifier extends ViewModifier
{
    private static final int CIRCLE_OFFSET = 700;
    //	private static final float SCALING_RATIO = 0.000f;
    private static final float SCALING_RATIO = 0.000f;
    private static final float TRANSLATION_RATIO = 0.09f;
    private static final float DEGTORAD = 1.0f / 180.0f * (float) Math.PI;

    @Override
    void applyToView(final View v, final AbsListView parent)
    {
        final float halfHeight = v.getHeight() * 0.5f;
        final float parentHalfHeight = parent.getHeight() * 0.5f;
        final float y = v.getY();
        final float rot = parentHalfHeight - halfHeight - y;

        //		v.setPivotX(0.0f);
        //		v.setPivotY(halfHeight);
        //		v.setRotation(rot * 0.05f);
        //		v.setTranslationX((-FloatMath.cos(rot * TRANSLATION_RATIO * DEGTORAD) + 1) * CIRCLE_OFFSET);

        //		v.setPivotX(-150.0f);
        //		v.setTranslationX(150.0f);
        //		v.setRotation(-0.100f);

        v.setPivotX(500.0f);
        v.setPivotY(halfHeight);
        v.setRotation(0.100f);
        v.setTranslationX(((-FloatMath.cos(rot * TRANSLATION_RATIO * DEGTORAD) + 0.75f) * -CIRCLE_OFFSET));

        //		COS : 165.53203
        //		rot : 533.5
        //		TRANSLATION_RATIO : 0.09
        //		DEGTORAD : 0.017453294
        //		CIRCLE_OFFSET : 500
        System.out.println("COS--" + ((-FloatMath.cos(rot * TRANSLATION_RATIO * DEGTORAD) + 1) * CIRCLE_OFFSET));
        System.out.println("rot--" + rot);
        System.out.println("TRANSLATION_RATIO--" + TRANSLATION_RATIO);
        System.out.println("DEGTORAD--" + DEGTORAD);
        System.out.println("CIRCLE_OFFSET--" + CIRCLE_OFFSET);

        final float scale = 1.0f - Math.abs(parentHalfHeight - halfHeight - y) * SCALING_RATIO;
        v.setScaleX(scale);
        v.setScaleY(scale);
    }
}
