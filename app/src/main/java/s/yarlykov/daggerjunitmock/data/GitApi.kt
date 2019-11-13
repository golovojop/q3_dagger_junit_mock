package s.yarlykov.daggerjunitmock.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import s.yarlykov.daggerjunitmock.domain.UserGit

interface GitApi {
    @GET("users")
    fun getUsers() : Single<Response<List<UserGit>>>
}