package com.developer4droid.instabug

import dagger.Binds
import dagger.Module

@Module internal interface InstabugModuleInternal {

    @Binds fun bindChessInstabug(impl: ChessInstabugImpl): ChessInstabug
}