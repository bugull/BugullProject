package com.bugull.bugullproject.di;

import dagger.Component;

/**
 * Created by cj on 2019-10-23.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComponent {

}
