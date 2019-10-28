package com.bugull.bugullproject.di;

import dagger.Component;

/**
 * Created by cj on 2019-10-23.
 */
@FragmentScope
@Component(dependencies = {AppComponent.class})
public interface FragmentComponent {
}
