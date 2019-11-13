package s.yarlykov.daggerjunitmock.data

import io.reactivex.Single
import s.yarlykov.daggerjunitmock.domain.User
import s.yarlykov.daggerjunitmock.domain.UserGit
import s.yarlykov.daggerjunitmock.logIt

class GitHelper(private val gitApi: GitApi) {

    fun getUsers(): Single<List<User>> =
        gitApi.getUsers()
            .map { okHttpResponse ->
                logIt("GitHelper::getUsers okHttpResponse.code = ${okHttpResponse.code()}")
                if (!okHttpResponse.isSuccessful) {
                    throw Throwable("Can't receive Users list")
                }
                okHttpResponse.body()!!
            }
            .map {gitUsers ->
                gitUsers.map {
                    UserGit.toUser(it)
                }
            }
}