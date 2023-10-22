package com.src.mvvmbtk.di


import com.src.mvvmbtk.data.repository.album.AlbumsDataSource
import com.src.mvvmbtk.data.repository.album.AlbumsRemoteDataSource
import com.src.mvvmbtk.data.repository.user.UserDataSource
import com.src.mvvmbtk.data.repository.comment.CommentDataSource
import com.src.mvvmbtk.data.repository.comment.CommentRemoteDataSource
import com.src.mvvmbtk.data.repository.products.ProductsDataSource
import com.src.mvvmbtk.data.repository.products.ProductsRemoteDataSource
import com.src.mvvmbtk.data.repository.user.UserRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindUserDataSource(
        dataSource: UserRemoteDataSource
    ): UserDataSource

    @Binds
    @Singleton
    abstract fun bindCommentDataSource(
        dataSource: CommentRemoteDataSource
    ): CommentDataSource


    @Binds
    @Singleton
    abstract fun bindAlbumsDataSource(
        dataSource: AlbumsRemoteDataSource
    ): AlbumsDataSource


    @Binds
    @Singleton
    abstract fun bindProductsDataSource(
        dataSource: ProductsRemoteDataSource
    ): ProductsDataSource


}