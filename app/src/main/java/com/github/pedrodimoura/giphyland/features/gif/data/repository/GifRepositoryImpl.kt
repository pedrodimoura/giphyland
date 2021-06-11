package com.github.pedrodimoura.giphyland.features.gif.data.repository

import com.github.pedrodimoura.giphyland.features.gif.data.local.GifLocalDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.local.model.GifLocalModel
import com.github.pedrodimoura.giphyland.features.gif.data.remote.GifRemoteDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.remote.model.GifRemoteModel
import com.github.pedrodimoura.giphyland.features.gif.domain.model.Gif
import com.github.pedrodimoura.giphyland.features.gif.domain.repository.GifRepository
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val gifRemoteDataSource: GifRemoteDataSource,
    private val gifLocalDataSource: GifLocalDataSource,
) : GifRepository {
    override suspend fun fetchTrending(): List<Gif> {
        // Clean this...
        val result = gifLocalDataSource.getAll()

        if (result.isNotEmpty())
            return mapToDomain(result)

        return mapRemoteModelToDomainModel(gifRemoteDataSource.fetchTrending())
    }

    private fun mapRemoteModelToDomainModel(gifRemoteModels: List<GifRemoteModel>) =
        gifRemoteModels.map { gifRemoteModel ->
            Gif(
                type = mapRemoteModelTypeToDomainModelType(gifRemoteModel.type),
                id = gifRemoteModel.id,
                slug = gifRemoteModel.slug,
                url = gifRemoteModel.url,
                bitLyUrl = gifRemoteModel.bitlyUrl,
                embedUrl = gifRemoteModel.embedUrl,
                username = gifRemoteModel.username,
                sourceUrl = gifRemoteModel.sourceUrl,
                source = gifRemoteModel.source,
                rating = mapRemoteModelRatingToDomainModelRating(gifRemoteModel.rating),
                sourceTld = gifRemoteModel.sourceTld,
                updateDateTime = gifRemoteModel.updateDatetime.orEmpty(),
                createDateTime = gifRemoteModel.createDatetime.orEmpty(),
                importDateTime = gifRemoteModel.importDatetime.orEmpty(),
                trendingDateTime = gifRemoteModel.trendingDatetime.orEmpty(),
                title = gifRemoteModel.title,
                imageUrl = gifRemoteModel.images.fixedHeight.url
            )
        }

    private fun mapRemoteModelTypeToDomainModelType(gifRemoteModelType: GifRemoteModel.Type) =
        when (gifRemoteModelType) {
            GifRemoteModel.Type.GIF -> Gif.Type.GIF
        }

    private fun mapRemoteModelRatingToDomainModelRating(gifRemoteModelRating: GifRemoteModel.Rating) =
        when (gifRemoteModelRating) {
            GifRemoteModel.Rating.G -> Gif.Rating.G
            GifRemoteModel.Rating.PG -> Gif.Rating.PG
            GifRemoteModel.Rating.PG13 -> Gif.Rating.PG13
            GifRemoteModel.Rating.R -> Gif.Rating.R
            GifRemoteModel.Rating.Y -> Gif.Rating.Y
        }

    private fun mapToDomain(localGifs: List<GifLocalModel>): List<Gif> {
        return localGifs.map { gifLocalModel -> mapGifLocalModelToGifDomainModel(gifLocalModel) }
    }

    private fun mapGifLocalModelToGifDomainModel(gifLocalModel: GifLocalModel): Gif =
        Gif(
            type = mapLocalModelTypeToDomainModelType(gifLocalModel.type),
            id = gifLocalModel.id,
            slug = gifLocalModel.slug,
            url = gifLocalModel.url,
            bitLyUrl = gifLocalModel.bitLyUrl,
            embedUrl = gifLocalModel.embedUrl,
            username = gifLocalModel.username,
            sourceUrl = gifLocalModel.sourceUrl,
            source = gifLocalModel.source,
            rating = mapLocalModelRatingToDomainModelRating(gifLocalModel.rating),
            sourceTld = gifLocalModel.sourceTld,
            updateDateTime = gifLocalModel.updateDateTime,
            createDateTime = gifLocalModel.createDateTime,
            importDateTime = gifLocalModel.importDateTime,
            trendingDateTime = gifLocalModel.trendingDateTime,
            title = gifLocalModel.title,
            imageUrl = gifLocalModel.imageUrl
        )

    private fun mapLocalModelRatingToDomainModelRating(gifLocalModelRating: GifLocalModel.Rating): Gif.Rating {
        return when (gifLocalModelRating) {
            GifLocalModel.Rating.Y -> Gif.Rating.Y
            GifLocalModel.Rating.G -> Gif.Rating.G
            GifLocalModel.Rating.PG -> Gif.Rating.PG
            GifLocalModel.Rating.PG13 -> Gif.Rating.PG13
            GifLocalModel.Rating.R -> Gif.Rating.R
        }
    }

    private fun mapLocalModelTypeToDomainModelType(gifLocalModelType: GifLocalModel.Type): Gif.Type {
        return when (gifLocalModelType) {
            GifLocalModel.Type.GIF -> Gif.Type.GIF
        }
    }


    private fun mapRemoteModelToLocalModel(gifRemoteModel: GifRemoteModel): GifLocalModel {
        return GifLocalModel(
            type = mapRemoteModelTypeToLocalModelType(gifRemoteModel.type),
            id = gifRemoteModel.id,
            slug = gifRemoteModel.slug,
            url = gifRemoteModel.url,
            bitLyUrl = gifRemoteModel.bitlyUrl,
            embedUrl = gifRemoteModel.embedUrl,
            username = gifRemoteModel.username,
            source = gifRemoteModel.source,
            rating = mapRemoteModelRatingToLocalModelRating(gifRemoteModel.rating),
            sourceTld = gifRemoteModel.sourceTld,
            sourceUrl = gifRemoteModel.sourceUrl,
            updateDateTime = gifRemoteModel.updateDatetime.orEmpty(),
            createDateTime = gifRemoteModel.createDatetime.orEmpty(),
            importDateTime = gifRemoteModel.importDatetime.orEmpty(),
            trendingDateTime = gifRemoteModel.trendingDatetime.orEmpty(),
            title = gifRemoteModel.title,
            imageUrl = gifRemoteModel.images.fixedHeight.url
        )
    }

    private fun mapRemoteModelTypeToLocalModelType(gifRemoteModelType: GifRemoteModel.Type): GifLocalModel.Type {
        return when (gifRemoteModelType) {
            GifRemoteModel.Type.GIF -> GifLocalModel.Type.GIF
        }
    }

    private fun mapRemoteModelRatingToLocalModelRating(
        gifRemoteModelRating: GifRemoteModel.Rating
    ): GifLocalModel.Rating {
        return when (gifRemoteModelRating) {
            GifRemoteModel.Rating.G -> GifLocalModel.Rating.G
            GifRemoteModel.Rating.PG -> GifLocalModel.Rating.PG
            GifRemoteModel.Rating.PG13 -> GifLocalModel.Rating.PG13
            GifRemoteModel.Rating.R -> GifLocalModel.Rating.R
            GifRemoteModel.Rating.Y -> GifLocalModel.Rating.Y
        }
    }
}