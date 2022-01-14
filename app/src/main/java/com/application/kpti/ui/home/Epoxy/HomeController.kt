package com.application.kpti.ui.home.Epoxy

import android.util.Log
import android.widget.Toast
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel


class HomeController(homeOnItemclickListener: HomeController.homeOnItemclickListener) : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private var _currentResult: HomeProperty? = null
    private var listener = homeOnItemclickListener

    override fun buildModels() {

        headerPPopuler {
            id(0)

        }
        // property populer
        val models = _currentResult!!.property_populer.map {
            ContentPPopulerModel_()
                .id(1)
                .property_name(it.property_name)
                .img_property(it.img_property)
            }

        carousel {
            id("coursel")
            models(models)
        }

        // property terkini
        headerPTekini {
            id(2)
        }

        _currentResult!!.property_terkini.forEach{
            contentPTerkini {
                id(3)
                imgproperty(it.img_property)
                propertyname(it.property_name)
                location(it.location)
                price("Rp."+it.price)
                itemClickListener { model, parentView, clickedView, position ->
                   this@HomeController.listener.OnclickItemPropertypopuler(model.propertyname()!!+model.price())
                }
            }
        }

        headerPSekitar {
            id(4)
        }

        _currentResult!!.property_sekitar.forEach {
            contentPSekitar {
                id(5)
                imgProperty(it.img_property)
                distancePoint(it.distance)
                propertyName(it.property_name)
            }
        }
    }

    fun submit(result: HomeProperty){
        _currentResult = result
        requestModelBuild()
    }


    interface homeOnItemclickListener{
        fun OnclickItemPropertypopuler(nameProperty: String)
        fun OnclickItemPropertyterkini()
        fun OnclickItemPropertysekitar()
    }
}