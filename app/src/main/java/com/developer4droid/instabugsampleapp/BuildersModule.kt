package com.developer4droid.instabugsampleapp

import com.developer4droid.instabug.ReportBugActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindReportBugActivity(): ReportBugActivity

    // Add bindings for other sub-components here
//    @ContributesAndroidInjector(modules = [LobbyActivityModule::class])
//    internal abstract fun bindLobbyActivity(): LobbyActivity
//
//    @ContributesAndroidInjector(modules = [LobbyFragmentModule::class])
//    internal abstract// or gain access to lobby activity dependencies from fragment via
//    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
//    fun bindLobbyFragment(): LobbyFragment

}