/**
 * https://medium.com/@fabioCollini/android-testing-using-dagger-2-mockito-and-a-custom-junit-rule-c8487ed01b56
 */

package s.yarlykov.daggerjunitmock.service

import javax.inject.Inject

class MainService @Inject constructor(
    val restService: RestService,
    val printService: PrintService) {

}


